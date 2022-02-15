package edu.escuelaing.arep.server;

import edu.escuelaing.arep.handler.Handler;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static edu.escuelaing.arep.utils.Constants.TYPES;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 2/9/2022
 * @project App
 */
public class HttpServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public final static Map<String, String> typesMap = new HashMap<String, String>();

    public HttpServer() {
        setTypes();
    }

    private void setTypes() {
        for (String[] type : TYPES) {
            typesMap.put(type[0], type[1]);
        }
    }

    public void startServer() throws IOException, URISyntaxException {
        int port = 35000;
        serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.err.printf("Could not listen on port: %d.%n", port);
            System.exit(1);
        }
        clientSocket = null;

        System.out.println("Listo para recibir ...");
        clientSocket = serverSocket.accept();

        serverConnection(clientSocket);
        closeConnection();
    }

    public void serverConnection(Socket clientSocket) throws IOException, URISyntaxException {
        this.clientSocket = clientSocket;
        serverConnection();
    }

    public void serverConnection() throws IOException, URISyntaxException {
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String inputLine, outputLine;
        ArrayList<String> request = new ArrayList<>();

        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);
            request.add(inputLine);
            if (!in.ready()) {
                break;
            }
        }
        outputLine = Handler.get(request);
        out.println(outputLine);
    }

    public void closeConnection() throws IOException {
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}

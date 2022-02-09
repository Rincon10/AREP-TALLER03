package edu.escuelaing.arep.server;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

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
    private final static Map<String, String> typesMap = new HashMap<String, String>();
    private final static String[][] types = {{"html", "text/html"}, {"js", "text/javascript"}, {"jpeg", "image/jpeg"}, {"jpg", "image/jpg"}};

    private void setTypes() {
        for (String[] type : types) {
            typesMap.put(type[0], type[1]);
        }
    }

    public void startServer() throws IOException {
        serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        clientSocket = null;

        System.out.println("Listo para recibir ...");
        clientSocket = serverSocket.accept();

        serverConnection(clientSocket);
        closeConnection();


    }

    public void serverConnection(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        serverConnection();
    }

    public void serverConnection() throws IOException {
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String inputLine, outputLine;

        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);
            if (!in.ready()) {
                break;
            }
        }
        outputLine = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>Title of the document</title>\n"
                + "</head>"
                + "<body>"
                + "My Web Site HOLIUIIIIIIII"
                + "</body>"
                + "</html>";
        System.out.println(outputLine);
        out.println(outputLine);
    }

    public void closeConnection() throws IOException {
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }

    public static void main(String[] args) {

    }

}

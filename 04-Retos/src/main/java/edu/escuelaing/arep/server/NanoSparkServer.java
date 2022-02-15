package edu.escuelaing.arep.server;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 2/9/2022
 * @project App
 */
public class NanoSparkServer {
    private static NanoSparkServer _instance;
    private HttpServer httpServer = new HttpServer();

    public static NanoSparkServer getInstance() {
        if (_instance == null) _instance = new NanoSparkServer();
        return _instance;
    }

    public void start() {
        try {
            httpServer.startServer();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NanoSparkServer nanoSparkServer = getInstance();
        nanoSparkServer.start();
    }

}

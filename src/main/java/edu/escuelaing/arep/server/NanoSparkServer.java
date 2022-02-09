package edu.escuelaing.arep.server;


import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 2/9/2022
 * @project App
 */
public class NanoSparkServer {
    private static NanoSparkServer _instance;
    private HttpServer httpServer = new HttpServer();
    private Map<String, BiFunction<HttpRequest, HttpResponse, String>> actions = new HashMap<>();

    public static NanoSparkServer getInstance(){
        if(_instance == null) _instance = new NanoSparkServer();
        return _instance;
    }

    public void get(String path, BiFunction<HttpRequest, HttpResponse, String> biFunction){
        actions.put(path, biFunction);
    }
}

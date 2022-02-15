package edu.escuelaing.arep.handler;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static edu.escuelaing.arep.server.HttpServer.typesMap;
import static edu.escuelaing.arep.utils.Constants.PUBLIC;
import static edu.escuelaing.arep.utils.Constants.RESOURCES_PATH;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 2/15/2022
 * @project App
 */
public class Handler {
    private File file;

    public Handler() {
    }

    private static String getDefaultResponse() {
        String outputLine = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + " <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                + "<meta charset=\"UTF-8\">"
                + "<title>Title of the document</title>\n"
                + "</head>"
                + "<body>"
                + "SIUUUUUUUUUUUUUUU  IS WORKING!!!"
                + "</body>"
                + "</html>";
        return outputLine;
    }

    private static String getNotFoundHttpMessage(String message) {
        String outputLine = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + " <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                + "<meta charset=\"UTF-8\">"
                + "<title>404 Error - Page Not Found</title>\"\n"
                + "</head>"
                + "<body>"
                + "<div>"
                + "<h1>Page Not Found</h1>"
                + "<p>" + message + " </p>"
                + "</div>"
                + "</body>"
                + "</html>";
        return outputLine;
    }

    private static String computeImage(URI resourceURI) {
        return "";
    }

    private static String computeContentResponse(URI resourceURI) {
        String responseContent;

        //css, js, jpg, etc..
        String extensionUri = resourceURI.toString().substring(resourceURI.getPath().lastIndexOf(".") + 1);
        if (extensionUri.equals("png")) return computeImage(resourceURI);// compute an image

        responseContent = "HTTP/1.1 200 OK \r\n"
                + "Content-Type: " + typesMap.get(extensionUri) + "\r\n"
                + "\r\n";
        File file = new File(RESOURCES_PATH + resourceURI.getPath());
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            //return the content of the file
            while ((line = br.readLine()) != null) responseContent += line;
        } catch (FileNotFoundException e) {
            return getNotFoundHttpMessage(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseContent;
    }

    public static String get(ArrayList<String> request) throws URISyntaxException {
        String uriContentType;

        // In reques.get(0) we hace all the information of the petition
        // Example: 0= "GET /public/css/index.css HTPP/1.1"
        uriContentType = request.get(0).split(" ")[1];
        URI resourceURI = new URI(uriContentType);
        if (resourceURI.getPath().startsWith(PUBLIC)) {
            return computeContentResponse(resourceURI);
        }

        return getDefaultResponse();
    }


}
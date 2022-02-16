package edu.escuelaing.arep;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 2/15/2022
 * @project WebApp
 */
public class URLReader {
    private URL siteURL;
    private URLConnection urlConnection;
    private String htmlResponse;
    private static String defaultSite = "http://www.google.com/";

    public URLReader(String url) {
        try {
            siteURL = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void openConnection() throws IOException {
        // Crea el objeto que URLConnection
        urlConnection = siteURL.openConnection();
    }

    public void createHtmlPage() throws IOException {
        String htmlResponse="";
        openConnection();
        showHeadersFromPage();

        //response
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(siteURL.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
                htmlResponse+=inputLine;
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter("resultado.html"));
            writer.write(htmlResponse);
            writer.close();
        } catch (IOException x) {
            System.err.println(x);
        }

    }

    public void showHeadersFromPage() {
        // Obtiene los campos del encabezado y los almacena en un estructura Map
        Map<String, List<String>> headers = urlConnection.getHeaderFields();
        // Obtiene una vista del mapa como conjunto de pares <K,V>
        // para poder navegarlo
        Set<Map.Entry<String, List<String>>> entrySet = headers.entrySet();
        // Recorre la lista de campos e imprime los valores
        for (Map.Entry<String, List<String>> entry : entrySet) {
            String headerName = entry.getKey();
            //Si el nombre es nulo, significa que es la linea de estado
            if (headerName != null) {
                System.out.print(headerName + ": ---> Header\n");
            }
            List<String> headerValues = entry.getValue();
            for (String value : headerValues) {
                System.out.print(value);
            }
            System.out.println("");
            System.out.println("");
        }
    }

    public static void main(String[] args) throws IOException {
        String url = "";
        if (args == null || args.length != 1) url = defaultSite;
        else url = args[0];

        URLReader urlReader = new URLReader(url);
        urlReader.createHtmlPage();
    }
}

package edu.escuelaing.client;

import edu.escuelaing.server.EchoServer;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 2/9/2022
 * @project AREP-TALLER03
 */
public class EchoClient {

    public void ejecutaServicio(String ipRmiregistry, int puertoRmiregistry, String nombreServicio) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        Registry registry = null;
        try {
            registry = LocateRegistry.getRegistry(ipRmiregistry, puertoRmiregistry);
            EchoServer echoServer = (EchoServer) registry.lookup(nombreServicio);
            System.out.println(echoServer.echo("Hola como estas?"));
        } catch (Exception e) {
            System.out.println("Hay un problema");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        EchoClient ec = new EchoClient();
        ec.ejecutaServicio("127.0.0.1", 23000, "echoServer");
    }
}

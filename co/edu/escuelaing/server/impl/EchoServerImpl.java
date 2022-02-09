package edu.escuelaing.server.impl;

import edu.escuelaing.server.EchoServer;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 2/9/2022
 * @project AREP-TALLER03
 */
public class EchoServerImpl implements EchoServer {


    public EchoServerImpl(String ipRMIregistry, int puertoRMIregistry, String nombreDePublicacion) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            //Crea el skeleton
            EchoServer echoServer = (EchoServer) UnicastRemoteObject.exportObject(this, 0);

            //Establezco el Registry
            Registry registry = LocateRegistry.getRegistry(ipRMIregistry, puertoRMIregistry);

            // Publico mi objeto en el registry (llave, valor)
            registry.bind(nombreDePublicacion, echoServer);
            System.out.println("Echo server ready...");
        } catch (Exception e) {
            System.out.println("Echo server exception");
            e.printStackTrace();
        }
    }

    @Override
    public String echo(String cadena) throws RemoteException {
        return "desde el servidor: " + cadena;
    }

    public static void main(String[] args) {
        EchoServerImpl ec = new EchoServerImpl("127.0.0.1", 23000, "echoServer");
    }
}

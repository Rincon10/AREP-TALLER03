package edu.escuelaing.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 2/9/2022
 * @project AREP-TALLER03
 */
public interface EchoServer extends Remote {
    public String echo(String cadena) throws RemoteException;
}

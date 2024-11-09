package rmi.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloChat extends Remote {
    String message(String name) throws RemoteException;
    String objMessage(Message msg) throws RemoteException;
}

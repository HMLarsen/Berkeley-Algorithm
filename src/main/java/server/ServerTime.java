package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalTime;

/**
 * Interface para que o client-side acesse o servidor.
 */
public interface ServerTime extends Remote {

	/**
	 * @return a hora local
	 */
	LocalTime getLocalTime() throws RemoteException;

	/**
	 * Ajusta a hora local baseada na hora do servidor com a média de horas.
	 * 
	 * @param localTime hora local do servidor
	 * @param avgDiff   média de horas
	 */
	void adjustTime(LocalTime localTime, long avgDiff) throws RemoteException;
}
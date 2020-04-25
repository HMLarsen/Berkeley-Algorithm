package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalTime;

import common.AppConstants;

/**
 * Implementação de {@link ServerTime}.
 */
@SuppressWarnings("serial")
public class ServerTimeImpl extends UnicastRemoteObject implements ServerTime {

	private LocalTime localTime;

	public ServerTimeImpl(LocalTime localTime) throws RemoteException {
		this.localTime = localTime;
	}

	@Override
	public LocalTime getLocalTime() throws RemoteException {
		return localTime;
	}

	@Override
	public void adjustTime(LocalTime localTime, long avgDiff) throws RemoteException {
		long localTimeNanos = localTime.toNanoOfDay();
		long thisNanos = getLocalTime().toNanoOfDay();
		var newNanos = thisNanos - localTimeNanos;
		newNanos = newNanos * -1 + avgDiff + thisNanos;
		LocalTime newLocalTime = LocalTime.ofNanoOfDay(newNanos);
		this.localTime = newLocalTime;
		System.out.println("Horário atualizado: " + AppConstants.formatter.format(newLocalTime));
	}

}
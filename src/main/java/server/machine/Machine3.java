package server.machine;

import static common.AppConstants.formatter;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalTime;

import common.AppConstants;
import server.ServerTime;
import server.ServerTimeImpl;

/**
 * Representação da máquina 3 para ter sua hora ajustada.
 */
public class Machine3 {

	public static void main(String[] args) {
		try {
			LocalTime hour = LocalTime.parse(AppConstants.MACHINE_3_HOUR, formatter);
			ServerTime machineServer = new ServerTimeImpl(hour);
			Registry registry = LocateRegistry.createRegistry(AppConstants.SERVER_PORT_3);
			registry.rebind(ServerTimeImpl.class.getSimpleName(), machineServer);
			System.out.println(String.format("Máquina 3 iniciada na porta %s [hora local: %s].",
					AppConstants.SERVER_PORT_3,
					AppConstants.formatter.format(hour)));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}

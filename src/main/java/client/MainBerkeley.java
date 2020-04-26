package client;

import static common.AppConstants.formatter;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalTime;

import common.AppConstants;
import server.ServerTime;
import server.ServerTimeImpl;

/**
 * Client-side da aplicação.
 */
public class MainBerkeley {

	public static void main(String[] args) {
		try {
			LocalTime localTime = LocalTime.parse(AppConstants.LOCAL_HOUR, formatter);
			System.out.println("Horário local: " + formatter.format(localTime));

			// criação dos servidores (máquinas)
			ServerTime machine1Server = createMachineServer(1);
			ServerTime machine2Server = createMachineServer(2);
			ServerTime machine3Server = createMachineServer(3);

			// calcular a média das horas
			var avgDiff = generateAverageTime(localTime,
					machine1Server.getLocalTime(),
					machine2Server.getLocalTime(),
					machine3Server.getLocalTime());

			// ajustar o tempo dos servidores
			machine1Server.adjustTime(localTime, avgDiff);
			machine2Server.adjustTime(localTime, avgDiff);
			machine3Server.adjustTime(localTime, avgDiff);
			localTime = localTime.plusNanos(avgDiff);

			System.out.println("\nHorários atualizados!");
			System.out.println("Horário local: " + formatter.format(localTime));
			System.out.println("Horário servidor 1: " + formatter.format(machine1Server.getLocalTime()));
			System.out.println("Horário servidor 2: " + formatter.format(machine2Server.getLocalTime()));
			System.out.println("Horário servidor 3: " + formatter.format(machine3Server.getLocalTime()));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	/**
	 * Cria um {@link ServerTime} que está associado a uma máquina para ter sua hora
	 * ajustada.
	 * 
	 * @param machineNumber número da máquina
	 * @return servidor da máquina com sua hora
	 * @throws Exception ao tentar criar o servidor ou registro
	 */
	private static ServerTime createMachineServer(int machineNumber) throws Exception {
		String serverName = AppConstants.SERVER_NAME;
		int serverPort = switch (machineNumber) {
			case 1 -> AppConstants.SERVER_PORT_1;
			case 2 -> AppConstants.SERVER_PORT_2;
			case 3 -> AppConstants.SERVER_PORT_3;
			default -> -1;
		};
		Registry machineRegistry = LocateRegistry.getRegistry(serverName, serverPort);
		ServerTime machineServerTime = (ServerTime) machineRegistry.lookup(ServerTimeImpl.class.getSimpleName());
		LocalTime machineTime = machineServerTime.getLocalTime();
		System.out.println("Conexão com a máquina " + machineNumber + " estabelecida com sucesso. Hora: "
				+ formatter.format(machineTime));
		return machineServerTime;
	}

	/**
	 * Calcula a média da hora que deve ser ajustada.<br>
	 * Hora somada das máquinas (cada uma subtraída pela hora local) dividida pelo
	 * total de máquinas.
	 * 
	 * @param localTime hora local
	 * @param times     hora das máquinas
	 * @return hora média calculada
	 */
	private static long generateAverageTime(LocalTime localTime, LocalTime... times) {
		long nanoLocal = localTime.toNanoOfDay();
		long difServer = 0;
		for (LocalTime t : times) {
			difServer += t.toNanoOfDay() - nanoLocal;
		}
		return difServer / times.length;
	}

}
package common;

import java.time.format.DateTimeFormatter;

public interface AppConstants {

	// utilitários
	public final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	// configuração do servidor das máquinas
	public final String SERVER_NAME = "localhost";
	public final int SERVER_PORT_1 = 1500;
	public final int SERVER_PORT_2 = 1501;
	public final int SERVER_PORT_3 = 1502;

	// horários
	public final String LOCAL_HOUR = "07:00:00";
	public final String MACHINE_1_HOUR = "10:05:00";
	public final String MACHINE_2_HOUR = "17:27:00";
	public final String MACHINE_3_HOUR = "23:15:00";

}

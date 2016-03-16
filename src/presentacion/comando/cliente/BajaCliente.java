package presentacion.comando.cliente;

import java.sql.SQLException;

import negocio.serviciosAplicacion.FactorySA;
import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.comandoFactory.CommandResponse;

public class BajaCliente implements Comando {
	
	public CommandResponse ejecutar(Object datos) {

		CommandResponse cr = new CommandResponse();
		try {

			cr.setDatos(FactorySA.getInstance().getSACliente().bajaCliente((Integer) datos));
			cr.setEvento(IDEventos.EVENTO_BAJA_CLIENTE);
			
		} catch (SQLException excep) {

			cr.setDatos(excep);
			cr.setEvento(IDEventos.ERROR_EVENTO_BAJA_CLIENTE);
		} 

		return cr;
	}
		
}

package presentacion.comando.cliente;

import java.sql.SQLException;

import negocio.serviciosAplicacion.FactorySA;
import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.comandoFactory.CommandResponse;

public class ConsultaCliente implements Comando {
	
	public CommandResponse ejecutar(Object datos) {

		CommandResponse cr = new CommandResponse();
		try {

			cr.setDatos(FactorySA.getInstance().getSACliente().consultaCliente((Integer) datos));
			cr.setEvento(IDEventos.EVENTO_CONSULTA_CLIENTE);
			
		} catch (SQLException excep) {

			cr.setDatos(excep);
			cr.setEvento(IDEventos.ERROR_CONSULTA_CLIENTE);
		} 

		return cr;
	}
		
}

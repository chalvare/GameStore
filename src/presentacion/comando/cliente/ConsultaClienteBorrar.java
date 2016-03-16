package presentacion.comando.cliente;

import java.sql.SQLException;

import negocio.serviciosAplicacion.FactorySA;
import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.comandoFactory.CommandResponse;

public class ConsultaClienteBorrar implements Comando {
	
	public CommandResponse ejecutar(Object datos) {

		CommandResponse cr = new CommandResponse();
		try {

			cr.setDatos(FactorySA.getInstance().getSACliente().consultaCliente((Integer) datos));
			cr.setEvento(IDEventos.EVENTO_CONSULTAR_CLIENTE_BORRAR);
			
		} catch (SQLException excep) {

			cr.setDatos(excep);
			cr.setEvento(IDEventos.ERROR_CONSULTAR_CLIENTE_BORRAR);
		} 

		return cr;
	}
		
}

package presentacion.comando.cliente;

import java.sql.SQLException;

import negocio.serviciosAplicacion.FactorySA;
import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.comandoFactory.CommandResponse;

public class ConsultaTotalCliente implements Comando {
	
	public CommandResponse ejecutar(Object datos) {

		CommandResponse cr = new CommandResponse();
		try {

			cr.setDatos(FactorySA.getInstance().getSACliente().consultaClientes());
			cr.setEvento(IDEventos.EVENTO_CONSULTA_TODOS_CLIENTES);
			
		} catch (SQLException excep) {

			cr.setDatos(excep);
			cr.setEvento(IDEventos.ERROR_EVENTO_CONSULTA_TODOS_CLIENTES);
		} 

		return cr;
	}

}

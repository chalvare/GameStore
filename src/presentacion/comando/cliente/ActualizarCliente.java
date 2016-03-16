package presentacion.comando.cliente;

import java.sql.SQLException;

import negocio.cliente.TransferCliente;
import negocio.serviciosAplicacion.FactorySA;
import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.comandoFactory.CommandResponse;

public class ActualizarCliente implements Comando{

	public CommandResponse ejecutar(Object datos) {

		CommandResponse cr = new CommandResponse();
		try {

			cr.setDatos(FactorySA.getInstance().getSACliente().actualizarCliente((TransferCliente) datos));
			cr.setEvento(IDEventos.EVENTO_MODIFICAR_CLIENTE);

		} catch (SQLException excep) {

			cr.setDatos(excep);
			cr.setEvento(IDEventos.ERROR_MODIFICAR_CLIENTE);
		} 

		return cr;
	}
}

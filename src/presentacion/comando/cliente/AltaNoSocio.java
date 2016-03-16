package presentacion.comando.cliente;

import java.sql.SQLException;
import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.comandoFactory.CommandResponse;
import negocio.cliente.TransferCliente;
import negocio.serviciosAplicacion.FactorySA;

public class AltaNoSocio implements Comando{
	
	public CommandResponse ejecutar(Object datos) {

		CommandResponse cr = new CommandResponse();
		try {

			cr.setDatos(FactorySA.getInstance().getSACliente().altaCliente((TransferCliente) datos));
			cr.setEvento(IDEventos.EVENTO_ALTA_NO_SOCIO);

		} catch (SQLException excep) {

			cr.setDatos(excep);
			cr.setEvento(IDEventos.ERROR_EVENTO_ALTA_NO_SOCIO);
		}

		return cr;
	}
	

}

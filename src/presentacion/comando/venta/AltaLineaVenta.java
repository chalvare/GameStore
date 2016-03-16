package presentacion.comando.venta;

import java.sql.SQLException;

import negocio.lineaVenta.TransferLineaVenta;
import negocio.serviciosAplicacion.FactorySA;
import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.comandoFactory.CommandResponse;

public class AltaLineaVenta implements Comando{
	
	public CommandResponse ejecutar(Object datos) {
		CommandResponse cr = new CommandResponse();
		try {

			cr.setDatos(FactorySA.getInstance().getSALineaVenta().altaLineaVenta((TransferLineaVenta) datos));
			cr.setEvento(IDEventos.EVENTO_ALTA_LINEA_VENTA);

		} catch (SQLException excep) {

			cr.setDatos(excep);
			cr.setEvento(IDEventos.ERROR_EVENTO_ALTA_LINEA_VENTA);
		} 

		return cr;

	}

}

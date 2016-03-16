package presentacion.comando.venta;

import java.sql.SQLException;

import negocio.serviciosAplicacion.FactorySA;
import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.comandoFactory.CommandResponse;

public class ConsultaVentaVender implements Comando{

	public CommandResponse ejecutar(Object datos) {
		CommandResponse cr = new CommandResponse();
		try {

			cr.setDatos(FactorySA.getInstance().getSAVenta().consultaVenta((Integer)datos));
			cr.setEvento(IDEventos.EVENTO_CONSULTA_VENTA_VENDER);

		} catch (SQLException excep) {

			cr.setDatos(excep);
			cr.setEvento(IDEventos.ERROR_EVENTO_CONSULTA_VENTA_VENDER);
		} 

		return cr;

	}
}

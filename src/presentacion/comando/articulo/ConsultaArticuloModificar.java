package presentacion.comando.articulo;

import java.sql.SQLException;

import negocio.serviciosAplicacion.FactorySA;
import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.comandoFactory.CommandResponse;

public class ConsultaArticuloModificar implements Comando{
	
	public CommandResponse ejecutar(Object datos) {

		CommandResponse cr = new CommandResponse();
		try {

			cr.setDatos(FactorySA.getInstance().getSAArticulo().consultaArticulo((Integer)datos));
			cr.setEvento(IDEventos.EVENTO_CONSULTAR_ARTICULO_MODIFICAR);

		} catch (SQLException excep) {

			cr.setDatos(excep);
			cr.setEvento(IDEventos.ERROR_EVENTO_CONSULTAR_ARTICULO_MODIFICAR);
		} 

		return cr;
	}

}

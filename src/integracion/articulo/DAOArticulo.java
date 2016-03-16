package integracion.articulo;

import java.sql.SQLException;
import java.util.ArrayList;

import negocio.articulo.TransferArticulo;

public interface DAOArticulo {//Integra Create, Read y Update del modelo CRUD.
	public boolean altaArticulo(TransferArticulo t) throws SQLException;
	public boolean actualizarArticulo(TransferArticulo t) throws SQLException;
	public TransferArticulo consultaArticulo(int IDArticulo) throws SQLException;
	public ArrayList<TransferArticulo> consultaArticulos() throws SQLException;
}

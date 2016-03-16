package negocio.articulo;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SAArticulo {
	public boolean altaArticulo(TransferArticulo t) throws SQLException;
	public boolean actualizarArticulo(TransferArticulo t) throws SQLException;
	public TransferArticulo consultaArticulo(int IDArticulo) throws SQLException;
	public ArrayList<TransferArticulo> consultaArticulos() throws SQLException;
}

package negocio.lineaVenta;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SALineaVenta {
	public boolean altaLineaVenta(TransferLineaVenta t) throws SQLException;
	public ArrayList<TransferLineaVenta> consultaLineaVentasPorVenta(int IDVenta) throws SQLException;
	public ArrayList<TransferLineaVenta> consultaLineaVentasPorArticulo(int IDArticulo) throws SQLException;
	//public boolean actualizarLineaVenta(int IDVenta, int IDArticulo, int cantidad) throws SQLException;
	public boolean devolucion(TransferLineaVenta t) throws SQLException;
}

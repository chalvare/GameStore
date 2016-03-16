package negocio.venta;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SAVenta {
	public boolean altaVenta(TransferVenta t) throws SQLException;
	public TransferVenta consultaVenta(int IDVenta) throws SQLException;
	public ArrayList<TransferVenta> consultaVentas() throws SQLException;
	public float balance() throws SQLException;
}

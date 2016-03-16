package integracion.venta;

import java.sql.SQLException;
import java.util.ArrayList;

import negocio.venta.TransferVenta;

public interface DAOVenta{
	public boolean altaVenta(TransferVenta t) throws SQLException;
	public TransferVenta consultaVenta(int IDVenta) throws SQLException;
	public ArrayList<TransferVenta> consultaVentas() throws SQLException;
	public float balance() throws SQLException;
	public boolean actualizarCosteVenta(int IDVenta) throws SQLException;
}

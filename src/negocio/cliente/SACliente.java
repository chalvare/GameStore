package negocio.cliente;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SACliente{
	public boolean altaCliente(TransferCliente t) throws SQLException;
	public boolean actualizarCliente(TransferCliente t) throws SQLException;
	public TransferCliente consultaCliente(int IDCliente) throws SQLException;
	public ArrayList<TransferCliente> consultaClientes() throws SQLException;
	public boolean bajaCliente(int IDCliente) throws SQLException;
}

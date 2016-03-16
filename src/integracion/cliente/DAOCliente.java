package integracion.cliente;

import java.sql.SQLException;
import java.util.ArrayList;

import negocio.cliente.TransferCliente;

public interface DAOCliente {
	public boolean altaSocio(TransferCliente t) throws SQLException;
	public boolean altaCliente(TransferCliente t) throws SQLException;
	public boolean actualizarCliente(TransferCliente t) throws SQLException;
	public boolean actualizarSocio(TransferCliente t) throws SQLException;
	public TransferCliente consultaCliente(int IDCliente) throws SQLException;
	public ArrayList<TransferCliente> consultaClientes() throws SQLException;
	public boolean bajaCliente(int IDCliente) throws SQLException;
}

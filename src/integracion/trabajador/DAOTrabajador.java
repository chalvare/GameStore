package integracion.trabajador;

import java.sql.SQLException;
import java.util.ArrayList;

import negocio.trabajador.TransferTrabajador;

public interface DAOTrabajador {
	public boolean altaTrabajador(TransferTrabajador t) throws SQLException;
	public boolean actualizarTrabajador(TransferTrabajador t) throws SQLException;
	public TransferTrabajador consultaTrabajador(int IDTrabajador) throws SQLException;
	public ArrayList<TransferTrabajador> consultaTrabajadores() throws SQLException;
	public ArrayList<TransferTrabajador> consultaTrabajadoresPorDepartamento(int IDDepartamento) throws SQLException;
	public boolean bajaTrabajador(int IDTrabajador) throws SQLException;
}

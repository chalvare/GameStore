package integracion.departamento;

import java.sql.SQLException;
import java.util.ArrayList;

import negocio.departamento.TransferDepartamento;

public interface DAODepartamento {
	public boolean altaDepartamento(TransferDepartamento t) throws SQLException;
	public boolean actualizarDepartamento(TransferDepartamento t) throws SQLException;
	public TransferDepartamento consultaDepartamento(int IDDepartamento) throws SQLException;
	public ArrayList<TransferDepartamento> consultaDepartamentos() throws SQLException;
	public boolean bajaDepartamento(int IDDepartamento) throws SQLException;
}

package integracion.departamento;

import integracion.transacciones.conexion.ExcepcionSQL;
import integracion.transacciones.conexion.JdbcUtils;
import integracion.transacciones.transactions.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import integracion.transacciones.transactionManager.TransactionManager;
import negocio.departamento.TransferDepartamento;

public class DAODepartamentoImp implements DAODepartamento
{
	private final String queryAlta = "INSERT INTO `gamestore`.`Departamento` (`Nombre`) VALUES(?)";
	private final String queryActualizar = "UPDATE `gamestore`.`Departamento` SET `Nombre` = ? WHERE `ID_Departamento` = ?";
	private final String queryConsultar1 = "SELECT * FROM `gamestore`.`Departamento` WHERE `ID_Departamento` = ? FOR UPDATE";
	private final String queryConsultarN = "SELECT * FROM `gamestore`.`Departamento` FOR UPDATE";
	private final String queryBaja = "DELETE FROM `gamestore`.`Departamento` WHERE `ID_Departamento` = ?";

	@Override
	public boolean altaDepartamento(TransferDepartamento t) throws SQLException
	{
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		
		boolean resultado = false;
		
		try {
			PreparedStatement alta = c.prepareStatement(queryAlta);
			alta.setString(1, t.getNombre());;
			
			int rs = alta.executeUpdate();
			
			if(rs==1)
				resultado=true;
			else
				throw new SQLException();
			
		} catch (ExcepcionSQL e)
		{
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al dar de alta el departamento");
		}
		
		return resultado;
	}

	@Override
	public boolean actualizarDepartamento(TransferDepartamento t) throws SQLException
	{
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		boolean resultado = false;
		try {
			PreparedStatement actualizar = c.prepareStatement(queryActualizar);
			
			actualizar.setString(1, t.getNombre());
			actualizar.setInt(2, t.getID());
			
			int rs = actualizar.executeUpdate();
			
			if(rs==1)
				resultado=true;
			else
				throw new SQLException();
			
			
		}catch (ExcepcionSQL e) {
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al actualizar el departamento");
		}
		
		return resultado;
	}

	@Override
	public TransferDepartamento consultaDepartamento(int IDDepartamento) throws SQLException
	{
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		
		TransferDepartamento res = null;
		
		try {
			PreparedStatement consulta = c.prepareStatement(queryConsultar1);
			consulta.setInt(1,IDDepartamento);
			ResultSet rs = consulta.executeQuery();
			
			while(rs.next()){
				res = new TransferDepartamento();
				res.setID(rs.getInt("ID_Departamento"));
				res.setNombre(rs.getString("Nombre"));
			}	
		} catch (ExcepcionSQL e) {
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al consultar el departamento");
		}
		
		return res;
	}

	@Override
	public ArrayList<TransferDepartamento> consultaDepartamentos() throws SQLException
	{
		ArrayList<TransferDepartamento>  res = new ArrayList<TransferDepartamento>();
		TransferDepartamento t;
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		
		try {
			PreparedStatement consulta = c.prepareStatement(queryConsultarN);
			ResultSet rs = consulta.executeQuery();
			
			while(rs.next())
			{
				t=new TransferDepartamento();//Necesario porque si no añade x veces el mismo objeto, debido a que todos tienen la misma referencia.
				t.setID(rs.getInt("ID_Departamento"));
				t.setNombre(rs.getString("Nombre"));
				res.add(t);
			}
		} catch (ExcepcionSQL e) {
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al consultar los departamentos");
		}
		
		return res;
	}

	@Override
	public boolean bajaDepartamento(int IDDepartamento) throws SQLException
	{
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		boolean resultado = false;
		try {
			PreparedStatement borrar = c.prepareStatement(queryBaja);
			
			borrar.setInt(1,IDDepartamento);
			
			int rs = borrar.executeUpdate();
			
			if(rs==1)
				resultado=true;
			else
				throw new SQLException();
			
			
		}catch (ExcepcionSQL e) {
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al borrar el departamento");
		}
		
		return resultado;
	}

}

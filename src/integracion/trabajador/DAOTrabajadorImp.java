package integracion.trabajador;

import integracion.transacciones.conexion.ExcepcionSQL;
import integracion.transacciones.conexion.JdbcUtils;
import integracion.transacciones.transactions.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import integracion.transacciones.transactionManager.TransactionManager;
import negocio.trabajador.TransferTrabajador;

public class DAOTrabajadorImp implements DAOTrabajador
{
	private final String queryAlta = "INSERT INTO `gamestore`.`Trabajador` (`ID_Departamento`,`DNI`,`Nombre`,`Apellidos`,`Tipo`,`Fec_Inicio`,`Fec_Fin`,`Sueldo_Base`,`Factor_Productividad`,`Sueldo_Horas`,`Horas`) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private final String queryActualizar = "UPDATE `gamestore`.`Trabajador` SET `ID_Departamento` = ?,`DNI` = ?,`Nombre` = ?,`Apellidos` = ?,`Tipo` = ?, `Fec_Inicio` = ?, `Fec_Fin` = ?, `Sueldo_Base` = ?, `Factor_Productividad` = ?, `Sueldo_Horas` = ?, `Horas` = ? WHERE `ID_Trabajador` = ?";
	private final String queryConsultar1 = "SELECT * FROM `gamestore`.`Trabajador` WHERE `ID_Trabajador` = ? FOR UPDATE";
	private final String queryConsultarN = "SELECT * FROM `gamestore`.`Trabajador` FOR UPDATE";
	private final String queryConsultarPorDepartamento = "SELECT * FROM `gamestore`.`Trabajador` WHERE `Trabajador`.`ID_Departamento` = ? FOR UPDATE";
	private final String queryBaja = "DELETE FROM `gamestore`.`Trabajador` WHERE `ID_Trabajador` = ?";
	
	@Override
	public boolean altaTrabajador(TransferTrabajador t) throws SQLException
	{
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		
		boolean resultado = false;
		
		try {
			PreparedStatement alta = c.prepareStatement(queryAlta);
			alta.setInt(1, t.getIDDepartamento());
			alta.setString(2, t.getDNI());
			alta.setString(3, t.getNombre());
			alta.setString(4, t.getApellidos());
			alta.setBoolean(5, t.getTipo());
			alta.setDate(6, t.getFecIni());
			alta.setDate(7, t.getFecFin());
			alta.setFloat(8,t.getSueldoBase());
			alta.setFloat(9,t.getFactProd());
			alta.setFloat(10,t.getSueldoHoras());
			alta.setInt(11, t.getHoras());
			
			int rs = alta.executeUpdate();
			
			if(rs==1)
				resultado=true;
			else
				throw new SQLException();
			
		} catch (ExcepcionSQL e)
		{
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al dar de alta el trabajador");
		}
		
		return resultado;
	}

	@Override
	public boolean actualizarTrabajador(TransferTrabajador t) throws SQLException
	{
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		boolean resultado = false;
		try {
			PreparedStatement actualizar = c.prepareStatement(queryActualizar);
			
			actualizar.setInt(1, t.getIDDepartamento());
			actualizar.setString(2, t.getDNI());
			actualizar.setString(3, t.getNombre());
			actualizar.setString(4, t.getApellidos());
			actualizar.setBoolean(5, t.getTipo());
			actualizar.setDate(6, t.getFecIni());
			actualizar.setDate(7, t.getFecFin());
			actualizar.setFloat(8,t.getSueldoBase());
			actualizar.setFloat(9,t.getFactProd());
			actualizar.setFloat(10,t.getSueldoHoras());
			actualizar.setInt(11, t.getHoras());
			actualizar.setInt(12, t.getID());
			
			int rs = actualizar.executeUpdate();
			
			if(rs==1)
				resultado=true;
			else
				throw new SQLException();
			
			
		}catch (ExcepcionSQL e) {
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al actualizar el trabajador");
		}
		
		return resultado;
	}

	@Override
	public TransferTrabajador consultaTrabajador(int IDTrabajador) throws SQLException
	{
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		
		TransferTrabajador res = null;
		
		try {
			PreparedStatement consulta = c.prepareStatement(queryConsultar1);
			consulta.setInt(1,IDTrabajador);
			ResultSet rs = consulta.executeQuery();
			
			while(rs.next()){
				res = new TransferTrabajador();
				res.setID(rs.getInt("ID_Trabajador"));
				res.setIDDepartamento(rs.getInt("ID_Departamento"));
				res.setDNI(rs.getString("DNI"));
				res.setNombre(rs.getString("Nombre"));
				res.setApellidos(rs.getString("Apellidos"));
				res.setTipo(rs.getBoolean("Tipo"));
				res.setFecIni(rs.getDate("Fec_Inicio"));
				res.setFecFin(rs.getDate("Fec_Fin"));
				res.setSueldoBase(rs.getFloat("Sueldo_Base"));
				res.setFactProd(rs.getFloat("Factor_Productividad"));
				res.setSueldoHoras(rs.getFloat("Sueldo_Horas"));
				res.setHoras(rs.getInt("Horas"));
			}	
		} catch (ExcepcionSQL e) {
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al consultar el trabajador");
		}
		
		return res;
	}

	@Override
	public ArrayList<TransferTrabajador> consultaTrabajadores() throws SQLException
	{
		ArrayList<TransferTrabajador>  res = new ArrayList<TransferTrabajador>();
		TransferTrabajador t;
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		
		try {
			PreparedStatement consulta = c.prepareStatement(queryConsultarN);
			ResultSet rs = consulta.executeQuery();
			
			while(rs.next())
			{
				t=new TransferTrabajador();//Necesario porque si no a�ade x veces el mismo objeto, debido a que todos tienen la misma referencia.
				t.setID(rs.getInt("ID_Trabajador"));
				t.setIDDepartamento(rs.getInt("ID_Departamento"));
				t.setDNI(rs.getString("DNI"));
				t.setNombre(rs.getString("Nombre"));
				t.setApellidos(rs.getString("Apellidos"));
				t.setTipo(rs.getBoolean("Tipo"));
				t.setFecIni(rs.getDate("Fec_Inicio"));
				t.setFecFin(rs.getDate("Fec_Fin"));
				t.setSueldoBase(rs.getFloat("Sueldo_Base"));
				t.setFactProd(rs.getFloat("Factor_Productividad"));
				t.setSueldoHoras(rs.getFloat("Sueldo_Horas"));
				t.setHoras(rs.getInt("Horas"));
				res.add(t);
			}
		} catch (ExcepcionSQL e) {
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al consultar los trabajadores");
		}
		
		return res;
	}
	
	@Override
	public ArrayList<TransferTrabajador> consultaTrabajadoresPorDepartamento(int IDDepartamento) throws SQLException
	{
		ArrayList<TransferTrabajador> res = new ArrayList<TransferTrabajador>();
		TransferTrabajador t;
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		
		try {
			PreparedStatement consulta = c.prepareStatement(queryConsultarPorDepartamento);
			consulta.setInt(1,IDDepartamento);
			ResultSet rs = consulta.executeQuery();
			
			while(rs.next())
			{
				t=new TransferTrabajador();//Necesario porque si no a�ade x veces el mismo objeto, debido a que todos tienen la misma referencia.
				t.setID(rs.getInt("ID_Trabajador"));
				t.setIDDepartamento(rs.getInt("ID_Departamento"));
				t.setDNI(rs.getString("DNI"));
				t.setNombre(rs.getString("Nombre"));
				t.setApellidos(rs.getString("Apellidos"));
				t.setTipo(rs.getBoolean("Tipo"));
				t.setFecIni(rs.getDate("Fec_Inicio"));
				t.setFecFin(rs.getDate("Fec_Fin"));
				t.setSueldoBase(rs.getFloat("Sueldo_Base"));
				t.setFactProd(rs.getFloat("Factor_Productividad"));
				t.setSueldoHoras(rs.getFloat("Sueldo_Horas"));
				t.setHoras(rs.getInt("Horas"));
				res.add(t);
			}
		} catch (ExcepcionSQL e) {
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al consultar los trabajadores por el departamento " + IDDepartamento);
		}
		
		return res;
	}


	@Override
	public boolean bajaTrabajador(int IDTrabajador) throws SQLException
	{
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		boolean resultado = false;
		try {
			PreparedStatement borrar = c.prepareStatement(queryBaja);
			
			borrar.setInt(1,IDTrabajador);
			
			int rs = borrar.executeUpdate();
			
			if(rs==1)
				resultado=true;
			else
				throw new SQLException();
			
			
		}catch (ExcepcionSQL e) {
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al borrar el trabajador");
		}
		
		return resultado;
	}
}

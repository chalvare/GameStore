package integracion.cliente;

import integracion.transacciones.conexion.ExcepcionSQL;
import integracion.transacciones.conexion.JdbcUtils;
import integracion.transacciones.transactions.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import integracion.transacciones.transactionManager.TransactionManager;
import negocio.cliente.TransferCliente;

public class DAOClienteImp implements DAOCliente
{
	private final String queryAltaSocio = "INSERT INTO `gamestore`.`Cliente` (`Nombre`,`Apellidos`,`Tipo`,`DNI`,`Email`,`Telefono`) VALUES(?,?,?,?,?,?)";
	private final String queryAltaCliente = "INSERT INTO `gamestore`.`Cliente` (`Nombre`,`Apellidos`,`Tipo`,`Intencion`) VALUES(?,?,?,?)";
	private final String queryActualizarSocio = "UPDATE `gamestore`.`Cliente` SET `Nombre` = ?, `Apellidos` = ?, `Tipo` = ?, `DNI` = ?, `Email` = ?, `Telefono` = ? WHERE `ID_Cliente` = ?";
	private final String queryActualizarCliente = "UPDATE `gamestore`.`Cliente` SET `Nombre` = ?, `Apellidos` = ?, `Tipo` = ?, `Intencion` = ? WHERE `ID_Cliente` = ?" ;
	private final String queryConsultar1 = "SELECT * FROM `gamestore`.`Cliente` WHERE `ID_Cliente` = ? FOR UPDATE";
	private final String queryConsultarN = "SELECT * FROM `gamestore`.`Cliente` FOR UPDATE";
	private final String queryBaja = "DELETE FROM `gamestore`.`Cliente` WHERE `ID_Cliente` = ?";
	
	@Override
	public boolean altaSocio(TransferCliente t) throws SQLException
	{
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		
		boolean resultado = false;
		
		try {
			PreparedStatement alta = c.prepareStatement(queryAltaSocio);
			alta.setString(1, t.getNombre());
			alta.setString(2, t.getApellidos());
			alta.setBoolean(3,t.getTipo());
			alta.setString(4, t.getDNI());
			alta.setString(5, t.getEmail());
			alta.setString(6, t.getTelefono());
			
			int rs = alta.executeUpdate();
			
			if(rs==1)
				resultado=true;
			else
				throw new SQLException();
			
		} catch (ExcepcionSQL e)
		{
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al dar de alta el Socio");
		}
		
		return resultado;
	}
	
	@Override
	public boolean altaCliente(TransferCliente t) throws SQLException
	{
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		
		boolean resultado = false;
		
		try {
			PreparedStatement alta = c.prepareStatement(queryAltaCliente);
			alta.setString(1, t.getNombre());
			alta.setString(2, t.getApellidos());
			alta.setBoolean(3,t.getTipo());
			alta.setBoolean(4,t.getIntencion());
			
			int rs = alta.executeUpdate();
			
			if(rs==1)
				resultado=true;
			else
				throw new SQLException();
			
		} catch (ExcepcionSQL e)
		{
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al dar de alta el Cliente");
		}
		
		return resultado;
	}

	@Override
	public boolean actualizarCliente(TransferCliente t) throws SQLException
	{
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		boolean resultado = false;
		try {
			PreparedStatement actualizar = c.prepareStatement(queryActualizarCliente);
			
			actualizar.setString(1, t.getNombre());
			actualizar.setString(2, t.getApellidos());
			actualizar.setBoolean(3,t.getTipo());
			actualizar.setBoolean(4,t.getIntencion());
			actualizar.setInt(5,t.getID());
			
			int rs = actualizar.executeUpdate();
			
			if(rs==1)
				resultado=true;
			else
				throw new SQLException();
			
			
		}catch (ExcepcionSQL e) {
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al actualizar el Cliente");
		}
		
		return resultado;
		
	}
	
	@Override
	public boolean actualizarSocio(TransferCliente t) throws SQLException
	{
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		boolean resultado = false;
		try {
			PreparedStatement actualizar = c.prepareStatement(queryActualizarSocio);
			
			actualizar.setString(1, t.getNombre());
			actualizar.setString(2, t.getApellidos());
			actualizar.setBoolean(3,t.getTipo());
			actualizar.setString(4, t.getDNI());
			actualizar.setString(5, t.getEmail());
			actualizar.setString(6, t.getTelefono());
			actualizar.setInt(7,t.getID());
			
			int rs = actualizar.executeUpdate();
			
			if(rs==1)
				resultado=true;
			else
				throw new SQLException();
			
			
		}catch (ExcepcionSQL e) {
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al actualizar el Socio");
		}
		
		return resultado;
		
	}

	@Override
	public TransferCliente consultaCliente(int IDCliente) throws SQLException
	{
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		
		TransferCliente res = null;
		
		try {
			PreparedStatement consulta = c.prepareStatement(queryConsultar1);
			consulta.setInt(1,IDCliente);
			ResultSet rs = consulta.executeQuery();
			
			while(rs.next()){
				res = new TransferCliente();
				res.setID(rs.getInt("ID_Cliente"));
				res.setNombre(rs.getString("Nombre"));
				res.setApellidos(rs.getString("Apellidos"));
				res.setTipo(rs.getBoolean("Tipo"));
				res.setDNI(rs.getString("DNI"));
				res.setEmail(rs.getString("Email"));
				res.setTelefono(rs.getString("Telefono"));
				res.setIntencion(rs.getBoolean("Intencion"));
			}
		} catch (ExcepcionSQL e) {
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al consultar el Cliente");
		}
		
		return res;
	}

	@Override
	public ArrayList<TransferCliente> consultaClientes() throws SQLException
	{
		ArrayList<TransferCliente>  res = new ArrayList<TransferCliente>();
		TransferCliente t;
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		
		try {
			PreparedStatement consulta = c.prepareStatement(queryConsultarN);
			ResultSet rs = consulta.executeQuery();
			
			while(rs.next())
			{
				t=new TransferCliente();//Necesario porque si no añade x veces el mismo objeto, debido a que todos tienen la misma referencia.
				t.setID(rs.getInt("ID_Cliente"));
				t.setNombre(rs.getString("Nombre"));
				t.setApellidos(rs.getString("Apellidos"));
				t.setTipo(rs.getBoolean("Tipo"));
				t.setDNI(rs.getString("DNI"));
				t.setEmail(rs.getString("Email"));
				t.setTelefono(rs.getString("Telefono"));
				t.setIntencion(rs.getBoolean("Intencion"));
				res.add(t);
			}
		} catch (ExcepcionSQL e) {
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al consultar los Clientes");
		}
		
		return res;
	}

	@Override
	public boolean bajaCliente(int IDCliente) throws SQLException
	{
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		boolean resultado = false;
		try {
			PreparedStatement borrar = c.prepareStatement(queryBaja);
			
			borrar.setInt(1,IDCliente);
			
			int rs = borrar.executeUpdate();
			
			if(rs==1)
				resultado=true;
			else
				throw new SQLException();
			
			
		}catch (ExcepcionSQL e) {
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al borrar el Cliente");
		}
		
		return resultado;
	}
}

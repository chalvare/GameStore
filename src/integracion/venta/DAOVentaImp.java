package integracion.venta;

import integracion.transacciones.conexion.ExcepcionSQL;
import integracion.transacciones.conexion.JdbcUtils;
import integracion.transacciones.transactions.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import integracion.transacciones.transactionManager.TransactionManager;
import negocio.venta.TransferVenta;

public class DAOVentaImp implements DAOVenta
{
	private final String queryAlta = "INSERT INTO `gamestore`.`Venta` (`ID_Venta`,`ID_Cliente`,`Coste Total`,`Fecha`) VALUES(?,?,?,?)";
	private final String queryConsultar1 = "SELECT * FROM `gamestore`.`Venta` WHERE `ID_Venta` = ? FOR UPDATE";
	private final String queryConsultarN = "SELECT * FROM `gamestore`.`Venta` FOR UPDATE";
	private final String queryBalance = "SELECT SUM(`Venta`.`Coste Total`) AS suma FROM `gamestore`.`Venta` FOR UPDATE";
	private final String queryActualizarCoste = "UPDATE `gamestore`.`Venta`,`gamestore`.`LineaVenta` SET `Coste Total` = (SELECT SUM(`gamestore`.`LineaVenta`.`Coste`) AS suma FROM `gamestore`.`LineaVenta` WHERE `LineaVenta`.`ID_Venta` =? ) WHERE `Venta`.`ID_Venta`=?";
	
	@Override
	public boolean altaVenta(TransferVenta t) throws SQLException
	{
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		
		boolean resultado = false;
		
		try {
			PreparedStatement alta = c.prepareStatement(queryAlta);
			alta.setInt(1, t.getID());
			alta.setInt(2, t.getIDCliente());
			alta.setFloat(3,0);
			alta.setDate(4, t.getFecha());
			
			int rs = alta.executeUpdate();
			
			if(rs==1)
				resultado=true;
			else
				throw new SQLException();
			
		} catch (ExcepcionSQL e)
		{
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al dar de alta la venta");
		}
		
		return resultado;
	}

	@Override
	public TransferVenta consultaVenta(int IDVenta) throws SQLException
	{
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		
		TransferVenta res = null;
		
		try {
			PreparedStatement consulta = c.prepareStatement(queryConsultar1);
			consulta.setInt(1,IDVenta);
			ResultSet rs = consulta.executeQuery();
		
			while(rs.next()){
				res = new TransferVenta();
				res.setID(rs.getInt("ID_Venta"));
				res.setIDCliente(rs.getInt("ID_Cliente"));
				res.setCosteTotal(rs.getFloat("Coste Total"));
				res.setFecha(rs.getDate("Fecha"));
				
			}	
		} catch (ExcepcionSQL e) {
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al consultar la venta");
		}
		
		return res;
	}

	@Override
	public ArrayList<TransferVenta> consultaVentas() throws SQLException
	{
		ArrayList<TransferVenta>  res = new ArrayList<TransferVenta>();
		TransferVenta t;
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		
		try {
			PreparedStatement consulta = c.prepareStatement(queryConsultarN);
			ResultSet rs = consulta.executeQuery();
			
			while(rs.next())
			{
				t=new TransferVenta();//Necesario porque si no a�ade x veces el mismo objeto, debido a que todos tienen la misma referencia.
				t.setID(rs.getInt("ID_Venta"));
				t.setIDCliente(rs.getInt("ID_Cliente"));
				t.setCosteTotal(rs.getFloat("Coste Total"));
				t.setFecha(rs.getDate("Fecha"));
				res.add(t);
			}
		} catch (ExcepcionSQL e) {
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al consultar las ventas");
		}
		
		return res;
	}

	@Override
	public float balance() throws SQLException
	{
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		
		float res = 0;
		
		try {
			PreparedStatement consulta = c.prepareStatement(queryBalance);
			ResultSet rs = consulta.executeQuery();
			if(rs.next())
				res = rs.getFloat("suma");
			
		} catch (ExcepcionSQL e) {
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al consultar el balance");
		}
		
		return res;
	}
	
	public boolean actualizarCosteVenta(int IDVenta) throws SQLException
	{
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		boolean resultado = false;
		try {
			
			PreparedStatement actualizar = c.prepareStatement(queryActualizarCoste);
			
			actualizar.setInt(1,IDVenta);
			actualizar.setInt(2,IDVenta);
			
			int rs = actualizar.executeUpdate();
			
			if(rs==1)
				resultado=true;
			else
				throw new SQLException();
			
		}catch (ExcepcionSQL e) {
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al actualizar el coste total de la venta");
		}
		
		return resultado;
		
	}
}

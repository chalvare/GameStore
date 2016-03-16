package integracion.articulo;

import integracion.transacciones.conexion.ExcepcionSQL;
import integracion.transacciones.conexion.JdbcUtils;
import integracion.transacciones.transactions.Transaction;

import java.sql.*;
import java.util.ArrayList;

import integracion.transacciones.transactionManager.TransactionManager;
import negocio.articulo.TransferArticulo;

public class DAOArticuloImp implements DAOArticulo
{
	private final String queryAlta = "INSERT INTO `gamestore`.`Articulo` (`Nombre`,`Valor`,`Cantidad`) VALUES(?,?,?)";
	private final String queryActualizar = "UPDATE `gamestore`.`Articulo` SET `Nombre` = ?, `Valor` = ?, `Cantidad` = ? WHERE `ID_Articulo` = ?" ;
	private final String queryConsultar1 = "SELECT * FROM `gamestore`.`Articulo` WHERE `ID_Articulo` = ? FOR UPDATE";
	private final String queryConsultarN = "SELECT * FROM `gamestore`.`Articulo` FOR UPDATE";
	
	@Override
	public boolean altaArticulo(TransferArticulo t) throws SQLException 
	{
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		
		boolean resultado = false;
		
		try {
			PreparedStatement alta = c.prepareStatement(queryAlta);
			alta.setString(1, t.getNombre());
			alta.setFloat(2,t.getValor());
			alta.setInt(3, t.getCantidad());
			
			int rs = alta.executeUpdate();
			
			if(rs==1)
				resultado=true;
			else
				throw new SQLException();
			
		} catch (ExcepcionSQL e)
		{
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al dar de alta el articulo");
		}
		
		return resultado;
	}

	@Override
	public boolean actualizarArticulo(TransferArticulo t) throws SQLException
	{
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		boolean resultado = false;
		try {
			PreparedStatement actualizar = c.prepareStatement(queryActualizar);
			
			actualizar.setString(1, t.getNombre());
			actualizar.setFloat(2, t.getValor());
			actualizar.setInt(3, t.getCantidad());
			actualizar.setInt(4, t.getID());
			
			int rs = actualizar.executeUpdate();
			
			if(rs==1)
				resultado=true;
			else
				throw new SQLException();
			
			
		}catch (ExcepcionSQL e) {
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al actualizar el articulo");
		}
		
		return resultado;
		
	}

	@Override
	public TransferArticulo consultaArticulo(int IDArticulo) throws SQLException
	{
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		
		TransferArticulo res = null;
		
		try {
			PreparedStatement consulta = c.prepareStatement(queryConsultar1);
			consulta.setInt(1,IDArticulo);
			ResultSet rs = consulta.executeQuery();
			
			while(rs.next()){
				res = new TransferArticulo();
				res.setID(rs.getInt("ID_Articulo"));
				res.setNombre(rs.getString("Nombre"));
				res.setCantidad(rs.getInt("Cantidad"));
				res.setValor(rs.getFloat("Valor"));
			}	
		} catch (ExcepcionSQL e) {
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al consultar el articulo");
		}
		
		return res;
	}

	@Override
	public ArrayList<TransferArticulo> consultaArticulos() throws SQLException
	{
		ArrayList<TransferArticulo>  res = new ArrayList<TransferArticulo>();
		TransferArticulo t;
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		
		try {
			PreparedStatement consulta = c.prepareStatement(queryConsultarN);
			ResultSet rs = consulta.executeQuery();
			
			while(rs.next())
			{
				t=new TransferArticulo();//Necesario porque si no a�ade x veces el mismo objeto, debido a que todos tienen la misma referencia.
				t.setID(rs.getInt("ID_Articulo"));
				t.setNombre(rs.getString("Nombre"));
				t.setCantidad(rs.getInt("Cantidad"));
				t.setValor(rs.getFloat("Valor"));
				res.add(t);
			}
		} catch (ExcepcionSQL e) {
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al consultar los articulos");
		}
		
		return res;
	}
	
}

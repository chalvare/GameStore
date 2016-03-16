package integracion.lineaVenta;

import integracion.transacciones.conexion.ExcepcionSQL;
import integracion.transacciones.conexion.JdbcUtils;
import integracion.transacciones.transactions.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import integracion.transacciones.transactionManager.TransactionManager;
import negocio.lineaVenta.TransferLineaVenta;
public class DAOLineaVentaImp implements DAOLineaVenta
{
	private final String queryAlta = "INSERT INTO `gamestore`.`LineaVenta` (`ID_Venta`,`ID_Articulo`,`Coste`,`Cantidad`) VALUES(?,?,?,?)";
	private final String queryCalculaCoste = "UPDATE `gamestore`.`LineaVenta`,`gamestore`.`Articulo` SET `gamestore`.`LineaVenta`.`Coste` = `gamestore`.`LineaVenta`.`Cantidad` * `gamestore`.`Articulo`.Valor WHERE `gamestore`.`LineaVenta`.`ID_Articulo` = `gamestore`.`Articulo`.`ID_Articulo`";
	private final String queryConsultarLineaPorVenta = "SELECT * FROM `gamestore`.`LineaVenta` WHERE `ID_Venta` = ? FOR UPDATE";
	private final String queryConsultarLineaPorArticulo  = "SELECT * FROM `gamestore`.`LineaVenta` WHERE `ID_Articulo` = ? FOR UPDATE";
	private final String queryDevolucion="UPDATE `gamestore`.`LineaVenta` SET `Cantidad` = ? WHERE `ID_Articulo`= ? AND `ID_Venta`= ?";
	
	private boolean calculoCosteLineaVenta() throws SQLException
	{
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		PreparedStatement calculo = c.prepareStatement(queryCalculaCoste);
		//boolean resultado=false;
		
		int rs = calculo.executeUpdate();
		rs=0;
		//System.out.println("res rs: " + rs);
		/*if(rs!=0)
			resultado=true;
		else
			throw new SQLException();*/
		
		return true;
	}
	
	@Override
	public boolean altaLineaVenta(TransferLineaVenta t) throws SQLException
	{
		// TODO Auto-generated method stub
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		
		boolean resultado = false;
		
		try {
			
			PreparedStatement alta = c.prepareStatement(queryAlta);
			alta.setInt(1, t.getIDVenta());
			alta.setInt(2, t.getIDArticulo());
			alta.setFloat(3, 0);
			alta.setInt(4, t.getCantidad());
			
			int rs = alta.executeUpdate();
			
			if(rs==1 && calculoCosteLineaVenta())
				resultado=true;
			else
				throw new SQLException();
			
		} catch (ExcepcionSQL e)
		{
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al dar de alta la linea de venta");
		}
		
		return resultado;
	}

	@Override
	public ArrayList<TransferLineaVenta> consultaLineaVentasPorVenta(int IDVenta) throws SQLException
	{
		ArrayList<TransferLineaVenta>  res = new ArrayList<TransferLineaVenta>();
		TransferLineaVenta t;
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		
		try {
			PreparedStatement consulta = c.prepareStatement(queryConsultarLineaPorVenta);
			consulta.setInt(1,IDVenta);
			ResultSet rs = consulta.executeQuery();
			
			while(rs.next())
			{
				t=new TransferLineaVenta();//Necesario porque si no a�ade x veces el mismo objeto, debido a que todos tienen la misma referencia.
				t.setIDVenta(rs.getInt("ID_Venta"));
				t.setIDArticulo(rs.getInt("ID_Articulo"));
				t.setCoste(rs.getFloat("Coste"));
				t.setCantidad(rs.getInt("Cantidad"));
				res.add(t);
			}
		} catch (ExcepcionSQL e) {
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al consultar la linea de venta de la venta " + IDVenta);
		}
		
		return res;
	}

	@Override
	public ArrayList<TransferLineaVenta> consultaLineaVentasPorArticulo(int IDArticulo) throws SQLException
	{
		ArrayList<TransferLineaVenta>  res = new ArrayList<TransferLineaVenta>();
		TransferLineaVenta t;
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		
		try {
			PreparedStatement consulta = c.prepareStatement(queryConsultarLineaPorArticulo);
			consulta.setInt(1,IDArticulo);
			ResultSet rs = consulta.executeQuery();
			
			while(rs.next())
			{
				t=new TransferLineaVenta();//Necesario porque si no a�ade x veces el mismo objeto, debido a que todos tienen la misma referencia.
				t.setIDVenta(rs.getInt("ID_Venta"));
				t.setIDArticulo(rs.getInt("ID_Articulo"));
				t.setCoste(rs.getFloat("Coste"));
				t.setCantidad(rs.getInt("Cantidad"));
				res.add(t);
			}
		} catch (ExcepcionSQL e) {
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al consultar la linea de venta del articulo " + IDArticulo);
		}
		
		return res;
	}

	@Override
	public boolean devolucion(TransferLineaVenta t) throws SQLException
	{
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		boolean resultado = false;
		try
		{
			PreparedStatement actualizar = c.prepareStatement(queryDevolucion);
			
			actualizar.setInt(1, t.getCantidad());
			actualizar.setInt(2, t.getIDArticulo());
			actualizar.setInt(3, t.getIDVenta());
			
			int rs = actualizar.executeUpdate();
			System.out.println("res rs:"+rs);
			
			if(rs!=0 && calculoCosteLineaVenta())
			{
				resultado=true;
			}
			else
				throw new SQLException();
			
			
		}catch (ExcepcionSQL e) {
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al realizar la devolucion");
		}
		
		return resultado;
	}

}

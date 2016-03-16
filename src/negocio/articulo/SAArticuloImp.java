package negocio.articulo;

import integracion.articulo.DAOArticulo;
import integracion.factoriaDAO.FactoriaDAO;
import integracion.transacciones.conexion.ExcepcionSQL;
import integracion.transacciones.transactions.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;

import integracion.transacciones.transactionManager.TransactionManager;

public class SAArticuloImp implements SAArticulo{

	@Override
	public boolean altaArticulo(TransferArticulo t) throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaccion = tm.nuevaTransaccion();
		DAOArticulo dao = FactoriaDAO.getInstance().generaDAOArticulo();
		boolean resultado = false;
		
		transaccion.start();
		
		try
		{
			if(t == null)
			{
				transaccion.rollback();
				throw new ExcepcionSQL("El transferArticulo está vacio");
			}
			else if(t.getNombre().equals("") || t.getValor()==null || t.getCantidad() == null)
			{
				transaccion.rollback();
				throw new ExcepcionSQL("Faltan datos esenciales del artï¿½culo");
			}
			else
			{
				resultado = dao.altaArticulo(t);
				transaccion.commit();
			}
			
		} catch (ExcepcionSQL e) {
			transaccion.rollback();
			throw e;
		}finally{
			tm.eliminaTransaccion();
		}
		
		return resultado;
	}

	@Override
	public boolean actualizarArticulo(TransferArticulo t) throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaccion = tm.nuevaTransaccion();
		DAOArticulo dao = FactoriaDAO.getInstance().generaDAOArticulo();
		boolean resultado = false;
		
		transaccion.start();
		
		try
		{
			if(t == null || dao.consultaArticulo(t.getID()) == null)
			{
				transaccion.rollback();
				throw new ExcepcionSQL("El transferArticulo está vacio o no existe el articulo");
			}
			else if(t.getNombre().equals("") || t.getValor()==null || t.getCantidad() == null)
			{
				transaccion.rollback();
				throw new ExcepcionSQL("Faltan datos esenciales del artï¿½culo");
			}
			else
			{
				resultado = dao.actualizarArticulo(t);
				transaccion.commit();
			}
			
			
		} catch (ExcepcionSQL e) {
			transaccion.rollback();
			throw e;
		}finally{
			tm.eliminaTransaccion();
		}
		return resultado;
	}

	@Override
	public TransferArticulo consultaArticulo(int IDArticulo) throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaccion = tm.nuevaTransaccion();
		DAOArticulo dao = FactoriaDAO.getInstance().generaDAOArticulo();
		TransferArticulo t = null;
		
		transaccion.start();
		
		try
		{
			t = dao.consultaArticulo(IDArticulo);
		}catch(ExcepcionSQL e)
		{
			throw e;
		}
		finally
		{
			tm.eliminaTransaccion();
		}
		
		return t;
	}

	@Override
	public ArrayList<TransferArticulo> consultaArticulos() throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOArticulo dao = FactoriaDAO.getInstance().generaDAOArticulo();
		ArrayList<TransferArticulo> listaArticulos = null;
		
		transacion.start();
	
		try
		{
			listaArticulos = dao.consultaArticulos();
		}
		catch(ExcepcionSQL e)
		{
			throw e;
		}
		finally
		{
			tm.eliminaTransaccion();
		}	
		
		return listaArticulos;
	}

}

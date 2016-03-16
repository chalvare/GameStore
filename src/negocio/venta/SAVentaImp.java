package negocio.venta;

import integracion.factoriaDAO.FactoriaDAO;
import integracion.transacciones.conexion.ExcepcionSQL;
import integracion.transacciones.transactions.Transaction;
import integracion.venta.DAOVenta;

import java.sql.SQLException;
import java.util.ArrayList;

import integracion.transacciones.transactionManager.TransactionManager;

public class SAVentaImp implements SAVenta
{
	@Override
	public boolean altaVenta(TransferVenta t) throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaccion = tm.nuevaTransaccion();
		DAOVenta dao = FactoriaDAO.getInstance().generaDAOVenta();
		boolean resultado = false;
		
		transaccion.start();
		
		try
		{
			if(t == null)
			{
				transaccion.rollback();
				throw new ExcepcionSQL("El transferVenta esta vacio");
			}
			else if(dao.consultaVenta(t.getID()) != null)
			{
				transaccion.rollback();
				throw new ExcepcionSQL("La venta ya existe");
			}
			else if(t.getIDCliente() == null|| t.getFecha() == null)
			{
				transaccion.rollback();
				throw new ExcepcionSQL("Faltan datos esenciales de la venta");
			}
			else
			{
				resultado = dao.altaVenta(t);
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
	public TransferVenta consultaVenta(int IDVenta) throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaccion = tm.nuevaTransaccion();
		DAOVenta dao = FactoriaDAO.getInstance().generaDAOVenta();
		TransferVenta t = null;
		
		transaccion.start();
		
		try
		{
			t = dao.consultaVenta(IDVenta);
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
	public ArrayList<TransferVenta> consultaVentas() throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOVenta dao = FactoriaDAO.getInstance().generaDAOVenta();
		ArrayList<TransferVenta> listaVentas = null;
		
		transacion.start();
	
		try
		{
			listaVentas = dao.consultaVentas();
		}
		catch(ExcepcionSQL e)
		{
			throw e;
		}
		finally
		{
			tm.eliminaTransaccion();
		}	
		
		return listaVentas;
	}

	@Override
	public float balance() throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaccion = tm.nuevaTransaccion();
		DAOVenta dao = FactoriaDAO.getInstance().generaDAOVenta();
		float resultado = -1;
		
		transaccion.start();
		
		try
		{
			resultado = dao.balance();
		} catch (ExcepcionSQL e) {
			throw e;
		}finally{
			tm.eliminaTransaccion();
		}
		
		return resultado;
	}

}

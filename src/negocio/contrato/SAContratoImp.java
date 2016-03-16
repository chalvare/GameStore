package negocio.contrato;

import integracion.contrato.DAOContrato;
import integracion.factoriaDAO.FactoriaDAO;
import integracion.transacciones.conexion.ExcepcionSQL;
import integracion.transacciones.transactions.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;

import integracion.transacciones.transactionManager.TransactionManager;

public class SAContratoImp implements SAContrato
{

	@Override
	public boolean altaContrato(TransferContrato t) throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaccion = tm.nuevaTransaccion();
		DAOContrato dao = FactoriaDAO.getInstance().generaDAOContrato();
		boolean resultado = false;
		
		transaccion.start();
		
		try
		{
			if(t == null)
			{
				transaccion.rollback();
				throw new ExcepcionSQL("El transferContrato está vacio");
			}
			else if(t.getDescripcion().equals(""))
			{
				transaccion.rollback();
				throw new ExcepcionSQL("Faltan descripcion del contrato");
			}
			else
			{
				resultado = dao.altaContrato(t);
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
	public boolean actualizarContrato(TransferContrato t) throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaccion = tm.nuevaTransaccion();
		DAOContrato dao = FactoriaDAO.getInstance().generaDAOContrato();
		boolean resultado = false;
		
		transaccion.start();
		
		try
		{
			if(t == null || dao.consultaContrato(t.getID())==null)
			{
				transaccion.rollback();
				throw new ExcepcionSQL("El transferContrato está vacio o el contrato no existe");
			}
			else if(t.getDescripcion().equals(""))
			{
				transaccion.rollback();
				throw new ExcepcionSQL("Faltan descripciï¿½n del contrato");
			}
			else
			{
				resultado = dao.actualizarContrato(t);
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
	public TransferContrato consultaContrato(int IDContrato) throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaccion = tm.nuevaTransaccion();
		DAOContrato dao = FactoriaDAO.getInstance().generaDAOContrato();
		TransferContrato t = null;
		
		transaccion.start();
		
		try
		{
			t = dao.consultaContrato(IDContrato);
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
	public ArrayList<TransferContrato> consultaContratos() throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOContrato dao = FactoriaDAO.getInstance().generaDAOContrato();
		ArrayList<TransferContrato> listaContratos = null;
		
		transacion.start();
	
		try
		{
			listaContratos = dao.consultaContratos();
		}
		catch(ExcepcionSQL e)
		{
			throw e;
		}
		finally
		{
			tm.eliminaTransaccion();
		}	
		
		return listaContratos;
	}

}

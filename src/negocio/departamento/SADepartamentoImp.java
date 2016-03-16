package negocio.departamento;

import integracion.departamento.DAODepartamento;
import integracion.factoriaDAO.FactoriaDAO;
import integracion.transacciones.conexion.ExcepcionSQL;
import integracion.transacciones.transactions.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;

import integracion.transacciones.transactionManager.TransactionManager;

public class SADepartamentoImp implements SADepartamento{

	@Override
	public boolean altaDepartamento(TransferDepartamento t) throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaccion = tm.nuevaTransaccion();
		DAODepartamento dao = FactoriaDAO.getInstance().generaDAODepartamento();
		boolean resultado = false;
		
		transaccion.start();
		
		try
		{
			if(t == null)
			{
				transaccion.rollback();
				throw new ExcepcionSQL("El transferArticulo está vacio");
			}
			else if(t.getNombre().equals(""))
			{
				transaccion.rollback();
				throw new ExcepcionSQL("Faltan nombre del departamento");
			}
			else
			{
				resultado = dao.altaDepartamento(t);
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
	public boolean actualizarDepartamento(TransferDepartamento t) throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaccion = tm.nuevaTransaccion();
		DAODepartamento dao = FactoriaDAO.getInstance().generaDAODepartamento();
		boolean resultado = false;
		
		transaccion.start();
		
		try
		{
			if(t == null || dao.consultaDepartamento(t.getID()) == null)
			{
				transaccion.rollback();
				throw new ExcepcionSQL("El transferArticulo está vacio o el departamento no existe");
			}
			else if(t.getNombre().equals(""))
			{
				transaccion.rollback();
				throw new ExcepcionSQL("Faltan nombre del departamento");
			}
			else
			{
				resultado = dao.actualizarDepartamento(t);
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
	public TransferDepartamento consultaDepartamento(int IDDepartamento) throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaccion = tm.nuevaTransaccion();
		DAODepartamento dao = FactoriaDAO.getInstance().generaDAODepartamento();
		TransferDepartamento t = null;
		
		transaccion.start();
		
		try
		{
			t = dao.consultaDepartamento(IDDepartamento);
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
	public ArrayList<TransferDepartamento> consultaDepartamentos() throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAODepartamento dao = FactoriaDAO.getInstance().generaDAODepartamento();
		ArrayList<TransferDepartamento> listaDepartamentos = null;
		
		transacion.start();
	
		try
		{
			listaDepartamentos = dao.consultaDepartamentos();
		}
		catch(ExcepcionSQL e)
		{
			throw e;
		}
		finally
		{
			tm.eliminaTransaccion();
		}	
		
		return listaDepartamentos;
	}

	@Override
	public boolean bajaDepartamento(int IDDepartamento) throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAODepartamento dao = FactoriaDAO.getInstance().generaDAODepartamento();
		transacion.start();
		Boolean resultado = null;
		
		transacion.start();
		
		try
		{		
			if(dao.consultaDepartamento(IDDepartamento) == null)
				throw new ExcepcionSQL("El departamento no existe");
			else
			{
				resultado = dao.bajaDepartamento(IDDepartamento);
				transacion.commit();
			}
		}
		catch(ExcepcionSQL e)
		{
			transacion.rollback();
			throw e;
		}
		finally
		{
			tm.eliminaTransaccion();
		}
		return resultado;
	}
}

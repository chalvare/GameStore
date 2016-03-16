package negocio.trabajador;

import integracion.factoriaDAO.FactoriaDAO;
import integracion.trabajador.DAOTrabajador;
import integracion.transacciones.conexion.ExcepcionSQL;
import integracion.transacciones.transactions.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;

import integracion.transacciones.transactionManager.TransactionManager;

public class SATrabajadorImp implements SATrabajador
{
	@Override
	public boolean altaTrabajador(TransferTrabajador t) throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaccion = tm.nuevaTransaccion();
		DAOTrabajador dao = FactoriaDAO.getInstance().generaDAOTrabajador();
		boolean resultado = false;
		
		transaccion.start();
		
		try {
			if(t == null)
			{
				transaccion.rollback();
				throw new ExcepcionSQL("El transferTrabajador esta vacio");
			}
			else if(t.getDNI().equals("") || t.getNombre().equals("") || t.getApellidos().equals("") || t.getFecIni() == null)
			{
				transaccion.rollback();
				throw new ExcepcionSQL("Falta informacion necesaria del trabajador");
			}
			else if((dao.consultaTrabajador(t.getID()) != null))//else if((dao.consultaCliente(t.getDNI()) != null))
			{
				transaccion.rollback();
				throw new ExcepcionSQL("El trabajador ya existe");
			}
			else if(t.getTipo())
			{
				if(t.getSueldoBase() == null || t.getFactProd() == null)
				{
					transaccion.rollback();
					throw new ExcepcionSQL("Falta informacion necesaria del trabajador para darle de alta como Encargado");
				}
				else
				{
					resultado = dao.altaTrabajador(t);
					transaccion.commit();
				}
			}
			else
			{
				if(t.getSueldoHoras() == null || t.getHoras() == null)
				{
					transaccion.rollback();
					throw new ExcepcionSQL("Falta informacion necesaria del trabajador para darle de alta como Empleado");
				}
				else
				{
					resultado = dao.altaTrabajador(t);
					transaccion.commit();
				}
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
	public boolean actualizarTrabajador(TransferTrabajador t) throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaccion = tm.nuevaTransaccion();
		DAOTrabajador dao = FactoriaDAO.getInstance().generaDAOTrabajador();
		boolean resultado = false;
		
		transaccion.start();
		
		try {
			
			if(t == null || dao.consultaTrabajador(t.getID()) == null)
			{
				transaccion.rollback();
				throw new ExcepcionSQL("El transferTrabajador esta vacio o el trabajador no existe");
			}
			else if(t.getDNI().equals("") || t.getNombre().equals("") || t.getApellidos().equals("") || t.getFecIni() == null)
			{
				transaccion.rollback();
				throw new ExcepcionSQL("Falta informacion necesaria del usuario");
			}
			else if(t.getTipo())
			{
				if(t.getSueldoBase() == null || t.getFactProd() == null)
				{
					transaccion.rollback();
					throw new ExcepcionSQL("Falta informacion necesaria del trabajador para actualizarlo como Encargado");
				}
				else
				{
					resultado = dao.actualizarTrabajador(t);
					transaccion.commit();
				}
			}
			else
			{
				if(t.getSueldoHoras() == null || t.getHoras() == null)
				{
					transaccion.rollback();
					throw new ExcepcionSQL("Falta informacion necesaria del trabajador para actualizarlo como Empleado");
				}
				else
				{
					resultado = dao.actualizarTrabajador(t);
					transaccion.commit();
				}
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
	public TransferTrabajador consultaTrabajador(int IDTrabajador) throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaccion = tm.nuevaTransaccion();
		DAOTrabajador dao = FactoriaDAO.getInstance().generaDAOTrabajador();
		TransferTrabajador t = null;
		
		transaccion.start();
		
		try
		{
			t = dao.consultaTrabajador(IDTrabajador);
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
	public ArrayList<TransferTrabajador> consultaTrabajadores() throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOTrabajador dao = FactoriaDAO.getInstance().generaDAOTrabajador();
		ArrayList<TransferTrabajador> listaTrabajadores = null;
		
		transacion.start();
	
		try
		{
			listaTrabajadores = dao.consultaTrabajadores();
		}
		catch(ExcepcionSQL e)
		{
			throw e;
		}
		finally
		{
			tm.eliminaTransaccion();
		}	
		
		return listaTrabajadores;
	}

	@Override
	public ArrayList<TransferTrabajador> consultaTrabajadoresPorDepartamento(int IDDepartamento) throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOTrabajador dao = FactoriaDAO.getInstance().generaDAOTrabajador();
		ArrayList<TransferTrabajador> listaTrabajadores = null;
		
		transacion.start();
	
		try
		{
			listaTrabajadores = dao.consultaTrabajadoresPorDepartamento(IDDepartamento);
		}
		catch(ExcepcionSQL e)
		{
			throw e;
		}
		finally
		{
			tm.eliminaTransaccion();
		}	
		
		return listaTrabajadores;
	}

	@Override
	public boolean bajaTrabajador(int IDTrabajador) throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOTrabajador dao = FactoriaDAO.getInstance().generaDAOTrabajador();
		Boolean resultado = null;
		
		transacion.start();
		
		try
		{		
			if(dao.consultaTrabajador(IDTrabajador) == null)
				throw new ExcepcionSQL("El trabajador no existe");
			else
			{
				resultado = dao.bajaTrabajador(IDTrabajador);
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

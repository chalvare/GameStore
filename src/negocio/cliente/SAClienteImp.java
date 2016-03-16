package negocio.cliente;

import integracion.cliente.DAOCliente;
import integracion.factoriaDAO.FactoriaDAO;
import integracion.transacciones.conexion.ExcepcionSQL;
import integracion.transacciones.transactions.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;

import integracion.transacciones.transactionManager.TransactionManager;

public class SAClienteImp implements SACliente{

	@Override
	public boolean altaCliente(TransferCliente t) throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaccion = tm.nuevaTransaccion();
		DAOCliente dao = FactoriaDAO.getInstance().generaDAOCliente();
		boolean resultado = false;
		
		transaccion.start();
		
		try {
			if(t == null)
			{
				transaccion.rollback();
				throw new ExcepcionSQL("El transferCliente está vacio");
			}
			else if(t.getNombre().equals("") || t.getApellidos().equals(""))
			{
				transaccion.rollback();
				throw new ExcepcionSQL("Falta informacion necesaria del usuario");
			}
			else if((dao.consultaCliente(t.getID()) != null))//else if((dao.consultaCliente(t.getDNI()) != null))
			{
				transaccion.rollback();
				throw new ExcepcionSQL("El cliente ya existe");
			}
			else if(t.getTipo())
			{
				if(t.getDNI().equals("") || t.getEmail().equals("") || t.getTelefono().equals(""))
				{
					transaccion.rollback();
					throw new ExcepcionSQL("Falta informacion necesaria del usuario para darle de alta como Socio");
				}
				else
				{
					resultado = dao.altaSocio(t);
					transaccion.commit();
				}
			}
			else
			{
				resultado = dao.altaCliente(t);
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
	public boolean actualizarCliente(TransferCliente t) throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaccion = tm.nuevaTransaccion();
		DAOCliente dao = FactoriaDAO.getInstance().generaDAOCliente();
		boolean resultado = false;
		
		transaccion.start();
		
		try {
			if(t == null || dao.consultaCliente(t.getID())==null)
			{
				transaccion.rollback();
				throw new ExcepcionSQL("El transferCliente está vacio  o el cliente no existe");
			}
			else if(t.getNombre().equals("") || t.getApellidos().equals(""))
			{
				transaccion.rollback();
				throw new ExcepcionSQL("Falta informacion necesaria del usuario");
			}
			else if(t.getTipo())
			{
				if(t.getDNI().equals("") || t.getEmail().equals("") || t.getTelefono().equals(""))
				{
					transaccion.rollback();
					throw new ExcepcionSQL("Falta informacion necesaria del usuario para darle de alta como Socio");
				}
				else
				{
					resultado = dao.actualizarSocio(t);
					transaccion.commit();
				}
			}
			else
			{
				resultado = dao.actualizarCliente(t);
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
	public TransferCliente consultaCliente(int IDCliente) throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaccion = tm.nuevaTransaccion();
		DAOCliente dao = FactoriaDAO.getInstance().generaDAOCliente();
		TransferCliente t = null;
		
		transaccion.start();
		
		try
		{
			t = dao.consultaCliente(IDCliente);
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
	public ArrayList<TransferCliente> consultaClientes() throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOCliente dao = FactoriaDAO.getInstance().generaDAOCliente();
		ArrayList<TransferCliente> listaClientes = null;
		
		transacion.start();
	
		try
		{
			listaClientes = dao.consultaClientes();
		}
		catch(ExcepcionSQL e)
		{
			throw e;
		}
		finally
		{
			tm.eliminaTransaccion();
		}	
		
		return listaClientes;
	}

	@Override
	public boolean bajaCliente(int IDCliente) throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOCliente dao = FactoriaDAO.getInstance().generaDAOCliente();
		Boolean resultado = null;
		
		transacion.start();
		
		try
		{		
			if(dao.consultaCliente(IDCliente) == null)
				throw new ExcepcionSQL("El cliente no existe");
			else
			{
				resultado = dao.bajaCliente(IDCliente);
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

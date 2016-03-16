package negocio.lineaVenta;

import integracion.articulo.DAOArticulo;
import integracion.factoriaDAO.FactoriaDAO;
import integracion.lineaVenta.DAOLineaVenta;
import integracion.transacciones.conexion.ExcepcionSQL;
import integracion.transacciones.transactions.Transaction;
import integracion.venta.DAOVenta;

import java.sql.SQLException;
import java.util.ArrayList;

import negocio.articulo.TransferArticulo;
import integracion.transacciones.transactionManager.TransactionManager;

public class SALineaVentaImp implements SALineaVenta
{
	@Override
	public boolean altaLineaVenta(TransferLineaVenta t) throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaccion = tm.nuevaTransaccion();
		DAOLineaVenta daoLineaVenta = FactoriaDAO.getInstance().generaDAOLineaVenta();
		DAOVenta daoVenta = FactoriaDAO.getInstance().generaDAOVenta();
		DAOArticulo daoArticulo = FactoriaDAO.getInstance().generaDAOArticulo();
		boolean resultado = false;
		
		transaccion.start();
		try
		{
			if(t==null || daoLineaVenta.consultaLineaVentasPorArticulo(t.getIDArticulo()) ==  null || daoLineaVenta.consultaLineaVentasPorVenta(t.getIDVenta()) == null)
			{
				transaccion.rollback();
				throw new ExcepcionSQL("La venta no existe o el transfer de lineaVenta esta vacio");
			}
			else
			{
				TransferArticulo tArticulo = daoArticulo.consultaArticulo(t.getIDArticulo());
				if(t.getCantidad() > tArticulo.getCantidad())
				{
					transaccion.rollback();
					throw new ExcepcionSQL("Estas intentando comprar mas cantidad de articulo que los existentes");
				}
				else
				{
					tArticulo.setCantidad(tArticulo.getCantidad()-t.getCantidad());
					resultado = daoLineaVenta.altaLineaVenta(t) && daoVenta.actualizarCosteVenta(t.getIDVenta()) && daoArticulo.actualizarArticulo(tArticulo);
					transaccion.commit();
				}
			}
		}catch (ExcepcionSQL e)
		{
			transaccion.rollback();
			throw e;
		}finally{
			tm.eliminaTransaccion();
		}
		
		return resultado;
	}

	@Override
	public ArrayList<TransferLineaVenta> consultaLineaVentasPorVenta(int IDVenta) throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOLineaVenta dao = FactoriaDAO.getInstance().generaDAOLineaVenta();
		ArrayList<TransferLineaVenta> listaLineasVenta = null;
		
		transacion.start();
	
		try
		{
			listaLineasVenta = dao.consultaLineaVentasPorVenta(IDVenta);
		}
		catch(ExcepcionSQL e)
		{
			throw e;
		}
		finally
		{
			tm.eliminaTransaccion();
		}	
		
		return listaLineasVenta;
	}

	@Override
	public ArrayList<TransferLineaVenta> consultaLineaVentasPorArticulo(int IDArticulo) throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transacion = tm.nuevaTransaccion();
		DAOLineaVenta dao = FactoriaDAO.getInstance().generaDAOLineaVenta();
		ArrayList<TransferLineaVenta> listaLineasVenta = null;
		
		transacion.start();
	
		try
		{
			listaLineasVenta = dao.consultaLineaVentasPorArticulo(IDArticulo);
		}
		catch(ExcepcionSQL e)
		{
			throw e;
		}
		finally
		{
			tm.eliminaTransaccion();
		}	
		
		return listaLineasVenta;
	}
	
	public boolean devolucion(TransferLineaVenta t) throws SQLException
	{
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaccion = tm.nuevaTransaccion();
		DAOLineaVenta daoLV = FactoriaDAO.getInstance().generaDAOLineaVenta();
		DAOVenta daoV = FactoriaDAO.getInstance().generaDAOVenta();
		boolean resultado = false;
		
		transaccion.start();
		
		try
		{
			ArrayList<TransferLineaVenta> listaLineasVenta = daoLV.consultaLineaVentasPorVenta(t.getIDVenta());
			
			if(listaLineasVenta==null)
			{
				transaccion.rollback();
				throw new ExcepcionSQL("No existe la linea de venta");
			}
			else
			{
				TransferLineaVenta lineaVentaConArticulo = null;
				for(TransferLineaVenta transfer : listaLineasVenta)
				{
					if(transfer.getIDArticulo() == t.getIDArticulo())
					{
						lineaVentaConArticulo=transfer;
					}
						
				}
				
				if(lineaVentaConArticulo == null)
				{
					transaccion.rollback();
					throw new ExcepcionSQL("La venta especificada no tiene el articulo con ID# " + t.getIDArticulo());
				}
				else
				{
					if(lineaVentaConArticulo.getCantidad() < t.getCantidad() )
					{
						transaccion.rollback();
						throw new ExcepcionSQL("Estas intentando devolver mas productos de los que compraste");
					}
					else
					{
						DAOArticulo daoA = FactoriaDAO.getInstance().generaDAOArticulo();
						TransferArticulo transferArticulo = daoA.consultaArticulo(t.getIDArticulo());
						transferArticulo.setCantidad(transferArticulo.getCantidad()+t.getCantidad());
						lineaVentaConArticulo.setCantidad(lineaVentaConArticulo.getCantidad()-t.getCantidad());
						resultado = daoA.actualizarArticulo(transferArticulo) && daoLV.devolucion(lineaVentaConArticulo) && daoV.actualizarCosteVenta(t.getIDVenta());
						transaccion.commit();
					}
				}
			}
		} catch (ExcepcionSQL e)
		{
			transaccion.rollback();
			throw e;
		}finally{
			tm.eliminaTransaccion();
		}
		
		return resultado;
	}
}

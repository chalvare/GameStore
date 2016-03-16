package integracion.transacciones.transactionManager;

import integracion.transacciones.conexion.ExcepcionSQL;
import integracion.transacciones.transactionFactory.TransactionFactory;
import integracion.transacciones.transactions.Transaction;

import java.util.concurrent.ConcurrentHashMap;

public class TransactionManagerImp extends TransactionManager
{
	private ConcurrentHashMap<Long, Transaction> mapaConcurrencia = new ConcurrentHashMap<Long, Transaction>();

	@Override
	public Transaction nuevaTransaccion()
	{
		Transaction t = null;
		Long idHilo = Thread.currentThread().getId();
		if(mapaConcurrencia.containsKey(idHilo))
			t = mapaConcurrencia.get(idHilo);
		else{
			t = TransactionFactory.getInstance().nuevaTransaccion();
			mapaConcurrencia.put(idHilo,t);
		}
		return t;
	}

	public Transaction getTransaction() throws ExcepcionSQL
	{
		Transaction t = null;
		Long idHilo = Thread.currentThread().getId();
		if(mapaConcurrencia.containsKey(idHilo))
			t = mapaConcurrencia.get(idHilo);
		else{
			throw new ExcepcionSQL("Error al obtener transaccion");
		}
		return t;
		
	}
	
	@Override
	public Boolean eliminaTransaccion() throws ExcepcionSQL
	{
		Long threadId = Thread.currentThread().getId();
		boolean resultado;
		
		if (mapaConcurrencia.containsKey(threadId))
		{
			Transaction t = mapaConcurrencia.get(threadId);
			
			t.commit();
			mapaConcurrencia.remove(threadId);
			
			resultado = true;
		}
		else
			resultado = false;
		
		return resultado;
	}
}

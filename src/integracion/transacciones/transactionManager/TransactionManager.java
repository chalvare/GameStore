package integracion.transacciones.transactionManager;

import integracion.transacciones.conexion.ExcepcionSQL;
import integracion.transacciones.transactions.Transaction;

public abstract class TransactionManager
{
	private static TransactionManager transactionManagerInstance;
	
	private synchronized static void createTransactionManager()
	{
		if(transactionManagerInstance == null)
			transactionManagerInstance = new TransactionManagerImp();
	}
	
	public static TransactionManager getInstance()
	{
		createTransactionManager();
		return transactionManagerInstance;
	}
	
	public abstract Transaction nuevaTransaccion();
	public abstract Transaction getTransaction() throws ExcepcionSQL;
	public abstract Boolean eliminaTransaccion() throws ExcepcionSQL;
}

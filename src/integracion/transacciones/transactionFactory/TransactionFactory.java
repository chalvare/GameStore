package integracion.transacciones.transactionFactory;

import integracion.transacciones.transactions.Transaction;

public abstract class TransactionFactory
{
	private static TransactionFactory transactionFactoryInstance;
	
	public abstract Transaction nuevaTransaccion();
	
	private synchronized static void createTransactionFactory()
	{
		if(transactionFactoryInstance == null)
			transactionFactoryInstance = new TransactionFactoryImp();
	}
	
	public static TransactionFactory getInstance()
	{
		createTransactionFactory();
		return transactionFactoryInstance;
	}
}

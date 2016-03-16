package integracion.transacciones.transactionFactory;

import integracion.transacciones.transactions.Transaction;
import integracion.transacciones.transactions.TransactionMySQL;

public class TransactionFactoryImp extends TransactionFactory {

	@Override
	public Transaction nuevaTransaccion() {
		return new TransactionMySQL();
	}

}

package integracion.transacciones.transactions;

import integracion.transacciones.conexion.ExcepcionSQL;

import java.sql.Connection;

public interface Transaction{
	public void start() throws ExcepcionSQL;
	public void commit() throws ExcepcionSQL;
	public void rollback() throws ExcepcionSQL;
	public Connection getResource();
	public void lock() throws ExcepcionSQL;
}

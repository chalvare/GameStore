package integracion.contrato;

import integracion.transacciones.conexion.ExcepcionSQL;
import integracion.transacciones.conexion.JdbcUtils;
import integracion.transacciones.transactions.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import integracion.transacciones.transactionManager.TransactionManager;
import negocio.contrato.TransferContrato;

public class DAOContratoImp implements DAOContrato
{
	private final String queryAlta = "INSERT INTO `gamestore`.`Tipo Contrato` (`Descripcion`) VALUES(?)";
	private final String queryActualizar = "UPDATE `gamestore`.`Tipo Contrato` SET `Descripcion` = ? WHERE `ID_Convenio` = ?";
	private final String queryConsultar1 = "SELECT * FROM `gamestore`.`Tipo Contrato` WHERE `ID_Convenio` = ? FOR UPDATE";
	private final String queryConsultarN = "SELECT * FROM `gamestore`.`Tipo Contrato` FOR UPDATE";
	
	@Override
	public boolean altaContrato(TransferContrato t) throws SQLException
	{
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		
		boolean resultado = false;
		
		try {
			PreparedStatement alta = c.prepareStatement(queryAlta);
			alta.setString(1, t.getDescripcion());
			
			int rs = alta.executeUpdate();
			
			if(rs==1)
				resultado=true;
			else
				throw new SQLException();
			
		} catch (ExcepcionSQL e)
		{
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al dar de alta el Contrato");
		}
		
		return resultado;
	}

	@Override
	public boolean actualizarContrato(TransferContrato t) throws SQLException
	{
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		boolean resultado = false;
		try {
			PreparedStatement actualizar = c.prepareStatement(queryActualizar);
			
			actualizar.setString(1, t.getDescripcion());
			actualizar.setInt(2, t.getID());
			
			int rs = actualizar.executeUpdate();
			
			if(rs==1)
				resultado=true;
			else
				throw new SQLException();
			
			
		}catch (ExcepcionSQL e) {
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al actualizar el contrato");
		}
		
		return resultado;
	}

	@Override
	public TransferContrato consultaContrato(int IDContrato) throws SQLException
	{
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		
		TransferContrato res = null;
		
		try {
			PreparedStatement consulta = c.prepareStatement(queryConsultar1);
			consulta.setInt(1,IDContrato);
			ResultSet rs = consulta.executeQuery();
			
			while(rs.next()){
				res = new TransferContrato();
				res.setID(rs.getInt("ID_Convenio"));
				res.setDescripcion(rs.getString("Descripcion"));
			}	
		} catch (ExcepcionSQL e) {
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al consultar el contrato");
		}
		
		return res;
	}

	@Override
	public ArrayList<TransferContrato> consultaContratos() throws SQLException
	{
		ArrayList<TransferContrato>  res = new ArrayList<TransferContrato>();
		TransferContrato t;
		Transaction transaccion = TransactionManager.getInstance().getTransaction();
		Connection c = transaccion.getResource();
		
		try {
			PreparedStatement consulta = c.prepareStatement(queryConsultarN);
			ResultSet rs = consulta.executeQuery();
			
			while(rs.next())
			{
				t=new TransferContrato();//Necesario porque si no añade x veces el mismo objeto, debido a que todos tienen la misma referencia.
				t.setID(rs.getInt("ID_Convenio"));
				t.setDescripcion(rs.getString("Descripcion"));
				res.add(t);
			}
		} catch (ExcepcionSQL e) {
			JdbcUtils.printSQLException(e);
			throw new ExcepcionSQL("Error al consultar los contratos");
		}
		
		return res;
	}

}

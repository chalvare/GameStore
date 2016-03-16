package integracion.transacciones.conexion;

import java.sql.*;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Conexion
{
	public Connection AbrirConexionDataSource() throws SQLException
	{
		MysqlDataSource ds = new MysqlDataSource();
		
		ds.setURL("jdbc:mysql://www.db4free.net");
		ds.setUser("teamgamestore");
		ds.setPassword("arnold858");
		ds.setDatabaseName("gamestore");
		ds.setPort(3306);
		Connection conexion = ds.getConnection();
		conexion.setAutoCommit(false);
		conexion.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
		
		return conexion;
	}
}

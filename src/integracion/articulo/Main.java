package integracion.articulo;

import integracion.transacciones.conexion.JdbcUtils;

import java.sql.SQLException;
import java.util.ArrayList;

import negocio.articulo.TransferArticulo;

public class Main {

	public static void main(String[] args)
	{
		TransferArticulo t = new TransferArticulo();
		ArrayList<TransferArticulo> t2 = new ArrayList<TransferArticulo>();
		
		/*t.setNombre("Pendiente");
		t.setValor(50);
		t.setCantidad(5);*/
		//Pene;
		
		try {
			DAOArticuloImp dao = new DAOArticuloImp();
			t2 = dao.consultaArticulos();
			for(int i=0;i<t2.size();i++)
			{
				t = t2.get(i);
				System.out.println(t.getValor());
			}
		} catch (SQLException e) {
			JdbcUtils.printSQLException(e);
		}
	}

}

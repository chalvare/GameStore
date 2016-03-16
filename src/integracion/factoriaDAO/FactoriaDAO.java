package integracion.factoriaDAO;

import integracion.articulo.DAOArticulo;
import integracion.cliente.DAOCliente;
import integracion.contrato.DAOContrato;
import integracion.departamento.DAODepartamento;
import integracion.lineaVenta.DAOLineaVenta;
import integracion.trabajador.DAOTrabajador;
import integracion.venta.DAOVenta;

public abstract class FactoriaDAO
{
	private static FactoriaDAO factoriaDAOInstance;
	
	private static synchronized void createFactoriaDAO() {
		
		if ( factoriaDAOInstance == null) {
			factoriaDAOInstance = new FactoriaDAOImp();
		}
	}
	
	public static FactoriaDAO getInstance(){

		createFactoriaDAO();

		return factoriaDAOInstance;
	}
	
	public abstract DAOArticulo generaDAOArticulo ();
	
	public abstract DAOCliente generaDAOCliente();

	public abstract DAOContrato generaDAOContrato();

	public abstract DAODepartamento generaDAODepartamento();

	public abstract DAOTrabajador generaDAOTrabajador();

	public abstract DAOVenta generaDAOVenta();
	
	public abstract DAOLineaVenta generaDAOLineaVenta();
}

package integracion.factoriaDAO;

import integracion.articulo.DAOArticulo;
import integracion.articulo.DAOArticuloImp;
import integracion.cliente.DAOCliente;
import integracion.cliente.DAOClienteImp;
import integracion.contrato.DAOContrato;
import integracion.contrato.DAOContratoImp;
import integracion.departamento.DAODepartamento;
import integracion.departamento.DAODepartamentoImp;
import integracion.lineaVenta.DAOLineaVenta;
import integracion.lineaVenta.DAOLineaVentaImp;
import integracion.trabajador.DAOTrabajador;
import integracion.trabajador.DAOTrabajadorImp;
import integracion.venta.DAOVenta;
import integracion.venta.DAOVentaImp;

public class FactoriaDAOImp extends FactoriaDAO
{
	public DAOCliente generaDAOCliente(){
		return new DAOClienteImp();
	}

	@Override
	public DAOArticulo generaDAOArticulo() {
		return new DAOArticuloImp();
	}

	@Override
	public DAOContrato generaDAOContrato() {
		return new DAOContratoImp();
	}

	@Override
	public DAODepartamento generaDAODepartamento() {
		return new DAODepartamentoImp();
	}

	@Override
	public DAOTrabajador generaDAOTrabajador() {
		return new DAOTrabajadorImp();
	}

	@Override
	public DAOVenta generaDAOVenta() {
		return new DAOVentaImp();
	}
	
	public DAOLineaVenta generaDAOLineaVenta() {
		return new DAOLineaVentaImp();
	}
}

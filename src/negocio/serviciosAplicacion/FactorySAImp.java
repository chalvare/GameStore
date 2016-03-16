package negocio.serviciosAplicacion;

import negocio.articulo.SAArticulo;
import negocio.articulo.SAArticuloImp;
import negocio.cliente.SACliente;
import negocio.cliente.SAClienteImp;
import negocio.contrato.SAContrato;
import negocio.contrato.SAContratoImp;
import negocio.departamento.SADepartamento;
import negocio.departamento.SADepartamentoImp;
import negocio.lineaVenta.SALineaVenta;
import negocio.lineaVenta.SALineaVentaImp;
import negocio.trabajador.SATrabajador;
import negocio.trabajador.SATrabajadorImp;
import negocio.venta.SAVenta;
import negocio.venta.SAVentaImp;

public class FactorySAImp extends FactorySA {

	@Override
	public SAArticulo getSAArticulo() {
		return new SAArticuloImp();
	}

	@Override
	public SACliente getSACliente() {
		return new SAClienteImp();
	}

	@Override
	public SAContrato getSAContrato() {
		return new SAContratoImp();
	}

	@Override
	public SADepartamento getSADepartamento() {
		return new SADepartamentoImp();
	}

	@Override
	public SALineaVenta getSALineaVenta() {
		return new SALineaVentaImp();
	}

	@Override
	public SAVenta getSAVenta() {
		return new SAVentaImp();
	}

	@Override
	public SATrabajador getSATrabajador() {
		return new SATrabajadorImp();
	}

}

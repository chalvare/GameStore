package negocio.serviciosAplicacion;

import negocio.articulo.SAArticulo;
import negocio.cliente.SACliente;
import negocio.contrato.SAContrato;
import negocio.departamento.SADepartamento;
import negocio.lineaVenta.SALineaVenta;
import negocio.trabajador.SATrabajador;
import negocio.venta.SAVenta;

public abstract class FactorySA 
{
	private static FactorySA factorySAInstance;
	
	private synchronized static void createFactorySA()
	{
		if(factorySAInstance == null)
			factorySAInstance = new FactorySAImp();
	}
	
	public static FactorySA getInstance()
	{
		createFactorySA();
		return factorySAInstance;
	}
	
	public abstract SAArticulo getSAArticulo();
	public abstract SACliente getSACliente();
	public abstract SAContrato getSAContrato();
	public abstract SADepartamento getSADepartamento();
	public abstract SALineaVenta getSALineaVenta();
	public abstract SAVenta getSAVenta();
	public abstract SATrabajador getSATrabajador();
	
}

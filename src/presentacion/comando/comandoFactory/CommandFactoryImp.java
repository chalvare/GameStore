/**
 * 
 */
package presentacion.comando.comandoFactory;

import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.articulo.ActualizarArticulo;
import presentacion.comando.articulo.AltaArticulo;
import presentacion.comando.articulo.ConsultaArticulo;
import presentacion.comando.articulo.ConsultaArticuloModificar;
import presentacion.comando.articulo.ConsultaTotalArticulo;
import presentacion.comando.cliente.ActualizarCliente;
import presentacion.comando.cliente.AltaNoSocio;
import presentacion.comando.cliente.AltaSocio;
import presentacion.comando.cliente.BajaCliente;
import presentacion.comando.cliente.ConsultaCliente;
import presentacion.comando.cliente.ConsultaClienteBorrar;
import presentacion.comando.cliente.ConsultaClienteModificar;
import presentacion.comando.cliente.ConsultaTotalCliente;
import presentacion.comando.contrato.ActualizarContrato;
import presentacion.comando.contrato.AltaContrato;
import presentacion.comando.contrato.ConsultaContratoModificar;
import presentacion.comando.contrato.ConsultaTotalContrato;
import presentacion.comando.contrato.ConsultarContrato;
import presentacion.comando.departamento.ActualizarDepartamento;
import presentacion.comando.departamento.AltaDepartamento;
import presentacion.comando.departamento.BajaDepartamento;
import presentacion.comando.departamento.ConsultaDepartamento;
import presentacion.comando.departamento.ConsultaDepartamentoActualizar;
import presentacion.comando.departamento.ConsultaDepartamentoBaja;
import presentacion.comando.departamento.ConsultaTotalDepartamento;
import presentacion.comando.trabajador.ActualizarTrabajador;
import presentacion.comando.trabajador.AltaEmpleado;
import presentacion.comando.trabajador.AltaEncargado;
import presentacion.comando.trabajador.BajaTrabajador;
import presentacion.comando.trabajador.ConsultaTotalTrabajador;
import presentacion.comando.trabajador.ConsultaTrabajador;
import presentacion.comando.trabajador.ConsultarTrabajadorBaja;
import presentacion.comando.trabajador.ConsultarTrabajadorModificar;
import presentacion.comando.venta.AltaLineaVenta;
import presentacion.comando.venta.Balance;
import presentacion.comando.venta.ConsultaTotalVenta;
import presentacion.comando.venta.ConsultaVentaVender;
import presentacion.comando.venta.ConsultarVenta;
import presentacion.comando.venta.Devolucion;
import presentacion.comando.venta.Vender;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Administrador
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class CommandFactoryImp extends CommandFactory {

	@Override
	public Comando nuevoComando(IDEventos id_comando) {
		
		Comando comando = null;
		
		switch(id_comando){
			
		case EVENTO_ALTA_SOCIO:
			comando = new AltaNoSocio();
			break;
		case EVENTO_ALTA_NO_SOCIO:
			comando = new AltaSocio();
			break;
		case EVENTO_CONSULTA_CLIENTE:
			comando = new ConsultaCliente();
			break;
		case EVENTO_CONSULTA_TODOS_CLIENTES:
			comando = new ConsultaTotalCliente();
			break;
		case EVENTO_BAJA_CLIENTE:
			comando = new BajaCliente();
			break;
		case EVENTO_MODIFICAR_CLIENTE:
			comando = new ActualizarCliente();
			break;
		case EVENTO_CONSULTAR_CLIENTE_BORRAR:
			comando = new ConsultaClienteBorrar();
			break;
		case EVENTO_CONSULTAR_CLIENTE_MODIFICAR:
			comando = new ConsultaClienteModificar();
			break;

			
			 
		case EVENTO_MODIFICAR_ARTICULO:
			comando = new ActualizarArticulo();
			break;
		case EVENTO_CONSULTA_ARTICULO:
			comando = new ConsultaArticulo();
			break;
		case EVENTO_CONSULTA_TODOS_ARTICULOS:
			comando = new ConsultaTotalArticulo();
			break;
		case EVENTO_ALTA_ARTICULO:
			comando = new AltaArticulo();
			break;
		case EVENTO_CONSULTAR_ARTICULO_MODIFICAR:
			comando = new ConsultaArticuloModificar();
			break;
			
			
		case EVENTO_ALTA_ENCARGADO:
			comando = new AltaEncargado();
			break;
		case EVENTO_ALTA_EMPLEADO:
			comando = new AltaEmpleado();
			break;
		case EVENTO_CONSULTA_TRABAJADOR:
			comando = new ConsultaTrabajador();
			break;
		case  EVENTO_CONSULTA_TODOS_TRABAJADORES:
			comando = new ConsultaTotalTrabajador();
			break;
		case EVENTO_BAJA_TRABAJADOR:
			comando = new BajaTrabajador();
			break;
			
		case EVENTO_CONSULTAR_TRABAJADOR_BORRAR:
			comando = new ConsultarTrabajadorBaja();
			break;
		case  EVENTO_CONSULTAR_TRABAJADOR_MODIFICAR:
			comando = new ConsultarTrabajadorModificar();
			break;
			
		case EVENTO_MODIFICAR_TRABAJADOR:
			comando = new ActualizarTrabajador();
			break;
		
		
			
			
			
		case EVENTO_ALTA_DEPARTAMENTO:
			comando = new AltaDepartamento();
			break;
		case EVENTO_CONSULTA_DEPARTAMENTO:
			comando = new ConsultaDepartamento();
			break;
		case EVENTO_CONSULTA_TODOS_DEPARMENTOS:
			comando = new ConsultaTotalDepartamento();
			break;	
		case EVENTO_MODIFICAR_DEPARTAMENTO:
			comando = new ActualizarDepartamento();
			break;
		case  EVENTO_BAJA_DEPARTAMENTO:
			comando = new BajaDepartamento();
			break;
		case  EVENTO_CONSULTA_DEPARTAMENTO_BAJA:
			comando = new ConsultaDepartamentoBaja();
			break;
		case EVENTO_CONSULTA_DEPARTAMENTO_MODIFICAR:
			comando = new ConsultaDepartamentoActualizar();
			break;
			
			
			
		case EVENTO_ALTA_CONTRATO:
			comando = new AltaContrato();
			break;
		case EVENTO_CONSULTA_CONTRATO:
			comando = new ConsultarContrato();
			break;
		case EVENTO_CONSULTA_TODOS_CONTRATO:
			comando = new ConsultaTotalContrato();
			break;	
		case EVENTO_MODIFICAR_CONTRATO:
			comando = new ActualizarContrato();
			break;
		case EVENTO_CONSULTA_MODIFICAR_CONTRATO:
			comando = new ConsultaContratoModificar();
			break;

			
		case EVENTO_VENDER:
			comando = new Vender();
			break;
		case  EVENTO_BALANCE:
			comando = new Balance();
			break;
		case EVENTO_DEVOLUCION:
			comando = new Devolucion();
			break;	
		case EVENTO_CONSULTA_VENTA:
			comando = new ConsultarVenta();
			break;	
		case EVENTO_CONSULTA_TODOS_VENTA:
			comando = new ConsultaTotalVenta();
			break;	
		case EVENTO_ALTA_LINEA_VENTA:
			comando = new AltaLineaVenta();
			break;
		case EVENTO_CONSULTA_VENTA_VENDER:
			comando = new ConsultaVentaVender();
			break;
			
		default:
			break;
		}	
		return comando;
	}
	
}
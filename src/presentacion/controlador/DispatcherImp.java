/**
 * 
 */
package presentacion.controlador;

import presentacion.articulo.gui.ArticuloGUI;
import presentacion.cliente.gui.ClienteGUI;
import presentacion.comando.IDEventos;
import presentacion.comando.comandoFactory.CommandResponse;
import presentacion.contrato.gui.ContratoGUI;
import presentacion.departamento.gui.DepartamentoGUI;
import presentacion.trabajador.gui.TrabajadorGUI;
import presentacion.venta.gui.VentaGUI;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Administrador
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DispatcherImp extends Dispatcher {
	
	/**
	 * (sin Javadoc)
	 * 
	 * @see Dispatcher#redirect(CommandResponse respuestacomando)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void redirect(CommandResponse respuestacomando) {

		IDEventos eventoActual = respuestacomando.getEvento();
		Object datos = respuestacomando.getDatos();

		if (eventoActual == IDEventos.EVENTO_ALTA_SOCIO
				|| eventoActual == IDEventos.EVENTO_ALTA_NO_SOCIO
				|| eventoActual == IDEventos.EVENTO_BAJA_CLIENTE
				|| eventoActual == IDEventos.EVENTO_CONSULTA_CLIENTE
				|| eventoActual == IDEventos.EVENTO_CONSULTA_TODOS_CLIENTES
				|| eventoActual == IDEventos.EVENTO_CONSULTAR_CLIENTE_BORRAR
				|| eventoActual == IDEventos.EVENTO_CONSULTAR_CLIENTE_MODIFICAR
				|| eventoActual == IDEventos.EVENTO_MODIFICAR_CLIENTE
				|| eventoActual == IDEventos.ERROR_ALTA_SOCIO
				|| eventoActual == IDEventos.ERROR_EVENTO_ALTA_NO_SOCIO
				|| eventoActual == IDEventos.ERROR_EVENTO_BAJA_CLIENTE
				|| eventoActual == IDEventos.ERROR_CONSULTA_CLIENTE
				|| eventoActual == IDEventos.ERROR_EVENTO_CONSULTA_TODOS_CLIENTES
				|| eventoActual == IDEventos.ERROR_CONSULTAR_CLIENTE_BORRAR
				|| eventoActual == IDEventos.ERROR_EVENTO_CONSULTAR_CLIENTE_MODIFICAR
				|| eventoActual == IDEventos.ERROR_MODIFICAR_CLIENTE) {
			
			ClienteGUI.getInstance().update(eventoActual, datos);
		}
		else if(eventoActual == IDEventos.EVENTO_ALTA_ENCARGADO
				    || eventoActual == IDEventos.EVENTO_ALTA_EMPLEADO
				    || eventoActual == IDEventos.EVENTO_CONSULTA_TRABAJADOR
				    || eventoActual == IDEventos.EVENTO_CONSULTA_TODOS_TRABAJADORES
				    || eventoActual == IDEventos.EVENTO_CONSULTAR_TRABAJADOR_BORRAR
				    || eventoActual == IDEventos.EVENTO_CONSULTAR_TRABAJADOR_MODIFICAR
				    || eventoActual == IDEventos.EVENTO_BAJA_TRABAJADOR
				    || eventoActual == IDEventos.EVENTO_MODIFICAR_TRABAJADOR
				    || eventoActual == IDEventos.ERROR_EVENTO_MODIFICAR_TRABAJADOR
				    || eventoActual == IDEventos.ERROR_EVENTO_ALTA_ENCARGADO
				    || eventoActual == IDEventos.ERROR_EVENTO_ALTA_EMPLEADO
				    || eventoActual == IDEventos.ERROR_EVENTO_CONSULTA_TRABAJADOR
				    || eventoActual == IDEventos.ERROR_CONSULTA_TODOS_TRABAJADORES
				    || eventoActual == IDEventos.ERROR_EVENTO_CONSULTAR_TRABAJADOR_BORRAR
				    || eventoActual == IDEventos.ERROR_EVENTO_CONSULTAR_TRABAJADOR_MODIFICAR
		    		|| eventoActual == IDEventos.ERROR_EVENTO_BAJA_TRABAJADOR) {
			
			TrabajadorGUI.getInstance().update(eventoActual, datos);
		}
		else if(eventoActual == IDEventos.EVENTO_ALTA_ARTICULO
			    || eventoActual == IDEventos.EVENTO_CONSULTA_ARTICULO
			    || eventoActual == IDEventos.EVENTO_CONSULTA_TODOS_ARTICULOS
			    || eventoActual == IDEventos.EVENTO_MODIFICAR_ARTICULO
			    || eventoActual == IDEventos.EVENTO_CONSULTAR_ARTICULO_MODIFICAR
				|| eventoActual == IDEventos.ERROR_EVENTO_CONSULTAR_ARTICULO_MODIFICAR
			    || eventoActual == IDEventos.ERROR_EVENTO_ALTA_ARTICULO
			    || eventoActual == IDEventos.ERROR_EVENTO_CONSULTA_ARTICULO
			    || eventoActual == IDEventos.ERROR_EVENTO_CONSULTA_TODOS_ARTICULOS
	    		|| eventoActual == IDEventos.ERROR_EVENTO_MODIFICAR_ARTICULO) {
			
			ArticuloGUI.getInstance().update(eventoActual, datos);
		}
		else if(eventoActual == IDEventos.EVENTO_ALTA_DEPARTAMENTO
			    || eventoActual == IDEventos.EVENTO_CONSULTA_DEPARTAMENTO
			    || eventoActual == IDEventos.EVENTO_CONSULTA_TODOS_DEPARMENTOS
			    || eventoActual == IDEventos.EVENTO_CONSULTA_DEPARTAMENTO_BAJA
			    || eventoActual == IDEventos.EVENTO_CONSULTA_DEPARTAMENTO_MODIFICAR
			    || eventoActual == IDEventos.EVENTO_MODIFICAR_DEPARTAMENTO
			    || eventoActual == IDEventos.EVENTO_BAJA_DEPARTAMENTO
			    || eventoActual == IDEventos.ERROR_EVENTO_ALTA_DEPARTAMENTO
			    || eventoActual == IDEventos.ERROR_EVENTO_CONSULTA_DEPARTAMENTO
			    || eventoActual == IDEventos.ERROR_EVENTO_CONSULTA_TODOS_DEPARMENTOS
			    || eventoActual == IDEventos.ERROR_EVENTO_CONSULTA_DEPARTAMENTO_BAJA
			    || eventoActual == IDEventos.ERROR_EVENTO_CONSULTA_DEPARTAMENTO_MODIFICAR
			    || eventoActual == IDEventos.ERROR_EVENTO_MODIFICAR_DEPARTAMENTO
			    || eventoActual == IDEventos.ERROR_EVENTO_BAJA_DEPARTAMENTO) {
			
			DepartamentoGUI.getInstance().update(eventoActual, datos);
		}
		else if(eventoActual == IDEventos.EVENTO_ALTA_CONTRATO
			    || eventoActual == IDEventos.EVENTO_CONSULTA_CONTRATO
			    || eventoActual == IDEventos.EVENTO_CONSULTA_TODOS_CONTRATO
			    || eventoActual == IDEventos.EVENTO_CONSULTA_MODIFICAR_CONTRATO
			    || eventoActual == IDEventos.EVENTO_MODIFICAR_CONTRATO
			    || eventoActual == IDEventos.ERROR_EVENTO_ALTA_CONTRATO
			    || eventoActual == IDEventos.ERROR_EVENTO_CONSULTA_CONTRATO
			    || eventoActual == IDEventos.ERROR_EVENTO_CONSULTA_TODOS_CONTRATO
			    || eventoActual == IDEventos.ERROR_EVENTO_CONSULTA_MODIFICAR_CONTRATO
			    || eventoActual == IDEventos.ERROR_EVENTO_MODIFICAR_CONTRATO) {
			
			ContratoGUI.getInstance().update(eventoActual, datos);
		}
		else if(eventoActual == IDEventos.EVENTO_VENDER
			    || eventoActual == IDEventos.EVENTO_DEVOLUCION
			    || eventoActual == IDEventos.EVENTO_CONSULTA_VENTA
			    || eventoActual == IDEventos.EVENTO_CONSULTA_TODOS_VENTA
			    || eventoActual == IDEventos.EVENTO_BALANCE
			    || eventoActual == IDEventos.EVENTO_ALTA_LINEA_VENTA
			    || eventoActual == IDEventos.EVENTO_CONSULTA_VENTA_VENDER
				|| eventoActual == IDEventos.ERROR_EVENTO_CONSULTA_VENTA_VENDER
				|| eventoActual == IDEventos.ERROR_EVENTO_ALTA_LINEA_VENTA
			    || eventoActual == IDEventos.ERROR_EVENTO_VENDER
			    || eventoActual == IDEventos.ERROR_EVENTO_DEVOLUCION
			    || eventoActual == IDEventos.ERROR_EVENTO_CONSULTA_VENTA
			    || eventoActual == IDEventos.ERROR_EVENTO_CONSULTA_TODOS_VENTA
			    || eventoActual == IDEventos.ERROR_EVENTO_BALANCE) {
			
			VentaGUI.getInstance().update(eventoActual, datos);
		}
	}
}
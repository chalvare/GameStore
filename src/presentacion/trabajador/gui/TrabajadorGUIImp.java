package presentacion.trabajador.gui;

import presentacion.comando.IDEventos;
import presentacion.trabajador.paneles.PanelTrabajador;

public class TrabajadorGUIImp extends TrabajadorGUI{
	
	private static PanelTrabajador panelTrabajador;
	
	public PanelTrabajador getPanelTrabajador()
	{
		if(panelTrabajador == null)
			panelTrabajador = new PanelTrabajador();
		
		return panelTrabajador;
	}
	
	
	public void update(IDEventos evento_actual, Object datos) {

		switch (evento_actual) {

		case EVENTO_ALTA_ENCARGADO:
		case ERROR_EVENTO_ALTA_ENCARGADO:
		case EVENTO_ALTA_EMPLEADO:
		case ERROR_EVENTO_ALTA_EMPLEADO:
			getPanelTrabajador().actualizarVentanaAlta(evento_actual, datos);
			break;
			
			
		case EVENTO_BAJA_TRABAJADOR:
		case ERROR_EVENTO_BAJA_TRABAJADOR:
		case EVENTO_CONSULTAR_TRABAJADOR_BORRAR:
		case ERROR_EVENTO_CONSULTAR_TRABAJADOR_BORRAR:
			getPanelTrabajador().actualizarVentanaBorra(evento_actual, datos);
			break;
			
		case EVENTO_MODIFICAR_TRABAJADOR:
		case ERROR_EVENTO_MODIFICAR_TRABAJADOR:
		case EVENTO_CONSULTAR_TRABAJADOR_MODIFICAR:
		case ERROR_EVENTO_CONSULTAR_TRABAJADOR_MODIFICAR:
			getPanelTrabajador().actualizarVentanaActualiza(evento_actual, datos);
			break;
			
			
		case EVENTO_CONSULTA_TRABAJADOR:
		case ERROR_EVENTO_CONSULTA_TRABAJADOR:
			getPanelTrabajador().actualizarVentanaConsulta(evento_actual, datos);
			break;
			
		case EVENTO_CONSULTA_TODOS_TRABAJADORES:
		case ERROR_CONSULTA_TODOS_TRABAJADORES:
			getPanelTrabajador().actualizarVentanaConsultaN(evento_actual, datos);
			break;

		default:
			break;

		}
	}
	

}

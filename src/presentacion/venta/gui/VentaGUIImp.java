package presentacion.venta.gui;

import presentacion.comando.IDEventos;
import presentacion.venta.paneles.PanelVenta;

public class VentaGUIImp extends VentaGUI{
	
	private static PanelVenta panelVenta;
	
	public PanelVenta getPanelVenta()
	{
		if(panelVenta == null)
			panelVenta = new PanelVenta();
		
		return panelVenta;
	}
	
	
	public void update(IDEventos evento_actual, Object datos) {
		 
		switch (evento_actual) {

		case EVENTO_VENDER:
		case ERROR_EVENTO_VENDER:
		case EVENTO_ALTA_LINEA_VENTA:
		case ERROR_EVENTO_ALTA_LINEA_VENTA:
		case EVENTO_CONSULTA_VENTA_VENDER:
		case ERROR_EVENTO_CONSULTA_VENTA_VENDER:
			getPanelVenta().actualizarVentanaVenta(evento_actual, datos);
			break;
			
		case EVENTO_BALANCE:
		case ERROR_EVENTO_BALANCE:
			getPanelVenta().actualizarVentanaBalance(evento_actual, datos);
			break;
			
		case EVENTO_DEVOLUCION:
		case ERROR_EVENTO_DEVOLUCION:
			getPanelVenta().actualizarVentanaDevolucion(evento_actual, datos);
			break;
			
		case EVENTO_CONSULTA_VENTA:
		case ERROR_EVENTO_CONSULTA_VENTA:
			getPanelVenta().actualizarVentanaConsulta(evento_actual, datos);
			break;
			
		case EVENTO_CONSULTA_TODOS_VENTA:
		case ERROR_EVENTO_CONSULTA_TODOS_VENTA:
			getPanelVenta().actualizarVentanaConsultaN(evento_actual, datos);
			break;
			
		default:
			break;

		}
	}


}

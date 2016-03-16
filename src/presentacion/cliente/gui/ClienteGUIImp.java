package presentacion.cliente.gui;

import presentacion.cliente.paneles.PanelCliente;
import presentacion.comando.IDEventos;

public class ClienteGUIImp extends ClienteGUI{
	
	private static PanelCliente panelCliente;
	
	public PanelCliente getPanelCliente()
	{
		if(panelCliente == null)
			panelCliente = new PanelCliente();
		
		return panelCliente;
	}
	
	
	public void update(IDEventos evento_actual, Object datos) {

		switch (evento_actual) {

		case EVENTO_ALTA_SOCIO:
		case ERROR_ALTA_SOCIO:
		case EVENTO_ALTA_NO_SOCIO:
		case ERROR_EVENTO_ALTA_NO_SOCIO:
			getPanelCliente().actualizarVentanaAlta(evento_actual, datos);
			break;
			
			
		case EVENTO_BAJA_CLIENTE:
		case ERROR_EVENTO_BAJA_CLIENTE:
		case EVENTO_CONSULTAR_CLIENTE_BORRAR:
		case ERROR_CONSULTAR_CLIENTE_BORRAR:
			getPanelCliente().actualizarVentanaBorra(evento_actual, datos);
			break;
			
		case EVENTO_MODIFICAR_CLIENTE:
		case ERROR_MODIFICAR_CLIENTE:
		case EVENTO_CONSULTAR_CLIENTE_MODIFICAR:
		case ERROR_EVENTO_CONSULTAR_CLIENTE_MODIFICAR:
			getPanelCliente().actualizarVentanaActualiza(evento_actual, datos);
			break;
			
			
		case EVENTO_CONSULTA_CLIENTE:
		case ERROR_CONSULTA_CLIENTE:
			getPanelCliente().actualizarVentanaConsulta(evento_actual, datos);
			break;
			
		case EVENTO_CONSULTA_TODOS_CLIENTES:
		case ERROR_EVENTO_CONSULTA_TODOS_CLIENTES:
			getPanelCliente().actualizarVentanaConsultaN(evento_actual, datos);
			break;

		default:
			break;

		}
	}
	

}

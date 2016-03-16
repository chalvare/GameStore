package presentacion.contrato.gui;

import presentacion.comando.IDEventos;
import presentacion.contrato.paneles.PanelContrato;

public class ContratoGUIImp extends ContratoGUI{
	
	private static PanelContrato panelContrato;
	
	public PanelContrato getPanelContrato()
	{
		if(panelContrato == null)
			panelContrato = new PanelContrato();
		
		return panelContrato;
	}
	
	
	public void update(IDEventos evento_actual, Object datos) {
	 
		switch (evento_actual) {

		case EVENTO_ALTA_CONTRATO:
		case ERROR_EVENTO_ALTA_CONTRATO:
			getPanelContrato().actualizarVentanaAlta(evento_actual, datos);
			break;
			
		case EVENTO_MODIFICAR_CONTRATO:
		case ERROR_EVENTO_MODIFICAR_CONTRATO:
		case EVENTO_CONSULTA_MODIFICAR_CONTRATO:
		case ERROR_EVENTO_CONSULTA_MODIFICAR_CONTRATO:
			getPanelContrato().actualizarVentanaActualiza(evento_actual, datos);
			break;
			
		case EVENTO_CONSULTA_CONTRATO:
		case ERROR_EVENTO_CONSULTA_CONTRATO:
			getPanelContrato().actualizarVentanaConsulta(evento_actual, datos);
			break;
			
		case EVENTO_CONSULTA_TODOS_CONTRATO:
		case ERROR_EVENTO_CONSULTA_TODOS_CONTRATO:
			getPanelContrato().actualizarVentanaConsultaN(evento_actual, datos);
			break;

		default:
			break;

		}
	}


}

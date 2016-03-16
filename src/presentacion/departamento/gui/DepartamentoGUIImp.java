package presentacion.departamento.gui;
import presentacion.comando.IDEventos;
import presentacion.departamento.paneles.PanelDepartamento;

public class DepartamentoGUIImp extends DepartamentoGUI{
	
	
	private static PanelDepartamento panelDepartamento;
	
	public PanelDepartamento getPanelDepartamento()
	{
		if(panelDepartamento == null)
			panelDepartamento = new PanelDepartamento();
		
		return panelDepartamento;
	}
	
	
	public void update(IDEventos evento_actual, Object datos) {
		
		 
		switch (evento_actual) {

		case EVENTO_ALTA_DEPARTAMENTO:
		case ERROR_EVENTO_ALTA_DEPARTAMENTO:
			getPanelDepartamento().actualizarVentanaAlta(evento_actual, datos);
			break;
			
			
		case EVENTO_CONSULTA_DEPARTAMENTO:
		case ERROR_EVENTO_CONSULTA_DEPARTAMENTO:
			getPanelDepartamento().actualizarVentanaConsulta(evento_actual, datos);
			break;
			
		case EVENTO_MODIFICAR_DEPARTAMENTO:
		case ERROR_EVENTO_MODIFICAR_DEPARTAMENTO:
		case EVENTO_CONSULTA_DEPARTAMENTO_MODIFICAR:
		case ERROR_EVENTO_CONSULTA_DEPARTAMENTO_MODIFICAR:
			getPanelDepartamento().actualizarVentanaActualiza(evento_actual, datos);
			break;
			
			
		case EVENTO_CONSULTA_TODOS_DEPARMENTOS:
		case ERROR_EVENTO_CONSULTA_TODOS_DEPARMENTOS:
			getPanelDepartamento().actualizarVentanaConsultaN(evento_actual, datos);
			break;
			
		case EVENTO_BAJA_DEPARTAMENTO:
		case ERROR_EVENTO_BAJA_DEPARTAMENTO:
		case EVENTO_CONSULTA_DEPARTAMENTO_BAJA:
		case ERROR_EVENTO_CONSULTA_DEPARTAMENTO_BAJA:
			getPanelDepartamento().actualizarVentanaBorra(evento_actual, datos);
			break;

		default:
			break;

		}
	}
	

}

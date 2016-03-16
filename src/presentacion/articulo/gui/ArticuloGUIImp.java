package presentacion.articulo.gui;

import presentacion.articulo.paneles.PanelArticulo;
import presentacion.comando.IDEventos;

public class ArticuloGUIImp extends ArticuloGUI{
	
private static PanelArticulo panelArticulo;
	
	public PanelArticulo getPanelArticulo()
	{
		if(panelArticulo == null)
			panelArticulo = new PanelArticulo();
		
		return panelArticulo;
	}
	
	
	public void update(IDEventos evento_actual, Object datos) {
	
		switch (evento_actual) {

		case EVENTO_ALTA_ARTICULO:
		case ERROR_EVENTO_ALTA_ARTICULO:
			getPanelArticulo().actualizarVentanaAlta(evento_actual, datos);
			break;
			
			
		case EVENTO_MODIFICAR_ARTICULO:
		case ERROR_EVENTO_MODIFICAR_ARTICULO:
		case EVENTO_CONSULTAR_ARTICULO_MODIFICAR:
		case ERROR_EVENTO_CONSULTAR_ARTICULO_MODIFICAR:
			getPanelArticulo().actualizarVentanaActualiza(evento_actual, datos);
			break;
			
			
		case EVENTO_CONSULTA_ARTICULO:
		case ERROR_EVENTO_CONSULTA_ARTICULO:
			getPanelArticulo().actualizarVentanaConsulta(evento_actual, datos);
			break;
			
		case EVENTO_CONSULTA_TODOS_ARTICULOS:
		case ERROR_EVENTO_CONSULTA_TODOS_ARTICULOS:
			getPanelArticulo().actualizarVentanaConsultaN(evento_actual, datos);
			break;

		default:
			break;

		}
	}
	

}

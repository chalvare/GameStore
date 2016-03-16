package presentacion.articulo.gui;

import presentacion.articulo.paneles.PanelArticulo;
import presentacion.comando.IDEventos;

public abstract class ArticuloGUI {
	
	private static ArticuloGUI ArticuloGUIInstance;

	public abstract void update(IDEventos evento_actual, Object datos);

	public static ArticuloGUI getInstance() {

		createArticuloGUI();

		return ArticuloGUIInstance;
	}

	private static synchronized void createArticuloGUI() {

		if (ArticuloGUIInstance == null) {
			ArticuloGUIInstance = new ArticuloGUIImp();
		}
	}
	
	public abstract PanelArticulo getPanelArticulo();

}

package presentacion.trabajador.gui;

import presentacion.comando.IDEventos;
import presentacion.trabajador.paneles.PanelTrabajador;

public abstract class TrabajadorGUI {
	
	private static TrabajadorGUI TrabajadorGUIInstance;

	public abstract void update(IDEventos evento_actual, Object datos);

	public static TrabajadorGUI getInstance() {

		createTrabajadorGUI();

		return TrabajadorGUIInstance;
	}

	private static synchronized void createTrabajadorGUI() {

		if (TrabajadorGUIInstance == null) {
			TrabajadorGUIInstance = new TrabajadorGUIImp();
		}
	}
	
	public abstract PanelTrabajador getPanelTrabajador();

}

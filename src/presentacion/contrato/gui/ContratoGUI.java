package presentacion.contrato.gui;

import presentacion.comando.IDEventos;
import presentacion.contrato.paneles.PanelContrato;

public abstract class ContratoGUI {

	private static ContratoGUI ContratoGUIInstance;

	public abstract void update(IDEventos evento_actual, Object datos);

	public static ContratoGUI getInstance() {

		createContratoGUI();

		return ContratoGUIInstance;
	}

	private static synchronized void createContratoGUI() {

		if (ContratoGUIInstance == null) {
			ContratoGUIInstance = new ContratoGUIImp();
		}
	}
	
	public abstract PanelContrato getPanelContrato();
	
}

package presentacion.departamento.gui;

import presentacion.comando.IDEventos;
import presentacion.departamento.paneles.PanelDepartamento;

public abstract class DepartamentoGUI {
	
	private static DepartamentoGUI DepartamentoGUIInstance;

	public abstract void update(IDEventos evento_actual, Object datos);

	public static DepartamentoGUI getInstance() {

		createDepartamentoGUI();

		return DepartamentoGUIInstance;
	}

	private static synchronized void createDepartamentoGUI() {

		if (DepartamentoGUIInstance == null) {
			DepartamentoGUIInstance = new DepartamentoGUIImp();
		}
	}
	
	public abstract PanelDepartamento getPanelDepartamento();
}

package presentacion.controlador;

import presentacion.comando.Comando;
import presentacion.comando.IDEventos;
import presentacion.comando.comandoFactory.CommandFactory;
import presentacion.comando.comandoFactory.CommandResponse;

public class ControladorImp extends Controlador{
	
	
	public void handleRequest(IDEventos evento, Object datos) {
		Comando c = CommandFactory.getInstancia().nuevoComando(evento);
		CommandResponse rc = c.ejecutar(datos);
		Dispatcher.getInstance().redirect(rc);
	}
	

}

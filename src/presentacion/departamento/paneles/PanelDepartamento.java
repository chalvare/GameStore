/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.departamento.paneles;

import integracion.transacciones.conexion.ExcepcionSQL;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import negocio.cliente.TransferCliente;
import negocio.departamento.TransferDepartamento;
import presentacion.articulo.paneles.*;
import presentacion.cliente.paneles.*;
import presentacion.comando.IDEventos;
import presentacion.controlador.Controlador;

/**
 *
 * @author ReplacedKevin
 */
public class PanelDepartamento extends javax.swing.JPanel {

    /**
     * Creates new form PanelAltaCliente
     */
    public PanelDepartamento() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        panelDepartamento = new javax.swing.JTabbedPane();
        altaDepartamento = new javax.swing.JPanel();
        etiqNombreA = new javax.swing.JLabel();
        nombreA = new javax.swing.JTextField();
        enviarA = new javax.swing.JButton();
        bajaDepartamento = new javax.swing.JPanel();
        enviarB = new javax.swing.JButton();
        lineaB = new javax.swing.JSeparator();
        borraB = new javax.swing.JButton();
        idDepartamentoBuscarB = new javax.swing.JTextField();
        etiqIDB = new javax.swing.JLabel();
        etiqNombreB = new javax.swing.JLabel();
        nombreB = new javax.swing.JTextField();
        actualizarDepartamento = new javax.swing.JPanel();
        etiqNombreAc = new javax.swing.JLabel();
        lineaAc = new javax.swing.JSeparator();
        actualizaAc = new javax.swing.JButton();
        nuevaAc = new javax.swing.JButton();
        idDepartamentoBuscarAc = new javax.swing.JTextField();
        etiqIDAc = new javax.swing.JLabel();
        enviarAc1 = new javax.swing.JButton();
        nombreAc = new javax.swing.JTextField();
        lineaAc1 = new javax.swing.JSeparator();
        consultaDepartamento = new javax.swing.JPanel();
        nombreC = new javax.swing.JTextField();
        enviarC = new javax.swing.JButton();
        lineaB1 = new javax.swing.JSeparator();
        idDepartamentoBuscarC = new javax.swing.JTextField();
        etiqIDC = new javax.swing.JLabel();
        etiqNombreC = new javax.swing.JLabel();
        consultaNDepartamento = new javax.swing.JPanel();
        scrollConsultaN = new javax.swing.JScrollPane();
        etiqIDCN = new javax.swing.JLabel();
        etiqNombreCN = new javax.swing.JLabel();
        enviarCN = new javax.swing.JButton();
        list = new JList<TransferDepartamento>();
        scrollConsultaN = new javax.swing.JScrollPane(list);

        etiqNombreA.setText("Nombre:");

        

        enviarA.setText("Enviar");
        enviarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout altaDepartamentoLayout = new javax.swing.GroupLayout(altaDepartamento);
        altaDepartamento.setLayout(altaDepartamentoLayout);
        altaDepartamentoLayout.setHorizontalGroup(
            altaDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(altaDepartamentoLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(etiqNombreA)
                .addGap(18, 18, 18)
                .addComponent(nombreA, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                .addComponent(enviarA)
                .addGap(91, 91, 91))
        );
        altaDepartamentoLayout.setVerticalGroup(
            altaDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(altaDepartamentoLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(altaDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqNombreA)
                    .addComponent(nombreA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enviarA))
                .addContainerGap(297, Short.MAX_VALUE))
        );

        panelDepartamento.addTab("Alta", altaDepartamento);

        enviarB.setText("Buscar");
        enviarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarBActionPerformed(evt);
            }
        });

        lineaB.setBackground(new java.awt.Color(0, 0, 0));

        borraB.setText("Borrar");
        borraB.setEnabled(false);
        borraB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borraBActionPerformed(evt);
            }
        });

        etiqIDB.setText("ID:");

        etiqNombreB.setText("Nombre:");

        nombreB.setEditable(false);
        

        javax.swing.GroupLayout bajaDepartamentoLayout = new javax.swing.GroupLayout(bajaDepartamento);
        bajaDepartamento.setLayout(bajaDepartamentoLayout);
        bajaDepartamentoLayout.setHorizontalGroup(
            bajaDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bajaDepartamentoLayout.createSequentialGroup()
                .addGroup(bajaDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bajaDepartamentoLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(etiqIDB)
                        .addGap(26, 26, 26)
                        .addComponent(idDepartamentoBuscarB, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(enviarB))
                    .addGroup(bajaDepartamentoLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(etiqNombreB)
                        .addGap(29, 29, 29)
                        .addComponent(nombreB, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                        .addComponent(borraB)))
                .addGap(119, 119, 119))
            .addGroup(bajaDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bajaDepartamentoLayout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(lineaB)
                    .addGap(2, 2, 2)))
        );
        bajaDepartamentoLayout.setVerticalGroup(
            bajaDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bajaDepartamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bajaDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enviarB)
                    .addComponent(idDepartamentoBuscarB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiqIDB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                .addGroup(bajaDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqNombreB)
                    .addComponent(nombreB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(borraB))
                .addGap(92, 92, 92))
            .addGroup(bajaDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bajaDepartamentoLayout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addComponent(lineaB, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(327, Short.MAX_VALUE)))
        );

        panelDepartamento.addTab("Baja", bajaDepartamento);

        etiqNombreAc.setText("Nombre:");

        lineaAc.setBackground(new java.awt.Color(0, 0, 0));

        actualizaAc.setText("Actualizar");
        actualizaAc.setEnabled(false);
        actualizaAc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizaAcActionPerformed(evt);
            }
        });

        nuevaAc.setText("Nueva Busqueda");

        etiqIDAc.setText("ID:");

        enviarAc1.setText("Buscar");

        nombreAc.setEditable(false);

        lineaAc1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout actualizarDepartamentoLayout = new javax.swing.GroupLayout(actualizarDepartamento);
        actualizarDepartamento.setLayout(actualizarDepartamentoLayout);
        actualizarDepartamentoLayout.setHorizontalGroup(
            actualizarDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actualizarDepartamentoLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(actualizarDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(actualizarDepartamentoLayout.createSequentialGroup()
                        .addComponent(etiqIDAc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idDepartamentoBuscarAc, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(enviarAc1))
                    .addGroup(actualizarDepartamentoLayout.createSequentialGroup()
                        .addComponent(etiqNombreAc)
                        .addGap(18, 18, 18)
                        .addComponent(nombreAc, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(actualizarDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nuevaAc)
                    .addComponent(actualizaAc))
                .addGap(33, 33, 33))
            .addGroup(actualizarDepartamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lineaAc1)
                .addContainerGap())
            .addGroup(actualizarDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(actualizarDepartamentoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lineaAc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        actualizarDepartamentoLayout.setVerticalGroup(
            actualizarDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, actualizarDepartamentoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(actualizarDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevaAc)
                    .addComponent(enviarAc1)
                    .addComponent(idDepartamentoBuscarAc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiqIDAc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lineaAc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                .addGroup(actualizarDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqNombreAc)
                    .addComponent(nombreAc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actualizaAc))
                .addGap(108, 108, 108))
            .addGroup(actualizarDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(actualizarDepartamentoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lineaAc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panelDepartamento.addTab("Actualiza", actualizarDepartamento);

        nombreC.setEditable(false);
       

        enviarC.setText("Buscar");
        enviarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarCActionPerformed(evt);
            }
        });

        lineaB1.setBackground(new java.awt.Color(0, 0, 0));

        etiqIDC.setText("ID:");

        etiqNombreC.setText("Nombre:");

        javax.swing.GroupLayout consultaDepartamentoLayout = new javax.swing.GroupLayout(consultaDepartamento);
        consultaDepartamento.setLayout(consultaDepartamentoLayout);
        consultaDepartamentoLayout.setHorizontalGroup(
            consultaDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, consultaDepartamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(consultaDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(consultaDepartamentoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(consultaDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(etiqNombreC)
                            .addComponent(etiqIDC))
                        .addGap(18, 18, 18)
                        .addGroup(consultaDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(consultaDepartamentoLayout.createSequentialGroup()
                                .addComponent(idDepartamentoBuscarC, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(enviarC))
                            .addComponent(nombreC, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(234, 234, 234))
                    .addGroup(consultaDepartamentoLayout.createSequentialGroup()
                        .addComponent(lineaB1)
                        .addContainerGap())))
        );
        consultaDepartamentoLayout.setVerticalGroup(
            consultaDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consultaDepartamentoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(consultaDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqIDC)
                    .addComponent(idDepartamentoBuscarC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enviarC))
                .addGap(23, 23, 23)
                .addComponent(lineaB1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                .addGroup(consultaDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiqNombreC))
                .addGap(83, 83, 83))
        );

        panelDepartamento.addTab("Consulta (1)", consultaDepartamento);

        etiqIDCN.setText("ID");

        etiqNombreCN.setText("Nombre");

        enviarCN.setText("Enviar");
        enviarCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarCNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout consultaNDepartamentoLayout = new javax.swing.GroupLayout(consultaNDepartamento);
        consultaNDepartamento.setLayout(consultaNDepartamentoLayout);
        consultaNDepartamentoLayout.setHorizontalGroup(
            consultaNDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollConsultaN)
            .addGroup(consultaNDepartamentoLayout.createSequentialGroup()
                .addGroup(consultaNDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(consultaNDepartamentoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(etiqIDCN)
                        .addGap(37, 37, 37)
                        .addComponent(etiqNombreCN))
                    .addGroup(consultaNDepartamentoLayout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(enviarCN)))
                .addContainerGap(262, Short.MAX_VALUE))
        );
        consultaNDepartamentoLayout.setVerticalGroup(
            consultaNDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, consultaNDepartamentoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(consultaNDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqIDCN)
                    .addComponent(etiqNombreCN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollConsultaN, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(enviarCN)
                .addContainerGap())
        );

        panelDepartamento.addTab("Consulta (N)", consultaNDepartamento);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDepartamento)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDepartamento)
        );
    }// </editor-fold>                        

                                           
    /////////// ALTA DEPARTAMENTO ///////////////
    private void enviarAActionPerformed(java.awt.event.ActionEvent evt) {                                        
       
		TransferDepartamento departamento = new TransferDepartamento(); 
    	
		if ( !nombreA.getText().equals("")){
    		 
    		departamento.setNombre(nombreA.getText());
    		
    		Controlador.getInstance().handleRequest(IDEventos.EVENTO_ALTA_DEPARTAMENTO, departamento);
    	}
    	else
    	{
    		JFrame frame = new JFrame();
    		JOptionPane.showMessageDialog(frame,"Tienes que rellenar todos los campos", "Aviso", JOptionPane.WARNING_MESSAGE);
    	}
    	
       
    }                                       

                                           
    /////////////// BORRAR DEPARTAMENTO //////////////////
    private void enviarBActionPerformed(java.awt.event.ActionEvent evt) {                                        
    	
    	String id = idDepartamentoBuscarB.getText();

    	if ( !id.equals("") ) {
    		Controlador controlador = Controlador.getInstance();
    		controlador.handleRequest(IDEventos.EVENTO_CONSULTA_DEPARTAMENTO_BAJA, Integer.valueOf(id));
    	}
    	else {
    		JFrame frame = new JFrame();
    		JOptionPane.showMessageDialog(frame,"Tienes que rellenar el ID", "Aviso", JOptionPane.WARNING_MESSAGE);
    	}
    }                                                 

    private void borraBActionPerformed(java.awt.event.ActionEvent evt){
    	
    	if ( idDepartamento != null )
			Controlador.getInstance().handleRequest(IDEventos.EVENTO_BAJA_DEPARTAMENTO, idDepartamento);
    	
		else
		{
    		JFrame frame = new JFrame();
    		JOptionPane.showMessageDialog(frame,"Error al cargar el departamento", "Error", JOptionPane.ERROR_MESSAGE);
		}
    }
    
    	
    	
    	
    /////////////// ACTUALIZAR DEPARTAMENTO ///////////////
    private void enviarAcActionPerformed(java.awt.event.ActionEvent evt) {   

    	idDepartamentoBuscarAc.setEditable(false); //Textfield

    	String id = idDepartamentoBuscarAc.getText();	
    	
    	if ( !id.equals("") ) {
    		
    		Controlador.getInstance().handleRequest(IDEventos.EVENTO_CONSULTA_DEPARTAMENTO_MODIFICAR, Integer.valueOf(id));
		}
		else
		{
			JFrame frame = new JFrame();
    		JOptionPane.showMessageDialog(frame,"Tienes que rellenar el ID", "Aviso", JOptionPane.WARNING_MESSAGE);
		}
    	
    }                                        

    private void nuevaAcActionPerformed(java.awt.event.ActionEvent evt) {

    	idDepartamento = null;
    	nombreAc.setText("");
    	nombreAc.setEditable(false);
    }

    private void actualizaAcActionPerformed(java.awt.event.ActionEvent evt) {

    	idDepartamentoBuscarAc.setEditable(false);

    	TransferDepartamento departamento = new TransferDepartamento();

    	if ( idDepartamento != null 
    			&& !nombreAc.getText().equals("")) {

    		departamento.setNombre(nombreAc.getText());
    		
    		Controlador.getInstance().handleRequest(IDEventos.EVENTO_MODIFICAR_DEPARTAMENTO, departamento);

    	}
    	else
    	{
    		JFrame frame = new JFrame();
    		JOptionPane.showMessageDialog(frame,"Tienes que rellenar todos los campos", "Aviso", JOptionPane.WARNING_MESSAGE);
    	}
    }
                                                     

    
    ////////////// CONSULTAR DEPARTAMENTO ///////////////
    private void enviarCActionPerformed(java.awt.event.ActionEvent evt) {                                        
    	
    	String id = idDepartamentoBuscarC.getText();

    	if ( !id.equals("") ) {
    		Controlador controlador = Controlador.getInstance();
    		controlador.handleRequest(IDEventos.EVENTO_CONSULTA_DEPARTAMENTO, Integer.parseInt(id));
    	}
    	else {
    		JFrame frame = new JFrame();
    		JOptionPane.showMessageDialog(frame,"Tienes que rellenar el ID", "Aviso", JOptionPane.WARNING_MESSAGE);
    	}
    }                                       

    
    //////////////CONSULTAR N CLIENTES ///////////////////
    private void enviarCNActionPerformed(java.awt.event.ActionEvent evt){

    	Controlador.getInstance().handleRequest(IDEventos.EVENTO_CONSULTA_TODOS_DEPARMENTOS, null);
    }
    
    
    public void actualizarVentanaAlta(IDEventos idEvento, Object datos) {
		
		if ( IDEventos.EVENTO_ALTA_DEPARTAMENTO == idEvento ) {
			
			if(datos instanceof Boolean)
			{
				Boolean correcto = (Boolean) datos;
				
				if (correcto) {
					
					JFrame frame = new JFrame();
		    		JOptionPane.showMessageDialog(frame,"Departamento creado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		    		
		    		nombreA.setText(""); 
				}
				else {
					JFrame frame = new JFrame();
		    		JOptionPane.showMessageDialog(frame,"Error al crear el departamento", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else if ( IDEventos.ERROR_EVENTO_ALTA_DEPARTAMENTO == idEvento ) {
			
			if ( datos instanceof ExcepcionSQL ) {
				
				JFrame frame = new JFrame();
	    		JOptionPane.showMessageDialog(frame,((ExcepcionSQL)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame, "Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
    
    public void actualizarVentanaConsulta(IDEventos idEvento, Object datos) {
		
		if ( IDEventos.EVENTO_CONSULTA_DEPARTAMENTO == idEvento ) {
		
			if ( datos instanceof TransferDepartamento) {
				
				TransferDepartamento departamento = (TransferDepartamento) datos;
				
				if ( departamento != null ) {
					nombreC.setText(departamento.getNombre());	
				}
					
			}
			else {
				JFrame frame = new JFrame();
	    		JOptionPane.showMessageDialog(frame,"Error al consultar el departamento", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if ( IDEventos.ERROR_EVENTO_CONSULTA_DEPARTAMENTO == idEvento ) {
			
			if ( datos instanceof ExcepcionSQL ) {
				
				JFrame frame = new JFrame();
	    		JOptionPane.showMessageDialog(frame,((ExcepcionSQL)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				
				JFrame frame = new JFrame();
	    		JOptionPane.showMessageDialog(frame,"Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
    
    public void actualizarVentanaActualiza(IDEventos idEvento, Object datos){
	    
    	if ( IDEventos.EVENTO_MODIFICAR_DEPARTAMENTO == idEvento ) {
			
			if ( datos instanceof Boolean ) {
				
				Boolean correcto = (Boolean) datos;
				
				if (correcto) {
					
					nombreAc.setText("");
					nombreAc.setEditable(false);
					
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "Departamento modificado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "El departamento no se ha modificado", "Error", JOptionPane.ERROR_MESSAGE);
				}
				idDepartamento = null;
			}
		}
		else if ( IDEventos.EVENTO_CONSULTA_DEPARTAMENTO_MODIFICAR == idEvento ) {
			
			if ( datos instanceof TransferDepartamento) {
				
				TransferDepartamento departamento = (TransferDepartamento) datos;
				
				nombreAc.setText(departamento.getNombre());
				nombreAc.setEditable(true);				
			}
		}
		else if ( IDEventos.ERROR_EVENTO_MODIFICAR_DEPARTAMENTO == idEvento || IDEventos.ERROR_EVENTO_CONSULTA_DEPARTAMENTO_MODIFICAR == idEvento ) {
			
			if ( datos instanceof ExcepcionSQL ) {
				
				JFrame frame = new JFrame();
	    		JOptionPane.showMessageDialog(frame,((ExcepcionSQL)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				JFrame frame = new JFrame();
	    		JOptionPane.showMessageDialog(frame,"Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
    }

    public void actualizarVentanaBorra(IDEventos idEvento, Object datos){
    	
    	if ( IDEventos.EVENTO_BAJA_DEPARTAMENTO == idEvento ) {

    		if ( datos instanceof Boolean ) {

    			Boolean correcto = (Boolean) datos;

    			if (correcto) {
    				
    				idDepartamentoBuscarB.setText("");
    				idDepartamento = null;
    				nombreB.setText("");
    				nombreB.setEditable(false);

    				JFrame frame = new JFrame();
		    		JOptionPane.showMessageDialog(frame,"Departamento borrado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    			}
    			else {

    				JFrame frame = new JFrame();
		    		JOptionPane.showMessageDialog(frame,"El departamento no se ha borrado", "Error", JOptionPane.ERROR_MESSAGE);
    			}
    		}
    	}
    	else if (IDEventos.EVENTO_CONSULTA_DEPARTAMENTO_BAJA == idEvento) {

    		if ( datos instanceof TransferDepartamento) {

    			TransferDepartamento departamento = (TransferDepartamento) datos;

    			idDepartamento = departamento.getID();
    			nombreB.setText(departamento.getNombre());
    			borraB.setEnabled(true);
    		}
    	}
    	else if ( IDEventos.ERROR_EVENTO_BAJA_DEPARTAMENTO == idEvento || IDEventos.ERROR_EVENTO_CONSULTA_DEPARTAMENTO_BAJA == idEvento ) {

    		if ( datos instanceof ExcepcionSQL ) {

    			JFrame frame = new JFrame();
    			JOptionPane.showMessageDialog(frame,((ExcepcionSQL)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
    		}
    		else {
    			JFrame frame = new JFrame();
    			JOptionPane.showMessageDialog(frame,"Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
    		}
    	}
    }
    
    public void actualizarVentanaConsultaN(IDEventos idEvento, Object datos) {

    	if ( IDEventos.EVENTO_CONSULTA_TODOS_DEPARMENTOS == idEvento ) {

    		if ( datos instanceof ArrayList) {

    			@SuppressWarnings("unchecked")
    			ArrayList<TransferDepartamento> listaDepartamentos = (ArrayList<TransferDepartamento>) datos;

    			TransferDepartamento[] clientes = new TransferDepartamento[listaDepartamentos.size()];
    			listaDepartamentos.toArray(clientes);
    			
    			list.setListData(clientes);

    		}
    		else {
    			JFrame frame = new JFrame();
	    		JOptionPane.showMessageDialog(frame,"Error al consultar todos los clientes", "Error", JOptionPane.ERROR_MESSAGE);
    		}
    	}
    	else if ( IDEventos.ERROR_EVENTO_CONSULTA_TODOS_DEPARMENTOS == idEvento ) {

    		if ( datos instanceof ExcepcionSQL ) {

    			JFrame frame = new JFrame();
    			JOptionPane.showMessageDialog(frame,((ExcepcionSQL)datos).getMensaje(), "Error", JOptionPane.ERROR_MESSAGE);
    		}
    		else {

    			JFrame frame = new JFrame();
    			JOptionPane.showMessageDialog(frame,"Error genérico", "Error", JOptionPane.ERROR_MESSAGE);
    		}
    	}
    }

    
    
    
    

    // Variables declaration - do not modify                     
    private javax.swing.JButton actualizaAc;
    private javax.swing.JPanel actualizarDepartamento;
    private javax.swing.JPanel altaDepartamento;
    private javax.swing.JPanel bajaDepartamento;
    private javax.swing.JButton borraB;
    private javax.swing.JPanel consultaDepartamento;
    private javax.swing.JPanel consultaNDepartamento;
    private javax.swing.JButton enviarA;
    private javax.swing.JButton enviarAc1;
    private javax.swing.JButton enviarB;
    private javax.swing.JButton enviarC;
    private javax.swing.JButton enviarCN;
    private javax.swing.JLabel etiqIDAc;
    private javax.swing.JLabel etiqIDB;
    private javax.swing.JLabel etiqIDC;
    private javax.swing.JLabel etiqIDCN;
    private javax.swing.JLabel etiqNombreA;
    private javax.swing.JLabel etiqNombreAc;
    private javax.swing.JLabel etiqNombreB;
    private javax.swing.JLabel etiqNombreC;
    private javax.swing.JLabel etiqNombreCN;
    private javax.swing.JTextField idDepartamentoBuscarAc;
    private javax.swing.JTextField idDepartamentoBuscarB;
    private javax.swing.JTextField idDepartamentoBuscarC;
    private javax.swing.JSeparator lineaAc;
    private javax.swing.JSeparator lineaAc1;
    private javax.swing.JSeparator lineaB;
    private javax.swing.JSeparator lineaB1;
    private javax.swing.JTextField nombreA;
    private javax.swing.JTextField nombreAc;
    private javax.swing.JTextField nombreB;
    private javax.swing.JTextField nombreC;
    private javax.swing.JButton nuevaAc;
    private javax.swing.JTabbedPane panelDepartamento;
    private javax.swing.JScrollPane scrollConsultaN;
    private Integer idDepartamento;
    private JList<TransferDepartamento> list;
}

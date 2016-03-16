/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.contrato.paneles;

import java.util.List;

import integracion.transacciones.conexion.ExcepcionSQL;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import negocio.articulo.TransferArticulo;
import negocio.contrato.TransferContrato;
import negocio.trabajador.TransferTrabajador;
import presentacion.comando.IDEventos;
import presentacion.controlador.Controlador;
import presentacion.articulo.paneles.*;
import presentacion.cliente.paneles.*;

/**
 *
 * @author ReplacedKevin
 */
public class PanelContrato extends javax.swing.JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form PanelAltaCliente
     */
    public PanelContrato() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        panelContrato = new javax.swing.JTabbedPane();
        altaContrato = new javax.swing.JPanel();
        enviarA = new javax.swing.JButton();
        etiqDescripcionA = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descripcionA = new javax.swing.JTextArea();
        actualizarContrato = new javax.swing.JPanel();
        etiqDecripcionAc = new javax.swing.JLabel();
        lineaAc = new javax.swing.JSeparator();
        actualizaAc = new javax.swing.JButton();
        nuevaAc = new javax.swing.JButton();
        idContratoBuscarAc = new javax.swing.JTextField();
        etiqIDAc = new javax.swing.JLabel();
        enviarAc = new javax.swing.JButton();
        lineaAc1 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        descripcionAc = new javax.swing.JTextArea();
        consultaContrato = new javax.swing.JPanel();
        enviarC = new javax.swing.JButton();
        lineaB1 = new javax.swing.JSeparator();
        idContratoBuscarC = new javax.swing.JTextField();
        etiqIDC = new javax.swing.JLabel();
        etiqDescripcionC = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcionC = new javax.swing.JTextArea();
        consultaContratoN = new javax.swing.JPanel();
        scrollConsultaN = new javax.swing.JScrollPane();
        etiqIDCN = new javax.swing.JLabel();
        etiqNombreCN = new javax.swing.JLabel();
        enviarCN = new javax.swing.JButton();
        list = new JList<TransferContrato>();
        scrollConsultaN = new javax.swing.JScrollPane(list);
        
        enviarA.setText("Enviar");
        enviarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarAActionPerformed(evt);
            }
        });

        etiqDescripcionA.setText("Descripcion:");

        descripcionA.setColumns(20);
        descripcionA.setRows(5);
        jScrollPane2.setViewportView(descripcionA);

        javax.swing.GroupLayout altaContratoLayout = new javax.swing.GroupLayout(altaContrato);
        altaContrato.setLayout(altaContratoLayout);
        altaContratoLayout.setHorizontalGroup(
            altaContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(altaContratoLayout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addComponent(etiqDescripcionA)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
            .addGroup(altaContratoLayout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(enviarA)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        altaContratoLayout.setVerticalGroup(
            altaContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(altaContratoLayout.createSequentialGroup()
                .addGroup(altaContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(altaContratoLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(enviarA))
                    .addGroup(altaContratoLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(etiqDescripcionA)))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        panelContrato.addTab("Alta", altaContrato);

        etiqDecripcionAc.setText("Descripcion:");

        lineaAc.setBackground(new java.awt.Color(0, 0, 0));

        actualizaAc.setText("Actualizar");
        actualizaAc.setEnabled(false);
        actualizaAc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizaAcActionPerformed(evt);
            }
        });

        nuevaAc.setText("Nueva Busqueda");
        nuevaAc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	nuevaAcActionPerformed(evt);
            }
        });
        

        etiqIDAc.setText("ID:");

        enviarAc.setText("Buscar");
        
        enviarAc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	enviarAcActionPerformed(evt);
            }
        });

        lineaAc1.setBackground(new java.awt.Color(0, 0, 0));

        descripcionAc.setColumns(20);
        descripcionAc.setRows(5);
        jScrollPane3.setViewportView(descripcionAc);

        javax.swing.GroupLayout actualizarContratoLayout = new javax.swing.GroupLayout(actualizarContrato);
        actualizarContrato.setLayout(actualizarContratoLayout);
        actualizarContratoLayout.setHorizontalGroup(
            actualizarContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actualizarContratoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(etiqIDAc)
                .addGap(18, 18, 18)
                .addComponent(idContratoBuscarAc, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(enviarAc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nuevaAc)
                .addGap(50, 50, 50))
            .addGroup(actualizarContratoLayout.createSequentialGroup()
                .addGroup(actualizarContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(actualizarContratoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lineaAc1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(actualizarContratoLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(etiqDecripcionAc)
                        .addGap(84, 84, 84)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(lineaAc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(actualizarContratoLayout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(actualizaAc)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        actualizarContratoLayout.setVerticalGroup(
            actualizarContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actualizarContratoLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(actualizarContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enviarAc)
                    .addComponent(idContratoBuscarAc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiqIDAc)
                    .addComponent(nuevaAc))
                .addGap(18, 18, 18)
                .addComponent(lineaAc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(actualizarContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(actualizarContratoLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(lineaAc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(actualizarContratoLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(actualizarContratoLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(etiqDecripcionAc)))
                .addGap(72, 72, 72)
                .addComponent(actualizaAc)
                .addGap(96, 96, 96))
        );

        panelContrato.addTab("Actualiza", actualizarContrato);

        enviarC.setText("Buscar");
        enviarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarCActionPerformed(evt);
            }
        });

        lineaB1.setBackground(new java.awt.Color(0, 0, 0));

        etiqIDC.setText("ID:");

        etiqDescripcionC.setText("Descripcion:");

        descripcionC.setColumns(20);
        descripcionC.setRows(5);
        jScrollPane1.setViewportView(descripcionC);

        javax.swing.GroupLayout consultaContratoLayout = new javax.swing.GroupLayout(consultaContrato);
        consultaContrato.setLayout(consultaContratoLayout);
        consultaContratoLayout.setHorizontalGroup(
            consultaContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, consultaContratoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(consultaContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(consultaContratoLayout.createSequentialGroup()
                        .addGroup(consultaContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(consultaContratoLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(etiqIDC)
                                .addGap(45, 45, 45)
                                .addComponent(idContratoBuscarC, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(enviarC))
                            .addGroup(consultaContratoLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(etiqDescripcionC)
                                .addGap(41, 41, 41)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(175, 175, 175))
                    .addGroup(consultaContratoLayout.createSequentialGroup()
                        .addComponent(lineaB1)
                        .addContainerGap())))
        );
        consultaContratoLayout.setVerticalGroup(
            consultaContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consultaContratoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(consultaContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqIDC)
                    .addComponent(idContratoBuscarC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enviarC))
                .addGap(23, 23, 23)
                .addComponent(lineaB1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(consultaContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(consultaContratoLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(consultaContratoLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(etiqDescripcionC)))
                .addContainerGap(162, Short.MAX_VALUE))
        );

        panelContrato.addTab("Consulta (1)", consultaContrato);

        etiqIDCN.setText("ID");

        etiqNombreCN.setText("Nombre");

        enviarCN.setText("Enviar");
        enviarCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarCNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout consultaContratoNLayout = new javax.swing.GroupLayout(consultaContratoN);
        consultaContratoN.setLayout(consultaContratoNLayout);
        consultaContratoNLayout.setHorizontalGroup(
            consultaContratoNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollConsultaN)
            .addGroup(consultaContratoNLayout.createSequentialGroup()
                .addGroup(consultaContratoNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(consultaContratoNLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(etiqIDCN)
                        .addGap(37, 37, 37)
                        .addComponent(etiqNombreCN))
                    .addGroup(consultaContratoNLayout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(enviarCN)))
                .addContainerGap(289, Short.MAX_VALUE))
        );
        consultaContratoNLayout.setVerticalGroup(
            consultaContratoNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, consultaContratoNLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(consultaContratoNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqIDCN)
                    .addComponent(etiqNombreCN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollConsultaN, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(enviarCN)
                .addContainerGap())
        );

        panelContrato.addTab("Consulta (N)", consultaContratoN);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContrato)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContrato)
        );
    }// </editor-fold>                        
                        

    
    //////////////// ALTA CONTRATO ////////////////////     
    
    private void enviarAActionPerformed(java.awt.event.ActionEvent evt) {                                        
       

    	TransferContrato contrato = new TransferContrato(); 
    
    	if (!descripcionA.getText().equals("")){
    		contrato.setDescripcion(descripcionA.getText());
    		Controlador.getInstance().handleRequest(IDEventos.EVENTO_ALTA_CONTRATO, contrato);
    	}
    	else
    	{
    		JFrame frame = new JFrame();
    		JOptionPane.showMessageDialog(frame,"Tienes que rellenar todos los campos", "Aviso", JOptionPane.WARNING_MESSAGE);
    	}
    	
        
    }                                       

    
    ///////////// ACTUALIZAR CONTRATO /////////////
    private void enviarAcActionPerformed(java.awt.event.ActionEvent evt) {   
    	
    	idContratoBuscarAc.setEditable(false);//Textfield
		String id = idContratoBuscarAc.getText();	
		
		if ( !id.equals("") ) {
			Controlador.getInstance().handleRequest(IDEventos.EVENTO_CONSULTA_MODIFICAR_CONTRATO, Integer.valueOf(id));
		}
		else
		{
			JFrame frame = new JFrame();
    		JOptionPane.showMessageDialog(frame,"Tienes que rellenar el ID", "Aviso", JOptionPane.WARNING_MESSAGE);
		}
    }                                        
    
    private void nuevaAcActionPerformed(java.awt.event.ActionEvent evt) {
    	
    	idContrato = null;
    	
    	idContratoBuscarAc.setText("");
    	idContratoBuscarAc.setEditable(true);
		
    	descripcionAc.setText("");
    	descripcionAc.setEditable(false);
    	actualizaAc.setEnabled(false);
		
    }
    
    private void actualizaAcActionPerformed(java.awt.event.ActionEvent evt) {
    	
    	idContratoBuscarAc.setEditable(false);
		
		TransferContrato contrato = new TransferContrato();
		
		if ( idContrato != null 
			&& !descripcionAc.getText().equals("")) {
			
			contrato.setID(idContrato);
			contrato.setDescripcion(descripcionAc.getText());
			
			Controlador.getInstance().handleRequest(IDEventos.EVENTO_MODIFICAR_CONTRATO, contrato);	
		}
		else
    	{
    		JFrame frame = new JFrame();
    		JOptionPane.showMessageDialog(frame,"Tienes que rellenar todos los campos", "Aviso", JOptionPane.WARNING_MESSAGE);
    	}
    }  
    

    /////////// CONSULTAR CONTRATO /////////////

    private void enviarCActionPerformed(java.awt.event.ActionEvent evt) {                                        
    	String id= idContratoBuscarC.getText();
    	
    	if (!id.equals("")) {
    		
    		Controlador controlador = Controlador.getInstance();
			Controlador.getInstance().handleRequest(IDEventos.EVENTO_CONSULTA_CONTRATO, Integer.valueOf(id));
    	}
    	else
    	{
    		JFrame frame = new JFrame();
    		JOptionPane.showMessageDialog(frame,"Tienes que rellenar el ID", "Aviso", JOptionPane.WARNING_MESSAGE);
    	}    
    }                                       

                                              
    /////////// CONSULTAR CONTRATO N /////////////
    
    private void enviarCNActionPerformed(java.awt.event.ActionEvent evt){
		
		Controlador.getInstance().handleRequest(IDEventos.EVENTO_CONSULTA_TODOS_CONTRATO, null);
    }

    
    ////////////////ACTUALIZAR///////////////////////
    
    
    public void actualizarVentanaAlta(IDEventos idEvento, Object datos) {
		
		if ( IDEventos.EVENTO_ALTA_CONTRATO == idEvento ) {
			
			if(datos instanceof Boolean)
			{
				Boolean correcto = (Boolean) datos;
				
				if (correcto) {

		    		descripcionA.setText(""); 
					
					JFrame frame = new JFrame();
		    		JOptionPane.showMessageDialog(frame,"Contrato creado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JFrame frame = new JFrame();
		    		JOptionPane.showMessageDialog(frame,"Error al crear el contrato", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else if ( IDEventos.ERROR_EVENTO_ALTA_CONTRATO == idEvento ) {
			
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
		
		if ( IDEventos.EVENTO_CONSULTA_CONTRATO == idEvento ) {
		
			if ( datos instanceof TransferContrato) {
				
				TransferContrato contrato = (TransferContrato) datos;
				
				if ( contrato != null ) {
					descripcionC.setText(contrato.getDescripcion());
				}
					
			}
			else {
				JFrame frame = new JFrame();
	    		JOptionPane.showMessageDialog(frame,"Error al consultar el contrato", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if ( IDEventos.ERROR_EVENTO_CONSULTA_CONTRATO == idEvento ) {
			
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
	    
    	if ( IDEventos.EVENTO_MODIFICAR_CONTRATO == idEvento ) {
			
			if ( datos instanceof Boolean ) {
				
				Boolean correcto = (Boolean) datos;
				
				if (correcto) {
					
					descripcionAc.setText("");
					descripcionAc.setEditable(false);
					
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "Contrato modificado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "El contrato no se ha modificado", "Error", JOptionPane.ERROR_MESSAGE);
				}
				idContrato = null;
			}
		}
		else if ( IDEventos.EVENTO_CONSULTA_MODIFICAR_CONTRATO == idEvento ) {
			
			if ( datos instanceof TransferContrato) {
				
				TransferContrato contrato = (TransferContrato) datos;
					
				idContrato = contrato.getID();
				descripcionAc.setText(contrato.getDescripcion());
				descripcionAc.setEditable(true);
				actualizaAc.setEnabled(true);
			}
		}
		else if ( IDEventos.ERROR_EVENTO_MODIFICAR_CONTRATO == idEvento || IDEventos.ERROR_EVENTO_CONSULTA_MODIFICAR_CONTRATO == idEvento ) {
			
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

    	if ( IDEventos.EVENTO_CONSULTA_TODOS_CONTRATO == idEvento ) {

    		if ( datos instanceof List) {

    			@SuppressWarnings("unchecked")
    			List<TransferContrato> listaContrato = (List<TransferContrato>) datos;

    			TransferContrato[] contrato = new TransferContrato[listaContrato.size()];
    			listaContrato.toArray(contrato);
    			list.setListData(contrato);

    		}
    		else {
    			JFrame frame = new JFrame();
	    		JOptionPane.showMessageDialog(frame,"Error al consultar todos los contratos", "Error", JOptionPane.ERROR_MESSAGE);
    		}
    	}
    	else if ( IDEventos.ERROR_EVENTO_CONSULTA_TODOS_CONTRATO== idEvento ) {

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
    private javax.swing.JPanel actualizarContrato;
    private javax.swing.JPanel altaContrato;
    private javax.swing.JPanel consultaContrato;
    private javax.swing.JPanel consultaContratoN;
    private javax.swing.JTextArea descripcionA;
    private javax.swing.JTextArea descripcionAc;
    private javax.swing.JTextArea descripcionC;
    private javax.swing.JButton enviarA;
    private javax.swing.JButton enviarAc;
    private javax.swing.JButton enviarC;
    private javax.swing.JButton enviarCN;
    private javax.swing.JLabel etiqDecripcionAc;
    private javax.swing.JLabel etiqDescripcionA;
    private javax.swing.JLabel etiqDescripcionC;
    private javax.swing.JLabel etiqIDAc;
    private javax.swing.JLabel etiqIDC;
    private javax.swing.JLabel etiqIDCN;
    private javax.swing.JLabel etiqNombreCN;
    private javax.swing.JTextField idContratoBuscarAc;
    private javax.swing.JTextField idContratoBuscarC;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator lineaAc;
    private javax.swing.JSeparator lineaAc1;
    private javax.swing.JSeparator lineaB1;
    private javax.swing.JButton nuevaAc;
    private javax.swing.JTabbedPane panelContrato;
    private javax.swing.JScrollPane scrollConsultaN;
    private JList<TransferContrato> list;
    private Integer idContrato;
    // End of variables declaration        
}

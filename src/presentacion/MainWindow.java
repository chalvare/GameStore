/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import presentacion.articulo.gui.ArticuloGUI;
import presentacion.articulo.paneles.PanelArticulo;
import presentacion.cliente.gui.ClienteGUI;
import presentacion.cliente.paneles.PanelCliente;
import presentacion.contrato.gui.ContratoGUI;
import presentacion.contrato.paneles.PanelContrato;
import presentacion.departamento.gui.DepartamentoGUI;
import presentacion.departamento.paneles.PanelDepartamento;
import presentacion.trabajador.gui.TrabajadorGUI;
import presentacion.trabajador.paneles.PanelTrabajador;
import presentacion.venta.gui.VentaGUI;
import presentacion.venta.paneles.PanelVenta;



/**
 *
 * @author ReplacedKevin
 */
public class MainWindow extends javax.swing.JFrame {
   
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private javax.swing.JButton Articulo;
	private javax.swing.JButton Cliente;
	private javax.swing.JButton Contrato;
	private javax.swing.JButton Departamento;
	private javax.swing.JButton Trabajador;
	private javax.swing.JButton Venta;
	private javax.swing.JToolBar barraBotones;
	private javax.swing.JPanel panelPrincipal;
	private PanelCliente panelCliente=ClienteGUI.getInstance().getPanelCliente();
	private PanelArticulo panelArticulo=ArticuloGUI.getInstance().getPanelArticulo();
	private PanelContrato panelContrato=ContratoGUI.getInstance().getPanelContrato();
	private PanelTrabajador panelTrabajador=TrabajadorGUI.getInstance().getPanelTrabajador();
	private PanelDepartamento panelDepartamento=DepartamentoGUI.getInstance().getPanelDepartamento();
	private PanelVenta panelVenta=VentaGUI.getInstance().getPanelVenta();
	


	public MainWindow() {
		setPreferredSize(new Dimension(900, 500));
		setMinimumSize(new Dimension(100, 100));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setTitle("GameStore For You, For Me, For Both Of Us");
		
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		setContentPane(panelPrincipal);
		
		
		barraBotones = new JToolBar();
		barraBotones.setAlignmentY(Component.CENTER_ALIGNMENT);
		barraBotones.setBackground(new Color(245, 245, 245));
		barraBotones.setMinimumSize(new Dimension(400, 400));
		barraBotones.setMaximumSize(new Dimension(500, 5));
		panelPrincipal.add(barraBotones, BorderLayout.NORTH);
		
		
		
		
		Cliente = new JButton("Cliente");
		Cliente.setAlignmentX(Component.CENTER_ALIGNMENT);
		Cliente.setVerticalAlignment(SwingConstants.CENTER);
		Cliente.setMaximumSize(new Dimension(74, 400));
		Cliente.setHorizontalTextPosition(SwingConstants.CENTER);
		Cliente.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		
		Cliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		    	panelCliente.setVisible(true);
				panelPrincipal.add(panelCliente, BorderLayout.CENTER);
				panelPrincipal.validate();
		    	paneles(0);
				
				
			}
		});
		barraBotones.add(Cliente);
		
		Articulo = new JButton("Articulo");
		Articulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		Articulo.setVerticalAlignment(SwingConstants.CENTER);
		Articulo.setMaximumSize(new Dimension(74, 400));
		Articulo.setHorizontalTextPosition(SwingConstants.CENTER);
		Articulo.setVerticalTextPosition(SwingConstants.BOTTOM);

		
		
		Articulo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				panelPrincipal.add(panelArticulo, BorderLayout.CENTER);
				panelPrincipal.validate();
		        panelArticulo.setVisible(true);
		        paneles(1);
				

			}
		});
		
		barraBotones.add(Articulo);
		
		Departamento = new JButton("Departamento");
		Departamento.setAlignmentX(Component.CENTER_ALIGNMENT);
		Departamento.setVerticalAlignment(SwingConstants.CENTER);
		Departamento.setMaximumSize(new Dimension(74, 400));
		Departamento.setHorizontalTextPosition(SwingConstants.CENTER);
		Departamento.setVerticalTextPosition(SwingConstants.BOTTOM);

		
		
		Departamento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
		        panelDepartamento.setVisible(true);
		        paneles(2);
				panelPrincipal.add(panelDepartamento, BorderLayout.CENTER);
				panelPrincipal.validate();
				
			}
		});
		barraBotones.add(Departamento);
		
		Venta = new JButton("Venta");
		Venta.setAlignmentX(Component.CENTER_ALIGNMENT);
		Venta.setVerticalAlignment(SwingConstants.CENTER);
		Venta.setMaximumSize(new Dimension(74, 400));
		Venta.setHorizontalTextPosition(SwingConstants.CENTER);
		Venta.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		
		Venta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    panelVenta.setVisible(true);
			    paneles(3);
				panelPrincipal.add(panelVenta, BorderLayout.CENTER);
				panelPrincipal.validate();
			    
				
			}
		});
		barraBotones.add(Venta);
		
		Trabajador = new JButton("Trabajador");
		Trabajador.setAlignmentX(Component.CENTER_ALIGNMENT);
		Trabajador.setVerticalAlignment(SwingConstants.CENTER);
		Trabajador.setMaximumSize(new Dimension(74, 400));
		Trabajador.setHorizontalTextPosition(SwingConstants.CENTER);
		Trabajador.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		
		Trabajador.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		        panelTrabajador.setVisible(true);
		        paneles(5);
				panelPrincipal.add(panelTrabajador, BorderLayout.CENTER);
				panelPrincipal.validate();
				
			}
		});
		barraBotones.add(Trabajador);
		
		Contrato = new JButton("Contrato");
		Contrato.setAlignmentX(Component.CENTER_ALIGNMENT);
		Contrato.setVerticalAlignment(SwingConstants.CENTER);
		Contrato.setMaximumSize(new Dimension(74, 400));
		Contrato.setHorizontalTextPosition(SwingConstants.CENTER);
		Contrato.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		
		Contrato.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelContrato.setVisible(true);
			    paneles(4);
				panelPrincipal.add(panelContrato, BorderLayout.CENTER);
				panelPrincipal.validate();
				
			}
		});
		barraBotones.add(Contrato);
		barraBotones.setFloatable(false);
		setVisible(true);
	}
	
	private void paneles(int i)
    {
    	if(i==0)
    	{
    		panelContrato.setVisible(false);
        	panelArticulo.setVisible(false);
        	panelDepartamento.setVisible(false);
        	panelVenta.setVisible(false);
        	panelTrabajador.setVisible(false);
    	}
    	else if (i==1)
    	{
    		panelContrato.setVisible(false);
        	panelCliente.setVisible(false);
        	panelDepartamento.setVisible(false);
        	panelVenta.setVisible(false);
        	panelTrabajador.setVisible(false);
    	}
    	else if (i==2)
    	{
    		panelContrato.setVisible(false);
        	panelArticulo.setVisible(false);
        	panelCliente.setVisible(false);
        	panelVenta.setVisible(false);
        	panelTrabajador.setVisible(false);
    	}
    	else if (i==3)
    	{
    		panelContrato.setVisible(false);
        	panelArticulo.setVisible(false);
        	panelCliente.setVisible(false);
        	panelDepartamento.setVisible(false);
        	panelTrabajador.setVisible(false);
    	}
    	else if (i==4)
    	{
        	panelArticulo.setVisible(false);
        	panelCliente.setVisible(false);
        	panelDepartamento.setVisible(false);
        	panelVenta.setVisible(false);
        	panelTrabajador.setVisible(false);
    	}
    	else if (i==5)
    	{
    		panelContrato.setVisible(false);
        	panelArticulo.setVisible(false);
        	panelCliente.setVisible(false);
        	panelDepartamento.setVisible(false);
        	panelVenta.setVisible(false);
    	}
    	else
    	{
    		panelContrato.setVisible(false);
        	panelArticulo.setVisible(false);
        	panelCliente.setVisible(true);
        	panelDepartamento.setVisible(false);
        	panelVenta.setVisible(false);
        	panelTrabajador.setVisible(false);
    	}
    	
    	
    }
	
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
}

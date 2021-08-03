package interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Point;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PruebasDatos extends JFrame {
	private JPanel contentPane;
	private static asistenteInterfaz asisGrafica;
	private JTable tDatos;
	private JTextField tdatos;
	private JLabel lPaciBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(asistenteInterfaz grafica) {
		asisGrafica=grafica;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin(grafica);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param asistenteInterfaz 
	 */
	public PruebasDatos(asistenteInterfaz grafica) {
		asisGrafica=grafica;
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lFunInsertar = new JLabel("Insertar");
		lFunInsertar.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lFunInsertar.setBounds(260, 227, 231, 92);
		contentPane.add(lFunInsertar);
		
		JLabel lPaciInsertar = new JLabel("Insertar");
		lPaciInsertar.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lPaciInsertar.setBounds(10, 227, 240, 92);
		contentPane.add(lPaciInsertar);
		
		JLabel lFunEliminar = new JLabel("Eliminar");
		lFunEliminar.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lFunEliminar.setBounds(260, 325, 231, 92);
		contentPane.add(lFunEliminar);
		
		JLabel lPaciEliminar = new JLabel("Eliminar");
		lPaciEliminar.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lPaciEliminar.setBounds(10, 325, 240, 92);
		contentPane.add(lPaciEliminar);
		
		JLabel lFunBuscar = new JLabel("Buscar");
		lFunBuscar.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lFunBuscar.setBounds(260, 129, 231, 92);
		contentPane.add(lFunBuscar);
		
		JLabel lblPacientes = new JLabel("Pacientes");
		lblPacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblPacientes.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPacientes.setBounds(10, 101, 226, 33);
		contentPane.add(lblPacientes);
		
		lPaciBuscar = new JLabel("Buscar");
		lPaciBuscar.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lPaciBuscar.setBounds(10, 129, 240, 92);
		contentPane.add(lPaciBuscar);
		
		JLabel lblNewLabel_3 = new JLabel("<html> Inserte el numero de datos n que quiere simular. <html>");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setToolTipText("");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(157, 10, 204, 65);
		contentPane.add(lblNewLabel_3);
		
		tdatos = new JTextField();
		tdatos.setText("0");
		tdatos.setColumns(10);
		tdatos.setBounds(167, 71, 166, 20);
		contentPane.add(tdatos);
		
		tDatos = new JTable(null,new String[] {
				"Nombre", "Cedula"
			});
		tDatos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
			},
			new String[] {
				"Nombre", "Cedula"
			}
		));
		tDatos.setBounds(284, 83, 216, 330);
		
		
		JButton btnEjecutar = new JButton("Ejecutar");
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Agregar				
				try {
					asisGrafica.TpacientesAgregar(Integer.valueOf(tdatos.getText()));
					int tiempo =asisGrafica.TpacientesAgregar(1);
					lPaciInsertar.setText("<html>Pacientes creados con exito<p>Tiempo requerido: <html>"+tiempo+" milisegundos.");
					}
					catch(NullPointerException e1) {
						System.out.println(" Campo vacio || dato invalido ");
						lPaciInsertar.setText("Dato invalido PacIns ");
					}
					try {
						asisGrafica.TfuncionariosAgregar(Integer.valueOf(tdatos.getText()));
						int tiempo1 = asisGrafica.TfuncionariosAgregar(1);
						lFunInsertar.setText("<html>Funcionarios creados con exito<p>Tiempo requerido: <html>"+tiempo1+" milisegundos.");
					}
					catch(NullPointerException e1) {
						System.out.println(" Campo vacio || dato invalido ");
						lFunInsertar.setText("Dato invalido FunIns ");
					}
				//Buscar	
				try {
						int tiempo =asisGrafica.TpacientesBuscar(1);
						lPaciBuscar.setText("<html>Paciente encontrado con exito<p>Tiempo requerido: <html>"+tiempo+" milisegundos.");
						}
						catch(NullPointerException e1) {
							System.out.println(" Campo vacio || dato invalido ");
							lPaciBuscar.setText("Dato invalido PacBus ");
						}
						try {
							int tiempo1 = asisGrafica.TfuncionariosBuscar(1);
							lFunBuscar.setText("<html>Funcionario encontrado con exito<p>Tiempo requerido: <html>"+tiempo1+" milisegundos.");
						}
						catch(NullPointerException e1) {
							System.out.println(" Campo vacio || dato invalido ");
							lFunBuscar.setText("Dato invalido FunBus ");
						}
					
				//Eliminar
				try {
					int tiempo =asisGrafica.TpacientesEliminar(1);
					asisGrafica.TpacientesEliminar(Integer.valueOf(tdatos.getText()));
					lPaciEliminar.setText("<html>Pacientes eliminados con exito<p>Tiempo requerido: <html>"+tiempo+" milisegundos.");
					}
					catch(NullPointerException e1) {
						System.out.println(" Campo vacio || dato invalido ");
						lPaciEliminar.setText("Dato invalido PacElim");
					}
				try {
						int tiempo1 = asisGrafica.TfuncionariosEliminar(1);
						asisGrafica.TfuncionariosEliminar(Integer.valueOf(tdatos.getText()));
						lFunEliminar.setText("<html>Funcionarios eliminados con exito<p>Tiempo requerido: <html>"+tiempo1+" milisegundos.");
					}
					catch(NullPointerException e1) {
						System.out.println(" Campo vacio || dato invalido ");
						lFunEliminar.setText("Dato invalido FunElim");
					}

				limpiar();
	
			}
		});
		
		btnEjecutar.setBorderPainted(false);
		btnEjecutar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnEjecutar.setBackground(new Color(2, 167, 220));
		btnEjecutar.setForeground(Color.BLACK);
		btnEjecutar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnEjecutar.setBounds(387, 67, 72, 23);
		contentPane.add(btnEjecutar);
		
		JLabel lblFuncionarios = new JLabel("Funcionarios");
		lblFuncionarios.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblFuncionarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuncionarios.setBounds(274, 101, 226, 33);
		contentPane.add(lblFuncionarios);
		
		JButton btnSalir = new JButton("Regresar");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
				asisGrafica.returnScreen();
			}
		});
		btnSalir.setVerifyInputWhenFocusTarget(false);
		btnSalir.setSelected(true);
		btnSalir.setRolloverEnabled(false);
		btnSalir.setRequestFocusEnabled(false);
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSalir.setFocusable(false);
		btnSalir.setFocusTraversalKeysEnabled(false);
		btnSalir.setFocusPainted(false);
		btnSalir.setDefaultCapable(false);
		btnSalir.setBorderPainted(false);
		btnSalir.setBorder(new LineBorder(new Color(0, 255, 255), 2, true));
		btnSalir.setBackground(new Color(175, 238, 238));
		btnSalir.setBounds(10, 10, 100, 33);
		contentPane.add(btnSalir);
		
		JLabel lblFecha = new JLabel("Tue May 25 19:58:55 COT 2021");
		lblFecha.setBounds(10, 407, 147, 33);
		contentPane.add(lblFecha);
		
		JLabel lblfondoAdmin = new JLabel("");
		lblfondoAdmin.setIcon(new ImageIcon(admin.class.getResource("/imagenes/fondoAdmin.jpg")));
		lblfondoAdmin.setBounds(0, -51, 522, 543);
		contentPane.add(lblfondoAdmin);
	}
	void limpiar() {
		//tdatos.setText("0");
		
	}
}
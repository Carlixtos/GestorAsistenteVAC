package gestorAsistenteVAC.interfaz;

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


public class Pruebasiteradas extends JFrame {
	private JPanel contentPane;
	private static asistenteInterfaz asisGrafica;
	private JTable tDatos;
	private JTextField tnumFuncionarios;
	private JTextField tnumPacientes;
	private JLabel lAvisoPacientes;

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
	public Pruebasiteradas(asistenteInterfaz grafica) {
		asisGrafica=grafica;
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JLabel lblNewLabel_3_1 = new JLabel("<html> Inserte el numero de funcionarios que quiere agregar o eliminar.<html>");
		lblNewLabel_3_1.setToolTipText("");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(250, 108, 220, 65);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lAvisoFuncionarios = new JLabel("  ");
		lAvisoFuncionarios.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lAvisoFuncionarios.setBounds(250, 211, 231, 92);
		contentPane.add(lAvisoFuncionarios);
		
		JLabel lblPacientes = new JLabel("Pacientes");
		lblPacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblPacientes.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPacientes.setBounds(-13, 65, 226, 33);
		contentPane.add(lblPacientes);
		
		lAvisoPacientes = new JLabel("  ");
		lAvisoPacientes.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lAvisoPacientes.setBounds(20, 211, 240, 92);
		contentPane.add(lAvisoPacientes);
		
		JLabel lblNewLabel_3 = new JLabel("<html> Inserte el numero de pacientes que quiere agregar o eliminar.<html>");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setToolTipText("");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(20, 108, 220, 65);
		contentPane.add(lblNewLabel_3);
		
		tnumPacientes = new JTextField();
		tnumPacientes.setText("0");
		tnumPacientes.setColumns(10);
		tnumPacientes.setBounds(20, 181, 166, 20);
		contentPane.add(tnumPacientes);
		
		tnumFuncionarios = new JTextField();
		tnumFuncionarios.setText("0");
		tnumFuncionarios.setBounds(250, 181, 166, 20);
		contentPane.add(tnumFuncionarios);
		tnumFuncionarios.setColumns(10);
		
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
		
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int tiempo =asisGrafica.TpacientesEliminar(Integer.valueOf(tnumPacientes.getText()));
					lAvisoPacientes.setText("<html>Pacientes eliminados con exito<p>Tiempo requerido: <html>"+tiempo+" milisegundos.");
					}
					catch(NullPointerException e1) {
						System.out.println(" Campo vacio || dato invalido ");
						lAvisoPacientes.setText(" Campo vacio || dato invalido ");
					}
					try {
						int tiempo1 = asisGrafica.TfuncionariosEliminar(Integer.valueOf(tnumFuncionarios.getText()));
						lAvisoFuncionarios.setText("<html>Funcionarios eliminados con exito<p>Tiempo requerido: <html>"+tiempo1+" milisegundos.");
					}
					catch(NullPointerException e1) {
						System.out.println(" Campo vacio || dato invalido ");
						lAvisoFuncionarios.setText(" Campo vacio || dato invalido ");
					}
				limpiar();
	
			}
		});
		
		btnEliminar.setBorderPainted(false);
		btnEliminar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnEliminar.setBackground(new Color(2, 167, 220));
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnEliminar.setBounds(428, 384, 72, 23);
		contentPane.add(btnEliminar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int tiempo =asisGrafica.TpacientesAgregar(Integer.valueOf(tnumPacientes.getText()));
				lAvisoPacientes.setText("<html>Pacientes creados con exito<p>Tiempo requerido: <html>"+tiempo+" milisegundos. ");
				}
				catch(NullPointerException e1) {
					System.out.println(" Campo vacio || dato invalido ");
					lAvisoPacientes.setText(" Campo vacio || dato invalido ");
				}
				try {
					int tiempo1 = asisGrafica.TfuncionariosAgregar(Integer.valueOf(tnumFuncionarios.getText()));
					lAvisoFuncionarios.setText("<html>Funcionarios creados con exito<p>Tiempo requerido: <html>"+tiempo1+" milisegundos.");
				}
				catch(NullPointerException e1) {
					System.out.println(" Campo vacio || dato invalido ");
					lAvisoFuncionarios.setText(" Campo vacio || dato invalido ");
				}
				limpiar();
				
			}
		});
		btnAgregar.setBackground(new Color(2, 167, 220));
		btnAgregar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAgregar.setBorderPainted(false);
		btnAgregar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnAgregar.setBounds(346, 384, 72, 23);
		contentPane.add(btnAgregar);
		
		JLabel lblNewLabel = new JLabel("Funcionarios");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(259, 65, 226, 33);
		contentPane.add(lblNewLabel);
		
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
		lblfondoAdmin.setIcon(new ImageIcon(admin.class.getResource("/gestorAsistenteVAC/imagenes/fondoAdmin.jpg")));
		lblfondoAdmin.setBounds(0, -51, 522, 543);
		contentPane.add(lblfondoAdmin);
	}
	void limpiar() {
		tnumFuncionarios.setText("0");
		tnumPacientes.setText("0");
		
	}
}
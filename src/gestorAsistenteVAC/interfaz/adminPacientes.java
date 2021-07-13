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


public class adminPacientes extends JFrame {
	private JPanel contentPane;
	private static asistenteInterfaz asisGrafica;
	private JTable table;
	private JTextField tNombre;
	private JTextField tApellido;
	private JTextField tDocumento;
	private JTextField tTdocumento;
	private JTextField tEdad;
	private JTextField tGenero;
	private JTextField tSangre;
	private JTextField tTvacuna;
	private JTextField tDosis;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JLabel lblNewLabel_20;
	private JLabel lblNewLabel_21;

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
	public adminPacientes(asistenteInterfaz grafica) {
		asisGrafica=grafica;
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccion=table.getSelectedRow();
				table.setValueAt(tNombre.getText(),seleccion, 0);
				table.setValueAt(tApellido.getText(),seleccion, 1);
				table.setValueAt(tEdad.getText(),seleccion, 2);
				table.setValueAt(tGenero.getText(),seleccion, 3);
				table.setValueAt(tTdocumento.getText(),seleccion, 4);
				table.setValueAt(tDocumento.getText(),seleccion, 5);
				table.setValueAt(tSangre.getText(),seleccion, 6);
				table.setValueAt("Paciente",seleccion, 7);
				table.setValueAt(tTvacuna.getText(),seleccion, 8);
				table.setValueAt(tDosis.getText(),seleccion, 9);
				limpiar();
			//	actualizarTabla(table,asisGrafica.getDatos());
			}
		});
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccion=table.getSelectedRow();
				((DefaultTableModel) table.getModel()).removeRow(seleccion);
				limpiar();
				
			}
		});
		
		lblNewLabel_21 = new JLabel("Perfil");
		lblNewLabel_21.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblNewLabel_21.setBounds(800, 58, 86, 20);
		contentPane.add(lblNewLabel_21);
		
		lblNewLabel_17 = new JLabel("Tipo de Sangre");
		lblNewLabel_17.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblNewLabel_17.setBounds(714, 58, 72, 20);
		contentPane.add(lblNewLabel_17);
		
		lblNewLabel_18 = new JLabel("Vacuna");
		lblNewLabel_18.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblNewLabel_18.setBounds(863, 58, 86, 20);
		contentPane.add(lblNewLabel_18);
		
		lblNewLabel_19 = new JLabel("Dosis");
		lblNewLabel_19.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblNewLabel_19.setBounds(935, 58, 86, 20);
		contentPane.add(lblNewLabel_19);
		
		lblNewLabel_20 = new JLabel("Tipo de documento");
		lblNewLabel_20.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblNewLabel_20.setBounds(559, 58, 86, 20);
		contentPane.add(lblNewLabel_20);
		
		lblNewLabel_16 = new JLabel("Documento");
		lblNewLabel_16.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel_16.setBounds(650, 57, 72, 20);
		contentPane.add(lblNewLabel_16);
		
		lblNewLabel_15 = new JLabel("Genero");
		lblNewLabel_15.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblNewLabel_15.setBounds(500, 58, 86, 20);
		contentPane.add(lblNewLabel_15);
		
		lblNewLabel_14 = new JLabel("Edad");
		lblNewLabel_14.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblNewLabel_14.setBounds(442, 58, 86, 20);
		contentPane.add(lblNewLabel_14);
		
		lblNewLabel_13 = new JLabel("Apellido");
		lblNewLabel_13.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblNewLabel_13.setBounds(363, 58, 86, 20);
		contentPane.add(lblNewLabel_13);
		
		lblNewLabel_12 = new JLabel("Nombre");
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblNewLabel_12.setBounds(294, 58, 86, 20);
		contentPane.add(lblNewLabel_12);
		
		lblNewLabel_11 = new JLabel("Dosis");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_11.setBounds(22, 379, 86, 20);
		contentPane.add(lblNewLabel_11);
		
		lblNewLabel_10 = new JLabel("Vacuna");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_10.setBounds(22, 352, 86, 20);
		contentPane.add(lblNewLabel_10);
		
		lblNewLabel_9 = new JLabel("Tipo de Sangre");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(22, 322, 103, 20);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_8 = new JLabel("Documento");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(22, 298, 86, 20);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_6 = new JLabel("Genero");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(22, 241, 86, 20);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Tipo de documento");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(22, 268, 145, 20);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_5 = new JLabel("Edad");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(22, 217, 86, 20);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_4 = new JLabel("Apellido");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(22, 190, 86, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(22, 160, 86, 20);
		contentPane.add(lblNewLabel_3);
		
		tDosis = new JTextField();
		tDosis.setColumns(10);
		tDosis.setBounds(129, 376, 120, 20);
		contentPane.add(tDosis);
		
		tTvacuna = new JTextField();
		tTvacuna.setColumns(10);
		tTvacuna.setBounds(129, 349, 120, 20);
		contentPane.add(tTvacuna);
		
		tSangre = new JTextField();
		tSangre.setColumns(10);
		tSangre.setBounds(129, 322, 120, 20);
		contentPane.add(tSangre);
		
		tDocumento = new JTextField();
		tDocumento.setColumns(10);
		tDocumento.setBounds(129, 295, 120, 20);
		contentPane.add(tDocumento);
		
		tTdocumento = new JTextField();
		tTdocumento.setColumns(10);
		tTdocumento.setBounds(129, 268, 120, 20);
		contentPane.add(tTdocumento);
		
		tGenero = new JTextField();
		tGenero.setColumns(10);
		tGenero.setBounds(129, 241, 120, 20);
		contentPane.add(tGenero);
		
		tEdad = new JTextField();
		tEdad.setColumns(10);
		tEdad.setBounds(129, 214, 120, 20);
		contentPane.add(tEdad);
		
		tApellido = new JTextField();
		tApellido.setColumns(10);
		tApellido.setBounds(129, 187, 120, 20);
		contentPane.add(tApellido);
		
		tNombre = new JTextField();
		tNombre.setBounds(129, 160, 120, 20);
		contentPane.add(tNombre);
		tNombre.setColumns(10);
		
		table = new JTable(null,new String[] {
				"Nombre", "Cedula"
			});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int seleccion=table.getSelectedRow();
				tNombre.setText(table.getValueAt(seleccion, 0).toString());
				tApellido.setText(table.getValueAt(seleccion, 1).toString());
				tEdad.setText(table.getValueAt(seleccion, 2).toString());
				tGenero.setText(table.getValueAt(seleccion, 3).toString());
				tTdocumento.setText(table.getValueAt(seleccion, 4).toString());
				tDocumento.setText(table.getValueAt(seleccion, 5).toString());
				tSangre.setText(table.getValueAt(seleccion, 6).toString());
				tTvacuna.setText(table.getValueAt(seleccion, 8).toString());
				tDosis.setText(table.getValueAt(seleccion, 9).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "Nombre", "Cedula"
			}
		));
		table.setBounds(284, 83, 706, 330);
		contentPane.add(table);

		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(255, 255, 224));
		lblNewLabel_2.setBounds(20, 149, 240, 252);
		contentPane.add(lblNewLabel_2);
		btnEliminar.setBorderPainted(false);
		btnEliminar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnEliminar.setBackground(new Color(2, 167, 220));
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnEliminar.setBounds(188, 106, 72, 23);
		contentPane.add(btnEliminar);
		btnModificar.setBackground(new Color(2, 167, 220));
		btnModificar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnModificar.setBorderPainted(false);
		btnModificar.setBounds(102, 106, 82, 23);
		contentPane.add(btnModificar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String[] paciente = new String [10];
				paciente[0]=tNombre.getText();
				paciente[1]=tApellido.getText();
				paciente[2]=tEdad.getText();
				paciente[3]=tGenero.getText();
				paciente[4]=tTdocumento.getText();
				paciente[5]=tDocumento.getText();
				paciente[6]=tSangre.getText();
				paciente[7]="Paciente";
				paciente[8]=tTvacuna.getText();
				paciente[9]=tDosis.getText();
				asisGrafica.agregarPaciente(paciente);
				actualizarTabla(table,asisGrafica.getDatosPacientes());
				limpiar();
			}
		});
		btnAgregar.setBackground(new Color(2, 167, 220));
		btnAgregar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAgregar.setBorderPainted(false);
		btnAgregar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnAgregar.setBounds(26, 106, 72, 23);
		contentPane.add(btnAgregar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(0, 206, 209,150));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(13, 83, 261, 330);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Pacientes");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(408, 11, 226, 33);
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
		lblfondoAdmin.setBounds(-12, -88, 1012, 527);
		contentPane.add(lblfondoAdmin);
	}
	void limpiar() {
		tNombre.setText("");
		tApellido.setText("");
		tEdad.setText("");
		tGenero.setText("");
		tTdocumento.setText("");
		tDocumento.setText("");
		tSangre.setText("");
		tTvacuna.setText("");
		tDosis.setText("");
		
	}
	void actualizarTabla(JTable tabla, String[][] datos) {
		 tabla.setModel(new javax.swing.table.DefaultTableModel(datos,new String []{"nombre","apellido","edad","genero","tipo de Documento", "Documento", "tipo de sangre","perfil","tipo de vacuna", "dosis"}
			        ));
	}
}
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

import gestorAsistenteVAC.gest.Funcionario;
import gestorAsistenteVAC.gest.Paciente;

import java.awt.Point;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class adminFuncionarios extends JFrame {
	private JPanel contentPane;
	private static asistenteInterfaz asisGrafica;
	private JTable tDatos;
	private JTextField tNombre;
	private JTextField tApellido;
	private JTextField tDocumento;
	private JTextField tTdocumento;
	private JTextField tEdad;
	private JTextField tGenero;
	private JTextField tSangre;
	private JTextField tHorario;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JTable tVisible;
	private JLabel lblNewLabel_11;
	private JTextField textBuscar;
	private JButton btnBuscar;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;

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
	public adminFuncionarios(asistenteInterfaz grafica) {
		asisGrafica=grafica;
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccion=tVisible.getSelectedRow();
				String nom = tVisible.getValueAt(seleccion, 0).toString();
				
				tVisible.setValueAt(tNombre.getText(),seleccion, 0);
				tVisible.setValueAt(tDocumento.getText(),seleccion, 1);
				
				String[] nDatos=new String[9];
				nDatos[0]=tNombre.getText();
				nDatos[1]=tApellido.getText();
				nDatos[2]=tEdad.getText();
				nDatos[3]=tGenero.getText();
				nDatos[4]=tTdocumento.getText();
				nDatos[5]=tDocumento.getText();
				nDatos[6]=tSangre.getText();
				nDatos[7]="Funcionario";
				nDatos[8]=tHorario.getText();


				for(int i=0;i<9;i++) {
					tDatos.setValueAt(nDatos[i],seleccion, i);
				}
				
				asisGrafica.modificarFuncionarios(nom,nDatos);
				
				limpiar();
				//actualizarTabla(tDatos,tVisible,asisGrafica.getDatosFuncionario());
			}
		});
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccion=tVisible.getSelectedRow();
				asisGrafica.eliminarFuncionarios(tDatos.getValueAt(seleccion, 0).toString());
				((DefaultTableModel) tDatos.getModel()).removeRow(seleccion);
				((DefaultTableModel) tVisible.getModel()).removeRow(seleccion);
				limpiar();
				
				//actualizarTabla(tDatos,tVisible,asisGrafica.getDatosFuncionario());
			}
		});
		
		tVisible = new JTable();
		tVisible.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		tVisible.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			int seleccion=tVisible.getSelectedRow();
			tNombre.setText(tDatos.getValueAt(seleccion, 0).toString());
			tApellido.setText(tDatos.getValueAt(seleccion, 1).toString());
			tEdad.setText(tDatos.getValueAt(seleccion, 2).toString());
			tGenero.setText(tDatos.getValueAt(seleccion, 3).toString());
			tTdocumento.setText(tDatos.getValueAt(seleccion, 4).toString());
			tDocumento.setText(tDatos.getValueAt(seleccion, 5).toString());
			tSangre.setText(tDatos.getValueAt(seleccion, 6).toString());
			tHorario.setText(tDatos.getValueAt(seleccion, 8).toString());
			//actualizarTabla(tDatos,tVisible,asisGrafica.getDatosFuncionario());
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		
		lblNewLabel_11 = new JLabel("<html> Inserte el numero de la cedula que quiere buscar <html>");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_11.setBounds(298, 54, 186, 41);
		contentPane.add(lblNewLabel_11);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Funcionario auxF = asisGrafica.buscarFuncionario(Integer.valueOf(textBuscar.getText()));
					tNombre.setText(auxF.getNombre());
					tApellido.setText(auxF.getApellido());
					tEdad.setText(String.valueOf(auxF.getEdad()));
					tGenero.setText(auxF.getGenero());
					tTdocumento.setText(auxF.getTipoDocumento());
					tDocumento.setText(String.valueOf(auxF.getDocumento()));
					tSangre.setText(auxF.getSangre());
					tHorario.setText(String.valueOf(auxF.getHorario()[0]));
					
					}
					catch(NullPointerException e1) {
						System.out.println(" Campo vacio || dato invalido ");
					}
				
			}
		});
		btnBuscar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnBuscar.setBorderPainted(false);
		btnBuscar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnBuscar.setBackground(new Color(2, 167, 220));
		btnBuscar.setBounds(428, 106, 72, 23);
		contentPane.add(btnBuscar);
		
		lblNewLabel_12 = new JLabel("Nombre");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_12.setBounds(298, 143, 86, 20);
		contentPane.add(lblNewLabel_12);
		
		textBuscar = new JTextField();
		textBuscar.setColumns(10);
		textBuscar.setBounds(298, 106, 120, 20);
		contentPane.add(textBuscar);
		
		lblNewLabel_13 = new JLabel("Cedula");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_13.setBounds(398, 143, 86, 20);
		contentPane.add(lblNewLabel_13);

		tVisible.setBounds(284, 172, 216, 241);
		contentPane.add(tVisible);
		
		lblNewLabel_10 = new JLabel("Horario");
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
		
		tHorario = new JTextField();
		tHorario.setColumns(10);
		tHorario.setBounds(129, 349, 120, 20);
		contentPane.add(tHorario);
		
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
		//contentPane.add(tDatos);

		
		
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

				String[] funcionario = new String [10];
				funcionario[0]=tNombre.getText();
				funcionario[1]=tApellido.getText();
				funcionario[2]=tEdad.getText();
				funcionario[3]=tGenero.getText();
				funcionario[4]=tTdocumento.getText();
				funcionario[5]=tDocumento.getText();
				funcionario[6]=tSangre.getText();
				funcionario[7]="Funcionario";
				funcionario[8]=tHorario.getText();

				asisGrafica.agregarFuncionario(funcionario);
				actualizarTabla(tDatos,tVisible,asisGrafica.getDatosFuncionario());
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
		
		JLabel lblNewLabel = new JLabel("Funcionarios");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(155, 11, 226, 41);
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
		tNombre.setText("");
		tApellido.setText("");
		tEdad.setText("");
		tGenero.setText("");
		tTdocumento.setText("");
		tDocumento.setText("");
		tSangre.setText("");
		tHorario.setText("");
		
	}
	void actualizarTabla(JTable tabla, JTable tVisible, String[][] datos) {
		 tabla.setModel(new javax.swing.table.DefaultTableModel(datos,new String []{"nombre","apellido","edad","genero","tipo de Documento", "Documento", "tipo de sangre","perfil","Horairio"}
			        ));
		 String[][] datosV=new String[datos.length][2];
		 int i=0;
		while(i<datos.length) {
		 datosV[i][0]=datos[i][0];
		 datosV[i][1]=datos[i][5];
		 i++;
		 }
		 tVisible.setModel(new javax.swing.table.DefaultTableModel(datosV,new String []{"nombre", "Documento"}
			        ));
	}
	public JTable getTVisible() {
		return tVisible;
	}

	public void actualizar() {
		actualizarTabla(tDatos,tVisible,asisGrafica.getDatosFuncionario());
		
	}
}
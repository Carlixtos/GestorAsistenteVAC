package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class admin extends JFrame {

	private JPanel contentPane;
	private static asistenteInterfaz asisGrafica;
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
	public admin(asistenteInterfaz grafica) {
		this.setLocationRelativeTo(null);
		asisGrafica=grafica;
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDatosPacientes = new JButton("Administracion de datos de pacientes.");
		btnDatosPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grafica.setScreen(11);
				
			}
		});
		
		JButton btnGenerGrafica_1 = new JButton("Generador de graficas.");
		btnGenerGrafica_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grafica.setScreen(4	);
				
			}
		});
		btnGenerGrafica_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnGenerGrafica_1.setBorderPainted(false);
		btnGenerGrafica_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnGenerGrafica_1.setBackground(new Color(2, 167, 220));
		btnGenerGrafica_1.setBounds(65, 260, 366, 60);
		contentPane.add(btnGenerGrafica_1);
		btnDatosPacientes.setBorderPainted(false);
		btnDatosPacientes.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDatosPacientes.setBackground(new Color(2, 167, 220));
		btnDatosPacientes.setForeground(Color.BLACK);
		btnDatosPacientes.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnDatosPacientes.setBounds(65, 65, 366, 60);
		contentPane.add(btnDatosPacientes);
		
		JButton btnDatosFuncionarios = new JButton("Administracion de datos de funcinarios.");
		btnDatosFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grafica.setScreen(12);
			}
		});
		btnDatosFuncionarios.setBackground(new Color(2, 167, 220));
		btnDatosFuncionarios.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDatosFuncionarios.setBorderPainted(false);
		btnDatosFuncionarios.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnDatosFuncionarios.setBounds(65, 130, 366, 60);
		contentPane.add(btnDatosFuncionarios);
		
		JButton btnAdminVacuna = new JButton("Administracion de datos de vacunas.");
		btnAdminVacuna.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnAdminVacuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grafica.setScreen(13);
			}
		});
		btnAdminVacuna.setBackground(new Color(2, 167, 220));
		btnAdminVacuna.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAdminVacuna.setBorderPainted(false);
		btnAdminVacuna.setBounds(65, 195, 366, 60);
		contentPane.add(btnAdminVacuna);
		
		JButton btnGenerGrafica = new JButton("Generador de datos ( Pruebas ).");
		btnGenerGrafica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grafica.setScreen(9);
			}
		});
		btnGenerGrafica.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnGenerGrafica.setBackground(new Color(2, 167, 220));
		btnGenerGrafica.setBorderPainted(false);
		btnGenerGrafica.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnGenerGrafica.setBounds(65, 325, 366, 60);
		contentPane.add(btnGenerGrafica);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
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
		btnSalir.setBounds(415, 10, 68, 33);
		contentPane.add(btnSalir);
		
		JLabel lblFecha = new JLabel("Tue May 25 19:58:55 COT 2021");
		lblFecha.setBounds(10, 13, 149, 33);
		contentPane.add(lblFecha);
		
		JLabel lblfondoAdmin = new JLabel("");
		lblfondoAdmin.setIcon(new ImageIcon(admin.class.getResource("/imagenes/fondoAdmin.jpg")));
		lblfondoAdmin.setBounds(-12, -95, 807, 629);
		contentPane.add(lblfondoAdmin);
	}
}

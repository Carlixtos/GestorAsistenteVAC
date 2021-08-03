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

public class Pruebasmenu extends JFrame {

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
	public Pruebasmenu(asistenteInterfaz grafica) {
		asisGrafica=grafica;
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDatosFuncionarios = new JButton("Pruebas con metodos iterados.");
		btnDatosFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grafica.setScreen(41);
			}
		});
		
		JButton btnSalir_1 = new JButton("Regresar");
		btnSalir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				asisGrafica.returnScreen();
			}
		});
		btnSalir_1.setVerifyInputWhenFocusTarget(false);
		btnSalir_1.setSelected(true);
		btnSalir_1.setRolloverEnabled(false);
		btnSalir_1.setRequestFocusEnabled(false);
		btnSalir_1.setForeground(Color.WHITE);
		btnSalir_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSalir_1.setFocusable(false);
		btnSalir_1.setFocusTraversalKeysEnabled(false);
		btnSalir_1.setFocusPainted(false);
		btnSalir_1.setDefaultCapable(false);
		btnSalir_1.setBorderPainted(false);
		btnSalir_1.setBorder(new LineBorder(new Color(0, 255, 255), 2, true));
		btnSalir_1.setBackground(new Color(175, 238, 238));
		btnSalir_1.setBounds(10, 10, 100, 33);
		contentPane.add(btnSalir_1);
		btnDatosFuncionarios.setBackground(new Color(2, 167, 220));
		btnDatosFuncionarios.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDatosFuncionarios.setBorderPainted(false);
		btnDatosFuncionarios.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnDatosFuncionarios.setBounds(65, 130, 366, 68);
		contentPane.add(btnDatosFuncionarios);
		
		JButton btnAdminVacuna = new JButton("Pruebas con n datos.");
		btnAdminVacuna.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnAdminVacuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grafica.setScreen(42);
			}
		});
		btnAdminVacuna.setBackground(new Color(2, 167, 220));
		btnAdminVacuna.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAdminVacuna.setBorderPainted(false);
		btnAdminVacuna.setBounds(65, 280, 366, 68);
		contentPane.add(btnAdminVacuna);
		
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
		lblFecha.setBounds(10, 397, 149, 33);
		contentPane.add(lblFecha);
		
		JLabel lblfondoAdmin = new JLabel("");
		lblfondoAdmin.setIcon(new ImageIcon(admin.class.getResource("/gestorAsistenteVAC/imagenes/fondoAdmin.jpg")));
		lblfondoAdmin.setBounds(-12, -95, 807, 629);
		contentPane.add(lblfondoAdmin);
	}

}
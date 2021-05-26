package gestorAsistenteVAC.interfaz;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public admin() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDatosPacientes = new JButton("Administracion de datos de pacientes.");
		btnDatosPacientes.setBorderPainted(false);
		btnDatosPacientes.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDatosPacientes.setBackground(new Color(2, 220, 180));
		btnDatosPacientes.setForeground(Color.BLACK);
		btnDatosPacientes.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnDatosPacientes.setBounds(65, 83, 366, 68);
		contentPane.add(btnDatosPacientes);
		
		JButton btnDatosFuncionarios = new JButton("Administracion de datos de funcinarios.");
		btnDatosFuncionarios.setBackground(new Color(0, 255, 127));
		btnDatosFuncionarios.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnDatosFuncionarios.setBorderPainted(false);
		btnDatosFuncionarios.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnDatosFuncionarios.setBounds(65, 161, 366, 68);
		contentPane.add(btnDatosFuncionarios);
		
		JButton btnAdminVacuna = new JButton("Administracion de datos de vacunas.");
		btnAdminVacuna.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnAdminVacuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdminVacuna.setBackground(new Color(0, 255, 127));
		btnAdminVacuna.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAdminVacuna.setBorderPainted(false);
		btnAdminVacuna.setBounds(65, 239, 366, 68);
		contentPane.add(btnAdminVacuna);
		
		JButton btnGenerGrafica = new JButton("Generador de graficas.");
		btnGenerGrafica.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnGenerGrafica.setBackground(new Color(0, 255, 127));
		btnGenerGrafica.setBorderPainted(false);
		btnGenerGrafica.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnGenerGrafica.setBounds(65, 317, 366, 68);
		contentPane.add(btnGenerGrafica);
		
		JButton btnSalir = new JButton("Salir");
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
		
		JLabel lblNewLabel = new JLabel("Tue May 25 19:58:55 COT 2021");
		lblNewLabel.setBounds(10, 13, 149, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblfondoAdmin = new JLabel("");
		lblfondoAdmin.setIcon(new ImageIcon(admin.class.getResource("/gestorAsistenteVAC/imagenes/fondoAdmin.jpg")));
		lblfondoAdmin.setBounds(10, 10, 557, 462);
		contentPane.add(lblfondoAdmin);
	}

}

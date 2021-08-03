package interfaz;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Font;
import javax.swing.border.LineBorder;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class interfazGrafica extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblUsuario;
	private JLabel lblContraseña;
	private JButton btnEntrar;
	private JLabel lblfecha;
	private static asistenteInterfaz asisGrafica;
	private JLabel lblusuarioInvalido;
	private boolean errorusuario=true;
	/**
	 * Launch the application.
	 */
	public static void main(asistenteInterfaz grafica) {
		asisGrafica=grafica;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazGrafica frame = new interfazGrafica(grafica);
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
	public interfazGrafica(asistenteInterfaz grafica) {
		asisGrafica=grafica;
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setDefaultCapable(false);
		btnSalir.setFocusPainted(false);
		btnSalir.setFocusTraversalKeysEnabled(false);
		btnSalir.setFocusable(false);
		btnSalir.setSelected(true);
		btnSalir.setVerifyInputWhenFocusTarget(false);
		btnSalir.setRolloverEnabled(false);
		btnSalir.setRequestFocusEnabled(false);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setVerifyInputWhenFocusTarget(false);
		btnEntrar.setRolloverEnabled(false);
		btnEntrar.setRequestFocusEnabled(false);
		btnEntrar.setFocusable(false);
		btnEntrar.setFocusTraversalKeysEnabled(false);
		btnEntrar.setDefaultCapable(false);
		btnEntrar.setBorderPainted(false);
		btnEntrar.setBackground(new Color(0, 206, 209));
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBorder(null);
		btnEntrar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEntrar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		btnEntrar.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				errorusuario=asisGrafica.ingresoUsuario(textField.getText(), String.valueOf(passwordField.getPassword()));
				textField.setText("");
				passwordField.setText("");
				if(!errorusuario) {
					lblusuarioInvalido.setVisible(true);
				}
			}
		});
		btnEntrar.setBounds(395, 388, 85, 40);
		contentPane.add(btnEntrar);

		
		lblusuarioInvalido = new JLabel("usuario invalido");
		lblusuarioInvalido.setHorizontalTextPosition(SwingConstants.CENTER);
		lblusuarioInvalido.setHorizontalAlignment(SwingConstants.CENTER);
		lblusuarioInvalido.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblusuarioInvalido.setForeground(new Color(255, 0, 0));
		lblusuarioInvalido.setBackground(new Color(255, 0, 0));
		lblusuarioInvalido.setBounds(103, 253, 269, 29);
		contentPane.add(lblusuarioInvalido);
		lblusuarioInvalido.setVisible(false);
		
		
		lblContraseña = new JLabel("Contrase\u00F1a");
		lblContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		lblContraseña.setHorizontalTextPosition(SwingConstants.CENTER);
		lblContraseña.setForeground(new Color(47, 79, 79));
		lblContraseña.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
		lblContraseña.setBounds(28, 332, 162, 33);
		contentPane.add(lblContraseña);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setForeground(new Color(47, 79, 79));
		lblUsuario.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
		lblUsuario.setBounds(28, 292, 162, 33);
		contentPane.add(lblUsuario);
		
		passwordField = new JPasswordField();
		passwordField.setCaretColor(new Color(255, 255, 255));
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setBackground(new Color(0, 128, 128));
		passwordField.setBounds(189, 332, 229, 33);
		contentPane.add(passwordField);
		btnSalir.setBorderPainted(false);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBorder(new LineBorder(new Color(0, 255, 255), 2, true));
		btnSalir.setBackground(new Color(175, 238, 238));
		btnSalir.setBounds(412, 10, 68, 33);
		contentPane.add(btnSalir);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setCaretColor(new Color(255, 255, 255));
		textField.setForeground(new Color(255, 255, 255));
		textField.setSelectionColor(new Color(0, 120, 215));
		textField.setAutoscrolls(false);
		textField.setBackground(new Color(0, 128, 128));
		textField.setBounds(189, 292, 229, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblfecha = new JLabel(new Date().toString());
		lblfecha.setBounds(28, 23, 149, 33);
		contentPane.add(lblfecha);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblFondo.setVerifyInputWhenFocusTarget(false);
		lblFondo.setBorder(null);
		lblFondo.setForeground(new Color(175, 238, 238));
		lblFondo.setBackground(new Color(0, 255, 255));
		lblFondo.setIcon(new ImageIcon(interfazGrafica.class.getResource("/gestorAsistenteVAC/imagenes/fondo.jpg")));
		lblFondo.setBounds(0, -40, 625, 524);
		contentPane.add(lblFondo);
	}	
}

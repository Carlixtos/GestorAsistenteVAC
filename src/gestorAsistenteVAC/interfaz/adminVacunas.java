package gestorAsistenteVAC.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class adminVacunas extends JFrame {

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
	public adminVacunas(asistenteInterfaz grafica) {
		asisGrafica=grafica;
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("23");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(161, 322, 195, 42);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("74");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(305, 188, 195, 42);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("59");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 188, 195, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2_2 = new JLabel("Janssen");
		lblNewLabel_2_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_2_2.setOpaque(true);
		lblNewLabel_2_2.setBackground(new Color(255, 255, 224));
		lblNewLabel_2_2.setBounds(172, 250, 172, 73);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Moderna");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1.setOpaque(true);
		lblNewLabel_2_1.setBackground(new Color(255, 255, 224));
		lblNewLabel_2_1.setBounds(316, 116, 172, 73);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("");
		lblNewLabel_1_1_1_2.setOpaque(true);
		lblNewLabel_1_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_2.setBackground(new Color(0, 206, 209, 150));
		lblNewLabel_1_1_1_2.setBounds(161, 240, 195, 124);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1.setOpaque(true);
		lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1.setBackground(new Color(0, 206, 209, 150));
		lblNewLabel_1_1_1_1.setBounds(305, 106, 195, 124);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pfizer");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(255, 255, 224));
		lblNewLabel_2.setBounds(20, 116, 172, 73);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setOpaque(true);
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setBackground(new Color(0, 206, 209, 150));
		lblNewLabel_1_1_1.setBounds(10, 106, 195, 124);
		contentPane.add(lblNewLabel_1_1_1);
		
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
		lblfondoAdmin.setBounds(-12, -95, 807, 629);
		contentPane.add(lblfondoAdmin);
	}
}
package interfaz;

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
import javax.swing.JToggleButton;
import javax.swing.JTextField;

public class adminVacunas extends JFrame {

	private JPanel contentPane;
	private static asistenteInterfaz asisGrafica;
	private JTextField textP;
	private JTextField textJ;
	private JTextField textM;
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
		
		textM = new JTextField();
		textM.setColumns(10);
		textM.setBounds(357, 240, 125, 20);
		contentPane.add(textM);
		
		textJ = new JTextField();
		textJ.setColumns(10);
		textJ.setBounds(190, 240, 125, 20);
		contentPane.add(textJ);
		
		//JLabel lblNewLabel_3 = new JLabel(String.valueOf(asisGrafica.getVacuanas().getDosis()));
		JLabel lblCJanssen = new JLabel(String.valueOf(asisGrafica.getCantVac("janssen")));
		lblCJanssen.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblCJanssen.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCJanssen.setHorizontalAlignment(SwingConstants.CENTER);
		lblCJanssen.setBounds(180, 188, 157, 42);
		contentPane.add(lblCJanssen);
			
		JLabel lblCModerna = new JLabel(String.valueOf(asisGrafica.getCantVac("moderna")));
		lblCModerna.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblCModerna.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCModerna.setHorizontalAlignment(SwingConstants.CENTER);
		lblCModerna.setBounds(347, 188, 153, 42);
		contentPane.add(lblCModerna);
				
		JLabel lblCPfizer = new JLabel(String.valueOf(asisGrafica.getCantVac("pfizer")));
		lblCPfizer.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblCPfizer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCPfizer.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCPfizer.setBounds(10, 188, 147, 42);
		contentPane.add(lblCPfizer);
		
		JButton btnAjanssen = new JButton("Agregar");
		btnAjanssen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					asisGrafica.agregarVacunas("janssen",Integer.valueOf(textJ.getText()));
					lblCJanssen.setText(String.valueOf(asisGrafica.getCantVac("janssen")));
					textJ.setText("");
				}
				catch(NullPointerException e1) {
					System.out.println(" Campo vacio || dato invalido ");
				}
			}
		});
		btnAjanssen.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnAjanssen.setBorderPainted(false);
		btnAjanssen.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAjanssen.setBackground(new Color(2, 167, 220));
		btnAjanssen.setBounds(208, 270, 72, 23);
		contentPane.add(btnAjanssen);
		
		JButton btnAmoderna = new JButton("Agregar");
		btnAmoderna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					asisGrafica.agregarVacunas("moderna",Integer.valueOf(textM.getText()));
					lblCModerna.setText(String.valueOf(asisGrafica.getCantVac("moderna")));
					textM.setText("");
				}
				catch(NullPointerException e1) {
					System.out.println(" Campo vacio || dato invalido ");
				}
			}
		});
		btnAmoderna.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnAmoderna.setBorderPainted(false);
		btnAmoderna.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAmoderna.setBackground(new Color(2, 167, 220));
		btnAmoderna.setBounds(375, 270, 72, 23);
		contentPane.add(btnAmoderna);
		
		JButton btnApfizer = new JButton("Agregar");
		btnApfizer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					asisGrafica.agregarVacunas("pfizer",Integer.valueOf(textP.getText()));	 
					lblCPfizer.setText(String.valueOf(asisGrafica.getCantVac("pfizer")));
					textP.setText("");
				}
				catch(NullPointerException e1) {
					System.out.println(" Campo vacio || dato invalido ");
				}
				
			}
		});
		btnApfizer.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnApfizer.setBorderPainted(false);
		btnApfizer.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnApfizer.setBackground(new Color(2, 167, 220));
		btnApfizer.setBounds(38, 270, 72, 23);
		contentPane.add(btnApfizer);
		
		textP = new JTextField();
		textP.setColumns(10);
		textP.setBounds(20, 240, 125, 20);
		contentPane.add(textP);
		
		
		
		//JLabel lblNewLabel_2_2 = new JLabel(asisGrafica.getVacuanas().getTipo());
		JLabel lblNewLabel_2_2 = new JLabel("Janssen");
		lblNewLabel_2_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_2_2.setOpaque(true);
		lblNewLabel_2_2.setBackground(new Color(255, 255, 224));
		lblNewLabel_2_2.setBounds(190, 116, 130, 73);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Moderna");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1.setOpaque(true);
		lblNewLabel_2_1.setBackground(new Color(255, 255, 224));
		lblNewLabel_2_1.setBounds(358, 116, 130, 73);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("");
		lblNewLabel_1_1_1_2.setOpaque(true);
		lblNewLabel_1_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_2.setBackground(new Color(0, 206, 209, 150));
		lblNewLabel_1_1_1_2.setBounds(180, 106, 150, 125);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1.setOpaque(true);
		lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1.setBackground(new Color(0, 206, 209, 150));
		lblNewLabel_1_1_1_1.setBounds(347, 106, 150, 125);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pfizer");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(255, 255, 224));
		lblNewLabel_2.setBounds(20, 116, 125, 73);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setOpaque(true);
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setBackground(new Color(0, 206, 209, 150));
		lblNewLabel_1_1_1.setBounds(10, 106, 150, 125);
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
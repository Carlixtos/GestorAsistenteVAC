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
import java.awt.Graphics;
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


public class Graficas extends JFrame {
	private JPanel contentPane;
	private static asistenteInterfaz asisGrafica;
	private JTable tDatos;
	private JTextField tdatos;
	private boolean pintar=false;

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
	public Graficas(asistenteInterfaz grafica) {
		pintar=false;
		this.setLocationRelativeTo(null);
		asisGrafica=grafica;
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("<html> Inserte la fecha que quiere consultar. <html>");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setToolTipText("");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(141, 10, 232, 65);
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
				pintar=true;
				repaint();
			}
		});
		
		btnEjecutar.setBorderPainted(false);
		btnEjecutar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnEjecutar.setBackground(new Color(2, 167, 220));
		btnEjecutar.setForeground(Color.BLACK);
		btnEjecutar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnEjecutar.setBounds(387, 67, 72, 23);
		contentPane.add(btnEjecutar);
		
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
		lblfondoAdmin.setBounds(0, -51, 626, 543);
		contentPane.add(lblfondoAdmin);
	}
	public void paint(Graphics g) {
		super.paint(g);
		if(pintar) {
		
		int[] genero;
			try {
				genero = this.asisGrafica.vacunadosGenero(tdatos.getText());}
			catch(NullPointerException e1) {
				genero=new int[2];
			}
		genero[0]=100;
		genero[1]=200;
		int[] edad;
		try {
			edad = this.asisGrafica.vacunadosEdad(tdatos.getText());}
		catch(NullPointerException e1) {
			edad=new int[6];
		}
		edad[0]=100;
		edad[1]=200;
		edad[2]=300;
		edad[3]=400;
		edad[4]=500;
		edad[5]=600;

		
		int mujeres=genero[0];
		int hombres=genero[1];
		int totalGenero =hombres+mujeres;
		int gradosHombre=hombres*360/totalGenero;
		int gradosMujer=mujeres*360/totalGenero;
		
		int e12=edad[0];
		int e30=edad[1];
		int e45=edad[2];
		int e55=edad[3];
		int e65=edad[4];
		int e75=edad[5];
		int totalEdad=e12+e30+e45+e55+e65+e75;
		int grados12=e12*360/totalEdad;
		int grados30=e30*360/totalEdad;
		int grados45=e45*360/totalEdad;
		int grados55=e55*360/totalEdad;
		int grados65=e65*360/totalEdad;
		int grados75=e75*360/totalEdad;
		
		
		g.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		g.setColor(new Color(0,0,255));
		g.fillArc(50, 120, 200,200,0,gradosHombre);
		g.fillRect(50, 350, 10,10);
		g.setColor(new Color(0,0,0));
		g.drawString("Hombre", 70, 360);
		g.setColor(new Color(255,0,0));
		g.fillArc(50, 120, 200,200,gradosHombre,gradosMujer);
		g.fillRect(50, 370, 10,10);
		g.setColor(new Color(0,0,0));
		g.drawString("Mujer", 70, 380);
		
		
		g.setColor(new Color(255,0,255));
		g.fillArc(350, 120, 200,200,0,grados12);
		g.fillRect(350, 350, 10,10);
		
		g.setColor(new Color(255,250,0));
		g.fillArc(350, 120, 200,200,grados12,grados30);
		g.fillRect(350, 370, 10,10);
		
		g.setColor(new Color(0,255,255));
		g.fillArc(350, 120, 200,200,grados12+grados30,grados45);
		g.fillRect(350, 390, 10,10);
		
		g.setColor(new Color(130,10,210));
		g.fillArc(350, 120, 200,200,grados12+grados30+grados45,grados55);
		g.fillRect(480, 350, 10,10);
		
		g.setColor(new Color(255,150,0));
		g.fillArc(350, 120, 200,200,grados12+grados30+grados45+grados55,grados65);
		g.fillRect(480, 370, 10,10);
		
		g.setColor(new Color(0,250,0));
		g.fillArc(350, 120, 200,200,grados12+grados30+grados45+grados55+grados65,360-(grados12+grados30+grados45+grados55+grados65));
		g.fillRect(480, 390, 10,10);
		
		g.setColor(new Color(0,0,0));
		g.drawString("12-30", 370, 360);
		g.drawString("30-45", 370, 380);
		g.drawString("45-55", 370, 400);
		g.drawString("55-65", 500, 360);
		g.drawString("65-75", 500, 380);
		g.drawString("Mayores de 75", 500, 400);
		pintar=false;
		}
	}
}
package provapoo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class Tela02 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtBemVindo;
	private JTextField txtVoceEstCadastrado;
	private JTextField txtParabens;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela02 frame = new Tela02();
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
	public Tela02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtBemVindo = new JTextField();
		txtBemVindo.setForeground(new Color(255, 255, 255));
		txtBemVindo.setBackground(new Color(0, 0, 64));
		txtBemVindo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		txtBemVindo.setText("BEM VINDO!!!");
		txtBemVindo.setBounds(73, 34, 265, 67);
		contentPane.add(txtBemVindo);
		txtBemVindo.setColumns(10);
		
		txtVoceEstCadastrado = new JTextField();
		txtVoceEstCadastrado.setText("Voce está cadastrado!!");
		txtVoceEstCadastrado.setBounds(45, 140, 235, 20);
		contentPane.add(txtVoceEstCadastrado);
		txtVoceEstCadastrado.setColumns(10);
		
		txtParabens = new JTextField();
		txtParabens.setText("Parabens!!");
		txtParabens.setBounds(45, 181, 235, 20);
		contentPane.add(txtParabens);
		txtParabens.setColumns(10);
	}

}

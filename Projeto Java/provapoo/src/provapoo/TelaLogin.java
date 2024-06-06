package provapoo;

import java.sql.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField pwfsenha;
	private JTextField txtusuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LogIn");
		lblNewLabel.setForeground(new Color(0, 0, 64));
		lblNewLabel.setBackground(new Color(51, 153, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(86, 11, 240, 71);
		contentPane.add(lblNewLabel);
		
		JButton btnacessar = new JButton("Acessar");
		btnacessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teste", "root", "");
						Statement stmt = con.createStatement();
						String sql = "select * from alunos where login='" + txtusuario.getText()+"' and senha='"+pwfsenha.getText()+"'";
						ResultSet rs = stmt.executeQuery(sql);
						if(rs.next()) {
							JOptionPane.showMessageDialog(null, "Login com Sucesso");
							Tela02 exibir = new Tela02();
							exibir.setVisible(true);
							txtusuario.setText(null);
							pwfsenha.setText(null);
						}else {
							JOptionPane.showMessageDialog(null, "Login não permitido");
							txtusuario.setText(null);
							pwfsenha.setText(null);
						}
							con.close();
						} catch (Exception e1) {
							System.out.print(e1);}
			}
		});
		btnacessar.setBounds(166, 174, 89, 23);
		contentPane.add(btnacessar);
		
		JButton btncadnovo = new JButton("Novo Cadastro");
		btncadnovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadNovoUsuario exibir = new
						TelaCadNovoUsuario();
						exibir.setVisible(true);
						txtusuario.setText(null);
						pwfsenha.setText(null);
			}
		});
		btncadnovo.setBounds(155, 208, 109, 23);
		contentPane.add(btncadnovo);
		
		JButton btnsair = new JButton("Sair");
		btnsair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnsair.setBounds(335, 208, 89, 23);
		contentPane.add(btnsair);
		
		JButton btnlimpar = new JButton("Limpar");
		btnlimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnlimpar.setBounds(10, 208, 89, 23);
		contentPane.add(btnlimpar);
		
		pwfsenha = new JPasswordField();
		pwfsenha.setBounds(155, 125, 117, 20);
		contentPane.add(pwfsenha);
		
		JLabel lblsenha = new JLabel("Senha");
		lblsenha.setBounds(99, 128, 46, 14);
		contentPane.add(lblsenha);
		
		JLabel lblusuario = new JLabel("Usuário");
		lblusuario.setBounds(99, 88, 46, 14);
		contentPane.add(lblusuario);
		
		txtusuario = new JTextField();
		txtusuario.setBounds(155, 85, 117, 20);
		contentPane.add(txtusuario);
		txtusuario.setColumns(10);
	}
}

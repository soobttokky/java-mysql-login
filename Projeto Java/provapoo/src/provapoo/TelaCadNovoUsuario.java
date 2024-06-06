package provapoo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class TelaCadNovoUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtusuario;
	private JPasswordField pwfsenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadNovoUsuario frame = new TelaCadNovoUsuario();
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
	public TelaCadNovoUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuáro");
		lblUsuario.setBounds(109, 83, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblsenha = new JLabel("Senha");
		lblsenha.setBounds(109, 144, 46, 14);
		contentPane.add(lblsenha);
		
		txtusuario = new JTextField();
		txtusuario.setBounds(177, 79, 86, 23);
		contentPane.add(txtusuario);
		txtusuario.setColumns(10);
		
		JButton btnsalvar = new JButton("Salvar");
		btnsalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/teste", "root", "");
						String sql = "Insert into alunos(login, senha) values (?, ?) ";
						PreparedStatement stmt = con.prepareStatement(sql);
						stmt.setString(1, txtusuario.getText());
						stmt.setString(2, pwfsenha.getText());
						JOptionPane.showMessageDialog(null, "Usuário Cadastrado com Sucesso");
						TelaLogin abrir = new TelaLogin();
						abrir.setVisible(true);
						txtusuario.setText(null);
						pwfsenha.setText(null);
						stmt.execute();
						TelaLogin.main(null);
						stmt.close();
						con.close();
						abrir.setVisible(false);
						TelaCadNovoUsuario telaCadNovoUsuario = new TelaCadNovoUsuario();
						telaCadNovoUsuario.setVisible(false);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

			}
		});
		btnsalvar.setBounds(20, 227, 89, 23);
		contentPane.add(btnsalvar);
		
		JButton btnsair = new JButton("Sair");
		btnsair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnsair.setBounds(309, 227, 89, 23);
		contentPane.add(btnsair);
		
		pwfsenha = new JPasswordField();
		pwfsenha.setBounds(177, 141, 86, 23);
		contentPane.add(pwfsenha);
	}

}

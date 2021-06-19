package Janelas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;

public class EscolhaRelatorios extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EscolhaRelatorios frame = new EscolhaRelatorios();
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
	public EscolhaRelatorios() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EscolhaRelatorios.class.getResource("/Imagens/Tela Cadastrar-3.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Relat\u00F3rio Individual");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setBounds(219, 105, 147, 41);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Relatorios tela = new Relatorios();
				tela.setVisible(true);
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Relat\u00F3rio Mensal");
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setBounds(219, 195, 147, 42);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRelatorio tela = new TelaRelatorio();
				tela.setVisible(true);
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_1);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.CYAN);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaInicio tela = new TelaInicio();
				tela.setVisible(true);
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		btnVoltar.setBounds(22, 322, 84, 28);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(EscolhaRelatorios.class.getResource("/Imagens/Tela Cadastrar-3.png")));
		lblNewLabel.setBounds(0, 0, 574, 389);
		contentPane.add(lblNewLabel);
	}
}

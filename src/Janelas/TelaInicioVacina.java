package Janelas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaInicioVacina extends JFrame {

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
					TelaInicioVacina frame = new TelaInicioVacina();
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
	public TelaInicioVacina() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnIncluirCidadao = new JButton("Incluir Vacina");
		btnIncluirCidadao.setBackground(Color.CYAN);
		btnIncluirCidadao.setForeground(Color.BLACK);
		btnIncluirCidadao.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnIncluirCidadao.setBounds(10, 110, 196, 40);
		btnIncluirCidadao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaIncluirVacina tela = new TelaIncluirVacina();
				tela.setVisible(true);
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		
		JButton btnEditarCidadao = new JButton("Editar Vacina");
		btnEditarCidadao.setBackground(Color.CYAN);
		btnEditarCidadao.setForeground(Color.BLACK);
		btnEditarCidadao.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnEditarCidadao.setBounds(10, 186, 196, 40);
		btnEditarCidadao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaEditarVacina tela = new TelaEditarVacina();
				tela.setVisible(true);
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		
		JButton btnExcluirCidadao = new JButton("Excluir Vacina");
		btnExcluirCidadao.setBackground(Color.CYAN);
		btnExcluirCidadao.setForeground(Color.BLACK);
		btnExcluirCidadao.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnExcluirCidadao.setBounds(10, 341, 196, 40);
		btnExcluirCidadao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaExcluirVacina tela = new TelaExcluirVacina();
				tela.setVisible(true);
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		
		JButton btnConsultarCidadao = new JButton("Consultar Vacina");
		btnConsultarCidadao.setBackground(Color.CYAN);
		btnConsultarCidadao.setForeground(Color.BLACK);
		btnConsultarCidadao.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnConsultarCidadao.setBounds(10, 264, 196, 40);
		btnConsultarCidadao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaConsultarVacina tela = new TelaConsultarVacina();
				tela.setVisible(true);
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnEditarCidadao);
		contentPane.add(btnIncluirCidadao);
		contentPane.add(btnConsultarCidadao);
		contentPane.add(btnExcluirCidadao);
		
		JLabel lblNewLabel_1 = new JLabel("Voltar\r\n");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TelaInicio tela = new TelaInicio();
				tela.setVisible(true);
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(87, 428, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Fundo Tela Inicio Vacina");
		lblNewLabel.setIcon(new ImageIcon(TelaInicioVacina.class.getResource("/Imagens/Tela de Inicio Vacina.png")));
		lblNewLabel.setBounds(-1, 2, 849, 496);
		contentPane.add(lblNewLabel);
	}
}

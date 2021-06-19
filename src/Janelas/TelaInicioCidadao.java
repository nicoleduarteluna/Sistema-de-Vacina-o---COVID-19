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

public class TelaInicioCidadao extends JFrame {

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
					TelaInicioCidadao frame = new TelaInicioCidadao();
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
	public TelaInicioCidadao() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnIncluirCidadao = new JButton("Incluir Cidad\u00E3o");
		btnIncluirCidadao.setBackground(Color.CYAN);
		btnIncluirCidadao.setForeground(Color.BLACK);
		btnIncluirCidadao.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnIncluirCidadao.setBounds(10, 107, 194, 39);
		btnIncluirCidadao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaIncluirCidadao tela = new TelaIncluirCidadao();
				tela.setVisible(true);
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		
		JButton btnEditarCidadao = new JButton("Editar Cidad\u00E3o");
		btnEditarCidadao.setBackground(Color.CYAN);
		btnEditarCidadao.setForeground(Color.BLACK);
		btnEditarCidadao.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnEditarCidadao.setBounds(10, 186, 194, 39);
		btnEditarCidadao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaEditarCidadao tela = new TelaEditarCidadao();
				tela.setVisible(true);
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		
		JButton btnExcluirCidadao = new JButton("Excluir Cidad\u00E3o");
		btnExcluirCidadao.setBackground(Color.CYAN);
		btnExcluirCidadao.setForeground(Color.BLACK);
		btnExcluirCidadao.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnExcluirCidadao.setBounds(10, 352, 194, 39);
		btnExcluirCidadao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaExcluirCidadao tela = new TelaExcluirCidadao();
				tela.setVisible(true);
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		
		JButton btnConsultarCidadao = new JButton("Consultar Cidad\u00E3o");
		btnConsultarCidadao.setBackground(Color.CYAN);
		btnConsultarCidadao.setForeground(Color.BLACK);
		btnConsultarCidadao.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnConsultarCidadao.setBounds(10, 270, 194, 39);
		btnConsultarCidadao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaConsultarCidadao tela = new TelaConsultarCidadao();
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
		
		JLabel lblNewLabel_1 = new JLabel("Voltar");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TelaInicio tela = new TelaInicio();
				tela.setVisible(true);
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setBounds(80, 441, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Fundo Tela Inicio Cidad\u00E3o");
		lblNewLabel.setIcon(new ImageIcon(TelaInicioCidadao.class.getResource("/Imagens/Tela de Inicio Cidad\u00E3o.png")));
		lblNewLabel.setBounds(0, 0, 846, 497);
		contentPane.add(lblNewLabel);
	}
}

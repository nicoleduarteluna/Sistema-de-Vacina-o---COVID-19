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

public class TelaInicio extends JFrame {

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
					TelaInicio frame = new TelaInicio();
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
	public TelaInicio() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAmbienteDeVacina = new JButton("Ambiente de Vacina");
		btnAmbienteDeVacina.setBackground(Color.CYAN);
		btnAmbienteDeVacina.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnAmbienteDeVacina.setBounds(229, 322, 177, 48);
		btnAmbienteDeVacina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaInicioVacina tela = new TelaInicioVacina();
				tela.setVisible(true);
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		
		JButton btnAmbienteDeCidado = new JButton("Ambiente de Cidad\u00E3o");
		btnAmbienteDeCidado.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnAmbienteDeCidado.setBounds(25, 323, 177, 46);
		btnAmbienteDeCidado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaInicioCidadao tela = new TelaInicioCidadao();
				tela.setVisible(true);
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		btnAmbienteDeCidado.setBackground(Color.CYAN);
		
		JButton btnCarteiraDeVacinao = new JButton("Carteira de Vacina\u00E7\u00E3o");
		btnCarteiraDeVacinao.setBackground(Color.CYAN);
		btnCarteiraDeVacinao.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnCarteiraDeVacinao.setBounds(444, 322, 177, 48);
		btnCarteiraDeVacinao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCarteiraVacinacao tela = new TelaCarteiraVacinacao();
				tela.setVisible(true);
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		
		JButton btnRelatrioDePreviso = new JButton("Relatórios");
		btnRelatrioDePreviso.setBackground(Color.CYAN);
		btnRelatrioDePreviso.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnRelatrioDePreviso.setBounds(659, 322, 177, 48);
		btnRelatrioDePreviso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EscolhaRelatorios tela = new EscolhaRelatorios();
				tela.setVisible(true);
				tela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnRelatrioDePreviso);
		contentPane.add(btnCarteiraDeVacinao);
		contentPane.add(btnAmbienteDeVacina);
		contentPane.add(btnAmbienteDeCidado);
		
		JLabel lblNewLabel = new JLabel("Fundo Tela de Inicio");
		lblNewLabel.setIcon(new ImageIcon(TelaInicio.class.getResource("/Imagens/TelaInicio.png")));
		lblNewLabel.setBounds(0, 0, 859, 497);
		contentPane.add(lblNewLabel);
	}
}

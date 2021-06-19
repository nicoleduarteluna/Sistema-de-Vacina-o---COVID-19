package Controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Janelas.TelaRelatorio;

public class Cidadao {
	
	private String nome;
	private String cpf;
	private Cidadao cli;
	private String id;
	private LocalDate dtNascimento;
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private String endereco;
	private String telefone;
	private String email;
	
	public Cidadao getCli() {
		return cli;
	}
	public void setCli(Cidadao cli) {
		this.cli = cli;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public LocalDate getDtNascimento() {
		return dtNascimento;
	}
	
	public String getDtNascimentoFormatado() {
		return formato.format(dtNascimento);
	}
	
	public void setDtNascimento(String d) {
		dtNascimento = LocalDate.parse(d, formato);
	}
	
	public void setDtNascimento(java.sql.Date d) {
		dtNascimento = d.toLocalDate();
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void inserir() {
		// 1: Definir o comando SQL
		String sql = "INSERT INTO Cidadao(nome, cpf, dtNascimento, email, telefone, endereco) VALUES (?, ?, ?, ?, ?, ?)";
		
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			
			// 4: Preenche os dados faltantes
			ps.setString(1, nome);
			ps.setString(2, cpf);
			ps.setDate(3, java.sql.Date.valueOf(dtNascimento));
			ps.setString(4, email);
			ps.setString(5, telefone);
			ps.setString(6, endereco);
			
			// 5: Executa o comando
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Cidadão incluído com sucesso!");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cidadão já cadastrado.");
		}
	}
	
	public void listar() {
		// 1: Definir o comando SQL
		String sql = "SELECT * FROM Cidadao";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Executa o comando e guarda
			// o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();
			// 5: itera sobre o resultado
			while (rs.next()) {
				int codigo = rs.getInt("cpf");
				String nome = rs.getString("nome");
				String telefone = rs.getString("telefone");
				String email = rs.getString("email");
				String endereco = rs.getString("endereco");
				String	dt = rs.getString("dtNascimento");
				String aux = String.format("Código: %d, Nome: %s, Fone: %s, Email: %s", cpf, codigo, nome, telefone, email, endereco, dt, dtNascimento);
				JOptionPane.showMessageDialog(null, aux);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listarJ() {
		String sql = 
				"select c.nome as 'Cidadao', cv.primeira_dose, v.nome as 'Vacina', v.intervalo_doses, (primeira_dose + INTERVAL intervalo_doses DAY) as previsao\r\n" + 
				"from Cidadao c, carteira_vacinacao cv, vacina v\r\n" + 
				"where c.id_cidadao = cv.id_cidadao\r\n" + 
				"and cv.id_vacina = v.id_vacina\r\n" + 
				"and v.qtde_doses > 1\r\n" + 
				"and (primeira_dose + INTERVAL intervalo_doses DAY) between '2021-05-31' and '2021-06-07'";
		
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			TelaRelatorio tela = new TelaRelatorio();
			JTable tabela =  tela.Cidadao;
			DefaultTableModel modelo = (DefaultTableModel) tabela.getModel() ;
			modelo.setNumRows(0);
			
			while (rs.next()) {
				modelo.addRow(new Object[] {rs.getString("Cidadao"),rs.getString("primeira_dose"), rs.getString("Vacina"), rs.getString("intervalo_doses"), rs.getString("previsao")});
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void apagar() {
		// 1: Definir o comando SQL
		String sql = "DELETE FROM Cidadao WHERE cpf = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setString(1, cpf);
			// 5: Executa o comando
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar() {
		// 1: Definir o comando SQL
		String sql = "UPDATE Cidadao SET nome = ?, telefone = ?, email = ?, endereco = ?, cpf = ?, dtNascimento = ?  where cpf = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setString(1, nome);
			ps.setString(2, telefone);
			ps.setString(3, email);
			ps.setString(4, endereco);
			ps.setDate(6, java.sql.Date.valueOf(dtNascimento));
			ps.setString(5, cpf);
			ps.setString(7, cpf);
			
			// 5: Executa o comando
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void consultar() {
		// 1: Definir o comando SQL
		String sql = "SELECT nome, dtNascimento, email, telefone, endereco FROM Cidadao where cpf = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, cpf);
			// 4: Executa o comando e guarda
			// o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();
			// 5: itera sobre o resultado
			if (rs.next()) {
				nome = rs.getString("nome");
				setDtNascimento(rs.getDate("dtNascimento"));
		//		dtNascimento = rs.getDate("dtNascimento");
				email = rs.getString("email");
				telefone = rs.getString("telefone");
				endereco = rs.getString("endereco");
			}
			 else if (!rs.next()){
				 JOptionPane.showMessageDialog(null, "Esse cidadão não está cadastrado!");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void consultarID() {
		// 1: Definir o comando SQL
		String sql = "SELECT nome, cpf, dtNascimento, email, telefone, endereco FROM Cidadao where id_cidadao = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, id);
			// 4: Executa o comando e guarda
			// o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();
			// 5: itera sobre o resultado
			if (rs.next()) {
				nome = rs.getString("nome");
				cpf = rs.getString("cpf");
				setDtNascimento(rs.getDate("dtNascimento"));
		//		dtNascimento = rs.getDate("dtNascimento");
				email = rs.getString("email");
				telefone = rs.getString("telefone");
				endereco = rs.getString("endereco");
			}
			 else if (!rs.next()){
				 JOptionPane.showMessageDialog(null, "Esse cidadão não está cadastrado!");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void consultarCPF() {
		// 1: Definir o comando SQL
		String sql = "SELECT nome, cpf, dtNascimento, email, telefone, endereco FROM Cidadao where cpf = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, cpf);
			// 4: Executa o comando e guarda
			// o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();
			// 5: itera sobre o resultado
			if (rs.next()) {
				nome = rs.getString("nome");
				cpf = rs.getString("cpf");
				setDtNascimento(rs.getDate("dtNascimento"));
		//		dtNascimento = rs.getDate("dtNascimento");
				email = rs.getString("email");
				telefone = rs.getString("telefone");
				endereco = rs.getString("endereco");
			}
			 else if (!rs.next()){
				 JOptionPane.showMessageDialog(null, "Esse cidadão não está cadastrado!");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void consultarIDCidadaoCarteira() {
		// 1: Definir o comando SQL
		String sql = "SELECT nome, cpf from Cidadao where id_cidadao = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, id);
			// 4: Executa o comando e guarda
			// o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();
			// 5: itera sobre o resultado
			if (rs.next()) {
				nome = rs.getString("nome");
				cpf = rs.getString("cpf");
			}
			 else if (!rs.next()){
				 JOptionPane.showMessageDialog(null, "Esse ID não existe nao banco de dados!!!");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void consultarPeloCPF() {
		// 1: Definir o comando SQL
		String sql = "SELECT nome, dtNascimento from Cidadao where cpf = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, cpf);
			// 4: Executa o comando e guarda
			// o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();
			// 5: itera sobre o resultado
			if (rs.next()) {
				nome = rs.getString("nome");
				setDtNascimento(rs.getDate("dtNascimento"));
			}
			 else if (!rs.next()){
				 JOptionPane.showMessageDialog(null, "Esse cidadão não está cadastrado!");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String consultarPeloNome() {
		// 1: Definir o comando SQL
		String sql = "SELECT id_cidadao FROM Cidadao where cpf = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, cpf);
			// 4: Executa o comando e guarda
			// o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();
			// 5: itera sobre o resultado
			if (rs.next()) {
				id = rs.getString("id_cidadao");
			}
			 else if (!rs.next()){
				 JOptionPane.showMessageDialog(null, "Esse cidadão não está cadastrado!");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public void consultarCPFCidadao() {
		// 1: Definir o comando SQL
		String sql = "SELECT nome, dtNascimento from Cidadao where cpf = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, cpf);
			// 4: Executa o comando e guarda
			// o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();
			// 5: itera sobre o resultado
			if (rs.next()) {
				nome = rs.getString("nome");
				setDtNascimento(rs.getDate("dtNascimento"));
			}
			 else if (!rs.next()){
				 JOptionPane.showMessageDialog(null, "Esse cidadão não está cadastrado!");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean existeCidadao() throws Exception{
		String sql = "SELECT primeira_dose FROM carteira_vacinacao WHERE id_cidadao = ?";
		
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection conn = factory.obtemConexao();
		PreparedStatement ps = conn.prepareStatement(sql)){
		ps.setString(1, id);

			try (ResultSet rs = ps.executeQuery()){
					return rs.next();
				}
			}
		}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public boolean apagarC() {
		boolean encontrado = false;
		String sql = "DELETE FROM Cidadao where cpf = ?";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, cpf);
			if (ps.executeUpdate() == 1) {
				encontrado = true;
				 JOptionPane.showMessageDialog(null, "Cidadão excluído com sucesso.");
			} else {
				encontrado = false;
				// JOptionPane.showMessageDialog(null, "Esse CPF não está cadastrado!");
			}
		} catch (Exception e) {
			
		}
		
		return encontrado;
	}
	
	
}

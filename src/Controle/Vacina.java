package Controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Vacina {
	
	private String nome;
	private String fabricante;
	private int qtdeDoses;
	private int intervalo;
	private int eficacia;
	private String id;
	private LocalDate validade;
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public int getQtdeDoses() {
		return qtdeDoses;
	}
	public void setQtdeDoses(int qtdeDoses) {
		this.qtdeDoses = qtdeDoses;
	}
	public int getIntervalo() {
		return intervalo;
	}
	public void setIntervalo(int intervalo) {
		this.intervalo = intervalo;
	}
	public int getEficacia() {
		return eficacia;
	}
	public void setEficacia(int eficacia) {
		this.eficacia = eficacia;
	}

	public LocalDate getValidade() {
		return validade;
	}
	
	public String getValidadeFormatado() {
		return formato.format(validade);
	}
	
	public void setValidade(String v) {
		validade = LocalDate.parse(v, formato);
	}
	
	public void setValidade(java.sql.Date v) {
		validade = v.toLocalDate();
	}
	
	public void inserir() {
		// 1: Definir o comando SQL
		String sql = "INSERT INTO vacina(nome, fabricante, qtde_doses, intervalo_doses, validade, eficacia) VALUES (?, ?, ?, ?, ?, ?)";
		
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			
			// 4: Preenche os dados faltantes
			ps.setString(1, nome);
			ps.setString(2, fabricante);
			ps.setInt(3, qtdeDoses);
			ps.setInt(4, intervalo);
			ps.setDate(5, java.sql.Date.valueOf(validade));
			ps.setInt(6, eficacia);
			
			// 5: Executa o comando
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Vacina cadastrada com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Vacina já cadastrada.");
		}
	}
	
	public boolean existeVacina() throws Exception{
		String sql = "SELECT primeira_dose FROM carteira_vacinacao WHERE id_vacina = ?";
		
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection conn = factory.obtemConexao();
		PreparedStatement ps = conn.prepareStatement(sql)){
		ps.setString(1, id);

			try (ResultSet rs = ps.executeQuery()){
					return rs.next();
				}
			}
		}
	
	public void consultar() {
		// 1: Definir o comando SQL
		String sql = "SELECT nome, fabricante, qtde_doses, intervalo_doses, validade, eficacia FROM vacina where nome = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, nome);
			// 4: Executa o comando e guarda
			// o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();
			// 5: itera sobre o resultado
			if (rs.next()) {
			//	nome = rs.getString("nome");
				setValidade(rs.getDate("validade"));
		//		dtNascimento = rs.getDate("dtNascimento");
				fabricante = rs.getString("fabricante");
				qtdeDoses = rs.getInt("qtde_doses");
				intervalo = rs.getInt("intervalo_doses");
				eficacia = rs.getInt("eficacia");
			}
			 else if (!rs.next()){
				 JOptionPane.showMessageDialog(null, "Essa vacina não foi cadastrada!");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void consultarNome() {
		// 1: Definir o comando SQL
		String sql = "SELECT nome FROM vacina ";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
		//	ps.setString(1, id);
			// 4: Executa o comando e guarda
			// o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();
			// 5: itera sobre o resultado
			if (rs.next()) {
				nome = rs.getString("nome");
			}
		
		 else if (!rs.next()){
			 JOptionPane.showMessageDialog(null, "Essa vacina não foi cadastrada!");
			
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String[] listarVacinas() {

        ArrayList<String> vacinas = new ArrayList<>();

        //1: Definir o comando SQL
        String sql = "SELECT nome FROM vacina";
        //2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try ( Connection c = factory.obtemConexao()) {
        	//3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Executa o comando e guarda
            //o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            //5: itera sobre o resultado
            while (rs.next()) {
                vacinas.add(rs.getString("nome"));
            } // while

        } catch (Exception e) {
            e.printStackTrace();
        }

        // converte ArrayList em []
        return vacinas.toArray(new String[vacinas.size()]);
    }

	
	public void consultarIDVacina() {
		// 1: Definir o comando SQL
		String sql = "SELECT nome, qtde_doses, intervalo_doses FROM vacina where id_vacina = ?";
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
				qtdeDoses = rs.getInt("qtde_doses");
				intervalo = rs.getInt("intervalo_doses");
			}
			 else if (!rs.next()){
				 JOptionPane.showMessageDialog(null, "Essa vacina não foi cadastrada!");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void consultarNomeVacina() {
		// 1: Definir o comando SQL
		String sql = "SELECT qtde_doses, intervalo_doses FROM vacina where nome = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, nome);
			// 4: Executa o comando e guarda
			// o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();
			// 5: itera sobre o resultado
			if (rs.next()) {
				qtdeDoses = rs.getInt("qtde_doses");
				intervalo = rs.getInt("intervalo_doses");
			}
			 else if (!rs.next()){
				 JOptionPane.showMessageDialog(null, "Essa vacina não foi cadastrada!");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String consultarID() {
		// 1: Definir o comando SQL
		String sql = "SELECT id_vacina FROM vacina where nome = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, nome);
			// 4: Executa o comando e guarda
			// o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();
			// 5: itera sobre o resultado
			if (rs.next()) {
				id = rs.getString("id_vacina");
			}
			 else if (!rs.next()){
				 JOptionPane.showMessageDialog(null, "Essa vacina não foi cadastrada!");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public void atualizar() {
		// 1: Definir o comando SQL
		String sql = "UPDATE vacina SET fabricante = ?, qtde_doses = ?, intervalo_doses = ?, validade = ?, eficacia = ?  where nome = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setString(1, fabricante);
			ps.setInt(2, qtdeDoses);
			ps.setInt(3, intervalo);
			ps.setDate(4, java.sql.Date.valueOf(validade));
			ps.setInt(5, eficacia);
			ps.setString(6, id);
			
			// 5: Executa o comando
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void apagar() {
		// 1: Definir o comando SQL
		String sql = "DELETE FROM vacina WHERE nome = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setString(1, nome);
			// 5: Executa o comando
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean apagarC() {
		boolean encontrado = false;
		String sql = "DELETE FROM vacina where nome = ?";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, nome);
			if (ps.executeUpdate() == 1) {
				encontrado = true;
				 JOptionPane.showMessageDialog(null, "Vacina excluída com sucesso.");
			} else {
				encontrado = false;
				// JOptionPane.showMessageDialog(null, "Esse CPF não está cadastrado!");
			}
		} catch (Exception e) {
			
		}
		
		return encontrado;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}

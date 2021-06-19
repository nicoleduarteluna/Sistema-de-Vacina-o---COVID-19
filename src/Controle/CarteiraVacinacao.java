package Controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class CarteiraVacinacao {

	private String id;
	private String id_cidadao;
	private String id_vacina;
	
	private LocalDate primeiraDose;
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public LocalDate getPrimeiraDose() {
		return primeiraDose;
	}
	
	public String getPrimeiraDoseFormatada() {
		return formato.format(primeiraDose);
	}
	
	public void setPrimeiraDose(String p) {
		primeiraDose = LocalDate.parse(p, formato);
	}
	
	public void setPrimeiraDose(java.sql.Date p) {
		primeiraDose = p.toLocalDate();
	}
	
	private LocalDate segundaDose;
	
	public LocalDate getSegundaDose() {
		return segundaDose;
	}
	
	public String getSegundaDoseFormatada() {
		if (segundaDose != null && !"".equals(segundaDose)) {
			return formato.format(segundaDose);
		} else {
			return "";
		}
	}
	
	public void setSegundaDose(String s) {
		if (s != null && !"".equals(s)) {
			segundaDose = LocalDate.parse(s, formato);
		}
	}
	
	public void setSegundaDose(java.sql.Date p) {
			segundaDose = p.toLocalDate();
	}

	public String getId_cidadao() {
		return id_cidadao;
	}

	public void setId_cidadao(String id_cidadao) {
		this.id_cidadao = id_cidadao;
	}

	public String getId_vacina() {
		return id_vacina;
	}

	public void setId_vacina(String id_vacina) {
		this.id_vacina = id_vacina;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void inserirRegistrosUmaDose() {
		// 1: Definir o comando SQL
		String sql = "INSERT INTO carteira_vacinacao(id_cidadao, id_vacina, primeira_dose) VALUES (?, ?, ?)";
		
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			
			// 4: Preenche os dados faltantes
			ps.setString(1, id_cidadao);
			ps.setString(2, id_vacina);
			ps.setDate(3, java.sql.Date.valueOf(primeiraDose));
	
			// 5: Executa o comando
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void inserirRegistrosDuasDoses() {
		// 1: Definir o comando SQL
		String sql = "INSERT INTO carteira_vacinacao(id_cidadao, id_vacina, primeira_dose, segunda_dose) VALUES (?, ?, ?, ?)";
		
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			@SuppressWarnings("unused")
			ResultSet rs = ps.executeQuery();
			
			if(primeiraDose.getDayOfMonth() >  segundaDose.getDayOfMonth()) {
			// 4: Preenche os dados faltantes
			ps.setString(1, id_cidadao);
			ps.setString(2, id_vacina);
			ps.setDate(3, java.sql.Date.valueOf(primeiraDose));
			ps.setDate(4, java.sql.Date.valueOf(segundaDose));
			}
			   else if (primeiraDose.getDayOfMonth() < (segundaDose.getDayOfMonth())) {
			        JOptionPane.showMessageDialog(null, "A data da segunda dose não pode ser anterior a primeira dose!");
			        primeiraDose.getDayOfMonth();
			        
			   }
			// 5: Executa o comando
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void inserirRegistrosPrimeiraDose() {
		// 1: Definir o comando SQL
		String sql = "INSERT INTO carteira_vacinacao(id_cidadao, id_vacina, primeira_dose) VALUES (?, ?, ?)";
		
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			
			// 4: Preenche os dados faltantes
			ps.setString(1, id_cidadao);
			ps.setString(2, id_vacina);
			ps.setDate(3, java.sql.Date.valueOf(primeiraDose));

			
			// 5: Executa o comando
			ps.execute();
			JOptionPane.showMessageDialog(null, "Primeira Dose registrada com sucesso!");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Este cidadão já tomou uma outra vacina.");
		}
	}
	
	public void consultarPrimeiraDose() {
		// 1: Definir o comando SQL
		String sql = "SELECT primeira_dose FROM carteira_vacinacao where id_cidadao = ? and id_vacina = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, id_cidadao);
			ps.setString(2, id_vacina);
			// 4: Executa o comando e guarda
			// o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();
			// 5: itera sobre o resultado
			if (rs.next()) {
				setPrimeiraDose(rs.getDate("primeira_dose"));	
		//		setSegundaDose(rs.getDate("segunda_dose"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void consultarSegundaDose() {
		// 1: Definir o comando SQL
		String sql = "SELECT segunda_dose FROM carteira_vacinacao where id_cidadao = ? and id_vacina = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, id_cidadao);
			ps.setString(2, id_vacina);
			// 4: Executa o comando e guarda
			// o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();
			// 5: itera sobre o resultado
			if (rs.next()) {
				setSegundaDose(rs.getDate("segunda_dose"));
			}
			
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}
	
	
	public void atualizar() {
		// 1: Definir o comando SQL
		String sql = "UPDATE carteira_vacinacao SET segunda_dose = ?  where id_cidadao = ? and id_vacina = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setDate(1, java.sql.Date.valueOf(segundaDose));
			ps.setString(2, id_cidadao);
			ps.setString(3, id_vacina);

			// 5: Executa o comando
			ps.execute();
			JOptionPane.showMessageDialog(null, "Segunda Dose registrada com sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String contar() {
		// 1: Definir o comando SQL
		String sql = "SELECT COUNT(primeira_dose) FROM carteira_vacinacao WHERE id_cidadao = ? and id_vacina = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, id_cidadao);
			ps.setString(2, id_vacina);

			// 5: Executa o comando
			ps.execute();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.print(sql);
		return sql;
	}
	
	public boolean existe(String cidadao, String vacina) throws Exception{
		String sql = "SELECT primeira_dose FROM carteira_vacinacao WHERE id_vacina = ? AND id_cidadao = ?";
		
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection conn = factory.obtemConexao();
		PreparedStatement ps = conn.prepareStatement(sql)){
		ps.setString(1, id_vacina);
		ps.setString(2, id_cidadao);
			try (ResultSet rs = ps.executeQuery()){
					return rs.next();
				}
			}
		}
	
	
	public boolean existeSegundaDose(String cidadao, String vacina) throws Exception{
		String sql = "SELECT segunda_dose FROM carteira_vacinacao WHERE id_vacina = ? AND id_cidadao = ?";
		
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection conn = factory.obtemConexao();
		PreparedStatement ps = conn.prepareStatement(sql)){
		ps.setString(1, id_vacina);
		ps.setString(2, id_cidadao);
			try (ResultSet rs = ps.executeQuery()){
					return rs.next();
				}
			}
		}
	
}

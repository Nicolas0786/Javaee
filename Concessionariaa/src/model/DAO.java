package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {

	/** The driver. */
	// Parametros de conexao
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/DBCONCEISONARIA?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "Nicolas0786345";

	// Metodos de conexao

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar() {
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	// teste de conexao

	// public void testeConexao() {
	// try { Connection con = conectar();
	// System.out.println(con); con.close();
	// } catch (Exception e) {
	// System.out.println(e); } }

	// ** crud create **//

	/**
	 * Inserir carro.
	 *
	 * @param carro the carro
	 */
	public void inserirCarro(JavaBeans carro) {
		String query = "INSERT INTO DBCONCEISONARIA.carro (marca, modelo, anomodelo, anofabricacao, placa, cor, qtdportas, datainsercaocarro, valor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			// abrir conexao
			Connection con = conectar();
			// preparar a query para a execução no banco
			PreparedStatement pst = con.prepareStatement(query);
			// substituir os parametros (?) pelo conteudo das variaveis javaBeans
			pst.setString(1, carro.getMarca());
			pst.setString(2, carro.getModelo());
			pst.setInt(3, carro.getAnoModelo());
			pst.setInt(4, carro.getAnoFabricacao());
			pst.setString(5, carro.getPlaca());
			pst.setString(6, carro.getCor());
			pst.setInt(7, carro.getQtdPortas());
			pst.setObject(8, carro.getDataInsercaoCarro());
			pst.setLong(9, carro.getValor());
			// executar query
			pst.executeUpdate();
			// encerrar conexao com o banco
			con.close();

		} catch (Exception e) {
			System.out.println("Erro ao inserir novo carro");
			System.out.println("Erro" + e);
		}
	}

	// Crude read

	/**
	 * Listar carros.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarCarros() {
		// criando obejto para acessar a classe javaBeans
		ArrayList<JavaBeans> carros = new ArrayList<>();
		String query = "SELECT * FROM DBCONCEISONARIA.carro ORDER BY marca";

		try {
			Connection con = conectar();
			PreparedStatement pstm = con.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			// laço abaixo sera executado enquanto estiver carros
			while (rs.next()) {
				JavaBeans carro = new JavaBeans();
				// variaveis de apoio que recebem os dados do banco
				carro.setIdCarro(Integer.parseInt(rs.getString(1)));
				carro.setMarca(rs.getString(2));
				carro.setModelo(rs.getString(3));
				carro.setAnoModelo(Integer.parseInt(rs.getString(4)));
				carro.setAnoFabricacao(Integer.parseInt(rs.getString(5)));
				carro.setPlaca(rs.getString(6));
				carro.setCor(rs.getString(7));
				carro.setQtdPortas(Integer.parseInt(rs.getString(8)));
				carro.setDataInsercaoCarro(LocalDate.parse(rs.getString(9)));
				carro.setValor(Long.parseLong(rs.getString(10)));
				carros.add(carro);
			}
			con.close();
			return carros;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

	/**
	 * Listar carros pdf.
	 *
	 * @return the array list
	 */
	// select pdf
	public ArrayList<JavaBeans> listarCarrosPdf() {
		ArrayList<JavaBeans> carrosPdf = new ArrayList<>();
		String query = "SELECT marca, modelo, anomodelo, anofabricacao, placa, cor, qtdportas, valor FROM DBCONCEISONARIA.carro ORDER BY marca";

		try {
			Connection con = conectar();
			PreparedStatement pstm = con.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				JavaBeans carro = new JavaBeans();
				// variaveis de apoio que recebem os dados do banco
				carro.setMarca(rs.getString(1));
				carro.setModelo(rs.getString(2));
				carro.setAnoModelo(Integer.parseInt(rs.getString(3)));
				carro.setAnoFabricacao(Integer.parseInt(rs.getString(4)));
				carro.setPlaca(rs.getString(5));
				carro.setCor(rs.getString(6));
				carro.setQtdPortas(Integer.parseInt(rs.getString(7)));
				carro.setValor(Long.parseLong(rs.getString(8)));
				carrosPdf.add(carro);
			}
			con.close();
			return carrosPdf;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

	// crud update
	/**
	 * Selecionar carro.
	 *
	 * @param carro the carro
	 */
	// selecionar o carro
	public void selecionarCarro(JavaBeans carro) {
		String query = "SELECT * FROM DBCONCEISONARIA.carro WHERE idcarro = ?";
		try {
			Connection con = conectar();
			PreparedStatement pstm = con.prepareStatement(query);
			// pstm.setString(1, String.valueOf(carro.getIdCarro()));
			pstm.setInt(1, carro.getIdCarro());
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				// setar as variaveis javaBeans
				carro.setIdCarro(Integer.parseInt(rs.getString(1)));
				carro.setMarca(rs.getString(2));
				carro.setModelo(rs.getString(3));
				carro.setAnoModelo(Integer.parseInt(rs.getString(4)));
				carro.setAnoFabricacao(Integer.parseInt(rs.getString(5)));
				carro.setPlaca(rs.getString(6));
				carro.setCor(rs.getString(7));
				carro.setQtdPortas(Integer.parseInt(rs.getString(8)));
				carro.setDataInsercaoCarro(LocalDate.parse(rs.getString(9)));
				carro.setValor(Long.parseLong(rs.getString(10)));

			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// editar o carro

	/**
	 * Alterar carro.
	 *
	 * @param carro the carro
	 */
	public void alterarCarro(JavaBeans carro) {
		String query = "UPDATE DBCONCEISONARIA.carro SET marca=?, modelo=?, anomodelo=?, anofabricacao=?, placa=?, cor=?, qtdportas=?, datainsercaocarro=?, valor=? WHERE idcarro=?";
		try {
			Connection con = conectar();
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, carro.getMarca());
			pstm.setString(2, carro.getModelo());
			pstm.setInt(3, carro.getAnoModelo());
			pstm.setInt(4, carro.getAnoFabricacao());
			pstm.setString(5, carro.getPlaca());
			pstm.setString(6, carro.getCor());
			pstm.setInt(7, carro.getQtdPortas());
			pstm.setObject(8, carro.getDataInsercaoCarro());
			pstm.setLong(9, carro.getValor());
			pstm.setInt(10, carro.getIdCarro());
			pstm.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// crude delete

	/**
	 * Deletar carro.
	 *
	 * @param carro the carro
	 */
	public void deletarCarro(JavaBeans carro) {
		String query = "DELETE FROM DBCONCEISONARIA.carro WHERE idcarro=?";

		try {
			Connection con = conectar();
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, carro.getIdCarro());
			pstm.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

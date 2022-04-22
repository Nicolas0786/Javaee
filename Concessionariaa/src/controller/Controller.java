package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;
import model.JavaBeans;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete", "/report" })
public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The dao. */
	DAO dao = new DAO();
	
	/** The carro. */
	JavaBeans carro = new JavaBeans();

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		super();

	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * teste de conexao dao.testeConexao();
		 */

		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			carros(request, response);
		} else if (action.equals("/insert")) {
			cadastrarCarro(request, response);
		} else if (action.equals("/select")) {
			listarCarros(request, response);
		} else if (action.equals("/update")) {
			editarCarros(request, response);
		} else if (action.equals("/delete")) {
			removerCarros(request, response);
		} else if (action.equals("/report")) {
			gerarRelatorio(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	/**
	 * Carros.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Listar carros
	protected void carros(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.sendRedirect("concessionaria.jsp");
		// Criando um objeo que ira receber os dados Javabeans
		ArrayList<JavaBeans> lista = dao.listarCarros();
		// teste de recibimento da lista
		// for(int i=0; i < lista.size(); i++) {
		// System.out.println(lista.get(i).getIdCarro());
		// System.out.println(lista.get(i).getMarca());
		// System.out.println(lista.get(i).getModelo());
		// System.out.println(lista.get(i).getAnoModelo());
		// System.out.println(lista.get(i).getAnoFabricacao());
		// System.out.println(lista.get(i).getPlaca());
		// System.out.println(lista.get(i).getCor());
		// System.out.println(lista.get(i).getQtdPortas());
		// System.out.println(lista.get(i).getDataInsercaoCarro());
		// System.out.println(lista.get(i).getValor());
		// }

		// Encaminhar a lista ao documento agenda.jsp
		request.setAttribute("carros", lista);
		RequestDispatcher rd = request.getRequestDispatcher("concessionaria.jsp");
		rd.forward(request, response);
	}

	/**
	 * Cadastrar carro.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Novo carro
	protected void cadastrarCarro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// teste de recebimento dos dados do formulario
		// System.out.println(request.getParameter("marca"));
		// System.out.println(request.getParameter("modelo"));
		// System.out.println(request.getParameter("anomod"));
		// System.out.println(request.getParameter("anofab"));
		// System.out.println(request.getParameter("placa"));
		// System.out.println(request.getParameter("cor"));
		// System.out.println(request.getParameter("qtdporta"));
		// System.out.println(request.getParameter("datainsercao"));
		// System.out.println(request.getParameter("valor"));

		// Setar as variaveis JavaBeans
		carro.setMarca(request.getParameter("marca"));
		carro.setModelo(request.getParameter("modelo"));
		carro.setAnoModelo(Integer.parseInt(request.getParameter("anomod")));
		carro.setAnoFabricacao(Integer.parseInt(request.getParameter("anofab")));
		carro.setPlaca(request.getParameter("placa"));
		carro.setCor(request.getParameter("cor"));
		carro.setQtdPortas(Integer.parseInt(request.getParameter("qtdporta")));
		// olhar esse data insercao
		carro.setDataInsercaoCarro(LocalDate.parse(request.getParameter("datainsercao")));
		carro.setValor(Long.parseLong(request.getParameter("valor")));

		// invocar o metodo inserir carro passando o objeto contato
		dao.inserirCarro(carro);
		// redirecionar para o documento carro.jsp
		response.sendRedirect("main");

	}

	/**
	 * Listar carros.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	// Editar carro
	protected void listarCarros(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// Recebimento do id do contato que sera editado
		// String idCarro = request.getParameter("idCarro");
		// System.out.println(idCarro);
		// Setar a variavel JavaBeans
		carro.setIdCarro(Integer.parseInt(request.getParameter("idCarro")));
		// executar o metodo selecionarCarro (dao)
		dao.selecionarCarro(carro);
		// teste de recebimeto
		// System.out.println(carro.getIdCarro());
		// System.out.println(carro.getMarca());
		// System.out.println(carro.getModelo());
		// System.out.println(carro.getAnoModelo());
		/// System.out.println(carro.getAnoFabricacao());
		/// System.out.println(carro.getPlaca());
		// System.out.println(carro.getCor());
		// System.out.println(carro.getQtdPortas());
		// System.out.println(carro.getDataInsercaoCarro());
		// System.out.println(carro.getValor());
		// setar os atributos dos formularios com o conteudo JavaBeans
		request.setAttribute("idCarro", carro.getIdCarro());
		request.setAttribute("marca", carro.getMarca());
		request.setAttribute("modelo", carro.getModelo());
		request.setAttribute("anomod", carro.getAnoModelo());
		request.setAttribute("anofab", carro.getAnoFabricacao());
		request.setAttribute("placa", carro.getPlaca());
		request.setAttribute("cor", carro.getCor());
		request.setAttribute("qtdporta", carro.getQtdPortas());
		request.setAttribute("datainsercao", carro.getDataInsercaoCarro());
		request.setAttribute("valor", carro.getValor());
		// Encaminhar ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	//

	/**
	 * Editar carros.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void editarCarros(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// teste de recebimento
		// System.out.println(request.getParameter("idCarro"));
		// System.out.println(request.getParameter("marca"));
		// System.out.println(request.getParameter("modelo"));
		// System.out.println(request.getParameter("anomod"));
		// System.out.println(request.getParameter("anofab"));
		// System.out.println(request.getParameter("placa"));
		// System.out.println(request.getParameter("cor"));
		// System.out.println(request.getParameter("qtdporta"));
		// System.out.println(request.getParameter("datainsercao"));
		// System.out.println(request.getParameter("valor"));

		// setar as variaveis JavaBeans
		carro.setIdCarro(Integer.parseInt(request.getParameter("idCarro")));
		carro.setMarca(request.getParameter("marca"));
		carro.setModelo(request.getParameter("modelo"));
		carro.setAnoModelo(Integer.parseInt(request.getParameter("anomod")));
		carro.setAnoFabricacao(Integer.parseInt(request.getParameter("anofab")));
		carro.setPlaca(request.getParameter("placa"));
		carro.setCor(request.getParameter("cor"));
		carro.setQtdPortas(Integer.parseInt(request.getParameter("qtdporta")));
		// olhar esse data insercao
		carro.setDataInsercaoCarro(LocalDate.parse(request.getParameter("datainsercao")));
		carro.setValor(Long.parseLong(request.getParameter("valor")));

		// executar o metado alterarCarro
		dao.alterarCarro(carro);
		// redirecionar para o documento concessionaria.jsp (atualizando as informações)
		response.sendRedirect("main");

	}

	/**
	 * Remover carros.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// remover um carro
	protected void removerCarros(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// recebimento do id do carro a ser excluido (validador.js)
		// String idCarro = request.getParameter("idCarro");
		// int idCArro = Integer.parseInt(request.getParameter("idCarro"));
		// System.out.println(idCarro);
		// setar a variavel idcarro JavaBeans
		carro.setIdCarro(Integer.parseInt(request.getParameter("idCarro")));
		// executar o metodo deletarCarro (dao) passando o objeto carro
		dao.deletarCarro(carro);
		// redirecionar para o documento concessionaria.jsp (atualizando as informações)
		response.sendRedirect("main");

	}

	// gerar relatorio em PDF

	/**
	 * Gerar relatorio.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Document documento = new Document();
		try {
			// tipo de conteudo
			response.setContentType("apllication/pdf");
			// nome do documento
			response.addHeader("Content-Disposition", "inline; filename=" + "carros.pdf");
			// criar o documento
			PdfWriter.getInstance(documento, response.getOutputStream());
			// abrir o documento -> conteudo
			documento.open();
			documento.add(new Paragraph("Lista de carros"));
			documento.add(new Paragraph(" "));
			// criar uma tabela
			PdfPTable tabela = new PdfPTable(8);
			// cabeçalho
			PdfPCell col1 = new PdfPCell(new Paragraph("Marca"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Modelo"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Ano Modelo"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Ano Fabricação"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Placa"));
			PdfPCell col6 = new PdfPCell(new Paragraph("Cor"));
			PdfPCell col7 = new PdfPCell(new Paragraph("Quantidade de Portas"));
			PdfPCell col8 = new PdfPCell(new Paragraph("Valor"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);
			tabela.addCell(col6);
			tabela.addCell(col7);
			tabela.addCell(col8);
			// popular a tabela com os carros
			ArrayList<JavaBeans> lista = dao.listarCarrosPdf();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getMarca());
				tabela.addCell(lista.get(i).getModelo());
				tabela.addCell(String.valueOf((lista.get(i).getAnoModelo())));
				tabela.addCell(String.valueOf((lista.get(i).getAnoFabricacao())));
				tabela.addCell(lista.get(i).getPlaca());
				tabela.addCell(lista.get(i).getCor());
				tabela.addCell(String.valueOf((lista.get(i).getQtdPortas())));
				tabela.addCell(String.valueOf((lista.get(i).getValor())));

			}
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
	}
}


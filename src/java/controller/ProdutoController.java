package controller;

import dao.ProdutoDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;

@WebServlet(name = "Produtos", urlPatterns = {"/ProdutoController"})
public class ProdutoController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/produto.jsp";
    private static String LIST_PRODUTO = "/listProduto.jsp";
    private static String Erro = "/paginaDeErro.jsp";
    private ProdutoDao dao;

    public ProdutoController() {
        super();
        dao = new ProdutoDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int Id = Integer.parseInt(request.getParameter("Id"));
            dao.deleteProduto(Id);
            forward = LIST_PRODUTO;
            request.setAttribute("produtos", dao.getAllProdutos());

        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int Id = Integer.parseInt(request.getParameter("Id"));
            Produto produto = dao.getProdutoById(Id);
            request.setAttribute("produto", produto);

        } else if (action.equalsIgnoreCase("listProduto")) {
            forward = LIST_PRODUTO;
            request.setAttribute("produtos", dao.getAllProdutos());

        } else {
            forward = INSERT_OR_EDIT;

        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        Produto produto = new Produto();
        produto.setNome(request.getParameter("nome"));
        produto.setVeiculo(request.getParameter("veiculo"));
        produto.setPesoLiquido(Float.parseFloat(request.getParameter("pesoliquido")));
        produto.setPesoBruto(Float.parseFloat(request.getParameter("pesobruto")));
        //produto.setVeiculo(request.getParameter("pesobruto"));
        String id = request.getParameter("id");
        float PL = Float.parseFloat(request.getParameter("pesoliquido"));
        float PB = Float.parseFloat(request.getParameter("pesobruto"));
          if (PB >= PL) {
            if (id == null || id.isEmpty()) {
                dao.addProduto(produto);
            } else {

                produto.setId(Integer.parseInt(id));
                dao.updateProduto(produto);
            }

        } else {
          RequestDispatcher view = request.getRequestDispatcher(Erro);
            request.setAttribute("produtos", dao.getAllProdutos());
            view.forward(request, response);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_PRODUTO);
        request.setAttribute("produtos", dao.getAllProdutos());
        view.forward(request, response);
    }
}

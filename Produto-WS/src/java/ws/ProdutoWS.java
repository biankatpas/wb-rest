/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dao.ProdutoDAO;
import dao.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelo.Produto;
import modelo.Usuario;

/**
 * REST Web Service
 *
 * @author biankatpas
 */
@Path("generic")
public class ProdutoWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProdutoWS
     */
    public ProdutoWS() {
    }

    /**
     * Retrieves representation of an instance of ws.ProdutoWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "Hello, Produto-WS!";
    }
    
//    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("usuario/get/{login}")
    public String getUsuario(@PathParam("login") String login)
    {
        Usuario u = new Usuario();
        u.setLogin(login);
        
        UsuarioDAO dao = new UsuarioDAO();
        u = dao.buscar(u);
        
        Gson g = new Gson();
        return g.toJson(u);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("usuario/list")
    public String listUsuarios()
    {
        List<Usuario> lista = new ArrayList<>();
        UsuarioDAO dao = new UsuarioDAO();
        lista = dao.listar();
        
        Gson g = new Gson();
        return g.toJson(lista);
    }
       
    @POST
    @Consumes({"application/json"})
    @Path("usuario/inserir")
    public boolean inserir(String content){
        Gson g = new Gson();
        Usuario u = (Usuario) g.fromJson(content, Usuario.class);
        UsuarioDAO dao = new UsuarioDAO();  
        return dao.inserir(u);
}

    /**
     * PUT method for updating or creating an instance of ProdutoWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes("application/json")
    @Path("usuario/alterar")
    public void alterar(String content) {
        Gson g = new Gson();
        Usuario u = (Usuario) g.fromJson(content, Usuario.class);
        UsuarioDAO dao = new UsuarioDAO();  
        dao.atualizar(u);
    }
    
   @DELETE
   @Path("usuario/excluir/{login}")
    public boolean excluir(@PathParam("login") String login)
    {    
        Usuario u = new Usuario();
        u.setLogin(login);
        
        UsuarioDAO dao = new UsuarioDAO();
        u = dao.buscar(u);
        return dao.excluir(u);
    }
    
//    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("produto/get/{descricao}")
    public String getProduto(@PathParam("descricao") String descricao)
    {
        Produto p = new Produto();
        p.setDescricao(descricao);
        
        ProdutoDAO dao = new ProdutoDAO();
        p = dao.buscar(p);
        
        Gson g = new Gson();
        return g.toJson(p);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("produto/list")
    public String listProdutos()
    {
        List<Produto> lista = new ArrayList<>();
        ProdutoDAO dao = new ProdutoDAO();
        lista = dao.listar();
        
        Gson g = new Gson();
        return g.toJson(lista);
    }

    @POST
    @Consumes({"application/json"})
    @Path("produto/inserir")
    public boolean inserirProduto(String content){
        Gson g = new Gson();
        Produto p = (Produto) g.fromJson(content, Produto.class);
        ProdutoDAO dao = new ProdutoDAO();  
        return dao.inserir(p);
}

    /**
     * PUT method for updating or creating an instance of ProdutoWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes("application/json")
    @Path("produto/alterar")
    public void alterarProduto(String content) {
        Gson g = new Gson();
        Produto p = (Produto) g.fromJson(content, Produto.class);
        ProdutoDAO dao = new ProdutoDAO();  
        dao.atualizar(p);
    }
    
   @DELETE
   @Path("produto/excluir/{descricao}")
    public boolean excluirProduto(@PathParam("descricao") String descricao)
    {    
        Produto p = new Produto();
        p.setDescricao(descricao);
        
        ProdutoDAO dao = new ProdutoDAO();
        p = dao.buscar(p);
        return dao.excluir(p);
    }
}

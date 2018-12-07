/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Produto;

/**
 *
 * @author biankatpas
 */
public class ProdutoDAO {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
    public ProdutoDAO()
    {
    
    }
    
    public boolean inserir(Produto produto)
    {
        String sql = "INSERT INTO produto(descricao,vencimento,vendedor) VALUES(?,?,?)";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, produto.getDescricao());
            pst.setString(2, produto.getVencimento());
            pst.setString(3, produto.getVendedor());
            
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    }
    public boolean atualizar(Produto produto)
    {
        String sql = "UPDATE produto set vencimento=?,vendedor=? where descricao=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
          
            pst.setString(1, produto.getVencimento());
            pst.setString(2, produto.getVendedor());
            pst.setString(3, produto.getDescricao());
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    }
    public boolean excluir(Produto produto)
    {
        String sql = "DELETE FROM produto where descricao=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            pst.setString(1, produto.getDescricao());
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    }
    
    public List<Produto> listar()
    {
         String sql = "SELECT * FROM produto";
        List<Produto> retorno = new ArrayList<>();
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Produto item = new Produto();
                item.setDescricao(res.getString("descricao"));
                item.setVencimento(res.getString("vencimento"));
                item.setVendedor(res.getString("vendedor"));
                
                retorno.add(item);
            }
               
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;
    
    }

    public Produto buscar(Produto produto)
    {
        String sql = "SELECT * FROM produto where descricao=?";
        Produto retorno = null;
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
           
            pst.setString(1, produto.getDescricao());
            ResultSet res = pst.executeQuery();
            
            if(res.next())
            {
                retorno = new Produto();
                retorno.setDescricao(res.getString("descricao"));
                retorno.setVencimento(res.getString("vencimento"));
                retorno.setVendedor(res.getString("vendedor"));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;
    
    }

}

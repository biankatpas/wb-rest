/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package consumir;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import modelo.Produto;
import modelo.Usuario;

/**
 *
 * @author biankatpas
 */
public class HttpTeste {
 
	private final String USER_AGENT = "Mozilla/5.0";
 
	public static void main(String[] args) throws Exception {
 
		HttpTeste http = new HttpTeste();
                Gson g = new Gson();
                
                Usuario u = new Usuario();
                List<Usuario> listaU = new ArrayList<>();
                Produto p = new Produto();
                List<Produto> listaP = new ArrayList<>();
                
                Type usuarioType = new TypeToken<Usuario>() {}.getType();
                Type listUsuarioType = new TypeToken<List<Usuario>>() {}.getType();
                Type produtoType = new TypeToken<Produto>() {}.getType();
                Type listProdutoType = new TypeToken<List<Produto>>() {}.getType();
                
                int test = 6;
                
                System.out.println("Testing: send Http request");
                String chamadaWS = "";
                String json = "";
                String retorno = "";
                
                switch(test)
                {
                    case 1: // listUsuarios
                        chamadaWS = "http://localhost:8084/Produto-WS/webresources/generic/usuario/list";
                        json = http.sendGet(chamadaWS, "GET");
                        
                        listaU = g.fromJson(json, listUsuarioType);
                        for (int i = 0; i < listaU.size(); i++)
                        {   
                            System.out.println("-----------------------------------");
                            System.out.println(listaU.get(i).getLogin());
                            System.out.println(listaU.get(i).getSenha());
                            System.out.println(listaU.get(i).getEmail());
                            System.out.println(listaU.get(i).getPerfil());
                        }
                        
                        System.out.println("-----------------------------------");
                        
                        break;
                    
                    case 2: // getUsuario
                        chamadaWS = "http://localhost:8084/Produto-WS/webresources/generic/usuario/get/biankatpas";
                        json = http.sendGet(chamadaWS, "GET");
                        
                        u = g.fromJson(json, usuarioType);
                        
                        System.out.println("-----------------------------------");
                        System.out.println(u.getLogin());
                        System.out.println(u.getSenha());
                        System.out.println(u.getEmail());
                        System.out.println(u.getPerfil());
                        System.out.println("-----------------------------------");
                        break;
                        
                    case 3: // inserirUsuario
                        u.setLogin("Mel");
                        u.setSenha("linda");
                        u.setEmail("mel@dog.com");
                        u.setPerfil("cliente");
                        
                        json = g.toJson(u, usuarioType);
                        
                        chamadaWS = "http://localhost:8084/Produto-WS/webresources/generic/usuario/inserir";
                        http.sendPost(chamadaWS, json, "POST");
                        
                        break;
                        
                    case 4: // alterarUsuario
                        u.setLogin("biankatpas");
                        u.setSenha("4312");
                        u.setEmail("aaa@gmail.com");
                        u.setPerfil("dev");
                        
                        chamadaWS = "http://localhost:8084/Produto-WS/webresources/generic/usuario/alterar";
                        json = g.toJson(u, usuarioType);
        
                        http.sendPost(chamadaWS, json, "PUT");
                        
                        break;
                    
                    case 5: // deletarUsuario
                        chamadaWS = "http://localhost:8084/Produto-WS/webresources/generic/usuario/excluir/teste";
                        retorno = http.sendGet(chamadaWS, "DELETE");
                        
                        System.out.println("-----------------------------------");
                        System.out.println(retorno);
                        System.out.println("-----------------------------------");
                        break;
                        
    //    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                    
                    case 6: // listProdutos
                        chamadaWS = "http://localhost:8084/Produto-WS/webresources/generic/produto/list";
                        json = http.sendGet(chamadaWS, "GET");
                        
                        listaP = g.fromJson(json, listProdutoType);
                        for (int i = 0; i < listaP.size(); i++)
                        {   
                            System.out.println("-----------------------------------");
                            System.out.println(listaP.get(i).getDescricao());
                            System.out.println(listaP.get(i).getVencimento());
                            System.out.println(listaP.get(i).getVendedor());
                        }
                        
                        System.out.println("-----------------------------------");
                        
                        break;
                    
                    case 7: // getProduto
                        chamadaWS = "http://localhost:8084/Produto-WS/webresources/generic/produto/get/shimeji";
                        json = http.sendGet(chamadaWS, "GET");
                        
                        p = g.fromJson(json, produtoType);
                        
                        System.out.println("-----------------------------------");
                        System.out.println(p.getDescricao());
                        System.out.println(p.getVencimento());
                        System.out.println(p.getVendedor());
                        System.out.println("-----------------------------------");
                        break;
                        
                    case 8: // inserirProduto
                        p.setDescricao("cogumelo");
                        p.setVencimento("10/12/18");
                        p.setVendedor("Michelle");
                        
                        json = g.toJson(p, produtoType);
                        
                        chamadaWS = "http://localhost:8084/Produto-WS/webresources/generic/produto/inserir";
                        http.sendPost(chamadaWS, json, "POST");
                        
                        break;
                        
                    case 9: // alterarProduto
                        p.setDescricao("cogumelo");
                        p.setVencimento("10/01/19");
                        p.setVendedor("Bianka");
                        
                        chamadaWS = "http://localhost:8084/Produto-WS/webresources/generic/produto/alterar";
                        json = g.toJson(p, produtoType);
        
                        http.sendPost(chamadaWS, json, "PUT");
                        
                        break;
                    
                    case 10: // deletarProduto
                        chamadaWS = "http://localhost:8084/Produto-WS/webresources/generic/produto/excluir/cogumelo";
                        retorno = http.sendGet(chamadaWS, "DELETE");
                        
                        System.out.println("-----------------------------------");
                        System.out.println(retorno);
                        System.out.println("-----------------------------------");
                        break;    
                        
                    default:
                        System.out.println("Opção invalida");
                }
		 
	}
 
	// HTTP GET request
	private String sendGet(String url, String method) throws Exception {
 
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		con.setRequestMethod(method);
 
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		return response.toString();
 
	}
        
        // HTTP POST request
	private void sendPost(String url, String urlParameters, String method) throws Exception {
 
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		//add reuqest header
		con.setRequestMethod(method);
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
 
//		String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
 
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		System.out.println(response.toString());
 
	}
}

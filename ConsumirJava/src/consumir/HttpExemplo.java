/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package consumir;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import modelo.Usuario;

/**
 *
 * @author biankatpas
 */
public class HttpExemplo {
 
	private final String USER_AGENT = "Mozilla/5.0";
 
	public static void main(String[] args) throws Exception {
 
		HttpExemplo http = new HttpExemplo();
                int test = 1;
                
                switch(test)
                {
                    case 1:
                        System.out.println("Testing: send Http GET request");
                        String chamadaWS = "http://localhost:8084/Produto-WS/webresources/generic/usuario/get/biankatpas";
                        String json = http.sendGet(chamadaWS);

                        Gson g = new Gson();
                        Usuario u = new Usuario();
                        Type usuarioType = new TypeToken<Usuario>() {}.getType();
                        u = g.fromJson(json, usuarioType);

                        System.out.println(u.getLogin());
                        System.out.println(u.getSenha());
                        System.out.println(u.getEmail());
                        System.out.println(u.getPerfil());
                        break;
                    
                    case 2:
                        System.out.println("Testing: send Http PUT request");
                        break;
                        
                    case 3:
                        System.out.println("Testing: send Http DELETE request");
                        break;
                        
                    case 4:
                        System.out.println("Testing: send Http POST request");
                        break;
                        
                    default:
                        System.out.println("Opção invalida");
                }
		 
	}
 
	// HTTP GET request
	private String sendGet(String url) throws Exception {
 
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		// optional default is GET
		con.setRequestMethod("GET");
 
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
}

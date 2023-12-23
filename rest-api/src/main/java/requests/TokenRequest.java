package requests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.json.JSONArray;
import org.json.JSONObject;

public abstract class TokenRequest {

	
	public static String getToken() {
		 String credentials = KeycloakConstants.CLIENT_ID + ":" + KeycloakConstants.CLIENT_SECRET;
	        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));
	        
		
		try {
			URL url =new URL(KeycloakConstants.KEYCLOAK_URL+"/realms/"+KeycloakConstants.REALM+"/protocol/openid-connect/token");
			HttpURLConnection connection=(HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			 connection.setRequestProperty("Authorization", "Basic " + encodedCredentials);
			 connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			 connection.setDoOutput(true);
			 try (OutputStream outputStream = connection.getOutputStream()) {
		            outputStream.write(KeycloakConstants.REQUEST_BODY.getBytes(StandardCharsets.UTF_8));
		            outputStream.flush();
		        }

		        // Read the response
		        int responseCode = connection.getResponseCode();
		        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		        String line;
		        StringBuilder response = new StringBuilder();
		        while ((line = reader.readLine()) != null) {
		            response.append(line);
		        }
		        reader.close();

		        // Print the response
//		        System.out.println("Response Code: " + responseCode);
//		        System.out.println("Response Body: " + response.toString());
		        connection.disconnect();
		        
		        //take json as a string
		       return takeTokenAsString( response.toString());
		       
		        // Close the connection
		        
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	private static String takeTokenAsString(String jsonResponse) {
		JSONObject responseJson = new JSONObject(jsonResponse);
	
	         return responseJson.getString("access_token");   
		 }

		
	}



package requests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import Models.Client;
import Models.Users;



public class KeycloakRequests {
	
	//TAKE THE USERS THAT EXIST IN THE REALM 
	public static List<Users> getUsers(){
		String accessToken=TokenRequest.getToken();
		URL url;
		try {
			url = new URL(KeycloakConstants.KEYCLOAK_URL+"/admin/realms/"+KeycloakConstants.REALM+"/users");
			System.out.println("url: "+url);
			 HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			  connection.setRequestMethod("GET");
		        connection.setRequestProperty("Authorization", "Bearer " + accessToken);
		        int responseCode = connection.getResponseCode();

		        // Read the response
		        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		        String line;
		        StringBuilder response = new StringBuilder();
		        while ((line = reader.readLine()) != null) {
		            response.append(line);
		        }
		        reader.close();

		        // Print the response
		        System.out.println("Response Code: " + responseCode);
		        System.out.println("Response Body: " + response.toString());
		        	List list=getListOfUsers(response.toString());
		        	
		        	
		        // Close the connection
		        connection.disconnect();
		        return list;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	   
	}

	private static ArrayList<Users> getListOfUsers(String jsonResponse) {
		JSONArray jsonArray=new JSONArray(jsonResponse);
		ArrayList<Users>list=new ArrayList<Users>();
		for(int i=0;i<jsonArray.length();i++) {
			JSONObject userObject = jsonArray.getJSONObject(i);
	           String id = userObject.getString("id");
	            String firstName = userObject.getString("firstName");
	            String lastName = userObject.getString("lastName");
	            String username = userObject.getString("username");
	            String email = userObject.getString("email");
	            Users user=new Users(id,username,firstName,lastName,email);
	            list.add(user);
		}
		System.out.println(list);
		return list;
	}
	
	//ADD USER TO KEYCLOAK DEFAULT DATABASE

	public static int createUser(String username, String firstName, String lastName, String email,String password) {
		String accessToken=TokenRequest.getToken();
		Users user=new Users(username,firstName,lastName,email);
		
		JSONObject jsonPayload=new JSONObject();
		jsonPayload.put("username", user.getUsername());
		jsonPayload.put("firstName", user.getFirstName());
		jsonPayload.put("lastName", user.getLastName());
		jsonPayload.put("email", user.getEmail());
		jsonPayload.put("enabled", true);
		
		JSONObject credentials=new JSONObject();
		credentials.put("type", "password");
		credentials.put("value", password);
        credentials.put("temporary", false);
        
        jsonPayload.put("credentials", new JSONObject[]{credentials});
		  URL obj;
		try {
			obj = new URL(KeycloakConstants.KEYCLOAK_URL+"/admin/realms/"+KeycloakConstants.REALM+"/users");
			HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/json");
	        conn.setRequestProperty("Authorization", "Bearer " + accessToken);
	        conn.setDoOutput(true);
	        try (OutputStream os = conn.getOutputStream()) {
	            byte[] input = jsonPayload.toString().getBytes("utf-8");
	            os.write(input, 0, input.length);
	        } catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        int responseCode = conn.getResponseCode();
	        StringBuilder response = new StringBuilder();
	        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
	            String inputLine;
	            while ((inputLine = in.readLine()) != null) {
	                response.append(inputLine);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        System.out.println("Response Code: " + responseCode);
	        System.out.println("Response Body: " + response.toString());
	        return responseCode;
	        
	    

		} catch ( IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return 0;
	        

	        
	} 
	
	public static int deleteUser(String id) {
		String accessToken=TokenRequest.getToken();
		
		URL url;
		try {
			url = new URL(KeycloakConstants.KEYCLOAK_URL+"/admin/realms/"+KeycloakConstants.REALM+"/users/"+id);
			HttpURLConnection conn=(HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("DELETE");
			conn.setRequestProperty("Authorization", "Bearer " + accessToken);
			 int responseCode = conn.getResponseCode();
			 System.out.println("responseCode: "+responseCode);
			 conn.disconnect();
			 return responseCode;
			
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return 0;
	}

	public static Users getUser(String id) {
		String accessToken=TokenRequest.getToken();
		
		URL url;
		try {
			url = new URL(KeycloakConstants.KEYCLOAK_URL+"/admin/realms/"+KeycloakConstants.REALM+"/users/"+id);
			
			HttpURLConnection conn=(HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Authorization", "Bearer " + accessToken);
			int responseCode = conn.getResponseCode();
			 BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        String line;
		        StringBuilder response = new StringBuilder();
		        while ((line = reader.readLine()) != null) {
		            response.append(line);
		        }
		       //create the user you found
		        JSONObject obj=new JSONObject(response.toString());
		        System.out.println(obj);
		        String username=obj.getString("username");
		        String firstName=obj.getString("firstName");
		        String lastName=obj.getString("lastName");
		        String email=obj.getString("email");
		 
		        
		        Users user=new Users(id,username,firstName,lastName,email);
		        System.out.println(user);
		        return user;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return null;
		
	}
	
	
	public static int updateUser(Users user) {
		
		String accessToken=TokenRequest.getToken();
		JSONObject jsonPayload=new JSONObject();
		jsonPayload.put("id", user.getId());
		jsonPayload.put("username",user.getUsername());
		jsonPayload.put("firstName", user.getFirstName());
		jsonPayload.put("lastName", user.getLastName());
		jsonPayload.put("email", user.getEmail());
	    jsonPayload.put("enabled", true);
		
		
		URL url;
		try {
			url = new URL("http://localhost:8080/admin/realms/TestRestApi/users/"+user.getId());
			HttpURLConnection conn=(HttpURLConnection) url.openConnection();
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Authorization", "Bearer " + accessToken);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setDoOutput(true);
			
			try(OutputStream os = conn.getOutputStream()){
				byte[] input=jsonPayload.toString().getBytes("utf-8");
				 os.write(input, 0, input.length);
				 
			}catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        int responseCode = conn.getResponseCode();
	        StringBuilder response = new StringBuilder();
	        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
	            String inputLine;
	            while ((inputLine = in.readLine()) != null) {
	                response.append(inputLine);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        System.out.println("UPDATE USER Response Code: " + responseCode);
	        System.out.println("UPDATE USER Response Body: " + response.toString());
	        return responseCode;
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return 0;
	}
	public static List<Client>getClients(){
		String accessToken=TokenRequest.getToken();
		URL url;
		try {
			url = new URL(KeycloakConstants.KEYCLOAK_URL+"/admin/realms/"+KeycloakConstants.REALM+"/clients");
			 HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			  connection.setRequestMethod("GET");
		        connection.setRequestProperty("Authorization", "Bearer " + accessToken);
		        int responseCode = connection.getResponseCode();
		        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		        String line;
		        StringBuilder response = new StringBuilder();
		        while ((line = reader.readLine()) != null) {
		            response.append(line);
		        }
		        reader.close();
		        List<Client> list=getListOfClients(response.toString());
		        // Print the response
		        System.out.println("Response Code: " + responseCode);
		        System.out.println("Response Body: " + response.toString());
		        connection.disconnect();
		        return list;
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	private static List<Client> getListOfClients(String jsonResponse) {
		JSONArray jsonArray=new JSONArray(jsonResponse);
		ArrayList<Client>list=new ArrayList<Client>();
		System.out.println(list);
		for(int i=0;i<jsonArray.length();i++) {
			JSONObject clientObject = jsonArray.getJSONObject(i);
			Client client = new Client();
	        client.setId(clientObject.getString("id"));
	        client.setClientId(clientObject.getString("clientId"));
	        client.setName(clientObject.getString("name"));
	        if (clientObject.has("rootUrl")) {
	            client.setRootUrl(clientObject.getString("rootUrl"));
	        }
	        if (clientObject.has("baseUrl")) {
	            client.setBaseUrl(clientObject.getString("baseUrl"));
	        }
	    
	        client.setSurrogateAuthRequired(clientObject.getBoolean("surrogateAuthRequired"));
	        client.setEnabled(clientObject.getBoolean("enabled"));
	        client.setAlwaysDisplayInConsole(clientObject.getBoolean("alwaysDisplayInConsole"));
	        client.setClientAuthenticatorType(clientObject.getString("clientAuthenticatorType"));

	        // Continue setting other properties based on your Client class fields

	        // Add the client to the list
	        list.add(client);
		}
		System.out.println(list);
		return list;
	}

	public static Client getClient(String id) {
		String accessToken=TokenRequest.getToken();
		URL url;
		try {
			url = new URL(KeycloakConstants.KEYCLOAK_URL+"/admin/realms/"+KeycloakConstants.REALM+"/clients/"+id);
			
			HttpURLConnection conn=(HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Authorization", "Bearer " + accessToken);
			int responseCode = conn.getResponseCode();
			 BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        String line;
		        StringBuilder response = new StringBuilder();
		        while ((line = reader.readLine()) != null) {
		            response.append(line);
		        }
		       //create the user you found
		        JSONObject obj=new JSONObject(response.toString());
		        System.out.println(obj);
		        Client client=new Client();
		        client.setId(obj.getString("id"));
	            client.setClientId(obj.getString("clientId"));
	            client.setName(obj.optString("name", ""));
	            client.setRootUrl(obj.optString("rootUrl", ""));
	            client.setBaseUrl(obj.optString("baseUrl", ""));
	            client.setSurrogateAuthRequired(obj.optBoolean("surrogateAuthRequired", false));
	            client.setEnabled(obj.optBoolean("enabled", false));
	            client.setAlwaysDisplayInConsole(obj.optBoolean("alwaysDisplayInConsole", false));
	            client.setClientAuthenticatorType(obj.optString("clientAuthenticatorType", ""));
	            client.setNotBefore(obj.optInt("notBefore", 0));
	            client.setBearerOnly(obj.optBoolean("bearerOnly", false));
	            client.setConsentRequired(obj.optBoolean("consentRequired", false));
	            client.setStandardFlowEnabled(obj.optBoolean("standardFlowEnabled", false));
	            client.setImplicitFlowEnabled(obj.optBoolean("implicitFlowEnabled", false));
	            client.setDirectAccessGrantsEnabled(obj.optBoolean("directAccessGrantsEnabled", false));
	            client.setServiceAccountsEnabled(obj.optBoolean("serviceAccountsEnabled", false));
	            client.setPublicClient(obj.optBoolean("publicClient", false));
	            client.setFrontchannelLogout(obj.optBoolean("frontchannelLogout", false));
	            client.setProtocol(obj.optString("protocol", ""));
	            //client.setAttributes((Map<String, String>) obj.optJSONObject("attributes"));
	            // Set other properties accordingly

	            // Print or use the created Client object
	            System.out.println(client);

	            return client;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
		
	
	     
	      

	       	            
	         

}

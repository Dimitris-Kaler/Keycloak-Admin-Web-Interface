/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package keycloakrestapi.app;

import requests.KeycloakRequests;
import requests.TokenRequest;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
    //String token=TokenRequest.getToken();
//  KeycloakRequests.getUsers();
//  KeycloakRequests.createUser("petros", "Sa1", "Kataka", "ari@gmail.com1");
//  KeycloakRequests.deleteUser("aa7672b6-7984-4f9f-8a27-f34388c02b62");
  KeycloakRequests.getUser("dae3699b-0b9b-400c-989b-9f68cbb2f0c5");
    }
}

package com.mycompany;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

@Service
public class ContactService{
	
	public void sendContactDetails(Contact contact) {
		try {

            RestTemplate restTemplate = new RestTemplate();
            final String base_url = "http://localhost:8081/Contact";
            
            // create request body
            String request = new Gson().toJson(contact);
            
            System.out.println(request);
            
            // set headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<String>(request, headers);
            
            
         // send request and parse result
            ResponseEntity<String> contactResponse = restTemplate
              .exchange(base_url, HttpMethod.POST, entity, String.class);
            if (contactResponse.getStatusCode() == HttpStatus.OK) {
              JSONObject userJson = new JSONObject(contactResponse.getBody());
            } else if (contactResponse.getStatusCode() == HttpStatus.UNAUTHORIZED) {
              System.out.println(contactResponse.getBody());
            }
        }
        catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
	}
	
}
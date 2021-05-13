package com.example.skillTest.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.skillTest.model.Reviewer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


//@Controller
@RestController


public class IndexController {
	
	@Autowired
	private RestTemplate rtemplate;
	
	@RequestMapping("/index")
    public Object index(@RequestParam("id") String id) {

		JSONObject data =  getAllData(id);
		
        return new Gson().toJson(data);
    }
	
	@Bean
	public RestTemplate getRestTempate() {
		return new RestTemplate();
		
	}
	
	@GetMapping("/getReviewers")
	public JSONObject getAllData(@RequestParam("id") String id){
		JSONObject data = new JSONObject();
		List<Reviewer> reviewer = new ArrayList<>();
		String url ="https://api.yelp.com/v3/businesses/"+id+"/reviews";
		
		Map<String, String> headers = new HashMap<>();
	    headers.put("accept", "application/json");
	    headers.put("Authorization", "Bearer v3u50eGG74uLja-0XkOxWAmYJ8t9rioVhKEbYZQzMxxcT9XgQCM41mZwpZkZwjnLFKK-CMTMPsSsJ9jSUo_iEm8fk1OFoM1RLLqEn3FtKSYfS0LTZOSo8jVnJkGbYHYx");
		
		try {
			HttpResponse<JsonNode> jsonResponse = Unirest.get(url).headers(headers).asJson();
			JsonNode arrayNode = jsonResponse.getBody();
			
			data = arrayNode.getObject();
			System.out.println(data);
			
		//System.out.print(jsonResponse.getBody());
		
		} catch (UnirestException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return data;
	}
	
	public Map<String,String> getImageUrl(String id,String img) {
		Map<String,String> map =new HashMap<>();
		
		
		return map;
	}
	
}

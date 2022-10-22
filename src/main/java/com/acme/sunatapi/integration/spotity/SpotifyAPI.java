package com.acme.sunatapi.integration.spotity;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.acme.sunatapi.integration.spotity.dto.UserSpotify;

@Service
public class SpotifyAPI {
    private static final String URL_API_SPOTIFY="https://api.spotify.com/v1/me";


    private RestTemplate restTemplate;

    
    public SpotifyAPI(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public UserSpotify me(){
        var ACCESS_TOKEN=System.getenv("SPOTIFY_API_KEY");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+ACCESS_TOKEN);

        HttpEntity<String> entity = 
                new HttpEntity<String>(headers);
        ResponseEntity<UserSpotify> response = restTemplate.
                                    exchange(URL_API_SPOTIFY,
                                    HttpMethod.GET,
                                    entity,
                                    new ParameterizedTypeReference<UserSpotify>(){});
        return response.getBody();
    }
}
package com.acme.sunatapi.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;

import com.acme.sunatapi.integration.sendgrid.*;
import com.acme.sunatapi.integration.spotity.*;

@Controller
public class Home2Controller {
    
    private static final String HOME_INDEX ="welcome"; 

    private final SpotifyAPI spotifyAPI;
    private final SendGridAPI sendGridAPI;

    public Home2Controller(SpotifyAPI spotifyAPI,SendGridAPI sendGridAPI ){
        this.spotifyAPI = spotifyAPI;
        this.sendGridAPI = sendGridAPI;
    }


    @GetMapping("/")
    public String index(Model model) {
        
        spotifyAPI.me();
        sendGridAPI.send("fduartej@usmp.pe","fduartej@gmail.com","test","test");
        return HOME_INDEX;
    }

}
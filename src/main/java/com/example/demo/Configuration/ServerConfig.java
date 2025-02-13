package com.example.demo.Configuration;


import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ServerConfig {

    @Bean
    public Cloudinary configurazioneCloud(){
        Map<String,String> configurazione = new HashMap<String,String>();
        configurazione.put("cloud_name", "dux4n7j2a");
        configurazione.put("api_key", "766641279995963");
        configurazione.put("api_secret", "2lyUOrN46CMjj277rK-RP3FTF4A");
        return new Cloudinary(configurazione);
    }


}
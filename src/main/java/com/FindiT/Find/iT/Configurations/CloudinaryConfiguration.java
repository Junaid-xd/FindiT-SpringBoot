package com.FindiT.Find.iT.Configurations;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfiguration {

    private final String CLOUD_NAME = "dc18bcmgm";
    private final String API_KEY = "466931791373891";
    private final String API_SECRET = "rel3gUUU40IMWoGnvkGFgLFKnGw";



    @Bean
    public Cloudinary cloudinary(){
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", CLOUD_NAME);
        config.put("api_key", API_KEY);
        config.put("api_secret", API_SECRET);
        return new Cloudinary(config);
    }
}









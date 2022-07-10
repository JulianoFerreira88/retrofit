package com.github;

import com.github.retrofit.Api;
import com.github.retrofit.model.service.EsanmatrizService;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Api api = new Api("http://localhost:8081");
        EsanmatrizService service = new EsanmatrizService(api.getMatrizRepository());
        service.findAll((m) -> {
            
        });
        
    }
}

package com.github.retrofit;

import com.github.retrofit.model.repository.EsandesmameRepository;
import com.github.retrofit.model.repository.EsanmatrizRepository;
import com.github.retrofit.model.repository.EsanracaRepository;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    private final retrofit2.Retrofit retrofit;

    public Api(String baseUrl) {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public EsanmatrizRepository getEsanmatrizRepository() {
        return retrofit.create(EsanmatrizRepository.class);
    }

    public EsanracaRepository getEsanracaRepository() {
        return retrofit.create(EsanracaRepository.class);
    }

    public EsandesmameRepository getEsandesmameRepository() {
        return retrofit.create(EsandesmameRepository.class);
    }

}

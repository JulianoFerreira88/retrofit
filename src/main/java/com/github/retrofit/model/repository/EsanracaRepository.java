package com.github.retrofit.model.repository;

import com.github.retrofit.model.entities.Esanraca;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EsanracaRepository {

    @GET(value = "/racas")
    Call<List<Esanraca>> findAll();

    @GET(value = "/racas/{id}")
    Call<Esanraca> findById(@Path("id") String id);
}

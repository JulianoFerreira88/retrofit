package com.github.retrofit.model.repository;

import com.github.retrofit.model.entities.Esandesmame;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EsandesmameRepository {

    @GET(value = "/desmames")
    Call<List<Esandesmame>> findAll();

    @GET(value = "/desmames/{id_matriz}")
    Call<List<Esandesmame>> findAllByMatriz(@Path("id_matriz") Integer id);
}

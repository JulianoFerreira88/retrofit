package com.github.retrofit.model.repository;

import com.github.retrofit.model.entities.Esanmatriz;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EsanmatrizRepository {

    @GET(value = "/matrizes")
    Call<List<Esanmatriz>> findAll();

    @GET(value = "/matrizes/lactantes")
    Call<List<Esanmatriz>> findLactantes();

    @GET(value = "/matrizes/vazias")
    Call<List<Esanmatriz>> findVazias();

    @GET(value = "/matrizes/gestantes")
    Call<List<Esanmatriz>> findGestantes();

    @GET(value = "/matrizes/{id}")
    Call<Esanmatriz> findLactantesById(@Path("id") String id);
}

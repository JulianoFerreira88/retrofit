package com.github.retrofit.model.service;

import com.github.retrofit.model.entities.Esanmatriz;
import com.github.retrofit.model.repository.EsanmatrizRepository;
import com.github.retrofit.model.service.utils.OnError;
import com.github.retrofit.model.service.utils.OnResponse;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EsanmatrizService {

    private final EsanmatrizRepository dao;
    private final OnError<Throwable> onError;

    public EsanmatrizService(EsanmatrizRepository dao, OnError<Throwable> error) {
        this.dao = dao;
        this.onError = error;
    }

    public void findALl(OnResponse<List<Esanmatriz>> onResponse) {
        dao.findAll().enqueue(new Callback<List<Esanmatriz>>() {
            @Override
            public void onResponse(Call<List<Esanmatriz>> call, Response<List<Esanmatriz>> rspns) {
                onResponse.response(rspns.body());
            }

            @Override
            public void onFailure(Call<List<Esanmatriz>> call, Throwable thrwbl) {
                onError.error(thrwbl);
            }
        });
    }

    public void findAllLactantes(OnResponse<List<Esanmatriz>> lactantes) {
        dao.findLactantes().enqueue(new Callback<List<Esanmatriz>>() {
            @Override
            public void onResponse(Call<List<Esanmatriz>> call, Response<List<Esanmatriz>> rspns) {
                lactantes.response(rspns.body());
            }

            @Override
            public void onFailure(Call<List<Esanmatriz>> call, Throwable thrwbl) {
                onError.error(thrwbl);
            }
        });
    }
}

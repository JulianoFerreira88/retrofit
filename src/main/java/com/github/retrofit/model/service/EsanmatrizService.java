package com.github.retrofit.model.service;

import com.github.retrofit.model.entities.Esanmatriz;
import com.github.retrofit.model.repository.EsanmatrizRepository;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EsanmatrizService {

    private final EsanmatrizRepository dao;

    public EsanmatrizService(EsanmatrizRepository dao) {
        this.dao = dao;
    }

    public void findAll(OnMatriz onMatriz) {
        dao.findAll().enqueue(new Callback<List<Esanmatriz>>() {
            @Override
            public void onResponse(Call<List<Esanmatriz>> call, Response<List<Esanmatriz>> rspns) {
                onMatriz.list(rspns.body());
            }

            @Override
            public void onFailure(Call<List<Esanmatriz>> call, Throwable thrwbl) {
                System.out.println("Implementar");
            }
        });
    }

    public interface OnMatriz {
        public void list(List<Esanmatriz> list);
    }
}

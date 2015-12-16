package com.laboratoriodesoftware2015.hermesbucarbala.service;

import android.util.Pair;

import com.google.gson.Gson;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by natalia on 15/12/15.
 */
public class RestApiImpl implements RestApi{
    @Override
    public void sendNotification(String text, String category, String children) {
       String json = makeJsonBody(new Pair("texto", text),new Pair("categoria", category), new Pair("contexto", category), new Pair("children", children), new Pair("fecha envio", new Date()));


    }

    private final String makeJsonBody(Pair<Object, Object>... pairValues) {
        Map<Object, Object> body = new HashMap<>();
        for (Pair pairValue : pairValues) {
            body.put(pairValue.first, pairValue.second);
        }

        return new Gson().toJson(body);
    }
}

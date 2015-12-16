package com.laboratoriodesoftware2015.hermesbucarbala.service;

import android.util.Log;
import android.util.Pair;

import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by natalia on 15/12/15.
 */
public class RestApiImpl implements RestApi{

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    private OkHttpClient client = new OkHttpClient();
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Override
    public void sendNotification(String text, String category, String children, final String url) {
        Date now = new Date();
        String contentString = "{\"id\": null, \"name\": \""+ text+"\"}";
        String contextString = "{\"id\": null, \"name\": \""+ category+"\"}";
        String childrenString = "{\"id\": null, \"name\": \""+ children+"\"}";
        String dateString = "\"dateReceived\": \""+df.format(now)+"\"";
        final String json = "[{\"content\": "+contentString+", \"context\": "+contextString+", \"category\": "+contextString+", \"child\": "+childrenString+" , "+dateString+"}]";

        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try {
            client.newCall(request).execute();
        } catch (IOException e) {
            Log.e("RestApiImpl", "Error sending notification to monitor");
        }


    }
}

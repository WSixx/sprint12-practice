package br.com.lucad.sprintexercise;

import retrofit2.Retrofit;

public class Constants {

    public static final String BASE_URL = "https://api.covid19api.com/";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build();

}

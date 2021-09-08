package br.com.lucad.sprintexercise;

import br.com.lucad.sprintexercise.model.Covid;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoint {

    @GET("summary")
    Call<Covid> getCovid();

}

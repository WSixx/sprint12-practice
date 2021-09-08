package br.com.lucad.sprintexercise.view;

import static br.com.lucad.sprintexercise.api.RetrofitClient.getRetrofitInstance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;

import br.com.lucad.sprintexercise.R;
import br.com.lucad.sprintexercise.api.ApiEndpoint;
import br.com.lucad.sprintexercise.model.Covid;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Example extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucas);

        TextView textView = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);
        TextView textView4 = findViewById(R.id.textView4);
        ProgressBar progressBar = findViewById(R.id.progressBar);

        //TODO: Voce vai precisar criar uma instancia da ApiEndpoint
        ApiEndpoint apiService =
                getRetrofitInstance().create(ApiEndpoint.class);

        //TODO: Voce vai precisar criar uma uma cal
        Call<Covid> call = apiService.getCovid();
        //TODO: Aqui voce vai implementar a chamada
        call.enqueue(new Callback<Covid>() {
            @Override
            public void onResponse(@NonNull Call<Covid> call, @NonNull Response<Covid> response) {
                if (response.isSuccessful()){
                    progressBar.setVisibility(View.GONE);
                    //ExemploGlobal
                    String data = response.body().getGlobal().getDate();
                    String totalMortesGlobal = response.body().getGlobal().getTotalDeaths().toString();

                    textView.setText(data);
                    textView2.setText(totalMortesGlobal);

                    //Exemplo Brasil:
                    String totalMortesBrasil = response.body().getCountries().get(23).getTotalDeaths().toString();
                    String totalConfirmadosBrasil = response.body().getCountries().get(23).getTotalConfirmed().toString();

                    textView3.setText(totalMortesBrasil);
                    textView4.setText(totalConfirmadosBrasil);
                }else {
                    try {
                        System.out.println(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Covid> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
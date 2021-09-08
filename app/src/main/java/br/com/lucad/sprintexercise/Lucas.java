package br.com.lucad.sprintexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import br.com.lucad.sprintexercise.model.Covid;

public class Lucas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucas);
        Covid covid = new Covid();

        TextView textView = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);

        textView.setText(String.valueOf(covid.getNewConfirmed()));
        textView2.setText(String.valueOf(covid.getNewDeaths()));


    }
}
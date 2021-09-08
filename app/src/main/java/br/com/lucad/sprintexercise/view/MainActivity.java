package br.com.lucad.sprintexercise.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import br.com.lucad.sprintexercise.R;
import br.com.lucad.sprintexercise.view.Example;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(getApplicationContext(), Example.class);
        startActivity(intent);

    }
}
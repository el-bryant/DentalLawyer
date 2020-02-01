package com.vitaldentcix.dentallawyer.dentallawyer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Cuadrante4 extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadrante4);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void onBack(View view) {
        Intent searchIntent = new Intent(Cuadrante4.this, Consulta.class);
        startActivity(searchIntent);
        finish();
    }

    public void onProblemas(View view) {
        Intent searchIntent = new Intent(Cuadrante4.this, Nomenclatura.class);
        startActivity(searchIntent);
        finish();
    }
}

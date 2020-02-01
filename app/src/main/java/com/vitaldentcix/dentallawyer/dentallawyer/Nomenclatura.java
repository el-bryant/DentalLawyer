package com.vitaldentcix.dentallawyer.dentallawyer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Nomenclatura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nomenclatura);
    }

    public void onBack(View view) {
        Intent searchIntent = new Intent(Nomenclatura.this, Consulta.class);
        startActivity(searchIntent);
    }
}

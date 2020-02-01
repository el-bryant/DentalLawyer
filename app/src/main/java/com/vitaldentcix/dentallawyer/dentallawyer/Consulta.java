package com.vitaldentcix.dentallawyer.dentallawyer;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Consulta extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    EditText etDni;
    EditText etApPat;
    EditText etApMat;
    EditText etNombres;
    EditText etEdad;
    EditText etSaldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //código para pestañas
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        TabsPager tabsPager = new TabsPager(getSupportFragmentManager());
        viewPager.setAdapter(tabsPager);
        tabLayout.setupWithViewPager(viewPager);

        //código para menú descolgante izquierdo
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        String recup_var_string = getIntent().getStringExtra("dni");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //código para selección de item en el menú descolgante izquierdo
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.main) {
            Intent searchIntent = new Intent(Consulta.this, MainActivity.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            finish();
        } else if (id == R.id.consulta) {
            Intent searchIntent = new Intent(Consulta.this, Consulta.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            finish();
        } else if (id == R.id.resultado) {
            Intent searchIntent = new Intent(Consulta.this, Resultado.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            finish();
        } else if (id == R.id.rol) {
            Intent searchIntent = new Intent(Consulta.this, Rol.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            finish();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void Cuad1 (View view) {
        Intent searchIntent = new Intent(Consulta.this, Cuadrante1.class);
        startActivity(searchIntent);
        finish();
    }

    public void Cuad2 (View view) {
        Intent searchIntent = new Intent(Consulta.this, Cuadrante2.class);
        startActivity(searchIntent);
        finish();
    }

    public void Cuad3 (View view) {
        Intent searchIntent = new Intent(Consulta.this, Cuadrante3.class);
        startActivity(searchIntent);
        finish();
    }

    public void Cuad4 (View view) {
        Intent searchIntent = new Intent(Consulta.this, Cuadrante4.class);
        startActivity(searchIntent);
        finish();
    }

    public void onProblemas(View view) {
        Intent searchIntent = new Intent(Consulta.this, Resultado.class);
        startActivity(searchIntent);
    }

    public void onBack(View view) {
        Intent searchIntent = new Intent(Consulta.this, Consulta.class);
        startActivity(searchIntent);
    }

    //buscar paciente----------------------------------------------------------------------------------

    public void onBuscar(View view) {
        Log.i("depurar","click");
        etApPat = (EditText) findViewById(R.id.etApPatPaciente);
        etApMat = (EditText) findViewById(R.id.etApMatPaciente);
        etNombres = (EditText) findViewById(R.id.etNombresPaciente);
        etEdad = (EditText) findViewById(R.id.etEdadPaciente);
        Thread tr = new Thread() {
            @Override
            public void run() {
                etDni = (EditText) findViewById(R.id.etDniPaciente);
                final String result = enviarDatosGet(etDni.getText().toString());
                Log.i("depurar",result);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int r = obtDatosJson(result);
                        if(r>0) {
                            MostrarData(result);
                        }
                    }
                });
            }
        };
        tr.start();
    }


    public String enviarDatosGet(String dnipaciente) {
        URL url = null;
        String linea = "";
        int respuesta = 0;
        StringBuilder result = null;

        try {

            url = new URL("http://192.168.25.73/DentalLawyer/consulta/buscar_paciente.php?dni_paciente=" + dnipaciente);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            respuesta = connection.getResponseCode();

            result = new StringBuilder();

            if (respuesta == HttpURLConnection.HTTP_OK) {
                InputStream in = new BufferedInputStream(connection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                while ((linea = reader.readLine()) != null) {
                    result.append(linea);
                }
            }
        } catch (Exception e) {

        }
        return result.toString();
    }

    public int obtDatosJson(String response) {
        int res = 0;

        try {
            JSONArray json = new JSONArray(response);
            if (json.length() > 0) {
                res = 1;
            }
        } catch (Exception e) {
        }
        return res;
    }

    public void MostrarData(String reponse) {
        try {
            JSONArray json = new JSONArray(reponse);
            for (int i = 0; i < json.length(); i++) {
                etApPat.setText(json.getJSONObject(i).getString("apellido_pat"));
                etApMat.setText(json.getJSONObject(i).getString("apellido_mat"));
                etNombres.setText(json.getJSONObject(i).getString("nombres"));
                etEdad.setText(json.getJSONObject(i).getString("f_nacimiento"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //modificar un registro-----------------------------------------------------------------------------

    public void onModificar(View view) {
        Log.i("depurar","click");
        etApPat = (EditText) findViewById(R.id.etApPatPaciente);
        etApMat = (EditText) findViewById(R.id.etApMatPaciente);
        etNombres = (EditText) findViewById(R.id.etNombresPaciente);
        etEdad = (EditText) findViewById(R.id.etEdadPaciente);
        Thread tr = new Thread() {
            @Override
            public void run() {
                etDni = (EditText) findViewById(R.id.etDniPaciente);
                etSaldo = (EditText) findViewById(R.id.etSaldo);
                final String result_in = enviarDatosGet_insert(etDni.getText().toString(), etSaldo.getText().toString());
                Log.i("depurar",result_in);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int r = obtDatosJson(result_in);
                        if(r>0) {
                            MostrarData(result_in);
                        }
                    }
                });
            }
        };
        tr.start();
    }


    public String enviarDatosGet_insert(String dnipaciente, String saldo) {
        URL url = null;
        String linea = "";
        int respuesta = 0;
        StringBuilder result = null;

        try {

            url = new URL("http://192.168.25.73/DentalLawyer/consulta/insertar.php?dni_paciente=" + dnipaciente + "&saldo="
                    + saldo);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            respuesta = connection.getResponseCode();

            result = new StringBuilder();

            if (respuesta == HttpURLConnection.HTTP_OK) {
                InputStream in = new BufferedInputStream(connection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                while ((linea = reader.readLine()) != null) {
                    result.append(linea);
                }
            }
        } catch (Exception e) {

        }
        return result.toString();
    }
}

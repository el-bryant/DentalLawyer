package com.vitaldentcix.dentallawyer.dentallawyer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Rol extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    EditText etDni;
    TextView tvDni, tv01, tv02, tv03, tv04, tv05, tv06, tv07, tv08, tv09, tv10, tv11, tv12, tv13, tv14;
    EditText et01, et02, et03, et04, et05, et06, et07, et08, et09, et10, et11, et12, et13, et14;
    //String recup_var_string = getIntent().getStringExtra("usuario_dni");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rol);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Cargar rol
        /*et01 = (EditText) findViewById(R.id.ett01);
        et02 = (EditText) findViewById(R.id.ett02);
        et03 = (EditText) findViewById(R.id.ett03);
        et04 = (EditText) findViewById(R.id.ett04);
        et05 = (EditText) findViewById(R.id.ett05);
        et06 = (EditText) findViewById(R.id.ett06);
        et07 = (EditText) findViewById(R.id.ett07);
        et08 = (EditText) findViewById(R.id.ett08);*/
        //et09 = (EditText) findViewById(R.id.ett09);
        /*et10 = (EditText) findViewById(R.id.ett10);
        et11 = (EditText) findViewById(R.id.ett11);
        et12 = (EditText) findViewById(R.id.ett12);
        et13 = (EditText) findViewById(R.id.ett13);
        et14 = (EditText) findViewById(R.id.ett14);
        tv01 = (TextView) findViewById(R.id.tvt01);
        tv02 = (TextView) findViewById(R.id.tvt02);
        tv03 = (TextView) findViewById(R.id.tvt03);
        tv04 = (TextView) findViewById(R.id.tvt04);
        tv05 = (TextView) findViewById(R.id.tvt05);
        tv06 = (TextView) findViewById(R.id.tvt06);
        tv07 = (TextView) findViewById(R.id.tvt07);
        tv08 = (TextView) findViewById(R.id.tvt08);        //tv09 = (TextView) findViewById(R.id.tvt09);/*
        tv10 = (TextView) findViewById(R.id.tvt10);
        tv11 = (TextView) findViewById(R.id.tvt11);
        tv12 = (TextView) findViewById(R.id.tvt12);
        tv13 = (TextView) findViewById(R.id.tvt13);
        tv14 = (TextView) findViewById(R.id.tvt14);
        /*onBuscar01();
        onBuscar02();
        onBuscar03();
        onBuscar04();
        onBuscar05();
        onBuscar06();
        onBuscar07();
        onBuscar08();*/
        //onBuscar09();
        /*onBuscar10();
        onBuscar11();
        onBuscar12();
        onBuscar13();
        onBuscar14();*/
    }

    //mostrar rol----------------------------------------------------------------------------------

    /*public void onBuscar01() {
        Log.i("depurar","click");
        Thread tr = new Thread() {
            @Override
            public void run() {
                tvDni = (TextView) findViewById(R.id.tvUsuario);
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = df.format(c.getTime());
                final String result01 = enviarDatosGet(recup_var_string, fecha, tv01.getText().toString());
                Log.i("depurar",result01);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int r = obtDatosJson01(result01);
                        if(r>0) {
                            MostrarData01(result01);
                        }
                    }
                });
            }
        };
        tr.start();
    }
    /*public void onBuscar02() {
        Log.i("depurar","click");
        Thread tr = new Thread() {
            @Override
            public void run() {
                tvDni = (TextView) findViewById(R.id.tvUsuario);
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = df.format(c.getTime());
                final String result02 = enviarDatosGet(recup_var_string, fecha, tv02.getText().toString());
                Log.i("depurar",result02);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int r = obtDatosJson02(result02);
                        if(r>0) {
                            MostrarData02(result02);
                        }
                    }
                });
            }
        };
        tr.start();
    }
    public void onBuscar03() {
        Log.i("depurar","click");
        Thread tr = new Thread() {
            @Override
            public void run() {
                tvDni = (TextView) findViewById(R.id.tvUsuario);
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = df.format(c.getTime());
                final String result03 = enviarDatosGet(recup_var_string, fecha, tv03.getText().toString());
                Log.i("depurar",result03);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int r = obtDatosJson03(result03);
                        if(r>0) {
                            MostrarData03(result03);
                        }
                    }
                });
            }
        };
        tr.start();
    }
    public void onBuscar04() {
        Log.i("depurar","click");
        Thread tr = new Thread() {
            @Override
            public void run() {
                tvDni = (TextView) findViewById(R.id.tvUsuario);
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = df.format(c.getTime());
                final String result04 = enviarDatosGet(recup_var_string, fecha, tv04.getText().toString());
                Log.i("depurar",result04);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int r = obtDatosJson04(result04);
                        if(r>0) {
                            MostrarData04(result04);
                        }
                    }
                });
            }
        };
        tr.start();
    }
    public void onBuscar05() {
        Log.i("depurar","click");
        Thread tr = new Thread() {
            @Override
            public void run() {
                tvDni = (TextView) findViewById(R.id.tvUsuario);
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = df.format(c.getTime());
                final String result05 = enviarDatosGet(recup_var_string, fecha, tv05.getText().toString());
                Log.i("depurar",result05);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int r = obtDatosJson05(result05);
                        if(r>0) {
                            MostrarData05(result05);
                        }
                    }
                });
            }
        };
        tr.start();
    }
    public void onBuscar06() {
        Log.i("depurar","click");
        Thread tr = new Thread() {
            @Override
            public void run() {
                tvDni = (TextView) findViewById(R.id.tvUsuario);
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = df.format(c.getTime());
                final String result06 = enviarDatosGet(recup_var_string, fecha, tv06.getText().toString());
                Log.i("depurar",result06);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int r = obtDatosJson06(result06);
                        if(r>0) {
                            MostrarData06(result06);
                        }
                    }
                });
            }
        };
        tr.start();
    }
    public void onBuscar07() {
        Log.i("depurar","click");
        Thread tr = new Thread() {
            @Override
            public void run() {
                tvDni = (TextView) findViewById(R.id.tvUsuario);
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = df.format(c.getTime());
                final String result07 = enviarDatosGet(recup_var_string, fecha, tv07.getText().toString());
                Log.i("depurar",result07);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int r = obtDatosJson07(result07);
                        if(r>0) {
                            MostrarData07(result07);
                        }
                    }
                });
            }
        };
        tr.start();
    }
    public void onBuscar08() {
        Log.i("depurar","click");
        Thread tr = new Thread() {
            @Override
            public void run() {
                tvDni = (TextView) findViewById(R.id.tvUsuario);
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = df.format(c.getTime());
                final String result08 = enviarDatosGet(recup_var_string, fecha, tv08.getText().toString());
                Log.i("depurar",result08);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int r = obtDatosJson08(result08);
                        if(r>0) {
                            MostrarData08(result08);
                        }
                    }
                });
            }
        };
        tr.start();
    }*/
   /* public void onBuscar09() {
        Log.i("depurar","click");
        Thread tr = new Thread() {
            @Override
            public void run() {
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = df.format(c.getTime());
                final String result09 = enviarDatosGet(recup_var_string, fecha, tv09.getText().toString());
                Log.i("depurar",result09);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int r = obtDatosJson09(result09);
                        if(r>0) {
                            MostrarData09(result09);
                        }
                    }
                });
            }
        };
        tr.start();
    }/*
    public void onBuscar10() {
        Log.i("depurar","click");
        Thread tr = new Thread() {
            @Override
            public void run() {
                tvDni = (TextView) findViewById(R.id.tvUsuario);
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = df.format(c.getTime());
                final String result10 = enviarDatosGet(recup_var_string, fecha, tv10.getText().toString());
                Log.i("depurar",result10);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int r = obtDatosJson10(result10);
                        if(r>0) {
                            MostrarData10(result10);
                        }
                    }
                });
            }
        };
        tr.start();
    }
    public void onBuscar11() {
        Log.i("depurar","click");
        Thread tr = new Thread() {
            @Override
            public void run() {
                tvDni = (TextView) findViewById(R.id.tvUsuario);
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = df.format(c.getTime());
                final String result11 = enviarDatosGet(recup_var_string, fecha, tv11.getText().toString());
                Log.i("depurar",result11);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int r = obtDatosJson11(result11);
                        if(r>0) {
                            MostrarData11(result11);
                        }
                    }
                });
            }
        };
        tr.start();
    }
    public void onBuscar12() {
        Log.i("depurar","click");
        Thread tr = new Thread() {
            @Override
            public void run() {
                tvDni = (TextView) findViewById(R.id.tvUsuario);
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = df.format(c.getTime());
                final String result12 = enviarDatosGet(recup_var_string, fecha, tv12.getText().toString());
                Log.i("depurar",result12);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int r = obtDatosJson12(result12);
                        if(r>0) {
                            MostrarData12(result12);
                        }
                    }
                });
            }
        };
        tr.start();
    }
    public void onBuscar13() {
        Log.i("depurar","click");
        Thread tr = new Thread() {
            @Override
            public void run() {
                tvDni = (TextView) findViewById(R.id.tvUsuario);
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = df.format(c.getTime());
                final String result13 = enviarDatosGet(recup_var_string, fecha, tv13.getText().toString());
                Log.i("depurar",result13);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int r = obtDatosJson13(result13);
                        if(r>0) {
                            MostrarData13(result13);
                        }
                    }
                });
            }
        };
        tr.start();
    }
    public void onBuscar14() {
        Log.i("depurar","click");
        Thread tr = new Thread() {
            @Override
            public void run() {
                tvDni = (TextView) findViewById(R.id.tvUsuario);
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = df.format(c.getTime());
                final String result14 = enviarDatosGet(recup_var_string, fecha, tv14.getText().toString());
                Log.i("depurar",result14);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int r = obtDatosJson14(result14);
                        if(r>0) {
                            MostrarData14(result14);
                        }
                    }
                });
            }
        };
        tr.start();
    }*/


    /*public String enviarDatosGet(String dni, String fecha, String hora) {
        URL url = null;
        String linea = "";
        int respuesta = 0;
        StringBuilder result = null;

        try {

            url = new URL("http://192.168.25.73/DentalLawyer/consulta/cargar_rol.php?dni=" + dni + "&fecha=" + fecha + "&hora="
                    + hora);

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

    /*public int obtDatosJson01(String response01) {
        int res = 0;

        try {
            JSONArray json = new JSONArray(response01);
            if (json.length() > 0) {
                res = 1;
            }
        } catch (Exception e) {
        }
        return res;
    }

    /*public int obtDatosJson02(String response02) {
        int res = 0;

        try {
            JSONArray json = new JSONArray(response02);
            if (json.length() > 0) {
                res = 1;
            }
        } catch (Exception e) {
        }
        return res;
    }

    public int obtDatosJson03(String response03) {
        int res = 0;

        try {
            JSONArray json = new JSONArray(response03);
            if (json.length() > 0) {
                res = 1;
            }
        } catch (Exception e) {
        }
        return res;
    }

    public int obtDatosJson04(String response04) {
        int res = 0;

        try {
            JSONArray json = new JSONArray(response04);
            if (json.length() > 0) {
                res = 1;
            }
        } catch (Exception e) {
        }
        return res;
    }

    public int obtDatosJson05(String response05) {
        int res = 0;

        try {
            JSONArray json = new JSONArray(response05);
            if (json.length() > 0) {
                res = 1;
            }
        } catch (Exception e) {
        }
        return res;
    }

    public int obtDatosJson06(String response06) {
        int res = 0;

        try {
            JSONArray json = new JSONArray(response06);
            if (json.length() > 0) {
                res = 1;
            }
        } catch (Exception e) {
        }
        return res;
    }

    public int obtDatosJson07(String response07) {
        int res = 0;

        try {
            JSONArray json = new JSONArray(response07);
            if (json.length() > 0) {
                res = 1;
            }
        } catch (Exception e) {
        }
        return res;
    }

    public int obtDatosJson08(String response08) {
        int res = 0;

        try {
            JSONArray json = new JSONArray(response08);
            if (json.length() > 0) {
                res = 1;
            }
        } catch (Exception e) {
        }
        return res;
    }
*/
   /* public int obtDatosJson09(String response09) {
        int res = 0;

        try {
            JSONArray json = new JSONArray(response09);
            if (json.length() > 0) {
                res = 1;
            }
        } catch (Exception e) {
        }
        return res;
    }
/*
    public int obtDatosJson10(String response10) {
        int res = 0;

        try {
            JSONArray json = new JSONArray(response10);
            if (json.length() > 0) {
                res = 1;
            }
        } catch (Exception e) {
        }
        return res;
    }

    public int obtDatosJson11(String response11) {
        int res = 0;

        try {
            JSONArray json = new JSONArray(response11);
            if (json.length() > 0) {
                res = 1;
            }
        } catch (Exception e) {
        }
        return res;
    }

    public int obtDatosJson12(String response12) {
        int res = 0;

        try {
            JSONArray json = new JSONArray(response12);
            if (json.length() > 0) {
                res = 1;
            }
        } catch (Exception e) {
        }
        return res;
    }

    public int obtDatosJson13(String response13) {
        int res = 0;

        try {
            JSONArray json = new JSONArray(response13);
            if (json.length() > 0) {
                res = 1;
            }
        } catch (Exception e) {
        }
        return res;
    }

    public int obtDatosJson14(String response14) {
        int res = 0;

        try {
            JSONArray json = new JSONArray(response14);
            if (json.length() > 0) {
                res = 1;
            }
        } catch (Exception e) {
        }
        return res;
    }*/

   /* public void MostrarData01(String reponse01) {
        try {
            JSONArray json = new JSONArray(reponse01);
            for (int i = 0; i < json.length(); i++) {
                et01.setText(json.getJSONObject(i).getString("paciente"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /*public void MostrarData02(String reponse02) {
        try {
            JSONArray json = new JSONArray(reponse02);
            for (int i = 0; i < json.length(); i++) {
                et01.setText(json.getJSONObject(i).getString("paciente"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void MostrarData03(String reponse03) {
        try {
            JSONArray json = new JSONArray(reponse03);
            for (int i = 0; i < json.length(); i++) {
                et01.setText(json.getJSONObject(i).getString("paciente"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void MostrarData04(String reponse04) {
        try {
            JSONArray json = new JSONArray(reponse04);
            for (int i = 0; i < json.length(); i++) {
                et01.setText(json.getJSONObject(i).getString("paciente"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void MostrarData05(String reponse05) {
        try {
            JSONArray json = new JSONArray(reponse05);
            for (int i = 0; i < json.length(); i++) {
                et01.setText(json.getJSONObject(i).getString("paciente"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void MostrarData06(String reponse06) {
        try {
            JSONArray json = new JSONArray(reponse06);
            for (int i = 0; i < json.length(); i++) {
                et01.setText(json.getJSONObject(i).getString("paciente"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void MostrarData07(String reponse07) {
        try {
            JSONArray json = new JSONArray(reponse07);
            for (int i = 0; i < json.length(); i++) {
                et01.setText(json.getJSONObject(i).getString("paciente"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void MostrarData08(String reponse08) {
        try {
            JSONArray json = new JSONArray(reponse08);
            for (int i = 0; i < json.length(); i++) {
                et01.setText(json.getJSONObject(i).getString("paciente"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
*/
   /* public void MostrarData09(String reponse09) {
        try {
            JSONArray json = new JSONArray(reponse09);
            for (int i = 0; i < json.length(); i++) {
                et01.setText(json.getJSONObject(i).getString("paciente"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
/*
    public void MostrarData10(String reponse10) {
        try {
            JSONArray json = new JSONArray(reponse10);
            for (int i = 0; i < json.length(); i++) {
                et01.setText(json.getJSONObject(i).getString("paciente"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void MostrarData11(String reponse11) {
        try {
            JSONArray json = new JSONArray(reponse11);
            for (int i = 0; i < json.length(); i++) {
                et01.setText(json.getJSONObject(i).getString("paciente"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void MostrarData12(String reponse12) {
        try {
            JSONArray json = new JSONArray(reponse12);
            for (int i = 0; i < json.length(); i++) {
                et01.setText(json.getJSONObject(i).getString("paciente"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void MostrarData13(String reponse13) {
        try {
            JSONArray json = new JSONArray(reponse13);
            for (int i = 0; i < json.length(); i++) {
                et01.setText(json.getJSONObject(i).getString("paciente"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void MostrarData14(String reponse14) {
        try {
            JSONArray json = new JSONArray(reponse14);
            for (int i = 0; i < json.length(); i++) {
                et01.setText(json.getJSONObject(i).getString("paciente"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }*/

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.main) {
            Intent searchIntent = new Intent(Rol.this, MainActivity.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R. anim.push_out_left);
            finish();
        } else if (id == R.id.consulta) {
            Intent searchIntent = new Intent(Rol.this, Consulta.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            finish();
        } else if (id == R.id.resultado) {
            Intent searchIntent = new Intent(Rol.this, Resultado.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            finish();
        } else if (id == R.id.rol) {
            Intent searchIntent = new Intent(Rol.this, Rol.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
package com.vitaldentcix.dentallawyer.dentallawyer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {
    AutoCompleteTextView UsernameEt;
    EditText PasswordEt;
    TextView tvDni;
    EditText etDni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    /*public void OnLogin(View view) {
        String username = UsernameEt.getText().toString();
        String password = PasswordEt.getText().toString();
        String type = "login";
        BackgroundWorker_login backgroundWorkerLogin = new BackgroundWorker_login(this);
        backgroundWorkerLogin.execute(type, username, password);
    }*/

    public void irMain(View view) {
        Intent searchIntent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(searchIntent);
    }

    public void OnLogin(View view) {
        Log.i("depurar","click");
        Thread tr = new Thread() {
            @Override
            public void run() {
                UsernameEt = (AutoCompleteTextView) findViewById(R.id.etUserName);
                PasswordEt = (EditText) findViewById(R.id.etPassword);
                final String result = enviarDatosGet(UsernameEt.getText().toString(), PasswordEt.getText().toString());
                Log.i("depurar",result);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int r = obtDatosJson(result);
                        if(r>0) {
                            Intent searchIntent = new Intent(LoginActivity.this, MainActivity.class);
                            searchIntent.putExtra("dni", MostrarData(result));
                            startActivity(searchIntent);
                        }
                    }
                });
            }
        };
        tr.start();
    }


    public String enviarDatosGet(String usuario, String pwd) {
        URL url = null;
        String linea = "";
        int respuesta = 0;
        StringBuilder result = null;

        try {

            url = new URL("http://192.168.25.73/DentalLawyer/login/login.php?usuario=" + usuario + "&pwd=" + pwd);

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

    public String MostrarData(String reponse) {
        String a = null;
        try {
            JSONArray json = new JSONArray(reponse);
            for (int i = 0; i < json.length(); i++) {
                a = (json.getJSONObject(i).getString("usuario"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return a;
    }
}

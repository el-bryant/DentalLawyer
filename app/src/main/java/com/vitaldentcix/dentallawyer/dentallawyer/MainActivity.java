package com.vitaldentcix.dentallawyer.dentallawyer;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    TextView tvDni;
    EditText etDni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        tvDni = (TextView) findViewById(R.id.tvUsuario);
        etDni = (EditText) findViewById(R.id.etUserName);
        String recup_var_string = getIntent().getStringExtra("dni");
        tvDni.setText(recup_var_string);
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

    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.main) {
            Intent searchIntent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(searchIntent);
            searchIntent.putExtra("usuario_dni", tvDni.getText().toString());
            overridePendingTransition(R.anim.pull_in_right, R. anim.push_out_left);
            finish();
        } else if (id == R.id.consulta) {
            Intent searchIntent = new Intent(MainActivity.this, Consulta.class);
            startActivity(searchIntent);
            searchIntent.putExtra("usuario_dni", tvDni.getText().toString());
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            finish();
        } else if (id == R.id.resultado) {
            Intent searchIntent = new Intent(MainActivity.this, Resultado.class);
            startActivity(searchIntent);
            searchIntent.putExtra("usuario_dni", tvDni.getText().toString());
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            finish();
        } else if (id == R.id.rol) {
            Intent searchIntent = new Intent(MainActivity.this, Rol.class);
            startActivity(searchIntent);
            searchIntent.putExtra("usuario_dni", tvDni.getText().toString());
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            finish();
        } else if (id == R.id.logout) {
            Intent searchIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(searchIntent);
            overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

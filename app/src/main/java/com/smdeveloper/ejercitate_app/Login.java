package com.smdeveloper.ejercitate_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    TextView RecordarContrasena;
    EditText user, passw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Titulo de actionBAr en blanco
        getSupportActionBar().setTitle("");

        // Referenciando variables a componentes del xml
        RecordarContrasena = (TextView) findViewById(R.id.Recordar_clave);
        user = (EditText) findViewById(R.id.input_userName_login);
        passw = (EditText) findViewById(R.id.input_contraseña_login);

        //Toast para recordar la contraseña
        RecordarContrasena.setOnClickListener(v -> Toast.makeText(Login.this, "Su contraseña es: 1234", Toast.LENGTH_SHORT).show());
    }

    public void IniciarSesion(View view) {
        if(user.getText().toString().equals("admin") && passw.getText().toString().equals("1234")) {
            Intent newIntent = new Intent(this, Home.class);
            newIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(newIntent);
            finish();
        }
        else{
            Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
        }
        if(user.getText().toString().equals("")) {
            Toast.makeText(this, "Por favor ingrese el Usuario", Toast.LENGTH_SHORT).show();
            user.requestFocus();
        }
        else if(passw.getText().toString().equals("")) {
            Toast.makeText(this, "Por favor ingrese la contraseña", Toast.LENGTH_SHORT).show();
            passw.requestFocus();
        }
    }

    //Destruir la app
    public void onBackPressed() {
        finish();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();
        if(id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
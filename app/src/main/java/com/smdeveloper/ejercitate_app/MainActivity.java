package com.smdeveloper.ejercitate_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Ocultar barras del celular (navegación y notificaciones)
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
         */

        //Titulo de actionBAr en blanco
        getSupportActionBar().setTitle("");

    }

    public void Registro(View view){
        Intent newIntent = new Intent(this,Registro.class);
        newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //evita crear pestañas continuas
        startActivity(newIntent);
    }
    public void Login(View view){
        Intent newIntent = new Intent(this,Login.class);
        newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //evita crear pestañas continuas
        startActivity(newIntent);
    }

    //Confirmación para salir de la app, dialogo como optionPane
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            new AlertDialog.Builder(this,R.style.Theme_AppCompat_Dialog_Alert)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Información")
                    .setMessage("¿Desea salir?")
                    .setNegativeButton("No",null)
                    .setPositiveButton("Si", (dialog, which) -> MainActivity.this.finish()).show();
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
}
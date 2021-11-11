package com.smdeveloper.ejercitate_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Titulo de actionBAr en blanco
        getSupportActionBar().setTitle("HOME");
    }

    //Confirmación para salir de la app, dialogo como optionPane
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            new AlertDialog.Builder(this,R.style.Theme_AppCompat_Dialog_Alert)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Información")
                    .setMessage("¿Desea salir? \nAl salir, se cerrará la sesión.")
                    .setNegativeButton("No",null)
                    .setPositiveButton("Si", (dialog, which) -> Home.this.finish()).show();
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
}
package com.example.danielbc.logyreg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import OpenHelper.SQLite_OpenHelper;

public class AlumnoProfesor extends AppCompatActivity {

    private Button btAl, btPro;

    SQLite_OpenHelper helper=new SQLite_OpenHelper(this, "BD1", null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno_profesor);

        btAl = (Button) findViewById(R.id.alumno);
        btPro = (Button) findViewById(R.id.profe);

    }

    public void alumnoPuls(View v){
        Intent a = new Intent(getApplicationContext(), RegAlumno.class);
        startActivity(a);

    }
    public void profePuls(View v){
        Intent p = new Intent(getApplicationContext(), RegProfesor.class);
        startActivity(p);

    }
}
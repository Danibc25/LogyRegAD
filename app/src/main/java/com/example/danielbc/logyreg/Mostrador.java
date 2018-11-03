package com.example.danielbc.logyreg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Mostrador extends AppCompatActivity {
    private TextView ensenar;
    private MyDBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrador);
        dbAdapter = new MyDBAdapter(this);
        dbAdapter.abrirBD();
        ensenar = (TextView) findViewById(R.id.ensenar);
        ArrayList <String> alumnos = dbAdapter.recuperarAlumnos();
        ensenar.setText(alumnos.get(2));
    }
}

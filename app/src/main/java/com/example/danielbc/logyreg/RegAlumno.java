package com.example.danielbc.logyreg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.SQLite_OpenHelper;

public class RegAlumno extends AppCompatActivity {
    private EditText alNombre, alApellido, alEdad, alCiclo, alCurso, alMedia;

    //SQLite_OpenHelper helper = new SQLite_OpenHelper(this, "BD1", null, 1);
    private MyDBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_alumno);

        alNombre = (EditText) findViewById(R.id.etAlNombre);
        alApellido = (EditText) findViewById(R.id.etAlApellido);
        alEdad = (EditText) findViewById(R.id.etAlEdad);
        alCiclo = (EditText) findViewById(R.id.etAlCiclo);
        alCurso = (EditText) findViewById(R.id.etAlCurso);
        alMedia = (EditText) findViewById(R.id.etAlMedia);

        dbAdapter = new MyDBAdapter(this);
        dbAdapter.abrirBD();

    }


    public void bRegistroPuls(View V) {
        String nombre = alNombre.getText().toString();
        String apellido = alApellido.getText().toString();
        String edad = alEdad.getText().toString();
        String ciclo = alCiclo.getText().toString();
        String curso = alCurso.getText().toString();
        String media = alMedia.getText().toString();

        if ((nombre.compareTo("") != 0) && (apellido.compareTo("") != 0) &&
                (edad.compareTo("") != 0) && (ciclo.compareTo("") != 0) &&
                (curso.compareTo("") != 0) && (media.compareTo("") != 0)) {


            //METODO GUARDAR ALUMNO

            dbAdapter.abrirBD();
            dbAdapter.insertarAlumno(nombre, apellido, edad, ciclo, curso, media);
            //dbAdapter.cerrarBD();

            Toast creada =
                    Toast.makeText(getApplicationContext(),
                            "Alumno ingresado en la tabla", Toast.LENGTH_SHORT);
            creada.show();

        } else {

            Toast error =
                    Toast.makeText(getApplicationContext(),
                            "Completa todos los campos :)", Toast.LENGTH_SHORT);

            error.show();

        }

    }


    public void bCancelarPuls(View V) {
        Intent cancelar = new Intent(getApplicationContext(), AlumnoProfesor.class);
        startActivity(cancelar);


    }
}

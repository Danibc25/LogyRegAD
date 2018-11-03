package com.example.danielbc.logyreg;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class Mostrador extends AppCompatActivity {
    private TextView ensenar;
    private MyDBAdapter dbAdapter;
    private Button alTodos, alCiclo, alCurso, proTodos, Todo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrador);

        ensenar = (TextView) findViewById(R.id.ensenar);
        alTodos = (Button) findViewById(R.id.alTodo);
        alCiclo = (Button) findViewById(R.id.alCiclos);
        alCurso = (Button) findViewById(R.id.alCursos);
        proTodos = (Button) findViewById(R.id.proTodo);
        Todo = (Button) findViewById(R.id.alproTodo);

        dbAdapter = new MyDBAdapter(this);
        dbAdapter.abrirBD();
    }

    public void alTodoPuls(View V) {

        ensenar.setText("Alumnos");

        ArrayList<String> alumnos = dbAdapter.recuperarAlumnos();

        for (int i = 0; i < alumnos.size(); i++) {

            ensenar.setText(ensenar.getText() + "\n" + alumnos.get(i) + "\n");

        }
    }

    public void alCiclosPuls(View V) {

        Toast t1 = Toast.makeText(getApplicationContext(),
                "Boton en construcción", Toast.LENGTH_SHORT);
        t1.show();
    }

    public void alCursosPuls(View V) {

        Toast t1 = Toast.makeText(getApplicationContext(),
                "Boton en construcción", Toast.LENGTH_SHORT);
        t1.show();
    }

    public void proTodoPuls(View V) {

        ensenar.setText("Profesores");

        ArrayList<String> profesores = dbAdapter.recuperarProfesores();

        for (int i = 0; i < profesores.size(); i++) {

            ensenar.setText(ensenar.getText() + "\n" + profesores.get(i));

        }
    }

    public void alproTodoPuls(View V) {

        Toast t1 = Toast.makeText(getApplicationContext(),
                "Boton en construcción", Toast.LENGTH_SHORT);
        t1.show();
    }
}

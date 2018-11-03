package com.example.danielbc.logyreg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDBAdapter {

    private static final String DATABASE_NAME = "DB2.db";
    private static final String DATABASE_AL = "alumnos";
    private static final String DATABASE_PRO = "profesores";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE_AL = "CREATE TABLE " + DATABASE_AL + " (_ID integer primary key autoincrement, Nombre text, Apellido text, Edad text, Ciclo text, Curso text, Media text);";
    private static final String DATABASE_CREATE_PRO = "CREATE TABLE " + DATABASE_PRO + " (_ID integer primary key autoincrement, Nombre text, Apellido text, Edad text, Ciclo text, Tutor text, Despacho text);";
    private static final String DATABASE_DROP_AL = "DROP TABLE IF EXISTS " + DATABASE_AL + ";";
    private static final String DATABASE_DROP_PRO = "DROP TABLE IF EXISTS " + DATABASE_PRO + ";";

    // Contexto de la aplicación que usa la base de datos
    private final Context context;

    // Clase SQLiteOpenHelper para crear/actualizar la base de datos
    private MyDbHelper dbHelper;

    // Instancia de la base de datos
    private SQLiteDatabase db;

    public MyDBAdapter(Context c) {

        context = c;
        dbHelper = new MyDbHelper(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public void abrirBD() {

        try {
            db = dbHelper.getWritableDatabase();
        } catch (SQLiteException e) {
            db = dbHelper.getReadableDatabase();
        }

    }

    public void insertarAlumno(String nom, String ape, String eda, String cic, String curs, String med) {

        ContentValues valores = new ContentValues();

        valores.put("Nombre", nom);
        valores.put("Apellido", ape);
        valores.put("Edad", eda);
        valores.put("Ciclo", cic);
        valores.put("Curso", curs);
        valores.put("Media", med);

        db.insert(DATABASE_AL, null, valores);

    }

    public void insertarProfesor(String nom, String ape, String eda, String cic, String tut, String desp) {

        ContentValues valores2 = new ContentValues();

        valores2.put("Nombre", nom);
        valores2.put("Apellido", ape);
        valores2.put("Edad", eda);
        valores2.put("Ciclo", cic);
        valores2.put("Tutor", tut);
        valores2.put("Despacho", desp);

        db.insert(DATABASE_PRO, null, valores2);

    }


    public ArrayList<String> recuperarAlumnos() {

        ArrayList<String> alumnos = new ArrayList<String>();

        //Recuperamos en un cursor la consulta realizada
        Cursor cursor = db.query(DATABASE_AL, null, null, null, null, null, null);

        //Recorremos el cursor
        if (cursor != null && cursor.moveToFirst()) {
            do {
                alumnos.add("* " + cursor.getString(1) + " " + cursor.getString(2) + "\n" + cursor.getString(3) + " años, " + cursor.getString(5) + " " + cursor.getString(4) + ", Nota media: " + cursor.getString(6));
            } while (cursor.moveToNext());
        }
        return alumnos;
    }

    public ArrayList<String> recuperarProfesores() {

        ArrayList<String> profesores = new ArrayList<String>();

        //Recuperamos en un cursor la consulta realizada
        Cursor cursor = db.query(DATABASE_PRO, null, null, null, null, null, null);

        //Recorremos el cursor
        if (cursor != null && cursor.moveToFirst()) {

            do {

                profesores.add("* " + cursor.getString(1) + " " + cursor.getString(2) + "\n" + cursor.getString(3) + " años, " + cursor.getString(5) + " " + cursor.getString(4) + ", Nota media: " + cursor.getString(6));

            } while (cursor.moveToNext());

        }
        return profesores;
    }

    private static class MyDbHelper extends SQLiteOpenHelper {

        public MyDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(DATABASE_CREATE_AL);
            db.execSQL(DATABASE_CREATE_PRO);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL(DATABASE_DROP_AL);
            db.execSQL(DATABASE_DROP_PRO);
            onCreate(db);

        }

    }
}
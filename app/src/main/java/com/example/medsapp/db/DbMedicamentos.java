package com.example.medsapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.medsapp.entidades.Medicamentos;

import java.util.ArrayList;

public class DbMedicamentos extends DbHelper{

    Context context;

    public DbMedicamentos(@Nullable Context context) {
        super(context);

        this.context = context;
    }

    public long insertarMedicamento(String nombre, String cantidad, String presentacion,
                                    String uso, String gramaje, String receta, String via,
                                    String patente, String caducidad, String advertencias){

        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();

            values.put("nombre", nombre);
            values.put("cantidad", cantidad);
            values.put("presentacion", presentacion);
            values.put("uso", uso);
            values.put("gramaje", gramaje);
            values.put("receta", receta);
            values.put("via", via);
            values.put("patente", patente);
            values.put("caducidad", caducidad);
            values.put("advertencias", advertencias);

            id = db.insert(TABLE_MEDICAMENTOS, null, values);

        } catch (Exception ex){
            ex.toString();
        }

        return id;
    }

    public ArrayList<Medicamentos> mostrarMedicamentos(){

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Medicamentos> listaMedicamentos = new ArrayList<>();

        Medicamentos medicamento = null;
        Cursor cursorMedicamentos = null;

        cursorMedicamentos = db.rawQuery("SELECT * FROM "+ TABLE_MEDICAMENTOS, null);

        if(cursorMedicamentos.moveToFirst()){
            do {
                medicamento = new Medicamentos();
                medicamento.setId(cursorMedicamentos.getInt(0));
                medicamento.setNombre(cursorMedicamentos.getString(1));
                medicamento.setCantidad("Cantidad recetada: "+cursorMedicamentos.getString(2));
                medicamento.setPresentacion("Presentación: "+cursorMedicamentos.getString(3));
                medicamento.setUso("Uso indicado: "+cursorMedicamentos.getString(4));
                medicamento.setGramaje("Gramaje/ml: "+cursorMedicamentos.getString(5));
                medicamento.setReceta("Receta: "+cursorMedicamentos.getString(6));
                medicamento.setVia("Via de administración: "+cursorMedicamentos.getString(7));
                medicamento.setPatente("Patente/Generico: "+cursorMedicamentos.getString(8));
                medicamento.setCaducidad("Caducidad "+cursorMedicamentos.getString(9));
                medicamento.setAdvertencias("Advertencias: "+cursorMedicamentos.getString(10));
                listaMedicamentos.add(medicamento);
            } while (cursorMedicamentos.moveToNext());
        }
        cursorMedicamentos.close();

        return listaMedicamentos;
    }

}


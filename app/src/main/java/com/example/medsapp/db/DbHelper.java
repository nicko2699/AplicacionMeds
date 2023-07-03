package com.example.medsapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "medicamentos.db";
    public static final String TABLE_MEDICAMENTOS = "t_medicamentos";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_MEDICAMENTOS+ "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombre TEXT NOT NULL," +
                "cantidad TEXT NOT NULL," +
                "presentacion TEXT NOT NULL," +
                "uso TEXT NOT NULL," +
                "gramaje TEXT NOT NULL," +
                "receta TEXT," +
                "via TEXT NOT NULL," +
                "patente TEXT NOT NULL," +
                "caducidad TEXT NOT NULL," +
                "advertencias TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE "+ TABLE_MEDICAMENTOS);

        onCreate(sqLiteDatabase);
    }
}


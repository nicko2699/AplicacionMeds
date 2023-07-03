package com.example.medsapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medsapp.Adaptadores.ListaMedicamentosAdapter;
import com.example.medsapp.db.DbHelper;
import com.example.medsapp.db.DbMedicamentos;
import com.example.medsapp.entidades.Medicamentos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView listaMedicamentos;
    ArrayList<Medicamentos> listaArrayMedicamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaMedicamentos = findViewById(R.id.listaMedicamentos);
        listaMedicamentos.setLayoutManager(new LinearLayoutManager(this));

        DbMedicamentos dbMedicamentos = new DbMedicamentos(MainActivity.this);

        listaArrayMedicamentos = new ArrayList<>();
        ListaMedicamentosAdapter adapter = new ListaMedicamentosAdapter(dbMedicamentos.mostrarMedicamentos());
        listaMedicamentos.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.nav_registro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.agregarMed:
                nuevoMedicamento();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void nuevoMedicamento(){
        Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
        startActivity(intent);
    }

}
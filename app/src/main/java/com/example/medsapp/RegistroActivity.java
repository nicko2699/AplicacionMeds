package com.example.medsapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.medsapp.db.DbMedicamentos;

public class RegistroActivity extends AppCompatActivity {

    EditText txtNombre, txtCantidad, txtPresentacion, txtUso, txtGramaje, txtReceta,
            txtVia, txtPatente, txtCaducidad, txtAdvertencias;

    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtNombre = findViewById(R.id.txtNombre);
        txtCantidad = findViewById(R.id.txtCantidad);
        txtPresentacion = findViewById(R.id.txtPresentacion);
        txtUso = findViewById(R.id.txtUso);
        txtGramaje = findViewById(R.id.txtGramaje);
        txtReceta = findViewById(R.id.txtReceta);
        txtVia = findViewById(R.id.txtVia);
        txtPatente = findViewById(R.id.txtPatente);
        txtCaducidad = findViewById(R.id.txtCaducidad);
        txtAdvertencias = findViewById(R.id.txtAdvertencias);
        btnRegistrar =findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbMedicamentos dbMedicamentos = new DbMedicamentos(RegistroActivity.this);

                long id = dbMedicamentos.insertarMedicamento(txtNombre.getText().toString(), txtCantidad.getText().toString(),
                        txtPresentacion.getText().toString(), txtUso.getText().toString(), txtGramaje.getText().toString(),
                        txtReceta.getText().toString(), txtVia.getText().toString(), txtPatente.getText().toString(),
                        txtCaducidad.getText().toString(), txtAdvertencias.getText().toString());

                if(id>0){
                    Toast.makeText(RegistroActivity.this, "Medicamento guardado", Toast.LENGTH_SHORT).show();
                    limpiar();
                } else{
                    Toast.makeText(RegistroActivity.this, "Error al guardar medicamento", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void limpiar(){
        txtNombre.setText("");
        txtCantidad.setText("");
        txtPresentacion.setText("");
        txtUso.setText("");
        txtGramaje.setText("");
        txtReceta.setText("");
        txtVia.setText("");
        txtPatente.setText("");
        txtCaducidad.setText("");
        txtAdvertencias.setText("");
    }

}

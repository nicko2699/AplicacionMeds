package com.example.medsapp.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medsapp.R;
import com.example.medsapp.entidades.Medicamentos;

import java.util.ArrayList;

public class ListaMedicamentosAdapter extends RecyclerView.Adapter<ListaMedicamentosAdapter.MedicamentoViewHolder> {

    ArrayList<Medicamentos> listaMedicamentos;

    public ListaMedicamentosAdapter(ArrayList<Medicamentos> listaMedicamentos){
        this.listaMedicamentos = listaMedicamentos;
    }

    @NonNull
    @Override
    public MedicamentoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_medicamento, null, false);
        return new MedicamentoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicamentoViewHolder holder, int position) {

        holder.viewNombre.setText(listaMedicamentos.get(position).getNombre());
        holder.viewCantidad.setText(listaMedicamentos.get(position).getCantidad());
        holder.viewPresentacion.setText(listaMedicamentos.get(position).getPresentacion());
        holder.viewUso.setText(listaMedicamentos.get(position).getUso());
        holder.viewGramaje.setText(listaMedicamentos.get(position).getGramaje());
        holder.viewReceta.setText(listaMedicamentos.get(position).getReceta());
        holder.viewVia.setText(listaMedicamentos.get(position).getVia());
        holder.viewPatente.setText(listaMedicamentos.get(position).getPatente());
        holder.viewCaducidad.setText(listaMedicamentos.get(position).getCaducidad());
        holder.viewAdvertencias.setText(listaMedicamentos.get(position).getAdvertencias());

    }

    @Override
    public int getItemCount() {
        return listaMedicamentos.size();
    }

    public class MedicamentoViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewCantidad, viewPresentacion, viewUso, viewGramaje,
        viewReceta, viewVia, viewPatente, viewCaducidad, viewAdvertencias;

        public MedicamentoViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewCantidad = itemView.findViewById(R.id.viewCantidad);
            viewPresentacion = itemView.findViewById(R.id.viewPresentacion);
            viewUso = itemView.findViewById(R.id.viewUso);
            viewGramaje = itemView.findViewById(R.id.viewGramaje);
            viewReceta = itemView.findViewById(R.id.viewReceta);
            viewVia = itemView.findViewById(R.id.viewVia);
            viewPatente = itemView.findViewById(R.id.viewPatente);
            viewCaducidad = itemView.findViewById(R.id.viewCaducidad);
            viewAdvertencias = itemView.findViewById(R.id.viewAdvertencias);

        }
    }
}

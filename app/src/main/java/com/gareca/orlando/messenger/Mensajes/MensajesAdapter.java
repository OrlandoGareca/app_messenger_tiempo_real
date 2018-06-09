package com.gareca.orlando.messenger.Mensajes;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gareca.orlando.messenger.R;

import java.util.List;

public class MensajesAdapter extends RecyclerView.Adapter<MensajesAdapter.MensajesViewHolder>{

    private List<MensajeDeTexto> mensajesDeTextos;

    public MensajesAdapter(List<MensajeDeTexto> mensajesDeTextos) {
        this.mensajesDeTextos = mensajesDeTextos;
    }

    @NonNull
    @Override
    public MensajesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_view_mensajes,parent,false);
        return new MensajesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MensajesViewHolder holder, int position) {
        holder.TvMensaje.setText(mensajesDeTextos.get(position).getMensaje());
        holder.TvHora.setText(mensajesDeTextos.get(position).getHoraDelMensaje());
    }

    @Override
    public int getItemCount() {
        return mensajesDeTextos.size();
    }

    static class MensajesViewHolder extends RecyclerView.ViewHolder{

        CardView carView;
        TextView TvMensaje;
        TextView TvHora;
        MensajesViewHolder(View itemView) {
            super(itemView);
            carView = (CardView) itemView.findViewById(R.id.cvMensaje);
            TvMensaje = (TextView) itemView.findViewById(R.id.msTexto);
            TvHora = (TextView) itemView.findViewById(R.id.msHora);

        }
    }
}

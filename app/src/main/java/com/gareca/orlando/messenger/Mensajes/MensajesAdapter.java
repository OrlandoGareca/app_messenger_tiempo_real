package com.gareca.orlando.messenger.Mensajes;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gareca.orlando.messenger.R;

import java.util.List;

public class MensajesAdapter extends RecyclerView.Adapter<MensajesAdapter.MensajesViewHolder>{

    private List<MensajeDeTexto> mensajesDeTextos;
    private Context context;

    public MensajesAdapter(List<MensajeDeTexto> mensajesDeTextos,Context context) {
        this.mensajesDeTextos = mensajesDeTextos;
        this.context = context;
    }

    @NonNull
    @Override
    public MensajesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_view_mensajes,parent,false);
        return new MensajesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MensajesViewHolder holder, int position) {
        RelativeLayout.LayoutParams rl = (RelativeLayout.LayoutParams) holder.carView.getLayoutParams();
        FrameLayout.LayoutParams fl = (FrameLayout.LayoutParams) holder.mensajeBG.getLayoutParams();
        LinearLayout.LayoutParams llHora = (LinearLayout.LayoutParams)holder.TvHora.getLayoutParams();
        LinearLayout.LayoutParams llMensaje = (LinearLayout.LayoutParams)holder.TvMensaje.getLayoutParams();
        if(mensajesDeTextos.get(position).getTipoMensaje()==1){//emisor
            holder.mensajeBG.setBackgroundResource(R.drawable.in_message_bg);
            rl.addRule(RelativeLayout.ALIGN_PARENT_LEFT,0);
            rl.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            llMensaje.gravity = Gravity.RIGHT;
            llHora.gravity = Gravity.RIGHT;
            fl.gravity = Gravity.RIGHT;
            holder.TvMensaje.setGravity(Gravity.RIGHT);
        }else if(mensajesDeTextos.get(position).getTipoMensaje()==2){
            holder.mensajeBG.setBackgroundResource(R.drawable.out_message_bg);
            rl.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,0);
            rl.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            fl.gravity = Gravity.LEFT;
            llMensaje.gravity = Gravity.LEFT;
            llHora.gravity = Gravity.LEFT;
            holder.TvMensaje.setGravity(Gravity.LEFT);
        }
        holder.carView.setLayoutParams(rl);
        holder.mensajeBG.setLayoutParams(fl);
        holder.TvHora.setLayoutParams(llHora);
        holder.TvMensaje.setLayoutParams(llMensaje);

        holder.TvMensaje.setText(mensajesDeTextos.get(position).getMensaje());
        holder.TvHora.setText(mensajesDeTextos.get(position).getHoraDelMensaje());
        if(android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
            holder.carView.getBackground().setAlpha(0);
        }else{
            holder.carView.setBackgroundColor(ContextCompat.getColor(context,android.R.color.transparent));
        }

    }

    @Override
    public int getItemCount() {
        return mensajesDeTextos.size();
    }

    static class MensajesViewHolder extends RecyclerView.ViewHolder{

        CardView carView;
        LinearLayout mensajeBG;
        TextView TvMensaje;
        TextView TvHora;
        MensajesViewHolder(View itemView) {
            super(itemView);
            carView = (CardView) itemView.findViewById(R.id.cvMensaje);
            mensajeBG = (LinearLayout)itemView.findViewById(R.id.mensajeBG);
            TvMensaje = (TextView) itemView.findViewById(R.id.msTexto);
            TvHora = (TextView) itemView.findViewById(R.id.msHora);

        }
    }
}

package com.gareca.orlando.messenger.Mensajes;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.gareca.orlando.messenger.R;

import java.util.ArrayList;
import java.util.List;


public class mensajeria extends AppCompatActivity {

    private RecyclerView rv;
    private List<MensajeDeTexto> mensajeDeTextos;
    private MensajesAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensajeria);
        mensajeDeTextos = new ArrayList<>();
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);

        rv = (RecyclerView)findViewById(R.id.rvMensajes);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        for(int i=0;i<10;i++){
            MensajeDeTexto mensajeDeTextoAuxiliar = new MensajeDeTexto();
            mensajeDeTextoAuxiliar.setId(""+i);
            mensajeDeTextoAuxiliar.setMensaje("hola"+i);
            mensajeDeTextoAuxiliar.setTipoMensaje(i);
            mensajeDeTextoAuxiliar.setHoraDelMensaje("10:2"+i);
            mensajeDeTextos.add(mensajeDeTextoAuxiliar);
        }

        adapter = new MensajesAdapter(mensajeDeTextos);
        rv.setAdapter(adapter);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

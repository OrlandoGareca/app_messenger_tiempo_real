package com.gareca.orlando.messenger.Mensajes;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gareca.orlando.messenger.R;

import java.util.ArrayList;
import java.util.List;


public class mensajeria extends AppCompatActivity {

    private RecyclerView rv;
    private Button bTenviarMensaje;
    private EditText eTEscribirMensaje;
    private List<MensajeDeTexto> mensajeDeTextos;
    private MensajesAdapter adapter;
    private int TEXT_LINES = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensajeria);
        mensajeDeTextos = new ArrayList<>();
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        bTenviarMensaje = (Button)findViewById(R.id.bTEnviarMensaje);
        eTEscribirMensaje = (EditText)findViewById(R.id.eTEscribirMensaje);
        rv = (RecyclerView)findViewById(R.id.rvMensajes);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        for(int i=0;i<10;i++){
            MensajeDeTexto mensajeDeTextoAuxiliar = new MensajeDeTexto();
            mensajeDeTextoAuxiliar.setId(""+i);
            mensajeDeTextoAuxiliar.setMensaje("El emisor numero"+i + "Te ha enviado un mensaje");
            mensajeDeTextoAuxiliar.setTipoMensaje(1);
            mensajeDeTextoAuxiliar.setHoraDelMensaje("10:2"+i);
            mensajeDeTextos.add(mensajeDeTextoAuxiliar);
        }

        for(int i=0;i<10;i++){
            MensajeDeTexto mensajeDeTextoAuxiliar = new MensajeDeTexto();
            mensajeDeTextoAuxiliar.setId(""+i);
            mensajeDeTextoAuxiliar.setMensaje("el Receptor numero"+i+ "te ah enviado un mensaje");
            mensajeDeTextoAuxiliar.setTipoMensaje(2);
            mensajeDeTextoAuxiliar.setHoraDelMensaje("10:2"+i);
            mensajeDeTextos.add(mensajeDeTextoAuxiliar);
        }

        adapter = new MensajesAdapter(mensajeDeTextos,this);
        rv.setAdapter(adapter);

        eTEscribirMensaje.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(eTEscribirMensaje.getLayout().getLineCount()!=TEXT_LINES){
                    setScrollBarChat();
                    TEXT_LINES = eTEscribirMensaje.getLayout().getLineCount();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        bTenviarMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateMensaje(eTEscribirMensaje.getText().toString());
            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setScrollBarChat();
    }
    public void CreateMensaje(String mensaje){
        MensajeDeTexto mensajeDeTextoAuxiliar = new MensajeDeTexto();
        mensajeDeTextoAuxiliar.setId("0");
        mensajeDeTextoAuxiliar.setMensaje(mensaje);
        mensajeDeTextoAuxiliar.setTipoMensaje(1);
        mensajeDeTextoAuxiliar.setHoraDelMensaje("10:20");
        mensajeDeTextos.add(mensajeDeTextoAuxiliar);
        adapter.notifyDataSetChanged();
        eTEscribirMensaje.setText("");
        setScrollBarChat();
    }
    public void setScrollBarChat(){
        rv.scrollToPosition(adapter.getItemCount()-1);
    }
}

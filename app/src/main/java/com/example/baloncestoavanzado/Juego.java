package com.example.baloncestoavanzado;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



public class Juego extends AppCompatActivity {

    private TextView mar_local,mar_visitante,localNombre,visitanteNombre;
    private String deQuien;
    private Integer jugador1eq1 = 0;
    private Integer jugador2eq1 = 0;
    private Integer jugador3eq1 = 0;
    private Integer jugador4eq1 = 0;
    private Integer jugador5eq1 = 0;
    private Integer jugador1eq2 = 0;
    private Integer jugador2eq2 = 0;
    private Integer jugador3eq2 = 0;
    private Integer jugador4eq2 = 0;
    private Integer jugador5eq2 = 0;
    private Integer ultimotiro = 0;
    private Integer ultimoJugador = 0;
    private Spinner ctiro;
    Button restart;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restart = findViewById(R.id.button15);
        mar_local= findViewById(R.id.Plocal);
        mar_visitante= findViewById(R.id.Pvis);
        localNombre = findViewById(R.id.Nlocal);
        visitanteNombre = findViewById(R.id.Nvis);

        Intent intent=getIntent();
        if(!intent.getStringExtra("local").equals("")) {
            localNombre.setText(intent.getStringExtra("local"));
        }
        if(!intent.getStringExtra("visitante").equals("")) {
            visitanteNombre.setText(intent.getStringExtra("visitante"));
        }

        ctiro = findViewById(R.id.ctiro);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.tiro, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ctiro.setAdapter(adapter);

        restart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                restaurarEstado();
            }
        });
    }
    public void setCtiro(View view) {
        String tipotiro = ctiro.getSelectedItem().toString();
        switch (tipotiro) {
            case "Tiro libre":
                ultimotiro = 1;
                comprobarCtiro(view,ultimotiro);
                break;
            case "Doble":
                ultimotiro = 2;
                comprobarCtiro(view, ultimotiro);
                break;
            case "Triple":
                ultimotiro = 3;
                comprobarCtiro(view, ultimotiro);
                break;
        }
    }
    public void comprobarCtiro(View view, int valor){
            switch(view.getId()){
                case R.id.button:
                    deQuien="local";
                    ultimoJugador=1;
                    jugador1eq1+=valor;
                    mar_local.setText(Integer.toString((Integer.parseInt(mar_local.getText().toString())+valor)));
                    break;
                case R.id.button2:
                    deQuien="local";
                    ultimoJugador=2;
                    jugador2eq1+=valor;
                    mar_local.setText(Integer.toString((Integer.parseInt(mar_local.getText().toString())+valor)));
                    break;
                case R.id.button3:
                    deQuien="local";
                    ultimoJugador=3;
                    jugador3eq1+=valor;
                    mar_local.setText(Integer.toString((Integer.parseInt(mar_local.getText().toString())+valor)));
                    break;
                case R.id.button4:
                    deQuien="local";
                    ultimoJugador=4;
                    jugador4eq1+=valor;
                    mar_local.setText(Integer.toString((Integer.parseInt(mar_local.getText().toString())+valor)));
                    break;
                case R.id.button5:
                    deQuien="local";
                    ultimoJugador=5;
                    jugador5eq1+=valor;
                    mar_local.setText(Integer.toString((Integer.parseInt(mar_local.getText().toString())+valor)));
                    break;
                case R.id.button6:
                    deQuien="visitante";
                    ultimoJugador=6;
                    jugador1eq2+=valor;
                    mar_visitante.setText(Integer.toString((Integer.parseInt(mar_visitante.getText().toString())+valor)));
                    break;
                case R.id.button7:
                    deQuien="visitante";
                    ultimoJugador=7;
                    jugador2eq2+=valor;
                    mar_visitante.setText(Integer.toString((Integer.parseInt(mar_visitante.getText().toString())+valor)));
                    break;
                case R.id.button8:
                    deQuien="visitante";
                    ultimoJugador=8;
                    jugador3eq2+=valor;
                    mar_visitante.setText(Integer.toString((Integer.parseInt(mar_visitante.getText().toString())+valor)));
                    break;
                case R.id.button9:
                    deQuien="visitante";
                    ultimoJugador=9;
                    jugador4eq2+=valor;
                    mar_visitante.setText(Integer.toString((Integer.parseInt(mar_visitante.getText().toString())+valor)));
                    break;
                case R.id.button10:
                    deQuien="visitante";
                    ultimoJugador=10;
                    jugador5eq2+=valor;
                    mar_visitante.setText(Integer.toString((Integer.parseInt(mar_visitante.getText().toString())+valor)));
                    break;
            }

        }
    public void borrarUltimaJugada(View view){
        switch (deQuien){
            case "local":
                mar_local.setText(Integer.toString((Integer.parseInt(mar_local.getText().toString())-ultimotiro)));
                restarUltimoJugada();
                break;
            case "visitante":
                mar_visitante.setText(Integer.toString((Integer.parseInt(mar_visitante.getText().toString())-ultimotiro)));
                restarUltimoJugada();
                break;
            default:
                Toast.makeText(getApplicationContext(),"No hay jugada anterior", Toast.LENGTH_SHORT).show();
                break;
        }
        deQuien="";
    }

    public void restarUltimoJugada(){
        switch (ultimoJugador){
            case 1:
                jugador1eq1-=ultimotiro;
                break;
            case 2:
                jugador2eq1-=ultimotiro;
                break;
            case 3:
                jugador3eq1-=ultimotiro;
                break;
            case 4:
                jugador4eq1-=ultimotiro;
                break;
            case 5:
                jugador5eq1-=ultimotiro;
                break;
            case 6:
                jugador1eq2-=ultimotiro;
                break;
            case 7:
                jugador2eq2-=ultimotiro;
                break;
            case 8:
                jugador3eq2-=ultimotiro;
                break;
            case 9:
                jugador4eq2-=ultimotiro;
                break;
            case 10:
                jugador5eq2-=ultimotiro;
                break;
            default:

                break;
        }
        ultimoJugador=0;
    }
    public void mandarStats(View view) {
        Intent intent = new Intent(this, statsviewer.class);
        intent.putExtra("mLocal",mar_local.getText().toString());
        intent.putExtra("mVis",mar_visitante.getText().toString());
        intent.putExtra("1eq1",Integer.toString(jugador1eq1));
        intent.putExtra("2eq1",Integer.toString(jugador2eq1));
        intent.putExtra("3eq1",Integer.toString(jugador3eq1));
        intent.putExtra("4eq1",Integer.toString(jugador4eq1));
        intent.putExtra("5eq1",Integer.toString(jugador5eq1));
        intent.putExtra("1eq2",Integer.toString(jugador1eq2));
        intent.putExtra("2eq2",Integer.toString(jugador2eq2));
        intent.putExtra("3eq2",Integer.toString(jugador3eq2));
        intent.putExtra("4eq2",Integer.toString(jugador4eq2));
        intent.putExtra("5eq2",Integer.toString(jugador5eq2));
        startActivity(intent);
    }

    public void restaurarEstado(){
        mar_local.setText("0");
        mar_visitante.setText("0");
        jugador1eq1=0;
        jugador2eq1=0;
        jugador3eq1=0;
        jugador4eq1=0;
        jugador5eq1=0;
        jugador1eq2=0;
        jugador2eq2=0;
        jugador3eq2=0;
        jugador4eq2=0;
        jugador5eq2=0;
        ultimoJugador=0;
        ultimotiro=0;
    }


}

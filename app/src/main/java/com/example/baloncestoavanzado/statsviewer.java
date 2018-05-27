package com.example.baloncestoavanzado;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class statsviewer extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats_main);


        TextView ptjugador1eq1 = (TextView) findViewById(R.id.pl1);
        TextView ptjugador2eq1 = (TextView) findViewById(R.id.pl2);
        TextView ptjugador3eq1 = (TextView) findViewById(R.id.pl3);
        TextView ptjugador4eq1 = (TextView) findViewById(R.id.pl4);
        TextView ptjugador5eq1 = (TextView) findViewById(R.id.pl5);
        TextView ptjugador1eq2 = (TextView) findViewById(R.id.pv1);
        TextView ptjugador2eq2 = (TextView) findViewById(R.id.pv2);
        TextView ptjugador3eq2 = (TextView) findViewById(R.id.pv3);
        TextView ptjugador4eq2 = (TextView) findViewById(R.id.pv4);
        TextView ptjugador5eq2 = (TextView) findViewById(R.id.pv5);
        TextView local = (TextView) findViewById(R.id.textView10);
        TextView visitante = (TextView) findViewById(R.id.textView11);
        Intent intent = getIntent();

        ptjugador1eq1.setText(intent.getStringExtra("1eq1"));
        ptjugador2eq1.setText(intent.getStringExtra("2eq1"));
        ptjugador3eq1.setText(intent.getStringExtra("3eq1"));
        ptjugador4eq1.setText(intent.getStringExtra("4eq1"));
        ptjugador5eq1.setText(intent.getStringExtra("5eq1"));
        ptjugador1eq2.setText(intent.getStringExtra("1eq2"));
        ptjugador2eq2.setText(intent.getStringExtra("2eq2"));
        ptjugador3eq2.setText(intent.getStringExtra("3eq2"));
        ptjugador4eq2.setText(intent.getStringExtra("4eq2"));
        ptjugador5eq2.setText(intent.getStringExtra("5eq2"));
        local.setText(intent.getStringExtra("mLocal"));
        visitante.setText(intent.getStringExtra("mVis"));
    }

    public void volver(View view) {
        finish();
    }
}
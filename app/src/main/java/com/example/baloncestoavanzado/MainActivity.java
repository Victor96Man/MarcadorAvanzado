package com.example.baloncestoavanzado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText local;
    EditText visitante;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.init_main);
        local = (EditText) findViewById(R.id.editText);
        visitante = (EditText) findViewById(R.id.editText2);

    }
    public void mandarMensaje(View view) {

        Intent intent=new Intent(this, Juego.class);
        intent.putExtra("local",local.getText().toString());
        intent.putExtra("visitante",visitante.getText().toString());
        startActivity(intent);
    }
}

package com.example.alcoolgasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText edtalcool;
    EditText edtgasolina;
    Button btnCalcular;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carregaComponentes();
        configurarBotaoCalcular();
    }

    protected void carregaComponentes() {
        edtalcool = findViewById(R.id.edtalcool);
        edtgasolina = findViewById(R.id.edtgasolina);
        btnCalcular = findViewById(R.id.btnCalcularvalor);
        txtResultado = findViewById(R.id.txtResultado);
    }

    protected void configurarBotaoCalcular() {
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultado = realizaCalculo();
                exibiResultado(resultado);
                limpaCampos();
            }
        });
    }

    protected String realizaCalculo() {
        float alcool = Float.parseFloat(edtalcool.getText().toString());
        float gasolina = Float.parseFloat(edtgasolina.getText().toString());

        String resultado;
        double maior;

        maior = gasolina * 0.7 ;

        if (maior <= alcool) {
            resultado = "Abasteça com Gasolina";

        }else{
            resultado = "Abasteça com Alcool";

        }
        return resultado;
    }

    protected void exibiResultado(String resultado) {
        txtResultado.setText(resultado);
    }

    protected void limpaCampos() {
        edtalcool.setText("");
        edtgasolina.setText("");
        edtgasolina.requestFocus();
    }
}
package com.example.victor.androidimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import shared.helpers.StrHelper;

public class ImcActivity extends AppCompatActivity {
    Button btnCalc;
    Button btnBack;
    EditText txtHeight;
    EditText txtPeso;
    TextView lblResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        this.btnBack = this.findViewById(R.id.btnBack);
        this.btnCalc = this.findViewById(R.id.btnCalc);
        this.txtHeight = this.findViewById(R.id.txtHeight);
        this.txtPeso = this.findViewById(R.id.txtPeso);
        this.lblResult = this.findViewById(R.id.lblResult);

        txtPeso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtPeso.setText("");
            }
        });

        txtHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtHeight.setText("");
            }
        });

        this.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        this.btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double peso = StrHelper.toDouble(txtPeso.getText().toString());
                double altura = StrHelper.toDouble(txtHeight.getText().toString());
                double imc = calc(peso, altura);
                String result = "";
                if (imc < 18.5) {
                    // baixo peso
                    result = "Peso baixo";
                } else if (imc >= 18.5 && imc <= 24.9) {
                    // peso normal
                    result = "Peso normal";
                } else if (imc >= 25 && imc <= 29.9) {
                    // sobrepeso
                    result = "Sobrepeso";
                } else if (imc >= 30 && imc <= 34.9) {
                    // obeseidade grau 1
                    result = "Obesidade Grau 1";
                } else if (imc >= 35 && imc <= 40) {
                    // obesidade grau 2
                    result = "Obesidade Grau 2";
                } else if (peso > 40) {
                    // obesidade morbida
                    result = "Obesidade Morbida";
                }
                lblResult.setText(result);
            }
        });

    }

    private double calc(double peso, double altura) {
        double imc = peso / (altura * altura);
        return imc;
    }
}

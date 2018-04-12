package com.example.victor.androidimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import shared.helpers.StrHelper;

public class ManActivity extends AppCompatActivity {

    Button btnCalc;
    Button btnBack;
    TextView lblResult;
    EditText txtHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man);
        btnCalc = findViewById(R.id.btnCalc);
        txtHeight = findViewById(R.id.txtHeight);
        lblResult = findViewById(R.id.lblResult);
        btnBack = findViewById(R.id.btnBack);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lblResult.setText(StrHelper.toString(calc(StrHelper.toDouble(txtHeight.getText().toString()))));
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        txtHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtHeight.setText("");
            }
        });
    }

    private double calc(double altura) {
        return (altura - 100) * 0.90;
    }
}

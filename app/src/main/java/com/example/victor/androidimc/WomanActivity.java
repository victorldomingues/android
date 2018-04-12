package com.example.victor.androidimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import shared.helpers.StrHelper;

public class WomanActivity extends AppCompatActivity {

    Button btnCalc;
    Button btnBack;
    EditText txtHeight;
    TextView lblResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_woman);
        this.btnCalc = this.findViewById(R.id.btnCalc);
        this.txtHeight = this.findViewById(R.id.txtHeight);
        this.lblResult = this.findViewById(R.id.lblResult);
        this.btnBack = this.findViewById(R.id.btnBack);
        this.btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lblResult.setText(StrHelper.toString(calc(StrHelper.toDouble(txtHeight.getText().toString()))));
            }
        });
        this.btnBack.setOnClickListener(new View.OnClickListener() {
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
        return (altura - 100) * 0.85;
    }
}

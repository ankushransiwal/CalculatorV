package com.example.ankush.calculatorv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNumber;
    Button btnSquare,btnSquareRoot,btnCube;
    TextView tvResult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    etNumber = (EditText)findViewById(R.id.etNumber);
    btnCube = (Button)findViewById(R.id.btnCube);
    btnSquare = (Button)findViewById(R.id.btnSquare);
    btnSquareRoot = (Button)findViewById(R.id.btnSquareRoot);
    tvResult = (TextView)findViewById(R.id.tvResult);


    btnSquare.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(etNumber.getText().toString().length()==0){
                Toast.makeText(MainActivity.this, "Enter a Number", Toast.LENGTH_SHORT).show();
                etNumber.requestFocus();
                return;
            }
            double number = Double.parseDouble(etNumber.getText().toString());
            double square = number * number;
            tvResult.setText("Square of "+number+" is: "+square);
        }
    });

    btnSquareRoot.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(etNumber.getText().toString().length()==0){
                Toast.makeText(MainActivity.this, "Enter a Number", Toast.LENGTH_SHORT).show();
                etNumber.requestFocus();
                return;
            }
            double number = Double.parseDouble(etNumber.getText().toString());
            double squareRoot = Math.sqrt(number);
            tvResult.setText("Square root of "+number+" is: "+squareRoot);
        }
    });

    btnCube.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(etNumber.getText().toString().length()==0){
                Toast.makeText(MainActivity.this, "Enter a Number", Toast.LENGTH_SHORT).show();
                etNumber.requestFocus();
                return;
            }
            double number = Double.parseDouble(etNumber.getText().toString());
            double cube = number * number * number;
            tvResult.setText("Cube of "+number+" is: "+cube);
        }
    });



    }
}

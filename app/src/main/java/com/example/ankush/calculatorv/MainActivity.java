package com.example.ankush.calculatorv;

import android.content.pm.ActivityInfo;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText etNumber;
    Button btnSquare,btnSquareRoot,btnCube;
    TextView tvResult;
    long bpt;
    TextToSpeech tts;

    @Override
    public void onBackPressed(){
        if(bpt + 1500 > System.currentTimeMillis())
            super.onBackPressed();
        else
            Toast.makeText(this, "Press back one more time", Toast.LENGTH_SHORT).show();
        bpt= System.currentTimeMillis();
    }


    @Override
    protected void onSaveInstanceState(Bundle b1) {
        b1.putString("ans",tvResult.getText().toString());
        super.onSaveInstanceState(b1);
    }

    @Override
    protected void onRestoreInstanceState(Bundle b2) {
        String a = b2.getString("ans");
        tvResult.setText(a);
        super.onRestoreInstanceState(b2);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    int orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
    setRequestedOrientation(orientation);

    tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
        @Override
        public void onInit(int i) {
            if(i!=TextToSpeech.ERROR){
                tts.setLanguage(Locale.ENGLISH);
            }
        }
    });

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
            String msg = tvResult.getText().toString();
            tts.speak(msg,TextToSpeech.QUEUE_FLUSH,null);
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
            String msg = tvResult.getText().toString();
            tts.speak(msg,TextToSpeech.QUEUE_FLUSH,null);
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
            String msg = tvResult.getText().toString();
            tts.speak(msg,TextToSpeech.QUEUE_FLUSH,null);
        }
    });



    }
}

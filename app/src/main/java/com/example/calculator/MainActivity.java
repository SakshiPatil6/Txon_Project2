package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button one, two, three, four, five, six, seven, eight, nine, zero, mul, div, add, sub,equal,back,dot,ac,mod;
    private TextView result;
    private EditText info;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char DIVISION = '/';
    private final char MULTIPLICATION = '*';

    private final char MOD='%';
    private double val1=Double.NaN;
    private double val2;
    private char ACTION;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();

        zero.setOnClickListener(view ->
                info.setText(info.getText().toString() + "0"));

        one.setOnClickListener(view -> info.setText(info.getText().toString() + "1"));

        two.setOnClickListener(view -> info.setText(info.getText().toString() + "2"));

        three.setOnClickListener(view -> info.setText(info.getText().toString() + "3"));

        four.setOnClickListener(view -> info.setText(info.getText().toString() + "4"));

        five.setOnClickListener(view -> info.setText(info.getText().toString() + "5"));

        six.setOnClickListener(view -> info.setText(info.getText().toString() + "6"));

        seven.setOnClickListener(view -> info.setText(info.getText().toString() + "7"));

        eight.setOnClickListener(view -> info.setText(info.getText().toString() + "8"));

        nine.setOnClickListener(view -> info.setText(info.getText().toString() + "9"));

        dot.setOnClickListener(view -> info.setText(info.getText().toString() + "."));

        ac.setOnClickListener(v -> {
            info.setText(null);
            result.setText(null);
        });


        add.setOnClickListener(view -> {
            ACTION= ADDITION;
            compute();
            result.setText(val1 + "+");
            info.setText(null);
        });

        sub.setOnClickListener(view -> {
            ACTION= SUBTRACTION;
            compute();
            result.setText(val1 + "-");
            info.setText(null);
        });

        mul.setOnClickListener(view -> {
            ACTION= MULTIPLICATION;
            compute();
            result.setText(val1 + "*");
            info.setText(null);
        });

        div.setOnClickListener(view -> {
            ACTION= DIVISION;
            compute();
            result.setText(val1 + "/");
            info.setText(null);
        });

        mod.setOnClickListener(view -> {
            ACTION= MOD;
            compute();
            result.setText(val1 + "%");
            info.setText(null);
        });

        equal.setOnClickListener(view -> {
            val2= Double.parseDouble(info.getText().toString());
            if(ACTION==ADDITION) {
                result.setText(result.getText().toString() + val2 + "=" + (val1+val2));
            } else if (ACTION==SUBTRACTION) {
                result.setText(result.getText().toString() + val2 + "=" + (val1-val2));
            } else if (ACTION==DIVISION) {
                result.setText(result.getText().toString() + val2 + "=" + (val1/val2));
            }
            else if (ACTION==MULTIPLICATION) {
                result.setText(result.getText().toString() + val2 + "=" + (val1*val2));
            }
            else if (ACTION==MOD) {
                result.setText(result.getText().toString() + val2 + "=" + (val1*val2));
            }

            info.setText(null);
        });

        back.setOnClickListener(view -> {
            if(info.getText().length() > 0){
                CharSequence name = info.getText().toString();
                info.setText(name.subSequence(0, name.length()-1));
            }
            else
            {
                val1 = Double.NaN;
                val2 = Double.NaN;
                info.setText(null);
                result.setText(null);
            }
        });


    }

    private void setupUIViews()
    {
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        zero=findViewById(R.id.zero);
        mul=findViewById(R.id.mul);
        div=findViewById(R.id.div);
        add=findViewById(R.id.plus);
        sub=findViewById(R.id.minus);
        back=findViewById(R.id.back);
        result=findViewById(R.id.textView);
        info=findViewById(R.id.ed);
        equal=findViewById(R.id.equal);
        dot=findViewById(R.id.dot);
        ac=findViewById(R.id.AC);
        mod=findViewById(R.id.mod);

    }

    private void compute()
    {
        if(!Double.isNaN(val1))
        {
            val2= Double.parseDouble(info.getText().toString());

            switch (ACTION)
            {
                case ADDITION:
                    val1=val1 + val2;
                    break;
                case SUBTRACTION:
                    val1=val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1=val1 * val2;
                    break;
                case DIVISION:
                    val1=val1 / val2;
                    break;
            }
        }

        else
        {
            val1 = Double.parseDouble(info.getText().toString());
        }
    }

}
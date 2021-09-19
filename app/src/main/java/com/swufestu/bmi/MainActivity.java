package com.swufestu.bmi;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Listen for button clicks
        Button button = findViewById(R.id.submit);
        button.setOnClickListener(calcBMI);
    }

    private OnClickListener calcBMI = new OnClickListener() {
        public void onClick(View v) {
            DecimalFormat nf = new DecimalFormat("0.00");
            EditText fieldheight = findViewById(R.id.height);
            EditText fieldweight = findViewById(R.id.weight);
            double height = Double
                    .parseDouble(fieldheight.getText().toString()) / 100;
            double weight = Double
                    .parseDouble(fieldweight.getText().toString());
            double BMI = weight / (height * height);

            TextView result = findViewById(R.id.result);
            result.setText("Your BMI is " + nf.format(BMI));

            // Give health advice
            TextView fieldsuggest = findViewById(R.id.suggest);
            if (BMI > 40) {
                fieldsuggest.setText(R.string.advice_veryheavy);
            } else if (BMI > 35) {
                fieldsuggest.setText(R.string.advice_tooheavy);
            }else if (BMI > 25) {
                fieldsuggest.setText(R.string.advice_heavy);
            }else if (BMI > 18.5) {
                fieldsuggest.setText(R.string.advice_average);
            }else {
                fieldsuggest.setText(R.string.advice_light);
            }
        }
    };

}
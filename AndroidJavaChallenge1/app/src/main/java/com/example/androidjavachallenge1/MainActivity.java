package com.example.androidjavachallenge1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText inchesEditText;
    Button calculateButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inchesString = inchesEditText.getText().toString();

                if (inchesString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "You have to input number", Toast.LENGTH_SHORT).show();
                } else {
                    double height = convertToMeters(inchesString);

                    displayResult(height);
                }


            }
        });


    }

    private void findViews() {
        inchesEditText = findViewById(R.id.edit_text_inches);

        calculateButton = findViewById(R.id.button_calculate);

        resultTextView = findViewById(R.id.text_view_result);
    }

    private double convertToMeters(String inchesString) {
        double inches = Integer.parseInt(inchesString);
        return inches * 0.0254;
    }

    private void displayResult(double height) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String resultText = myDecimalFormatter.format(height);

        resultTextView.setText(resultText + " Meters");
    }
}
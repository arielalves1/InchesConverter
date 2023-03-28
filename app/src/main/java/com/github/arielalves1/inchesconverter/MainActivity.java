package com.github.arielalves1.inchesconverter;

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
            public void onClick(View v) {

                //checking if edittext is empty or not -then- assign it to the var
                String inchesString = inchesEditText.getText().toString();
                if(inchesString.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please input a value", Toast.LENGTH_SHORT).show();

                }else {
                    double result = calculateHeight(inchesString);

                    //formating the result method
                    displayResult(result);
                }
            }
        });
    }

    private void findViews(){
        inchesEditText = findViewById(R.id.edit_text_inches);
        resultTextView = findViewById(R.id.text_view_result);
        calculateButton = findViewById(R.id.button_calculate);

    }

    private double calculateHeight(String inchesString) {
      int inches = Integer.parseInt(inchesString);

      return inches * 0.0254;



    }
    private void displayResult(double result) {
        DecimalFormat myFomrmatter = new DecimalFormat("0.00");
        String resultString = myFomrmatter.format(result);
        resultTextView.setText(resultString+ "meters");
    }



}
package com.example.tipme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button ten, fifteen, twenty, resetButton;
    private EditText enterAmount;
    private TextView tipAmountText, totalText;
    private double tipAmount, totalAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ten = findViewById(R.id.ten_percent);
        fifteen = findViewById(R.id.fifteen_percent);
        twenty = findViewById(R.id.twenty_percent);
        enterAmount = findViewById(R.id.amount);
        tipAmountText = findViewById(R.id.tip_text);
        totalText = findViewById(R.id.total_text);
        resetButton = findViewById(R.id.reset_button);

        enterAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().trim().length()==0){
                    ten.setEnabled(false);
                    fifteen.setEnabled(false);
                    twenty.setEnabled(false);
                    resetButton.setVisibility(View.GONE);
                } else {
                    ten.setEnabled(true);
                    fifteen.setEnabled(true);
                    twenty.setEnabled(true);
                    resetButton.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ten.setOnClickListener(v -> {
            tipAmount = getTipAmount(10);
            totalAmount = getTotalAmount(tipAmount);
            tipAmountText.setText("Tip is $" + tipAmount);
            totalText.setText("Total is $"+ totalAmount);
            });

        fifteen.setOnClickListener(v -> {
            tipAmount = getTipAmount(15);
            totalAmount = getTotalAmount(tipAmount);
            tipAmountText.setText("Tip is $" + tipAmount);
            totalText.setText("Total is $"+ totalAmount);
        });

        twenty.setOnClickListener(v -> {
            tipAmount = getTipAmount(20);
            totalAmount = getTotalAmount(tipAmount);
            tipAmountText.setText("Tip is $" + tipAmount);
            totalText.setText("Total is $"+ totalAmount);
        });

        resetButton.setOnClickListener(v -> {
            enterAmount.setText("");
            tipAmountText.setText("");
            totalText.setText("");
        });
    }

    private double getTipAmount(int percent) {
        String amountEnteredString = enterAmount.getText().toString();
        double amountEntered = Double.parseDouble(amountEnteredString);
        double result = (amountEntered*percent)/100;
        result = Math.round(result * 100.0) / 100.0;
        return result;
    }

    private double getTotalAmount(double tipAmount){
        String amountEnteredString = enterAmount.getText().toString();
        double amountEntered = Double.parseDouble(amountEnteredString);
        double result = amountEntered + tipAmount;
        result = Math.round(result * 100.0) / 100.0;
        return result;
    }
}

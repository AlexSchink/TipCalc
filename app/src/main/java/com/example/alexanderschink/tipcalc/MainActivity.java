package com.example.alexanderschink.tipcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity
implements SeekBar.OnSeekBarChangeListener, TextWatcher {

    private TextView amountText;
    private EditText userInput;
    private TextView percentageText;
    private SeekBar percentageBar;
    private TextView tipText;
    private TextView totalText;

    private NumberFormat percentageFormatter = NumberFormat.getPercentInstance();
    private NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

    private double percentageValue;
    private double amountValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amountText = (TextView) findViewById(R.id.amaountText);
        userInput = (EditText) findViewById(R.id.userInput);
        percentageText = (TextView) findViewById(R.id.percentageText);
        percentageBar = (SeekBar) findViewById(R.id.percentageBar);
        tipText = (TextView) findViewById(R.id.tipText);
        totalText = (TextView) findViewById(R.id.totalText);

        percentageBar.setOnSeekBarChangeListener(this);

        userInput.addTextChangedListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        percentageValue = progress / 100.0;
        percentageText.setText(percentageFormatter.format(percentageValue));

        double tipValue = amountValue * percentageValue;
        double totalValue = amountValue + tipValue;

        tipText.setText(currencyFormatter.format(tipValue));
        totalText.setText(currencyFormatter.format(totalValue));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }


    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence text, int i, int i1, int i2) {
        if (text.length() > 0) {
            double value = Double.parseDouble(text.toString());
            amountValue = value / 100;
            amountText.setText(currencyFormatter.format(amountValue));

            double tipValue = amountValue * percentageValue;
            double totalValue = amountValue + tipValue;

            tipText.setText(currencyFormatter.format(tipValue));
            totalText.setText(currencyFormatter.format(totalValue));
        }
        else {

            userInput.setText(0);
            tipText.setText(0);
            totalText.setText(0);
        }
    }


    @Override
    public void afterTextChanged(Editable editable) {

    }


}

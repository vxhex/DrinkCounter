package com.eerieapplications.drinkcounter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

public class MainActivity extends ActionBarActivity {

    public static final String PREFS_NAME = "DrinkCounterPrefs";
    private TextView _drinkCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _drinkCounter = (TextView) findViewById(R.id.drinkCounter);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String drinks = settings.getString("drinks", "0");
        _drinkCounter.setText(String.valueOf(drinks));

        final Button counter = (Button) findViewById(R.id.drinkButton);
        counter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int value = Integer.parseInt(_drinkCounter.getText().toString());
                value += 1;
                _drinkCounter.setText(String.valueOf(value));
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("drinks", _drinkCounter.getText().toString());
                editor.commit();
            }
        });

        final Button reset = (Button) findViewById(R.id.resetButton);
        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int value = Integer.parseInt(_drinkCounter.getText().toString());
                value = 0;
                _drinkCounter.setText(String.valueOf(value));
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("drinks", _drinkCounter.getText().toString());
                editor.commit();
            }
        });
    }

    @Override
    protected void onStop(){
        super.onStop();
    }
}

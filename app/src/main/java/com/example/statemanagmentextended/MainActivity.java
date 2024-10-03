package com.example.statemanagmentextended;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_COUNT = "count";
    private static final String KEY_TEXT = "text";
    private static final String KEY_CHECKBOX = "checkbox";
    private static final String KEY_SWITCH = "switch";
    private TextView textViewCount;
    private int counter = 0;
    private String text = "";
    private Boolean checkbox = false;
    private Boolean switchTheme = false;
    private EditText editText;
    private CheckBox checkBox;
    private Switch SwitchTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewCount = findViewById(R.id.textViewCount);
        editText = findViewById(R.id.edit_text_id);
        checkBox = findViewById(R.id.checkbox);
        SwitchTheme = findViewById(R.id.switchTheme);
        Button buttonIncrement = findViewById(R.id.buttonIncrement);
        text = String.valueOf(editText);
        checkbox = Boolean.valueOf(checkbox);
        switchTheme = Boolean.valueOf(String.valueOf(SwitchTheme));

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(KEY_COUNT);
            text = savedInstanceState.getString(KEY_TEXT);
            checkbox = savedInstanceState.getBoolean(KEY_CHECKBOX);
            switchTheme = savedInstanceState.getBoolean(KEY_SWITCH);
        }
        updateCountText();
        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                updateCountText();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT, counter);
        outState.putString(KEY_TEXT, text);
        outState.putBoolean(KEY_CHECKBOX, checkbox);
        outState.putBoolean(KEY_CHECKBOX, switchTheme);
    }

    private void updateCountText() {
        textViewCount.setText("Licznik: " + counter);
    }
}
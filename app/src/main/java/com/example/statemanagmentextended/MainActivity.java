package com.example.statemanagmentextended;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
    private String textCheck = "";
    private Boolean checkbox = false;
    private Boolean switchTheme = false;
    private EditText editText;
    private CheckBox checkBox;
    private Switch SwitchTheme;
    private TextView textCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewCount = findViewById(R.id.textViewCount);
        editText = findViewById(R.id.edit_text_id);
        checkBox = findViewById(R.id.checkbox);
        textCheckBox = findViewById(R.id.textCheckBox);
        SwitchTheme = findViewById(R.id.switchTheme);
        Button buttonIncrement = findViewById(R.id.buttonIncrement);

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
            SwitchTheme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(SwitchTheme.isChecked())
                    {
                        switchTheme = true;
                    }
                    else
                    {
                        switchTheme = false;
                    }
                    updateSwitchTheme();
                }
            });
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(checkBox.isChecked())
                    {
                        checkbox = true;
                    }
                    else
                    {
                        checkbox = false;
                    }
                    updateCheckBox();
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



    public void updateCountText() {
        textViewCount.setText("Licznik: " + counter);
    }
    public void updateSwitchTheme() {
        if(switchTheme){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
    public void updateCheckBox() {
        if(checkbox) {
            textCheckBox.setText("Witam:)");
        }else{
            textCheckBox.setText("");
        }
    }
}

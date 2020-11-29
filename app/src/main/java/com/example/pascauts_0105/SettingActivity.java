package com.example.pascauts_0105;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {
    RadioButton english,indo;
    RadioGroup group;
    Button btnsave;
    private String languageToLoad = "eng";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        group = findViewById(R.id.radioGroup);
        english = findViewById(R.id.radioButton);
        indo = findViewById(R.id.radioButton2);
        btnsave = findViewById(R.id.btn_save);
        btnsave.setOnClickListener(this);

        english.setOnClickListener(this);
        indo.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.radioButton:
                languageToLoad = "eng";
                break;
            case R.id.radioButton2:
                languageToLoad = "in";
                break;
            case R.id.btn_save:
                Intent intent = new Intent(SettingActivity.this,MainActivity.class);
                intent.putExtra(MainActivity.LANG,languageToLoad);
                startActivity(intent);
                finish();
                break;
        }

    }



    public interface Language{
        public String setlang(String s);
    }
}

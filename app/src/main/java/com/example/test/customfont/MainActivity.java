package com.example.test.customfont;

import android.graphics.Typeface;
import android.support.v4.text.TextDirectionHeuristicCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextWatcher {
    TextView t;
    EditText tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = (TextView)findViewById(R.id.my_text);
        Typeface customFont = Typeface.createFromAsset(getAssets(),"fonts/zeroes three.ttf");
        t.setTypeface(customFont);
        tv = (EditText)findViewById(R.id.editText);
        tv.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Toast.makeText(this,"Before String",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Toast.makeText(this,"On Change",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void afterTextChanged(Editable s) {
        int num = Integer.parseInt(s.toString());
        if(num>100){
            s.replace(0,s.length(),"100");
        }
    }
}

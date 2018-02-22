package com.example.admin.signapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class Dictionary extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        Button alp =(Button) findViewById(R.id.alphabets);
        Button num =(Button) findViewById(R.id.numbers);
        Button btnfuw = (Button) findViewById(R.id.fuw);
        ImageButton backbtn = (ImageButton) findViewById(R.id.backbutton_sign);
        ImageButton homebtn = (ImageButton) findViewById(R.id.homebutton_sign);
        alp.setOnClickListener(this);
        num.setOnClickListener(this);
        btnfuw.setOnClickListener(this);
        backbtn.setOnClickListener(this);
        homebtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Dictionary.this, Main3Activity.class);
        switch (v.getId())
        {
            case R.id.alphabets:
                intent.putExtra("Userchoice", 1);
                startActivity(intent);
                finish();
                break;

            case R.id.numbers:
                intent.putExtra("Userchoice", 2);
                startActivity(intent);
                finish();
                break;

            case R.id.fuw:
                intent.putExtra("Userchoice", 3);
                startActivity(intent);
                finish();
                break;


        }

    }
}

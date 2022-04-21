package com.example.is2011_igra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button Play;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Play = (Button) findViewById(R.id.button);
        Play.setOnClickListener(this);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, GameActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}
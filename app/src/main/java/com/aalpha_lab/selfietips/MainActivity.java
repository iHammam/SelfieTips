package com.aalpha_lab.selfietips;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {

    Button button_GetTips;
    Button button_TakeSelfie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_GetTips = (Button) findViewById(R.id.button_get_tips);
        button_TakeSelfie = (Button) findViewById(R.id.button_take_selfie);

        // Third Party Animation Library example
        YoYo.with(Techniques.StandUp)
                .duration(2000)
                .playOn(findViewById(R.id.button_take_selfie));

        // GetTips Button behaviour
        button_GetTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent);
            }
        });

        // TakeSelfie Button behaviour
        button_TakeSelfie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TakeSelfie.class);
                startActivity(intent);
            }
        });

    }
}

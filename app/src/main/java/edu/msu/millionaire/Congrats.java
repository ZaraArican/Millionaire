package edu.msu.millionaire;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//Game over page
public class Congrats extends AppCompatActivity {
int lastScore;
    TextView tv_score;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats);
        tv_score=(TextView)findViewById(R.id.tv_score);
        button=(Button)findViewById(R.id.button);

//displays last score , activity shared from mainactivity
        SharedPreferences preferences=getSharedPreferences("prefs",0);
        lastScore=preferences.getInt("lastScore",0);

tv_score.setText("You earned: $" +lastScore);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }


}

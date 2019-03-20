package edu.msu.millionaire;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class Main2Activity extends AppCompatActivity {
 Button b_answer1,b_answer2,b_answer3,b_answer4;
 ImageView iv_flag;
 TextView textView;
    int lastScore;
    private int mScore=0;
 List<CountryItem> list;
    Random r;
    int turn=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        r=new Random();
        iv_flag=(ImageView) findViewById(R.id.iv_flag);
        textView=(TextView)findViewById(R.id.textView);
        b_answer1=(Button)findViewById(R.id.b_answer1);
        b_answer2=(Button)findViewById(R.id.b_answer2);
        b_answer3=(Button)findViewById(R.id.b_answer3);
        b_answer4=(Button)findViewById(R.id.b_answer4);
        list=new ArrayList<>();
        //add all flags and names to the list
      for(int i=0; i <new Database().answers.length; i++){
     list.add(new CountryItem(new Database().answers[i], new Database().flags[i]));
 }
//shuffle the countries
        Collections.shuffle(list);
newQuestion(turn);
//textView.setText("You Earned:$ " +mScore);
        b_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//check if answer is correct
                if(b_answer1.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    Toast.makeText(Main2Activity.this, "This is the CORRECT answer. ",Toast.LENGTH_SHORT).show();
                    mScore=mScore+100000;
                    updateScore(mScore);
                    textView.setText("You Earned:$ " +mScore);
                    //check if the last question
                    if (turn<list.size()){
turn++;
newQuestion(turn);
                    }else{
                        Toast.makeText(Main2Activity.this, "You Finished the game "  ,Toast.LENGTH_SHORT).show();
                        m();
                    }
                }else{
                    gameover();
                    Toast.makeText(Main2Activity.this, "That was the incorrect answer.",Toast.LENGTH_SHORT).show();
                }
            }
        });
        b_answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if answer is correct
                if(b_answer2.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    Toast.makeText(Main2Activity.this, "This is the CORRECT answer. ",Toast.LENGTH_SHORT).show();
                    mScore=mScore+100000;
                    updateScore(mScore);
                    textView.setText("You Earned:$ " +mScore);

                    //check if the last question
                    if (turn<list.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        Toast.makeText(Main2Activity.this, "You Finished the game "  ,Toast.LENGTH_SHORT).show();
                        m();
                    }
                }else{
                    gameover();
                    Toast.makeText(Main2Activity.this, "That was the incorrect answer.",Toast.LENGTH_SHORT).show();
                }
            }
        });
        b_answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if answer is correct
                if(b_answer3.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    Toast.makeText(Main2Activity.this, "This is the CORRECT answer. ",Toast.LENGTH_SHORT).show();
                    mScore=mScore+100000;
                    updateScore(mScore);
                    textView.setText("You Earned:$ " +mScore);

                    //check if the last question
                    if (turn<list.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        Toast.makeText(Main2Activity.this, "You Finished the game "  ,Toast.LENGTH_SHORT).show();
                        m();
                    }
                }else{
                    gameover();
                    Toast.makeText(Main2Activity.this, "That was the incorrect answer.",Toast.LENGTH_SHORT).show();
                }
            }
        });
        b_answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if answer is correct
                if(b_answer4.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    Toast.makeText(Main2Activity.this, "This is the CORRECT answer. ",Toast.LENGTH_SHORT).show();
                    mScore=mScore+100000;
                    updateScore(mScore);
                    textView.setText("You Earned:$ " +mScore);
                    //check if the last question
                    if (turn<list.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        Toast.makeText(Main2Activity.this, "You Finished the game "  ,Toast.LENGTH_SHORT).show();

                       m();
                    }
                }else{
                    gameover();
                    Toast.makeText(Main2Activity.this, "That was the incorrect answer.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
private void gameover(){
//shares data from one activty to another
    SharedPreferences preferences=getSharedPreferences("prefs",0);
    SharedPreferences.Editor editor=preferences.edit();
    editor.putInt("lastScore",mScore);
    editor.apply();
//starts new activity, goes to congrats.class
    Intent intent=new Intent(getApplicationContext(),Congrats.class);
    startActivity(intent);
    finish();
}

private void m(){
    Intent intent=new Intent(getApplicationContext(),Finish.class);
    startActivity(intent);
    finish();
}
    private void updateScore(int point){
    }
    private void newQuestion(int number){
        //set flag image to the screen
        iv_flag.setImageResource(list.get(number-1).getImage());
//decide on which button to place the correct answer
        int correct_answer=r.nextInt(4)+1;
        int firstButton=number-1;
        int secondButton;
        int thirdButton;
        int fourthButton;
        switch (correct_answer){
            case 1:
            b_answer1.setText(list.get(firstButton).getName());
            do{
                secondButton=r.nextInt(list.size());
            }while (secondButton == firstButton);
            do{
                thirdButton=r.nextInt(list.size());
             }while (thirdButton == firstButton || thirdButton == secondButton);
            do{
                fourthButton=r.nextInt(list.size());
            }while (fourthButton == firstButton || fourthButton== secondButton || fourthButton == thirdButton);
                b_answer2.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(fourthButton).getName());
                break;
            case 2:
                b_answer2.setText(list.get(firstButton).getName());
                do{
                    secondButton=r.nextInt(list.size());
                }while (secondButton == firstButton);
                do{
                    thirdButton=r.nextInt(list.size());
                }while (thirdButton == firstButton || thirdButton == secondButton);
                do{
                    fourthButton=r.nextInt(list.size());
                }while (fourthButton == firstButton || fourthButton== secondButton || fourthButton == thirdButton);
                b_answer1.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(fourthButton).getName());
                break;
            case 3:
                b_answer3.setText(list.get(firstButton).getName());

                do{
                    secondButton=r.nextInt(list.size());
                }while (secondButton == firstButton);
                do{
                    thirdButton=r.nextInt(list.size());
                }while (thirdButton == firstButton || thirdButton == secondButton);
                do{
                    fourthButton=r.nextInt(list.size());
                }while (fourthButton == firstButton || fourthButton== secondButton || fourthButton == thirdButton);

                b_answer2.setText(list.get(secondButton).getName());
                b_answer1.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(fourthButton).getName());
                break;
            case 4:
                b_answer4.setText(list.get(firstButton).getName());

                do{
                    secondButton=r.nextInt(list.size());
                }while (secondButton == firstButton);
                do{
                    thirdButton=r.nextInt(list.size());
                }while (thirdButton == firstButton || thirdButton == secondButton);
                do{
                    fourthButton=r.nextInt(list.size());
                }while (fourthButton == firstButton || fourthButton== secondButton || fourthButton == thirdButton);

                b_answer2.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer1.setText(list.get(fourthButton).getName());
                break;
        }

    }
}

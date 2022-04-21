package com.example.is2011_igra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    Button buttonObjectChoice1;
    Button buttonObjectChoice2;
    Button buttonObjectChoice3;
    TextView textObjectPartA;
    TextView textObjectPartB;
    TextView textObjectScore;
    TextView textObjectLevel;
    int currentScore = 0;
    int currentLevel = 1;

    int partA = 9;
    int partB = 9;
    int correctAnswer = partA * partB;
    int wrongAnswer1 = correctAnswer - 1;
    int wrongAnswer2 = correctAnswer + 1;

    @Override
    protected void onStart() {
        super.onStart();
        textObjectPartA = (TextView)findViewById(R.id.num1);
        textObjectPartB = (TextView)findViewById(R.id.num2);
        textObjectScore = (TextView)findViewById(R.id.ScoreView);
        textObjectLevel = (TextView)findViewById(R.id.levelView);
        buttonObjectChoice1 = (Button)findViewById(R.id.answ1);
        buttonObjectChoice2 = (Button)findViewById(R.id.answ2);
        buttonObjectChoice3 = (Button)findViewById(R.id.answ3);
        buttonObjectChoice1.setOnClickListener(this);
        buttonObjectChoice2.setOnClickListener(this);
        buttonObjectChoice3.setOnClickListener(this);

        textObjectPartA.setText(""+partA);
        textObjectPartB.setText(""+partB);
        buttonObjectChoice1.setText("" + correctAnswer);
        buttonObjectChoice2.setText("" + wrongAnswer1);
        buttonObjectChoice3.setText("" + wrongAnswer2);
    }

    @Override
    public void onClick(View view) {
        //объявим новую переменную типа int, которую будем использовать
//        в каждом case
        int answerGiven = 0;
        switch (view.getId()) {
            case R.id.answ1:
//присваиваем переменной answerGiven значение, содержащееся
//                в buttonObjectChoice1
                answerGiven = Integer.parseInt("" +
                        buttonObjectChoice1.getText());
                break;
            case R.id.answ2:
//то же самое, что и предыдущий case, только используем
//                следующую кнопку
                answerGiven = Integer.parseInt("" +
                        buttonObjectChoice2.getText());
                break;
            case R.id.answ3:
//то же самое, что и предыдущий case, только используем
//                следующую кнопку
                answerGiven = Integer.parseInt("" +
                        buttonObjectChoice3.getText());
                break;
        }
        updateScoreAndLevel(answerGiven);
        setQuesion();

    }

    void setQuesion()
    {
        int numberRange = currentLevel*3;
        Random randInt = new Random();
        int num1 = randInt.nextInt(numberRange);
        num1++;
        int num2 = randInt.nextInt(numberRange);
        num2++;

        correctAnswer=num1*num2;
        int wrondAnswer1 = correctAnswer-2;
        int wrondAnswer2 = correctAnswer+2;
        textObjectPartA.setText(""+num1);
        textObjectPartB.setText(""+num2);

        int buttonLayout = randInt.nextInt(3);
        switch (buttonLayout)
        {
            case 0:
                buttonObjectChoice1.setText(""+correctAnswer);
                buttonObjectChoice2.setText(""+wrondAnswer1);
                buttonObjectChoice3.setText(""+wrondAnswer2);
                break;
            case 1:
                buttonObjectChoice1.setText(""+wrondAnswer1);
                buttonObjectChoice2.setText(""+correctAnswer);
                buttonObjectChoice3.setText(""+wrondAnswer2);
                break;
            case 2:
                buttonObjectChoice1.setText(""+wrondAnswer1);
                buttonObjectChoice2.setText(""+wrondAnswer2);
                buttonObjectChoice3.setText(""+correctAnswer);
                break;
        }
    }
    void updateScoreAndLevel(int answerGiven)
    {
        if(answerGiven==correctAnswer)
        {
            for (int i = 0; i <= currentLevel; i++) {
                currentScore+=i;
            }
            currentLevel++;

        }
        else {
            currentLevel=1;
            currentScore=0;

        }
        textObjectScore.setText("Score: "+currentScore);
        textObjectLevel.setText("Level: "+currentLevel);

    }
}



package com.example.android.flagsquiz;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView flagImage;
    Button answer1;
    Button answer2;
    Button answer3;
    Button answer4;
    String[][]answers;
    TextView pointDisplay;
    int points;
    int selectedAnswer;
    int[] images;
    int[] correctAnswers;
    int currQuestionID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flagImage = (ImageView)findViewById(R.id.FlagImage);
        answer1 = (Button)findViewById(R.id.answer1);
        answer2 = (Button)findViewById(R.id.answer2);
        answer3 = (Button)findViewById(R.id.answer3);
        answer4 = (Button)findViewById(R.id.answer4);
        pointDisplay = (TextView)findViewById(R.id.Points);
        answer1.setOnClickListener(answer1Click);
        answer2.setOnClickListener(answer2Click);
        answer3.setOnClickListener(answer3Click);
        answer4.setOnClickListener(answer4Click);
        answers = new String[][]{
                {"Germany", "Poland", "Ukraine", "France"},
                {"Ukraine", "France", "Germany", "Poland"},
                {"Poland", "Ukraine", "Germany", "France"}
        };
        correctAnswers = new int[]{ 1, 4, 2};
        images = new int[]{R.drawable.germany, R.drawable.poland, R.drawable.ukraine};
        currQuestionID = 1;
        points = 0;
        setQuestion(currQuestionID);
    }
    public void setQuestion(int questionID)
    {
        answer1.setText(answers[questionID-1][0]);
        answer2.setText(answers[questionID-1][1]);
        answer3.setText(answers[questionID-1][2]);
        answer4.setText(answers[questionID-1][3]);
        flagImage.setImageResource(images[questionID-1]);
    }

    private View.OnClickListener answer1Click = new View.OnClickListener() {
        public void onClick(View v) {
            selectedAnswer = 1;
            updatePoints(checkAnswer(selectedAnswer));
        }
    };
    private View.OnClickListener answer2Click = new View.OnClickListener() {
        public void onClick(View v) {
            selectedAnswer = 2;
            updatePoints(checkAnswer(selectedAnswer));
        }
    };
    private View.OnClickListener answer3Click = new View.OnClickListener() {
        public void onClick(View v) {
            selectedAnswer = 3;
            updatePoints(checkAnswer(selectedAnswer));
        }
    };
    private View.OnClickListener answer4Click = new View.OnClickListener() {
        public void onClick(View v) {
            selectedAnswer = 4;
            updatePoints(checkAnswer(selectedAnswer));
        }
    };
    private boolean checkAnswer(int answerID){
        if(answerID == correctAnswers[currQuestionID-1])
            return true;
        return false;
    }
    private void updatePoints(boolean questionResult){
        if (questionResult)
            points++;
        pointDisplay.setText("Score : " + points);
        if(currQuestionID != 3)
            currQuestionID++;
        else
            currQuestionID = 1;
        setQuestion(currQuestionID);
    }
}
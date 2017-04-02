package com.example.android.flagsquiz;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView flagImage;
    Button answer1;
    Button answer2;
    Button answer3;
    Button answer4;
    String[][]answers;
    int[] images;
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
        answers = new String[][]{
                {"Germany", "Poland", "Ukraine", "France"},
                {"Ukraine", "France", "Germany", "Poland"},
                {"Poland", "Ukraine", "Germany", "France"}
        };
        images = new int[]{R.drawable.germany, R.drawable.poland, R.drawable.ukraine};
        setQuestion(1);
    }
    public void setQuestion(int questionID)
    {
        answer1.setText(answers[questionID-1][0]);
        answer2.setText(answers[questionID-1][1]);
        answer3.setText(answers[questionID-1][2]);
        answer4.setText(answers[questionID-1][3]);
        flagImage.setImageResource(images[questionID-1]);
    }
}
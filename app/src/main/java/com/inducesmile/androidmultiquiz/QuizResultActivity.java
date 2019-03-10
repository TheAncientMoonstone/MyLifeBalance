package com.inducesmile.androidmultiquiz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        setTitle(getString(R.string.quiz_result));

       final String resultString = getIntent().getExtras().getString("RESULT_OBJECT");
        String userScore = getIntent().getExtras().getString("TOTAL_SCORE");

        double passResult = Double.parseDouble(userScore);
        int userPassMark = new Double(passResult).intValue();

        TextView userPassScore = (TextView)findViewById(R.id.textView6);
       //TextView userFailedScore = (TextView)findViewById(R.id.fail);

        int PassScore = 100 - userPassMark;
        if (PassScore >=15)
        {
        userPassScore.setText(String.valueOf(userPassMark) +" % answer correct"+" .You are in Level Two"+ " You often find" +
                " life confusing. You feel out of control. Change is difficult for you," +
                        " but you tend to be in the level 3 zone and that frustrates you");}
        else{
            userPassScore.setText(String.valueOf(userPassMark)  +" % answer correct"+"You are in Level One"+
                    "You feel " +
                            "confused most of the time. You view life as a disappointment so far and " +
                            "you allow the forces outside of yourself to" +
                            " dominate you. This is what we refer to as Level 3 living.");}

        Button retakeQuizButton = (Button)findViewById(R.id.retake_quiz);
        assert retakeQuizButton != null;
        retakeQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retakeQuizIntent = new Intent(QuizResultActivity.this, QuizCategoryActivity.class);
                startActivity(retakeQuizIntent);
            }
        });

        Button viewQuizResultButton = (Button)findViewById(R.id.view_result);
        assert viewQuizResultButton != null;
        viewQuizResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent(QuizResultActivity.this, ResultAnalysisActivity.class);
                resultIntent.putExtra("RESULT", resultString);
                startActivity(resultIntent);
            }
        });

    }

    @Override
    public void onBackPressed() {
    }
}

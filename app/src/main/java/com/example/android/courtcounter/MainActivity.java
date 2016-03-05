package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int teamAScore = 0;
    int teamBScore = 0;

    TextView scoreAView;
    TextView scoreBView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreAView = (TextView)findViewById( R.id.team_a_score_text_view );
        scoreBView = (TextView)findViewById( R.id.team_b_score_text_view );

        //start scores
        showScore(scoreAView, teamAScore);
        showScore(scoreBView , teamBScore);
    }


    protected void showScore(TextView scoreView, int score){
        scoreView.setText(Integer.toString(score));
    }

    public void incrementScore(View view) {
        String btnTag = (String)view.getTag();
        String[] parts = btnTag.split(":");

        String team = (String)parts[0].trim();
        int increment = Integer.parseInt( parts[1].trim() );

        if( team.equals("a") ){
            teamAScore+=increment;
            showScore(scoreAView, teamAScore);
        }else{
            teamBScore+=increment;
            showScore(scoreBView, teamBScore);
        }
    }

    public void restartScore(View view) {
        teamAScore = 0;
        teamBScore = 0;
        showScore(scoreAView, teamAScore);
        showScore(scoreBView , teamBScore);
    }
}

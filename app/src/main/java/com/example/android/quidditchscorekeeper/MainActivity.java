package com.example.android.quidditchscorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Increases the score for Team A by 150 and ends the game
     */
    public void snitchForTeamA(View view) {
        scoreTeamA = scoreTeamA + 150;
        displayForTeamA(scoreTeamA);
        displayWinner();
        endGame();
    }

    /**
     * Increases the score for Team A by ten
     */
    public void addTenForTeamA(View view) {
        scoreTeamA = scoreTeamA + 10;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increases the score for Team B by 150 and ends the game
     */
    public void snitchForTeamB(View view) {
        scoreTeamB = scoreTeamB + 150;
        displayForTeamB(scoreTeamB);
        displayWinner();
        endGame();
    }

    /**
     * Increases the score for Team B by ten
     */
    public void addTenForTeamB(View view) {
        scoreTeamB = scoreTeamB + 10;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayWinner() {
        TextView winnerView = (TextView) findViewById(R.id.winner);
        if (scoreTeamA > scoreTeamB) {
            winnerView.setText(R.string.gryffindor_wins);
        } else {
            winnerView.setText(R.string.slytherin_wins);
        }
    }

    public void endGame() {
        ImageButton snitchButtonA = (ImageButton) this.findViewById(R.id.snitchA);
        ImageButton snitchButtonB = (ImageButton) this.findViewById(R.id.snitchB);
        Button pointsButtonA = (Button) this.findViewById(R.id.pointsA);
        Button pointsButtonB = (Button) this.findViewById(R.id.pointsB);
        snitchButtonA.setEnabled(false);
        snitchButtonB.setEnabled(false);
        pointsButtonA.setEnabled(false);
        pointsButtonB.setEnabled(false);

    }

    public void resetWinner() {
        TextView winnerView = (TextView) findViewById(R.id.winner);
        winnerView.setText("");
    }

    public void reset(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        resetWinner();
        ImageButton snitchButtonA = (ImageButton) this.findViewById(R.id.snitchA);
        ImageButton snitchButtonB = (ImageButton) this.findViewById(R.id.snitchB);
        Button pointsButtonA = (Button) this.findViewById(R.id.pointsA);
        Button pointsButtonB = (Button) this.findViewById(R.id.pointsB);
        snitchButtonA.setEnabled(true);
        snitchButtonB.setEnabled(true);
        pointsButtonA.setEnabled(true);
        pointsButtonB.setEnabled(true);
    }
}

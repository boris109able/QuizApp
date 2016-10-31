package com.example.android.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int[] standardAnswer = {3, 1, 4, 3, 4};
    int[] userAnswer = {0, 0, 0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickForFirstQuestion(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.jupiter:
                if (checked)
                    userAnswer[0] = 1;
                break;
            case R.id.venus:
                if (checked)
                    userAnswer[0] = 2;
                break;
            case R.id.mars:
                if (checked)
                    userAnswer[0] = 3;
                break;
            case R.id.mercury:
                if (checked)
                    userAnswer[0] = 4;
                break;
        }
        //Log.v("First answer input: ", ""+userAnswer[0]);
    }

    public void clickForSecondQuestion(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.catAbuser:
                if (checked)
                    userAnswer[1] = 1;
                break;
            case R.id.snakeAbuser:
                if (checked)
                    userAnswer[1] = 2;
                break;
            case R.id.dogAbuser:
                if (checked)
                    userAnswer[1] = 3;
                break;
            case R.id.rabbitAbuser:
                if (checked)
                    userAnswer[1] = 4;
                break;
        }
        //Log.v("Second answer input: ", ""+userAnswer[1]);
    }

    public void clickForThirdQuestion(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.dist1:
                if (checked)
                    userAnswer[2] = 1;
                break;
            case R.id.dist2:
                if (checked)
                    userAnswer[2] = 2;
                break;
            case R.id.dist3:
                if (checked)
                    userAnswer[2] = 3;
                break;
            case R.id.dist4:
                if (checked)
                    userAnswer[2] = 4;
                break;
        }
        //Log.v("Third answer input: ", ""+userAnswer[2]);
    }

    public void clickForFourthQuestion(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.newton:
                if (checked)
                    userAnswer[3] = 1;
                break;
            case R.id.faraday:
                if (checked)
                    userAnswer[3] = 2;
                break;
            case R.id.lenz:
                if (checked)
                    userAnswer[3] = 3;
                break;
            case R.id.ampere:
                if (checked)
                    userAnswer[3] = 4;
                break;
        }
        //Log.v("Fourth answer input: ", ""+userAnswer[3]);
    }

    public void clickForFifthQuestion(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.quantum:
                if (checked)
                    userAnswer[4] = 1;
                break;
            case R.id.electro:
                if (checked)
                    userAnswer[4] = 2;
                break;
            case R.id.mechanic:
                if (checked)
                    userAnswer[4] = 3;
                break;
            case R.id.heat:
                if (checked)
                    userAnswer[4] = 4;
                break;
        }
        //Log.v("Fifth answer input: ", ""+userAnswer[4]);
    }

    public void submitAnswer(View view) {
        String[] s = new String[5];
        s[0] = "Olympus Mons is three times the height of Mount Everest and is located on Mars.";
        s[1] = "Schrödinger won himself the nickname \"Cat Abuser\" by his famous thought experiment \"Schrödinger's cat\".";
        s[2] = "The distance between the Earth Planet and the Moon is 384,400km.";
        s[3] = "This is the famous Len's Law. The Lenz's Law is proposed by Russian scientist Heinrich Lenz in 1834.";
        s[4] = "Fourier introduced the series for the purpose of solving the heat equation in a metal plate in 1807.";
        String result = new String();
        int count = 0;
        for (int i = 0; i < standardAnswer.length; i++) {
            if (standardAnswer[i] == userAnswer[i]) {
                result += "Question " + (i + 1) + " : Correct! \n";
                count++;
            }
            else {
                result += "Question " + (i + 1) + " : Wrong! \n";
            }
            result += s[i];
            result += "\n\n";
        }

        CheckBox cb1 = (CheckBox) findViewById(R.id.galois);
        CheckBox cb2 = (CheckBox) findViewById(R.id.turing);
        CheckBox cb3 = (CheckBox) findViewById(R.id.abel);
        CheckBox cb4 = (CheckBox) findViewById(R.id.archimedes);
        if (cb1.isChecked() && cb2.isChecked() && !cb3.isChecked() && cb4.isChecked()) {
            result += "Question 6: Correct! \n";
            count++;
        }
        else {
            result += "Question 6: Wrong! \n";
        }
        result += "Évariste Galois was a French mathematician who died at age 20 from wounds suffered in a duel.\n";
        result += "Alan Turing died in 1954, 16 days before his 42nd birthday, from cyanide poisoning.\n";
        result += "Niels Henrik Abel was a Norwegian mathematician who died at age 26 due to tuberculosis.\n";
        result += "Archimedes was killed by a Roman soldier. The last words attributed to Archimedes are \"Do not disturb my circles\".\n";

        result = "Your score is " + count + "(out of 6).\n\n" + result;
        TextView v = (TextView) findViewById(R.id.standardAnswer);
        v.setText(result);
    }

    public void composeEmail(View view) {
        String subject = "Science quiz results of ";
        EditText et = (EditText) findViewById(R.id.userName);
        subject += et.getText().toString();
        TextView v = (TextView) findViewById(R.id.standardAnswer);
        String textBody = v.getText().toString();
        Log.v("standard answer: ", textBody);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, textBody);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}

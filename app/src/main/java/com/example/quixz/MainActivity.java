package com.example.quixz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

class Question{
    private final String que;
    private final boolean ans;

    public Question(String que, boolean ans) {
        this.que = que;
        this.ans = ans;
    }
    public String getQue() {
        return que;
    }

    public boolean getAns() {
        return ans;
    }
}
public class MainActivity extends AppCompatActivity {
    ArrayList<Question> questionList;
    Button a,b;
    TextView questionDisplay,scoreDisplay;
    int index = 0;
    int currentScore = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionList = new ArrayList<>();
        questionDisplay = findViewById(R.id.question);
        scoreDisplay = findViewById(R.id.score_display);
        fillList(questionList);
        questionDisplay.setText(questionList.get(index).getQue());
    }
    public void click(View view){
        if(index < questionList.size()-1){
            Button button = (Button)view;
            //experimental
            String input = button.getText().toString();
            String answer = questionList.get(index).getAns()? "true": "false";
            if(input.equals(answer)) currentScore++;
            if(index < questionList.size()-1)nextQuestion();
            updateScore();
        }
        else{
            Toast.makeText(this, "questions over", Toast.LENGTH_SHORT).show();
        }
    }

    private void nextQuestion() {
        index++;
        questionDisplay.setText(questionList.get(index).getQue());
    }
    private void updateScore() {
        String temp = currentScore + "";
        scoreDisplay.setText(temp);
    }

    private void fillList(ArrayList<Question> questionList) {
        questionList.add(new Question("question number 0",true));
        questionList.add(new Question("question number 1",false));
        questionList.add(new Question("question number 2",true));
        questionList.add(new Question("question number 3",false));
        questionList.add(new Question("question number 4",true));
        questionList.add(new Question("question number 5",false));
        questionList.add(new Question("question number 6",true));
        questionList.add(new Question("question number 7",false));
        questionList.add(new Question("question number 8",false));
        questionList.add(new Question("question number 9",true));
    }
}
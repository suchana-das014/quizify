package com.example.quzifyapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PlayActivity extends AppCompatActivity {

    TextView cpt_question, text_question;
    Button btn_choose1, btn_choose2, btn_choose3, btn_choose4, btn_next;

    String[] questions = {
            "What is the capital of France?",
            "Which planet is known as the Red Planet?",
            "What is the largest ocean on Earth?",
            "Who wrote 'Romeo and Juliet'?",
            "What is the smallest prime number?",
            "What gas do plants absorb?",
            "Which country hosted the 2016 Summer Olympics?",
            "What is H2O commonly known as?",
            "Which animal is known as the king of the jungle?",
            "What is the hardest natural substance?"
    };

    String[][] options = {
            {"Paris", "London", "Rome", "Berlin"},
            {"Venus", "Mars", "Jupiter", "Saturn"},
            {"Indian", "Pacific", "Atlantic", "Arctic"},
            {"Shakespeare", "Dickens", "Twain", "Hemingway"},
            {"0", "1", "2", "3"},
            {"Oxygen", "Carbon", "Hydrogen", "Carbon Dioxide"},
            {"Brazil", "China", "UK", "Russia"},
            {"Salt", "Oxygen", "Water", "Sugar"},
            {"Elephant", "Tiger", "Lion", "Bear"},
            {"Gold", "Diamond", "Iron", "Steel"}
    };

    int currentQuestion = 0;
    int totalQuestions = questions.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        // Bind views
        cpt_question = findViewById(R.id.cpt_question);
        text_question = findViewById(R.id.text_question);
        btn_choose1 = findViewById(R.id.btn_choose1);
        btn_choose2 = findViewById(R.id.btn_choose2);
        btn_choose3 = findViewById(R.id.btn_choose3);
        btn_choose4 = findViewById(R.id.btn_choose4);
        btn_next = findViewById(R.id.btn_next);

        // Load first question
        loadQuestion();

        // Next button logic
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentQuestion++;
                if (currentQuestion < totalQuestions) {
                    loadQuestion();
                } else {
                    Toast.makeText(PlayActivity.this, "Quiz Finished!", Toast.LENGTH_SHORT).show();
                    finish(); // or open result screen
                }
            }
        });
    }

    private void loadQuestion() {
        cpt_question.setText((currentQuestion + 1) + "/" + totalQuestions);
        text_question.setText(questions[currentQuestion]);

        btn_choose1.setText(options[currentQuestion][0]);
        btn_choose2.setText(options[currentQuestion][1]);
        btn_choose3.setText(options[currentQuestion][2]);
        btn_choose4.setText(options[currentQuestion][3]);
    }
}

package com.example.quzifyapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PlayActivity extends AppCompatActivity {

    private TextView cpt_question, text_question;
    private Button btn_choose1, btn_choose2, btn_choose3, btn_choose4, btn_next;

    private String[] questions = {
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

    private String[][] options = {
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

    // Correct answers index for each question (0-based)
    private int[] correctAnswers = {0, 1, 1, 0, 2, 3, 0, 2, 2, 1};

    private int currentQuestion = 0;
    private int selectedOption = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        cpt_question = findViewById(R.id.cpt_question);
        text_question = findViewById(R.id.text_question);
        btn_choose1 = findViewById(R.id.btn_choose1);
        btn_choose2 = findViewById(R.id.btn_choose2);
        btn_choose3 = findViewById(R.id.btn_choose3);
        btn_choose4 = findViewById(R.id.btn_choose4);
        btn_next = findViewById(R.id.btn_next);

        loadQuestion();

        View.OnClickListener optionListener = v -> {
            resetOptionColors();
            selectedOption = -1;

            Button clicked = (Button) v;
            clicked.setBackgroundColor(Color.parseColor("#FFC107")); // yellow highlight

            int id = clicked.getId();
            if (id == R.id.btn_choose1) {
                selectedOption = 0;
            } else if (id == R.id.btn_choose2) {
                selectedOption = 1;
            } else if (id == R.id.btn_choose3) {
                selectedOption = 2;
            } else if (id == R.id.btn_choose4) {
                selectedOption = 3;
            }
        };

        btn_choose1.setOnClickListener(optionListener);
        btn_choose2.setOnClickListener(optionListener);
        btn_choose3.setOnClickListener(optionListener);
        btn_choose4.setOnClickListener(optionListener);

        btn_next.setOnClickListener(v -> {
            if (selectedOption == -1) {
                Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show();
                return;
            }

            if (selectedOption == correctAnswers[currentQuestion]) {
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
            }

            currentQuestion++;

            if (currentQuestion < questions.length) {
                loadQuestion();
                resetOptionColors();
                selectedOption = -1;
            } else {
                Toast.makeText(this, "Quiz Finished!", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

    private void loadQuestion() {
        cpt_question.setText((currentQuestion + 1) + "/" + questions.length);
        text_question.setText(questions[currentQuestion]);

        btn_choose1.setText(options[currentQuestion][0]);
        btn_choose2.setText(options[currentQuestion][1]);
        btn_choose3.setText(options[currentQuestion][2]);
        btn_choose4.setText(options[currentQuestion][3]);
    }

    private void resetOptionColors() {
        int defaultColor = getResources().getColor(R.color.primary_color);
        btn_choose1.setBackgroundColor(defaultColor);
        btn_choose2.setBackgroundColor(defaultColor);
        btn_choose3.setBackgroundColor(defaultColor);
        btn_choose4.setBackgroundColor(defaultColor);
    }
}

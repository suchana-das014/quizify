package com.example.quzifyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    // Declare buttons
    private Button play;
    private Button setting;
    private Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second); // Link to the layout file

        // Bind buttons to their IDs
        play = findViewById(R.id.buttonPlay);
        setting = findViewById(R.id.buttonSettings);
        exit = findViewById(R.id.buttonExit);

        // Set click listeners

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Action for "Play" button
                Toast.makeText(SecondActivity.this, "Play clicked", Toast.LENGTH_SHORT).show();

                // Example: Navigate to QuizActivity (uncomment if you have it)
                // Intent intent = new Intent(SecondActivity.this, QuizActivity.class);
                // startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Action for "Settings" button
                Toast.makeText(SecondActivity.this, "Settings clicked", Toast.LENGTH_SHORT).show();

                // Example: Navigate to SettingsActivity (if created)
                // Intent intent = new Intent(SecondActivity.this, SettingsActivity.class);
                // startActivity(intent);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Exit the app gracefully
                finishAffinity();  // Finishes all activities
            }
        });
    }
}
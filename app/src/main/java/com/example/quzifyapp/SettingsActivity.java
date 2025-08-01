package com.example.quzifyapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private Switch switchSound, switchDarkMode;
    private Button buttonAddQuestion, buttonResetScore, buttonAbout, buttonBack;

    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "quizify_prefs";
    private static final String SOUND_KEY = "sound_enabled";
    private static final String DARK_MODE_KEY = "dark_mode_enabled";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Bind views
        switchSound = findViewById(R.id.switchSound);
        switchDarkMode = findViewById(R.id.switchDarkMode);
        buttonAddQuestion = findViewById(R.id.buttonAddQuestion);
        buttonResetScore = findViewById(R.id.buttonResetScore);
        buttonAbout = findViewById(R.id.buttonAbout);
        buttonBack = findViewById(R.id.buttonBack);

        // Load preferences
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        switchSound.setChecked(sharedPreferences.getBoolean(SOUND_KEY, true));
        switchDarkMode.setChecked(sharedPreferences.getBoolean(DARK_MODE_KEY, false));

        // Switch listeners
        switchSound.setOnCheckedChangeListener((buttonView, isChecked) -> {
            sharedPreferences.edit().putBoolean(SOUND_KEY, isChecked).apply();
            Toast.makeText(this, isChecked ? "Sound Enabled" : "Sound Disabled", Toast.LENGTH_SHORT).show();
        });

        switchDarkMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            sharedPreferences.edit().putBoolean(DARK_MODE_KEY, isChecked).apply();
            Toast.makeText(this, isChecked ? "Dark Mode Enabled" : "Dark Mode Disabled", Toast.LENGTH_SHORT).show();
            // Optional: implement actual theme switching logic here
        });

        // Button click listeners
        buttonAddQuestion.setOnClickListener(v -> {
            Toast.makeText(this, "Add Question clicked (implement your logic)", Toast.LENGTH_SHORT).show();
            // TODO: Navigate to Add Question screen or show dialog
        });

        buttonResetScore.setOnClickListener(v -> {
            Toast.makeText(this, "Score reset (implement your logic)", Toast.LENGTH_SHORT).show();
            // TODO: Reset score logic here
        });

        buttonAbout.setOnClickListener(v -> {
            Toast.makeText(this, "About Quizify clicked", Toast.LENGTH_SHORT).show();
            // TODO: Show about info dialog or activity
        });

        buttonBack.setOnClickListener(v -> finish());  // Go back to previous screen
    }
}

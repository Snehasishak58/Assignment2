package com.example.app1;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxFavorite;
    private RadioGroup radioGroupGenre;
    private RatingBar ratingBar;
    private SeekBar seekBarDifficulty;
    private TextView textDifficultyLevel;
    private Switch switchNotifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        checkBoxFavorite = findViewById(R.id.checkbox_favorite);
        radioGroupGenre = findViewById(R.id.radioGroup);
        ratingBar = findViewById(R.id.rating_bar);
        seekBarDifficulty = findViewById(R.id.seekBar_difficulty);
        textDifficultyLevel = findViewById(R.id.text_difficulty_level);
        switchNotifications = findViewById(R.id.switch_notifications);

        // Handle CheckBox state
        checkBoxFavorite.setOnClickListener(v -> {
            if (checkBoxFavorite.isChecked()) {
                Toast.makeText(MainActivity.this, "Marked as Favorite", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Unmarked as Favorite", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle RadioGroup for selecting genre
        radioGroupGenre.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedRadioButton = findViewById(checkedId);
            String selectedGenre = selectedRadioButton.getText().toString();
            Toast.makeText(MainActivity.this, "Selected Genre: " + selectedGenre, Toast.LENGTH_SHORT).show();
        });

        // Handle RatingBar for rating
        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) ->
                Toast.makeText(MainActivity.this, "Rated: " + rating + " stars", Toast.LENGTH_SHORT).show()
        );

        // Handle SeekBar for difficulty level
        seekBarDifficulty.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textDifficultyLevel.setText("Difficulty: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // No action needed here
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Difficulty set to " + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
            }
        });

        // Handle Switch for notifications
        switchNotifications.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(MainActivity.this, "Notifications Enabled", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Notifications Disabled", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

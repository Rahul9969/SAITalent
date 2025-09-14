package com.sai.talentassessment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.sai.talentassessment.test.TestListActivity;

/**
 * The main entry screen of the application.
 * This activity would typically handle user login/registration and then
 * navigate to the main functional part of the app.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // This would inflate a layout file, e.g., R.layout.activity_main
        // For simplicity, we create UI programmatically.
        // setContentView(R.layout.activity_main);

        Button startButton = new Button(this);
        startButton.setText("Start Assessment");
        setContentView(startButton);

        // In a real app, you would have login fields and logic here.
        // After successful login, you would get an athlete ID.
        final String athleteId = "ATHLETE_12345"; // Dummy ID

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestListActivity.class);
                intent.putExtra("ATHLETE_ID", athleteId);
                startActivity(intent);
            }
        });
    }
}
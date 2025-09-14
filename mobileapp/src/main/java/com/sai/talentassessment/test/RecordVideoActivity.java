package com.sai.talentassessment.test;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.sai.talentassessment.ai.PerformanceAnalyzer;
import com.sai.talentassessment.ai.AnalysisResult;

/**
 * This activity handles the video recording and triggers the on-device AI analysis.
 */
public class RecordVideoActivity extends AppCompatActivity {

    private String testName;
    private String athleteId;
    private PerformanceAnalyzer performanceAnalyzer;

    private TextView statusText;
    private ProgressBar progressBar;
    private Button recordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_record_video);

        testName = getIntent().getStringExtra("TEST_NAME");
        athleteId = getIntent().getStringExtra("ATHLETE_ID");
        performanceAnalyzer = new PerformanceAnalyzer();

        // statusText = findViewById(R.id.text_status);
        // progressBar = findViewById(R.id.progress_bar);
        // recordButton = findViewById(R.id.button_record);
        
        // Dummy UI for demonstration
        statusText = new TextView(this);
        recordButton = new Button(this);
        recordButton.setText("Start Recording");
        setContentView(recordButton);

        recordButton.setOnClickListener(v -> {
            startRecordingAndAnalysis();
        });
    }

    private void startRecordingAndAnalysis() {
        // Step 1: In a real app, open the camera using CameraX or another API
        // and record a video, saving the file path.
        Uri dummyVideoUri = Uri.parse("file:///sdcard/dummy_video.mp4");
        
        statusText.setText("Analyzing video...");
        // progressBar.setVisibility(View.VISIBLE);
        recordButton.setEnabled(false);

        // Step 2: Start the AI analysis on a background thread.
        new Thread(() -> {
            // This simulates a long-running analysis process.
            AnalysisResult result = performanceAnalyzer.analyzeVideo(dummyVideoUri, testName);

            // Step 3: Switch back to the UI thread to show results
            // and trigger data submission.
            new Handler(Looper.getMainLooper()).post(() -> {
                // progressBar.setVisibility(View.GONE);
                statusText.setText("Analysis Complete!");
                showResultsAndSubmit(result);
            });
        }).start();
    }

    private void showResultsAndSubmit(AnalysisResult result) {
        // Here you would navigate to a results activity and then
        // start a background service to upload the data and video.
        System.out.println("Test: " + testName + ", Athlete: " + athleteId);
        System.out.println("Result: " + result.getValue() + " " + result.getUnit());
        System.out.println("Anomalies Found: " + result.hasAnomalies());

        // TODO: Start a service to upload the result and video file to the backend.
    }
}
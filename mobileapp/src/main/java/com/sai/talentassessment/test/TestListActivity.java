package com.sai.talentassessment.test;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sai.talentassessment.data.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * This activity displays the list of available fitness assessment tests
 * for the athlete to perform.
 */
public class TestListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_test_list);

        RecyclerView recyclerView = new RecyclerView(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setContentView(recyclerView);

        List<Test> testList = getStandardTests();
        String athleteId = getIntent().getStringExtra("ATHLETE_ID");

        TestListAdapter adapter = new TestListAdapter(this, testList, athleteId);
        recyclerView.setAdapter(adapter);
    }

    /**
     * Creates the list of standard fitness tests as per requirements.
     * @return A list of Test objects.
     */
    private List<Test> getStandardTests() {
        List<Test> tests = new ArrayList<>();
        tests.add(new Test("Vertical Jump", "Measures lower body power.", "Stand and jump as high as you can. Record from the side."));
        tests.add(new Test("Shuttle Run", "Measures agility and speed.", "Run between two markers. Record the entire run."));
        tests.add(new Test("Sit-ups (1 Minute)", "Measures core strength.", "Perform as many sit-ups as possible in 60 seconds."));
        tests.add(new Test("Endurance Run", "Measures cardiovascular fitness.", "Record your run over the specified distance."));
        // Add other tests like height, weight (could be manual input)
        return tests;
    }

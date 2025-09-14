package com.sai.talentassessment.test;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.sai.talentassessment.data.Test;

import java.util.List;

/**
 * Adapter for the RecyclerView in TestListActivity to display each test.
 */
public class TestListAdapter extends RecyclerView.Adapter<TestListAdapter.TestViewHolder> {

    private final List<Test> testList;
    private final Context context;
    private final String athleteId;

    public TestListAdapter(Context context, List<Test> testList, String athleteId) {
        this.context = context;
        this.testList = testList;
        this.athleteId = athleteId;
    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // View view = LayoutInflater.from(context).inflate(R.layout.item_test, parent, false);
        // return new TestViewHolder(view);
        // Programmatic view creation for simplicity
        return new TestViewHolder(new TextView(context)); // Simplified
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {
        Test currentTest = testList.get(position);
        // holder.testName.setText(currentTest.getName());
        // holder.testDescription.setText(currentTest.getDescription());
        ((TextView) holder.itemView).setText(currentTest.getName()); // Simplified

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, RecordVideoActivity.class);
            intent.putExtra("TEST_NAME", currentTest.getName());
            intent.putExtra("ATHLETE_ID", athleteId);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return testList.size();
    }

    /**
     * ViewHolder class to hold the UI elements for a single test item.
     */
    static class TestViewHolder extends RecyclerView.ViewHolder {
        // TextView testName;
        // TextView testDescription;
        // Button startTestButton;

        public TestViewHolder(@NonNull View itemView) {
            super(itemView);
            // testName = itemView.findViewById(R.id.text_test_name);
            // testDescription = itemView.findViewById(R.id.text_test_description);
            // startTestButton = itemView.findViewById(R.id.button_start_test);
        }
    }
}
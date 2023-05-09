package com.probaldas.nycSchools.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.probaldas.nycSchools.R;
import com.probaldas.nycSchools.ui.school.SchoolListViewModel;
import com.probaldas.nycSchools.ui.school.adapter.SchoolListPagedAdapter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private SchoolListViewModel mViewModel;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        mViewModel = ViewModelProviders.of(this).get(SchoolListViewModel.class);

        // Setup recycler view
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        getDataFromServer();
    }

    private void getDataFromServer() {
        // Instantiate PagedAdapter
        final SchoolListPagedAdapter adapter = new SchoolListPagedAdapter(this);

        mViewModel.getSchoolDetailsList().observe(this, schoolDetails -> {
            Log.i(TAG, "onChanged called and list size is: " + schoolDetails.size() + ".");
            adapter.submitList(schoolDetails);
        });

        recyclerView.setAdapter(adapter);
    }
}
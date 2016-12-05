package com.example.user.sqliteexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class Main2Activity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {
    ListView listViewRecords;
    UserDataSource userDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewRecords = (ListView) findViewById(R.id.listViewRecords);
        listViewRecords.setOnItemSelectedListener(this);
    }

    public void addRecord(View v) {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        updateList();
        super.onResume();
    }

    private void updateList() {
        //Retrieve	records	from	SQLite
        userDataSource = new UserDataSource(this);
        userDataSource.open();
        final List<UserRecord> values = userDataSource.getAllUsers();
        UserRecordAdapter adapter = new UserRecordAdapter(this,
                R.layout.user_record, values);
        //Link	adapter	to	ListView
        listViewRecords.setAdapter(adapter);
    }

    protected void onPause() {
        userDataSource.close();
        super.onPause();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
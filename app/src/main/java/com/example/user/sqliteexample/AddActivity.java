package com.example.user.sqliteexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void saveRecord(View v) {
        EditText editTextName, editTextEmail;
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        UserRecord userRecord = new UserRecord();
        userRecord.setName(editTextName.getText().toString());
        userRecord.setEmail(editTextEmail.getText().toString());
        UserDataSource userDataSource = new UserDataSource(this);
        userDataSource.insertUser(userRecord);
        this.finish();    //Terminate	this	Activity
    }
}
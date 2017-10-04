package com.example.admin.writetoexternal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etWrite;
    private TextView tvRead, tvState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWrite = (EditText) findViewById(R.id.etWrite);
        tvRead = (TextView) findViewById(R.id.tvRead);
        tvState = (TextView) findViewById(R.id.tvState);

    }

    public void usingExternalStorage(View view) {

        switch (view.getId()){

            case R.id.btnSave:
                MyAysncTask myAysncTask = new MyAysncTask(tvState, etWrite.getText().toString());
                myAysncTask.execute();

                break;
            case R.id.btnLoad:
                MyAsyncTaskRetrieve myAsyncTaskRetrieve = new MyAsyncTaskRetrieve(tvState, tvRead);
                myAsyncTaskRetrieve.execute();
                break;
        }
    }
}

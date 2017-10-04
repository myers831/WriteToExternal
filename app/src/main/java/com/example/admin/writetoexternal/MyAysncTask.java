package com.example.admin.writetoexternal;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.content.ContentValues.TAG;

/**
 * Created by Admin on 10/3/2017.
 */

public class MyAysncTask extends AsyncTask<String, String, String> {

    String writeData;
    TextView textView;

    public MyAysncTask(TextView textview, String writeData) {
        this.writeData = writeData;
        this.textView = textview;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        textView.setText("Writing Setup");

    }

    @Override
    protected String doInBackground(String... params) {
        publishProgress("Writing");

        int len = writeData.length();
        if (len == 0) {
            return "Please write data in text field";
        } else {
            try {
                publishProgress("Writing to file");
                File myFile = new File("/sdcard/","ClassProject");
                myFile.createNewFile();
                FileOutputStream fos = new FileOutputStream(myFile);
                fos.write(writeData.getBytes());
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "File Saved";
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        textView.setText(values[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        textView.setText(s);
    }
}

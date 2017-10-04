package com.example.admin.writetoexternal;

import android.os.AsyncTask;
import android.os.Environment;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Admin on 10/3/2017.
 */

public class MyAsyncTaskRetrieve extends AsyncTask<String, String, String> {

    TextView textView, textView2;
    String readData;

    public MyAsyncTaskRetrieve(TextView textView, TextView textView2) {
        this.textView = textView;
        this.textView2 = textView2;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        textView.setText("Reading Setup");
    }

    @Override
    protected String doInBackground(String... params) {

        try {
            publishProgress("Reading Data");
            File myFile = new File("/sdcard/","ClassProject");
            FileInputStream fis = new FileInputStream(myFile);
            byte[] dataArray = new byte[fis.available()];

            while (fis.read(dataArray) != -1) {
                readData = new String(dataArray);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return readData;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        textView.setText(values[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        textView2.setText(s);
    }
}

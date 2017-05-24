package com.fallingstar.lab6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    /*
     Define variables
     */
    EditText myTxt;
    Button saveBtn, loadBtn, clearBtn, finishBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         Init GUI variables
         */
        myTxt = (EditText) findViewById(R.id.myTxt);
        saveBtn = (Button)findViewById(R.id.SaveBtn);
        loadBtn = (Button)findViewById(R.id.LoadBtn);
        clearBtn = (Button)findViewById(R.id.ClearBtn);
        finishBtn = (Button)findViewById(R.id.FinishBtn);

        initWidgets();
    }

    /*
     purpose : Init listener for widgets
    */
    private void initWidgets() {
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveText();
            }
        });
        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadText();
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearText();
            }
        });
        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doFinish();
            }
        });
    }

    /*
     purpose : Save current EditText's text to file,
            in SD card(External storage) with write-append mode.
    */
    private void saveText(){
        try{
            File dir = getExternalFilesDir("Myfiles");
            File sdCard = new File(dir, "data.txt");
            dir.mkdirs();
            if (!sdCard.exists()){ //If file doesn't exists
                //Create success
                sdCard.createNewFile();
            }

            FileOutputStream fOut = new FileOutputStream(sdCard, true);

            fOut.write(myTxt.getText().toString().getBytes());
            fOut.close();

            Toast toast = Toast.makeText(MainActivity.this, "Done save text to SD File", Toast.LENGTH_SHORT);
            toast.show();
        }catch (Exception e){
            Log.e("EXCP", e.getLocalizedMessage());
        }

    }
    /*
    purpose : Load text data that saved early, show it to the EditText
     */
    private void loadText(){
        try{
            File sdCard = new File(getExternalFilesDir("Myfiles"), "data.txt");

            FileInputStream fIn = new FileInputStream(sdCard);
            InputStreamReader isw = new InputStreamReader(fIn);

            byte[] data = new byte[fIn.available()];
            while (fIn.read(data) != -1){
                //Read until data is done.
            }
            myTxt.setText(new String(data));
            fIn.close();

            Toast toast = Toast.makeText(MainActivity.this, "Done reading text from SD File", Toast.LENGTH_SHORT);
            toast.show();
        }catch (Exception e){
            Log.e("EXCP", e.getLocalizedMessage());
        }
    }
    /*
    purpose : Clear all of text that already typed in EditText
     */
    private void clearText(){
        myTxt.setText("");
    }

    /*
    purpose : Finish(Close) current activity(application)
     */
    private void doFinish(){
        finish();
    }
}

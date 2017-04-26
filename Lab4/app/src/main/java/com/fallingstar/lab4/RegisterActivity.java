package com.fallingstar.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {

    // Variables
    Intent myIntent;
    TextView nameTxt, sexTxt, sendMethodTxt;
    String nameStr, sexStr, sendMethodStr;
    Button backBtn;

    /*
    name : onCreate
    purpose :
    1. Get intent instance and extras.
    2. Set values of text fields with extra values with setValues()
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Get own intent instance
        myIntent = getIntent();

        nameStr = myIntent.getStringExtra("name");
        sexStr = myIntent.getStringExtra("sex");
        sendMethodStr = myIntent.getStringExtra("sendMethod");

        nameTxt = (TextView)findViewById(R.id.nameResult);
        sexTxt = (TextView)findViewById(R.id.sexResult);
        sendMethodTxt = (TextView)findViewById(R.id.sendMethodResult);

        //Dismiss current view(activity) when button clicked
        backBtn = (Button)findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setValues();
    }

    /*
    name : setValues()
    purpose :
    1. Set each value of text field with extras of intent
     */
    private void setValues(){
        nameTxt.setText("성명    :"+nameStr);
        sexTxt.setText("성별    :"+sexStr);
        sendMethodTxt.setText("수신여부  :"+sendMethodStr);
    }
}

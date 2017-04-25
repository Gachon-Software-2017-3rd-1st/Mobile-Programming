package com.fallingstar.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    // Define GUI based variables
    Button backBtn;
    String nameStr, ageStr;

    // Define programmatic variables
    Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Get intent of current class instance
        myIntent = getIntent();

        if (myIntent != null){
            // Get String Extra value from intent with key named "name" and "age"
            nameStr = myIntent.getStringExtra("name");
            ageStr = myIntent.getStringExtra("age");
            // After got a value, print the information with Toast
            Toast.makeText(getApplicationContext(), "Student Info : "+nameStr+" "+ageStr, Toast.LENGTH_SHORT).show();
        }

        // Get button's reference and set click listener
        backBtn = (Button)findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //If the button clicked, call back() function
                back();
            }
        });
    }

    // name : back
    // purpose : finish current activity, and go back to previous activity.
    private void back() {
        finish();
    }
}

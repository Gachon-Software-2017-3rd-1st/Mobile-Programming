package com.fallingstar.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {

    // Define GUI based variables
    Button addBtn;
    EditText nameTxt, ageTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        // Get each text field's references.
        nameTxt = (EditText)findViewById(R.id.nameTxt);
        ageTxt = (EditText)findViewById(R.id.ageTxt);

        // Get button's reference and set click listener.
        addBtn = (Button)findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When button clicked, call addInfo()
                addInfo();
            }
        });
    }

    // name : addInfo()
    // purpose : Get name and age strings from each text field,
    //          put it into the own variable,
    //          make intent instance and put Extra values,
    //          lauch intent with startActivity()
    private void addInfo( ) {
        String nameStr, ageStr;
        Intent intent;

        nameStr = nameTxt.getText().toString();
        ageStr  = ageTxt.getText().toString();

        // Make an intent and put extras into the intent,
        // with key named "name" and "age"
        intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.putExtra("name", nameStr);
        intent.putExtra("age", ageStr);
        startActivity(intent);
    }
}

package com.fallingstar.lab4;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    // Variables
    Button submitBtn;
    EditText nameTxt;
    RadioGroup sexRadGroup;
    RadioButton malRad, femRad;
    CheckBox smsChk, emailChk;

    /*
        name : onCreate
        purpose :
        1. Initialize first of view
        2. When submit button is pressed, initialize intent instance and put extras of each text fields
         */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitBtn = (Button)findViewById(R.id.submitBtn);
        nameTxt = (EditText)findViewById(R.id.nameTxt);

        sexRadGroup = (RadioGroup)findViewById(R.id.sexRadGroup);
        malRad = (RadioButton)findViewById(R.id.malRad);
        femRad = (RadioButton)findViewById(R.id.femRad);

        smsChk = (CheckBox)findViewById(R.id.smsChk);
        emailChk = (CheckBox)findViewById(R.id.emailChk);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Get Values from widgets
                int radId = sexRadGroup.getCheckedRadioButtonId();
                String nameStr = "";
                String sexStr = "";
                String sendMethod = "";
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);

                nameStr  = nameTxt.getText().toString();

                if (radId == malRad.getId()){
                    sexStr = "남자";
                }else if (radId == femRad.getId()){
                    sexStr = "여자";
                }

                if (smsChk.isChecked()){
                    sendMethod += "SMS";
                }
                if (emailChk.isChecked()){
                    sendMethod += " E-mail";
                }

                //Put Extras and start activity with intent
                intent.putExtra("name", nameStr);
                intent.putExtra("sex", sexStr);
                intent.putExtra("sendMethod", sendMethod);

                startActivity(intent);
            }
        });
    }

}

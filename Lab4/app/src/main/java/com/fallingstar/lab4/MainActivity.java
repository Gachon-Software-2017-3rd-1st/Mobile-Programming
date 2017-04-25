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

    Button submitBtn;
    EditText nameTxt;
    RadioGroup sexRadGroup;
    RadioButton malRad, femRad;
    CheckBox smsChk, emailChk;
    Button mBtn;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String myData = "ASDF";

        mBtn = (Button)findViewById(ASDFSAFD);
        Intent intent = new Intent();
        intent.getStringExtra()


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
                Log.d("ASDADASD", sexStr+" QWEQWQEWQWE");

                intent.putExtra("name", nameStr);
                intent.putExtra("sex", sexStr);
                intent.putExtra("sendMethod", sendMethod);

                startActivity(intent);
            }
        });
    }

    public int asdf() {
        int a;
        switch (a){
            case 1:
                return 1;
            case 2:
                return 2;

        }
        return 3;
    }



}

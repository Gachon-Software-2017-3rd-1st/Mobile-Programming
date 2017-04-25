package com.fallingstar.lab3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button myBtn;
    MenuItem item1, item2, item3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myBtn = (Button)findViewById(R.id.myBtn);
        registerForContextMenu(myBtn);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Button Menu");
        getMenuInflater().inflate(R.menu.my_menu, menu);

        item1 = menu.add(1,1,0,"Red");
        item2 = menu.add(1,2,0,"Green");
        item3 = menu.add(1,3,0,"Blue");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                myBtn.setTextColor(Color.RED);
                break;
            case 2:
                myBtn.setTextColor(Color.GREEN);
                break;
            case 3:
                myBtn.setTextColor(Color.BLUE);
                break;
            default:
                Toast.makeText(this, "Hello Menu!", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}

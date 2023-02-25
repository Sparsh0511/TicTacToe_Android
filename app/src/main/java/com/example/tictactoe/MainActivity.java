package com.example.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private int flag = 0, counter = 0;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("This is a toolbar");
            getSupportActionBar().setSubtitle("Welcome to toolbar");
        }
        init();
    }

    private void init() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);

        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

    }

    public void check(View v)  {
        Button currentBtn = (Button) v;
        boolean isEmpty = isEmpty(currentBtn);

        if(!isEmpty) {
            String currentText = currentBtn.getText().toString();
            currentBtn.setText(currentText);
        } else {
            counter++;
            if(flag == 0) {
                currentBtn.setText("X");
                flag = 1;
            } else {
                currentBtn.setText("O");
                flag = 0;
            }
        }



        currentBtn.setTextColor(Color.BLACK);

        if(counter > 4) {
            String b1 = btn1.getText().toString();
            String b2 = btn2.getText().toString();
            String b3 = btn3.getText().toString();

            String b4 = btn4.getText().toString();
            String b5 = btn5.getText().toString();
            String b6 = btn6.getText().toString();

            String b7 = btn7.getText().toString();
            String b8 = btn8.getText().toString();
            String b9 = btn9.getText().toString();

            if(b1.equals(b2) && b2.equals(b3) && !b1.equals("") ) {
                Toast.makeText(this, "Winner is: " + b1, Toast.LENGTH_SHORT).show();
            } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("") ) {
                Toast.makeText(this, "Winner is: "+ b4, Toast.LENGTH_SHORT).show();
            } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("") ) {
                Toast.makeText(this, "Winner is: "+ b7, Toast.LENGTH_SHORT).show();
            } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("") ) {
                Toast.makeText(this, "Winner is: "+ b1, Toast.LENGTH_SHORT).show();
            } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("") ) {
                Toast.makeText(this, "Winner is: "+ b2,Toast.LENGTH_SHORT).show();
            } else if ( b3.equals(b6) && b6.equals(b9) && !b3.equals("")  ) {
                Toast.makeText(this, "Winner is: "+ b3, Toast.LENGTH_SHORT).show();
            } else if ( b1.equals(b5) && b5.equals(b9) && !b1.equals("") ) {
                Toast.makeText(this, "Winner is: "+ b1, Toast.LENGTH_SHORT).show();
            } else if ( b3.equals(b5) && b5.equals(b7) && !b3.equals("") ) {
                Toast.makeText(this, "Winner is: "+ b3, Toast.LENGTH_SHORT).show();
            }


        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.tool_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.reset) {
            restart(new View(this));
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean isEmpty(@NonNull Button btn) {
        return btn.getText().toString().equals("");
    }
    public void restart(View v) {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");

        btn4.setText("");
        btn5.setText("");
        btn6.setText("");

        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        flag = 0;
        counter = 0;
    }
}
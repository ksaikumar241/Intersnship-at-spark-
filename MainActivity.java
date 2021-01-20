package com.example.bank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
        b1=(Button)findViewById(R.id.viewCustmers);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this,AllCustomers.class);
                startActivity(in);
            }
        });
//
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(MainActivity.this,AllTransactions.class);
                    startActivity(i);
                }
            });
            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(MainActivity.this,TransferActivity.class);
                    startActivity(i);
                }
            });

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }


public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    switch(item.getItemId()) {
        case R.id.item1:
            //Add Customer table activity intent here
            Intent in=new Intent(MainActivity.this,AllCustomers.class);
            startActivity(in);
            break;
        case R.id.item2:
            //Add Transfer table activity intent here
            Toast.makeText(this,"constructing",Toast.LENGTH_LONG).show();
            Intent i=new Intent(MainActivity.this,AllTransactions.class);
            startActivity(i);
            break;
        case R.id.item3:
           // go_to_transfer_activity();
            Intent in1=new Intent(MainActivity.this,TransferActivity.class);
            startActivity(in1);
            break;
    }
    return super.onOptionsItemSelected(item);
}


}
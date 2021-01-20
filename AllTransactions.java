package com.example.bank;

import  androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AllTransactions extends AppCompatActivity {
    ListView transactionlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_transactions);

        transactionlist=(ListView)findViewById(R.id.list);

        DataBaseHelper dab=new DataBaseHelper(this);

        List<Transaction> transactions =dab.transelectAll();
        Transactionlist cadpt=new Transactionlist(this,transactions);
        transactionlist.setAdapter(cadpt);
        transactionlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });


    }


}

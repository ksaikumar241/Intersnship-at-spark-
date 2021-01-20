package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AllCustomers extends AppCompatActivity {
        ListView customerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_customers);
        customerList=(ListView)findViewById(R.id.list);

        //final ArrayList<Customer> customers= new ArrayList<>();

        DataBaseHelper dab=new DataBaseHelper(this);

        dab.addOne(new Customer("Meliodas","male","ACE18881229",1450.24));
        dab.addOne(new Customer("Diane","female","ACE18881215",2860.35));
        dab.addOne(new Customer("Ban","male","ACE18881260",4320.00));
        dab.addOne(new Customer("Gowther","male","ACE18881265",9002.11));
        dab.addOne(new Customer("Merlin","female","ACE18145987",4625.85));
        dab.addOne(new Customer("King","male","ACE18658943",4050.37));
        dab.addOne(new Customer("Escnor","male","ACE18986435",1056.46));
        dab.addOne(new Customer("Asta","male","ACE18789631",1256.75));
        dab.addOne(new Customer("Yuno","male","ACE18789436",3656.28));
        dab.addOne(new Customer("Noelle","female","ACE18893146",1258.12));
        dab.addOne(new Customer("Satoshi","male","ACE18654128",4586.01));
        dab.addOne(new Customer("Serena","female","ACE18983217",8523.01));
        dab.addOne(new Customer("Asuna","female","ACE18976431",8653.10));


        List<Customer> customers =dab.selectAll();
        CustomerAdapter cadpt=new CustomerAdapter(this,customers);
        customerList.setAdapter(cadpt);
        customerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });




    }

}
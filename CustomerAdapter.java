package com.example.bank;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomerAdapter extends ArrayAdapter<Customer> {
    String sex;
    ImageView image;
    public CustomerAdapter(Context context, List<Customer> objects){
        super(context,0,objects);
    }
    @SuppressLint("ResourceType")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       // return super.getView(position, convertView, parent);
        Customer currentCustomer=getItem(position);
      View listitem=convertView;
      if(listitem==null){
        listitem= LayoutInflater.from(getContext()).inflate(R.layout.custom_adapter,parent,false);
      }

       if(currentCustomer.getmSex().equals("male")){
           image = (ImageView) listitem.findViewById(R.id.image);
            image.setImageResource(R.drawable.male);
       }
        else {
            image = (ImageView) listitem.findViewById(R.id.image);
            image.setImageResource(R.drawable.female);
        }


        TextView Lname=(TextView)listitem.findViewById(R.id.name);
        Lname.setText(currentCustomer.getmCustomerName());

        TextView bal=(TextView)listitem.findViewById(R.id.balance);
        bal.setText(""+currentCustomer.getmBalance());

        TextView Acno=(TextView)listitem.findViewById(R.id.acno);
        Acno.setText(currentCustomer.getmAccountNumber());

        return listitem;
    }
}

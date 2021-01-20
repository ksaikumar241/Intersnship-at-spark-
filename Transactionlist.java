package com.example.bank;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class Transactionlist extends ArrayAdapter<Transaction> {


    public Transactionlist(Context context, List<Transaction> objects) {
        super(context, 0, objects);
    }

    @SuppressLint("ResourceType")
    @NonNull

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Transaction tran = getItem(position);
        View listitem = convertView;

        if(listitem==null){
            listitem= LayoutInflater.from(getContext()).inflate(R.layout.activity_transactionlist,parent,false);
        }

        TextView txfrom=(TextView)listitem.findViewById(R.id.txfrom);
        txfrom.setText(tran.getFrom());

        TextView txto=(TextView)listitem.findViewById(R.id.txto);
        txto.setText(tran.getTo());

        TextView txrupee=(TextView)listitem.findViewById(R.id.txrupee);
        txrupee.setText(""+tran.getRupee());





        return listitem;
    }



}
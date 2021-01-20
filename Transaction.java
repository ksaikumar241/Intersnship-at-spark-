package com.example.bank;

import android.os.Trace;

public class Transaction {
    public String from;
    public String to;
    public Double rupee;

    public Transaction(String from, String to, Double rupee) {
        this.from = from;
        this.to = to;
        this.rupee = rupee;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Double getRupee() {
        return rupee;
    }

    public void setRupee(Double rupee) {
        this.rupee = rupee;
    }
}




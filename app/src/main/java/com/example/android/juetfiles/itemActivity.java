package com.example.android.juetfiles;

public class itemActivity {

    int backgournd;
    String item_Name;

    public itemActivity() {
    }

    public itemActivity(int backgournd, String item_Name) {
        this.backgournd = backgournd;
        this.item_Name = item_Name;

    }

    public int getBackgournd() {
        return backgournd;
    }

    public String getItem_Name() {
        return item_Name;
    }


    public void setBackgournd(int backgournd) {
        this.backgournd = backgournd;
    }

    public void setItem_Name(String item_Name) {
        this.item_Name = item_Name;
    }
}

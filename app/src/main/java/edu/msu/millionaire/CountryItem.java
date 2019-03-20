package edu.msu.millionaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CountryItem extends AppCompatActivity {
 String name;
 int image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_item);
    }
    //image of country name by name
    public CountryItem(String name, int image){
        this.name=name;
        this.image=image;
    }
//gets name
    public String getName() {
        return name;
    }
//gets image
    public int getImage() {
        return image;
    }
}

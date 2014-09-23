package com.nigazuki.campusfestival.app;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;


public class First_Activity extends ActionBarActivity {
    private SharedPreferences preference;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        preference = getSharedPreferences("Preference Name", MODE_PRIVATE);
        editor = preference.edit();

        editor.putString("playtitle", "");
        editor.putString("playmassage", "");
        editor.putString("playdata", "");
        editor.putString("playplace", "");

    }
}

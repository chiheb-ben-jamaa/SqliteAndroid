package com.m.sqliteandroid.Acivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.m.sqliteandroid.R;

public class Improter extends AppCompatActivity {
    ListView liste_web_produit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_improter);
        liste_web_produit=(ListView)findViewById(R.id.liste_web_produit);

    }
}

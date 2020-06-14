package com.m.sqliteandroid.Acivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.m.sqliteandroid.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void AjouterProduit (View v) {
        Intent i=new Intent(MainActivity.this,Ajouter_un_produit.class);
        startActivity(i);
    }

    public void ListeProduit (View v) {
        Intent i=new Intent(MainActivity.this,Liste_des_produit.class);
        startActivity(i);
    }

    public void ListeFiltreeProduit (View v) {
        Intent i=new Intent(MainActivity.this,Liste_filtree_des_produit.class);
        startActivity(i);
    }

    public void Importer (View v) {
        Intent i=new Intent(MainActivity.this,Improter.class);
        startActivity(i);
    }
}

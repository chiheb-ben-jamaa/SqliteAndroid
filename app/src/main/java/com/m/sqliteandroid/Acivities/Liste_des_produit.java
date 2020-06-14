package com.m.sqliteandroid.Acivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.m.sqliteandroid.Adapter.CustomAdapter;
import com.m.sqliteandroid.Manager.DBManager;
import com.m.sqliteandroid.Model.Produit;
import com.m.sqliteandroid.R;

import java.util.ArrayList;
import java.util.List;

public class Liste_des_produit extends AppCompatActivity {
    ListView listview_produit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_des_produit);

        DBManager dbManager = new DBManager(this);

        // Setup the data source
        ArrayList<Produit> itemsArrayList =  dbManager.getallProduit(); // calls function to get items list

        // instantiate the custom list adapter
        CustomAdapter adapterr = new CustomAdapter(this, itemsArrayList);

        // get the ListView and attach the adapter
        listview_produit=(ListView)findViewById(R.id.listview_produit);
        listview_produit.setAdapter(adapterr);

    }
}

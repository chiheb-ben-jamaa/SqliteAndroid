package com.m.sqliteandroid.Acivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.m.sqliteandroid.Adapter.CustomAdapter;
import com.m.sqliteandroid.Adapter.CustomAdapterFiltree;
import com.m.sqliteandroid.Manager.DBManager;
import com.m.sqliteandroid.Model.Produit;
import com.m.sqliteandroid.R;

import java.util.ArrayList;

public class Liste_filtree_des_produit extends AppCompatActivity {
    Spinner spinner_categorie;
    public String selected_val="";
    ListView listview_filtree;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_filtree_des_produit);
        spinner_categorie=(Spinner)findViewById(R.id.spinner_categorie);
        listview_filtree=(ListView)findViewById(R.id.listview_produit);
        init_spinner();


    }




    public String init_spinner(){
        //TODO : get list categorie and add it to the spinner :
        DBManager dbManager = new DBManager(this);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, dbManager.getallcategorie());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_categorie.setAdapter(arrayAdapter);
       spinner_categorie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               selected_val=spinner_categorie.getSelectedItem().toString();
               Toast.makeText(getApplicationContext(), selected_val , Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });
        return selected_val;
    }


    public  void Recherche(View view){
        //TODO: get the item select from spinner (init_spinner)
        DBManager dbManager = new DBManager(this);
        // Setup the data source
        ArrayList<Produit> itemsArrayList =  dbManager.getCategrieFiltree(selected_val); // calls function to get items list
        String selected_val="";
        // instantiate the custom list adapter
        CustomAdapterFiltree adapterr = new CustomAdapterFiltree(this, itemsArrayList);
        // get the ListView and attach the adapter
        listview_filtree=(ListView)findViewById(R.id.listview_filtree);
        listview_filtree.setAdapter(adapterr);
        adapterr.notifyDataSetChanged();


    }





}

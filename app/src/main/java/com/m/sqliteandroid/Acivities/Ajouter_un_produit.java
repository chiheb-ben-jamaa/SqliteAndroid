package com.m.sqliteandroid.Acivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.m.sqliteandroid.Manager.DBManager;
import com.m.sqliteandroid.Model.Produit;
import com.m.sqliteandroid.R;

public class Ajouter_un_produit extends AppCompatActivity {

    EditText nom,code_a_barre,
            stock,categorie;

    Button enregistrer;
    public DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_un_produit);

        enregistrer=(Button)findViewById(R.id.enregistrer);
        nom=(EditText)findViewById(R.id.nom);
        code_a_barre=(EditText)findViewById(R.id.code_a_barre);
        stock=(EditText)findViewById(R.id.stock);
        categorie=(EditText)findViewById(R.id.categorie);




    }


    public void Enregistrer (View v){
        dbManager = new DBManager(this);

        //TODO: get all text from EditText:
        String nom_val=nom.getText().toString();
        int code_val=Integer.parseInt(code_a_barre.getText().toString());
        int stock_val=Integer.parseInt(stock.getText().toString());
        String categorie_val=categorie.getText().toString();

        Produit produit=new Produit(nom_val,code_val,stock_val,categorie_val);
        dbManager.insert(produit);
        Log.d(TAG, "onClick: Inser in Enregistrer");
        dbManager.close();
        finish();

    }


    public void Annuler (View v) {
        finish();
    }



}

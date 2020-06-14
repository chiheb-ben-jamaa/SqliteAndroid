package com.m.sqliteandroid.Manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.m.sqliteandroid.Helper.DatabaseHelper;
import com.m.sqliteandroid.Model.Produit;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class DBManager {



    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;





    public DBManager(Context context){
        //On crée la BDD et sa table
        dbHelper = new DatabaseHelper(context, DatabaseHelper.DB_NAME, null, DatabaseHelper.DB_VERSION);
    }




    public void open(){
        //on ouvre la BDD en écriture
        database = dbHelper.getWritableDatabase();
    }




    public void close(){
        //on ferme l'accès à la BDD
        database.close();
    }




    //create model Produit
    public void insert(Produit produit) {
        //int array :
        open();
        ContentValues contentValue = new ContentValues();
        //add all params into the array:
        contentValue.put(DatabaseHelper.COLUMN_NOM, produit.getNom());
        contentValue.put(DatabaseHelper.COLUMN_CODE,produit.getCode_a_barre() );
        contentValue.put(DatabaseHelper.COLUMN_STOCK,produit.getStock() );
        contentValue.put(DatabaseHelper.COLUMN_CATEGORIE,produit.getCategorie() );
        //isert array that have all the data:
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
        Log.d(TAG, "insert: Data"+produit.getCategorie());

    }







    public ArrayList<Produit> getallProduit()
    {
        open();
        ArrayList<Produit> List_produit = new ArrayList<Produit>();

        /*
        Cursor c = database.query("produit", new String[] {DatabaseHelper.COLUMN_ID,DatabaseHelper.COLUMN_NOM, DatabaseHelper.COLUMN_CATEGORIE,
                DatabaseHelper.COLUMN_CODE, DatabaseHelper.COLUMN_STOCK}, null, null, null, null, null);
        */
        String selectQuery = "SELECT * FROM produit";
        Cursor c = database.rawQuery(selectQuery, null);

        Produit produit;
        while (c.moveToNext())
        {
            produit = new Produit();


            produit.setId(c.getInt(c.getColumnIndex(DatabaseHelper.COLUMN_ID)));
            produit.setNom(c.getString(c.getColumnIndex(DatabaseHelper.COLUMN_NOM)));
            produit.setCode_a_barre(c.getInt(c.getColumnIndex(DatabaseHelper.COLUMN_CODE)));
            produit.setStock(c.getInt(c.getColumnIndex(DatabaseHelper.COLUMN_STOCK)));
            produit.setCategorie(c.getString(c.getColumnIndex(DatabaseHelper.COLUMN_CATEGORIE)));


            List_produit.add(produit);
        }

        c.close();

        return List_produit;
    }





    public ArrayList<String> getallcategorie(){
        open();
        ArrayList<String> categorieList=new ArrayList<String>();

        String selectQuery = "SELECT DISTINCT categorie FROM produit";
        Cursor c = database.rawQuery(selectQuery, null);

        String categorie_val="";
        while (c.moveToNext())
        {

            categorie_val=c.getString(c.getColumnIndex(DatabaseHelper.COLUMN_CATEGORIE));
            categorieList.add(categorie_val);
            Log.d(TAG, "getallcategorie: "+categorie_val);
        }

        c.close();
        Log.d(TAG, "getallcategorie SIZE: "+categorieList.size());
        return categorieList;

    }



    public ArrayList<Produit> getCategrieFiltree(String categorie)
    {
        open();
        ArrayList<Produit> List_produit_filtree = new ArrayList<Produit>();

        String selectQuery = "SELECT * FROM produit  WHERE categorie ='"+categorie+"'";
        Cursor c = database.rawQuery(selectQuery, null);

        Produit produit;
        while (c.moveToNext())
        {
            produit = new Produit();


            produit.setId(c.getInt(c.getColumnIndex(DatabaseHelper.COLUMN_ID)));
            produit.setNom(c.getString(c.getColumnIndex(DatabaseHelper.COLUMN_NOM)));
            produit.setCode_a_barre(c.getInt(c.getColumnIndex(DatabaseHelper.COLUMN_CODE)));
            produit.setStock(c.getInt(c.getColumnIndex(DatabaseHelper.COLUMN_STOCK)));
            produit.setCategorie(c.getString(c.getColumnIndex(DatabaseHelper.COLUMN_CATEGORIE)));
            Log.d(TAG, "getallcategorie: "+produit.getCategorie());

            List_produit_filtree.add(produit);
        }

        c.close();
        Log.d(TAG, "getallcategorie SIZE: "+List_produit_filtree.size());
        return List_produit_filtree;
    }





}

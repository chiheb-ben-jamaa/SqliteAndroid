package com.m.sqliteandroid.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.m.sqliteandroid.Model.Produit;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "android.db";
    public static final String TABLE_NAME = "produit";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOM = "nom";
    public static final String COLUMN_CODE = "code_a_barre";
    public static final String COLUMN_STOCK = "stock";
    public static final String COLUMN_CATEGORIE = "categorie";


    //adding this :
    SQLiteDatabase database;

    public DatabaseHelper(@Nullable Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }


    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_NOM + " TEXT NOT NULL, " +
            COLUMN_CODE+ " INTEGER NOT NULL," +
            COLUMN_STOCK+ " INTEGER NOT NULL," +
            COLUMN_CATEGORIE+ " TEXT NOT NULL);";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }




}

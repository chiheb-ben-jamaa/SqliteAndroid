package com.m.sqliteandroid.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.m.sqliteandroid.Model.Produit;
import com.m.sqliteandroid.R;

import java.util.ArrayList;

public class CustomAdapterFiltree extends BaseAdapter {
    private Context mContext;
    private ArrayList<Produit> produits;

    public CustomAdapterFiltree(Context mContext, ArrayList<Produit> produits) {
        this.mContext = mContext;
        this.produits = produits;
    }

    public int getCount() {
        return produits.size();
    }

    public Object getItem(int position) {
        return produits.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View ViewAndroid;
        if (convertView == null) {
            ViewAndroid = new View(mContext);
            ViewAndroid = inflater.inflate(R.layout.list_row_filtree, null);
            TextView nom_txt = (TextView) ViewAndroid.findViewById(R.id.nom_txt);
            TextView categorie_txt = (TextView) ViewAndroid.findViewById(R.id.categorie_txt);
            TextView stock_txt = (TextView) ViewAndroid.findViewById(R.id.stock_txt);
            nom_txt.setText(produits.get(position).getNom());
            categorie_txt.setText(produits.get(position).getCategorie());
            stock_txt.setText(String.valueOf(produits.get(position).getStock()));

        } else {
            ViewAndroid = (View) convertView;
        }

        return ViewAndroid;
    }

}
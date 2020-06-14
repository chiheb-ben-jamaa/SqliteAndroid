package com.m.sqliteandroid.Acivities;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.m.sqliteandroid.Adapter.CustomAdapter;
import com.m.sqliteandroid.Model.Produit;
import com.m.sqliteandroid.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class Improter extends AppCompatActivity {
    ListView liste_web_produit;

    //get json from PHP :
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private String url = "http://192.168.1.5/php_webservice_produit/web.php";
    public  ArrayList<Produit> list;
    public TextView count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_improter);
        liste_web_produit=(ListView)findViewById(R.id.liste_web_produit);
        count=(TextView)findViewById(R.id.count);
        list=new ArrayList<Produit>();

        //RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(this);
        Volley();



    }

    public void Volley(){
        mStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                //Toast.makeText(getApplicationContext(),"Response :" + response.toString(), Toast.LENGTH_LONG).show();//display the response on screen
                Log.i(TAG,"Error :" + response.toString());


                try {
                    JSONArray jsonObject = new JSONArray (response);
                    for(int i=0;i<jsonObject.length();i++){
                        String count=String.valueOf(i);

                        JSONObject prodObject = jsonObject.getJSONObject(i);

                        //creating a Produit object and giving them the values from json object
                        Produit p=new Produit();
                        p.setNom(prodObject.getString("nom"));
                        p.setCategorie(prodObject.getString("categorie"));
                        p.setStock(Integer.parseInt(prodObject.getString("stock")));
                        p.setCode_a_barre(Integer.parseInt(prodObject.getString("code_barre")));


                        list.add(p);


                    }


                    //set the count of the Arrylist
                    count.setText(String.valueOf(jsonObject.length()));
                    CustomAdapter adapter = new CustomAdapter(getApplicationContext(), list);
                    // get the ListView and attach the adapter
                    liste_web_produit.setAdapter(adapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.getStackTraceString(e);
                    Toast.makeText(Improter.this, "Bad Response from the Server", Toast.LENGTH_SHORT).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.i(TAG,"Error :" + error.toString());

            }
        });

        mRequestQueue.add(mStringRequest);

    }




}

package com.example.listviewvolley;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.nsd.NsdManager;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RequestQueue queue;
    private TextView txtListaEvaluadores;
    List<ElementosLista> evaluadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queue = Volley.newRequestQueue(this);
        evaluadores = obtenerEvaluadores();
        MostrarData(evaluadores);
    }

    private List<ElementosLista> obtenerEvaluadores(){
        evaluadores = new ArrayList<>();
        String url = "https://www.uealecpeterson.net/ws/listadoevaluadores.php";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,url,null, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse (JSONObject response){
                try {
                    JSONArray listaevaluadores = response.getJSONArray("listaaevaluador");

                    String contenido="";
                    for (int i=0;i<listaevaluadores.length();i++) {
                        JSONObject evaluador = listaevaluadores.getJSONObject(i);
                        evaluadores.add(new ElementosLista(
                                evaluador.getString("nombres"),
                                evaluador.getString("idevaluador"),
                                evaluador.getString("area"),
                                evaluador.getString("imgJPG"),
                                evaluador.getString("imgjpg")
                        ));
                    }
                }
                catch (JSONException e){
                    e.printStackTrace();

                }
            }
        },

                new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){

            }
        });
        queue.add(request);
        return evaluadores;
    }

    private void MostrarData (List<ElementosLista> listado){
        Adaptador adapter = new Adaptador(listado,this);
        RecyclerView recyclerView=findViewById(R.id.lstLista);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }


}
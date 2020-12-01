package com.example.zutawa_assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tv,tv2,tv3,tv4;
    RecyclerView recyclerView,recyclerView2,recyclerView3,recyclerView4;
    PlantAdapter plantAdapter,cat3;
    PlantAdapter2 plantAdapter2,cat4;
    ArrayList<Plant> plants,plants2,plants3,plants4;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        recyclerView = findViewById(R.id.recycle);
        recyclerView2 = findViewById(R.id.recycle2);
        recyclerView3 = findViewById(R.id.recycle3);
        recyclerView4 = findViewById(R.id.recycle4);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false ));
        recyclerView2.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        recyclerView3.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false ));
        recyclerView4.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false ));
        plantAdapter = new PlantAdapter();
        cat3 = new PlantAdapter();
        plantAdapter2 = new PlantAdapter2();
        cat4 = new PlantAdapter2();
        recyclerView.setAdapter(plantAdapter);
        recyclerView2.setAdapter(plantAdapter2);
        recyclerView3.setAdapter(cat3);
        recyclerView4.setAdapter(cat4);
        plants = new ArrayList<>();
        plants2 = new ArrayList<>();
        plants3 = new ArrayList<>();
        plants4 = new ArrayList<>();
        getData();
    }

    private void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        url = "https://gaming-panda.df.r.appspot.com/intern_test";
        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.GET,
                url,
                null,
                response -> {
                        try {
                            JSONObject jo = new JSONObject(response.toString());
                            JSONArray ja = jo.getJSONArray("response");
                            for (int i=0; i < 1; i++) {
                                JSONObject data = ja.getJSONObject(i);
                                tv.setText(data.getString("title"));
                                JSONArray item = data.getJSONArray("items");
                                for(int j=0 ; j<6; j++) {
                                    JSONObject img = item.getJSONObject(j);
                                    Plant plant = new Plant();
                                    plant.setImg_src(img.getString("img_src"));
                                    plant.setTitle(img.getString("title"));
                                    plants.add(plant);
                                }
                            }
                            for (int i=1; i < 2; i++) {
                                JSONObject data = ja.getJSONObject(i);
                                tv2.setText(data.getString("title"));
                                JSONArray item = data.getJSONArray("items");
                                for(int j=0 ; j<6; j++) {
                                    JSONObject img = item.getJSONObject(j);
                                    Plant plant2 = new Plant();
                                    plant2.setImg_src(img.getString("img_src"));
                                    plant2.setTitle(img.getString("title"));
                                    plant2.setSubtitile(img.getString("sub_title"));
                                    plants2.add(plant2);
                                }
                            }
                            for (int i=2; i < 3; i++) {
                                JSONObject data = ja.getJSONObject(i);
                                tv3.setText(data.getString("title"));
                                JSONArray item = data.getJSONArray("items");
                                for(int j=0 ; j<6; j++) {
                                    JSONObject img = item.getJSONObject(j);
                                    Plant plant3 = new Plant();
                                    plant3.setImg_src(img.getString("img_src"));
                                    plant3.setTitle(img.getString("title"));
                                    plants3.add(plant3);
                                }
                            }
                            for (int i=3; i < 4; i++) {
                                JSONObject data = ja.getJSONObject(i);
                                tv4.setText(data.getString("title"));
                                JSONArray item = data.getJSONArray("items");
                                for(int j=0 ; j<6; j++) {
                                    JSONObject img = item.getJSONObject(j);
                                    Plant plant4 = new Plant();
                                    plant4.setImg_src(img.getString("img_src"));
                                    plant4.setTitle(img.getString("title"));
                                    //plant4.setSubtitile(img.getString("sub_title"));
                                    plants4.add(plant4);
                                }
                            }
                        } catch (JSONException e) {
                        e.printStackTrace();
                        }
                        plantAdapter.setData(plants);
                        plantAdapter.notifyDataSetChanged();
                        plantAdapter2.setData(plants2);
                        plantAdapter2.notifyDataSetChanged();
                        cat3.setData(plants3);
                        cat3.notifyDataSetChanged();
                        cat4.setData(plants4);
                        cat4.notifyDataSetChanged();
                        progressDialog.dismiss();
                    },
                    error -> {
                        // TODO Auto-generated method stub
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this,"Error Occurred",Toast.LENGTH_SHORT).show();
                    }

            );
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(postRequest);
    }
}
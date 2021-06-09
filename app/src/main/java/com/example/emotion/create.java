package com.example.emotion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class create extends AppCompatActivity {
    EditText id,name,brand;
    Button createProduct;
    String url = "https://60c0341eb8d36700175547de.mockapi.io/product";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        name =findViewById(R.id.nameCreate);
        brand =findViewById(R.id.brandCreate);
        createProduct = findViewById(R.id.createProduct);
        createProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PostApi(url,name.getText().toString().trim(),brand.getText().toString());
                Intent intent  = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(intent);
            }
        });

    }

    private void PostApi(String url,String name,String brand){
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(create.this, "Successfully", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(create.this, "Error by Post data!", Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                HashMap<String, String>
                        params = new HashMap<>();
                params.put("name", name);
                params.put("brand", brand);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
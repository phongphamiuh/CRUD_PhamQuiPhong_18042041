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

public class edit extends AppCompatActivity {
    EditText name,brand;
    Button editBtn;
    String url = "https://60c0341eb8d36700175547de.mockapi.io/product";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);


        name = findViewById(R.id.nameEdit);
        brand =findViewById(R.id.branEdit);
        editBtn =findViewById(R.id.editBtn);
        Product product = (Product) getIntent().getSerializableExtra("product");
        name.setText(product.getName());
        brand.setText(product.getBrand());

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PutApi(url,product.getId(),name.getText().toString().trim(),brand.getText().toString().trim());
                Intent intent  = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(intent);
            }
        });
    }

    private void PutApi(String url,String id,String name,String brand){
        StringRequest stringRequest = new StringRequest(
                Request.Method.PUT, url + '/' + id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(edit.this, "Successfully", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(edit.this, "Error by Post data!", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("name", name);
                params.put("brand", brand);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
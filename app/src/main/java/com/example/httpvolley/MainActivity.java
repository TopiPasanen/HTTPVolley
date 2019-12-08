package com.example.httpvolley;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText osoiteLoota;
    TextView dataLoota;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.Gogogo).setOnClickListener(this);
        osoiteLoota = (EditText) findViewById(R.id.osoiteLoota);
        dataLoota = (TextView) findViewById(R.id.dataLoota);
    }

    @Override
    public void onClick(View v) {



        final RequestQueue queue = Volley.newRequestQueue(this);
        String url = osoiteLoota.getText().toString();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    dataLoota.setText(response);
                    queue.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dataLoota.setText("That didn't work");
                queue.stop();
            }
        });
        queue.add(stringRequest);
    }
}

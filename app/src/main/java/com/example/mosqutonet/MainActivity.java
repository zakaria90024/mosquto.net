package com.example.mosqutonet;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button buttonDown, buttonUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonDown = findViewById(R.id.buttonDown);
        buttonUp = findViewById(R.id.buttonUp);


        buttonDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ConnectivityManager mgr = (ConnectivityManager) getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo netInfo = mgr.getActiveNetworkInfo();

                if (netInfo != null) {
                    if (netInfo.isConnected()) {
                        WebView myWebView = (WebView) findViewById(R.id.webview);
                        myWebView.loadUrl("http://192.168.4.1/Hi");
                        myWebView.setWebViewClient(new WebViewClient());
                    } else {
                        Toast.makeText(MainActivity.this, "Not Connected Internet", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Not Connected Internet", Toast.LENGTH_SHORT).show();
                }


            }
        });


        buttonUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConnectivityManager mgr = (ConnectivityManager) getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo netInfo = mgr.getActiveNetworkInfo();

                if (netInfo != null) {
                    if (netInfo.isConnected()) {
                        WebView myWebView = (WebView) findViewById(R.id.webview);
                        myWebView.loadUrl("http://192.168.4.1/Lo");
                        myWebView.setWebViewClient(new WebViewClient());
                    } else {
                        Toast.makeText(MainActivity.this, "Not Connected Internet", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Not Connected Internet", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
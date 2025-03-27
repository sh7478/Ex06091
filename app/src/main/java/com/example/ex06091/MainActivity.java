package com.example.ex06091;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    WebView wV;
    EditText etAdress;
    String adress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wV = (WebView) findViewById(R.id.wV);
        wV.getSettings().setJavaScriptEnabled(true);
        etAdress = findViewById(R.id.etAddress);
        /*adress = "";*/
    }

    public void search(View view) {
        wV.setWebViewClient(new MyWebViewClient());
        adress = etAdress.getText().toString();
        if (adress != "")
        {
            wV.loadUrl(adress);
        }
    }

    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}
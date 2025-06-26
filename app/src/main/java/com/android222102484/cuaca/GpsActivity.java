package com.android222102484.cuaca;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GpsActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.layout_gps);
        webView = findViewById(R.id.wvMain);

        TextView textViewCoordinat = findViewById(R.id.textView_koordinat);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle param = getIntent().getBundleExtra("param");
        textViewCoordinat.setText(param.getDouble("lat") + " x " + param.getDouble("lon"));

        String url = "https://www.google.com/maps" +
                "?q=" + param.getDouble("lat") + "," + param.getDouble("lon") +
                "&ll=" + param.getDouble("lat") + "," + param.getDouble("lon") +
                "&z=10";

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }
}

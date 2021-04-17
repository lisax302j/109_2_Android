package com.example.a106332013_hw42;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ShareCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareTextEditText;

    public static final int CAMERA_PERMISSION = 100;//檢測相機權限用
    public static final int REQUEST_HIGH_IMAGE = 101;//檢測高畫質相機回傳

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        Intent intent = getIntent ( );
        Uri uri = intent.getData ( );
        if (uri != null) {
            String uri_string = getString (R.string.uri_label)
                    + uri.toString ( );
            TextView textView = findViewById (R.id.text);
            textView.setText (uri_string);
        }

        mWebsiteEditText = findViewById(R.id.website_edittext);
        mLocationEditText=findViewById ( R.id.location_edittext );
        mShareTextEditText = findViewById(R.id.share_edittext);

        Button btnPicture = (Button) findViewById (R.id.button_picture);

        }


    @SuppressLint("QueryPermissionsNeeded")

    public void openWebsite(View view) {
        String url = mWebsiteEditText.getText ( ).toString ( );
        Uri webpage = Uri.parse (url);
        Intent intent = new Intent (Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity (getPackageManager ( )) != null) {
            startActivity (intent);
        } else {
            Log.d ("ImplicitIntents", "Can't handle this!");

        }
    }

    public void openLocation(View view) {
        String loc = mLocationEditText.getText ( ).toString ( );
        Uri addressUri = Uri.parse ("geo:0,0?q=" + loc);
        Intent intent = new Intent (Intent.ACTION_VIEW, addressUri);
        if (intent.resolveActivity (getPackageManager ( )) != null) {
            startActivity (intent);
        } else {
            Log.d ("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void shareText(View view) {
        String txt = mShareTextEditText.getText ( ).toString ( );
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from (this)
                .setType (mimeType)
                .setChooserTitle ("Share this text with: ")
                .setText (txt)
                .startChooser ( );
    }

    public void TakePicture(View view) {
        Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(it,100);
    }
}



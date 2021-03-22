package com.example.a106332013_hw42;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareTextEditText;
    private EditText mTakePictureEditText;
//12313213
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
    }

    @SuppressLint("QueryPermissionsNeeded")

    public void openWebsite(View view) {
        mWebsiteEditText = findViewById (R.id.website_edittext);
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
        mLocationEditText = findViewById (R.id.location_edittext);
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
        mShareTextEditText = findViewById (R.id.share_edittext);
        String txt = mShareTextEditText.getText ( ).toString ( );
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from (this)
                .setType (mimeType)
                .setChooserTitle ("Share this text with: ")
                .setText (txt)
                .startChooser ( );

    }

    Intent intent = new Intent ( );
//    intent.setAction("android.media.action.STILL_IMAGE_CAMERA");
//    startActivity(intent);

    Button btn = (Button) findViewById (R.id.button_picture);
//    btn.setOnClickListener(new void OnClickListener(){


//    public void OnClick(View view)
//      Intent intent = new Intent ( );
//      intent.setAction ("android.media.action.STILL_IMAGE_CAMERA");
//      startActivity (intent);
//    };

}


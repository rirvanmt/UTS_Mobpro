package com.example.rahadianirvan.wartegmcd;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class Menu1 extends AppCompatActivity {


    ImageView mImage;
    TextView mText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);



        mImage = (ImageView)findViewById(R.id.image);
        mText = (TextView)findViewById(R.id.text);




        loadDataFromAsset();
    }

    public void loadDataFromAsset() {
        // load text
        try {
            // get input stream for text
            InputStream is = getAssets().open("text.txt");
            // check size
            int size = is.available();
            // create buffer for IO
            byte[] buffer = new byte[size];
            // get data to buffer
            is.read(buffer);
            // close stream
            is.close();
            // set result to TextView
            mText.setText(new String(buffer));
        }
        catch (IOException ex) {
            return;
        }

        // load image
        try {
            // get input stream
            InputStream ims = getAssets().open("bill_gates.png");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            mImage.setImageDrawable(d);
        }
        catch(IOException ex) {
            return;
        }

    }
}


package com.example.rahadianirvan.wartegmcd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

public class PesanActivity extends AppCompatActivity {

    CheckBox cek1,cek2,cek3,cek4,cek5;
    Button btnPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pesan);
        cek1 = (CheckBox) findViewById(R.id.cek1);
        cek2 = (CheckBox) findViewById(R.id.cek2);
        cek3 = (CheckBox) findViewById(R.id.cek3);
        cek4 = (CheckBox) findViewById(R.id.cek4);
        cek5 = (CheckBox) findViewById(R.id.cek5);
        btnPesan = (Button) findViewById(R.id.btnPesan);

    }
    Intent intent;
    public void test1(View view){
        switch (view.getId()){
            case R.id.img1:
                intent = new Intent(getApplicationContext(), Menu1.class);
                startActivity(intent);
                break;
            case R.id.img2:
                intent = new Intent(getApplicationContext(), Menu1.class);
                startActivity(intent);
                break;
        }
    }
}

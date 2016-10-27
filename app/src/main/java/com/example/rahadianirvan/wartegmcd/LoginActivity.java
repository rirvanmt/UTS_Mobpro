package com.example.rahadianirvan.wartegmcd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    //Username Password edit text
    EditText username,password;

    //isi shared
    private final String NAMA = "Rahadian Irvan";
    private final String EMAIL = "rahadian@student.uinsgd.ac.id";

    //Username dan Password
    private final String USERNAME = "admin";
    private final String PASSWORD = "admin";

    //login button
    Button btnLogin,btnRegister;

    //Session Manager Class
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //session manager
        session = new SessionManager(getApplicationContext());

        //Username, Password
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        //Menampilkan status Login
        Toast.makeText(getApplicationContext(), "User Login Status: " +
                session.isLoggedIn(), Toast.LENGTH_LONG).show();

        //Login Button
        btnRegister =(Button) findViewById(R.id.btnRegister);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        //Login Button Event
        btnLogin.setOnClickListener(new View.OnClickListener(){

            public void onClick(View arg0){
                //Get Username, Password
                String user = username.getText().toString();
                String pass = password.getText().toString();

                //cek jika username dan password dengan data
                if (user.trim().length() > 0 && pass.trim().length() > 0){
                    //jika sesuai dengan data
                    if (user.equals(USERNAME) && pass.equals(PASSWORD)){
                        session.createLoginSession(NAMA, EMAIL);
                        //Mengarahkan ke Main Activity
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        //Username/Password Salah/Tidak sesuai
                        Toast.makeText(getApplicationContext(), "LOGIN GAGAL..\n" +
                                "Silahkan Masukan Username dan Password", Toast.LENGTH_LONG).show();
                    }
                }
            }

        });

        //btnRegister Event
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

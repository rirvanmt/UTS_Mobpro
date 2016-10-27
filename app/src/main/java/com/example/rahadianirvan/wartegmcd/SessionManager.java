package com.example.rahadianirvan.wartegmcd;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.example.rahadianirvan.wartegmcd.LoginActivity;

import java.util.HashMap;

/**
 * Created by Rahadian Irvan on 10/21/2016.
 */
public class SessionManager {
    //Shared Pref
    SharedPreferences pref;

    //Editor untuk Shared pref
    Editor editor;

    //Context
    Context _context;

    //Shared pref mode
    int PRIVATE_MODE = 0;

    //shared pred file name
    private static final String PREF_NAME = "PrefLogin";

    //Shared pref Key
    private static final String IS_LOGIN = "IsLoggedIn";

    //Username
    public static String KEY_NAMA = "name";

    //Password
    public static String KEY_MAIL = "email";

    //Constructor
    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    //Membuat Login Session
    public void createLoginSession(String nama, String email){
        //Menyimpan login dengan nilai TRUE
        editor.putBoolean(IS_LOGIN, true);

        //Menyimpan username di pref
        editor.putString(KEY_NAMA, nama);

        //Menyimpan password di pref
        editor.putString(KEY_MAIL, email);

        //Simpan Perubahan
        editor.commit();
    }

    //Mendapatkan Session yang telah tersimpan
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<>();
        //username user
        user.put(KEY_NAMA, pref.getString(KEY_NAMA, null));
        //password user
        user.put(KEY_MAIL, pref.getString(KEY_MAIL, null));
        //return user
        return user;
    }

    //Cek Login Status
    public void checkLogin(){
        //cek login
        if (!this.isLoggedIn()){
            //jika user tidak login maka akan kembali ke login activity
            Intent intent = new Intent(_context, LoginActivity.class);
            //tutup semau activity
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            //tambah flag untuk memulai activity baru
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //membuka activity Login
            _context.startActivity(intent);
        }
    }

    //Cek user Login
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }

    //Menghapus detail session
    public void logoutUser(){
        //menghapus semua data dari shared pref
        editor.clear();
        editor.commit();
        //diarahkan ke Login Activity
        Intent intent = new Intent(_context, LoginActivity.class);
        //tutup semua activity
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //tambahkan flag untuk memulai activity baru
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //membuka activity Login
        _context.startActivity(intent);
    }
}

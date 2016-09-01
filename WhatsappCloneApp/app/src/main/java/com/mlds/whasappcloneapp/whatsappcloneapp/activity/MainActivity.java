package com.mlds.whasappcloneapp.whatsappcloneapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.client.Firebase;
import com.mlds.whasappcloneapp.whatsappcloneapp.R;

public class MainActivity extends AppCompatActivity {

    private Firebase firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Firebase.setAndroidContext(this);

        firebase = new Firebase("https://whatsappclone-df781.firebaseio.com/mensagens");
        firebase.setValue("Teste do firebase");*/



    }
}

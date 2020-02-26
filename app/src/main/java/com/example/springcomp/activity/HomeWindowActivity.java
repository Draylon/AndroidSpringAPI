package com.example.springcomp.activity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.springcomp.R;
import com.example.springcomp.socketService.ApiDataLink;

import java.io.Serializable;

public class HomeWindowActivity extends AppCompatActivity implements Serializable {

    ApiDataLink login;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Boolean isLogged = (Boolean) getIntent().getSerializableExtra("IsLogged");
        setContentView(R.layout.home_window);
        TextView v = findViewById(R.id.homeLabel);
        if(ApiDataLink.getLocalData().getName() == null)
            v.setText("Bem vindo, "+ApiDataLink.getLocalData().getEmail());
        else
            v.setText("Bem vindo, "+ApiDataLink.getLocalData().getName());
        if(isLogged)
            Toast.makeText(this,"Logged Shows Up",Toast.LENGTH_LONG).show();
        else Toast.makeText(this,"Login was not forwarded here",Toast.LENGTH_LONG).show();
    }
}
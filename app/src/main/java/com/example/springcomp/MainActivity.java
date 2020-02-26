package com.example.springcomp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import com.example.springcomp.UI.dialogs.AutoLoginDialog;
import com.example.springcomp.UI.login.LoginSectionPageAdapter;
import com.example.springcomp.UI.login.LoginTabFragView;
import com.example.springcomp.UI.login.SignupTabFragView;
import com.example.springcomp.activity.HomeWindowActivity;
import com.example.springcomp.socketService.ApiDataLink;
import com.google.android.material.tabs.TabLayout;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable {

    ApiDataLink login;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        login = new ApiDataLink();
        setContentView(R.layout.activity_main);

        Button welcomeBT = findViewById(R.id.welcomeButton);
        ApiDataLink.setCacheDir(getCacheDir());
        ApiDataLink.init();

        TextView serv = findViewById(R.id.serverIPText);
        TextView prt = findViewById(R.id.serverPortText);
        serv.setText(ApiDataLink.getLocalData().getServerIP());
        prt.setText(String.valueOf(ApiDataLink.getLocalData().getServerPort()));

        welcomeBT.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView serverIP = findViewById(R.id.serverIPText);
                TextView serverPort = findViewById(R.id.serverPortText);
                ApiDataLink.getLocalData().setServerIP(serverIP.getText().toString());
                if(Integer.valueOf(serverPort.getText().toString()) != null)
                    ApiDataLink.getLocalData().setServerPort(Integer.valueOf(serverPort.getText().toString()));
                else ApiDataLink.getLocalData().setServerPort(0000);
                Boolean bls = ApiDataLink.saveLocalData();
                if(bls)
                    System.out.println("Saved file!");
                else System.out.println("FML!!");

                final Boolean[] autoLogin = {false};
                if(ApiDataLink.getLocalData().getLogged()){
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Login Automático").setMessage("Entrar com a mesma conta?")
                            .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) { autoLogin[0] =true;setLoginForward(autoLogin);}})
                            .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) { autoLogin[0]=false;setLoginForward(autoLogin);}}).show();
                }else{
                    setLoginForward(autoLogin);
                }
            }
        });
    }

    private void setLoginForward(Boolean[] autoLogin){
        if(autoLogin[0]){
            Toast.makeText(MainActivity.this,"welcomeToast",Toast.LENGTH_LONG).show();
            //setContentView(R.layout.home_window);
            Intent intent = new Intent(MainActivity.this, HomeWindowActivity.class);
            intent.putExtra("IsLogged", new Boolean(true));
            startActivity(intent);
        }else{
            setContentView(R.layout.login_screen);
            Toast.makeText(MainActivity.this,"Please Log In",Toast.LENGTH_LONG).show();
            LoginSectionPageAdapter adapter = new LoginSectionPageAdapter(getSupportFragmentManager());
            ViewPager loginViewPager = findViewById(R.id.loginViewPager);
            setViewPager(loginViewPager);

            TabLayout loginTabLayout = findViewById(R.id.loginTabs);
            loginTabLayout.setupWithViewPager(loginViewPager);
        }
    }

    public void setViewPager(ViewPager viewPager){
        LoginSectionPageAdapter adapter = new LoginSectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new LoginTabFragView(),"Login");
        adapter.addFragment(new SignupTabFragView(),"Sign Up");
        viewPager.setAdapter(adapter);
    }
}

package com.example.springcomp;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import com.example.springcomp.UI.login.LoginSectionPageAdapter;
import com.example.springcomp.UI.login.LoginTabFragView;
import com.example.springcomp.UI.login.SignupTabFragView;
import com.example.springcomp.socketService.ApiDataLink;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ApiDataLink login;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        login = new ApiDataLink();
        setContentView(R.layout.activity_main);

        Button welcomeBT = findViewById(R.id.welcomeButton);

        welcomeBT.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(ApiDataLink.getLocalData().getLogged()){
                    Toast.makeText(MainActivity.this,"welcomeToast",Toast.LENGTH_LONG).show();
                    setContentView(R.layout.home_window);
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
        });
    }

    public void setViewPager(ViewPager viewPager){
        LoginSectionPageAdapter adapter = new LoginSectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new LoginTabFragView(),"Login");
        adapter.addFragment(new SignupTabFragView(),"Sign Up");
        viewPager.setAdapter(adapter);
    }
}

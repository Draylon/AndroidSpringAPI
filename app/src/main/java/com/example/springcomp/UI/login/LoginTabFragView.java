package com.example.springcomp.UI.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.springcomp.MainActivity;
import com.example.springcomp.R;
import com.example.springcomp.activity.HomeWindowActivity;
import com.example.springcomp.api.dtos.UserLoginResponseDTO;
import com.example.springcomp.socketService.ApiDataLink;
import com.example.springcomp.socketService.LocalDataRepo;
import com.google.gson.Gson;

import java.util.HashMap;

public class LoginTabFragView extends Fragment {

    Button loginButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.logintab_fragview,container,false);
        loginButton = view.findViewById(R.id.loginButton);
        TextView use = view.findViewById(R.id.loginUsername);
        TextView pas = view.findViewById(R.id.loginPassword);
        use.setText(ApiDataLink.getLocalData().getEmail());
        pas.setText(ApiDataLink.getLocalData().getPassword());

        ApiDataLink.getLocalData().setLogged(false);
        ApiDataLink.saveLocalData();

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(),"LoginFrag selected",Toast.LENGTH_LONG).show();
                TextView username = view.findViewById(R.id.loginUsername);
                TextView password = view.findViewById(R.id.loginPassword);
                String unString = username.getText().toString();
                String pwString = password.getText().toString();
                ApiDataLink.setUserData(unString,pwString);
                try{
                    HashMap loginStatus = ApiDataLink.attemptLogin();
                    System.out.println(loginStatus.toString());
                    UserLoginResponseDTO loginResponse = new Gson().fromJson((String) loginStatus.get("response"), UserLoginResponseDTO.class);
                    System.out.println(loginResponse.toString());
                    if(loginResponse.getValidCredentials()) {
                        Toast.makeText(getActivity(), "Logged In successfully",Toast.LENGTH_LONG).show();
                        ApiDataLink.getLocalData().setHash(loginResponse.getHash());
                        //getActivity().setContentView(R.layout.home_window);
                        ApiDataLink.getLocalData().setLogged(true);
                        ApiDataLink.saveLocalData();
                        Intent intent = new Intent(getActivity(), HomeWindowActivity.class);
                        intent.putExtra("IsLogged", new Boolean(true));
                        startActivity(intent);
                    }else {
                        Toast.makeText(getActivity(),"Invalid Credentials!",Toast.LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getActivity(),"Login Failed!",Toast.LENGTH_LONG).show();
                    System.err.println(e);
                }

            }
        });
        return view;
    }
}

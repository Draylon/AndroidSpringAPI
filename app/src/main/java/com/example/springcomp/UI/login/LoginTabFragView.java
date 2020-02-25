package com.example.springcomp.UI.login;

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
import com.example.springcomp.R;
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
        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(),"LoginFrag selected",Toast.LENGTH_LONG).show();
                TextView username = view.findViewById(R.id.loginUsername);
                TextView password = view.findViewById(R.id.loginPassword);
                String unString = (String) username.getText();
                String pwString = (String) password.getText();
                ApiDataLink.setUserData(unString,pwString);
                HashMap loginStatus = ApiDataLink.attemptLogin();
                UserLoginResponseDTO loginResponse = new Gson().fromJson(loginStatus.get("response"), UserLoginResponseDTO.class);
                if(loginResponse.getValidCredentials()) {
                    Toast.makeText(getActivity(), "Logged In successfully",Toast.LENGTH_LONG);
                    ApiDataLink.getLocalData().setHash(loginResponse.getHash());
                }else {
                    Toast.makeText(getActivity(),"Invalid Credentials!",Toast.LENGTH_LONG);
                }

            }
        });
        return view;
    }
}

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
import com.example.springcomp.api.dtos.UserResponseDTO;
import com.example.springcomp.entities.User;
import com.example.springcomp.enums.UserTypeEnum;
import com.example.springcomp.socketService.ApiDataLink;
import com.google.android.material.tabs.TabItem;

import java.util.HashMap;

public class SignupTabFragView extends Fragment {

    Button signupButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.signuptab_fragview,container,false);
        signupButton = view.findViewById(R.id.signupButton);
        signupButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(),"SignupFrag selected",Toast.LENGTH_LONG).show();
                TextView username = view.findViewById(R.id.signupUsername);
                TextView password = view.findViewById(R.id.signupPassword);
                TextView address = view.findViewById(R.id.signupPassword);
                TextView email = view.findViewById(R.id.signupPassword);
                TextView phone = view.findViewById(R.id.signupPassword);
                TextView user = view.findViewById(R.id.signupPassword);
                String unString = (String) username.getText();
                String pwString = (String) password.getText();
                String adString = (String) address.getText();
                String emString = (String) email.getText();
                String phString = (String) phone.getText();
                String usString = (String) user.getText();

                //====================================================================
                ApiDataLink.setUserData(unString,phString,emString,pwString,adString, UserTypeEnum.valueOf(usString));
                HashMap signupStatus = ApiDataLink.attemptSignup();
                String signupResponse = (String) signupStatus.get("response");
                if(signupResponse == "registrado") {
                    Toast.makeText(getActivity(), "Usuário Registrado!", Toast.LENGTH_LONG);
                    TabItem clicktab = view.findViewById(R.id.loginTab);
                    clicktab.callOnClick();
                    TextView luser = view.findViewById(R.id.loginUsername);
                    TextView lpw = view.findViewById(R.id.loginPassword);
                    luser.setText(unString);
                    lpw.setText(pwString);
                }else Toast.makeText(getActivity(),"Usuário Não Registrado: "+signupResponse,Toast.LENGTH_LONG);
            }
        });
        return view;
    }
}

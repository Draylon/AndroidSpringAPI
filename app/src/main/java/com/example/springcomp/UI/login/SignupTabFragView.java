package com.example.springcomp.UI.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
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
import com.google.gson.Gson;

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
                TextView address = view.findViewById(R.id.signupAdress);
                TextView email = view.findViewById(R.id.signupEmail);
                TextView phone = view.findViewById(R.id.signupPhone);
                RadioGroup userType = view.findViewById(R.id.signupUserType);
                String unString = username.getText().toString();
                String pwString = password.getText().toString();
                String adString = address.getText().toString();
                String emString = email.getText().toString();
                String phString = phone.getText().toString();
                UserTypeEnum utString;
                if(userType.getCheckedRadioButtonId() == R.id.signupRadio1)
                    utString = UserTypeEnum.CLIENT;
                else
                    utString=UserTypeEnum.VENDOR;

                //====================================================================
                ApiDataLink.setUserData(unString,phString,emString,pwString,adString, utString);
                try{
                    HashMap signupStatus = ApiDataLink.attemptSignup();
                    String signupResponse = (String) signupStatus.get("response");
                    UserResponseDTO userResponse = new Gson().fromJson(signupResponse,UserResponseDTO.class);
                    if(userResponse.getEmail().contentEquals(emString) && userResponse.getName().contentEquals(unString)) {
                        Toast.makeText(getActivity(), "Usuário Registrado!", Toast.LENGTH_LONG).show();
                        TabItem clicktab = view.findViewById(R.id.loginTab);
                        clicktab.callOnClick();
                        TextView luser = view.findViewById(R.id.loginUsername);
                        TextView lpw = view.findViewById(R.id.loginPassword);
                        luser.setText(unString);
                        lpw.setText(pwString);
                    }else Toast.makeText(getActivity(),"Usuário Não Registrado: "+signupResponse,Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Toast.makeText(getActivity(),"Signup Failed!",Toast.LENGTH_LONG).show();
                    System.err.println(e);
                }
            }
        });
        return view;
    }
}

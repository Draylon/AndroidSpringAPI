package com.example.springcomp.UI.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.springcomp.R;

public class SignupTabFragView extends Fragment {

    Button signupButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.signuptab_fragview,container,false);
        signupButton = view.findViewById(R.id.signupButton);
        signupButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"SignupFrag selected",Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}

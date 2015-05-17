package com.example.fragmtofragmasiwant;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Eugen-HP on 17.05.2015.
 */
public class Fragment2 extends Fragment {
    OnLatLngSent onLatLngSent;

    @Override
    public void onAttach(Activity activity) {
       try {
           onLatLngSent = (OnLatLngSent)activity;
       }
       catch (ClassCastException e){
           throw  new ClassCastException(activity.toString()+" must implement OnLatLngSent");
       }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment2, container, false);
        final EditText etLat = (EditText)v.findViewById(R.id.etLat);
        final EditText etLng = (EditText)v.findViewById(R.id.etLng);
        Button btnAccept = (Button)v.findViewById(R.id.btnAccept);
        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLatLngSent.onCoordSend(etLat.getText().toString(),etLng.getText().toString());
                Log.d("Fragment2", "onAcceptClicked()");

            }
        });
        return v;
    }
}

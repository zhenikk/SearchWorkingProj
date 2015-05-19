package com.example.uni_bit.fragmenttofragmentcomunication;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Uni-Bit on 14.05.2015.
 */public class Fragment1 extends Fragment {
    OnFragmentSendText mSendText;
    String send_text;
    EditText text;


    public Fragment1(){
    }

    public void onAttach(Activity activity){
        Log.d("Fragment1","OnAttach()");
        super.onAttach(activity);
        try{
            mSendText = (OnFragmentSendText)activity;
        } catch(ClassCastException e){
            throw new ClassCastException(activity.toString() + " must implement OnFragmentSendText");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.frag1_layout, container, false);
        Log.d("Fragment1","OnCreateView()");
        text = (EditText)v.findViewById(R.id.input);
        Button b = (Button)v.findViewById(R.id.send);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send_text = text.getText().toString();
                Log.d("Fragment1","onClicked()");
                mSendText.onSentText(send_text);
            }
        });
        return v;
    }
}
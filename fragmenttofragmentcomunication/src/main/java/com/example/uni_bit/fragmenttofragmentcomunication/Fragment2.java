package com.example.uni_bit.fragmenttofragmentcomunication;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Uni-Bit on 14.05.2015.
 */
public class Fragment2 extends Fragment{
    private static final String LOG_TAG = "Tag" ;
    FragmentTransaction ft;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frag2_layout,null);
        return v;
    }
    public void setText(String item) {
    }
}

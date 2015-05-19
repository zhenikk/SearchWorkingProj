package com.example.fragmtofragmasiwant;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.awt.font.TextAttribute;

/*
* Created by Eugen-HP on 17.05.2015.
 */
public class Fragment1 extends Fragment {
    TextView tv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1, container, false);
        Button openNewFragm = (Button)v.findViewById(R.id.btnOpenNext);
        tv = (TextView)v.findViewById(R.id.tvResult);
       // setTextView("text");

        Log.d("Fragment1","On CreateView");
      /*  Bundle b = new Bundle();

        String lat = b.getString("lat");
        String lng = b.getString("lng");
        setTextView("Lat: "+lat + " Lng: "+lng);
*/
        openNewFragm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment2 fr2 = new Fragment2();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container,fr2,"fragment2");
               // ft.addToBackStack(null);
                ft.commit();
            }
        });



        return v;
    }

   public void setTextView(final String s){
       if(tv!=null){
           Log.d("setTextView","tv "+ s);
        tv.setText(s);
       }
       else  Log.d("setTextView","tv is NULL");
    }
}

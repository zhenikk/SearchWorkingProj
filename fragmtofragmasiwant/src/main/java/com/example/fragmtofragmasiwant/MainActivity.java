package com.example.fragmtofragmasiwant;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class MainActivity extends Activity implements OnLatLngSent {

    Fragment1 fragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("MainActivity","OnCreate()");
       if(savedInstanceState!=null){
           Log.d("MainActivity","savedInstance!=null");
           fragment1 = (Fragment1)getFragmentManager().getFragment(savedInstanceState,"mContent");
       }
        else
       {Log.d("MainActivity","savedInstance isNull");
           fragment1 =  new Fragment1();
       }


        setContentView(R.layout.activity_main);
        getFragmentManager().beginTransaction()
                .replace(R.id.container,fragment1,"fragment1")
                .commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("MainActivity", "onSaveInstenceState()");
        getFragmentManager().putFragment(outState,"mContent",fragment1);

    }

    @Override
    public void onCoordSend(String lat, String lng) {
        Log.d("MainActivity","onCoordSend()");
        fragment1 = (Fragment1) getFragmentManager().findFragmentByTag("fragment1");
        Bundle args = new Bundle();
        args.putString("lat",lat);
        args.putString("lng", lng);

        if(fragment1!=null) {
            Log.d("MainActivity", "Fragment1 - NotNull SetTextView");

            FragmentTransaction ft = getFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment1);
            fragment1.setTextView("Lat: " + lat + ", Lng: " + lng);
            ft.commit();

        }
        else {
            Log.d("MainActivity", "Fragment1 - ISNull");

            if(lat!=null&&lng!=null){
            Fragment1 fr1 = new Fragment1();

            fr1.setArguments(args);
            getFragmentManager().beginTransaction()
                    .replace(R.id.container,fr1).commit();
                Log.d("Result","Lat: "+lat+", Lng: "+lng);
          fr1.setTextView("Lat: "+lat+" Lng: "+lng);}

        }
    }
}

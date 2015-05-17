package com.example.fragmtofragmasiwant;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;


public class MainActivity extends Activity implements OnLatLngSent {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFragmentManager().beginTransaction()
                .replace(R.id.container, new Fragment1(),"fragment1")
                .commit();

    }

    @Override
    public void onCoordSend(String lat, String lng) {
        Fragment1 fragment1 = (Fragment1) getFragmentManager().findFragmentByTag("fragment1");
        if(fragment1!=null){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container,fragment1).commit();
                  fragment1.setTextView("Lat: "+lat+", Lng: "+lng);}
        else {
            Fragment1 fr1 = new Fragment1();
            Bundle args = new Bundle();
//            args.putString("lat",lat);
//            args.putString("lng",lng);
//            fr1.setArguments(args);
            getFragmentManager().beginTransaction()
                    .replace(R.id.container,fr1).commit();
            fr1.setTextView("Lat: "+lat+", Lng: "+lng);

        }
    }
}

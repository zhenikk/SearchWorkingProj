package com.example.uni_bit.fragmenttofragmentcomunication;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;


public class MainActivity extends Activity implements Fragment1.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment1 fragment1= new Fragment1();

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.main_container,fragment1);
        ft.commit();


        }


    @Override
    public void onFragmentInteraction(String link) {


    }
}

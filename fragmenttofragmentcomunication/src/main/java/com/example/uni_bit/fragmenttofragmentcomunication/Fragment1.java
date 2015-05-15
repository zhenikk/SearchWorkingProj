package com.example.uni_bit.fragmenttofragmentcomunication;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Uni-Bit on 14.05.2015.
 */
public class Fragment1 extends Fragment {
    private static final String LOG_TAG = "Tag" ;
    private OnFragmentInteractionListener mListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mListener = (OnFragmentInteractionListener)activity;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString()+" must implement interface OnFragmentInteractionListener");
        }
    }
    public void updateDetail() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frag1_layout,null);
        Button btn = (Button)v.findViewById(R.id.update_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment2 fragment2 = new Fragment2();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main_container,fragment2);
                ft.addToBackStack(null);
                ft.commit();
                Log.d(LOG_TAG, "Button click in Fragment1");
            }
        });
        return v;
    }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(String link);
    }
}

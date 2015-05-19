package com.example.uni_bit.fragmenttofragmentcomunication;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends Activity implements OnFragmentSendText {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            if (savedInstanceState == null) {
                getFragmentManager().beginTransaction()
                        .add(R.id.container, new Fragment1())
                        .commit();
            }
        }
        else {
            if (savedInstanceState == null) {
                getFragmentManager().beginTransaction()
                        .add(R.id.container, new Fragment1())
                        .commit();
                getFragmentManager().beginTransaction()
                        .add(R.id.container2, new Fragment2(), "fragment2")
                        .commit();
            }
        }

    }

    @Override
    public void onSentText(String text) {
        Log.d("Main","onSentText overriden "+text);
        Fragment2 fragment_2 = (Fragment2) getFragmentManager().findFragmentByTag("fragment2");
        if (fragment_2 != null) {
            Log.d("MainActivity", "Fragment2-NotNull SetTextView");
            fragment_2.setText(text);
        } else {
            Log.d("MainActivity", "Fragment2 - Null Create new");
            Fragment2 fragment = new Fragment2();
            Bundle args = new Bundle();
            args.putString("text", text);
            fragment.setArguments(args);
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .addToBackStack(null).commit();
            fragment.sentText();
        }

    }

}


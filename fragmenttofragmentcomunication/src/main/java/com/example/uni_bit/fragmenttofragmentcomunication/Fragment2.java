package com.example.uni_bit.fragmenttofragmentcomunication;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.AsyncTask;
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
    TextView text;
    String stringtext;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.frag2_layout, container, false);
        text = (TextView)v.findViewById(R.id.sent_text);
        return v;
    }

    public void setText(final String string){
        text.setText(string);
    }

    public void sentText(){
        Log.d("Fragment2","sentText()");
        new MyTask().execute();

    }

    private class MyTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            Bundle b = getArguments();
            stringtext = b.getString("text");
            return null;
        }

        protected void onPostExecute(String result){
            setText(stringtext);
        }
    }
}

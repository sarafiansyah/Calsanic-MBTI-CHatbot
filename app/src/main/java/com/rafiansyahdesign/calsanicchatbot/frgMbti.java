package com.rafiansyahdesign.calsanicchatbot;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.rafiansyahdesign.calsanicchatbot.mbti.MainActivity;

public class frgMbti extends Fragment {



    public frgMbti(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_mbti, container, false);

        final Button buttonTakeTest = (Button) rootView.findViewById(R.id.btntaketest);

        buttonTakeTest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentTakeTest;
                intentTakeTest = new Intent(getActivity(), MainActivity.class);
                startActivity(intentTakeTest);
            }
        });

        return rootView;

    }
}

package com.rafiansyahdesign.calsanicchatbot;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class frgChatbot extends Fragment {



    public frgChatbot(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_chatbot, container, false);

        final Button buttonChatgpt = (Button) rootView.findViewById(R.id.btn_chatgpt);
        final Button buttonBrainshop = (Button) rootView.findViewById(R.id.btn_brainshop);

        buttonChatgpt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentChatgpt;
                intentChatgpt = new Intent(getActivity(), ChatGPTBot.class);
                startActivity(intentChatgpt);
            }
        });
        buttonBrainshop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentBrainshop;
                intentBrainshop = new Intent(getActivity(), BrainshopBot.class);
                startActivity(intentBrainshop);
            }
        });

        return rootView;

    }
}

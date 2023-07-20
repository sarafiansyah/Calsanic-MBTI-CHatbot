package com.rafiansyahdesign.calsanicchatbot;

import com.smarteist.autoimageslider.SliderView;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class frgHome extends Fragment {

    Intent intent;

    String url1 = "https://bizzbucket.co/wp-content/uploads/2020/08/Life-in-The-Metro-Blog-Title-22.png";
    String url2 = "https://bizzbucket.co/wp-content/uploads/2020/08/Life-in-The-Metro-Blog-Title-22.png";
    String url3 = "https://bizzbucket.co/wp-content/uploads/2020/08/Life-in-The-Metro-Blog-Title-22.png";



    public frgHome(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

            // Urls of our images.

                // we are creating array list for storing our image urls.
                ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

                // initializing the slider view.
                SliderView sliderView = rootView.findViewById(R.id.slider);

                // adding the urls inside array list
                sliderDataArrayList.add(new SliderData(url1));
                sliderDataArrayList.add(new SliderData(url2));
                sliderDataArrayList.add(new SliderData(url3));

                // passing this array list inside our adapter class.
                SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);

                // below method is used to set auto cycle direction in left to
                // right direction you can change according to requirement.
                sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

                // below method is used to
                // setadapter to sliderview.
                sliderView.setSliderAdapter(adapter);

                // below method is use to set
                // scroll time in seconds.
                sliderView.setScrollTimeInSec(3);

                // to set it scrollable automatically
                // we use below method.
                sliderView.setAutoCycle(true);

                // to start autocycle below method is used.
                sliderView.startAutoCycle();

        intent = new Intent(getActivity(), content_01.class);
        final Button button = (Button) rootView.findViewById(R.id.btn_content01);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent);
            }
        });



        return rootView;
    }

    }


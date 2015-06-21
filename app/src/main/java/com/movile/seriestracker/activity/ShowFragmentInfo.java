package com.movile.seriestracker.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.movile.seriestracker.R;

/**
 * Created by movile on 21/06/15.
 */
public class ShowFragmentInfo extends Fragment {


    public static final String EXTRA_SHOW = "show";


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.show_fragment_info,container);
        return view;

    }



}

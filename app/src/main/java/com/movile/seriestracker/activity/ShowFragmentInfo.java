package com.movile.seriestracker.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.movile.seriestracker.R;

import model.Show;

/**
 * Created by movile on 21/06/15.
 */
public class ShowFragmentInfo extends Fragment {


    public static final String EXTRA_SHOW = "show";
    private TextView summary;


    @Override
    public void onResume (){
        super.onResume();
        Bundle data = getArguments();
        if(data != null){
            Show result=(Show)data.getSerializable(this.EXTRA_SHOW);
            summary.setText(result.overview());

        }



    }




    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.show_fragment_info,null);
        summary=(TextView)view.findViewById(R.id.cardview_show_summary);
        return view;

    }



}

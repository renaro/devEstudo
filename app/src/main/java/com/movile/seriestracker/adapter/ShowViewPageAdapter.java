package com.movile.seriestracker.adapter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.movile.seriestracker.activity.ShowFragmentInfo;
import com.movile.seriestracker.activity.ShowFragmentSeasons;

import model.Show;

/**
 * Created by movile on 21/06/15.
 */
public class ShowViewPageAdapter extends FragmentPagerAdapter {

    public static int POSITION_INFO=0;
    public static int POSITION_SEASONS=1;
    private Show mShow;

    public ShowViewPageAdapter(FragmentManager fragmentManager,Show show) {
        super(fragmentManager);
        mShow=show;

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment =  new Fragment();
        Bundle arg = new Bundle();

        if(position == POSITION_INFO){
            arg.putSerializable(ShowFragmentInfo.EXTRA_SHOW,mShow);
            fragment = new ShowFragmentInfo();
            fragment.setArguments(arg);

        }
        if(position == POSITION_SEASONS){
            arg.putString(ShowFragmentSeasons.EXTRA_SHOW, mShow.ids().slug());
            fragment = new ShowFragmentSeasons();
            fragment.setArguments(arg);

        }

        return fragment;


    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == POSITION_SEASONS){
            return "SEASONS";
        }
        if(position == POSITION_INFO){
            return "INFO";
        }
        return "";
    }



}

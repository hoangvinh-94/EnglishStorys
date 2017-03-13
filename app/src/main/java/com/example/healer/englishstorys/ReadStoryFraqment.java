package com.example.healer.englishstorys;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.RelativeLayout;


/**
 * Created by Healer on 21-Feb-17.
 */

public class ReadStoryFraqment extends Fragment{
    BottomSheetBehavior bottomSheetBehavior;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle BundlesavedInstanceState){
        View rootView = inflater.inflate(R.layout.readstory_tab,container,false);
        View bottomSheet = rootView.findViewById(R.id.audioBar);
        bottomSheetBehavior = BottomSheetBehavior.from((View) bottomSheet);
        bottomSheetBehavior.setPeekHeight(0);
        RelativeLayout layout_story = (RelativeLayout) rootView.findViewById(R.id.layout_story);

        layout_story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
                else {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
                Log.d("vinh1","vinh1");
            }
        });
        return rootView;
    }
}

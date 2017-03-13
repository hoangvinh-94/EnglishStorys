package com.example.healer.englishstorys;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.BottomSheetBehavior;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

/**
 * Created by Healer on 21-Feb-17.
 */

public class ReadStoryFraqment extends Fragment implements View.OnTouchListener{
    private BottomSheetBehavior audioBar;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle BundlesavedInstanceState){
        View rootView = inflater.inflate(R.layout.readstory_tab,container,false);
        View BottomSheet_AudioBar = rootView.findViewById(R.id.bottomsheet_audio);
        audioBar  = BottomSheetBehavior.from(BottomSheet_AudioBar);
        return rootView;
    }
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if(action == motionEvent.ACTION_DOWN){
            Log.d("vinh","vinh");
            if(audioBar.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                audioBar.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
            else {
                audioBar.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
            return true;
        }
        if(action == motionEvent.ACTION_UP){
            Log.d("vinh1","vinh1");
        }
        return false;
    }
}

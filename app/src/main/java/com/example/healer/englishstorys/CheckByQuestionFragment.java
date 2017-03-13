package com.example.healer.englishstorys;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

/**
 * Created by Healer on 21-Feb-17.
 */

public class CheckByQuestionFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle BundlesavedInstanceState){
        View rootView = inflater.inflate(R.layout.checkbyquestion_tab,container,false);
        return rootView;
    }
}

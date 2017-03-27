package com.example.healer.englishstorys;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static com.example.healer.englishstorys.ListStoryActivity.*;
import static com.example.healer.englishstorys.MainActivity.*;


/**
 * Created by Healer on 21-Feb-17.
 */

public class ReadStoryFraqment extends Fragment{
    BottomSheetBehavior bottomSheetBehavior;
    public static ImageButton btnPlay,btnStop,btnRwind, btnForward;
    public static TextView audioCurrentDurationLabel,
            audioTotalDurationLabel;
    TextView content;

    public static SeekBar sb;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle BundlesavedInstanceState){
        View rootView = inflater.inflate(R.layout.readstory_tab,container,false);
        View bottomSheet = rootView.findViewById(R.id.audioBar);
        btnPlay = (ImageButton) rootView.findViewById(R.id.imgPlay);
        btnForward = (ImageButton) rootView.findViewById(R.id.imgForward);
        btnRwind = (ImageButton) rootView.findViewById(R.id.imgRewind);
        btnStop = (ImageButton) rootView.findViewById(R.id.imgStop);
        sb = (SeekBar) rootView.findViewById(R.id.seekbar);
        audioCurrentDurationLabel = (TextView) rootView.findViewById(R.id.labelStart);
        audioTotalDurationLabel = (TextView) rootView.findViewById(R.id.labelEnd);
        bottomSheetBehavior = BottomSheetBehavior.from((View) bottomSheet);
        bottomSheetBehavior.setPeekHeight(0);
        LinearLayout layout_story = (LinearLayout) rootView.findViewById(R.id.layout_story);
        TextView titleStory = (TextView) rootView.findViewById(R.id.txt_Title);
        ImageView picture =(ImageView) rootView.findViewById(R.id.img_Picture);
        titleStory.setText(ListStoryActivity.arrStory.get(MainActivity.position).getTitle());
        content = (TextView) rootView.findViewById(R.id.content_story);

        //content.setText(arrStory.get(position).getContentStory());
        layout_story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

                }
                else {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });
        //readData(R.raw.test1);
        return rootView;
    }
     public void readData(int key)
    {
        String data;
        InputStream in= getResources()
                .openRawResource(key);
        InputStreamReader inreader=new InputStreamReader(in);
        BufferedReader bufreader=new BufferedReader(inreader);
        StringBuilder builder=new StringBuilder();
        if(in!=null)
        {
            try{
                while((data=bufreader.readLine())!=null)
                {
                    builder.append(data);
                    builder.append("\n");
                }
                in.close();
                content.setText(builder.toString());
            }
            catch(IOException ex){
                Log.e("ERROR", ex.getMessage());
            }
        }
    }

}

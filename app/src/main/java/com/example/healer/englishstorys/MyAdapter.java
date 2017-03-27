package com.example.healer.englishstorys;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Healer on 20-Feb-17.
 */

public class MyAdapter extends ArrayAdapter<Story> {
    Activity context;
    int layoutId;
    ArrayList<Story> arr=null;

    public MyAdapter(Activity context, int layoutId, ArrayList<Story> list) {
        super(context, layoutId,list);
        this.context = context;
        this.arr = list;
        this.layoutId = layoutId;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater = context.getLayoutInflater();
            convertView=inflater.inflate(layoutId,null);
        }
        final Story story = arr.get(position);
        ImageView imageTitle = (ImageView) convertView.findViewById(R.id.imgTitle);
        TextView textTitle = (TextView)convertView.findViewById(R.id.txtTitle);
        LinearLayout layoutTitle=(LinearLayout)convertView.findViewById(R.id.layoutTitle);
        imageTitle.setImageURI(Uri.parse(story.getImage()));
        textTitle.setText(story.getTitle());

        final Intent intent = new Intent(this.context,MainActivity.class);
        final Intent intentService = new Intent(this.context,MyService.class);
        intent.putExtra("url",story.getLinkAudio());
        intent.putExtra("position",position);


        imageTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //context.startService(intentService);
                getContext().startActivity(intent);
            }
        });
        textTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //context.startService(intentService);
                getContext().startActivity(intent);
            }
        });
        layoutTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //context.startService(intentService);
                getContext().startActivity(intent);

                          }
        });
        return convertView;
    }
}

package com.example.healer.englishstorys;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ListStoryActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private MyAdapter storyAdapter=null;
    public static ArrayList<Story> arrStory = null;
    GridView gridView =  null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
         arrStory = new ArrayList<Story>();
        storyAdapter = new MyAdapter(this, R.layout.custom_girdview,arrStory);
        //arrStory.add(new Story("android.resource://com.example.danhvangame/drawable/buoi","Chúa Tể Những Chiếc Nhẫn","android.resource://com.example.danhvangame/raw/emlabanoicuaanh"));
        try {
            arrStory=readData(R.raw.test);

        } catch (IOException e) {
            e.printStackTrace();
        }
        gridView = (GridView)findViewById(R.id.gridview);
        gridView.setAdapter(storyAdapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    public ArrayList<Story> readData(int key) throws IOException {
        ArrayList<Story> ArrayStory = null;
        FileReader fr = new FileReader(String.valueOf(key));
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        StringBuilder builder = new StringBuilder();
        Log.d("vinh","vinh");
        if(br.readLine() == null){
            System.out.println("No data");
        }
        else{

            fr = new FileReader(String.valueOf(key));
            br = new BufferedReader(fr);
            while((line = br.readLine()).equals(""));
            int n = Integer.parseInt(line);

            for(int i=0;i<n;i++){
                Story story = new Story();
                while((line = br.readLine()).equals(""));
                story.setTitle(line);
/*
                while(!(line = br.readLine()).equals("")){
                    builder.append(line);
                    builder.append("\n");
                }
                story.setContentStory(builder.toString());

                while(!(line = br.readLine()).equals("")){
                    builder.append(line);
                    builder.append("\n");
                }
                story.setContentTranslate(builder.toString());

                while((line = br.readLine()).equals(""));
                int n1 = Integer.parseInt(line);
                Vocabulary vocabulary = new Vocabulary();
                ArrayList<Vocabulary> arrVocabulary = new ArrayList<Vocabulary>();
                String[] str = null;
                while(!(line = br.readLine()).equals("")){
                    str = line.split(" ");
                    vocabulary.setEnglishWord(str[0]);
                    vocabulary.setVietnamWord(str[1]);
                    arrVocabulary.add(vocabulary);
                }
                story.setVocabulary(arrVocabulary);

                CheckKnowledge checkKnowledge = new CheckKnowledge();
                ArrayList<CheckKnowledge> arrCheckKnowledge = new ArrayList<CheckKnowledge>();
                str = null;
                while(!(line = br.readLine()).equals("")){
                    str = line.split(" ");
                    checkKnowledge.setQuestion(str[0]);
                    checkKnowledge.setAnswer(str[1]);
                    arrCheckKnowledge.add(checkKnowledge);
                }
                story.setCheckKnowledges(arrCheckKnowledge);
*/
                ArrayStory.add(story);
            }
        }
        return ArrayStory;
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

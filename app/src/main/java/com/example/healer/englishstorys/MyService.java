package com.example.healer.englishstorys;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;


public class MyService extends Service implements OnCompletionListener,
        OnClickListener,OnSeekBarChangeListener {
    MediaPlayer mp = null;
    private WeakReference<ImageButton> imgbPlay, imgbStop,imgbRewind, imgbForward;
    private WeakReference<TextView> audioCurrentDurationLabel;
    private WeakReference<TextView> audioTotalDurationLabel;
    private WeakReference<SeekBar> audioProgressBar;
    public static int currentSongIndex = -1;
    ArrayList<Story> storys=null;
    int audioPos, audioMax,position;
    String url;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        //mp = MediaPlayer.create(this,R.raw.emlabanoicuaanh);
        Log.d("Player Service", "Pause");
        mp = new MediaPlayer();
        mp.setVolume(100,100);
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        Log.d("Player Service", "Pause");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        url =  intent.getStringExtra("url");
        position = intent.getIntExtra("position",-1);
        storys = ListStoryActivity.arrStory;
       // Log.d("Pvd", url+position+" "+storys.get(position).getLinkAudio());
        initUI();
        try {
            Play(position);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        if (mp.isPlaying()) {
            mp.stop();
        }
        mp.release();
    }
    public void initUI(){
        imgbPlay = new WeakReference<ImageButton>(ReadStoryFraqment.btnPlay);
        imgbStop = new WeakReference<ImageButton>(ReadStoryFraqment.btnStop);
        imgbRewind = new WeakReference<ImageButton>(ReadStoryFraqment.btnRwind);
        imgbForward = new WeakReference<ImageButton>(ReadStoryFraqment.btnForward);
        audioCurrentDurationLabel = new WeakReference<TextView>(ReadStoryFraqment.audioCurrentDurationLabel);
        audioTotalDurationLabel = new WeakReference<TextView>(ReadStoryFraqment.audioTotalDurationLabel);
        audioProgressBar = new WeakReference<SeekBar>(ReadStoryFraqment.sb);


        // set listening event
        imgbPlay.get().setOnClickListener(this);
        imgbStop.get().setOnClickListener(this);
        imgbRewind.get().setOnClickListener(this);
        imgbForward.get().setOnClickListener(this);
        audioProgressBar.get().setOnSeekBarChangeListener(this);
    }
    private void Play(int position) throws IOException {
        mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
       // mp.setDataSource(storys.get(position).getLinkAudio());
        mp.setDataSource(getApplicationContext(), Uri.parse(storys.get(position).getLinkAudio()));
        mp.prepare();
        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                imgbPlay.get().setImageResource(R.drawable.pause);
                audioPos = mp.getCurrentPosition();
                audioMax = mp.getDuration();
                audioProgressBar.get().setMax(audioMax);
                audioProgressBar.get().setProgress(audioPos);
                mp.start();
            }
        });
    }


    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgPlay:
                if (currentSongIndex == -1) {
                    if (mp.isPlaying()) {
                        if (mp != null) {
                            mp.pause();
                            // Changing button image to play button
                            imgbPlay.get()
                                    .setImageResource(R.drawable.play);
                            Log.d("Player Service", "Pause");
                        }
                    } else {
                        // Resume song
                        if (mp != null) {
                            //mp.start();
                            try {
                                Play(storys.size());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            // Changing button image to pause button
                            imgbPlay.get().setImageResource(
                                    R.drawable.pause);
                            Log.d("Player Service", "Play");
                        }
                    }
                }
                break;
            case R.id.imgForward:
                // check if next song is there or not
                Log.d("Player Service", "Forward");
               /* if (currentSongIndex < (arrSong.size() - 1)) {
                    playSong(currentSongIndex + 1);
                    currentSongIndex = currentSongIndex + 1;
                } else {
                    // play first song
                    playSong(0);
                    currentSongIndex = 0;
                }*/
                break;
            case R.id.imgRewind:
                Log.d("Player Service", "Rewind");
               /* if (currentSongIndex > 0) {
                    playSong(currentSongIndex - 1);
                    currentSongIndex = currentSongIndex - 1;
                } else {
                    // play last song
                    playSong(arrSong.size() - 1);
                    currentSongIndex = arrSong.size() - 1;
                }*/
                break;
            default:break;

        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
        if (fromUser && mp.isPlaying()) {
            mp.seekTo(progress);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}

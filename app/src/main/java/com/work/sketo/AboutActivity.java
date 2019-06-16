package com.work.sketo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class AboutActivity extends YouTubeBaseActivity {
    private static final String TAG ="AboutActivity";                                            //extends YouTubeBaseActivity instead of AppCompatActivity

    WebView myWebView;


    YouTubePlayerView mYouTubePlayerView;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("file:///android_asset/aboutus.html");                                    //local address of html file

        Log.d(TAG, "onCreate: Starting.");
        mYouTubePlayerView = (YouTubePlayerView)findViewById(R.id.ytubePlay);

        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "onClick: Done Initializing.");

                youTubePlayer.loadVideo("juHoJYX86Dg");                                          //load single video

/*
                List<String> videoList = new ArrayList<>();                                         //load multiple videos
                videoList.add("juHoJYX86Dg");
                videoList.add("juHoJYX86Dg");
                videoList.add("juHoJYX86Dg");
                youTubePlayer.loadVideos(videoList);

                youTubePlayer.loadPlaylist("PLgCYzUzKIBE-eHpqt44Ea-Mi_iAUkpOdq");                //load a playlist
*/
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onClick: Failed to Initialize.");
            }
        };

        mYouTubePlayerView.initialize(YouTubeConfig.getAPI_key(),mOnInitializedListener);           //onCreate play youtube video

/*
        mYouTubePlayerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Initializing YouTube Player.");
                mYouTubePlayerView.initialize(YouTubeConfig.getAPI_key(),mOnInitializedListener);   //play youtube video
            }
        });
*/

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
/*         Enables regular immersive mode.
         For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
         Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY*/
        View splashView = getWindow().getDecorView();
        splashView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
/*                         Set the content to appear under the system bars so that the
                         content doesn't resize when the system bars hide and show.*/
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }
}

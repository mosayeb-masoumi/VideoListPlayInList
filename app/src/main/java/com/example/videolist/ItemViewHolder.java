package com.example.videolist;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.danikula.videocache.HttpProxyCacheServer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import static android.view.View.GONE;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    SimpleExoPlayer exoPlayer;
    PlayerView playerView;

    RelativeLayout root;
    ProgressBar progressBar;

    ImageView img_cover;


    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);

        root = itemView.findViewById(R.id.root);
        playerView= itemView.findViewById(R.id.exoplayerView);
        progressBar = itemView.findViewById(R.id.progressbar);
        img_cover = itemView.findViewById(R.id.img_cover);


    }

    public void bindData(String url, int position) {


//        root.setOnClickListener(view -> {
//
//            exoPlayer = ExoPlayerFactory.newSimpleInstance(itemView.getContext());
//
//
//            HttpProxyCacheServer proxyServer = new HttpProxyCacheServer.Builder(itemView.getContext()).maxCacheSize(1024 * 1024 * 1024).build();
//            String proxyURL = proxyServer.getProxyUrl(url);
//
//            DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(itemView.getContext(),
//                    Util.getUserAgent(itemView.getContext(), itemView.getContext().getPackageName()));
//
////            playerView.setPlayer(exoPlayer);
////            playerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FIT);
////        playerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FIXED_HEIGHT);
//
//            exoPlayer.prepare(new ProgressiveMediaSource.Factory(dataSourceFactory)
//                    .createMediaSource(Uri.parse(proxyURL)));
//
//
//            playerView.setPlayer(exoPlayer);
//            playerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FIXED_HEIGHT);
//            exoPlayer.setPlayWhenReady(true);
////            exoPlayer.getPlaybackState();  to start video again while finished
//
//
//            exoPlayer.addListener(new Player.EventListener() {
//                @Override
//                public void onTimelineChanged(Timeline timeline, @Nullable Object manifest, int reason) {
//
//                }
//
//                @Override
//                public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {
//
//                }
//
//                @Override
//                public void onLoadingChanged(boolean isLoading) {
//
//                    if(isLoading){
//                        progressBar.setVisibility(View.VISIBLE);
//                    }else{
//
//                        progressBar.setVisibility(GONE);
//                    }
//                }
//
//                @Override
//                public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
//                    switch (playbackState) {
//
//                        case Player.STATE_BUFFERING:
//
//                            if (progressBar != null) {
//                                progressBar.setVisibility(View.VISIBLE);
//                            }
//
//                            break;
//                        case Player.STATE_ENDED:
//                            Log.d("TAG", "onPlayerStateChanged: Video ended.");
//                            exoPlayer.seekTo(0);
//                            break;
//                        case Player.STATE_IDLE:
//
//                            break;
//                        case Player.STATE_READY:
//                            Log.e("TAG", "onPlayerStateChanged: Ready to play.");
//                            if (progressBar != null) {
//                                img_cover.setVisibility(GONE);
//                                progressBar.setVisibility(GONE);
//                            }
////                                if(!isVideoViewAdded){
////                                    addVideoView();
////                                }
//                            break;
//                        default:
//                            break;
//                    }
//                }
//
//                @Override
//                public void onRepeatModeChanged(int repeatMode) {
//
//                }
//
//                @Override
//                public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {
//
//                }
//
//                @Override
//                public void onPlayerError(ExoPlaybackException error) {
//
//                }
//
//                @Override
//                public void onPositionDiscontinuity(int reason) {
//
//                }
//
//                @Override
//                public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
//
//                }
//
//                @Override
//                public void onSeekProcessed() {
//
//                }
//            });
//
//
//
//
//
//
//
//
//        });
    }

    public void setOnVideoItemHolderListener(VideoItemInteraction listener, String url, Context context, int position) {

        root.setOnClickListener(view -> {




            exoPlayer = ExoPlayerFactory.newSimpleInstance(itemView.getContext());

            HttpProxyCacheServer proxyServer = new HttpProxyCacheServer.Builder(itemView.getContext()).maxCacheSize(1024 * 1024 * 1024).build();
            String proxyURL = proxyServer.getProxyUrl(url);

            DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(itemView.getContext(),
                    Util.getUserAgent(itemView.getContext(), itemView.getContext().getPackageName()));


            exoPlayer.prepare(new ProgressiveMediaSource.Factory(dataSourceFactory)
                    .createMediaSource(Uri.parse(proxyURL)));


            playerView.setPlayer(exoPlayer);
            playerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FIXED_HEIGHT);
            exoPlayer.setPlayWhenReady(true);

//            exoPlayer.getPlaybackState();  to start video again while finished


            exoPlayer.addListener(new Player.EventListener() {
                @Override
                public void onTimelineChanged(Timeline timeline, @Nullable Object manifest, int reason) {

                }

                @Override
                public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {

                }

                @Override
                public void onLoadingChanged(boolean isLoading) {

                    if(isLoading){
                        progressBar.setVisibility(View.VISIBLE);
                    }else{

                        progressBar.setVisibility(GONE);
                    }
                }

                @Override
                public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                    switch (playbackState) {

                        case Player.STATE_BUFFERING:

                            if (progressBar != null) {
                                progressBar.setVisibility(View.VISIBLE);
                            }

                            break;
                        case Player.STATE_ENDED:
                            Log.d("TAG", "onPlayerStateChanged: Video ended.");
//                            exoPlayer.seekTo(0);
//                            exoPlayer.release();

                            break;
                        case Player.STATE_IDLE:

                            break;
                        case Player.STATE_READY:
                            Log.e("TAG", "onPlayerStateChanged: Ready to play.");
                            if (progressBar != null) {
                                img_cover.setVisibility(GONE);
                                progressBar.setVisibility(GONE);
                            }
//                                if(!isVideoViewAdded){
//                                    addVideoView();
//                                }
                            break;
                        default:
                            break;
                    }
                }

                @Override
                public void onRepeatModeChanged(int repeatMode) {

                }

                @Override
                public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {

                }

                @Override
                public void onPlayerError(ExoPlaybackException error) {

                }

                @Override
                public void onPositionDiscontinuity(int reason) {

                }

                @Override
                public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {

                }

                @Override
                public void onSeekProcessed() {

                }
            });








        });


    }
}

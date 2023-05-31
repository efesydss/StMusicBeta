package com.st.stmusic.entity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.google.android.exoplayer2.ExoPlayer;

public class NotificationPlayAction extends Service {
    PlayerService activeService = new PlayerService();

    public void play(Intent intent) {
        String action = (String) intent.getExtras().get("PLAYER");
        if (action.equals("PLAY")) {
            activeService.clickPlayFromPlayerActivity();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public NotificationPlayAction() {
        super();
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        play(intent);
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}


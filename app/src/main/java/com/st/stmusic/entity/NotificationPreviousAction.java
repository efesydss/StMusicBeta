package com.st.stmusic.entity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class NotificationPreviousAction extends Service {
    PlayerService activeService = new PlayerService();

    public void previous(Intent intent) {

        String action = (String) intent.getExtras().get("PLAYER");

        if (action.equals("PREVIOUS")) {
            activeService.previous();
            PlayerService.playerActivity.loadData(activeService.getPos());

        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        previous(intent);
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

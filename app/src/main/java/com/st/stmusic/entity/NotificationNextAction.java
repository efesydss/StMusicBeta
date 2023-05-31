package com.st.stmusic.entity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class NotificationNextAction extends Service {

    PlayerService activeService = new PlayerService();

    public void next(Intent intent) {
        String action = (String) intent.getExtras().get("PLAYER");
        if (action.equals("NEXT")) {
            activeService.next();
            PlayerService.setSituationNow(PlayerService.getSituationNow());
            PlayerService.playerActivity.loadData(activeService.getPos());
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        next(intent);
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

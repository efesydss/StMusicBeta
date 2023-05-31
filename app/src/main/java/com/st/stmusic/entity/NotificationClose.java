package com.st.stmusic.entity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class NotificationClose extends Service {
    PlayerService activeService = new PlayerService();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        activeService.shutdown();

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

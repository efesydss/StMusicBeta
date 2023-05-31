package com.st.stmusic;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RemoteViews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.st.stmusic.databinding.ActivityHomeBinding;
import com.st.stmusic.entity.MenuService;
import com.st.stmusic.entity.NotificationClose;
import com.st.stmusic.entity.NotificationNextAction;
import com.st.stmusic.entity.NotificationPlayAction;
import com.st.stmusic.entity.NotificationPreviousAction;
import com.st.stmusic.entity.PlayerService;
import com.st.stmusic.fragments.FavoritesFragment;
import com.st.stmusic.fragments.PlaylistFragment;
import com.st.stmusic.fragments.SongFragment;

import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity implements View.OnAttachStateChangeListener, MenuItem.OnMenuItemClickListener {

    public static NotificationManager nm;
    public static ActivityHomeBinding binding;
    public static ExoPlayer player;
    //testgitlocalstudio
    static int firstTimeOpen = 0;
    static String firstTimeNotificate = "0";
    static int drawable = R.drawable.ic_pause;

    static int state;
    private final ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    private final ArrayList<String> fragmentBaslikArrayList = new ArrayList<>();
    PlayerService service = new PlayerService();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        binding.toolbarPlaylist2.setTitle("");
        setSupportActionBar(binding.toolbarPlaylist2);
        getSupportActionBar().setDisplayShowTitleEnabled(false);//bu asıl yöntemdir.

        try {
            service = new PlayerService(HomeActivity.this);


            binding.motionLayout.transitionToEnd();
        } catch (Exception e) {

        }


        MenuService menuService = new MenuService();
        MenuService.setmContext(getApplicationContext());
        MenuService.setHomeActivity(this);


        if (PlayerService.getPlayer() != null) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.R) {
                NotificationMedia("");//burada oyna

            } else {
                NotificationMedia("");//olmassa aşşağıda comment prompt da eski cihazlar için olan var onu kullanırım
            }
        }


        binding.constraintLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayerService.setHoverOnClick("hover");
                startActivities(new Intent[]{new Intent(getApplicationContext(), PlayerActivity.class).putParcelableArrayListExtra("items", service.getModel()).putExtra("pos", service.getPos()).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)});

            }
        });
        binding.hoverPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firstTimeOpen = 1;
                service.clickPlay();
            }
        });

        binding.hoverNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstTimeOpen = 1;
                service.next();
                service.loadHoverData();
            }
        });
        binding.hoverPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstTimeOpen = 1;
                service.previous();
                service.loadHoverData();
            }
        });


        binding.motionLayout.addTransitionListener(new MotionLayout.TransitionListener() {
            @Override
            public void onTransitionStarted(MotionLayout motionLayout, int startId, int endId) {

                firstTimeOpen = 1;
            }

            @Override
            public void onTransitionChange(MotionLayout motionLayout, int startId, int endId, float progress) {

            }

            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int currentId) {

            }

            @Override
            public void onTransitionTrigger(MotionLayout motionLayout, int triggerId, boolean positive, float progress) {


            }
        });


        MyViewPagerAdapter adapter = new MyViewPagerAdapter(this);

        fragmentArrayList.add(new PlaylistFragment());
        //fragmentArrayList.add(new ArtistFragment());
        fragmentArrayList.add(new SongFragment());
        fragmentArrayList.add(new FavoritesFragment());


        binding.homeVp.setAdapter(adapter);

        fragmentBaslikArrayList.add("Playlist");
        //fragmentBaslikArrayList.add("Artist");
        fragmentBaslikArrayList.add("Songs");
        fragmentBaslikArrayList.add("Favorites");

        new TabLayoutMediator(binding.tabLayout, binding.homeVp, ((tab, position) -> tab.setText(fragmentBaslikArrayList.get(position)))).attach();


        binding.homeVp.getCurrentItem();
        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getText().toString().trim().equals("Playlist")) {
                    state = 0;
                    invalidateOptionsMenu();
                } else if (tab.getText().toString().trim().equals("Songs")) {
                    state = 2;
                    invalidateOptionsMenu();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {


            }
        });
        PlayerService.setSituationNow("pause");

    }


    public void transitionStart() {
        if (PlayerService.getSituationNow().equals("pause")) {
            binding.motionLayout.transitionToEnd();
        }

    }


    @Override
    public void onViewAttachedToWindow(View v) {

    }

    @Override
    public void onViewDetachedFromWindow(View v) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        return true;
    }

    public void ReloadHover() {
        service.loadHoverData();
    }

    @Override
    protected void onResume() {


        service.resumeHoverControl();


        super.onResume();
    }


    public void NotificationMedia(String MySwitch) {
        // Get the layouts to use in the custom notification
        RemoteViews notificationLayout = new RemoteViews(getPackageName(), R.layout.small_notification);
        RemoteViews notificationLayoutExpanded2 = new RemoteViews(getPackageName(), R.layout.large_notification_new);//**buraya yeni layout koy**/
        //channel created
        CharSequence name = getString(R.string.channel_name);
        NotificationChannel channel = new NotificationChannel("0", name, NotificationManager.IMPORTANCE_HIGH);

        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("DO", "2");
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 1, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        notificationLayoutExpanded2.setOnClickPendingIntent(R.id.imageView, pendingIntent);

        /**PLay Button Service Connection**/
        Intent intentPlay = new Intent(this, NotificationPlayAction.class);
        intentPlay.putExtra("PLAYER", "PLAY");
        PendingIntent pendingPlay = PendingIntent.getService(getApplicationContext(), (int) Math.random(), intentPlay, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        /**PLay Button Service Connection**/


        /**Previous Button Service Connection**/
        Intent intentPrevious = new Intent(this, NotificationPreviousAction.class);
        intentPrevious.putExtra("PLAYER", "PREVIOUS");
        PendingIntent pendingPrevious = PendingIntent.getService(getApplicationContext(), (int) Math.random(), intentPrevious, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        /**Previous Button Service Connection**/


        /**Next Button Service Connection**/
        Intent intentNext = new Intent(this, NotificationNextAction.class);
        intentNext.putExtra("PLAYER", "NEXT");
        PendingIntent pendingNext = PendingIntent.getService(getApplicationContext(), (int) Math.random(), intentNext, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        /**Next Button Service Connection**/


        /**Close Button Service Connection**/
        Intent intentClose = new Intent(this, NotificationClose.class);//fix it
        intentClose.putExtra("PLAYER", "CLOSE");
        PendingIntent pendingClose = PendingIntent.getService(getApplicationContext(), (int) Math.random(), intentClose, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        /**Close Button Service Connection**/


        if (MySwitch.equals("play") || MySwitch.equals("")) {
            if (PlayerService.getSituationNow().equals("pause")) {
                binding.hoverPlayPause.setImageResource(R.drawable.ic_pause);
                drawable = R.drawable.ic_pause;
                PlayerService.setSituationNow("play");
            } else if (PlayerService.getSituationNow().equals("play")) {
                drawable = R.drawable.ic_play;
                binding.hoverPlayPause.setImageResource(R.drawable.ic_play);

                PlayerService.setSituationNow("pause");
            }
        }
        if (MySwitch.equals("next")) {
            if (PlayerService.getSituationNow().equals("play")) {
                drawable = R.drawable.ic_pause;
                binding.hoverPlayPause.setImageResource(R.drawable.ic_pause);

            }
            if (PlayerService.getSituationNow().equals("pause")) {
                drawable = R.drawable.ic_play;
                binding.hoverPlayPause.setImageResource(R.drawable.ic_play);

            }
        }

        Notification.Action play = new Notification.Action.Builder(drawable, getString(R.string.play), pendingPlay).build();
        Notification.Action previous = new Notification.Action.Builder(R.drawable.ic_skippreviousnot, getString(R.string.previous), pendingPrevious).build();
        Notification.Action next = new Notification.Action.Builder(R.drawable.ic_skipnextnot, getString(R.string.next), pendingNext).build();
        Notification.Action close = new Notification.Action.Builder(R.drawable.ic_close, getString(R.string.close), pendingClose).build();

        Bitmap pic = BitmapFactory.decodeResource(getResources(), R.drawable.ic_close);


        //  MediaSessionCompat mediaSession = new MediaSessionCompat(getApplicationContext(), "session tag");

        //MediaSessionCompat.Token token = mediaSession.getSessionToken();

        // mediaStyle.setMediaSession(token);
        // Apply the layouts to the notification
        @SuppressLint("ResourceAsColor") Notification customNotification = new Notification.Builder(getApplicationContext()).setSmallIcon(R.drawable.ic_stmusic)//required
                .addAction(previous).addAction(play).addAction(next).addAction(close).setOnlyAlertOnce(true).setLargeIcon(pic)//bu biraz boklu
                .setStyle(new Notification.MediaStyle())//required//DecoratedMediaCustomViewStyle
                .setAutoCancel(true).setContentTitle(service.getNotificationData()).setContentText(service.getNotificationTitle()).setColor(R.color.black).setBadgeIconType(1).setContentIntent(pendingIntent)
                //.setContentIntent(pendingIntent)2. ye koy biri service biri activity olsun
                .setChannelId("0")//unknown

                .build();//required
        //manager created
        //
        nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.createNotificationChannel(channel);//added channel.


        nm.notify(0, customNotification);
    }


    public void clearNotification() {
        nm.cancelAll();

    }

    @Override
    public void onBackPressed() {


    }

    private class MyViewPagerAdapter extends FragmentStateAdapter {

        public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {

            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {

            return fragmentArrayList.get(position);

        }

        @Override
        public int getItemCount() {
            return fragmentArrayList.size();
        }
    }
}
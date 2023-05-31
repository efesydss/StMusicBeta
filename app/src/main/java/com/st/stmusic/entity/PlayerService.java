package com.st.stmusic.entity;

import static com.st.stmusic.R.drawable.ic_property_1_pause;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.squareup.picasso.Picasso;
import com.st.stmusic.HomeActivity;
import com.st.stmusic.PlayerActivity;
import com.st.stmusic.R;
import com.st.stmusic.data.MusicModel;
import com.st.stmusic.fragments.PlaylistFragment;
import com.st.stmusic.fragments.SleepTimerFragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Timer;

public class PlayerService implements Serializable {
    public static ExoPlayer player;
    public static Timer timer = new Timer();


    public static String situationNow;

    public static String getSituationNow() {
        return situationNow;
    }

    public static void setSituationNow(String situationNow) {
        PlayerService.situationNow = situationNow;
    }

    public static void setPlayerActivity(PlayerActivity playerActivity) {
        PlayerService.playerActivity = playerActivity;
    }

    static PlayerActivity playerActivity;

    public static void setSleepTimerFragment(SleepTimerFragment sleepTimerFragment) {
        PlayerService.sleepTimerFragment = sleepTimerFragment;
    }

    static SleepTimerFragment sleepTimerFragment;

    static PlaylistFragment playlistFragment;

    static HomeActivity activity;

    public PlayerService(HomeActivity activity) {
        PlayerService.activity = activity;
    }

    public int getPos() {
        return pos;
    }

    public ArrayList<MusicModel> getModel() {
        return model;
    }

    public ArrayList<String> getFavorites() {
        return favorites;
    }

    public TinyDB getTinydb() {
        return tinydb;
    }

    public Context getmContext() {
        return mContext;
    }

    public static ExoPlayer getPlayer() {
        return player;
    }

    static int pos;
    String minute;
    String second;
    String minute2;
    String second2;
    boolean playerSwitch;

    public static String getHoverOnClick() {
        return hoverOnClick;
    }

    static String hoverOnClick;
    static ArrayList<MusicModel> model;
    ArrayList<String> favorites;
    TinyDB tinydb;
    Context mContext;

    public PlayerService() {
    }

    public static void setPos(int pos) {


        PlayerService.pos = pos;

    }


    public PlayerService(int pos, String minute, String second, String minute2, String second2, boolean playerSwitch, ArrayList<MusicModel> model, ArrayList<String> favorites, TinyDB tinydb, Context mContext) {
        PlayerService.pos = pos;
        this.minute = minute;
        this.second = second;
        this.minute2 = minute2;
        this.second2 = second2;
        this.playerSwitch = playerSwitch;
        PlayerService.model = model;
        this.favorites = favorites;
        this.tinydb = tinydb;
        this.mContext = mContext;
    }

    public void setupExo() {
        if (!hoverOnClick.equals("hover")) {
            if (player != null) {
                player.stop();
                player = new ExoPlayer.Builder(mContext).build();
            } else {
                player = new ExoPlayer.Builder(mContext).build();
            }
            hoverOnClick = "empty";
        }
    }

    public void showCreatePLaylistDialog() {

        View alertView = LayoutInflater.from(playerActivity).inflate(R.layout.alert_create_playlist, null);

        EditText txtName = alertView.findViewById(R.id.txtPlaylistNameEdit);
        TextView txtNamePlaylist = alertView.findViewById(R.id.txtPlaylistName);
        Button btnOk = alertView.findViewById(R.id.btnCreate);
        final Dialog ad = new Dialog(playerActivity, R.style.MY_AlertDialog);
        ad.setContentView(alertView);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtName.getText().toString().trim().equals("")) {
                    boolean sit = playerActivity.manager.createPlaylist(txtName.getText().toString().trim());
                    if (sit) {
                    } else {
                    }
                    ad.dismiss();//dialog dismiss
                } else {
                    txtNamePlaylist.setText("Please Enter a Name");
                }
            }
        });

        txtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                txtNamePlaylist.setText(s);
                if (count == 0) {
                    txtNamePlaylist.setText("Please Enter a Name");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        ad.create();
        ad.show();

    }


    public void shutdown() {
        activity.clearNotification();
        activity.finishAffinity();
        playerActivity.finishAffinity();
        System.exit(0);

    }

    public void shuffleOn() {
        player.setShuffleModeEnabled(!player.getShuffleModeEnabled());

    }

    public static void setHoverOnClick(String hoverOnClick) {
        PlayerService.hoverOnClick = hoverOnClick;
    }

    public void start() {

        if (!hoverOnClick.equals("hover")) {
            for (int i = pos; i < model.size(); i++) {
                player.addMediaItem(i, MediaItem.fromUri(Uri.parse(model.get(i).getmData())));
                player.setShuffleModeEnabled(true);
            }
            player.prepare();
            player.play();
            hoverOnClick = "empty";
            activity.NotificationMedia("");//burada notification çağırılıyor ve oluşturuluyor bunu da ileride bir service taşı
        }
    }

    public String getNotificationTitle() {
        return model.get(pos).getmArtist();
    }

    public String getNotificationData() {
        return model.get(pos).getmTitle();
    }

    public Uri getNotificationImage() {
        return model.get(pos).getSongImage();
    }

    public boolean isPlaying() {
        return player.isPlaying();
    }

    public void stopExo() {
        player.stop();
    }

    public void startTransition() {
        HomeActivity.binding.motionLayout.transitionToStart();
        activity.transitionStart();

    }

    public void loadHoverData() {

        Picasso.get()
                .load(model.get(pos).getSongImage())
                .placeholder(R.drawable.ic_stmusic)
                .error(R.drawable.ic_stmusic)
                .into(HomeActivity.binding.imgSongImageHover);
        HomeActivity.binding.txtArtistSongs2.setText(model.get(pos).getmArtist());
        HomeActivity.binding.txtSongName3.setText(model.get(pos).getmTitle());

        if (playerSwitch) {
            HomeActivity.binding.hoverPlayPause.setImageResource(R.drawable.ic_pause);
        } else {
            HomeActivity.binding.hoverPlayPause.setImageResource(R.drawable.ic_play);

        }
    }

    public void resumeHoverControl() {
        if (HomeActivity.binding.txtSongName3.getText().toString().equals("null")) {
            HomeActivity.binding.motionLayout.transitionToEnd();
        }else{

            HomeActivity.binding.motionLayout.transitionToStart();
        }

    }


    public void clickPlayFromPlayerActivity() {
        if (player.isPlaying()) {
            playerSwitch = false;
            player.pause();
            playerActivity.binding.imgPlayPause.setImageResource(R.drawable.ic_property_1_play);
            activity.NotificationMedia("play");//this last change
            return;
        } else if (player.isPlaying() == false) {
            playerSwitch = true;
            player.play();
            playerActivity.binding.imgPlayPause.setImageResource(ic_property_1_pause);
            activity.NotificationMedia("play");//this
            return;

        }
    }

    public void clickPlayFromPlayerActivity(int val, int duration) {

        if (player.isPlaying()) {
            playerSwitch = false;
            player.pause();
            playerActivity.binding.imgPlayPause.setImageResource(R.drawable.ic_property_1_play);
            activity.NotificationMedia("play");//this last change

        }

    }

    public void clickPlay() {
        try {
            if (player.isPlaying()) {
                playerSwitch = false;
                player.pause();
                HomeActivity.binding.hoverPlayPause.setImageResource(R.drawable.ic_play);
                activity.NotificationMedia("play");

                return;
            } else if (player.isPlaying() == false) {
                playerSwitch = true;
                player.play();
                HomeActivity.binding.hoverPlayPause.setImageResource(R.drawable.ic_pause);
                activity.NotificationMedia("play");
                return;

            }
        } catch (Exception e) {
        }

    }

    public static void setPlayer(ExoPlayer player) {
        PlayerService.player = player;
    }

    public void next() {

        if (pos < model.size() - 1) {
            player.stop();
            MediaItem mediaItem = MediaItem.fromUri(model.get(pos + 1).getmData());
            pos++;
            player.setMediaItem(mediaItem);
            player.prepare();


            activity.NotificationMedia("next");

        }
    }

    public void justLoadNotificationMedia() {
        activity.NotificationMedia("");
    }


    public void stop2() {
        if (!activity.isDestroyed()) {
            clickPlay();
        }


    }

    public void previous() {
        if (pos > 0) {
            player.stop();
            MediaItem mediaItem = MediaItem.fromUri(model.get(pos - 1).getmData());
            pos = pos - 1;

            //loadData(pos);
            player.setMediaItem(mediaItem);
            player.prepare();
            if (player.isPlaying()) {
                player.play();
            }

            activity.NotificationMedia("previous");

        }
    }


}


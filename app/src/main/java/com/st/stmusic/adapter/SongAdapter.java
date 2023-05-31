package com.st.stmusic.adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.st.stmusic.PlayerActivity;
import com.st.stmusic.R;
import com.st.stmusic.data.MusicModel;
import com.st.stmusic.databinding.SongCardBinding;
import com.st.stmusic.entity.PlayerService;
import com.st.stmusic.entity.PlaylistManager;
import com.st.stmusic.entity.TinyDB;

import java.io.File;
import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private final Context mContext;
    private ArrayList<MusicModel> songsList;
    private TinyDB tinyDB;


    ArrayList<String> temp = new ArrayList<>();


    public SongAdapter(Context mContext, ArrayList<MusicModel> songsList, TinyDB tinyDB) {
        this.mContext = mContext;
        this.songsList = songsList;
        this.tinyDB = tinyDB;


    }

    public void filterList(ArrayList<MusicModel> filterlist) {
        // below line is to add our filtered
        // list in our course array list.
        songsList = filterlist;
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder {
        SongCardBinding itemView;

        public SongViewHolder(@NonNull SongCardBinding itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
        }
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        SongCardBinding binding = SongCardBinding.inflate(layoutInflater, parent, false);

        return new SongAdapter.SongViewHolder(binding);
    }


    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        MusicModel model = songsList.get(position);


        tinyDB = new TinyDB(mContext);
        PlaylistManager manager = new PlaylistManager(tinyDB, mContext);

        PlayerService service = new PlayerService();
        manager.setTinyDB(tinyDB);


        model.setPosition(String.valueOf(position));
        SongCardBinding t = holder.itemView;
        t.txtSongName.setText(model.getmTitle());


        t.txtArtistSongs.setText(model.getmArtist());

        t.txtArtistSongs.setText(model.getmArtist());
        manager.setTinyDB(tinyDB);

        Picasso.get()
                .load(model.getSongImage())
                .placeholder(R.drawable.ic_stmusic)
                .error(R.drawable.baseline_music_note_24)
                .into(t.imgSongImage);
        int mCurrentPosition = Math.toIntExact(Long.parseLong(model.getDuration()));
        String minute2 = String.valueOf(Integer.valueOf(mCurrentPosition) / 60000);
        String second2 = String.valueOf((Integer.valueOf(mCurrentPosition) % 60000) / 1000);
        if (Integer.valueOf(second2) < 10 && Integer.valueOf(minute2) >= 10) {

            t.txtDuration.setText(minute2 + ":" + "0" + second2);

        } else if (Integer.valueOf(second2) >= 10 && Integer.valueOf(minute2) < 10) {

            t.txtDuration.setText("0" + minute2 + ":" + second2);

        } else if (Integer.valueOf(second2) >= 10 && Integer.valueOf(minute2) >= 10) {

            t.txtDuration.setText(minute2 + ":" + second2);

        } else if (Integer.valueOf(second2) < 10 && Integer.valueOf(minute2) < 10) {
            t.txtDuration.setText("0" + minute2 + ":" + "0" + second2);
        }

        t.songcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                PlayerService.setHoverOnClick("empty");
                try {
                    mContext.startActivities(new Intent[]{new Intent(mContext, PlayerActivity.class).putParcelableArrayListExtra("items", songsList).putExtra("pos", position).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)});

                } catch (Exception e) {

                }


            }
        });
        t.imgMoreVert.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(mContext, v);
                MenuInflater menuInflater = popupMenu.getMenuInflater();
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                menuInflater.inflate(R.menu.song_card_menu, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_delete:
                                new AlertDialog.Builder(mContext)
                                        .setTitle("Are You Sure?")
                                        .setMessage("This Song Deleting in Device Storage!")
                                        .setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {

                                                File musicFile = new File(model.getmData().toString().trim());
                                                try {
                                                    if (Build.VERSION.SDK_INT == Build.VERSION_CODES.R) {
                                                        Toast.makeText(mContext, "Güvenlik Nedeniyle Bunu Dosya Yöneticinizle Halletmeniz gerekiyor", Toast.LENGTH_SHORT).show();
                                                        Intent intent = new Intent();
                                                        intent.setAction(Intent.ACTION_VIEW);
                                                        intent.setData(Uri.parse("content://com.android.externalstorage.documents/root/primary/"));
                                                        mContext.startActivity(intent);
                                                    } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                                                        boolean test = musicFile.delete();
                                                        if (test){
                                                            Toast.makeText(mContext, "Success", Toast.LENGTH_SHORT).show();
                                                            try{
                                                                songsList.remove(position);
                                                                notifyItemRemoved(position);
                                                                /**
                                                                 * API 32 DE TEST EDİLMEDİ
                                                                 * eğer yukarıdaki Dosya yöneticisi ile halletme bokunu api sdk 33 de çağırırsan Samsung cihazlar müzikleri Samsung isimli bir klasörde yinelenene kopyalama yapıyor.
                                                                 * yani tüm müzikleri kopyalayıp Samsung isimli bir klasörün içine yeniden kopyalıyor sanırım bunu tüm şarkıları listelemek için yapıyor music de
                                                                **/


                                                            }catch (Exception e){
                                                                Log.e("test",e+"");
                                                            }

                                                        }else{
                                                            Toast.makeText(mContext, "Failed!", Toast.LENGTH_SHORT).show();
                                                        }

                                                    }

                                                } catch (Exception e) {

                                                }

                                            }
                                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {

                                                dialog.dismiss();
                                            }
                                        }).show();

                                return true;

                            case R.id.action_addplaylist:

                                // manager.addSongsToPlaylist("efe",model.getmData());
                                View alertView = LayoutInflater.from(mContext).inflate(R.layout.alert_add_song_playlist, null);
                                RecyclerView rv = alertView.findViewById(R.id.recyclerViewSpecific);

                                rv.setLayoutManager(new LinearLayoutManager(mContext));
                                //listeyi ayarla


                                temp = manager.getPlaylist(false);
                                Button btn = alertView.findViewById(R.id.btnDismiss);

                                SelectPlaylistAdapter adapter = new SelectPlaylistAdapter(mContext, temp, tinyDB, model.getmData());
                                rv.setAdapter(adapter);
                                rv.setHasFixedSize(true);

                                final Dialog ad = new Dialog(mContext, R.style.MY_AlertDialog);
                                ad.setContentView(alertView);

                                btn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        ad.dismiss();
                                    }
                                });
                                ad.create();
                                ad.show();

                                return true;
                        }
                        return false;
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return songsList.size();
    }


    public ArrayList<MusicModel> getSongsList() {
        return songsList;
    }
}

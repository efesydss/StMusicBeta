package com.st.stmusic.adapter;

import static com.st.stmusic.R.color.settingRecycler;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.exoplayer2.util.Log;
import com.st.stmusic.PlaylistDetailActivity;
import com.st.stmusic.R;
import com.st.stmusic.databinding.PlaylistCardBinding;
import com.st.stmusic.entity.PlaylistManager;
import com.st.stmusic.entity.TinyDB;

import java.util.ArrayList;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.MusicViewHolder> {
    private final Context mContext;
    private final ArrayList<String> musicModelList;
    private final int playListSize;
    private final TinyDB tinyDB;
    public String str="";


    public PlaylistAdapter(Context mContext, ArrayList<String> musicModelList, int playListSize, TinyDB tinyDB) {
        this.mContext = mContext;
        this.musicModelList = musicModelList;
        this.playListSize = playListSize;
        this.tinyDB = tinyDB;
    }

    public class MusicViewHolder extends RecyclerView.ViewHolder {
        PlaylistCardBinding itemView;

        public MusicViewHolder(@NonNull PlaylistCardBinding itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
        }
    }

    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        PlaylistCardBinding binding = PlaylistCardBinding.inflate(layoutInflater, parent, false);


        return new MusicViewHolder(binding);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {



        PlaylistManager manager = new PlaylistManager(tinyDB, mContext);
         str = musicModelList.get(position);
        PlaylistCardBinding t = holder.itemView;
        t.txtMany.setText(manager.getManySpecificSize(str) + " Song");
        t.txtName.setText(str);
        manager.setTinyDB(tinyDB);


        t.playlistCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    mContext.startActivities(new Intent[]{new Intent(mContext, PlaylistDetailActivity.class).putExtra("currentPlaylist", musicModelList.get(position))});


                } catch (Exception e) {

                }
            }
        });


        t.imgMoreVert2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(mContext, v);
                MenuInflater menuInflater = popupMenu.getMenuInflater();
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                menuInflater.inflate(R.menu.playlist_card_menu, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @SuppressLint("ResourceAsColor")
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_remove:
                                try {

                                    musicModelList.remove(position);
                                    manager.removePlaylist(t.txtName.getText().toString().trim());
                                    manager.setTinyDB(tinyDB);
                                    notifyItemRemoved(position);
                                } catch (Exception e) {

                                }

                                return true;
                            case R.id.action_rename:

                                View alertView = LayoutInflater.from(mContext).inflate(R.layout.alert_create_playlist, null);
                                EditText txtName = alertView.findViewById(R.id.txtPlaylistNameEdit);
                                TextView txtNamePlaylist = alertView.findViewById(R.id.txtPlaylistName);
                                ImageButton btnOk = alertView.findViewById(R.id.btnCreate);
                                final Dialog ad = new Dialog(mContext, R.style.MY_AlertDialog);

                                txtName.requestFocus();
                                ImageView btnCancel=alertView.findViewById(R.id.btnCancel);


                                ad.setContentView(alertView);
                                btnCancel.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        ad.dismiss();
                                    }
                                });
                                btnOk.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        if (!txtName.getText().toString().trim().equals("")) {
                                            boolean sit = manager.updatePlaylistName(String.valueOf(t.txtName.getText()), txtName.getText().toString().trim());//manageri parametre olarak al mutlakaa
                                            if (sit) {
                                               t.txtName.setText(txtName.getText().toString().trim());
                                                t.txtMany.setText(manager.getManySpecificSize(txtName.getText().toString().trim()) + " Song");
                                                str=txtName.getText().toString().trim();


                                                musicModelList.set(position,str);

                                                manager.setTinyDB(tinyDB);

                                            }
                                            ad.dismiss();//dialog dismiss
                                        } else {
                                            txtNamePlaylist.setText(R.string.enter_name);
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
                                            txtNamePlaylist.setText(R.string.enter_name);
                                        }
                                    }

                                    @Override
                                    public void afterTextChanged(Editable s) {


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

        return musicModelList.size();

    }


}

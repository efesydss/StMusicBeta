package com.st.stmusic.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.st.stmusic.PlayerActivity;
import com.st.stmusic.R;
import com.st.stmusic.data.MusicModel;
import com.st.stmusic.databinding.FavoritesCardBinding;
import com.st.stmusic.entity.PlayerService;

import java.nio.file.LinkOption;
import java.util.ArrayList;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder> {
    private final Context mContext;
    private final ArrayList<MusicModel> songsList;

    public FavoritesAdapter(Context mContext, ArrayList<MusicModel> songsList) {
        this.mContext = mContext;
        this.songsList = songsList;
    }

    public class FavoritesViewHolder extends RecyclerView.ViewHolder {
        FavoritesCardBinding itemView;

        public FavoritesViewHolder(@NonNull FavoritesCardBinding itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
        }
    }


    @NonNull
    @Override
    public FavoritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        FavoritesCardBinding binding = FavoritesCardBinding.inflate(layoutInflater, parent, false);
        return new FavoritesAdapter.FavoritesViewHolder(binding);
    }


    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull FavoritesViewHolder holder, int position) {

        MusicModel model = songsList.get(position);
        model.setPosition(String.valueOf(position));
        FavoritesCardBinding t = holder.itemView;
        t.txtName.setText(model.getmTitle());
        t.txtArtist.setText(model.getmArtist());
        Picasso.get()
                .load(model.getSongImage())
                .placeholder(R.drawable.baseline_music_note_24)
                .error(R.drawable.baseline_music_note_24)
                .into(t.imgSongImage);
        t.imgMoreVert.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(mContext, v);
                MenuInflater menuInflater = popupMenu.getMenuInflater();
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                menuInflater.inflate(R.menu.favorites_card_menu, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {

                            case R.id.action_addplaylist:
                                return true;
                        }
                        return false;
                    }
                });
            }
        });

        int mCurrentPosition = Math.toIntExact(Long.parseLong(model.getDuration()));
        String minute2 = String.valueOf(Integer.valueOf(mCurrentPosition) / 60000);
        String second2 = String.valueOf((Integer.valueOf(mCurrentPosition) % 60000) / 1000);
        if (Integer.valueOf(second2) < 10 && Integer.valueOf(minute2) >= 10) {

            t.txtDuration2.setText(minute2 + ":" + "0" + second2);

        } else if (Integer.valueOf(second2) >= 10 && Integer.valueOf(minute2) < 10) {

            t.txtDuration2.setText("0" + minute2 + ":" + second2);

        } else if (Integer.valueOf(second2) >= 10 && Integer.valueOf(minute2) >= 10) {

            t.txtDuration2.setText(minute2 + ":" + second2);

        } else if (Integer.valueOf(second2) < 10 && Integer.valueOf(minute2) < 10) {
            t.txtDuration2.setText("0" + minute2 + ":" + "0" + second2);
        }
        PlayerService.setHoverOnClick("empty");
        t.favoritesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    mContext.startActivities(new Intent[]{new Intent(mContext
                            , PlayerActivity.class)
                            .putParcelableArrayListExtra("items"
                                    , songsList).putExtra("pos", position)});
                }catch (Exception e){
                    Log.e("err",e.toString());
                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return songsList.size();
    }


}

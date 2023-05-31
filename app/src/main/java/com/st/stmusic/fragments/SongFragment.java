package com.st.stmusic.fragments;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.st.stmusic.HomeActivity;
import com.st.stmusic.SettingsActivity;
import com.st.stmusic.adapter.SongAdapter;
import com.st.stmusic.data.MusicModel;
import com.st.stmusic.databinding.FragmentSongBinding;
import com.st.stmusic.entity.MenuService;
import com.st.stmusic.entity.TinyDB;

import java.util.ArrayList;


public class SongFragment extends Fragment implements SearchView.OnQueryTextListener {
    static HomeActivity homeActivity;
    public FragmentSongBinding binding;
    ArrayList<MusicModel> audioList;
    TinyDB tinydb;
    SongAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSongBinding.inflate(inflater, container, false);
        binding.rvSong.setLayoutManager(new LinearLayoutManager(requireContext()));


        loadData();



        tinydb = new TinyDB(requireContext());
        return binding.getRoot();
    }

    public void openSettings() {
        Intent intent = new Intent(getActivity(), SettingsActivity.class);
        startActivity(intent);
    }

    public void loadData() {
        ContentResolver contentResolver = requireContext().getContentResolver();


        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;



        String selection = MediaStore.Audio.Media.IS_MUSIC + "!= 0";
        String sortOrder = MediaStore.Audio.Media.TITLE + " ASC";
        Cursor cursor = contentResolver.query(uri, null, selection, null, sortOrder);
        audioList = new ArrayList<>();
        if (cursor != null && cursor.getCount() > 0) {


            while (cursor.moveToNext()) {

                @SuppressLint("Range") String ID = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media._ID));
                @SuppressLint("Range") String data = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                @SuppressLint("Range") String genre = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.GENRE));
                @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                @SuppressLint("Range") String album = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
                @SuppressLint("Range") String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                @SuppressLint("Range") String duration = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
                @SuppressLint("Range") String displayName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));//biraz daha uzun şarkı adı gibi daha detay var title sadece ad soyad gibi düşün..
                @SuppressLint("Range") String volume = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.VOLUME_NAME));//sd card mı yoksa ana diskte mi onu söylüyor.
                @SuppressLint("Range") String bucketName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.BUCKET_DISPLAY_NAME));//içerisinde bulunduğu klasör
                Long albumId = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID));

                Uri sArtworkUri = Uri.parse("content://media/external/audio/albumart");
                /**
                 * duration= 24.600
                 * duration / 60.000  = > dakikayı verir
                 * (duration % 60.000) / 1000  = > dakikadan artan saniyeyi verir
                 * **/
                String minutes = String.valueOf(Integer.valueOf(duration) / 60000);
                String seconds = String.valueOf((Integer.valueOf(duration) % 60000) / 1000);
                Uri albumArtUri = ContentUris.withAppendedId(sArtworkUri, albumId);
                // Save to audioList

                if (artist.equals("<unknown>")){
                    artist="";
                }

                audioList.add(new MusicModel(ID, data, title.trim(), album, artist, albumArtUri, duration, uri, "0", 0));


                Log.e("test",
                        "\n data = " + data +
                                "\n" + "title = " + title +
                                "\n" + "album = " + album +
                                "\n" + "artist = " + artist +

                                "\n" + "display name = " + displayName +
                                "\n" + "volume name = " + volume +
                                "\n" + "bucket name = " + bucketName +
                                "\n" + "ID = " + ID);




            }
        }
        cursor.close();



        //adapter size 0 olmamalı
        adapter = new SongAdapter(requireContext(), audioList, tinydb);
        binding.rvSong.setAdapter(adapter);
        binding.rvSong.setHasFixedSize(true);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void callMenu() {

        MenuService menuService = new MenuService();
        MenuService.setSongFragment(this);
        MenuService.setWhichMenu("song");
        menuService.loadMenu();
    }

    @Override
    public void onResume() {
        getActivity().invalidateOptionsMenu();
        callMenu();
        super.onResume();
    }


    public void filter(String text) {
        // creating a new array list to filter our data.
        ArrayList<MusicModel> filteredlist = new ArrayList<MusicModel>();

        // running a for loop to compare elements.
        for (MusicModel item : audioList) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.getmTitle().toLowerCase().contains(text.toLowerCase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(requireContext(), "No Data Found..", Toast.LENGTH_SHORT).show();
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            adapter.filterList(filteredlist);
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {


        return true;
    }
}
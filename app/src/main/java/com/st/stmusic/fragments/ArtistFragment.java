package com.st.stmusic.fragments;

import static android.provider.MediaStore.MediaColumns.TITLE;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.st.stmusic.SettingsActivity;
import com.st.stmusic.adapter.ArtistAdapter;
import com.st.stmusic.data.ArtistModel;
import com.st.stmusic.databinding.FragmentArtistBinding;
import com.st.stmusic.entity.MenuService;

import java.util.ArrayList;


public class ArtistFragment extends Fragment implements SearchView.OnQueryTextListener {
    FragmentArtistBinding binding;

    ArrayList<ArtistModel> model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentArtistBinding.inflate(inflater, container, false);
        binding.rvArtist.setLayoutManager(new LinearLayoutManager(requireContext()));

        //menu();
        loadData();


        return binding.getRoot();
    }

    public void loadData() {
        ContentResolver contentResolver = requireContext().getContentResolver();

        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String selection = MediaStore.Audio.Media.IS_MUSIC + "!= 0";
        String sortOrder = TITLE + " ASC";
        Cursor cursor = contentResolver.query(uri, null, selection, null, sortOrder);
        model = new ArrayList<>();

        if (cursor != null && cursor.getCount() > 0) {

            while (cursor.moveToNext()) {
                @SuppressLint("Range") String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                @SuppressLint("Range") String dataForImage = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                model.add(new ArtistModel(artist, 1, Uri.parse(dataForImage)));
            }
        }/**audioList adaptere yolla ve finish**/
        cursor.close();


        ArtistAdapter adapter = new ArtistAdapter(requireContext(), model);
        binding.rvArtist.setAdapter(adapter);
        binding.rvArtist.setHasFixedSize(true);
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onResume() {
        getActivity().invalidateOptionsMenu();
        callMenu();
        super.onResume();
    }

    public void openSettings() {
        Intent intent = new Intent(getActivity(), SettingsActivity.class);
        startActivity(intent);
    }

    public void callMenu() {

        MenuService menuService = new MenuService();
        MenuService.setArtistFragment(this);
        MenuService.setWhichMenu("artist");
        menuService.loadMenu();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
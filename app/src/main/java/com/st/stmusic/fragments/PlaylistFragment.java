package com.st.stmusic.fragments;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.st.stmusic.R;
import com.st.stmusic.SettingsActivity;
import com.st.stmusic.adapter.PlaylistAdapter;
import com.st.stmusic.data.MusicModel;
import com.st.stmusic.databinding.FragmentPlaylistBinding;
import com.st.stmusic.entity.MenuService;
import com.st.stmusic.entity.PlaylistManager;
import com.st.stmusic.entity.TinyDB;

import java.util.ArrayList;


public class PlaylistFragment extends Fragment implements SearchView.OnQueryTextListener {
    FragmentPlaylistBinding binding;
    ArrayList<MusicModel> audioList;
    final ArrayList<String> playlistArray = new ArrayList<>();
    final ArrayList<String> songList = new ArrayList<>();
    TinyDB tinyDB;
    PlaylistAdapter adapter;
    PlaylistManager manager;
    final int playListSize = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPlaylistBinding.inflate(inflater, container, false);

        binding.rvPlaylist.setLayoutManager(new LinearLayoutManager(requireContext()));


        tinyDB = new TinyDB(requireContext());


        manager = new PlaylistManager(tinyDB, requireContext());

        manager.getPlaylist();


        adapter = new PlaylistAdapter(requireContext(), manager.getPlaylistArray(), manager.getPlayListSize(), tinyDB);
        binding.rvPlaylist.setAdapter(adapter);
        binding.rvPlaylist.setHasFixedSize(true);


        return binding.getRoot();


    }


    @Override
    public void onDestroy() {

        super.onDestroy();
    }

    public void callMenu() {
        MenuService menuService = new MenuService();
        MenuService.setPlaylistFragment(this);
        MenuService.setWhichMenu("playlist");
        menuService.loadMenu();
    }

    public void openCreateInterface() {
        View alertView = LayoutInflater.from(requireContext()).inflate(R.layout.alert_create_playlist, null);
        EditText txtName = alertView.findViewById(R.id.txtPlaylistNameEdit);
        TextView txtNamePlaylist = alertView.findViewById(R.id.txtPlaylistName);
        ImageButton btnOk = alertView.findViewById(R.id.btnCreate);
        ImageView btnCancel = alertView.findViewById(R.id.btnCancel);
        final Dialog ad = new Dialog(requireContext(), R.style.MY_AlertDialog);

        txtName.requestFocus();



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
                    boolean sit = manager.createPlaylist(txtName.getText().toString().trim());//manageri parametre olarak al mutlakaa
                    if (sit) {
                    } else {
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
    }

    public void openSettings() {
        Intent intent = new Intent(getActivity(), SettingsActivity.class);
        startActivity(intent);
    }


    @Override
    public void onResume() {


        getActivity().invalidateOptionsMenu();
        callMenu();
        adapter.notifyDataSetChanged();
        super.onResume();
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
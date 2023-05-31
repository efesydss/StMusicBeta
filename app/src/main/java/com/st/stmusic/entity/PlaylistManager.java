package com.st.stmusic.entity;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

public class PlaylistManager {
    final ArrayList<String> playlistArray = new ArrayList<>();
    final ArrayList<String> songList = new ArrayList<>();
    final ArrayList<String> songListBackupForUpdate = new ArrayList<>();
    final int playListSize = 0;
    TinyDB tinyDB;
    Context mContext;

    public PlaylistManager() {
    }

    public PlaylistManager(TinyDB tinyDB, Context mContext) {
        this.tinyDB = tinyDB;
        this.mContext = mContext;
    }

    public void setTinyDB(TinyDB tinyDB) {
        this.tinyDB = tinyDB;
    }

    public ArrayList<String> getPlaylistArray() {
        return playlistArray;
    }

    public ArrayList<String> getSongList() {
        return songList;
    }

    public int getPlayListSize() {
        return playListSize;
    }

    /**
     * PLAYLİST MANAGEMENT
     **/
    public void getPlaylist() {
        playlistArray.clear();
        for (int i = 0; i < tinyDB.getListString("playlist").size(); i++) {
            playlistArray.add(tinyDB.getListString("playlist").get(i));

        }
    }


    public ArrayList<String> getPlaylist(boolean test) {
        playlistArray.clear();
        for (int i = 0; i < tinyDB.getListString("playlist").size(); i++) {
            playlistArray.add(tinyDB.getListString("playlist").get(i));

        }
        return playlistArray;
    }

    public String getPlaylist(String controlKey) {
        playlistArray.clear();
        String situation = "null";
        for (int i = 0; i < tinyDB.getListString("playlist").size(); i++) {
            if (tinyDB.getListString("playlist").get(i).equals(controlKey)) {
                situation = "fail";//çünkü daha önce eklenmiş

            } else if (!situation.equals("fail")) {
                situation = "success";
                playlistArray.add(tinyDB.getListString("playlist").get(i));//ilk defa ekleniyor sorunsuz eklendi.
            }
        }
        return situation;
    }

    public boolean createPlaylist(String playlistName) {
        String ctrl = getPlaylist(playlistName);
        if (ctrl.equals("success") || ctrl.equals("null")) {

            playlistArray.add(playlistName);
            tinyDB.putListString("playlist", playlistArray);
            return true;
        }
        return false;
    }

    public void removePlaylist(String playlistName) {



        String ctrl = getPlaylist(playlistName);

        getPlaylist();
        if (ctrl.equals("success")) {
        } else if (ctrl.equals("fail")) {
            for (int i = 0; i <= playlistArray.size(); i++) {
                Log.e("ctrla", " playlist song => " + playlistArray.get(i));
                if (playlistName.equals(playlistArray.get(i))) {
                    playlistArray.remove(i);
                    tinyDB.putListString("playlist", playlistArray);
                    break;


                }
            }
            removeAllSongsThisPlaylist(playlistName);
        }
    }
    /**PLAYLİST MANAGEMENT**/

    /***************************************************/
    /**
     * PLAYLİST SONG MANAGEMENT
     **/
    public void getPlaylistSongs(String playlistName) {
        songList.clear();
        for (int i = 0; i < tinyDB.getListString(playlistName).size(); i++) {
            songList.add(tinyDB.getListString(playlistName).get(i));
        }
    }

    public void addSongsToPlaylist(String playlistName, String songData) {
        songList.clear();
        getPlaylistSongs(playlistName);
        songList.add(songData);
        tinyDB.putListString(playlistName, songList);

    }

    public boolean updatePlaylistName(String playlistName, String newName) {
        songList.clear();

        getPlaylistSongs(playlistName);
        for(int i = 0; i < songList.size();i++){
            songListBackupForUpdate.add(songList.get(i));
        }
        removePlaylist(playlistName);
        boolean sit= createPlaylist(newName);
        for (int i =0;i< songListBackupForUpdate.size();i++){
            addSongsToPlaylist(newName, songListBackupForUpdate.get(i));
        }
        return sit;
    }

    public void removeAllSongsThisPlaylist(String playlistName) {
        tinyDB.remove(playlistName);
    }

    public void removeSongsFromPlaylist(String playlistName, String songData) {
        getPlaylistSongs(playlistName);
        for (int i = 0; i < songList.size(); i++) {
            if (songList.get(i).equals(songData)) {
                songList.remove(i);
                tinyDB.putListString(playlistName, songList);
                break;
            }
        }
    }

    public int getManySpecificSize(String playlistName) {
        songList.clear();
        getPlaylistSongs(playlistName);
        return songList.size();
    }


    /**PLAYLİST SONG MANAGEMENT**/

}

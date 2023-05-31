package com.st.stmusic.entity;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuProvider;

import com.st.stmusic.HomeActivity;
import com.st.stmusic.PlaylistDetailActivity;
import com.st.stmusic.R;
import com.st.stmusic.fragments.ArtistFragment;
import com.st.stmusic.fragments.FavoritesFragment;
import com.st.stmusic.fragments.PlaylistFragment;
import com.st.stmusic.fragments.SettingsFragment;
import com.st.stmusic.fragments.SongFragment;

public class MenuService {
    static SongFragment songFragment;
    static PlaylistDetailActivity playlistDetailActivity;


    static PlaylistFragment playlistFragment;
    static ArtistFragment artistFragment;
    static HomeActivity homeActivity;
    static FavoritesFragment favoritesFragment;
    static Context mContext;
    static String whichMenu;
    static SettingsFragment settingsFragment;

    public static SettingsFragment getSettingsFragment() {
        return settingsFragment;
    }
    public static PlaylistDetailActivity getPlaylistDetailActivity() {
        return playlistDetailActivity;
    }

    public static void setPlaylistDetailActivity(PlaylistDetailActivity playlistDetailActivity) {
        MenuService.playlistDetailActivity = playlistDetailActivity;
    }


    public static void setSettingsFragment(SettingsFragment settingsFragment) {
        MenuService.settingsFragment = settingsFragment;
    }

    public static String getWhichMenu() {
        return whichMenu;
    }

    public static void setWhichMenu(String whichMenu) {
        MenuService.whichMenu = whichMenu;
    }

    public static Context getmContext() {
        return mContext;
    }

    public static void setmContext(Context mContext) {
        MenuService.mContext = mContext;
    }

    public static SongFragment getSongFragment() {
        return songFragment;
    }

    public static void setSongFragment(SongFragment songFragment) {
        MenuService.songFragment = songFragment;
    }

    public static PlaylistFragment getPlaylistFragment() {
        return playlistFragment;
    }

    public static void setPlaylistFragment(PlaylistFragment playlistFragment) {
        MenuService.playlistFragment = playlistFragment;
    }

    public static ArtistFragment getArtistFragment() {
        return artistFragment;
    }

    public static void setArtistFragment(ArtistFragment artistFragment) {
        MenuService.artistFragment = artistFragment;
    }

    public static HomeActivity getHomeActivity() {
        return homeActivity;
    }

    public static void setHomeActivity(HomeActivity homeActivity) {
        MenuService.homeActivity = homeActivity;
    }

    public static FavoritesFragment getFavoritesFragment() {
        return favoritesFragment;
    }

    public static void setFavoritesFragment(FavoritesFragment favoritesFragment) {
        MenuService.favoritesFragment = favoritesFragment;
    }


    public void loadMenu() {
        if (whichMenu.equals("favorites")) {
            homeActivity.invalidateOptionsMenu();
            homeActivity.addMenuProvider(new MenuProvider() {
                @Override
                public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                    menu.clear();
                    menuInflater.inflate(R.menu.toolbar_favorites_menu, menu);
                }

                @Override
                public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                    return true;
                }
            });
        }
        if (whichMenu.equals("artist")) {
            homeActivity.invalidateOptionsMenu();
            homeActivity.addMenuProvider(new MenuProvider() {
                @Override
                public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                    menu.clear();
                    menuInflater.inflate(R.menu.toolbar_artist_menu, menu);
                }

                @Override
                public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                    return true;
                }
            });
        }

        if (whichMenu.equals("song")) {
            homeActivity.invalidateOptionsMenu();
            homeActivity.addMenuProvider(new MenuProvider() {
                @Override
                public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                    menu.clear();
                    menuInflater.inflate(R.menu.toolbar_songs_menu, menu);
                    MenuItem searchItem = menu.findItem(R.id.action_search);
                    SearchView searchView = (SearchView) searchItem.getActionView();
                    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                        @Override
                        public boolean onQueryTextSubmit(String query) {
                            return false;
                        }

                        @Override
                        public boolean onQueryTextChange(String newText) {
                            songFragment.filter(newText);
                            return false;
                        }
                    });
                }

                @Override
                public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                    return true;
                }
            });
        }
        if (whichMenu.equals("playlist")) {
            homeActivity.addMenuProvider(new MenuProvider() {
                @Override
                public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                    menu.clear();
                    menuInflater.inflate(R.menu.toolbar_playlist_menu, menu);
                }

                @Override
                public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.actionSettingsPlaylist:
                            playlistFragment.openSettings();
                            break;
                        case R.id.action_create_playlist:
                            playlistFragment.openCreateInterface();
                            break;

                        case R.id.settingSong_action:
                            songFragment.openSettings();
                            break;
                        case R.id.action_setting_artist:
                            artistFragment.openSettings();
                            break;
                        case R.id.action_settings_favorites:
                            favoritesFragment.openSettings();
                            break;
                    }
                    return true;
                }
            });
        }


    }

}

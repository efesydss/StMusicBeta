package com.st.stmusic;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.st.stmusic.databinding.ActivityHomeBindingImpl;
import com.st.stmusic.databinding.ActivityMainBindingImpl;
import com.st.stmusic.databinding.ActivityPlayerBindingImpl;
import com.st.stmusic.databinding.ArtistCardBindingImpl;
import com.st.stmusic.databinding.FavoritesCardBindingImpl;
import com.st.stmusic.databinding.FragmentArtistBindingImpl;
import com.st.stmusic.databinding.FragmentFavoritesBindingImpl;
import com.st.stmusic.databinding.FragmentPlaylistBindingImpl;
import com.st.stmusic.databinding.FragmentSongBindingImpl;
import com.st.stmusic.databinding.SelectPlaylistCardBindingImpl;
import com.st.stmusic.databinding.SongCardBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYHOME = 1;

  private static final int LAYOUT_ACTIVITYMAIN = 2;

  private static final int LAYOUT_ACTIVITYPLAYER = 3;

  private static final int LAYOUT_ARTISTCARD = 4;

  private static final int LAYOUT_FAVORITESCARD = 5;

  private static final int LAYOUT_FRAGMENTARTIST = 6;

  private static final int LAYOUT_FRAGMENTFAVORITES = 7;

  private static final int LAYOUT_FRAGMENTPLAYLIST = 8;

  private static final int LAYOUT_FRAGMENTSONG = 9;

  private static final int LAYOUT_SELECTPLAYLISTCARD = 10;

  private static final int LAYOUT_SONGCARD = 11;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(11);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.st.stmusic.R.layout.activity_home, LAYOUT_ACTIVITYHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.st.stmusic.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.st.stmusic.R.layout.activity_player, LAYOUT_ACTIVITYPLAYER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.st.stmusic.R.layout.artist_card, LAYOUT_ARTISTCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.st.stmusic.R.layout.favorites_card, LAYOUT_FAVORITESCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.st.stmusic.R.layout.fragment_artist, LAYOUT_FRAGMENTARTIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.st.stmusic.R.layout.fragment_favorites, LAYOUT_FRAGMENTFAVORITES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.st.stmusic.R.layout.fragment_playlist, LAYOUT_FRAGMENTPLAYLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.st.stmusic.R.layout.fragment_song, LAYOUT_FRAGMENTSONG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.st.stmusic.R.layout.select_playlist_card, LAYOUT_SELECTPLAYLISTCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.st.stmusic.R.layout.song_card, LAYOUT_SONGCARD);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYHOME: {
          if ("layout/activity_home_0".equals(tag)) {
            return new ActivityHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_home is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPLAYER: {
          if ("layout/activity_player_0".equals(tag)) {
            return new ActivityPlayerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_player is invalid. Received: " + tag);
        }
        case  LAYOUT_ARTISTCARD: {
          if ("layout/artist_card_0".equals(tag)) {
            return new ArtistCardBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for artist_card is invalid. Received: " + tag);
        }
        case  LAYOUT_FAVORITESCARD: {
          if ("layout/favorites_card_0".equals(tag)) {
            return new FavoritesCardBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for favorites_card is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTARTIST: {
          if ("layout/fragment_artist_0".equals(tag)) {
            return new FragmentArtistBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_artist is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTFAVORITES: {
          if ("layout/fragment_favorites_0".equals(tag)) {
            return new FragmentFavoritesBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_favorites is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPLAYLIST: {
          if ("layout/fragment_playlist_0".equals(tag)) {
            return new FragmentPlaylistBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_playlist is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSONG: {
          if ("layout/fragment_song_0".equals(tag)) {
            return new FragmentSongBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_song is invalid. Received: " + tag);
        }
        case  LAYOUT_SELECTPLAYLISTCARD: {
          if ("layout/select_playlist_card_0".equals(tag)) {
            return new SelectPlaylistCardBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for select_playlist_card is invalid. Received: " + tag);
        }
        case  LAYOUT_SONGCARD: {
          if ("layout/song_card_0".equals(tag)) {
            return new SongCardBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for song_card is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(4);

    static {
      sKeys.put(1, "ActivityAccessObject");
      sKeys.put(2, "PlayerActivityAccessObject");
      sKeys.put(3, "SongFragmentAccessObject");
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(11);

    static {
      sKeys.put("layout/activity_home_0", com.st.stmusic.R.layout.activity_home);
      sKeys.put("layout/activity_main_0", com.st.stmusic.R.layout.activity_main);
      sKeys.put("layout/activity_player_0", com.st.stmusic.R.layout.activity_player);
      sKeys.put("layout/artist_card_0", com.st.stmusic.R.layout.artist_card);
      sKeys.put("layout/favorites_card_0", com.st.stmusic.R.layout.favorites_card);
      sKeys.put("layout/fragment_artist_0", com.st.stmusic.R.layout.fragment_artist);
      sKeys.put("layout/fragment_favorites_0", com.st.stmusic.R.layout.fragment_favorites);
      sKeys.put("layout/fragment_playlist_0", com.st.stmusic.R.layout.fragment_playlist);
      sKeys.put("layout/fragment_song_0", com.st.stmusic.R.layout.fragment_song);
      sKeys.put("layout/select_playlist_card_0", com.st.stmusic.R.layout.select_playlist_card);
      sKeys.put("layout/song_card_0", com.st.stmusic.R.layout.song_card);
    }
  }
}

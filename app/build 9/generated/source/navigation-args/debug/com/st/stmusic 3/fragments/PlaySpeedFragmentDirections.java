package com.st.stmusic.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.st.stmusic.R;

public class PlaySpeedFragmentDirections {
  private PlaySpeedFragmentDirections() {
  }

  @NonNull
  public static NavDirections backPlaySpeed() {
    return new ActionOnlyNavDirections(R.id.backPlaySpeed);
  }
}

package com.st.stmusic.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.st.stmusic.R;

public class SettingsFragmentDirections {
  private SettingsFragmentDirections() {
  }

  @NonNull
  public static NavDirections goToSleepTimer() {
    return new ActionOnlyNavDirections(R.id.goToSleepTimer);
  }

  @NonNull
  public static NavDirections goToPlaySpeed() {
    return new ActionOnlyNavDirections(R.id.goToPlaySpeed);
  }

  @NonNull
  public static NavDirections goToControlScreenFragment() {
    return new ActionOnlyNavDirections(R.id.goToControlScreenFragment);
  }

  @NonNull
  public static NavDirections goToManageTabFragment() {
    return new ActionOnlyNavDirections(R.id.goToManageTabFragment);
  }
}

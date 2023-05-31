package com.st.stmusic.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.st.stmusic.R;

public class SleepTimerFragmentDirections {
  private SleepTimerFragmentDirections() {
  }

  @NonNull
  public static NavDirections backSleepTimer() {
    return new ActionOnlyNavDirections(R.id.backSleepTimer);
  }
}

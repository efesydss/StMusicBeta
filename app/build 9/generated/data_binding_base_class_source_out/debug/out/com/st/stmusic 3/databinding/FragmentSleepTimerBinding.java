// Generated by data binding compiler. Do not edit!
package com.st.stmusic.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.st.stmusic.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentSleepTimerBinding extends ViewDataBinding {
  @NonNull
  public final ImageView btn10Min;

  @NonNull
  public final ImageView btn15Min;

  @NonNull
  public final ImageView btn1Hour;

  @NonNull
  public final ImageView btn30Min;

  @NonNull
  public final ImageView btn45Min;

  @NonNull
  public final ImageView btn5Min;

  @NonNull
  public final ImageView btnEndOfPlaylist;

  @NonNull
  public final ImageView btnEndOfTrack;

  @NonNull
  public final Toolbar toolbarSleepTimer;

  protected FragmentSleepTimerBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView btn10Min, ImageView btn15Min, ImageView btn1Hour, ImageView btn30Min,
      ImageView btn45Min, ImageView btn5Min, ImageView btnEndOfPlaylist, ImageView btnEndOfTrack,
      Toolbar toolbarSleepTimer) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btn10Min = btn10Min;
    this.btn15Min = btn15Min;
    this.btn1Hour = btn1Hour;
    this.btn30Min = btn30Min;
    this.btn45Min = btn45Min;
    this.btn5Min = btn5Min;
    this.btnEndOfPlaylist = btnEndOfPlaylist;
    this.btnEndOfTrack = btnEndOfTrack;
    this.toolbarSleepTimer = toolbarSleepTimer;
  }

  @NonNull
  public static FragmentSleepTimerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_sleep_timer, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSleepTimerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentSleepTimerBinding>inflateInternal(inflater, R.layout.fragment_sleep_timer, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSleepTimerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_sleep_timer, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSleepTimerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentSleepTimerBinding>inflateInternal(inflater, R.layout.fragment_sleep_timer, null, false, component);
  }

  public static FragmentSleepTimerBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentSleepTimerBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentSleepTimerBinding)bind(component, view, R.layout.fragment_sleep_timer);
  }
}

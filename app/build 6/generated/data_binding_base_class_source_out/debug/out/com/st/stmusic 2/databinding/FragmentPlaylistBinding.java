// Generated by data binding compiler. Do not edit!
package com.st.stmusic.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.st.stmusic.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentPlaylistBinding extends ViewDataBinding {
  @NonNull
  public final MotionLayout constraintLayout3;

  @NonNull
  public final RecyclerView rvPlaylist;

  protected FragmentPlaylistBinding(Object _bindingComponent, View _root, int _localFieldCount,
      MotionLayout constraintLayout3, RecyclerView rvPlaylist) {
    super(_bindingComponent, _root, _localFieldCount);
    this.constraintLayout3 = constraintLayout3;
    this.rvPlaylist = rvPlaylist;
  }

  @NonNull
  public static FragmentPlaylistBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_playlist, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentPlaylistBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentPlaylistBinding>inflateInternal(inflater, R.layout.fragment_playlist, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentPlaylistBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_playlist, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentPlaylistBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentPlaylistBinding>inflateInternal(inflater, R.layout.fragment_playlist, null, false, component);
  }

  public static FragmentPlaylistBinding bind(@NonNull View view) {
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
  public static FragmentPlaylistBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentPlaylistBinding)bind(component, view, R.layout.fragment_playlist);
  }
}
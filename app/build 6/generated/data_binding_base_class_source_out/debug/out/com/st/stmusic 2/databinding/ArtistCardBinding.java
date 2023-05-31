// Generated by data binding compiler. Do not edit!
package com.st.stmusic.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.st.stmusic.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ArtistCardBinding extends ViewDataBinding {
  @NonNull
  public final ImageView imgLine;

  @NonNull
  public final ImageView imgSongImage;

  @NonNull
  public final TextView txtCount;

  @NonNull
  public final TextView txtName;

  protected ArtistCardBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView imgLine, ImageView imgSongImage, TextView txtCount, TextView txtName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imgLine = imgLine;
    this.imgSongImage = imgSongImage;
    this.txtCount = txtCount;
    this.txtName = txtName;
  }

  @NonNull
  public static ArtistCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.artist_card, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ArtistCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ArtistCardBinding>inflateInternal(inflater, R.layout.artist_card, root, attachToRoot, component);
  }

  @NonNull
  public static ArtistCardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.artist_card, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ArtistCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ArtistCardBinding>inflateInternal(inflater, R.layout.artist_card, null, false, component);
  }

  public static ArtistCardBinding bind(@NonNull View view) {
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
  public static ArtistCardBinding bind(@NonNull View view, @Nullable Object component) {
    return (ArtistCardBinding)bind(component, view, R.layout.artist_card);
  }
}
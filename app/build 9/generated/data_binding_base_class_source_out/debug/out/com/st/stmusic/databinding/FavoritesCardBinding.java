// Generated by data binding compiler. Do not edit!
package com.st.stmusic.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.st.stmusic.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FavoritesCardBinding extends ViewDataBinding {
  @NonNull
  public final CardView favoritesCard;

  @NonNull
  public final ImageView imgLike;

  @NonNull
  public final ImageView imgLine;

  @NonNull
  public final ImageView imgMoreVert;

  @NonNull
  public final ImageView imgSongImage;

  @NonNull
  public final TextView txtArtist;

  @NonNull
  public final TextView txtDuration2;

  @NonNull
  public final TextView txtName;

  protected FavoritesCardBinding(Object _bindingComponent, View _root, int _localFieldCount,
      CardView favoritesCard, ImageView imgLike, ImageView imgLine, ImageView imgMoreVert,
      ImageView imgSongImage, TextView txtArtist, TextView txtDuration2, TextView txtName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.favoritesCard = favoritesCard;
    this.imgLike = imgLike;
    this.imgLine = imgLine;
    this.imgMoreVert = imgMoreVert;
    this.imgSongImage = imgSongImage;
    this.txtArtist = txtArtist;
    this.txtDuration2 = txtDuration2;
    this.txtName = txtName;
  }

  @NonNull
  public static FavoritesCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.favorites_card, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FavoritesCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FavoritesCardBinding>inflateInternal(inflater, R.layout.favorites_card, root, attachToRoot, component);
  }

  @NonNull
  public static FavoritesCardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.favorites_card, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FavoritesCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FavoritesCardBinding>inflateInternal(inflater, R.layout.favorites_card, null, false, component);
  }

  public static FavoritesCardBinding bind(@NonNull View view) {
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
  public static FavoritesCardBinding bind(@NonNull View view, @Nullable Object component) {
    return (FavoritesCardBinding)bind(component, view, R.layout.favorites_card);
  }
}

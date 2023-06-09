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

public abstract class FragmentSettingsBinding extends ViewDataBinding {
  @NonNull
  public final ImageView btnAboutUS;

  @NonNull
  public final ImageView btnContactUS;

  @NonNull
  public final ImageView btnControlScreen;

  @NonNull
  public final ImageView btnDonateUS;

  @NonNull
  public final ImageView btnManageTab;

  @NonNull
  public final ImageView btnSkipSilence;

  @NonNull
  public final ImageView btnSleepTimer;

  @NonNull
  public final ImageView btnThemeSwitch;

  @NonNull
  public final ImageView btnplaySpeed;

  @NonNull
  public final Toolbar toolbarSettings;

  protected FragmentSettingsBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView btnAboutUS, ImageView btnContactUS, ImageView btnControlScreen,
      ImageView btnDonateUS, ImageView btnManageTab, ImageView btnSkipSilence,
      ImageView btnSleepTimer, ImageView btnThemeSwitch, ImageView btnplaySpeed,
      Toolbar toolbarSettings) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnAboutUS = btnAboutUS;
    this.btnContactUS = btnContactUS;
    this.btnControlScreen = btnControlScreen;
    this.btnDonateUS = btnDonateUS;
    this.btnManageTab = btnManageTab;
    this.btnSkipSilence = btnSkipSilence;
    this.btnSleepTimer = btnSleepTimer;
    this.btnThemeSwitch = btnThemeSwitch;
    this.btnplaySpeed = btnplaySpeed;
    this.toolbarSettings = toolbarSettings;
  }

  @NonNull
  public static FragmentSettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_settings, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentSettingsBinding>inflateInternal(inflater, R.layout.fragment_settings, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSettingsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_settings, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentSettingsBinding>inflateInternal(inflater, R.layout.fragment_settings, null, false, component);
  }

  public static FragmentSettingsBinding bind(@NonNull View view) {
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
  public static FragmentSettingsBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentSettingsBinding)bind(component, view, R.layout.fragment_settings);
  }
}

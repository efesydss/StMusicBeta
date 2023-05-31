package com.st.stmusic.fragments;

import static com.st.stmusic.R.drawable.ic_themeoff;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.st.stmusic.BuildConfig;
import com.st.stmusic.HomeActivity;
import com.st.stmusic.R;
import com.st.stmusic.databinding.FragmentSettingsBinding;
import com.st.stmusic.entity.MenuService;

public class SettingsFragment extends Fragment {
    static int theme;
    FragmentSettingsBinding binding;
    MenuService menuService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSettingsBinding.inflate(inflater, container, false);

        binding.txtVersion.setText("betaV"+BuildConfig.VERSION_NAME);

        theme = 0;
        ((AppCompatActivity) getActivity()).setSupportActionBar(binding.toolbarSettings);
        binding.toolbarSettings.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        MenuService.setSettingsFragment(this);

        binding.toolbarSettings.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(requireActivity(), HomeActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                }

            }
        });
        binding.btnSleepTimer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.goToSleepTimer);
            }
        });
        binding.btnplaySpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.goToPlaySpeed);
            }
        });
        binding.btnControlScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.goToControlScreenFragment);
            }
        });
        binding.btnAboutUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.instagram.com/soydastech/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.instagram.android");
                startActivity(intent);
            }
        });
        binding.btnManageTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.goToManageTabFragment);
            }
        });
        binding.btnSkipSilence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateInterface();
            }
        });
        binding.btnThemeSwitch.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {
                //theme değiştir
                //butınu değiştir

                if (theme == 0) {
                    binding.btnThemeSwitch.setImageResource(R.drawable.ic_theme_on);
                    theme = 1;
                } else {
                    binding.btnThemeSwitch.setImageResource(ic_themeoff);
                    theme = 0;
                }
            }
        });


        return binding.getRoot();
    }

    public void openCreateInterface() {
        View alertView = LayoutInflater.from(requireContext()).inflate(R.layout.alert_skip_silence, null);
        ImageView btnYes = alertView.findViewById(R.id.btnYes);
        ImageView btnNo = alertView.findViewById(R.id.btnNo);

        final Dialog ad = new Dialog(requireContext(), R.style.MY_AlertDialog);

        ad.setContentView(alertView);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //buraya sessizliği geç yap
                ad.dismiss();//dialog dismiss
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                ad.dismiss();//dialog dismiss
            }
        });

        ad.create();
        ad.show();
    }//fix it

    @Override
    public void onDestroy() {

        super.onDestroy();
    }
}
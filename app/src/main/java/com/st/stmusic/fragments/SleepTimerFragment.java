package com.st.stmusic.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.google.android.exoplayer2.ExoPlayer;
import com.st.stmusic.R;
import com.st.stmusic.databinding.FragmentSleepTimerBinding;
import com.st.stmusic.entity.PlayerService;

import java.util.Timer;


public class SleepTimerFragment extends Fragment {
    FragmentSleepTimerBinding binding;
    ExoPlayer player;
    PlayerService service;
    static Timer timer = new Timer();
    Handler handler1;
    Handler handler2;
    Handler handler3;
    Handler handler4;
    Handler handler5;
    Handler handler6;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSleepTimerBinding.inflate(inflater, container, false);


        service = new PlayerService();
        player = PlayerService.getPlayer();


        ((AppCompatActivity) getActivity()).setSupportActionBar(binding.toolbarSleepTimer);
        binding.toolbarSleepTimer.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);

        binding.toolbarSleepTimer.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.backSleepTimer);
            }
        });
        binding.btn5Min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(requireContext(), R.string.timer_5_min, Toast.LENGTH_SHORT).show();
                        cliclk();
                    }
                }, 300000);

                Navigation.findNavController(v).navigate(R.id.backSleepTimer);


            }
        });
        binding.btn10Min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler2 = new Handler();
                handler2.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(requireContext(), R.string.timer_10_min, Toast.LENGTH_SHORT).show();
                        cliclk();
                    }
                }, 600000);
                Navigation.findNavController(v).navigate(R.id.backSleepTimer);
            }
        });
        binding.btn15Min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler3 = new Handler();
                handler3.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(requireContext(), R.string.timer_15_min, Toast.LENGTH_SHORT).show();
                        cliclk();

                    }
                }, 900000);
                Navigation.findNavController(v).navigate(R.id.backSleepTimer);
            }
        });
        binding.btn30Min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler4 = new Handler();
                handler4.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(requireContext(), R.string.timer_30_min, Toast.LENGTH_SHORT).show();cliclk();
                    }
                }, 1800000);
                Navigation.findNavController(v).navigate(R.id.backSleepTimer);
            }
        });
        binding.btn45Min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler5 = new Handler();
                handler5.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(requireContext(), R.string.timer_45_min, Toast.LENGTH_SHORT).show(); cliclk();
                    }
                }, 2700000);
                Navigation.findNavController(v).navigate(R.id.backSleepTimer);
            }
        });
        binding.btn1Hour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler6 = new Handler();
                handler6.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(requireContext(), R.string.timer_1_hour, Toast.LENGTH_SHORT).show();
                        cliclk();
                        handler6.removeCallbacks(this::run);
                    }
                }, 3600000);

                Navigation.findNavController(v).navigate(R.id.backSleepTimer);
            }
        });
        binding.btnEndOfTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Navigation.findNavController(v).navigate(R.id.backSleepTimer);
            }
        });
        binding.btnEndOfPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.backSleepTimer);

            }
        });
        return binding.getRoot();
    }

    public void cliclk() {
        service.clickPlayFromPlayerActivity(1, 5);
    }
}
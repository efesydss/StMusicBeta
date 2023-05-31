package com.st.stmusic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.st.stmusic.databinding.FragmentControlLockScreenBinding;


public class ControlLockScreenFragment extends Fragment {
    FragmentControlLockScreenBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentControlLockScreenBinding.inflate(inflater, container, false);
        ((AppCompatActivity) getActivity()).setSupportActionBar(binding.toolbarControlLock);
        binding.toolbarControlLock.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);

        binding.toolbarControlLock.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.backControlLockScreenFragment);
            }
        });
        return binding.getRoot();
    }
}
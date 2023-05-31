package com.st.stmusic.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.st.stmusic.databinding.FragmentDonateUsBinding;


public class DonateUsFragment extends Fragment {
    FragmentDonateUsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDonateUsBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }
}
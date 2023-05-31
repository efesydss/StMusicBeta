package com.st.stmusic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.st.stmusic.databinding.FragmentManageTabBinding;


public class ManageTabFragment extends Fragment {
    FragmentManageTabBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentManageTabBinding.inflate(inflater, container, false);
        ((AppCompatActivity) getActivity()).setSupportActionBar(binding.toolbarManageTab);
        binding.toolbarManageTab.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);

        binding.toolbarManageTab.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.backToManageTabFragment);
            }
        });
        return binding.getRoot();
    }
}
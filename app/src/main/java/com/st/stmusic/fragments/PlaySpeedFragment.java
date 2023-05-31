package com.st.stmusic.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.st.stmusic.R;
import com.st.stmusic.databinding.FragmentPlaySpeedBinding;


public class PlaySpeedFragment extends Fragment {
    public static boolean btn1, btn2, btn3, btn4, btn5, btn6;
    FragmentPlaySpeedBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPlaySpeedBinding.inflate(inflater, container, false);
        ((AppCompatActivity) getActivity()).setSupportActionBar(binding.toolbarPlaySpeed);
        binding.toolbarPlaySpeed.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);

        binding.toolbarPlaySpeed.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.backPlaySpeed);
            }
        });

        btn1 = true;
        btn2 = true;
        btn3 = true;
        btn4 = true;
        btn5 = true;
        btn6 = true;

        defButton();

        binding.btnRestoreDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restoreDefault();
            }
        });

        binding.btn050x.setOnClickListener(new View.OnClickListener() {
            //fix it
            @Override
            public void onClick(View v) {
                if (btn1 == false) {
                    btn1 = true;
                    binding.btn050x.setImageResource(R.drawable.btn050white);
                } else {
                    binding.btn050x.setImageResource(R.drawable.btn050active);
                    allDeactivate("btn1");

                }
            }
        });
        binding.btn075x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (btn2 == false) {
                    btn2 = true;
                    binding.btn075x.setImageResource(R.drawable.btn075white);
                } else {
                    binding.btn075x.setImageResource(R.drawable.btn075active);

                    allDeactivate("btn2");

                }
            }
        });
        binding.btnDefaultSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn3 == false) {
                    btn3 = true;
                    binding.btnDefaultSpeed.setImageResource(R.drawable.btndefaultwihte);
                } else {
                    binding.btnDefaultSpeed.setImageResource(R.drawable.btndefaultactive);

                    allDeactivate("btn3");

                }
            }
        });
        binding.btn15x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn4 == false) {
                    btn4 = true;
                    binding.btn15x.setImageResource(R.drawable.btn15white);
                } else {
                    binding.btn15x.setImageResource(R.drawable.btn15active);

                    allDeactivate("btn4");

                }
            }
        });
        binding.btn175x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn5 == false) {
                    btn5 = true;
                    binding.btn175x.setImageResource(R.drawable.btn175white);
                } else {
                    binding.btn175x.setImageResource(R.drawable.btn175active);

                    allDeactivate("btn5");

                }
            }
        });
        binding.btn2x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn6 == false) {
                    btn6 = true;
                    binding.btn2x.setImageResource(R.drawable.btn2white);
                } else {
                    binding.btn2x.setImageResource(R.drawable.btn2active);

                    allDeactivate("btn6");

                }
            }
        });
        return binding.getRoot();
    }

    public void allDeactivate(String btn) {

        if (btn1 && !btn.equals("btn1")) {

            binding.btn050x.setImageResource(R.drawable.btn050white);
            btn1 = true;
        }
        if (btn2 && !btn.equals("btn2")) {
            binding.btn075x.setImageResource(R.drawable.btn075white);
            btn2 = true;
        }//0555 972 1324
        if (btn3 && !btn.equals("btn3")) {
            binding.btnDefaultSpeed.setImageResource(R.drawable.btndefaultwihte);
            btn3 = true;
        }
        if (btn4 && !btn.equals("btn4")) {
            binding.btn15x.setImageResource(R.drawable.btn15white);
            btn4 = true;
        }
        if (btn5 && !btn.equals("btn5")) {
            binding.btn175x.setImageResource(R.drawable.btn175white);
            btn5 = true;
        }
        if (btn6 && !btn.equals("btn6")) {
            binding.btn2x.setImageResource(R.drawable.btn2white);
            btn6 = true;
        }
    }

    public void activateOfButtons(boolean IsActivate, String btn) {
        if (IsActivate) {
            String selected = btn;
            if (btn.equals("btn1")) {
                btn1 = true;
                btn2 = false;
                btn3 = false;
                btn4 = false;
                btn5 = false;
                btn6 = false;
                //binding.btn050x.setImageResource(R.drawable.vct050);
            } else if (btn.equals("btn2")) {
                btn1 = false;
                btn2 = true;
                btn3 = false;
                btn4 = false;
                btn5 = false;
                btn6 = false;
                //   binding.btn075x.setImageResource(R.drawable.ic_75x);
            } else if (btn.equals("btn3")) {
                btn1 = false;
                btn2 = false;
                btn3 = true;
                btn4 = false;
                btn5 = false;
                btn6 = false;
            } else if (btn.equals("btn4")) {
                btn1 = false;
                btn2 = false;
                btn3 = false;
                btn4 = true;
                btn5 = false;
                btn6 = false;
            } else if (btn.equals("btn5")) {
                btn1 = false;
                btn2 = false;
                btn3 = false;
                btn4 = false;
                btn5 = true;
                btn6 = false;
            } else if (btn.equals("btn6")) {
                btn1 = false;
                btn2 = false;
                btn3 = false;
                btn4 = false;
                btn5 = false;
                btn6 = true;
            }
        } else {
            btn1 = false;
            btn2 = false;
            btn3 = false;
            btn4 = true;//this should be default value
            btn5 = false;
            btn6 = false;
        }
    }

    public void defButton() {
        binding.btnDefaultSpeed.setImageResource(R.drawable.btndefaultactive);
        allDeactivate("btn3");
    }

    public void restoreDefault() {
        binding.btnDefaultSpeed.setImageResource(R.drawable.btndefaultactive);
        allDeactivate("btn3");
    }
}
package com.app.profiledisplayer.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.app.profiledisplayer.R;
import com.app.profiledisplayer.databinding.ActivityHomeBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        loadFragment();
    }


    private void  loadFragment(){
        getSupportFragmentManager().beginTransaction()
                .add(binding.fragmentContainerView.getId(), HomeFragment.class, null)
                .commit();
    }



}

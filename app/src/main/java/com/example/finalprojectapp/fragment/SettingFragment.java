package com.example.finalprojectapp.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.fragment.app.Fragment;

import com.example.finalprojectapp.R;
import com.example.finalprojectapp.R;


public class SettingFragment extends Fragment {

    MediaPlayer sound;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        sound = MediaPlayer.create(getContext(), R.raw.heartbeat2);
        Switch aSwitch = (Switch) view.findViewById(R.id.soundswitch);


        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sound.setLooping(isChecked);

                if(isChecked)  {
                    sound.start();
                } else {
                    sound.stop();
                }

            }
        });
        return view;
    }
}
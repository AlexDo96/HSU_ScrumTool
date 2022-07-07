package com.example.tuananh.hsuscrumtool.activities.ScrumMaster;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tuananh.hsuscrumtool.R;


public class TasksScrumMasterFragment extends Fragment {
    private LayoutInflater inflater;
    private ViewGroup container;
    private Bundle savedInstanceState;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        this.container = container;
        this.savedInstanceState = savedInstanceState;
        View view=inflater.inflate(R.layout.fragment_tasks_scrum_master,container,false);
        return view;//super.onCreateView(inflater, container, savedInstanceState);
    }
}

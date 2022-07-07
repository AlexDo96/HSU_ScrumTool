package com.example.tuananh.hsuscrumtool.activities.Developer;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.tuananh.hsuscrumtool.R;
import com.example.tuananh.hsuscrumtool.adapters.SprintEventDevAdapter;
import com.example.tuananh.hsuscrumtool.models.SprintEvent;

import java.util.ArrayList;

/**
 * Created by HK on 16/10/2017.
 */

public class SprintEventDevFragment extends Fragment {


    ListView lvSprintEvent;
    ArrayList<SprintEvent> arraySprintEventList;
    SprintEventDevAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_sprint_event_dev,container,false);
        lvSprintEvent = (ListView) view.findViewById(R.id.fragment_sprint_event_dev_lv_sprintevent_list);

        arraySprintEventList = new ArrayList<>();

        adapter = new SprintEventDevAdapter(getActivity(), R.layout.row_sprint_event_list, arraySprintEventList);
        lvSprintEvent.setAdapter(adapter);

        return view;
    }
}

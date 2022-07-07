package com.example.tuananh.hsuscrumtool.activities.Developer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tuananh.hsuscrumtool.R;

public class TasksStatisticalFragment extends Fragment {

    int num_of_tasks, num_of_todo, num_of_doing, num_of_done;
    TextView txtNumOfTasks, txtNumOfTodo, txtNumOfDoing, txtNumOfDone;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_tasks_statistical,container,false);

        txtNumOfTasks = (TextView) view.findViewById(R.id.fragment_tasks_statistical_tv_num_of_task);
        txtNumOfTodo = (TextView) view.findViewById(R.id.fragment_tasks_statistical_tv_num_of_todo);
        txtNumOfDoing = (TextView) view.findViewById(R.id.fragment_tasks_statistical_tv_num_of_doing);
        txtNumOfDone = (TextView) view.findViewById(R.id.fragment_tasks_statistical_tv_num_of_done);

        txtNumOfTasks.setText(String.valueOf(num_of_tasks));
        txtNumOfTodo.setText(String.valueOf(num_of_todo));
        txtNumOfDoing.setText(String.valueOf(num_of_doing));
        txtNumOfDone.setText(String.valueOf(num_of_done));

        return view;
    }
}

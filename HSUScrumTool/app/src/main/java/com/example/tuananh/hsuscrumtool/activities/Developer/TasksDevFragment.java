package com.example.tuananh.hsuscrumtool.activities.Developer;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.tuananh.hsuscrumtool.R;
import com.example.tuananh.hsuscrumtool.adapters.TasksDevAdapter;
import com.example.tuananh.hsuscrumtool.models.Task;

import java.util.ArrayList;

public class TasksDevFragment extends Fragment {

    ListView lvTask;
    ArrayList<Task> arrayTaskList;
    TasksDevAdapter adapter;

    String urltaskdev ="http://192.168.1.5/HSUScrumToolWebService/select_task_dev.php";
    String urlupdatetaskdev ="http://192.168.1.5/HSUScrumToolWebService/update_task_dev.php";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view=inflater.inflate(R.layout.fragment_tasks__developer,container,false);
        lvTask = (ListView) view.findViewById(R.id.fragment_tasks_developer_lv_task_list);

        arrayTaskList = new ArrayList<>();

        adapter = new TasksDevAdapter(getActivity(), R.layout.row_task_list, arrayTaskList);
        lvTask.setAdapter(adapter);

        Task.DetailTaskDev(urltaskdev,);

        lvTask.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                DialogUpdate(i);

                return false;
            }
        });

        return view;
    }

    private void DialogUpdate(final int index){
        final Dialog diaglog = new Dialog(TasksDevFragment.this);

        diaglog.setContentView(R.layout.dialog_tasks_update_dev);

        Button btnTodo= (Button) diaglog.findViewById(R.id.dialog_tasks_update_dev_btnTodo);
        Button btnDoing= (Button) diaglog.findViewById(R.id.dialog_tasks_update_dev_btnDoing);
        Button btnDone= (Button) diaglog.findViewById(R.id.dialog_tasks_update_dev_btnDone);

        btnTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int taskID = arrayTaskList.get(index).getTaskID();
                String TaskStatus = "To Do";

                Task.UpdateTaskDev(urlupdatetaskdev, taskID, TaskStatus,);
                adapter.notifyDataSetChanged();
                diaglog.dismiss();
            }
        });

        btnDoing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int taskID  = arrayTaskList.get(index).getTaskID();
                String TaskStatus = "Doing";

                Task.UpdateTaskDev(urlupdatetaskdev, taskID, TaskStatus,);
                adapter.notifyDataSetChanged();
                diaglog.dismiss();
            }
        });

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int taskID = arrayTaskList.get(index).getTaskID();
                String TaskStatus = "Done";

                Task.UpdateTaskDev(urlupdatetaskdev, taskID, TaskStatus,);
                adapter.notifyDataSetChanged();
                diaglog.dismiss();
            }
        });

        diaglog.show();
    }

}

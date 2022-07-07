package com.example.tuananh.hsuscrumtool.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.tuananh.hsuscrumtool.R;
import com.example.tuananh.hsuscrumtool.models.Task;

import java.util.List;

/**
 * Created by HK on 16/10/2017.
 */

public class TasksDevAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Task> taskList;

    public TasksDevAdapter(Context context, int layout, List<Task> taskList) {
        this.context = context;
        this.layout = layout;
        this.taskList = taskList;
    }

    @Override
    public int getCount() {
        return taskList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView txtTaskID, txtTaskDescription, txtTaskStatus;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if(view==null){
            holder=new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);

            holder.txtTaskID= (TextView) view.findViewById(R.id.row_task_list_tv_task_id);
            holder.txtTaskDescription= (TextView) view.findViewById(R.id.row_task_list_tv_task_description);
            holder.txtTaskStatus= (TextView) view.findViewById(R.id.row_task_list_tv_task_status);

            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        //Tạo ra đối tượng task từ List<Task> để có thể getTaskID, getTaskDescription, v.v..
        final Task task = taskList.get(i); //get vị trí thứ i

        holder.txtTaskID.setText(task.getTaskID());
        holder.txtTaskDescription.setText(task.getTaskDescription());
        holder.txtTaskStatus.setText(task.getTaskStatus());

        return view;
    }
}

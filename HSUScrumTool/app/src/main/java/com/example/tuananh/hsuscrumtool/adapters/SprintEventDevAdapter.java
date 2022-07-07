package com.example.tuananh.hsuscrumtool.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tuananh.hsuscrumtool.R;
import com.example.tuananh.hsuscrumtool.models.SprintEvent;


import java.util.List;

/**
 * Created by HK on 16/10/2017.
 */

public class SprintEventDevAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<SprintEvent> sprintEventList;

    public SprintEventDevAdapter(Context context, int layout, List<SprintEvent> sprintEventList) {
        this.context = context;
        this.layout = layout;
        this.sprintEventList = sprintEventList;
    }

    @Override
    public int getCount() {
        return sprintEventList.size();
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
        TextView txtSprintID, txtEventType, txtEventDate, txtContent;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if(view==null){
            holder=new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);

            holder.txtSprintID= (TextView) view.findViewById(R.id.row_sprint_event_list_tv_sprint_id);
            holder.txtEventType= (TextView) view.findViewById(R.id.row_sprint_event_list_tv_event_type);
            holder.txtEventDate= (TextView) view.findViewById(R.id.row_sprint_event_list_tv_event_date);
            holder.txtContent= (TextView) view.findViewById(R.id.row_sprint_event_list_tv_event_content);

            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        //Tạo ra đối tượng sprintEvent từ List<SprintEvent> để có thể getSprintID, getEventType, v.v..
        final SprintEvent sprintEvent = sprintEventList.get(i); //get vị trí thứ i

        holder.txtSprintID.setText(sprintEvent.getSprintID());
        holder.txtEventType.setText(sprintEvent.getEventType());
        holder.txtEventDate.setText(sprintEvent.getEventDate().toString());
        holder.txtContent.setText(sprintEvent.getContent());

        return view;
    }
}

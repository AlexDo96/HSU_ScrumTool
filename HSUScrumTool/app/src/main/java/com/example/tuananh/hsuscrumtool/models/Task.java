package com.example.tuananh.hsuscrumtool.models;

import android.app.Fragment;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tuananh.hsuscrumtool.activities.Developer.DeveloperActivity;
import com.example.tuananh.hsuscrumtool.activities.Developer.TasksDevFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tuan Anh on 06/10/2017.
 */

public class Task {
    private int TaskID;
    private int SprintBacklogID;
    private String TaskDescription;
    private String TaskStatus;
    private int DeveloperID;

    public Task(int taskID, String taskDescription, String taskStatus) {
        TaskID = taskID;
        TaskDescription = taskDescription;
        TaskStatus = taskStatus;
    }

    public Task(int taskID, int sprintBacklogID, String taskDescription, String taskStatus) {
        TaskID = taskID;
        SprintBacklogID = sprintBacklogID;
        TaskDescription = taskDescription;
        TaskStatus = taskStatus;
    }

    public int getTaskID() {
        return TaskID;
    }

    public void setTaskID(int taskID) {
        TaskID = taskID;
    }

    public int getSprintBacklogID() {
        return SprintBacklogID;
    }

    public void setSprintBacklogID(int sprintBacklogID) {
        SprintBacklogID = sprintBacklogID;
    }

    public String getTaskDescription() {
        return TaskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        TaskDescription = taskDescription;
    }

    public String getTaskStatus() {
        return TaskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        TaskStatus = taskStatus;
    }




    //H??m SelectData th??ng qua JSON g???i l??n WebService
    public static void DetailTask(String url, final Context context) {
        //T???o Request ?????n WebService
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {  //L???ng nghe t??n hi???u tr??? v??? t??? WebService
                    @Override
                    public void onResponse(JSONArray response) {
                        //Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();

                        //G???i ph????ng th???c t??? class kh??c th??ng qua context
                       /* MainActivity main = (MainActivity)context;
                        main.arraySinhVien.clear(); //X??a d??? li???u khi ???? b???m n??t x??a v?? th???c hi???n function DeleteSinhVien()
                        // n???u ko c?? b?????c n??y n?? s??? ko x??a tr??n Listview
                        // th???m ch?? d??? li???u tr??n Listview c??n nhi???u h??n ban ?????u
                        */

                        for (int i =0; i<response.length(); i++)
                        {
                            try {
                                JSONObject object = response.getJSONObject(i); //T???o ?????i t?????ng JSON Object
                                //Tr??? v??? ArrayList<SinhVien> th??ng qua Key c???a JSON Object
                                /*main.arraySinhVien.add(new SinhVien(
                                        object.getInt("ID"),
                                        object.getString("Hoten"),
                                        object.getInt("Namsinh"),
                                        object.getString("Diachi")

                                ));*/
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        //main.adapter.notifyDataSetChanged(); //Cho Adapter nh???n bi???t s??? thay ?????i d??? li???u

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "L???i", Toast.LENGTH_SHORT).show();
                    }
                }

        );
        requestQueue.add(jsonArrayRequest);
    }


    public static void DetailTaskDev(String url, final Context context){
        //T???o Request ?????n WebService
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();

                        TasksDevFragment devFragment = (DeveloperActivity)context;

                        for (int i =0; i<response.length(); i++)
                        {
                            try {
                                //Ph???i new ?????i t?????ng ki???u JSONArray v?? g??n response v??? ????? ??p ki???u n?? v??? JSONArray
                                JSONObject object = new JSONArray(response).getJSONObject(i); //T???o ?????i t?????ng JSON Object
                                //Tr??? v??? ArrayList<SinhVien> th??ng qua Key c???a JSON Object
                                devFragment.arrayTaskList.add(new Task(
                                        object.getInt("TaskID"),
                                        object.getString("TaskDescription"),
                                        object.getString("TaskStatus")
                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        devFragment.adapter.notifyDataSetChanged();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "L???i qu?? tr??nh", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            //Post l??n web service d???ng Map v???i Key v?? Value ????? x??? l?? t??c v???
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<>();
                params.put("AccountID"," ");

                return params;
            }
        };

        requestQueue.add(stringRequest);
    }

    //H??m CreateTask (Ph????ng th???c POST)
    public static void CreateTask(String url, final Context context){
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("success")){
                            Toast.makeText(context, "Th??m th??nh c??ng", Toast.LENGTH_SHORT).show();

                        }else {
                            Toast.makeText(context, "L???i th??m", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "L???i qu?? tr??nh", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<>();


                return params;
            }
        };

        requestQueue.add(stringRequest);
    }

    //H??m UpdateTask (Ph????ng th???c POST)
    public static void UpdateTask(String url, final Context context){
        final RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("success")){
                            Toast.makeText(context, "C???p nh???t th??nh c??ng", Toast.LENGTH_SHORT).show();

                        }else {
                            Toast.makeText(context, "L???i c???p nh???t", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "L???i qu?? tr??nh", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<>();

                return params;
            }
        };

        requestQueue.add(stringRequest);
    }


    //H??m UpdateTask (Ph????ng th???c POST)
    public static void UpdateTaskDev(String url, final int TaskID , final String TaskStatus, final Context context){
        final RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("success")){
                            Toast.makeText(context, "C???p nh???t th??nh c??ng", Toast.LENGTH_SHORT).show();

                        }else {
                            Toast.makeText(context, "L???i c???p nh???t", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "L???i qu?? tr??nh", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<>();

                params.put("TaskStatus",TaskStatus);
                params.put("TaskID",String.valueOf(TaskID));

                return params;
            }
        };

        requestQueue.add(stringRequest);
    }

    //H??m DeleteTask(Ph????ng th???c POST)
    public static void DeleteTask(String url, final int id, final Context context){
        //T???o Request ?????n WebService
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        //N???u l???y d??? li???u v??? th?? d??ng JSONRequest c??n Post d??? li???u l??n th?? d??ng StringRequest
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("success")){
                            Toast.makeText(context, "X??a th??nh c??ng", Toast.LENGTH_SHORT).show();

                        }else {
                            Toast.makeText(context, "L???i x??a", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "L???i qu?? tr??nh", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            //Post l??n web service d???ng Map v???i Key v?? Value ????? x??? l?? t??c v???
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<>();

                params.put("idSV",String.valueOf(id)); // Truy???n v??o id v??? tr?? mu???n x??a
                //Nh??? s???a l???i key "idSV" th??nh t??n id c???a ?????i t?????ng trong CSDL
                return params;
            }
        };

        requestQueue.add(stringRequest);
    }

}

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




    //Hàm SelectData thông qua JSON gửi lên WebService
    public static void DetailTask(String url, final Context context) {
        //Tạo Request đến WebService
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {  //Lắng nghe tín hiệu trả về từ WebService
                    @Override
                    public void onResponse(JSONArray response) {
                        //Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();

                        //Gọi phương thức từ class khác thông qua context
                       /* MainActivity main = (MainActivity)context;
                        main.arraySinhVien.clear(); //Xóa dữ liệu khi đã bấm nút xóa và thực hiện function DeleteSinhVien()
                        // nếu ko có bước này nó sẽ ko xóa trên Listview
                        // thậm chí dữ liệu trên Listview còn nhiều hơn ban đầu
                        */

                        for (int i =0; i<response.length(); i++)
                        {
                            try {
                                JSONObject object = response.getJSONObject(i); //Tạo đối tượng JSON Object
                                //Trả về ArrayList<SinhVien> thông qua Key của JSON Object
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

                        //main.adapter.notifyDataSetChanged(); //Cho Adapter nhận biết sự thay đổi dữ liệu

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "Lỗi", Toast.LENGTH_SHORT).show();
                    }
                }

        );
        requestQueue.add(jsonArrayRequest);
    }


    public static void DetailTaskDev(String url, final Context context){
        //Tạo Request đến WebService
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
                                //Phải new Đối tượng kiểu JSONArray và gán response về để ép kiểu nó về JSONArray
                                JSONObject object = new JSONArray(response).getJSONObject(i); //Tạo đối tượng JSON Object
                                //Trả về ArrayList<SinhVien> thông qua Key của JSON Object
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
                        Toast.makeText(context, "Lỗi quá trình", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            //Post lên web service dạng Map với Key và Value để xử lý tác vụ
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<>();
                params.put("AccountID"," ");

                return params;
            }
        };

        requestQueue.add(stringRequest);
    }

    //Hàm CreateTask (Phương thức POST)
    public static void CreateTask(String url, final Context context){
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("success")){
                            Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show();

                        }else {
                            Toast.makeText(context, "Lỗi thêm", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "Lỗi quá trình", Toast.LENGTH_SHORT).show();
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

    //Hàm UpdateTask (Phương thức POST)
    public static void UpdateTask(String url, final Context context){
        final RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("success")){
                            Toast.makeText(context, "Cập nhật thành công", Toast.LENGTH_SHORT).show();

                        }else {
                            Toast.makeText(context, "Lỗi cập nhật", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "Lỗi quá trình", Toast.LENGTH_SHORT).show();
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


    //Hàm UpdateTask (Phương thức POST)
    public static void UpdateTaskDev(String url, final int TaskID , final String TaskStatus, final Context context){
        final RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("success")){
                            Toast.makeText(context, "Cập nhật thành công", Toast.LENGTH_SHORT).show();

                        }else {
                            Toast.makeText(context, "Lỗi cập nhật", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "Lỗi quá trình", Toast.LENGTH_SHORT).show();
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

    //Hàm DeleteTask(Phương thức POST)
    public static void DeleteTask(String url, final int id, final Context context){
        //Tạo Request đến WebService
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        //Nếu lấy dữ liệu về thì dùng JSONRequest còn Post dữ liệu lên thì dùng StringRequest
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("success")){
                            Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();

                        }else {
                            Toast.makeText(context, "Lỗi xóa", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "Lỗi quá trình", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            //Post lên web service dạng Map với Key và Value để xử lý tác vụ
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<>();

                params.put("idSV",String.valueOf(id)); // Truyền vào id vị trí muốn xóa
                //Nhớ sửa lại key "idSV" thành tên id của đối tượng trong CSDL
                return params;
            }
        };

        requestQueue.add(stringRequest);
    }

}

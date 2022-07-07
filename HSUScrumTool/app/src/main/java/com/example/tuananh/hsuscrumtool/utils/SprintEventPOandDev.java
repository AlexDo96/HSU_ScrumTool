package com.example.tuananh.hsuscrumtool.utils;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.tuananh.hsuscrumtool.models.SprintEvent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by Tuan Anh on 06/10/2017.
 */

public class SprintEventPOandDev extends SprintEvent {
    public SprintEventPOandDev(int sprintEventID, String eventType, Date eventDate, String content) {
        super(sprintEventID, eventType, eventDate, content);
    }

    //Hàm SelectData thông qua JSON gửi lên WebService
    public static void DetailEvent(String url, final Context context) {
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
}

package com.example.tuananh.hsuscrumtool.models;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tuan Anh on 06/10/2017.
 */

public class Account {
    private String Username;
    private String Password;
    private String FullName;
    private String MobilePhone;
    private String Email;
    private String ScrumRole;

    public Account(String username, String password, String fullName, String mobilePhone, String email, String scrumRole) {
        Username = username;
        Password = password;
        FullName = fullName;
        MobilePhone = mobilePhone;
        Email = email;
        ScrumRole = scrumRole;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getMobilePhone() {
        return MobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        MobilePhone = mobilePhone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getScrumRole() {
        return ScrumRole;
    }

    public void setScrumRole(String scrumRole) {
        ScrumRole = scrumRole;
    }


    //Hàm SelectData thông qua JSON gửi lên WebService
    public static void SelectAccount(String url, final Context context) {
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

    //Hàm Create Account (Phương thức POST)
    public static void CreateAccount(String url, final Context context){
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


    //Hàm Update Account (Phương thức POST)
    public static void EditAccount(String url, final Context context){
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



}

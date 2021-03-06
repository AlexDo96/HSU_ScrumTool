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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tuan Anh on 06/10/2017.
 */

public class Project {
    private int ProjectID;
    private String ProjectName;
    private String Requirement;
    private Date StartDate;
    private int EstimateTime;
    private Date EndDate;
    private String ProjectStatus;
    private String ProductOwner;
    private String ScrumMaster;

    public Project(int projectID, String projectName, String requirement, Date startDate, int estimateTime, Date endDate, String projectStatus, String productOwner, String scrumMaster) {
        ProjectID = projectID;
        ProjectName = projectName;
        Requirement = requirement;
        StartDate = startDate;
        EstimateTime = estimateTime;
        EndDate = endDate;
        ProjectStatus = projectStatus;
        ProductOwner = productOwner;
        ScrumMaster = scrumMaster;
    }

    public int getProjectID() {
        return ProjectID;
    }

    public void setProjectID(int projectID) {
        ProjectID = projectID;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public String getRequirement() {
        return Requirement;
    }

    public void setRequirement(String requirement) {
        Requirement = requirement;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public int getEstimateTime() {
        return EstimateTime;
    }

    public void setEstimateTime(int estimateTime) {
        EstimateTime = estimateTime;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public String getProjectStatus() {
        return ProjectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        ProjectStatus = projectStatus;
    }

    public String getProductOwner() {
        return ProductOwner;
    }

    public void setProductOwner(String productOwner) {
        ProductOwner = productOwner;
    }

    public String getScrumMaster() {
        return ScrumMaster;
    }

    public void setScrumMaster(String scrumMaster) {
        ScrumMaster = scrumMaster;
    }

    //H??m SelectData th??ng qua JSON g???i l??n WebService
    public static void DetailProject(String url, final Context context) {
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


    //H??m CreateProject (Ph????ng th???c POST)
    public static void CreateProject(String url, final Context context){
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

    //H??m UpdateProject (Ph????ng th???c POST)
    public static void UpdateProject(String url, final Context context){
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

    //H??m DeleteProject(Ph????ng th???c POST)
    public static void DeleteProject(String url, final int id, final Context context){
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

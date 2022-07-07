package com.example.tuananh.hsuscrumtool.activities;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;

import com.example.tuananh.hsuscrumtool.R;


import com.example.tuananh.hsuscrumtool.activities.Developer.DeveloperActivity;
import com.example.tuananh.hsuscrumtool.activities.ProductOwner.ProductOwnerActivity;
import com.example.tuananh.hsuscrumtool.activities.ScrumMaster.ScrumMasterActivity;


public class SignInActivity extends AppCompatActivity {

    EditText etUsername, etPass;
    Button btnSignin, btnSignup, btnExit;
    String username, pass;
    /*
    Spinner spin ;
    TextView tvChosse;
    String arr[]={
            "Product Owner",
            "Scrum Master",
            "Developer"};
*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Anhxa();
        ControlButton();
    }

    private void ControlButton() {
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog diaglogexit = new Dialog(SignInActivity.this);
                diaglogexit.setCancelable(false);
                diaglogexit.setContentView(R.layout.dialog_exit);

                Button btnYes = (Button)diaglogexit.findViewById(R.id.btn_yes);
                Button btnNo = (Button)diaglogexit.findViewById(R.id.btn_no);

                btnYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onBackPressed();
                    }
                });

                btnNo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        diaglogexit.cancel();
                    }
                });

                diaglogexit.show();

                Display display = ((WindowManager)getSystemService(SignInActivity.WINDOW_SERVICE)).getDefaultDisplay();
                int width= display.getWidth();
                int height= display.getHeight();

                diaglogexit.getWindow().setLayout((6*width)/6,(height)/3);
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog diaglogsignup = new Dialog(SignInActivity.this);
                diaglogsignup.setCancelable(false);
                diaglogsignup.setContentView(R.layout.dialog_signup);
//AddItemSpiner();
                final EditText et_dialog_Username = (EditText)diaglogsignup.findViewById(R.id.et_username);
                final EditText et_dialog_Pass = (EditText)diaglogsignup.findViewById(R.id.et_pass);
                Button btnCancel = (Button)diaglogsignup.findViewById(R.id.btn_cancel);
                Button btnCreate = (Button)diaglogsignup.findViewById(R.id.btn_create);

                btnCreate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        username= et_dialog_Username.getText().toString().trim();
                        pass= et_dialog_Pass.getText().toString().trim();

                        etUsername.setText(username);
                        etPass.setText(pass);

                        diaglogsignup.cancel();
                    }
                });

                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        diaglogsignup.cancel();
                    }
                });

                diaglogsignup.show();

                Display display = ((WindowManager)getSystemService(SignInActivity.WINDOW_SERVICE)).getDefaultDisplay();
                int width= display.getWidth();
                int height= display.getHeight();

                diaglogsignup.getWindow().setLayout((6*width)/7,(4*height)/5);
            }
        });

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etUsername.getText().length() !=0 && etPass.getText().length()!=0)
                {
                    if (etUsername.getText().toString().equals(username) && etPass.getText().toString().equals(pass))
                    {
                        // Toast.makeText(SignInActivity.this, "Signin successful", Toast.LENGTH_SHORT).show();

                    }
                    //   Toast.makeText(SignInActivity.this,etUsername.getText().toString(),Toast.LENGTH_SHORT).show();
                    if(etUsername.getText().toString().compareTo("a")==0)
                    {
                        Intent i =new Intent(SignInActivity.this,ProductOwnerActivity.class);
                        startActivity(i);
                    }
                    if(etUsername.getText().toString().compareTo("b")==0)
                    {
                       Intent i =new Intent(SignInActivity.this,ScrumMasterActivity.class);
                       startActivity(i);
                    }
                    if(etUsername.getText().toString().compareTo("c")==0)
                    {
                        Intent i =new Intent(SignInActivity.this,DeveloperActivity.class);
                        startActivity(i);
                    }

                    else
                    {
                        Toast.makeText(SignInActivity.this,"Signin fail",Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(SignInActivity.this,"Please check your username and password again",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Anhxa() {
        etUsername = (EditText) findViewById(R.id.activity_sign_in_et_username);
        etPass = (EditText) findViewById(R.id.activity_sign_in_et_pass);
        btnSignin = (Button) findViewById(R.id.activity_sign_in_btn_signin);
        btnSignup = (Button) findViewById(R.id.activity_sign_in_btn_signup);
        btnExit = (Button) findViewById(R.id.activity_sign_in_btn_exit);
       //  spin=(Spinner) findViewById(R.id.spn_role);
      //  tvChosse = (TextView) findViewById(R.id.tv_Chosse);
    }
    /*
    private  void AddItemSpiner()
    {
        ArrayAdapter<String> adapter=new ArrayAdapter<String>
                (
                        this,
                        android.R.layout.simple_spinner_item,
                        arr
                );
        adapter.setDropDownViewResource
                (android.R.layout.simple_list_item_single_choice);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new MyProcessEvent());
    }
    private class MyProcessEvent implements
            OnItemSelectedListener
    {
        //Khi có chọn lựa thì vào hàm này
        public void onItemSelected(AdapterView<?> arg0,
                                   View arg1,
                                   int arg2,
                                   long arg3) {
            //arg2 là phần tử được chọn trong data source
           tvChosse.setText(arr[arg2]);
        }
        //Nếu không chọn gì cả
        public void onNothingSelected(AdapterView<?> arg0) {
            tvChosse.setText("");
        }
    }*/
}

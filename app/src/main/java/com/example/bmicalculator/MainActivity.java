package com.example.bmicalculator;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//บรรทัดนี้จะเกิดobject ขึ้นตามหน้าจอที่เราsetไว้
        //ถ้าตัวRเป็นตัวแดงแสดงว่าerrorที่ res โดยมากจะเป็นlayout

        final Button calculateButton = findViewById(R.id.calculate_button);//อ้างอิงปุ่ม
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText heightEditText = findViewById(R.id.height_edit_text);
                EditText weightEditText = findViewById(R.id.weight_edit_text);



                if(heightEditText.getText().toString().equals("")||weightEditText.getText().toString().equals("")){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setMessage("ERROR");
                    dialog.show();
                }else {
                    int h = Integer.parseInt(heightEditText.getText().toString());//แปลงเป็นint เพราะที่user ส่งมาเป็นString
                    int w = Integer.parseInt(weightEditText.getText().toString());
                    float bmi = calculatebmi(h, w);

                    String resultText = null;
                    if (bmi < 18.5) {
                        resultText = "ผอมเกินไป";
                    } else if (bmi < 25) {
                        resultText = "ปกติ";
                    } else if (bmi < 30) {
                        resultText = "อ้วน";
                    } else resultText = "อ้วนมากกก";

                    String msg = "น้ำหนักอยู่ในเกณฑ์: " + resultText;
                    Toast t = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG);
                    t.show();
                /*String msg = "ค่า bmi = " + String.format(Locale.US,"%.2f",bmi);

                //Toast t = Toast.makeText(MainActivity.this, "ค่า bmi = " + String.valueOf(bmi), Toast.LENGTH_LONG);
                Toast t = Toast.makeText(MainActivity.this,msg, Toast.LENGTH_LONG);
                t.show();*/
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("Result");
                    dialog.setMessage(msg);

                    //ถ้าเป็น negative button นั้นจะอยู่ทางขวาสุด

                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //codeที่จะทำเมื่อuser click ok in dialog
                            finish();
                        }
                    });//ปุ่มที่เป็นการยอมรับนิยมใช้อันนี้
                    dialog.setNegativeButton("NO", null);
                    dialog.setCancelable(false);//การบังคับให้userต้องกดdialogเท่านั้นนนนนนนนนน
                    dialog.show();
                    //new AlertDialog.Builder(MainActivity.this).setTitle("Result").setMessage(msg).setPositiveButton("OK",null).show();
                    //เราสามารถทำได้ในบรรทัดเดียวกัน
                }
            }
        });
    }
    private float calculatebmi (int height , int weight){
        // bmi = kg/m^2
        float height_m = height/100f;
        Log.i(TAG,"ความสูงหน่วยเมตร  = "+String.valueOf(height_m));
        return weight/(height_m*height_m);
    }
}

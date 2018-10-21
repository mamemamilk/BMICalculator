package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity  /*(2)implements View.OnClickListener*/ {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //class name

        Toast t2 = Toast.makeText(this,"Andriod",Toast.LENGTH_SHORT);
        t2.show();
        //toast andriod จะไม่แสดงพร้อมกันมันจะรันตามคิวของมัน
        Button start_B = findViewById(R.id.start_button);
        /*(1)วิธี Inner class

        MyListener listener = new MyListener();
        start_B.setOnClickListener(listener);*/
        /*(2) Activity เป็น Listener
        start_B.setOnClickListener(this);//this เป็นการเรียกใช้ตัวมันเอง*/
        //วิธีที่ 3 Areny mous Inner Cliss
        start_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        Button exit_B = findViewById(R.id.exit_button);
        exit_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();//เท่ากับการกดปุ่มbackของโทรศัพท์ แอนดอย
            }
        });
        /*start_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ตรงนี้จะทำงานเมื่อ userมากดปุ่ม
                String message = "Hello";
                Toast t = Toast.makeText(SplashActivity.this,message,Toast.LENGTH_SHORT); //short ขะแสดงสั้นๆ 2-3 วินาที long 4 ขึ้นไป ตามที่กำหนด
                t.show();
            }
        });//set code ที่จะทำงานเมื่อปุ่มถูกclick
        Toast t3 = Toast.makeText(this,"Studio",Toast.LENGTH_SHORT); //short ขะแสดงสั้นๆ 2-3 วินาที long 4 ขึ้นไป ตามที่กำหนด
        t3.show();
        Button exit_B = findViewById(R.id.exit_button);
        exit_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/
    }
/*(2)
    @Override
    public void onClick(View v) {
        Log.d("bmi","Hello  Andriod");
    }*/
    /*private class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Log.d("bmi","Ok naka ");
        }
    }(1)*/
}

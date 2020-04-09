package com.example.call;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Intent intent = new Intent();
    Button call2;
    TextView sdt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        call2 = (Button) findViewById(R.id.BtnCall2);
        sdt2 = (TextView) findViewById(R.id.SDT2);
        setTitle("Thực hiện cuộc gọi");
        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = "tel:" + sdt2.getText();
                Intent intentTest = new Intent(Intent.ACTION_CALL);
                intentTest.setData(Uri.parse(phoneNumber));
                intentTest.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                if (ActivityCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intentTest);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            intent.setClass(Main2Activity.this, MainActivity.class);
            startActivity(intent);
            Main2Activity.this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

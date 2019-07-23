package com.minglin.android.configchange;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void recreate(View view) {
        startActivity(new Intent(this, RecreateActivity.class));
    }

    public void configChange(View view) {
        startActivity(new Intent(this, RetainStateActivity.class));
    }
}

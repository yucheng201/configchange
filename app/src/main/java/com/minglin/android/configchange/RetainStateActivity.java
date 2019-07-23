package com.minglin.android.configchange;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by lingjiu on 2019/7/23.
 */
public class RetainStateActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private EditText et;
    private CharSequence charSequence;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_recreate);

        initView();
        //charSequence = (CharSequence) getLastCustomNonConfigurationInstance();
        //et.setText(charSequence);
        Log.e(TAG, "onCreate");
    }

    private void initView() {
        et = ((EditText) findViewById(R.id.et));
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                charSequence = s;
            }
        });
    }


    /*@Override
    public Object onRetainNonConfigurationInstance() {
        return super.onRetainNonConfigurationInstance();
    }
*/

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        Log.e(TAG, "onRetainCustomNonConfigurationInstance");
        return charSequence;
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(TAG, "onRestoreInstanceState");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e(TAG, "onConfigurationChanged");
        int orientation = newConfig.orientation;
        if (orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.ac_recreate);
        } else {
            setContentView(R.layout.ac_recreate);
        }
        initView();
        et.setText(charSequence);
    }
}

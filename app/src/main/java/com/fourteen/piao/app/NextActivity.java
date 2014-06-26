package com.fourteen.piao.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class NextActivity extends ActionBarActivity {

    private EditText editTextGet = null;
    private EditText editTextPost = null;

    private  Button btnGet = null;
    private  Button btnPost = null;

    //----------------------------------request Baidu start
    private Button requestButton = null;
    private HttpResponse httpResponse =null;
    private HttpEntity httpEntity = null;
    //----------------------------------request Baidu end
    private Button button= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        button = (Button)findViewById(R.id.next_button_id_activity_next);
        button.setText("I am one button in the activity of 'next'");
        button.setOnClickListener(new btnNextListener());

        requestButton = (Button)findViewById(R.id.requestBaiduButton);
        requestButton.setText("getRequestButton");
        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HttpGet httpGet = new HttpGet("http://edu-tms.com/flow.php");
                HttpClient httpClient = new DefaultHttpClient();
                InputStream inputStream = null;
                try {
                    httpResponse = httpClient.execute(httpGet);
                    httpEntity = httpResponse.getEntity();
                    inputStream = httpEntity.getContent();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    String result = "";
                    String line = "";
                    while ((line = reader.readLine()) != null){
                        result += line;
                    }
                    System.out.println(result);
                } catch (IOException e) {
                    e.printStackTrace();
//                    Log.d("debug info", e.getMessage());
                }finally {
                    try{
                        inputStream.close();
                    }catch (Exception e){
                       e.printStackTrace();
                    }
                }

            }
        });
//        在Next按钮上绑定一个按钮按下的监听器
    }

    private class btnNextListener implements View.OnClickListener {



        public void onClick(View view) {
            Log.d("meddd","run");
            Intent intent = new Intent();
            intent.setClass(NextActivity.this, StaticDemo.class);
            NextActivity.this.startActivity(intent);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.next, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

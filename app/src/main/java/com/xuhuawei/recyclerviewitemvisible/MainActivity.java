package com.xuhuawei.recyclerviewitemvisible;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View btn_listView=findViewById(R.id.btn_listView);
        View btn_recyclerView=findViewById(R.id.btn_recyclerView);
        btn_listView.setOnClickListener(onClickListener);
        btn_recyclerView.setOnClickListener(onClickListener);
    }
    private View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId()==R.id.btn_listView){
                startActivity(new Intent(MainActivity.this,ListViewActivity.class));
            }else {
                startActivity(new Intent(MainActivity.this,RecyclerViewActivity.class));
            }
        }
    };
}

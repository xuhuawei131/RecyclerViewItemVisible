package com.xuhuawei.recyclerviewitemvisible;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {
    private ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listview = findViewById(R.id.listview);
        String[] names = new String[100];
        for (int i = 0; i < 100; i++) {
            names[i] = "Item-" + i;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.adapter_listview_item, R.id.text_name, names);
        listview.setAdapter(adapter);

        OnItemEnterOrExitVisibleHelper helper = new OnItemEnterOrExitVisibleHelper();

        helper.setListiewScrollListener(listview);
        helper.setOnScrollStatusListener(listener);
    }

    private OnItemEnterOrExitVisibleHelper.OnScrollStatusListener listener = new OnItemEnterOrExitVisibleHelper.OnScrollStatusListener() {
        public void onSelectEnterPosition(int postion) {
            Log.v("xhw", "进入Enter：" + postion);
        }
        public void onSelectExitPosition(int postion) {
            Log.v("xhw", "退出Exit：" + postion);
        }
    };
}

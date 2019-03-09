package com.xuhuawei.recyclerviewitemvisible;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.xuhuawei.recyclerviewitemvisible.adapters.TagAdapter;
import com.xuhuawei.recyclerviewitemvisible.beans.TagBean;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    private LinearLayoutManager layoutManager;
    private List<TagBean> tagBeanList = new ArrayList<>();
    private TagAdapter tagAdapter;

    protected void init() {
        tagBeanList.add(new TagBean("0", "准时0"));
        tagBeanList.add(new TagBean("1", "准时1"));
        tagBeanList.add(new TagBean("2", "非常绅士2"));
        tagBeanList.add(new TagBean("3", "非常有礼貌3"));
        tagBeanList.add(new TagBean("4", "很会照顾女生4"));
        tagBeanList.add(new TagBean("5", "我的男神是个大暖男哦5"));
        tagBeanList.add(new TagBean("6", "谈吐优雅6"));
        tagBeanList.add(new TagBean("7", "送我到楼下7"));
        tagBeanList.add(new TagBean("8", "送我到楼下8"));
        tagBeanList.add(new TagBean("9", "迟到9"));
        tagBeanList.add(new TagBean("10", "态度恶劣10"));
        tagBeanList.add(new TagBean("11", "有不礼貌行为22"));
        tagBeanList.add(new TagBean("12", "有侮辱性语言有暴力倾向13"));
        tagBeanList.add(new TagBean("13", "人身攻击13"));
        tagBeanList.add(new TagBean("14", "临时改变行程14"));
        tagBeanList.add(new TagBean("15", "客户迟到并无理要求延长约会时间15"));
        tagBeanList.add(new TagBean("16", "客户迟到并无理要求延长约会时间16"));
        tagBeanList.add(new TagBean("17", "客户迟到并无理要求延长约会时间17"));
        tagBeanList.add(new TagBean("18", "客户迟到并无理要求延长约会时间118"));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        init();
        recyclerView = findViewById(R.id.rvGrid);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new RecycleViewDivider(this, 0, 10, 0xfff6f6f8));

        tagAdapter = new TagAdapter(tagBeanList);
        recyclerView.setAdapter(tagAdapter);

        OnItemEnterOrExitVisibleHelper helper=new OnItemEnterOrExitVisibleHelper();

        helper.setRecyclerScrollListener(recyclerView);
        helper.setOnScrollStatusListener(listener);
    }



    private OnItemEnterOrExitVisibleHelper.OnScrollStatusListener listener=new OnItemEnterOrExitVisibleHelper.OnScrollStatusListener(){
        public  void onSelectEnterPosition(int postion){
            Log.v("xhw","进入Enter："+postion);
        }
        public  void onSelectExitPosition(int postion) {
            Log.v("xhw","退出Exit："+postion);
        }
    };

}

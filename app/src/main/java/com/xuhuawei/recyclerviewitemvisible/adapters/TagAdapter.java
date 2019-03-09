package com.xuhuawei.recyclerviewitemvisible.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.xuhuawei.recyclerviewitemvisible.R;
import com.xuhuawei.recyclerviewitemvisible.beans.TagBean;
import java.util.List;

/**
 * Created by Allen on 2017/4/14.
 *
 * 评论页面的适配器
 */

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.ViewHolder> {
    private List<TagBean> tagList;
    public TagAdapter(List<TagBean> tagList) {
        this.tagList = tagList;
    }

    @Override
    public TagAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tag_layout, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(final TagAdapter.ViewHolder holder, final int position) {
        holder.text_name.setText(tagList.get(position).getTag_name());
    }

    @Override
    public int getItemCount() {
        return tagList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View root_view;
        public TextView text_name;

        public ViewHolder(View view) {
            super(view);
            root_view=view.findViewById(R.id.root_view);
            text_name=view.findViewById(R.id.text_name);
        }
    }
}

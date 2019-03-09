package com.xuhuawei.recyclerviewitemvisible;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ListView;

public  class OnItemEnterOrExitVisibleHelper {
    private int lastStart = -1;
    private int lastEnd;

    private OnScrollStatusListener listener;

    public void setOnScrollStatusListener(OnScrollStatusListener listener) {
        this.listener = listener;
    }

    public interface OnScrollStatusListener{
        public  void onSelectEnterPosition(int postion);
        public  void onSelectExitPosition(int postion);
    }

    private void dealScrollEvent(int firstVisible, int lastVisible) {
        int visibleItemCount = lastVisible - firstVisible;
        if (visibleItemCount > 0) {
            if (lastStart == -1) {
                lastStart = firstVisible;
                lastEnd = lastVisible;
                for (int i = lastStart; i < lastEnd + 1; i++) {
                    if (listener!=null){
                        listener.onSelectEnterPosition(i);
                    }

                }
            } else {
                if (firstVisible != lastStart) {
                    if (firstVisible > lastStart) {//向上滑动
                        for (int i = lastStart; i < firstVisible; i++) {
                            if (listener!=null){
                                listener.onSelectExitPosition(i);
                            }
                        }
                    } else {//向下滑动
                        for (int i = firstVisible; i < lastStart; i++) {
                            if (listener!=null){
                                listener.onSelectEnterPosition(i);
                            }
                        }
                    }
                    lastStart = firstVisible;
                }
                //
                if (lastVisible != lastEnd) {
                    if (lastVisible > lastEnd) {//向上滑动
                        for (int i = lastEnd; i < lastVisible; i++) {
                            if (listener!=null){
                                listener.onSelectEnterPosition(i + 1);
                            }

                        }
                    } else {//向下滑动
                        for (int i = lastVisible; i < lastEnd; i++) {
                            if (listener!=null){
                                listener.onSelectExitPosition(i + 1);
                            }
                        }
                    }
                    lastEnd = lastVisible;
                }
            }
        }
    }


    public void setListiewScrollListener(ListView listView){
        listView.setOnScrollListener(listiewScrollListener);
    }

    public void setRecyclerScrollListener(RecyclerView recyclerView) {
        recyclerView.addOnScrollListener(recyclerScrollListener);
    }

    public AbsListView.OnScrollListener getListiewScrollListener() {
        return listiewScrollListener;
    }
    public RecyclerView.OnScrollListener getRecyclerScrollListener() {
        return recyclerScrollListener;
    }

    private AbsListView.OnScrollListener listiewScrollListener=new AbsListView.OnScrollListener(){
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {

        }
        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int paramVisibleItemCount, int totalItemCount) {
            int firstVisible = view.getFirstVisiblePosition();
            int lastVisible = view.getLastVisiblePosition();
            dealScrollEvent(firstVisible, lastVisible);
        }
    };

    private RecyclerView.OnScrollListener recyclerScrollListener=new RecyclerView.OnScrollListener(){
        //RecyclerVew
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
           LinearLayoutManager layoutManager= (LinearLayoutManager) recyclerView.getLayoutManager();
           if (layoutManager!=null){
               int firstVisible = layoutManager.findFirstVisibleItemPosition();
               int lastVisible = layoutManager.findLastVisibleItemPosition();

               int visibleItemCount = lastVisible - firstVisible;
               if (lastVisible == 0) {
                   visibleItemCount = 0;
               }
               if (visibleItemCount != 0) {
                   dealScrollEvent(firstVisible, lastVisible);
               }
           }
        }
    };
}

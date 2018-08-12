package t.p.c.psylist;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import application.BaseFragment;
import test.psy.com.psyctest.R;

public class LefttFragment extends BaseFragment {
    RecyclerView recyclerView;
    ArrayList<LeftListItem> tiltiles_list;
    HomeAdapter homeAdapter;

    // fragment向activity通信接口
    OnListSeclectd onListSeclectd;
    public interface OnListSeclectd{
        public void onListSeclected(int postion);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.psy_list_left_fragment_lsyout, container, false);
        //列表加载
        recyclerView=view.findViewById(R.id.recy_left);
        //load data
        String[] titles=getArraysFromRes(R.array.psy_list_Left_title);
         tiltiles_list=new ArrayList();
        for(int i=0;i<titles.length;i++){
            LeftListItem leftListItem=new LeftListItem();
            leftListItem.setTitle(titles[i]);
            if(i==0){
                leftListItem.setChecked(true);
            }else {
                leftListItem.setChecked(false);
            }
            tiltiles_list.add(leftListItem);
        }
        //adapter
        homeAdapter=new HomeAdapter(R.layout.psy_list_left_list_item,tiltiles_list);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        ((LinearLayoutManager) layoutManager).setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(homeAdapter);



        //listener
        homeAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, final int position) {
                int i=0;
                for(LeftListItem item:tiltiles_list){
                    item.setChecked(false);
                    if(i==position){
                        item.setChecked(true);
                    }
                        i++;
                }
                recyclerView.setAdapter(homeAdapter);
                //give the right fragment num
                onListSeclectd.onListSeclected(position);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            onListSeclectd = (OnListSeclectd) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }

    }

    public class HomeAdapter extends BaseQuickAdapter<LeftListItem, BaseViewHolder> {
        public HomeAdapter(int layoutResId, List data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, LeftListItem item) {
            helper.setText(R.id.title, item.getTitle());
            if(item.getChecked()==true){
                helper.setTextColor(R.id.title, Color.WHITE);
                helper.setBackgroundColor(R.id.title,getResources().getColor(R.color.left_list_text_color));
            }
            //listener


        }
    }
}

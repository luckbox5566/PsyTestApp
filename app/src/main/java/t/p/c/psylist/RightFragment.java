package t.p.c.psylist;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

public class RightFragment extends BaseFragment {

    RecyclerView recyclerView;
    //arrays data
    ArrayList<String[]> arrar_list=new ArrayList<>();
    String[] list1={"x"};
    String[] list2={"x"};
    String[] list3={"x"};
    String[] list4={"x"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arrar_list.add(list1);
        arrar_list.add(list2);
        arrar_list.add(list3);
        arrar_list.add(list4);
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.psy_list_right_fragment_layout, container, false);
        //列表加载
        recyclerView=view.findViewById(R.id.recy_right);
        //load data
        return view;

    }

    public void updateRihgtList(int postion){
        //adapter
        RightFragment.HomeAdapter homeAdapter=new RightFragment.HomeAdapter(R.layout.psy_list_right_lsit_item,turnArraysIntoList(arrar_list.get(postion)));
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        ((LinearLayoutManager) layoutManager).setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(homeAdapter);
    }

    public class HomeAdapter extends BaseQuickAdapter<RightListItem, BaseViewHolder> {
        public HomeAdapter(int layoutResId, List data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, RightListItem item) {
            helper.setText(R.id.right_title, item.getTitle());
        }


    }


}

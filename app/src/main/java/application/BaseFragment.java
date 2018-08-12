package application;

import android.content.res.Resources;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import test.psy.com.psyctest.R;

public class BaseFragment extends Fragment {
    //放置一般工具方法

    //get data from resource
    public String[] getArraysFromRes(int arraysId ){
        Resources res=getResources();
        String[] s=res.getStringArray(arraysId);
        return s;
    }

    // turn arrsys string into list
    public ArrayList<String> turnArraysIntoList(String[] arrays){
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<arrays.length;i++){
            list.add(arrays[i]);
        }
        return  list;
    }
}

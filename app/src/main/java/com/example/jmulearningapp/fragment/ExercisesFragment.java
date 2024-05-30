package com.example.jmulearningapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.jmulearningapp.R;
import com.example.jmulearningapp.adapter.ExercisesListItemAdapter;
import com.example.jmulearningapp.bean.ExercisesBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lrui1
 * @description
 * @date 2024/5/30 14:52
 */
public class ExercisesFragment extends Fragment {

    private ListView vlist;//传给fragment_exercises
    private ExercisesListItemAdapter adapter; //适配器
    private List<ExercisesBean> beanlist; //列表集合

    @Override
    //创建该fragment对应的视图
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_exercises, null);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        vlist = view.findViewById(R.id.lv_list);
        adapter = new ExercisesListItemAdapter(getActivity());//获取适配器
        adapter.setData(beanlist);//数据传输
        vlist.setAdapter(adapter);
    }

    //章节习题信息
    private void initData(){
        beanlist = new ArrayList<ExercisesBean>();
        for (int i=0;i<6;i++){
            ExercisesBean bean = new ExercisesBean();
            bean.id=(i+1);
            switch (i){
                case 0:
                    bean.title="第1章 毛泽东思想及其历史地位";
                    bean.content="共计10题";
                    bean.background=(R.drawable.exercises_bg_1);
                    break;
                case 1:
                    bean.title="第2章 新民主主义革命理论";
                    bean.content="共计10题";
                    bean.background=(R.drawable.exercises_bg_2);
                    break;
                case 2:
                    bean.title="第3章 社会主义改造理论";
                    bean.content="共计10题";
                    bean.background=(R.drawable.exercises_bg_3);
                    break;
                case 3:
                    bean.title="第4章 社会主义建设道路初步探索的理论成果";
                    bean.content="共计10题";
                    bean.background=(R.drawable.exercises_bg_4);
                    break;
                case 4:
                    bean.title="第5章 邓小平理论";
                    bean.content="共计10题";
                    bean.background=(R.drawable.exercises_bg_1);
                    break;
                case 5:
                    bean.title="第6章 三个代表”重要思想”";
                    bean.content="共计10题";
                    bean.background=(R.drawable.exercises_bg_2);
                    break;
                default:
                    break;
            }
            beanlist.add(bean);
        }
    }
}


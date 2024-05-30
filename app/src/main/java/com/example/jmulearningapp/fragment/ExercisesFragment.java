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
                    bean.title="第1章 领悟人生真谛 把握人生方向";
                    bean.content="共计10题";
                    bean.background=(R.drawable.exercises_bg_1);
                    break;
                case 1:
                    bean.title="第2章 追求远大理想 坚定崇高信念";
                    bean.content="共计10题";
                    bean.background=(R.drawable.exercises_bg_2);
                    break;
                case 2:
                    bean.title="第3章 继承优良传统 弘扬中国精神";
                    bean.content="共计10题";
                    bean.background=(R.drawable.exercises_bg_3);
                    break;
                case 3:
                    bean.title="第4章 明确价值要求 践行价值准则";
                    bean.content="共计10题";
                    bean.background=(R.drawable.exercises_bg_4);
                    break;
                case 4:
                    bean.title="第5章 遵守道德规范 锤炼道德品格";
                    bean.content="共计10题";
                    bean.background=(R.drawable.exercises_bg_1);
                    break;
                case 5:
                    bean.title="第6章 学习法治思想 提升法治素养";
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


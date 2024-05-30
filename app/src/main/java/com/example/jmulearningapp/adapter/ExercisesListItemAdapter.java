package com.example.jmulearningapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jmulearningapp.R;
import com.example.jmulearningapp.activity.ExercisesDetailActivity;
import com.example.jmulearningapp.bean.ExercisesBean;
import com.example.jmulearningapp.utils.AnalysisUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lrui1
 * @description
 * @date 2024/5/30 14:53
 */
public class ExercisesListItemAdapter extends BaseAdapter {

    private List<ExercisesBean> objects = new ArrayList<ExercisesBean>();
    private Context context;
    private LayoutInflater layoutInflater;

    public ExercisesListItemAdapter(Context context){
        this.context=context;
        this.layoutInflater= LayoutInflater.from(context);
    }
    /**
     * 设置数据更新界面
     */
    public void setData(List<ExercisesBean> objects){
        this.objects = objects;
        notifyDataSetChanged();
    }
    //
    public void updateView(List<ExercisesBean> objects){
        this.objects = objects;
        this.notifyDataSetChanged();
    }

    //适配器中数据集的数据个数；
    @Override
    public int getCount() {
        return objects == null ? 0 : objects.size();
    }

    /**
     * 根据position得到对应的Item的对象
     */
    @Override
    public ExercisesBean getItem(int position) {
        return objects.get(position);
    }

    /**
     * 根据position得到对应Item的对象
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 得到相应position对应的Item视图，position是当前Item的位置
     * convertView参数就是滚出屏幕的Item的View
     * 第一次进入或滑动屏幕时候被调用
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.exercises_list_item, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((ExercisesBean) getItem(position), (ViewHolder) convertView.getTag(),
                position, convertView);
        return convertView;
    }

    private void initializeViews(ExercisesBean object, ViewHolder holder,
                                 int position, View convertView) {
        final ExercisesBean bean = getItem(position);
        if (bean != null) {
            holder.tvOrder.setText(position + 1 + "");
            holder.tvTitle.setText(bean.title);
            Log.i("readExercises", AnalysisUtils.readExerciseStatus(context,position+1)+"");
            if (AnalysisUtils.readExerciseStatus(context,position+1)){
                holder.tvContent.setText("已完成");
            }else{
                holder.tvContent.setText(bean.content);
            }
            holder.tvOrder.setBackgroundResource(bean.background);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (bean == null) {
                        return;
                    }
                    //跳转到习题界面
                    Intent intent = new Intent(context, ExercisesDetailActivity.class);
                    intent.putExtra("id", bean.id);
                    intent.putExtra("title", bean.title);
                    ((Activity) context).startActivityForResult(intent, 000);
                }
            });
        }
    }

    protected class ViewHolder {
        private TextView tvOrder;
        private TextView tvTitle;
        private TextView tvContent;

        public ViewHolder(View view) {
            tvOrder = (TextView) view.findViewById(R.id.tv_order);
            tvTitle = (TextView) view.findViewById(R.id.tv_title);
            tvContent = (TextView) view.findViewById(R.id.tv_content);
        }
    }
}

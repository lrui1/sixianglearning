package com.example.jmulearningapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.jmulearningapp.R;
import com.example.jmulearningapp.activity.PlayHistoryActivity;
import com.example.jmulearningapp.activity.ReadBookActivity;
import com.example.jmulearningapp.utils.AnalysisUtils;

/**
 * @author lrui1
 * @description
 * @date 2024/5/30 15:01
 */
public class MyinfoFragment extends Fragment implements View.OnClickListener{

    private LinearLayout llHead;
    private ImageView ivHeadIcon;
    private TextView tvUserName;
    private RelativeLayout rlCourseHistory;
    private ImageView ivCourseHistoryIcon;
    private RelativeLayout rlSetting1;
    private RelativeLayout rlSetting2;
    private RelativeLayout rlSetting3;
    private RelativeLayout rlSetting4;

    private ImageView ivUserInfoIcon1;
    private ImageView ivUserInfoIcon2;
    private ImageView ivUserInfoIcon3;
    private ImageView ivUserInfoIcon4;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_myinfo, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        llHead = (LinearLayout) view.findViewById(R.id.ll_head);
        ivHeadIcon = (ImageView) view.findViewById(R.id.iv_head_icon);
        tvUserName = (TextView) view.findViewById(R.id.tv_user_name);
        rlCourseHistory = (RelativeLayout) view.findViewById(R.id.rl_course_history);
        ivCourseHistoryIcon = (ImageView) view.findViewById(R.id.iv_course_history_icon);
        rlSetting1 = (RelativeLayout) view.findViewById(R.id.rl_book1);
        ivUserInfoIcon1 = (ImageView) view.findViewById(R.id.iv_book1_icon);
        rlSetting2 = (RelativeLayout) view.findViewById(R.id.rl_book2);
        ivUserInfoIcon2 = (ImageView) view.findViewById(R.id.iv_book2_icon);
        rlSetting3 = (RelativeLayout) view.findViewById(R.id.rl_book3);
        ivUserInfoIcon3 = (ImageView) view.findViewById(R.id.iv_book3_icon);
        rlSetting4 = (RelativeLayout) view.findViewById(R.id.rl_book4);
        ivUserInfoIcon4 = (ImageView) view.findViewById(R.id.iv_book4_icon);

        if (AnalysisUtils.readLoginStatus(getActivity())){
            tvUserName.setText(AnalysisUtils.readLoginUserName(getActivity()));
        }else {
            tvUserName.setText("点击登录");
        }

        llHead.setOnClickListener(this);
        rlCourseHistory.setOnClickListener(this);
        rlSetting1.setOnClickListener(this);
        rlSetting2.setOnClickListener(this);
        rlSetting3.setOnClickListener(this);
        rlSetting4.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();

        if (viewId == R.id.rl_course_history) {
            if (AnalysisUtils.readLoginStatus(getActivity())){
                //跳转到播放记录页面
                Intent intent = new Intent(getActivity(), PlayHistoryActivity.class);
                getActivity().startActivity(intent);
            } else {
                Toast.makeText(getActivity(),"您未登录，请先登录", Toast.LENGTH_SHORT).show();
            }
        } else if (viewId == R.id.rl_book1 ||
                viewId == R.id.rl_book2 ||
                viewId == R.id.rl_book3 ||
                viewId == R.id.rl_book4) {
            Intent intent = new Intent(getActivity(), ReadBookActivity.class);
            intent.putExtra("st", Integer.toString(viewId));
            getActivity().startActivity(intent);
        }
    }
}



package com.example.jmulearningapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.jmulearningapp.MainActivity;
import com.example.jmulearningapp.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author lrui1
 * @description
 * @date 2024/5/30 23:51
 */
public class ShareFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_share, container, false);
        ShareClick(root);
        //IntentSend();

        return inflater.inflate(R.layout.fragment_myinfo, container, false);
    }
    public void ShareClick(View v){
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
        intent.putExtra(Intent.EXTRA_TEXT, "欢迎使用思想道德学习通" +
                "http://47.245.90.4/software.html");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(Intent.createChooser(intent, getActivity().getTitle()));
    }
    public void IntentSend(){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }
        };
        timer.schedule(task, 5000);
    }
}

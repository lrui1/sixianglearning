package com.example.jmulearningapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.jmulearningapp.R;

/**
 * @author lrui1
 * @description
 * @date 2024/5/31 10:14
 */
public class QuitFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_send, container, false);

        System.exit(0);
        return root;
    }
}

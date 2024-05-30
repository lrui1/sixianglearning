package com.example.jmulearningapp.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.jmulearningapp.R;
import com.example.jmulearningapp.bean.ChatBean;
import com.example.jmulearningapp.utils.DBUtils;

/**
 * @author lrui1
 * @description
 * @date 2024/5/30 8:57
 */
public class ChatFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_chat, container, false);
        final TextView textView = root.findViewById(R.id.text_send);
        final EditText mFeedBackEditText = (EditText) root.findViewById(R.id.fee_back_edit);
        Button mSendFeedBackButton = (Button) root.findViewById(R.id.feed_back_btn);
        mSendFeedBackButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final String content = mFeedBackEditText.getText().toString();
                if (!TextUtils.isEmpty(content)) {
                    //此处写处理逻辑
                    Toast.makeText(getContext().getApplicationContext(), "提交成功",Toast.LENGTH_SHORT).show();
                    mFeedBackEditText.setText("");
                    DBUtils db =DBUtils.getInstance(getContext());
                    ChatBean bean = new ChatBean();
                    bean.username="1";
                    bean.message=content;
                    db.saveUserChat(bean);
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            MySqlUtils.saveMysql("chatMessage","123",content);
//                        }
//                    }).start();
                } else {
                    Toast.makeText(getContext().getApplicationContext(), "请输入内容！",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }
}

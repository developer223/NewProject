package sn170507180223.classroom.android.sdwu.edu.cn.newproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ch6Atity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch6);
        //在java代码获取字符串资源
        String content=getString(R.string.ok);

        Log.i(ch6Atity.this.toString(),content);
        String sms=getString(R.string.sms);
        sms=String.format(sms,100,"张三");
        Log.i(ch6Atity.this.toString(),content);
    }
}

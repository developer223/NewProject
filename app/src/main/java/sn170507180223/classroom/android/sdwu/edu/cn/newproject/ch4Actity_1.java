package sn170507180223.classroom.android.sdwu.edu.cn.newproject;

import android.app.WallpaperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ch4Actity_1 extends AppCompatActivity implements View.OnFocusChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载界面，使用资源id
        setContentView(R.layout.layout_ch4_1);
        //1、获取普通页面组件,必须在setConTentView之后，调用
        Button button=(Button) findViewById(R.id.button1);
        ImageView imageView=(ImageView)findViewById(R.id.ch4_iv);
        //3、调用事件源的setxxxxxListener 方法注册事件监听器。(第一个练习的)
        button.setOnClickListener(new MyClickListener());
        //3、使用内部匿名类注册监听器
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //设置壁纸

                WallpaperManager wallpaperManager=(WallpaperManager) getSystemService(WALLPAPER_SERVICE);
                try {
                    wallpaperManager.setResource(R.raw.img);
                }catch(Exception e){
                    Log.e(ch4Actity_1.class.toString(),e.toString());
                }
                return true;
            }
        });
        EditText email=(EditText) findViewById(R.id.ch4_1_email);//找到事件源
        email.setOnFocusChangeListener(this);//焦点改变事件
    }

    @Override//上面implements View.OnFocusChangeListener后按照提示输出的
    public void onFocusChange(View view, boolean b) {
        //参数b代表是否获取焦点
        //判断邮箱地址的合法性
        EditText editText=(EditText)view;//强制类型的转换
        if (!b){
            String content=editText.getText().toString();//得到editText的内容
            //判断邮箱地址的正则表达式
            String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern pattern= Pattern.compile(regEx1);//对正则表达式编译
            Matcher matcher=pattern.matcher(content);//将输入内容与正则表达式匹配
            //找文本
            TextView textView=(TextView)findViewById(R.id.ch4_1_tv);
            if(matcher.matches()){
                textView.setText("");//将原有内容清空
            }else{
                textView.setText("email invalidate");//设置内容：邮件不合法
            }

        }
    }

    //2.实现事件监听类，该监听类是一个特殊的java类,必须实现
    class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Log.i(ch4Actity_1.class.toString(),"button click");
        }
    }
}

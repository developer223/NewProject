package sn170507180223.classroom.android.sdwu.edu.cn.newproject;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ch6Atity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch6);
        //在java代码获取字符串资源
        String content=getString(R.string.hello);

        Log.i(ch6Atity.this.toString(),content);

        String sms=getString(R.string.sms);
        sms=String.format(sms,100,"张三");
        Log.i(ch6Atity.this.toString(),content);


        //获取数组资源
        Resources resources=getResources();
        //整型数组
        int[] intArr=resources.getIntArray(R.array.intArr);
        for(int i=0;i<intArr.length;i++){
            Log.i(ch6Atity.this.toString(),intArr[i]+"");
        }
        //字符串
        String[] strArry=resources.getStringArray(R.array.strArr);
        for(int i=0;i<strArry.length;i++){
            Log.i(ch6Atity.this.toString(),strArry[i]);
        }
        //普通类型
        TypedArray typedArray=resources.obtainTypedArray(R.array.comArr);
        ImageView imageView=(ImageView)findViewById(R.id.ch6_1_iv);
        int resId=typedArray.getResourceId(0,0);
        imageView.setImageResource(resId);

        String str=typedArray.getString(0);
        Log.i(ch6Atity.this.toString(),str);

        //注册上下文菜单
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.ch6_1_11);
        registerForContextMenu(linearLayout);

        XmlPullParser xmlPullParser=resources.getXml(R.xml.words);
        try {
            while (xmlPullParser.getEventType()!=XmlPullParser.END_DOCUMENT){
                if(xmlPullParser.getEventType()==XmlPullParser.START_TAG) {
                    //判断是否为word元素
                    if (xmlPullParser.getName().equals("word")) {
                        String word = xmlPullParser.getAttributeName(0);
                        Log.i(ch6Atity.class.toString(),word);
                    }
                }
            }
        } catch (XmlPullParserException e) {
            Log.e(ch6Atity.class.toString(),e.toString());
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //加载自定义菜单资源
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.my,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mymenu_item1:
                Toast.makeText(this,"item1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mymenu_item2:
                Toast.makeText(this,"item2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mymenu_item3:
                Toast.makeText(this,"item3",Toast.LENGTH_SHORT).show();
                break;

        }
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //基于回调的事件处理
        //根据D进行区分
        switch (item.getItemId()){
            case R.id.mymenu_item1:
                Toast.makeText(this,"item1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mymenu_item2:
                Toast.makeText(this,"item2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mymenu_item3:
                Toast.makeText(this,"item3",Toast.LENGTH_SHORT).show();
                break;

        }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.my,menu);
        return true;
    }
}

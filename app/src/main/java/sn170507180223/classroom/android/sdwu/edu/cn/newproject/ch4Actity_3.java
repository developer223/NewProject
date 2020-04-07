package sn170507180223.classroom.android.sdwu.edu.cn.newproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.id.list;

public class ch4Actity_3 extends AppCompatActivity {
    public ArrayList list;
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch4_3);

        list=new ArrayList();
        textView=(TextView)findViewById(R.id.ch4_3_tv) ;

        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.ch4_3_ll);
        int count=linearLayout.getChildCount();
        for(int i=0;i<count;i++){
            View view=linearLayout.getChildAt(i);
            if(view instanceof CheckBox){
                final CheckBox checkBox=(CheckBox)view;
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        //参数b是否选中
                        if(b){
                            list.add(compoundButton);
                        }else{
                            list.remove(compoundButton);
                        }
                        String content="you select:";
                        for(int t=0;t<list.size(); t++){
                            CheckBox checkBox1=(CheckBox)list.get(t);
                            String sel=checkBox1.getText().toString();
                            content+=sel+",";
                        }
                        textView.setText(content);
                    }
                });
            }
        }

    }
}

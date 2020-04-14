package sn170507180223.classroom.android.sdwu.edu.cn.newproject;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;

public class ch9Actity extends AppCompatActivity {
private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch9_1);
        Resources resource=getResources();
        String[] countries=resource.getStringArray(R.array.countries);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,countries);
        AutoCompleteTextView autoCompleteTextView=(AutoCompleteTextView)findViewById(R.id.ch9_1_act);
        autoCompleteTextView.setAdapter(arrayAdapter);

        progressBar=(ProgressBar)findViewById(R.id.ch9_1_pb);
    }
    public void progressStart(View view){
        Thread thread=new Thread(){
            @Override
            public void run() {
                int i=0;
                while(i<=100){
                    progressBar.setProgress(i);
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){

                    }
                    i+=25;
                }
            }
        };
        thread.start();
    }
}

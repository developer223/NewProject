package sn170507180223.classroom.android.sdwu.edu.cn.newproject;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ch5Actity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch5);

    }

    //添加通知
    public void notification(View view){
        Notification.Builder builder=new Notification.Builder(this);
        //完成通知各种属性的设置
        builder.setContentTitle("titlt");
        builder.setContentTitle("message");
        builder.setWhen(System.currentTimeMillis());
        builder.setSmallIcon(android.R.drawable.ic_input_delete);//引用系统资源
        //完成构造
        Notification notification=builder.build();
        //发送
        NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(101,notification);

    }
    //删除通知
    public void  cancle_nitified(View view){
        NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(101);
    }
    //弹出框设置
    public void alert_dialog(View view){
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        //在构造器内设置对话框的属性
        builder.setTitle("title");
        builder.setMessage("message");
        builder.setIcon(android.R.drawable.ic_dialog_email);
        builder.setPositiveButton("confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //点击添加事件后的处理
                Toast.makeText(ch5Actity.this,"confirm",Toast.LENGTH_SHORT).show();

            }
        });
        builder.setNegativeButton("exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(ch5Actity.this,"exit",Toast,LENGTH_SHORT).show();
                Toast.makeText(ch5Actity.this,"exit",Toast.LENGTH_SHORT).show();
            }
        });

        builder.create().show();

    }

}

package cn.edu.sdwu.android.classroom.sn170507180103;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Ch5Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch5_1);


    }
    //最下面显示toast
    public void  toast1(View view){
        Toast.makeText(this,"toast1",Toast.LENGTH_LONG).show();
    }
    //中间显示toast
    public void toast2(View view){
        Toast toast=Toast.makeText(this,"toast2",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }
    //toast显示自定义的布局
    public void toast3(View view){
        //加载自定义的布局文件,将其转换为一个View类的实例
        LayoutInflater layoutInflater=getLayoutInflater();
        View view1=layoutInflater.inflate(R.layout.layout_toast,null);//null是加载整个布局
        //设置显示文本
        TextView textView=(TextView)view1.findViewById(R.id.toast_tv);
        textView.setText("toast3");

        Toast toast=new Toast(this);
        toast.setView(view1);//设置界面样式
        toast.setDuration(Toast.LENGTH_SHORT);//设置显示时长
        toast.setGravity(Gravity.CENTER,0,0);//这只显示位置
        toast.show();
    }

    public void notification(View view){
        //构造器--实例化构造器
        Notification.Builder builder=new Notification.Builder(this);
        //在构造器中完成统治各种属性的设置
        //设置标题
        builder.setContentTitle("title");
        //设置内容
        builder.setContentText("message");
        //设置发送时间(长整型--时间戳1970年到现在)
        builder.setWhen(System.currentTimeMillis());
        //设置图标(系统中已有的资源图标)
        builder.setSmallIcon(android.R.drawable.ic_input_delete);
        //调用build方法，完成构造
        Notification notification=builder.build();
        //发送到状态栏,使用NotificationManager资源管理器
        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(101,notification);//编号，对象



    }

    public void cancel_notification(View view){
        //使用NotificationManager取消通知
        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(101);

    }

    public void alert_dialog(View view){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        //早构造器中设置对话框属性
        //设置标题
        builder.setTitle("title");
        //设置内容
        builder.setMessage("message");
        //设置图标
        builder.setIcon(android.R.drawable.ic_dialog_email);
        //设置按钮
        builder.setPositiveButton("confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //添加点击按钮后的处理
                Toast.makeText(Ch5Activity1.this,"confirm",Toast.LENGTH_SHORT).show();


            }
        });
        builder.setNegativeButton("exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Ch5Activity1.this,"exit",Toast.LENGTH_SHORT).show();
            }
        });

        //第三个按钮
        builder.setNeutralButton("cancel",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Ch5Activity1.this,"cancel",Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();

    }

}


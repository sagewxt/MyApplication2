package cn.edu.sdwu.android.classroom.sn170507180103;

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

}


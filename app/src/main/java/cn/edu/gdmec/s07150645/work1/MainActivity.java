package cn.edu.gdmec.s07150645.work1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private AlertDialog dialog;
    private AlertDialog.Builder builder;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1= (TextView) this.findViewById(R.id.textView);
        Button button1= (Button) this.findViewById(R.id.button1);
        Button button2= (Button) this.findViewById(R.id.button2);
        Button button3= (Button) this.findViewById(R.id.button3);
        Button button4= (Button) this.findViewById(R.id.button4);
        Button button5= (Button) this.findViewById(R.id.button5);
        Button button6= (Button) this.findViewById(R.id.button6);
        Button button7= (Button) this.findViewById(R.id.button7);

        View.OnClickListener lis=new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                    switch (v.getId()){
                    case R.id.button1:
                         dialog1();
                         break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;
                    case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                    case R.id.button7:
                        dialog7();
                        break;
                }

            }
        };

        button1.setOnClickListener(lis);
        button2.setOnClickListener(lis);
        button3.setOnClickListener(lis);
        button4.setOnClickListener(lis);
        button5.setOnClickListener(lis);
        button6.setOnClickListener(lis);
        button7.setOnClickListener(lis);

    }



    public void dialog1(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("提示");
        dialog.setMessage("确定退出吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);

        DialogInterface.OnClickListener lis=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which==DialogInterface.BUTTON_POSITIVE) {
                    dialog.dismiss();
                    MainActivity.this.finish();
                }else if(which==DialogInterface.BUTTON_NEGATIVE){
                    dialog.dismiss();
                }
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"取消",lis);
        dialog.show();
    }

    public void dialog2(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("调查");
        dialog.setMessage("你平时忙吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        DialogInterface.OnClickListener lis=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="";
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        str="平时很忙";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str="平时一般";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str="平时轻松";
                        break;
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"忙碌",lis);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"一般",lis);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"不忙",lis);
        dialog.show();
    }

    public void dialog3(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("请输入");
        dialog.setMessage("你平时忙吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        final EditText tEdit=new EditText(this);
        dialog.setView(tEdit);
        DialogInterface.OnClickListener lis=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("你输入的是"+tEdit.getText().toString());

            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis);
        dialog.show();
    }

    public void dialog4(){
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener mlis=new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bSelect[which]=isChecked;
                }
        };
        builder=new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,null,mlis);
        dialog=builder.create();
        dialog.setTitle("复选框");
        DialogInterface.OnClickListener lis=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了:";
                for (int i=0;i<bSelect.length;i++){
                    if (bSelect[i]){
                        str=str+"\n"+item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis);
        dialog.show();
        }






    public void dialog5(){
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener slis=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                bSelect[which]=true;
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,slis);
        dialog=builder.create();
        dialog.setTitle("单选框");
        DialogInterface.OnClickListener lis=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               String str="你选择了:";
                for (int i=0;i<bSelect.length;i++){
                    if (bSelect[i]){
                        str=str+"\n"+item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis);
        dialog.show();
    }

    public void dialog6(){
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener slis=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               String str="你选择了:"+item[which];
                tv1.setText(str);
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setItems(item,slis);
        dialog=builder.create();
        dialog.setTitle("列表框");
        DialogInterface.OnClickListener lis=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              dialog.dismiss();
            }
        };
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",lis);
        dialog.show();
    }

    public void dialog7(){
       LayoutInflater inflater=getLayoutInflater();
        View layout=inflater.inflate(R.layout.diylayout,null);
        final  EditText et=(EditText)layout.findViewById(R.id.editText);
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("自定义布局");
        dialog.setView(layout);
        DialogInterface.OnClickListener lis=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("输入的是："+et.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",lis);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",lis);
        dialog.show();

    }
}

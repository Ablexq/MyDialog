package com.example.ablex.mydialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.ablex.mydialog.dialog.LoadingDialog;
import com.example.ablex.mydialog.dialog.VersionAlertDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.btn1)
    TextView btn1;
    @BindView(R.id.btn2)
    TextView btn2;
    @BindView(R.id.btn3)
    TextView btn3;
    @BindView(R.id.btn4)
    TextView btn4;
    @BindView(R.id.btn5)
    TextView btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                LoadingDialog loadingDialog = new LoadingDialog(MainActivity.this)
                        .setCancelable(false)
                        .setPrompts(R.string.processing);
                loadingDialog.show();
                break;

            case R.id.btn2:
                new VersionAlertDialog(MainActivity.this)
                        .builder()
                        .setCancelable(false)
                        .setMsg("强制升级信息")
                        .setPositiveButton("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                System.out.println("您点击了确定");
                            }
                        }).show();

                break;

            case R.id.btn3:
                new VersionAlertDialog(MainActivity.this)
                        .builder()
                        .setCancelable(false)
                        .setMsg("推荐升级信息")
                        .setPositiveButton("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                System.out.println("您点击了升级");
                            }
                        }).show();
                break;

            case R.id.btn4:
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("更新提示")
                        .setMessage("信息内容")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                System.out.println("点击了确定");
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();

                break;
            case R.id.btn5:
                break;
        }
    }

}

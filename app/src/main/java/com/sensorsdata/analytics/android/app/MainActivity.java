package com.sensorsdata.analytics.android.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

import com.sensorsdata.analytics.android.sdk.SensorsDataTrackViewOnClick;
import com.sensorsdata.analytics.android.app.databinding.ActivityMainBinding;

@SuppressWarnings("Convert2Lambda")
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setHandlers(this);

        ButterKnife.bind(this);

        initButton();
        initLambdaButton();
        initShowDialogButton();
        initShowMultiChoiceDialogButton();
        initCheckBox();
        initRatingBar();
        initSeekBar();
        initSpinner();
        initAdapterViewTest();
        initExpandableListViewTest();
        initTabHostButton();

    }

    private void initTabHostButton() {
        AppCompatButton button = findViewById(R.id.tabHostButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TabHostTestActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initExpandableListViewTest() {
        AppCompatButton button = findViewById(R.id.expandableListViewTest);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ExpandableListViewTestActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initAdapterViewTest() {
        AppCompatButton button = findViewById(R.id.adapterViewTest);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AdapterViewTestActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initSpinner() {
        Spinner spinner = findViewById(R.id.spinner);
        List<String> dataList = new ArrayList<>();
        dataList.add("北京");
        dataList.add("上海");
        dataList.add("广州");
        dataList.add("深圳");
        dataList.add("咸宁");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dataList);

        //为适配器设置下拉列表下拉时的菜单样式。
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //为spinner绑定我们定义好的数据适配器
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });
    }

    private void initSeekBar() {
        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void initRatingBar() {
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            }
        });
    }

    private void initCheckBox() {
        AppCompatCheckBox checkBox = findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });
    }

    private void initShowMultiChoiceDialogButton() {
        AppCompatButton button = findViewById(R.id.showMultiChoiceDialogButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMultiChoiceDialog(MainActivity.this);
            }
        });
    }


    private void initShowDialogButton() {
        AppCompatButton button = findViewById(R.id.showDialogButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(MainActivity.this);
            }
        });
    }

    /**
     * Lambda 语法
     */
    private void initLambdaButton() {
        AppCompatButton button = findViewById(R.id.lambdaButton);
        button.setOnClickListener(view -> showToast("Lambda OnClick"));
    }

    /**
     * 普通 setOnClickListener
     */
    private void initButton() {
        AppCompatButton button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ///还可缓解
                showToast("普通");
                //hi 就不积跬步
            }
        });

        registerForContextMenu(button);
    }

    /**
     * 通过 DataBinding 绑定点击事件
     *
     * @param view View
     */
    public void dataBindingOnClick(View view) {
        showToast("DataBinding Onclick");
    }

    /**
     * 通过 layout 中的 Android:onClick 属性绑定点击事件
     *
     * @param view View
     */
    @SensorsDataTrackViewOnClick
    public void xmlOnClick(View view) {
        showToast("XML OnClick");
    }

    /**
     * 通过 ButterKnife 绑定事件
     */
    @OnClick({R2.id.butterknife})
    public void butterKnifeButtonOnClick(View view) {
        showToast("Butter Knife OnClick");
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void showMultiChoiceDialog(Context context) {
        Dialog dialog;
        boolean[] selected = new boolean[]{true, true, true, true};
        CharSequence[] items = {"北京", "上海", "深圳", "合肥"};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("神策数据在哪些城市有服务团队？");
        DialogInterface.OnMultiChoiceClickListener mutiListener =
                new DialogInterface.OnMultiChoiceClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface,
                                        int which, boolean isChecked) {
                        selected[which] = isChecked;
                    }
                };
        builder.setMultiChoiceItems(items, selected, mutiListener);
        dialog = builder.create();
        dialog.show();
    }

    private void showDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("标题");
        builder.setMessage("内容");
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog = builder.create();

        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        showToast(item.getTitle().toString());
        return super.onContextItemSelected(item);
    }

    @Override
    @SuppressWarnings("all")
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_more:
                ViewGroup rootView = findViewById(R.id.rootView);
                AppCompatButton button = new AppCompatButton(this);
                button.setText("动态创建的 Button");
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                rootView.addView(button);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

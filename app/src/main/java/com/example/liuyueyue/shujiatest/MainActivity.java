package com.example.liuyueyue.shujiatest;
import android.os.PersistableBundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener,RadioGroup.OnCheckedChangeListener{
    private AutoCompleteTextView acTextView;
    private MultiAutoCompleteTextView macTextView;
    private String[] res = {"beijing1","beijing2","android3","android4"};
    private ToggleButton tb;
    private ImageView img;
    private CheckBox checkbox;
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1.初始化控件
        //2.适配器
        //3.初始化数据源，这数据源匹配文本框输入的内容

        //将adapter与当前AutocompleteTexeView绑定
        acTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,res);
        acTextView.setAdapter(adapter);
        //1.初始化控件
        //2.适配器
        //3.初始化数据源，这数据源匹配文本框输入的内容
        //将adapter与当前AutocompleteTexeView绑定
        //设置分隔符
        macTextView = (MultiAutoCompleteTextView) findViewById(R.id.MultiautoCompleteTextView1);
        macTextView.setAdapter(adapter);
        //设置以逗号为分隔符结束的符号
        macTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        tb = (ToggleButton) findViewById(R.id.toggleButto1);
        img = (ImageView) findViewById(R.id.imageview1);
       /* tb.setOnCheckedChangeListener(this);*/
       tb.setOnCheckedChangeListener(this);
        rg = (RadioGroup) findViewById(R.id.radioGroup1);
        rg.setOnCheckedChangeListener(this);
    }
//当tb被点击的时候，该方法会执行
    public void onCheckedChanged(CompoundButton buttonview,boolean isChecked){
    img.setBackgroundResource(isChecked?R.drawable.guan:R.drawable.kai);
   //初始化checkbox
        checkbox = (CheckBox) findViewById(R.id.checkbox1);
        //通过设置checkbox监听事件来对checkbox进行处理
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //通过onCheckedChanged来监听当前CheckBox是否被选中
                if(isChecked){
                    //获得CheckBox文本内容
                    String text =checkbox.getText().toString();
                    Log.i("tag",text);
                }
            }
        });

        checkbox = (CheckBox) findViewById(R.id.checkbox2);
        //通过设置checkbox监听事件来对checkbox进行处理
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //通过onCheckedChanged来监听当前CheckBox是否被选中
                if(isChecked){
                    //获得CheckBox文本内容
                    String text =checkbox.getText().toString();
                    Log.i("tag",text);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId){
            case R.id.radio0:
                Log.i("tag","你当前是一个男孩");
                Toast.makeText(this,"你当前是"+checkedId+"孩子",Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio1:
                Log.i("tag","你当前是一个女孩");
                Toast.makeText(this,"你当前是"+checkedId+"孩子",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}

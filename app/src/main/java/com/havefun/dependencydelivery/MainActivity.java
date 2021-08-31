package com.havefun.dependencydelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.havefun.liba.LibAClass;
import com.havefun.libb.LibBClass;
import com.havefun.libc.LibCClass;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //app  --> 1.implementation project(path: ':liba')
        //liba --> 2.implementation project(path: ':libb')
        case1();

        //app -->  1.implementation project(path: ':liba')
        //lia -->  2.api project(path: ':libb')
        case2();

        //app -->  1.implementation project(path: ':liba')
        //lia -->  2.api project(path: ':libb')
        //apb -->  1.api project(path: ':libc')
        case3();

        //app -->  1.implementation project(path: ':liba')
        //lia -->  2.implementation project(path: ':libb')
        //apb -->  1.api project(path: ':libc')
        case4();

        summary();
    }

    /**
     * 结论:
     * 1.当当前模块引用其他依赖时无论使用implementation 或者 api 都不影响当前模块使用依赖的内容
     * 2.implementation会阻止当前模块将其依赖向下传递 对应 case4
     * 3.api会将当前模块的依赖传递给调用者模块 对比case1 case2
     */
    private void summary() {

    }


    private void case1() {
        //只能调用liba里面的方法
        LibAClass.helloClassA();
    }

    private void case2() {
        // 可以调用liba  libb 的方法
        LibAClass.helloClassA();
        LibBClass.helloClassB();

    }

    private void case3() {
        // 可以调用 liba libb libc的方法
        LibAClass.helloClassA();
        LibBClass.helloClassB();
        LibCClass.helloClassC();
    }

    private void case4() {
        // 可以调用 liba 的方法
        LibAClass.helloClassA();
        // 无法调用libb libc的方法
        //LibBClass.helloClassB();
        //LibCClass.helloClassC();
    }
}
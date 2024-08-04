package com.example.mycalculator;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ClickListener implements View.OnClickListener {

    // 文本视图, 用于显示文本
    private TextView textView;

    private Context context;

    public ClickListener(TextView textView, Context context) {
        this.textView = textView;
        this.context = context;
    }

    // 第一个数字
    private String firstNum = "0";

    // 第二个数字
    private String secondNum = "0";

    // 操作符
    private String operator = "";

    // 展示效果
    private String resultText = "";

    @Override
    public void onClick(View view) {

        // 先判断点击是否合法
        if(!verify(view)){

            return;

        }




    }

    public boolean verify(View view){

        if(view.getId() == R.id.btn_cancel){    // 1. 点击取消按钮

            // 没有运算符, 则依次逐位删除第一个数字
            if(operator.equals("") && (firstNum.equals("") || firstNum.equals("0"))){

                // 第一个数字未输入
                Toast.makeText(context, "没有可取消的数字了", Toast.LENGTH_SHORT).show();
                return false;

            }else if (!operator.equals("") && (secondNum.equals("") || secondNum.equals("0"))){

                // 第二个数字未输入
                Toast.makeText(context, "没有可取消的数字了", Toast.LENGTH_SHORT).show();
                return false;
            }

        } else if (view.getId() == R.id.btn_equal) {    // 2. 点击了等号

            if (operator.equals("")) {
                Toast.makeText(context, "请输入运算符", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (firstNum.equals("") || secondNum.equals("")) { // 无操作数
                Toast.makeText(context, "请输入数字", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (operator.equals("÷") && Double.parseDouble(secondNum) == 0) { // 除数为零
                Toast.makeText(context, "除数不能为零", Toast.LENGTH_SHORT).show();
                return false;
            }

        } else if (view.getId() == R.id.btn_plus || view.getId() == R.id.btn_minus // 点击了加、减、乘、除按钮
                || view.getId() == R.id.btn_multiply || view.getId() == R.id.btn_divide) {
            if (firstNum.equals("")) { // 缺少第一个操作数
                Toast.makeText(context, "请输入数字", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (!operator.equals("")) { // 已有运算符
                Toast.makeText(context, "请输入数字", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else if (view.getId() == R.id.ib_sqrt) { // 点击了开根号按钮
            if (firstNum.equals("")) { // 缺少底数
                Toast.makeText(context, "请输入数字", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (Double.parseDouble(firstNum) < 0) { // 不能对负数开平方
                Toast.makeText(context, "开根号的数值不能小于零", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else if (view.getId() == R.id.btn_reciprocal) { // 点击了求倒数按钮
            if (firstNum.equals("")) { // 缺少底数
                Toast.makeText(context, "请输入数字", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (Double.parseDouble(firstNum) == 0) { // 不能对零求倒数
                Toast.makeText(context, "不能对零求倒数", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else if (view.getId() == R.id.btn_dot) { // 点击了小数点
            if (operator.equals("") && firstNum.contains(".")) { // 无运算符，则检查第一个操作数是否已有小数点
                Toast.makeText(context, "一个数字不能有两个小数点", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (!operator.equals("") && secondNum.contains(".")) { // 有运算符，则检查第二个操作数是否已有小数点
                Toast.makeText(context, "一个数字不能有两个小数点", Toast.LENGTH_SHORT).show();
                return false;
            }
        }


        return true;

    }

}

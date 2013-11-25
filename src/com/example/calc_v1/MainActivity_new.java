package com.example.calc_v1;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.SumPathEffect;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity_new extends Activity implements OnClickListener {

	int action = 0;
	static TextView tv;
	Button bt_0, bt_1, bt_2, bt_3, bt_4, bt_5, bt_6, bt_7, bt_8, bt_9,
			bt_minus, bt_sum, bt_multiply, bt_div, bt_point, bt_res, bt_cancel;

	static StringBuilder symbol = new StringBuilder();
	static Float first_number = (float) 0;
	static Float second_number = (float) 0;
	static Float result = null;

	public static final String CALC_LOG = "calcLog";
	private static final int SUMMA = 1;
	private static final int MINUS = 2;
	private static final int DIV = 3;
	private static final int MULTIPLY = 4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		tv = (TextView) findViewById(R.id.textView1);
		bt_0 = (Button) findViewById(R.id.bt_0);
		bt_0.setOnClickListener(this);
		bt_1 = (Button) findViewById(R.id.bt_1);
		bt_1.setOnClickListener(this);
		bt_2 = (Button) findViewById(R.id.bt_2);
		bt_2.setOnClickListener(this);
		bt_3 = (Button) findViewById(R.id.bt_3);
		bt_3.setOnClickListener(this);
		bt_4 = (Button) findViewById(R.id.bt_4);
		bt_4.setOnClickListener(this);
		bt_5 = (Button) findViewById(R.id.bt_5);
		bt_5.setOnClickListener(this);
		bt_6 = (Button) findViewById(R.id.bt_6);
		bt_6.setOnClickListener(this);
		bt_7 = (Button) findViewById(R.id.bt_7);
		bt_7.setOnClickListener(this);
		bt_8 = (Button) findViewById(R.id.bt_8);
		bt_8.setOnClickListener(this);
		bt_9 = (Button) findViewById(R.id.bt_9);
		bt_9.setOnClickListener(this);
		bt_point = (Button) findViewById(R.id.bt_point);
		bt_point.setOnClickListener(this);
		bt_div = (Button) findViewById(R.id.bt_div);
		bt_div.setOnClickListener(this);
		bt_multiply = (Button) findViewById(R.id.bt_multiply);
		bt_multiply.setOnClickListener(this);
		bt_minus = (Button) findViewById(R.id.bt_minus);
		bt_minus.setOnClickListener(this);
		bt_sum = (Button) findViewById(R.id.bt_sum);
		bt_sum.setOnClickListener(this);
		bt_res = (Button) findViewById(R.id.bt_res);
		bt_res.setOnClickListener(this);
		bt_cancel = (Button) findViewById(R.id.bt_cansel);
		bt_cancel.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.bt_0:
			symbol.append("0");
			break;
		case R.id.bt_1:
			symbol.append("1");
			break;
		case R.id.bt_2:
			symbol.append("2");
			break;
		case R.id.bt_3:
			symbol.append("3");
			break;
		case R.id.bt_4:
			symbol.append("4");
			break;
		case R.id.bt_5:
			symbol.append("5");
			break;
		case R.id.bt_6:
			symbol.append("6");
			break;
		case R.id.bt_7:
			symbol.append("7");
			break;
		case R.id.bt_8:
			symbol.append("8");
			break;
		case R.id.bt_9:
			symbol.append("9");
			break;
		case R.id.bt_point:
			symbol.append(".");
			break;

		case R.id.bt_sum:
			if (symbol != null & (symbol.length() != 0)) {
				first_number = Float.parseFloat(symbol.toString());
			}
			action = SUMMA;
			symbol.setLength(0);
			break;

		case R.id.bt_minus:
			if (symbol != null & (symbol.length() != 0)) {
				first_number = Float.parseFloat(symbol.toString());
			}
			action = MINUS;
			symbol.setLength(0);
			break;

		case R.id.bt_div:
			if (symbol != null & (symbol.length() != 0)) {
				first_number = Float.parseFloat(symbol.toString());
			}
			action = DIV;
			if (first_number != 0 & second_number == 0) {
				symbol.append("ERROR");
			} else {
				result = Calculate(action);
			}
			symbol.setLength(0);
			break;

		case R.id.bt_multiply:
			if (symbol != null & (symbol.length() != 0)) {
				first_number = Float.parseFloat(symbol.toString());
			}
			action = MULTIPLY;
			symbol.setLength(0);
			break;

		case R.id.bt_res:
			if (first_number != 0 & second_number == 0) {
				symbol.append("ERROR");
			} else {
				result = Calculate(action);
			}
			break;

		case R.id.bt_cansel:
			first_number = (float) 0;
			second_number = (float) 0;
			result = null;
			symbol.setLength(0);
			break;
		}

		tv.setText(symbol);
	}

	private static Float Calculate(int action) {
		switch (action) {
		case SUMMA:
			result = first_number + second_number;
			break;
		case MINUS:
			result = first_number - second_number;
			break;
		case MULTIPLY:
			result = first_number * second_number;
			break;
		case DIV:
			result = first_number / second_number;
			break;
		}
		return result;
	}

}

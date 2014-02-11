package com.example.calc;

import com.example.calc.R;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.SumPathEffect;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	int action = 0;
	TextView tv;
	Button bt_0, bt_1, bt_2, bt_3, bt_4, bt_5, bt_6, bt_7, bt_8, bt_9,
			bt_minus, bt_sum, bt_multiply, bt_div, bt_point, bt_res, bt_cancel;

	StringBuilder symbol = new StringBuilder();
	Float first_number = null;
	Float second_number = null;
	Float result = null;

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
		if (first_number == null) {
			first_number = (float) 0;
		}

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
			if (symbol.length() != 0) {
				symbol.append(".");
			} else {
				symbol.append("0.");
			}
			break;

		case R.id.bt_sum:
			second_number = null;
			if (symbol != null & (symbol.length() != 0)) {
				first_number = Float.parseFloat(symbol.toString());
			}
			action = SUMMA;
			symbol.setLength(0);
			break;

		case R.id.bt_minus:
			second_number = null;
			if (symbol != null & (symbol.length() != 0)) {
				first_number = Float.parseFloat(symbol.toString());
			}
			action = MINUS;
			symbol.setLength(0);
			break;

		case R.id.bt_div:
			second_number = null;
			if (symbol != null & (symbol.length() != 0)) {
				first_number = Float.parseFloat(symbol.toString());
			}
			action = DIV;
			symbol.setLength(0);
			break;

		case R.id.bt_multiply:
			second_number = null;
			if (symbol != null & (symbol.length() != 0)) {
				first_number = Float.parseFloat(symbol.toString());
			}
			action = MULTIPLY;
			symbol.setLength(0);
			break;

		case R.id.bt_res:
			if (symbol.length() != 0 & result == null & second_number == null)
				second_number = Float.parseFloat(symbol.toString());
			symbol.setLength(0);

			if (first_number != null & second_number != null) {

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
					if (second_number != 0) {
						result = first_number / second_number;
					} else {
						symbol.append("error");
						setBtClickAble(false);
					}
					break;
				}
				first_number = result;
			}
			break;

		case R.id.bt_cansel:
			first_number = null;
			second_number = null;
			result = null;
			symbol.setLength(0);
			setBtClickAble(true);
			break;
		}

		if (result != null) {
			if (result == result.intValue()) {
				symbol.append(result.intValue());
			} else {
				symbol.append(result);
			}
		}
		tv.setText(symbol);
		result = null;
	}

	private void setBtClickAble(boolean b) {
		// у�?тановка неактивно�?ти кнопок, заменить, по возможно�?ти, через группы
		bt_0.setClickable(b);
		bt_1.setClickable(b);
		bt_2.setClickable(b);
		bt_3.setClickable(b);
		bt_4.setClickable(b);
		bt_5.setClickable(b);
		bt_6.setClickable(b);
		bt_7.setClickable(b);
		bt_8.setClickable(b);
		bt_9.setClickable(b);
		bt_point.setClickable(b);
		bt_res.setClickable(b);
		bt_sum.setClickable(b);
		bt_minus.setClickable(b);
		bt_multiply.setClickable(b);
		bt_div.setClickable(b);
	}

}

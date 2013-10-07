package com.nakul.example.tipcalculator;

import java.text.DecimalFormat;

import com.nakul.example.tipcalculator.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalcActivity extends Activity {
	private EditText etTotalAmt;
	private TextView tvTipAmt;
	private DecimalFormat df = new DecimalFormat();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calc);
		etTotalAmt = (EditText) findViewById(R.id.etTotalAmt);
		tvTipAmt = (TextView) findViewById(R.id.tvTipAmt);
		df.setMaximumFractionDigits(2);
	}

	public void show15PercentTip(View v) {
		if(isValid()){
			Float tip = Float.parseFloat(etTotalAmt.getText().toString());
			String tipAmount = df.format(tip * 0.15);
			tvTipAmt.setText(tipAmount);
		}
	}
	
	public void show10PercentTip(View v) {
		if(isValid()){
			Float tip = Float.parseFloat(etTotalAmt.getText().toString());
			String tipAmount = df.format(tip * 0.10);
			tvTipAmt.setText(tipAmount);
		}
	}
	
	public void show20PercentTip(View v) {
		if(isValid()){
			Float tip = Float.parseFloat(etTotalAmt.getText().toString());
			String tipAmount = df.format(tip * 0.20);
			tvTipAmt.setText(tipAmount);
		}
	}
	
	private boolean isValid(){
		String totalAmt = etTotalAmt.getText().toString();
		if(totalAmt==null || "".equals(totalAmt)){
			Toast.makeText(this, "Please enter amount.", Toast.LENGTH_SHORT).show();
			return false;
		}
		
		return true;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calc, menu);
		return true;
	}

}

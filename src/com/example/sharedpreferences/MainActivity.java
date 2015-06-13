package com.example.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

	EditText input1,input2;
	Button output1,output2;

	SharedPreferences pref;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		pref=getSharedPreferences("demo", MODE_PRIVATE);
		
		input1=(EditText)findViewById(R.id.txt1);
		input2=(EditText)findViewById(R.id.txt2);
		
		output1=(Button)findViewById(R.id.btn1);
		output2=(Button)findViewById(R.id.btn2);
		
		
		output1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			 	SharedPreferences.Editor editor=pref.edit();
				editor.putString("ch1", input1.getText().toString());
				editor.putString("ch2", input2.getText().toString());
				editor.commit();
			}
		});
		
		output2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String ch1=pref.getString("ch1", "");
				String ch2=pref.getString("ch2", "");
				input1.setText(ch1);
				input2.setText(ch2);
			}
		});
		
		
	}


}

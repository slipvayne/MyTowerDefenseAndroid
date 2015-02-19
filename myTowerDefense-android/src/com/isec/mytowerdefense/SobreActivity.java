package com.isec.mytowerdefense;

import com.swarmconnect.SwarmActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;


public class SobreActivity extends SwarmActivity {
	
	 TextView tv1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sobre);
		
	tv1 = (TextView)findViewById(R.id.texto);

    loadDoc();
 }

private void loadDoc(){

    String s = "";

   
    
    s += ""+getResources().getString(R.string.sobre_texto);
    
    tv1.setMovementMethod(new ScrollingMovementMethod());

    tv1.setText(s);

	}

	public void onSair(View v)
	{
	finish();
	}


}

	



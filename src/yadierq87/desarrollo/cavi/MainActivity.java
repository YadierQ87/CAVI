package yadierq87.desarrollo.cavi;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
//import android.widget.SeekBar;
import android.widget.TextView;
//import android.widget.Toast;


public class MainActivity extends Activity {

	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
	    // MAnejando el elemento seleccionado
	    switch (item.getItemId()) {
	        case R.id.itemCalculo:
	        	 this.calcularImporte(getCurrentFocus());
	            return true;
	        case R.id.itemLimpiar:
	        	this.LimpiarCampos(getCurrentFocus());
	    }
	    return super.onOptionsItemSelected(item);
	}
    
    public void LimpiarCampos(View view){
    
    	for(int i=0; i < 30; i++)
	      {
    		TextView tvCol = (TextView) findViewById(R.id.valueB1 + i);
    		tvCol.setText("");
	      }
    	TextView tvtotalColC1 = (TextView) findViewById(R.id.editTotalC); 
		TextView tvtotalColD2 = (TextView) findViewById(R.id.editTotalD); 
		tvtotalColC1.setText(""); tvtotalColD2.setText("");
    }
    
     public void calcularImporte(View view){
    	
    	//double A = 20.0;
    	double sumC=0,sumD=0;
    	EditText etColTemp = (EditText) findViewById(R.id.editTemp);
    	double ColA = 0;
    	if( etColTemp.getText().length() <= 0 )//los valores estan bien
    	{  Toast.makeText(this, "Inserire il valore della temperatura", Toast.LENGTH_SHORT).show();   }
    	else
    	{
    	 ColA =	Double.parseDouble(etColTemp.getText().toString());
    	//empieza el calculo
    	for(int i=0; i < 30; i+=3)
	      {
    		//capturando los datos y convirtiendo
    		EditText etColB = (EditText) findViewById(R.id.valueB1 + i);
    		//EditText etColB2 = (EditText) findViewById(R.id.editTemp + i);
    		EditText etColC = (EditText) findViewById(R.id.valueC1 + i);    		
    		if( etColB.getText().length() > 0 && etColC.getText().length() > 0 && etColTemp.getText().length() > 0 )//los valores estan bien
    		{	
    		 double ColB = Double.parseDouble(etColB.getText().toString());
    		 double ColC = Double.parseDouble(etColC.getText().toString());
    		 
    		 CalculoTemp  calculotemp = new CalculoTemp(ColA,ColB,ColC); 
    		 sumC = sumC + ColC;
    		 sumD = sumD + calculotemp.getResistencia();
    		 //llenando la ultima columna
    		 TextView tvColD = (TextView) findViewById(R.id.textColD1 + i);    		
     		 tvColD.setText(Double.toString(calculotemp.getResistencia()));    		 
    		}     		
	      } 
    	if (sumC > 0 && sumD > 0) {
    		TextView tvtotalColC = (TextView) findViewById(R.id.editTotalC); 
    		TextView tvtotalColD = (TextView) findViewById(R.id.editTotalD); 
    		tvtotalColC.setText(Double.toString(sumC));	
    		tvtotalColD.setText(Double.toString(sumD));
		}    	
    }
  }
    
}









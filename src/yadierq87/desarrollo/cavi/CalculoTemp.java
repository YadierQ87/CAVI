package yadierq87.desarrollo.cavi;


//import android.provider.SyncStateContract.Constants;

public class CalculoTemp {

	public double ColF_rame_cte = 0.17201/1000000000;
	public int ColG_lunguezza_cte = 1;
	public double ColJ_a_cte = 0.0039;
	public float ColK_temp_cte = 20;
	
	public double ColA_temp, ColB_diamfilo, ColC_lunguezza,  ColL_temp;
	public double ColD_resist_calcolata;
	
	
	public CalculoTemp(double colA_temp, double colB_diamfilo,double colC_lunguezza) {
		super();
		ColA_temp = colA_temp;
		ColB_diamfilo = colB_diamfilo;
		ColC_lunguezza = colC_lunguezza;
		ColL_temp = ColA_temp;
		ColD_resist_calcolata = getResistencia();
	}
	
	//columna D
	public double getResistencia() {//okok
		double result = (ColF_rame_cte *( 1 + ColJ_a_cte * (ColL_temp - ColK_temp_cte))*ColC_lunguezza/getSezionefilo())	;
		return Math.rint(result * 1000)/1000;
	}	
	//columna E
	public double getDiametrofilo() { //okok
		return ColB_diamfilo / 10000;					
	}
	//columna H
	public double getSezionefilo() { //okok
		double sezione = (getDiametrofilo()/2); 
		double sezione_fin = Math.pow(sezione,2) * Math.PI;
		return sezione_fin;
	}
	//columna I
	public double getResistenciaI() {//okok
		return ColF_rame_cte * (ColG_lunguezza_cte/getSezionefilo());				
	}	
	
	//columna M
	public double getP0() {//okok
	       return getResistenciaI()*(1+ColJ_a_cte *(ColL_temp - ColK_temp_cte));						
	}
	//columna N
	public double getNkm() {//okok
		return getP0() * 1000;					
	}
	//columna O
	public double getOLung() {//okok
	    return 1/(getNkm()*1000)	;
	}
	
}

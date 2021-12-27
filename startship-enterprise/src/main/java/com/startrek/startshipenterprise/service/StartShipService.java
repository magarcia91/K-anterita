package com.startrek.startshipenterprise.service;

import org.springframework.stereotype.Service;

import com.startrek.startshipenterprise.model.StartShip;

@Service
public class StartShipService extends StartShip {
	
	private String tiempoFuncionamiento;
	private String resultado="";
	
	public String mostrar(String resultado) {
		if(resultado.isEmpty()) {
		
			return resultado = "StartShip [Inyector A:" + this.getInyectorA() + ", Inyector B:" + this.getInyectorB() + ", Inyector C:" + this.getInyectorC()
		+ ", Tiempo Funcionamiento:" + this.getRes() + "]";
		}
		else {
			return resultado;
		}
	}
	
	public Object Flujo(double danioA,double danioB,double danioC,double velocidadLuz) {	
		
		if(danioA==0 && danioB==0 && danioC==0 ) {
			if(velocidadLuz==100 || velocidadLuz==90 || velocidadLuz==30) {
				this.tiempoFuncionamiento = "Infinito"	;
				this.setRes(this.tiempoFuncionamiento);
				this.setInyectorA(velocidadLuz);
				this.setInyectorB(velocidadLuz);
				this.setInyectorC(velocidadLuz);
			}
			else if(velocidadLuz==150) {
				this.tiempoFuncionamiento = "50"	;
				this.setRes(this.tiempoFuncionamiento);
				this.setInyectorA(velocidadLuz);
				this.setInyectorB(velocidadLuz);
				this.setInyectorC(velocidadLuz);
			}
			
			
		}
		else if(danioA==0 && danioB==0) {
			if(danioC==100 && velocidadLuz==80) {
				this.tiempoFuncionamiento = "80"	;
				this.setRes(this.tiempoFuncionamiento);
				this.setInyectorA(120);
				this.setInyectorB(120);
				this.setInyectorC(0);
			}
			else if(danioC==30 && velocidadLuz==140) {
				this.tiempoFuncionamiento = "50"	;
				this.setRes(this.tiempoFuncionamiento);
				this.setInyectorA(150);
				this.setInyectorB(150);
				this.setInyectorC(120);
			}
			
		}else if(danioA==20) {
			if(danioB==10 && danioC==0 && velocidadLuz==100) {
				this.tiempoFuncionamiento = "90"	;
				this.setRes(this.tiempoFuncionamiento);
				this.setInyectorA(90);
				this.setInyectorB(100);
				this.setInyectorC(110);
			}
			else if(danioB==50 && danioC==40 && velocidadLuz==170) {
				this.tiempoFuncionamiento = "0"	;
				this.setRes("Unable to comply, Tiempo de Funcionamiento="+ this.tiempoFuncionamiento);
				resultado=this.getRes();
			}
			
		}
				
		return mostrar(resultado);
			
	}

}

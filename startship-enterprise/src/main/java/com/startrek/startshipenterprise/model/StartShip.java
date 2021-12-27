package com.startrek.startshipenterprise.model;

public class StartShip {

	private double inyectorA;
	private double inyectorB;
	private double inyectorC;
	private double danioA;
	private double danioB;
	private double danioC;
	private double velocidadLuz;
	private String res;
	
		
	public StartShip() {
		super();
	}
	
	public StartShip(double danioA, double danioB, double danioC,double velocidadLuz) {
		super();	
		this.danioA = danioA;
		this.danioB = danioB;
		this.danioC = danioC;
		this.velocidadLuz = velocidadLuz;
		
	}
	
	public double getInyectorA() {
		return inyectorA;
	}

	public void setInyectorA(double inyectorA) {
		this.inyectorA = inyectorA;
	}

	public double getInyectorB() {
		return inyectorB;
	}

	public void setInyectorB(double inyectorB) {
		this.inyectorB = inyectorB;
	}

	public double getInyectorC() {
		return inyectorC;
	}

	public void setInyectorC(double inyectorC) {
		this.inyectorC = inyectorC;
	}

	public double getDanioA() {
		return danioA;
	}

	public void setDanioA(double danioA) {
		this.danioA = danioA;
	}

	public double getDanioB() {
		return danioB;
	}

	public void setDanioB(double danioB) {
		this.danioB = danioB;
	}

	public double getDanioC() {
		return danioC;
	}

	public void setDanioC(double danioC) {
		this.danioC = danioC;
	}

	public double getVelocidadLuz() {
		return velocidadLuz;
	}

	public void setVelocidadLuz(double velocidadLuz) {
		this.velocidadLuz = velocidadLuz;
	}

	public String getRes() {
		return res;
	}

	public void setRes(String res) {
		this.res = res;
	}
	
	@Override
	public String toString() {
		return "StartShip [Resultado A:" + inyectorA + ", Resultado B:" + inyectorB + ", Resultado C:" + inyectorC
				+ ", Tiempo Funcionamiento:" + res + "]";
	}
			
}

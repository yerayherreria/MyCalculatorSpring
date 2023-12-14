package com.jacaranda.calculator.model;

import java.util.Objects;

import jakarta.validation.constraints.NotNull;

public class ElectricalPower {
	@NotNull(message="No puede ser nulo")
	private int volt;
	@NotNull(message="No puede ser nulo")
	private int amp;
	
	public int getVolt() {
		return volt;
	}
	public void setVolt(int volt) throws Exception {
		try {
			this.volt = volt;			
		}catch(Exception e) {
			throw new Exception("Volt not valid");
		}
	}
	public int getAmp() {
		return amp;
	}
	public void setAmp(int amp) throws Exception {
		try {
			this.amp = amp;
			
		}catch(Exception e) {
			throw new Exception("Amp not valid");
		}
	}
	
	public double getResult() {
		return this.volt*this.amp;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(amp, volt);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ElectricalPower other = (ElectricalPower) obj;
		return amp == other.amp && volt == other.volt;
	}
	
	
}

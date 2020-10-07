package com.java.model;

public class Phase {
      private String phase_id;
      private String phase_name;
      private String phase_description;
      
	public String getPhase_id() {
		return phase_id;
	}
	public void setPhase_id(String phase_id) {
		this.phase_id = phase_id;
	}
	public String getPhase_name() {
		return phase_name;
	}
	public void setPhase_name(String phase_name) {
		this.phase_name = phase_name;
	}
	public String getPhase_description() {
		return phase_description;
	}
	public void setPhase_description(String phase_description) {
		this.phase_description = phase_description;
	}
	
	@Override
	public String toString() {
		return "Phase [phase_id=" + phase_id + ", phase_name=" + phase_name + ", phase_description=" + phase_description
				+ "]";
	}
      
      
}

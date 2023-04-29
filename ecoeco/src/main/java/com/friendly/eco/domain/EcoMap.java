package com.friendly.eco.domain;

import lombok.Data;

@Data
public class EcoMap {
	private int ecomap_idx;
	private EcoMapCategory ecoMapCategory; // association
	private Mem mem; // association
	private String ecomap_placename;
	private String ecomap_addr;
	private int ecomap_lati;
	private int ecomap_longi;
	private String ecomap_grade;
	private String ecomap_detail;
	private String ecomap_regdate;
}

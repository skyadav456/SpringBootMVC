package com.sharad.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service("seasonService")
public class ISeasonFinderServiceImpl implements ISeasonFinderService {

	@Override
	public String findSeason() {
		//get System Date
		LocalDate ld = LocalDate.now();
		//get current months
		int month = ld.getMonthValue();
		
		if(month>=7&&month<=9) {
			return "Rainy Season";
		}else if(month>=3 && month<=6) {
			return "Summer Season";
		}else
			return "Winter Season";
	}

}

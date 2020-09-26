package com.eval.coronakit.service;

import com.eval.coronakit.entity.CoronaKit;

public interface CoronaKitService{
	public CoronaKit saveKit(CoronaKit kit);
	public CoronaKit getKitById(int kitId);
}

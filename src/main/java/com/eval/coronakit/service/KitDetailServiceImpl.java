package com.eval.coronakit.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eval.coronakit.dao.KitDetailRepository;
import com.eval.coronakit.entity.KitDetail;

@Service
public class KitDetailServiceImpl implements KitDetailService {

	@Autowired
	KitDetailRepository repository;
	
	@Override
	@Transactional
	public KitDetail addKitItem(KitDetail kitItem) {
		if(kitItem!=null) {
			repository.save(kitItem);
		}
		return kitItem;
	}

	@Override
	public KitDetail getKitItemById(int itemId) {
		return repository.findById(itemId).orElse(null);
	}

	@Override
	public List<KitDetail> getAllKitItemsOfAKit(int kitId) {
		return repository.findAll();
	}

}

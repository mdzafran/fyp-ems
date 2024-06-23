package com.ems.estatemanagementsystem.service.propertyservice;

import java.util.List;

import com.ems.estatemanagementsystem.entity.User;
import com.ems.estatemanagementsystem.entity.property.Share;

public interface ShareService {
    List<Share> getAllShares();

	List<Share> getSharesByUser(User user);

	List<Share> getSharesByUserId(Long userId);
	
	Share saveShare(Share share);
	
	Share getShareById(Long id);
	
	Share updateShare(Share share);
	
	void deleteShareById(Long id);
}

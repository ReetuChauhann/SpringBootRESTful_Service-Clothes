package com.reetu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.Cloth;
import com.reetu.dao.ClothRepo;

@Service
public class services implements MyService {
	         @Autowired
	         ClothRepo cr;

	

	@Override
	public List<Cloth> getallcloth() {
		// TODO Auto-generated method stub
		return cr.getallcloth();
	}

	@Override
	public List<Cloth> getclothbyname(String name) {
		// TODO Auto-generated method stub
		return cr.getclothbyname(name);
	}

	@Override
	public List<Cloth> getsamename(String name) {
		// TODO Auto-generated method stub
		return cr.getsamename(name);
	}

	@Override
	public List<Integer> getallids() {
		// TODO Auto-generated method stub
		return cr.getallids();
	}

	@Override
	public String updatecloth(Cloth c) {
		// TODO Auto-generated method stub
		return cr.updatecloth(c);
	}

	@Override
	public String deletecloth(int cid) {
		// TODO Auto-generated method stub
		return cr.deletecloth(cid);
	}

	@Override
	public String addcloth(Cloth c, MultipartFile image1) {
		
		return cr.addcloth(c, image1);
	}

	@Override
	public byte[] getimage(int cid) {
		// TODO Auto-generated method stub
		return cr.getimage(cid);
	}

	@Override
	public String updateimage(int cid, MultipartFile image) {
		// TODO Auto-generated method stub
		return cr.updateimage(cid, image);
	}

	

	
	
	

}

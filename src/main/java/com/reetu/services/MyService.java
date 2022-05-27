package com.reetu.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.Cloth;

public interface MyService {
	 public String addcloth(Cloth c,MultipartFile image1); 
	 public List<Cloth> getallcloth();
	 public List<Cloth> getclothbyname(String name);
	 public List<Cloth> getsamename(String name);
	 public List<Integer> getallids();
	 public String updatecloth(Cloth c);
	 public String deletecloth(int cid);
	 public byte [] getimage(int cid);
	 public String updateimage(int cid, MultipartFile image);
}

package com.reetu.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.Cloth;
import com.reetu.services.MyService;

@RestController
public class Controller {
	                       @Autowired
	                       MyService services;
	             @RequestMapping("/")
	             public String home() {
	            	 return "hey there!";
	             }
	                       
	             @GetMapping("/getallclothes")
	             public List<Cloth> getallcloth(){
	            	 List<Cloth> c = services.getallcloth();
	            	 return c;
	             }
	            
	            @GetMapping("/getbyname/{name}")
	            public List<Cloth> getbyname(@PathVariable("name") String name){
	            	List<Cloth> c = services.getclothbyname(name);
	            	return c;
	            }
	            
	            @PostMapping(value = "/addcloth")
	            public ResponseEntity<String> addcloth(@RequestPart("Cloth") Cloth c,@RequestPart("image") MultipartFile image) {
	            	String s = services.addcloth(c, image);
	            	if(s=="success") {
	            		return new ResponseEntity<String>(s,HttpStatus.OK);
	            	}else {
	            		return new ResponseEntity<>(s, HttpStatus.NOT_MODIFIED);
	            	}
	            }
	            
	           @GetMapping("/getallids")
	           public List<Integer> getallids(){
	        	   List<Integer> d = services.getallids();
	        	   return d;
	           }
	           
	           @GetMapping("/getcolthlikename/{name}")
	           public List<Cloth> likename(@PathVariable("name") String name){
	        	   List<Cloth> g = services.getsamename(name);
	        	   return g;
	           }
	           
	           @PutMapping(value = "/update", consumes= {"application/xml","application/json"})
	           public String updatecloth(@RequestBody Cloth c) {
	        	   String s= services.updatecloth(c);
	        	   if(s=="success") {
	        		   return "success";
	        	   }else{
	        		   return "failed";
	        	   }
	        	   
	           }
	           
	           @DeleteMapping(value = "/delete/{cid}")
	           public String delete(@PathVariable("cid") int cid) {
	        	   String s = services.deletecloth(cid);
	        	   if(s=="success") {
	        		   return "Successfully Deleted";
	        	   }else {
	        		   return "Error";
	        	   }
	        	   
	           }
	           
	           @GetMapping(value = "/getImage/{cid}")
	           public byte [] getimage(@PathVariable("cid") int cid) {
	        	   
	        	   byte [] b=services.getimage(cid);
	        	   if(b!=null) {
	        		   return b;
	        	   }else {
	        		   return null;
	        	   }
	        	   
	           }
	           
	           @PutMapping("/updateImage")
	           public ResponseEntity<String> updateImagehere( @RequestPart("cid") int cid, @RequestPart("image") MultipartFile image) {
	        	   String s= services.updateimage(cid, image);
	        	   if(s=="success") {
	            		return new ResponseEntity<String>(s,HttpStatus.OK);
	            	}else {
	            		return new ResponseEntity<>(s, HttpStatus.NOT_MODIFIED);
	            	}
	           }

}

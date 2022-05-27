package com.reetu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.Cloth;

@Repository
public class ClothRepo {
	                 
	                       @Autowired
	                       JdbcTemplate jdbctemplate;
	                       
	                    // to add cloth
	                    public String addcloth(Cloth c,MultipartFile image1) {
	                    	try {
	                    		   String query = "insert into clothes values(?,?,?,?,?)";
	                    		   int x = jdbctemplate.update(query, new Object[] {c.getCid(), c.getName(), c.getPrice(), c.getBrand(),image1.getInputStream()});
								 if(x!=0) {
									 return "success";
								 }else {
									 return "failed";
								 }
									 
							} catch (Exception e) {
							      e.printStackTrace();
							      return "failed";
							}
	                    }
	                // to get all the clothes
	                    
	                public List<Cloth> getallcloth(){
	                	class ClothMapper implements RowMapper{

							@Override
							public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
								Cloth c = new Cloth();
								c.setCid(rs.getInt("cid"));
								c.setName(rs.getString("name"));
								c.setPrice(rs.getInt("price"));
								c.setBrand(rs.getString("brand"));
							    return c;
							}
	                		
	                	}
	                   try {
	                	   final String query = "select * from clothes";
		                   List<Cloth> c= jdbctemplate.query(query, new ClothMapper());
		                   if(c!=null) {
		                   return c;
		                   }else {
		                	   return null;
		                   }
					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}
	                }
	               // to get clothes by name
	               public List<Cloth> getclothbyname(String name){
	            	   class ClothMapper implements RowMapper{

						@Override
						public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
							Cloth c = new Cloth();
							c.setCid(rs.getInt("cid"));
							c.setName(rs.getString("name"));
							c.setPrice(rs.getInt("price"));
							c.setBrand(rs.getString("brand"));
							return c;
						}
	            		   
	            	   }
	            	  try {
	            		  final String query = "select * from clothes where name=?";
		            	   List<Cloth> c = jdbctemplate.query(query, new ClothMapper(), new Object[] {name});
		            	   if(c!=null) {
			                   return c;
			                   }else {
			                	   return null;
			                   }
						} catch (Exception e) {
							e.printStackTrace();
							return null;
						}
	               }
	               
	               // to get same name cloth
	               public List<Cloth> getsamename(String name){
	            	   class ClothMapper implements RowMapper{

						@Override
						public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
							Cloth c = new Cloth();
							c.setCid(rs.getInt("cid"));
							c.setName(rs.getString("name"));
							c.setPrice(rs.getInt("price"));
							c.setBrand(rs.getString("brand"));
							return c;
						}
	            		   
	            	 }
	            	   try {
	            		   final String query = "select * from clothes where name like ?";
		            	   List<Cloth> c = jdbctemplate.query(query, new ClothMapper(), new Object[] {"%"+name+"%"});
		            	   if(c!=null) {
			                   return c;
			                   }else {
			                	   return null;
			                   }
						} catch (Exception e) {
							e.printStackTrace();
							return null;
					}
	              }
	               
	               
	               //get all ids only
	              public List<Integer> getallids(){
	            	   class ClothMapper implements RowMapper{

						@Override
						public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
							
							return rs.getInt("cid");
						}
	            	  }
	            	   final String query = "select cid from clothes";
	            	   List<Integer> t= jdbctemplate.query(query, new ClothMapper());
	            	   return t;   
	            	   }
	              
	              // delete by id
	              public String deletecloth(int cid) {
	            	  try {
	            		     String query = "delete from clothes where cid=?";
	            		     int x = jdbctemplate.update(query, new Object[] {cid});
	            		     if(x!=0) {
								 return "success";
							 }else {
								 return "failed";
							 }
								 
						} catch (Exception e) {
						      e.printStackTrace();
						      return "failed";
						}
	              }
	              
	              //update cloth
	              public String updatecloth(Cloth c) {
	            	  try {
	            		    String query = "update clothes set name=?,price=?,brand=? where cid=?";
	            		    int x = jdbctemplate.update(query, new Object[] {c.getName(), c.getPrice(), c.getBrand(),c.getCid()});
					        if(x!=0) {
								 return "success";
							 }else {
								 return "failed";
							 }
								 
						} catch (Exception e) {
						      e.printStackTrace();
						      return "failed";
						}
	              }
	              //get image
	              public byte [] getimage(int cid) {
	              	
	              	class ClothMapper implements RowMapper{

	  					@Override
	  					public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
	  						
	  						return rs.getBytes("image");
	  					}
	              		
	              	}
	              	try {
	  					   final String query = "select image from clothes where cid=?";
	  					   byte [] b = (byte []) jdbctemplate.queryForObject(query, new ClothMapper(), new Object[] {cid});
	  					   return b;
	  				} catch (EmptyResultDataAccessException e) {
	  					e.printStackTrace();
	  					return null;
	  				}
	              }
	              
	              //update image
	              public String updateimage(int cid, MultipartFile image) {
	            	  try {
						      String query="update clothes set image=? where cid=?";
						      int x=jdbctemplate.update(query, new Object[] {image.getInputStream(), cid});
						      if(x!=0) {
						    	  return "success";
						      }else {
						    	  return "failed";
						      }
					} catch (Exception e) {
						e.printStackTrace();
						return "failed";
					}
	              }
	              
	               

}

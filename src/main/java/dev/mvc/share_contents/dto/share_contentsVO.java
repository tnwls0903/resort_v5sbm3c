package dev.mvc.share_contents.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class share_contentsVO {
	private int scon_no;
	
	private int catno;
	
	private int pro_no;
	
	private String socn_name="";
	
	private String scon_contents="";
	
	private int scon_views;
	
	private int scon_bookmark;
	
	private int scon_comment;
	
	private String scon_commnet;
	
	private int scon_priority;
	
}

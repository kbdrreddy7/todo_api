package com.uttara.beans;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Todo {

	@Id @GeneratedValue
	private Long sl;
	
	
	private String name;
	
	private String desc;
	
	private Date startDate;
	
	private Date endDate;
	
	private String status; 

	
	
	public Todo() {
		super();
	}

	public Long getSl() {
		return sl;
	}

	public void setSl(Long sl) {
		this.sl = sl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Todo(String name, String desc, Date startDate, Date endDate) {
		super();
		this.name = name;
		this.desc = desc;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	
	
	
	@Override
	public String toString() {
		return "Todo [sl=" + sl + ", name=" + name + ", desc=" + desc + ", startDate=" + startDate + ", endDate="
				+ endDate + ", status=" + status + "]";
	}

	public Map<String, String> validate() {
		
		Map<String,String>validations=new HashMap<String,String>();
		
		if(name==null || name.trim().equals(""))
			validations.put("name", "Name should not be empty");
		
		if(desc==null || desc.trim().equals(""))
			validations.put("desc", "Description should not be empty");
		
		if(startDate==null)
			validations.put("startDate", "Start Date should not be empty");
		
		else if(startDate.before(new Date()))
			  
			validations.put("startDate", "Start Date should be future date");
		
		
		if(endDate==null)
			validations.put("endDate", "End Date should not be empty");
		
		else if(endDate.before(new Date()))
			  
			validations.put("endDate", "End Date should be future date");
		
			 
		
		return validations.size()==0?null:validations;

		
	}
	
		
	
	
}

/**
 * 
 */
package com.centrica.task.api.model;

/**
 * @author wemccl
 *
 */
public class Customer {

	private String id ;
	private String name ;	
    private String promotion;

    
    public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	/**
     * 
     * @param name
     */
	public Customer(String id) { 
       this.id = id;
    }
	
	/**
	 * 
	 * @return
	 */
    public String getPromotion() {
		return promotion;
	}
    
	/**
	 * 
	 * @param motd
	 */
	public void setPromotion(String motd) {
		this.promotion = motd;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}

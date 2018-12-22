package com.digital.education.system.ui.managed.bean;


import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.richfaces.event.ItemChangeEvent;

@ManagedBean
@ApplicationScoped
public class PanelMenuBean implements Serializable {
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String current;
	    private boolean singleMode;
	 
	    public boolean isSingleMode() {
	        return singleMode;
	    }
	 
	    public void setSingleMode(boolean singleMode) {
	        this.singleMode = singleMode;
	    }
	 
	    public String getCurrent() {
	        return this.current;
	    }
	 
	    public void setCurrent(String current) {
	        this.current = current;
	    }
	 
	    public void updateCurrent(ItemChangeEvent event) {
	        setCurrent(event.getNewItemName());
	    	
	    	
	    }
	}



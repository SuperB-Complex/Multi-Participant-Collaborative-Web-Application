package com.slack.pojo;

import java.util.HashSet;
import java.util.Set;


/**
 * WorkSpace entity. @author MyEclipse Persistence Tools
 */

public class WorkSpace  implements java.io.Serializable {


    // Fields    

     private Integer wid;
     private String wname;
     private String wdescription;
     private Set spaceMems = new HashSet(0);
     private Set chans = new HashSet(0);


    // Constructors

    /** default constructor */
    public WorkSpace() {
    }

	/** minimal constructor */
    public WorkSpace(String wname) {
        this.wname = wname;
    }
    
    /** full constructor */
    public WorkSpace(String wname, String wdescription, Set spaceMems, Set chans) {
        this.wname = wname;
        this.wdescription = wdescription;
        this.spaceMems = spaceMems;
        this.chans = chans;
    }

   
    // Property accessors

    public Integer getWid() {
        return this.wid;
    }
    
    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getWname() {
        return this.wname;
    }
    
    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getWdescription() {
        return this.wdescription;
    }
    
    public void setWdescription(String wdescription) {
        this.wdescription = wdescription;
    }

    public Set getSpaceMems() {
        return this.spaceMems;
    }
    
    public void setSpaceMems(Set spaceMems) {
        this.spaceMems = spaceMems;
    }

    public Set getChans() {
        return this.chans;
    }
    
    public void setChans(Set chans) {
        this.chans = chans;
    }
   








}
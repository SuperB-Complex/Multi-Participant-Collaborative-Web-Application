package com.slack.pojo;

import java.util.HashSet;
import java.util.Set;


/**
 * Chan entity. @author MyEclipse Persistence Tools
 */

public class Chan  implements java.io.Serializable {


    // Fields    

     private ChanId id;
     private WorkSpace workSpace;
     private Integer chtype;
     private Set chaMems = new HashSet(0);


    // Constructors

    /** default constructor */
    public Chan() {
    }

	/** minimal constructor */
    public Chan(ChanId id, WorkSpace workSpace, Integer chtype) {
        this.id = id;
        this.workSpace = workSpace;
        this.chtype = chtype;
    }
    
    /** full constructor */
    public Chan(ChanId id, WorkSpace workSpace, Integer chtype, Set chaMems) {
        this.id = id;
        this.workSpace = workSpace;
        this.chtype = chtype;
        this.chaMems = chaMems;
    }

   
    // Property accessors

    public ChanId getId() {
        return this.id;
    }
    
    public void setId(ChanId id) {
        this.id = id;
    }

    public WorkSpace getWorkSpace() {
        return this.workSpace;
    }
    
    public void setWorkSpace(WorkSpace workSpace) {
        this.workSpace = workSpace;
    }

    public Integer getChtype() {
        return this.chtype;
    }
    
    public void setChtype(Integer chtype) {
        this.chtype = chtype;
    }

    public Set getChaMems() {
        return this.chaMems;
    }
    
    public void setChaMems(Set chaMems) {
        this.chaMems = chaMems;
    }
   








}
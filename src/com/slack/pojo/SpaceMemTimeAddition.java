package com.slack.pojo;

import java.sql.Timestamp;


/**
 * SpaceMemTimeAddition entity. @author MyEclipse Persistence Tools
 */

public class SpaceMemTimeAddition  implements java.io.Serializable {


    // Fields    

     private Integer staid;
     private SpaceMem spaceMem;
     private Timestamp winvited;
     private Timestamp wjointime;


    // Constructors

    /** default constructor */
    public SpaceMemTimeAddition() {
    }

	/** minimal constructor */
    public SpaceMemTimeAddition(SpaceMem spaceMem, Timestamp winvited) {
        this.spaceMem = spaceMem;
        this.winvited = winvited;
    }
    
    /** full constructor */
    public SpaceMemTimeAddition(SpaceMem spaceMem, Timestamp winvited, Timestamp wjointime) {
        this.spaceMem = spaceMem;
        this.winvited = winvited;
        this.wjointime = wjointime;
    }

   
    // Property accessors

    public Integer getStaid() {
        return this.staid;
    }
    
    public void setStaid(Integer staid) {
        this.staid = staid;
    }

    public SpaceMem getSpaceMem() {
        return this.spaceMem;
    }
    
    public void setSpaceMem(SpaceMem spaceMem) {
        this.spaceMem = spaceMem;
    }

    public Timestamp getWinvited() {
        return this.winvited;
    }
    
    public void setWinvited(Timestamp winvited) {
        this.winvited = winvited;
    }

    public Timestamp getWjointime() {
        return this.wjointime;
    }
    
    public void setWjointime(Timestamp wjointime) {
        this.wjointime = wjointime;
    }
   








}
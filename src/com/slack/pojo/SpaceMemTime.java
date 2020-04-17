package com.slack.pojo;

import java.sql.Timestamp;


/**
 * SpaceMemTime entity. @author MyEclipse Persistence Tools
 */

public class SpaceMemTime  implements java.io.Serializable {


    // Fields    

     private Integer stid;
     private SpaceMem spaceMemBySpacememTimeIbfk2;
     private SpaceMem spaceMemBySpacememTimeIbfk1;
     private Timestamp winvited;
     private Timestamp wjointime;


    // Constructors

    /** default constructor */
    public SpaceMemTime() {
    }

	/** minimal constructor */
    public SpaceMemTime(SpaceMem spaceMemBySpacememTimeIbfk2, SpaceMem spaceMemBySpacememTimeIbfk1, Timestamp winvited) {
        this.spaceMemBySpacememTimeIbfk2 = spaceMemBySpacememTimeIbfk2;
        this.spaceMemBySpacememTimeIbfk1 = spaceMemBySpacememTimeIbfk1;
        this.winvited = winvited;
    }
    
    /** full constructor */
    public SpaceMemTime(SpaceMem spaceMemBySpacememTimeIbfk2, SpaceMem spaceMemBySpacememTimeIbfk1, Timestamp winvited, Timestamp wjointime) {
        this.spaceMemBySpacememTimeIbfk2 = spaceMemBySpacememTimeIbfk2;
        this.spaceMemBySpacememTimeIbfk1 = spaceMemBySpacememTimeIbfk1;
        this.winvited = winvited;
        this.wjointime = wjointime;
    }

   
    // Property accessors

    public Integer getStid() {
        return this.stid;
    }
    
    public void setStid(Integer stid) {
        this.stid = stid;
    }

    public SpaceMem getSpaceMemBySpacememTimeIbfk2() {
        return this.spaceMemBySpacememTimeIbfk2;
    }
    
    public void setSpaceMemBySpacememTimeIbfk2(SpaceMem spaceMemBySpacememTimeIbfk2) {
        this.spaceMemBySpacememTimeIbfk2 = spaceMemBySpacememTimeIbfk2;
    }

    public SpaceMem getSpaceMemBySpacememTimeIbfk1() {
        return this.spaceMemBySpacememTimeIbfk1;
    }
    
    public void setSpaceMemBySpacememTimeIbfk1(SpaceMem spaceMemBySpacememTimeIbfk1) {
        this.spaceMemBySpacememTimeIbfk1 = spaceMemBySpacememTimeIbfk1;
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
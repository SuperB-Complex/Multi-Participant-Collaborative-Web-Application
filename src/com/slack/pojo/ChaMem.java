package com.slack.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * ChaMem entity. @author MyEclipse Persistence Tools
 */

public class ChaMem  implements java.io.Serializable {


    // Fields    

     private ChaMemId id;
     private Chan chan;
     private SpaceMem spaceMem;
     private Timestamp cinvitedtime;
     private Integer state;
     private Timestamp cjointime;
     private Set messages = new HashSet(0);


    // Constructors

    /** default constructor */
    public ChaMem() {
    }

	/** minimal constructor */
    public ChaMem(ChaMemId id, Chan chan, SpaceMem spaceMem, Timestamp cinvitedtime, Integer state) {
        this.id = id;
        this.chan = chan;
        this.spaceMem = spaceMem;
        this.cinvitedtime = cinvitedtime;
        this.state = state;
    }
    
    /** full constructor */
    public ChaMem(ChaMemId id, Chan chan, SpaceMem spaceMem, Timestamp cinvitedtime, Integer state, Timestamp cjointime, Set messages) {
        this.id = id;
        this.chan = chan;
        this.spaceMem = spaceMem;
        this.cinvitedtime = cinvitedtime;
        this.state = state;
        this.cjointime = cjointime;
        this.messages = messages;
    }

   
    // Property accessors

    public ChaMemId getId() {
        return this.id;
    }
    
    public void setId(ChaMemId id) {
        this.id = id;
    }

    public Chan getChan() {
        return this.chan;
    }
    
    public void setChan(Chan chan) {
        this.chan = chan;
    }

    public SpaceMem getSpaceMem() {
        return this.spaceMem;
    }
    
    public void setSpaceMem(SpaceMem spaceMem) {
        this.spaceMem = spaceMem;
    }

    public Timestamp getCinvitedtime() {
        return this.cinvitedtime;
    }
    
    public void setCinvitedtime(Timestamp cinvitedtime) {
        this.cinvitedtime = cinvitedtime;
    }

    public Integer getState() {
        return this.state;
    }
    
    public void setState(Integer state) {
        this.state = state;
    }

    public Timestamp getCjointime() {
        return this.cjointime;
    }
    
    public void setCjointime(Timestamp cjointime) {
        this.cjointime = cjointime;
    }

    public Set getMessages() {
        return this.messages;
    }
    
    public void setMessages(Set messages) {
        this.messages = messages;
    }
   








}
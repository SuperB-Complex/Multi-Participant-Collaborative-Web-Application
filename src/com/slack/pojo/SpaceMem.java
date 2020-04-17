package com.slack.pojo;

import java.util.HashSet;
import java.util.Set;


/**
 * SpaceMem entity. @author MyEclipse Persistence Tools
 */

public class SpaceMem  implements java.io.Serializable {


    // Fields    

     private SpaceMemId id;
     private WorkSpace workSpace;
     private Customer customer;
     private Integer ustate;
     private Set spaceMemTimesForSpacememTimeIbfk2 = new HashSet(0);
     private Set chaMems = new HashSet(0);
     private Set spaceMemTimesForSpacememTimeIbfk1 = new HashSet(0);
     private Set spaceMemTimeAdditions = new HashSet(0);


    // Constructors

    /** default constructor */
    public SpaceMem() {
    }

	/** minimal constructor */
    public SpaceMem(SpaceMemId id, WorkSpace workSpace, Customer customer, Integer ustate) {
        this.id = id;
        this.workSpace = workSpace;
        this.customer = customer;
        this.ustate = ustate;
    }
    
    /** full constructor */
    public SpaceMem(SpaceMemId id, WorkSpace workSpace, Customer customer, Integer ustate, Set spaceMemTimesForSpacememTimeIbfk2, Set chaMems, Set spaceMemTimesForSpacememTimeIbfk1, Set spaceMemTimeAdditions) {
        this.id = id;
        this.workSpace = workSpace;
        this.customer = customer;
        this.ustate = ustate;
        this.spaceMemTimesForSpacememTimeIbfk2 = spaceMemTimesForSpacememTimeIbfk2;
        this.chaMems = chaMems;
        this.spaceMemTimesForSpacememTimeIbfk1 = spaceMemTimesForSpacememTimeIbfk1;
        this.spaceMemTimeAdditions = spaceMemTimeAdditions;
    }

   
    // Property accessors

    public SpaceMemId getId() {
        return this.id;
    }
    
    public void setId(SpaceMemId id) {
        this.id = id;
    }

    public WorkSpace getWorkSpace() {
        return this.workSpace;
    }
    
    public void setWorkSpace(WorkSpace workSpace) {
        this.workSpace = workSpace;
    }

    public Customer getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getUstate() {
        return this.ustate;
    }
    
    public void setUstate(Integer ustate) {
        this.ustate = ustate;
    }

    public Set getSpaceMemTimesForSpacememTimeIbfk2() {
        return this.spaceMemTimesForSpacememTimeIbfk2;
    }
    
    public void setSpaceMemTimesForSpacememTimeIbfk2(Set spaceMemTimesForSpacememTimeIbfk2) {
        this.spaceMemTimesForSpacememTimeIbfk2 = spaceMemTimesForSpacememTimeIbfk2;
    }

    public Set getChaMems() {
        return this.chaMems;
    }
    
    public void setChaMems(Set chaMems) {
        this.chaMems = chaMems;
    }

    public Set getSpaceMemTimesForSpacememTimeIbfk1() {
        return this.spaceMemTimesForSpacememTimeIbfk1;
    }
    
    public void setSpaceMemTimesForSpacememTimeIbfk1(Set spaceMemTimesForSpacememTimeIbfk1) {
        this.spaceMemTimesForSpacememTimeIbfk1 = spaceMemTimesForSpacememTimeIbfk1;
    }

    public Set getSpaceMemTimeAdditions() {
        return this.spaceMemTimeAdditions;
    }
    
    public void setSpaceMemTimeAdditions(Set spaceMemTimeAdditions) {
        this.spaceMemTimeAdditions = spaceMemTimeAdditions;
    }
   








}
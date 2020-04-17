package com.slack.pojo;

import java.util.HashSet;
import java.util.Set;


/**
 * Customer entity. @author MyEclipse Persistence Tools
 */

public class Customer  implements java.io.Serializable {


    // Fields    

     private Integer uid;
     private String username;
     private String useremail;
     private String nickname;
     private String userpwd;
     private Set spaceMems = new HashSet(0);


    // Constructors

    /** default constructor */
    public Customer() {
    }

	/** minimal constructor */
    public Customer(String username, String useremail, String nickname, String userpwd) {
        this.username = username;
        this.useremail = useremail;
        this.nickname = nickname;
        this.userpwd = userpwd;
    }
    
    /** full constructor */
    public Customer(String username, String useremail, String nickname, String userpwd, Set spaceMems) {
        this.username = username;
        this.useremail = useremail;
        this.nickname = nickname;
        this.userpwd = userpwd;
        this.spaceMems = spaceMems;
    }

   
    // Property accessors

    public Integer getUid() {
        return this.uid;
    }
    
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return this.useremail;
    }
    
    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getNickname() {
        return this.nickname;
    }
    
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUserpwd() {
        return this.userpwd;
    }
    
    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public Set getSpaceMems() {
        return this.spaceMems;
    }
    
    public void setSpaceMems(Set spaceMems) {
        this.spaceMems = spaceMems;
    }
   








}
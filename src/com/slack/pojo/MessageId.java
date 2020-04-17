package com.slack.pojo;

import java.sql.Timestamp;


/**
 * MessageId entity. @author MyEclipse Persistence Tools
 */

public class MessageId  implements java.io.Serializable {


    // Fields    

     private String cname;
     private Integer wid;
     private Timestamp posttime;
     private Integer posterid;


    // Constructors

    /** default constructor */
    public MessageId() {
    }

    
    /** full constructor */
    public MessageId(String cname, Integer wid, Timestamp posttime, Integer posterid) {
        this.cname = cname;
        this.wid = wid;
        this.posttime = posttime;
        this.posterid = posterid;
    }

   
    // Property accessors

    public String getCname() {
        return this.cname;
    }
    
    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getWid() {
        return this.wid;
    }
    
    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Timestamp getPosttime() {
        return this.posttime;
    }
    
    public void setPosttime(Timestamp posttime) {
        this.posttime = posttime;
    }

    public Integer getPosterid() {
        return this.posterid;
    }
    
    public void setPosterid(Integer posterid) {
        this.posterid = posterid;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof MessageId) ) return false;
		 MessageId castOther = ( MessageId ) other; 
         
		 return ( (this.getCname()==castOther.getCname()) || ( this.getCname()!=null && castOther.getCname()!=null && this.getCname().equals(castOther.getCname()) ) )
 && ( (this.getWid()==castOther.getWid()) || ( this.getWid()!=null && castOther.getWid()!=null && this.getWid().equals(castOther.getWid()) ) )
 && ( (this.getPosttime()==castOther.getPosttime()) || ( this.getPosttime()!=null && castOther.getPosttime()!=null && this.getPosttime().equals(castOther.getPosttime()) ) )
 && ( (this.getPosterid()==castOther.getPosterid()) || ( this.getPosterid()!=null && castOther.getPosterid()!=null && this.getPosterid().equals(castOther.getPosterid()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCname() == null ? 0 : this.getCname().hashCode() );
         result = 37 * result + ( getWid() == null ? 0 : this.getWid().hashCode() );
         result = 37 * result + ( getPosttime() == null ? 0 : this.getPosttime().hashCode() );
         result = 37 * result + ( getPosterid() == null ? 0 : this.getPosterid().hashCode() );
         return result;
   }   





}
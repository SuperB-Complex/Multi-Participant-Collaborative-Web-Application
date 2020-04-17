package com.slack.pojo;



/**
 * SpaceMemId entity. @author MyEclipse Persistence Tools
 */

public class SpaceMemId  implements java.io.Serializable {


    // Fields    

     private Integer wid;
     private Integer userid;


    // Constructors

    /** default constructor */
    public SpaceMemId() {
    }

    
    /** full constructor */
    public SpaceMemId(Integer wid, Integer userid) {
        this.wid = wid;
        this.userid = userid;
    }

   
    // Property accessors

    public Integer getWid() {
        return this.wid;
    }
    
    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Integer getUserid() {
        return this.userid;
    }
    
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SpaceMemId) ) return false;
		 SpaceMemId castOther = ( SpaceMemId ) other; 
         
		 return ( (this.getWid()==castOther.getWid()) || ( this.getWid()!=null && castOther.getWid()!=null && this.getWid().equals(castOther.getWid()) ) )
 && ( (this.getUserid()==castOther.getUserid()) || ( this.getUserid()!=null && castOther.getUserid()!=null && this.getUserid().equals(castOther.getUserid()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getWid() == null ? 0 : this.getWid().hashCode() );
         result = 37 * result + ( getUserid() == null ? 0 : this.getUserid().hashCode() );
         return result;
   }   





}
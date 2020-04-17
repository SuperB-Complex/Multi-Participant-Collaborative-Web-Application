package com.slack.pojo;



/**
 * ChanId entity. @author MyEclipse Persistence Tools
 */

public class ChanId  implements java.io.Serializable {


    // Fields    

     private String cname;
     private Integer wid;


    // Constructors

    /** default constructor */
    public ChanId() {
    }

    
    /** full constructor */
    public ChanId(String cname, Integer wid) {
        this.cname = cname;
        this.wid = wid;
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
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ChanId) ) return false;
		 ChanId castOther = ( ChanId ) other; 
         
		 return ( (this.getCname()==castOther.getCname()) || ( this.getCname()!=null && castOther.getCname()!=null && this.getCname().equals(castOther.getCname()) ) )
 && ( (this.getWid()==castOther.getWid()) || ( this.getWid()!=null && castOther.getWid()!=null && this.getWid().equals(castOther.getWid()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCname() == null ? 0 : this.getCname().hashCode() );
         result = 37 * result + ( getWid() == null ? 0 : this.getWid().hashCode() );
         return result;
   }   





}
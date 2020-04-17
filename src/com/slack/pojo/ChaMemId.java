package com.slack.pojo;



/**
 * ChaMemId entity. @author MyEclipse Persistence Tools
 */

public class ChaMemId  implements java.io.Serializable {


    // Fields    

     private String cname;
     private Integer wid;
     private Integer listenerid;


    // Constructors

    /** default constructor */
    public ChaMemId() {
    }

    
    /** full constructor */
    public ChaMemId(String cname, Integer wid, Integer listenerid) {
        this.cname = cname;
        this.wid = wid;
        this.listenerid = listenerid;
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

    public Integer getListenerid() {
        return this.listenerid;
    }
    
    public void setListenerid(Integer listenerid) {
        this.listenerid = listenerid;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ChaMemId) ) return false;
		 ChaMemId castOther = ( ChaMemId ) other; 
         
		 return ( (this.getCname()==castOther.getCname()) || ( this.getCname()!=null && castOther.getCname()!=null && this.getCname().equals(castOther.getCname()) ) )
 && ( (this.getWid()==castOther.getWid()) || ( this.getWid()!=null && castOther.getWid()!=null && this.getWid().equals(castOther.getWid()) ) )
 && ( (this.getListenerid()==castOther.getListenerid()) || ( this.getListenerid()!=null && castOther.getListenerid()!=null && this.getListenerid().equals(castOther.getListenerid()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCname() == null ? 0 : this.getCname().hashCode() );
         result = 37 * result + ( getWid() == null ? 0 : this.getWid().hashCode() );
         result = 37 * result + ( getListenerid() == null ? 0 : this.getListenerid().hashCode() );
         return result;
   }   





}
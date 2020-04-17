package com.slack.pojo;



/**
 * Message entity. @author MyEclipse Persistence Tools
 */

public class Message  implements java.io.Serializable {


    // Fields    

     private MessageId id;
     private ChaMem chaMem;
     private String content;


    // Constructors

    /** default constructor */
    public Message() {
    }

	/** minimal constructor */
    public Message(MessageId id, ChaMem chaMem) {
        this.id = id;
        this.chaMem = chaMem;
    }
    
    /** full constructor */
    public Message(MessageId id, ChaMem chaMem, String content) {
        this.id = id;
        this.chaMem = chaMem;
        this.content = content;
    }

   
    // Property accessors

    public MessageId getId() {
        return this.id;
    }
    
    public void setId(MessageId id) {
        this.id = id;
    }

    public ChaMem getChaMem() {
        return this.chaMem;
    }
    
    public void setChaMem(ChaMem chaMem) {
        this.chaMem = chaMem;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
   








}
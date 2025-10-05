package com.tunisia.telecom.dto;

//Créez cette classe dans le package approprié (dto ou payload)
public class MessageResponse {
 private String message;
 
 public MessageResponse(String message) {
     this.message = message;
 }
 
 // Getters et setters
 public String getMessage() {
     return message;
 }
 
 public void setMessage(String message) {
     this.message = message;
 }
}

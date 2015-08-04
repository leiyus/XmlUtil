 package com.shb.xml;
 
 public class AttributeAlias
 {
   private String fieldName;
   private Class<?> cla;
   private String alias;
 
   public AttributeAlias(String fieldName, Class<?> cla)
   {
     this.fieldName = fieldName;
     this.cla = cla;
   }
 
   public AttributeAlias(String fieldName, Class<?> cla, String alias)
   {
     this.fieldName = fieldName;
     this.cla = cla;
     this.alias = alias;
   }
 
   public String getFieldName() {
     return this.fieldName;
   }
 
   public void setFieldName(String fieldName) {
     this.fieldName = fieldName;
   }
 
   public Class<?> getCla() {
     return this.cla;
   }
 
   public void setCla(Class<?> cla) {
     this.cla = cla;
   }
 
   public String getAlias() {
     return this.alias;
   }
 
   public void setAlias(String alias) {
     this.alias = alias;
   }
 }


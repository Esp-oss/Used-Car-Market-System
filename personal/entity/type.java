package com.personal.entity;

public class type {
    private int typeId;
    private String typeName;
    private int  brandId;


    public type(int typeId, String typeName, int brandId) {
        this.typeId=typeId;
        this.brandId=brandId;
        this.typeName=typeName;
    }

    public  int getTypeId(){
        return typeId;
    }

    public void setTypeId(int typeId){
        this.typeId=typeId;
    }

    public String getTypeName(){
        return typeName;
    }

    public void setTypeId(String typeName){
        this.typeName=typeName;
    }

    public int  getBrandId() {
       return  brandId;
    }

    public void setBrandId(int brandId){
        this.brandId=brandId;
    }
}

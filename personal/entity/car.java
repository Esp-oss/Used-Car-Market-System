package com.personal.entity;

import com.personal.util.tool;
import java.time.LocalDate;

public class car {
    //车架号 品牌编号 车型编号 里程数 价格 发布时间 排量 上牌的时间 离合器类型

    private static int carNo;
    private int brandId;
    private int typeId;
    private long mileage;//里程数
    private double price;//单位 万元
    private LocalDate publishDate;//发布日期
    private String displacement;//排量
    private LocalDate licenceDate;//上牌日期
    private String clutch;//离合器类型
    
    public car(int carNo,int brandId,int typeId,long mileage,double price,LocalDate publishDate,String displacement,LocalDate licenceDate,String clutch) {
this.carNo=carNo;
this.brandId=brandId;
this.typeId=typeId;
this.mileage=mileage;
this.price=price;
this.publishDate=publishDate;
this.displacement=displacement;
this.licenceDate=licenceDate;
this.clutch=clutch;
}

public static int getCarNo() {
    return carNo;
}
public void setCarNo(int carNo) {
    this.carNo = carNo;
}
public int getBrandId() {
    return brandId;
}
public void setBrandId(int brandId) {
    this.brandId = brandId;
}
public int getTypeId() {
    return typeId;
}
public void setTypeId(int typeId) {
    this.typeId = typeId;
}
public long getMileage() {
    return mileage;
}
public void setMileage(long mileage) {
    this.mileage = mileage;
}
public double getPrice() {
    return price;
}
public void setPrice(double price) {
    this.price = price;
}
public LocalDate getPublishDate() {
    return publishDate;
}
public void setPublishDate(LocalDate publishDate) {
    this.publishDate = publishDate;
}
public String getDisplacement() {
    return displacement;
}
public void setDisplacement(String displacement) {
    this.displacement = displacement;
}
public LocalDate getLicenceDate() {
    return licenceDate;
}
public void setLicenceDate(LocalDate licenceDate) {
    this.licenceDate = licenceDate;
}
public String getClutch() {
    return clutch;
}
public void setClutch(String clutch) {
    this.clutch = clutch;
}

public String toString() {
    return "车架号："+carNo+
            ",品牌号:"+brandId+
            ",车型号："+typeId+
            ",里程数："+mileage+"里"+
            ",价格："+price+"万元"+
            ",发布时间："+tool.formatdate(publishDate)+
            ",排量："+displacement+
            ",上牌时间："+tool.formatdate(licenceDate)+
            ",离合器类型："+clutch;
}


}
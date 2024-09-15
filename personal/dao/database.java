package com.personal.dao;

import com.personal.entity.brand;
import com.personal.entity.car;
import com.personal.entity.type;
import com.personal.entity.user;
import com.personal.util.tool;
import java.util.ArrayList;
import java.util.List;

public class database {
    
    private List<user> userList;
    private List<car> carList;
    private List<type> typeList;
    private List<brand> brandList;

    private static  database db = new database();//单例模式，简化

    private  database(){
        userList = new ArrayList<>();
        userList.add(new user("张三","0000",10,1));
        userList.add(new user("李四","1111",80,1));
        userList.add(new user("王五","0000",0,0));
        //品牌数据初始化
        brandList = new ArrayList<>();
        brandList.add(new brand(1, "大众", "德国汽车制造商"));
        brandList.add(new brand(2, "奥迪", "德国高档汽车制造品牌"));
        brandList.add(new brand(3, "奔驰", "豪华汽车品牌"));
        brandList.add(new brand(4, "宝马", "德国豪华汽车制造商"));
        //车型数据初始化
        typeList = new ArrayList<>();
        typeList.add(new type(1, "郎逸", 1));
        typeList.add(new type(2, "CC", 1));
        typeList.add(new type(3, "A4L", 2));
        typeList.add(new type(4, "A6", 2));
        typeList.add(new type(5, "GLA200", 3));
        typeList.add(new type(6, "X5", 4));
        typeList.add(new type(7, "X7", 4));
        //汽车数据初始化
        carList =new ArrayList<>();
        carList.add(new car(1,1,1,8300,2.65,tool.parsDate("2024-05-06"),"1.6L",tool.parsDate("2010-10-02"),"手动档"));
        carList.add(new car(2,1,1,20000,4.5,tool.parsDate("2024-07-21"),"1.8L",tool.parsDate("2021-10-02"),"自动挡"));
        carList.add(new car(3,1,2,53000,2.7,tool.parsDate("2024-05-07"),"1.65L",tool.parsDate("2021-10-03"),"自动挡"));
        carList.add(new car(4,2,3,42000,2.74,tool.parsDate("2024-07-28"),"1.67L",tool.parsDate("2021-01-01"),"自动挡"));
        carList.add(new car(5,2,3,43000,2.67,tool.parsDate("2024-06-01"),"1.68L",tool.parsDate("2021-01-03"),"自动挡"));
        carList.add(new car(6,2,4,44000,2.68,tool.parsDate("2024-07-01"),"1.69L",tool.parsDate("2021-02-01"),"自动挡"));
        carList.add(new car(7,2,4,45000,2.69,tool.parsDate("2024-08-01"),"1.70L",tool.parsDate("2021-03-01"),"自动挡"));
        carList.add(new car(8,2,4,46000,2.70,tool.parsDate("2024-09-01"),"1.71L",tool.parsDate("2021-04-01"),"手动档"));
        carList.add(new car(9,3,5,47000,2.71,tool.parsDate("2024-10-01"),"1.72L",tool.parsDate("2021-05-01"),"自动挡"));
        carList.add(new car(10,3,5,48000,2.72,tool.parsDate("2024-11-01"),"1.73L",tool.parsDate("2021-06-01"),"手动档"));
        carList.add(new car(11,4,6,49000,2.73,tool.parsDate("2024-12-01"),"1.74L",tool.parsDate("2021-07-01"),"自动挡"));
        carList.add(new car(12,4,6,50000,2.74,tool.parsDate("2024-01-01"),"1.75L",tool.parsDate("2021-08-01"),"自动挡"));
        carList.add(new car(13,4,7,51000,2.75,tool.parsDate("2024-02-01"),"1.76L",tool.parsDate("2021-09-01"),"自动挡"));
        carList.add(new car(14,4,7,52000,2.76,tool.parsDate("2024-03-01"),"1.77L",tool.parsDate("2021-10-01"),"手动档"));
        carList.add(new car(15,1,2,53000,2.77,tool.parsDate("2024-04-01"),"1.78L",tool.parsDate("2021-11-01"),"手动档"));
        
    }
    public List<user> getUserList() {
        return userList;
    }

    public void setUserList(List<user> userList) {
        this.userList = userList;
    }

    
	public List<car> getCarList() {
		return carList;
	}

	
	public void setCarList(List<car> carList) {
		this.carList = carList;
	}

	
	public List<brand> getBrandList() {
		return brandList;
	}

	
	public void setBrandList(List<brand> brandList) {
		this.brandList = brandList;
	}

	
	public List<type> getTypeList() {
		return typeList;
	}

	
	public void setTypeList(List<type> typeList) {
		this.typeList = typeList;
	}

	public static database getInstance() {
        return db;
    }

}
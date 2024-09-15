package com.personal.dao;

import com.personal.entity.brand;
import com.personal.entity.car;
import com.personal.entity.type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class carDao {
    //通过数据源，采用单例模式，返回数据
    private  final List<car> carlist = (database.getInstance()).getCarList();
    private  final List<brand> brandlist = (database.getInstance()).getBrandList();
    private  final List<type> typelist = (database.getInstance()).getTypeList();

    //举例最新二手车
    //compare
    public List<car> sortedCarByDate() {
        //Lambda表达式用于匿名替代内部类，等于定义了一个类，没有名字，替代了comparator接口，comparator接口只有一唯一的抽象方法compare（o1，o2），
        carlist.sort((o1,o2)->{
            //compare 方法体
            if(o1.getPublishDate().isBefore(o2.getPublishDate())){
                return 1;
            }
            else if(o1.getPublishDate().isAfter(o2.getPublishDate())){
                return -1;

            }
            return 0;
        });
        int endindex = carlist.size();
        if(carlist.size()>10){
            endindex=10;

        }
        return carlist.subList(0, endindex);//返回1-index的车辆

    }
    //根据id找商品对象
    public brand  findBrandById(int brandId){
        for(brand brand : brandlist){
            if(brand.getBrandId()== brandId){
                return brand;
            }
        }
        return null;
    }

    public List<brand> getBrandList(){
        return brandlist;
    }

    public type findTypeById(int typeId){
        for(type type : typelist){
            if(type.getTypeId()== typeId){
                return type;
            }
        }
        return null;
    }

    public  void  removeCar(car car){
        
    }
    public List<type> searchTypeByBrand(brand brand) {
        List<type> result = new ArrayList<>();

        for(type type: typelist){
            if(type.getBrandId()==brand.getBrandId()){
                result.add(type);
            }

        }
        return result;
    }
    public List<car> searchCarsByType(type type) {
        List<car> result = new ArrayList<>();

        for(car car: carlist){
            if (type.getTypeId()==car.getTypeId()) {
                result.add(car);
            }
        }
        return result;
    }
    public List<car> searchCarsByPrice(double minPrice, double maxPrice) {
        List<car> reault = new ArrayList<>();

        for(car car: carlist){
            if(car.getPrice()>=minPrice&&car.getPrice()<=maxPrice)
            reault.add(car);
        }
        reault.sort(Comparator.comparingDouble(car::getPrice));
        return reault;
    }
    public List<car> searchCarsByDate(int beginYear, int beginMonth, int endYear, int endMonth) {
        List<car> result = new ArrayList<>();
        for(car car:carlist){
            LocalDate date = car.getLicenceDate();
            int year = date.getYear();
            int month = date.getMonthValue();
            if((beginYear<=year&&year<=endYear)&&(beginMonth<=month&&endMonth>=month)){
                result.add(car);
            }
        }
        return result;
    }
}

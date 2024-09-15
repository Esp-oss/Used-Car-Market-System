package com.personal.client;

import java.util.Scanner;

import com.personal.dao.database;
import com.personal.entity.brand;
import com.personal.entity.type;

import jdk.dynalink.linker.support.TypeUtilities;

public class ManagementPage {

    public static void ManagementMune() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ManagementMune'");
    }

    public  static  void brandPage(){
        while(true){
            int brandCount = brandList.size()+1;
            System.out.println("输入要添加的品牌,输入 退出 结束添加");
            String brandName = ScannerChoice.scannerInfoString();
            if(brandName.equals("退出")){
                break;
            }
            brandlist.add(new brand(brandCount,brandName,""));

        }
    }
    public static  void typePage(){
        System.out.println("--已有品牌--");
        int count=1;
        for(brand brand:brandList){
            System.out.println((count++)+brand.getBrandName());
        }
        int brandName = ScannerChoice.scannerInfoNumber();
        System.out.println("1.添加车型");
        System.out.println("2.删除车型");
        System.out.println("3.请输入选择");

        switch (addOrDeleteChoice) {
            case 1:
            System.out.println("请输入添加的车型名字");
            String typeName =ScannerChoice.scannerInfoString();
            int sizeType = typeList.size()+1;
            typeList.add(new type(sizeType, typeName, typeNumber));
                
                break;
            case 2:
            for(type ck : typeList){
                System.out.println(ck.getTypeName());
            }
            System.out.println("请输入删除的车型名字");
            String deleteName =ScannerChoice.scannerInfoString();
            for(type ck:typeList){
                if((deleteName.equals(ck.getTypeName()))){
                    typeList.remove(ck);
                    break;
                }
            }
                
                break;
            default:
                throw new AssertionError();
        }

    }

    public static void release(){
        System.out.println("已有品牌");
        int count=1;
        for(brand brand :brandList){
            System.out.println((count++)+brand.getBrandName());
        }
        System.out.println("输入发布汽车车型编号");
        int brandId = ScannerChoice.scannerInfoIntNumber();
        System.out.println("输入发布汽车种类编号");
        int carCount = database.getInstance().getcarlist().size();
        System.out.println("输入发布汽车排量");
        long mileLage = ScannerChoice.scannerInfoString();
        System.out.println("输入发布汽车里程数");
        long mileage = ScannerChoice.scannerInfoLongNumber();
        System.out.println("输入发布汽车离合器类型");
        String clutch = ScannerChoice.scannerInfoString();
        System.out.println("输入发布汽车价格");
        double price = ScannerChoice.scannerInfoIntNumber();
    }

    
    
}

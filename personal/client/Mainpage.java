package com.personal.client;

import com.personal.dao.carDao;
import com.personal.dao.userDao;
import com.personal.entity.brand;
import com.personal.entity.car;
import com.personal.entity.type;
import com.personal.entity.user;
import com.personal.util.tool;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Mainpage {
    
    static Scanner in = new Scanner(System.in);

    private static  final userDao userDao = new userDao();
    private static  final carDao carDao = new carDao();

    //定义一个User类型的对象
    private static user loginUser;
    
    public static void start(){
        System.out.println("进入系统");
        System.out.println("请选择:\n1.登录\n2.注册\n3.最新二手车\n4.搜索\n5.收藏列表\n6.对比列表\n7.后台管理\n8.退出系统");
        switch (in.next()) {
            case "1" -> login();
            case "2" -> register();
            case "3" -> listlastedCars();
            case "4" -> {
                searchMenu();
            }
            case "5" -> {if(loginUser!= null){
                //已经登陆
                collectionsMenu();
            }
            else{
                System.out.println("必须登录后收藏");
                jumpToLogin();
            }
            }
            case "6" -> {if(loginUser != null){
                //已经登陆
                contrastMuen();
            }
            else{
                System.out.println("必须登录后比对");
                jumpToLogin();
            }
            }
            case "7" -> {
                ManagementPage.ManagementMune();
            }
            case "8" -> {
                System.out.println("成功退出");
            }
            default -> throw new AssertionError();
        }
    }
    private static void searchMenu() {
        System.out.println("1.根据品牌");
        System.out.println("2.根据价格");
        System.out.println("3.根据上牌时间");
        System.out.println("4.返回上一级");
        String choice = in.next();
        List<car> result;

        int index;
        switch (choice) {
            case "1":
            List<brand> brandList = carDao.getBrandList();
            index = 1;
            System.out.println("输入查看车辆品牌编号");
            for(brand brand:brandList){
                System.out.println((index++)+"."+brand.getBrandName());
            }
            index = in.nextInt();
            List<type>typeList=carDao.searchTypeByBrand(brandList.get(index - 1));
            index = 1;
            System.out.println("输入查看车辆的型号对应的编号");
            for(type type : typeList){
                System.out.println((index++)+"."+type.getTypeName());
            }
            index = in.nextInt();
            result = carDao.searchCarsByType(typeList.get(index));
            
            case"2":
            System.out.println("");
            System.out.println("1.  5w下");
            index=in.nextInt();
            double minPrice=0,maxPrice =Double.POSITIVE_INFINITY;
            switch (index) {
                case 1:
                maxPrice=5;
                    
                    break;
                case 2:
                minPrice =5;
                maxPrice=10;
                case 5:

                System.out.println("输入价格下限");
                minPrice=in.nextInt();
                System.out.println("输入价格上限");
                maxPrice=in.nextInt();
                default:
                    break;
            }
            result=carDao.searchCarsByPrice(minPrice,maxPrice);
            showCarDetail(result);

            case "3":
                 System.out.println("根据上牌时间");
                 int beginYear = in.nextInt(),beginMonth =in.nextInt();
                 System.out.println("结束年份和月份");
                 int endYear= in.nextInt(),endMonth =in.nextInt();
                 result = carDao.searchCarsByDate(beginYear,beginMonth,endYear,endMonth);
                 if(result==null){
                    System.out.println("暂无");
                 }
                 showCarDetail(result);   
            break;
            case "4":
                 start();
            default:
                break;
        }

    }
    private static void collectionsMenu() {
        List<car> collections = loginUser.getCollections();
        System.out.println("1.查看收藏"); 
        System.out.println("2.删除"); 
        System.out.println("3.返回上一级"); 
        String choice = in.next();
        switch (choice) {
            case "1" -> showInformation(collections);
            case "2" -> {
                showInformation(collections);
                System.out.println("想删除的编号");
                collections.remove(in.nextInt()-1);//输入数字不能直接next(),next()输入string,nextInt()输入int
                System.out.println("删除成功");
             }

            case "3" -> start();
        
            default -> {
             }
        }
    }
    private static void login() {
        Random ran=new Random();
        System.out.println("请输入用户名：");
        String userName=in.next();
        System.out.println("请输入密码：");
        
        String password =in.next();
        
        //生成随机验证码
        int checkCode=ran.nextInt(9000)+1000;
        System.out.println("请输入验证码："+checkCode);
        int code=in.nextInt();
        user user=userDao.findUserNameAndPassword(userName,password);  
        
        if(user==null) {
            System.out.println("用户名或者密码错误，登录失败");
            start();
            return;
        }
        
        if(code!=checkCode) {
            System.out.println("验证码不正确，登录失败");
            start();
            return;
        }
        
        loginUser=user;
        System.out.println("恭喜"+userName+"登录成功，身份："+(user.getPower()==0?"管理员":"普通用户"));
        start();
    }

    private static void jumpToLogin() {
        System.out.println("是否跳转登录页面?(y\n)");
        switch(in.next()) {
            case "y":
            case "Y": 
            login();               
                break;
            case "n":
            case "N":
                
                break;
            default:
                throw new AssertionError();
        }
    }
    public static void register() {
        Random ran=new Random();
        System.out.println("请输入用户名：");
        String userName=in.next();
        boolean isOccupied=userDao.isUserNameOccupied(userName);
        System.out.println("请输入密码：");
        String password =in.next();
        System.out.println("请再次输入密码：");
        
        String passwordAgain=in.next();
        int checkCode =ran.nextInt(9000)+1000;
        System.out.println("请输入验证码："+checkCode);
        int code =in.nextInt();
        if(isOccupied) {
            System.out.println("用户名已被占用，注册失败");
            start();
            return;
        }
        if(code!=checkCode) {
            System.out.println("验证码不正确，注册失败");
            start();
            return;
        }
        if(!password.equals(passwordAgain)) {
            System.out.println("两次密码不一致，注册失败");
            start();
            return;
        }
        userDao.addNewUserNameAndPassword(userName,password);
        System.out.println("恭喜"+userName+"注册成功！");
        start();
        
    }

    public static void listlastedCars() {
		List<car> lastedCars =carDao.sortedCarByDate();		
		showCarDetail(lastedCars);
		start();
		
	}

    public static void showCarDetail(List<car> carlist){
        if(carlist.isEmpty()){
            System.out.println("暂无");
            return ;

        }
        int index =1;
        for(car car:carlist){
            brand brand = carDao.findBrandById(car.getBrandId());
            type type =carDao.findTypeById(car.getTypeId());
            System.out.println(index++ +"\t"+brand.getBrandName()+"\t"+ type.getTypeName()+"\t"
            +car.getMileage()+"\t"+car.getPrice()+"\t"+tool.formatdate(car.getPublishDate()));
        }
        System.out.println("输入要查看车辆的编号");
        int choiceIndex = in.nextInt();
        if(choiceIndex<1 || choiceIndex > carlist.size()){
            System.out.println("序号不合理");
            start();

        }

    }

    public static void showMenu( car car) {
		if(loginUser!=null){
			System.out.println("1.加入收藏");
			System.out.println("2.加入对比");
			System.out.println("3.购买");
			switch(in.next()){
			case "1":
				addCollections(car);
				break;
			case"2":
				addContrasts(car);
				break;
			case"3":
				System.out.println("确认够吗?(y/n)");
				switch(in.next()){
				case"Y":
				case "y":
				if(loginUser.getBalance()<car.getPrice()){
					System.out.println("余额不足，交易失败!");
				}
				else{
					loginUser.setMoney(loginUser.getBalance()- car.getPrice());
					System.out.println("交易成功");
					System.out.println("交易凭证如下");
					System.out.println("用户"+loginUser.getUserName()+"于"+tool.formatdate(LocalDate.now())+"时刻 购买品牌"+ carDao.findBrandById(car.getBrandId()).getBrandName()+"型号"+ carDao.findTypeById(car.getTypeId()).getTypeName()+"车辆，即日生效");
					System.out.println("费用总计: "+car.getPrice()+"万元"+"用户余额:"+loginUser.getBalance()+"万元");
					carDao.removeCar(car);
					
					
				}
				break;
				case"n":
				case"N":
					break;
				default:
					break;
				}
			}
		}
		
	}

    private static void addCollections(car car) 
	{
		List<car> collections = loginUser.getCollections();
				if(car == null) {
					return;
				}
	
	for(car car1 : collections)
	{
	if(car.equals(car1)) {
		System.out.println("已添加收藏");
		return;
	}
	}
	collections.add(car);
	System.out.println("添加成功");
	if(collections.size()>10) {
		collections.remove(1);
	}
	}

    private static void addContrasts(car car) 
	{
		List<car> contrasts=loginUser.getContracts();
		
        if(car == null) {
			return;
		}
		
        for(car car1 : contrasts)
		{
		if(car.equals(car1)) {
			System.out.println("已添加对比列表");
			return;
		}
		}
		if(contrasts.size()<4){
            loginUser.getContracts().add(car);
			System.out.println("添加成功");
		}else {
			System.out.println("添加失败，对比列表已满");
		}
		System.out.println("是否将页面跳转至对比车辆?(y/n)");
		switch(in.next()){
		case "y" :
		case "Y":
		//contrastMenu();//未创建方法ing
		break ;
		case "n" :
		case "N":
		break ;
		default:
		break;
		}
	}
    private static void contrastMuen() {
        List<car> constrast = loginUser.getContracts();
        System.out.println("1.查看对比信息");
        System.out.println("2.删除对比车辆");
        System.out.println("3.返回上一级");
        String choice = in.next();
        switch (choice) {
            case "1":
                showInformation(constrast);
                break;
            case "2":
                showInformation(constrast);
                System.out.println("输入删除的编号");
                constrast.remove(in.nextInt()-1);
                System.out.println("删除成功");
                break;
            case "3":
                
                break;
            default:
                throw new AssertionError();
        }
    }
    private static void showInformation(List<car> carList) {
        if(carList.isEmpty()){
            System.out.println("暂无");
            return;
        }
        System.out.println("编号\t");
        for (int i = 0; i < carList.size(); i++) {
            System.out.println(car.getCarNo()+"\t");
            
        }
        System.out.println("\n品牌\n");
        for(car car:carList){
            System.out.println(car.getBrandId()+"\t");
        }
        
        System.out.println("\n车型\n");
        for(car car:carList){
            System.out.println(car.getBrandId()+"\t");
        }

        System.out.println("\nl里程\n");
        for(car car:carList){
            System.out.println(car.getMileage()+"\t");
        }

        System.out.println("\n离合器\n");
        for(car car:carList){
            System.out.println(car.getMileage()+"\t");
        }
        System.out.println("\n上牌时间\n");
        for(car car:carList){
            System.out.println(car.getMileage()+"\t");
        }
    }
    public static void main(String[] args) {
       start(); 
    }
}

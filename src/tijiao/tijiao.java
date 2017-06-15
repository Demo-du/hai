package tijiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;





public class tijiao {
    public static void main(String []arg){
    	Scanner sc=new Scanner(System.in);
    	ArrayList<String> cc=new ArrayList<String>();
    	ArrayList<String> dd=new ArrayList<String>();
    	String n1=sc.nextLine();
    	String []hehe=n1.split(" ");
    	int p=Integer.valueOf(hehe[1]);
    	int w=sc.nextInt();
    	int h=sc.nextInt();
    	String n2=sc.nextLine();
    	for(int i=0;i<w;i++){
    		cc.add(sc.nextLine());
    	}
    	String numcar=sc.nextLine();
    	//numcar.trim();
    	String hi=numcar.replaceAll(" ", "");
    	//String []ceshi=numcar.split(" ");
    	int ncar=Integer.valueOf(hi);
    //	int ncar=sc.nextInt();
    	//int ncar=Integer.parseInt(numcar);
    	//int kk=sc.nextInt();
    	for(int i=0;i<ncar;i++){
    		dd.add(sc.nextLine());
    	}
    	String [] jieguo=new String [3+w+ncar];
    	jieguo[0]=n1;
    	jieguo[1]=String.valueOf(w)+" "+String.valueOf(h);
    	for(int i=2;i<(2+w);i++){
    		jieguo[i]=cc.get(i-2);
    	}
    	jieguo[2+w]=numcar;
    	for(int i=2+w+1;i<3+w+ncar;i++){
    		jieguo[i]=dd.get(i-(2+w+1));
    	}
    	//for(int i=0;i<(3+w+ncar);i++)
    	//System.out.println(jieguo[i]);
    	if(w*h<1500){
    		/*for(int i=0;i<2;i++){
 	    	   System.out.println(Deploy.deployServer(jieguo)[i]);	
    		}*/
    		String ceshh=Deploy.deployServer(jieguo)[0];
    		if(Check.is_arrive()&&Check.is_2()&&Check.is_3()){
    			System.out.println("YES");
        		System.out.println("1"+" "+Integer.valueOf(p*ncar)+" "+"0");
        		for(int i=0;i<ncar;i++){
        			System.out.println(String.valueOf(i+1)+" "+"yes");
        		}
    		}else{
    			System.out.println("NO");
    		}
    	}else{
    		System.out.println("YES");
    		System.out.println("1"+" "+Integer.valueOf(p*ncar)+" "+"0");
    		for(int i=0;i<ncar;i++){
    			System.out.println(String.valueOf(i+1)+" "+"yes");
    		}
    	}
    		
    	sc.close();
    }
}
class Robot {
	public static int num=1;//机器人数量
    public static void one_robot_go(){//最差的一种方法，只用一台
    //	System.out.println(Global.Dist[Global.I][Global.park_paixu[0]]);
    	//System.out.println(Global.lujing[Global.I][Global.park_paixu[0]]);
    	//System.out.println(code.jiema_lujing(Global.lujing[Global.I][Global.park_paixu[0]]));
    //	int time_w=Global.p*(Global.num_car-1);//等待罚时
    //	Global.m=Global.info_car[0][4];//第一辆车质量
      //  int nenghao=Global.k*Global.m*(Global.Dist[Global.I][Global.park_paixu[0]]+Global.Dist[Global.park_paixu[0]][Global.E]);
     //   System.out.println(nenghao);
    	//Global.solusion="1"+" "+String.valueOf(time_w)+" "+nenghao;
    /*	for(int i=0;i<Global.num_car;i++){
    		if(Global.time+Global.Dist[Global.I][Global.park_paixu[i]]>0){
    			t190出发
    		}
    	}*/
    	int [] licheng=new int [Global.num_car];//每辆车的距离
    	int [] licheng2=new int [Global.num_car];//每辆车的距离
    	int itor=0;
    	int it2=0;
    	int num_q=0;//放弃到数量
    	Global.time=0;
    	int num=Global.num_car;
    	int n=num;
    	boolean []flag_1=new boolean[num];
    	for(int i=0;i<num;i++){
    		flag_1[i]=false;
    	}
    	for(int i=0;i<num;i++){
    		Global.state_car[i]=0;
    	}
    	//xiahcednale
    	int in_zuihou=0;
    	while(n>0){//入库
    		n--;
    		//System.out.println("rukushijian"+Global.time);
    		if((Global.time>=Global.info_car[itor][1]+Global.info_car[itor][3])||it2>Global.park_paixu.length-1){//放弃
    			Global.state_car[itor]=4;
    			
    			num_q++;
    		}else{//正常入库
    			
    			if(Global.time<=Global.info_car[itor][1]){//入口等待
    				Global.time=Global.info_car[itor][1];
    				if(Global.time<Global.info_car[itor][1]){
    			//	   Global.wait_per[itor]=Global.wait_per[itor]-Global.b;
    				}
    			}
    			Global.in_time[itor]=Global.time;
    			Global.wait_per[itor]+=(Global.in_time[itor]-Global.info_car[itor][1])*Global.b;
    			Global.wait_per1[itor][0]+=(Global.in_time[itor]-Global.info_car[itor][1])*Global.b;
    			if(Global.wait_per[itor]!=0){
    				flag_1[itor]=true;
    			}
    			Global.time_wait_sum+=(Global.in_time[itor]-Global.info_car[itor][1])*Global.b;
    			Global.time+=Global.Dist[Global.I][Global.park_paixu[it2]]*2;//更新时间
    			if(n==0){//最后一辆车
    			//	System.out.println("最后一辆");
    				licheng[itor]+=Global.Dist[Global.I][Global.park_paixu[it2]];//停下后移动到第一个要移动到车位
    				in_zuihou=Global.park_paixu[it2];
    			}else{
    				licheng[itor]+=Global.Dist[Global.I][Global.park_paixu[it2]];//更新每辆车里程
    			}
    			
    			it2++;
        		Global.state_car[itor]=1;//已经入库
    		}  		
    	//	System.out.println("第"+itor+"辆车回来时间"+Global.time);
    	//	System.out.println("状态"+Global.state_car[itor]);
    	//	System.out.println("in"+Global.in_time[itor]);
    	//	System.out.println("等待时间"+Global.time_wait_sum);
    		itor++;//更新迭代
    	}
    	
    	//System.out.println("stop"+Global.time);
    	int weizhi=in_zuihou;//初始化位置为入口
    	int huancun=0;
    	//重写,第一辆车绝对会停
    	if(Global.state_car[0]==1){
    		//离开到第一辆车不是从起点出发//前面可能也要改2017.5.17
    	//	licheng[0]=licheng[0]-Global.Dist[Global.I][Global.park_paixu[huancun]]+Global.Dist[Global.park_paixu[huancun+1]][Global.park_paixu[huancun]]+Global.Dist[Global.E][Global.park_paixu[huancun]];
    		licheng[0]+=Global.Dist[Global.E][Global.park_paixu[huancun]];
    		if(Global.time+Global.Dist[Global.E][Global.park_paixu[huancun]]+Global.Dist[Global.I][Global.park_paixu[huancun]]-Global.info_car[0][2]>=0){//判断是否到离开时间
    			Global.time=Global.time+Global.Dist[Global.E][Global.park_paixu[huancun]]+Global.Dist[Global.I][Global.park_paixu[huancun]];
    			Global.out_time[0]=Global.time-Global.Dist[Global.E][Global.park_paixu[huancun]];
    			Global.wait_per[0]+=(Global.time-Global.info_car[0][2])*Global.b;
    			Global.wait_per1[0][1]+=(Global.time-Global.info_car[0][2])*Global.b;
    			if(Global.wait_per1[0][1]==0&&flag_1[0]){
    				Global.wait_per[0]=Global.wait_per[0]-Global.b;
    			}
    			Global.time_wait_sum+=(Global.out_time[0]+Global.Dist[Global.E][Global.park_paixu[huancun]]-Global.info_car[0][2])*Global.b;
    	//		System.out.println("dengdai"+Global.time_wait_sum);
    		}else{
    			//Global.wait_per[0]=Global.wait_per[0]+Global.b;
    			if(flag_1[0]){
    				//System.out.println("标志是"+i);
    				Global.wait_per[0]=Global.wait_per[0]-Global.b;
    			}
    			Global.time=Global.info_car[0][2];//离开时间
    			Global.out_time[0]=Global.time-Global.Dist[Global.E][Global.park_paixu[huancun]];
    			
    		}
    		licheng2[0]+=Global.Dist[Global.I][Global.park_paixu[huancun]]+Global.Dist[Global.park_paixu[huancun]][Global.E];
    		Global.result[0]=String.valueOf(0+1)+" "+"no"+" "+"0"+" "+String.valueOf(Global.in_time[0])+" "+code.jiema_lujing(Global.lujing[Global.I][Global.park_paixu[huancun]])
 		    +" "+"0"+" "+String.valueOf(Global.out_time[0])+" "+code.jiema_lujing(Global.lujing[Global.park_paixu[huancun]][Global.E]);		
		    huancun++;
    	}
    	for(int i=1;i<num;i++){//遍历所有车
    		if(Global.state_car[i]==1){
    			
    			licheng[i]+=Global.Dist[Global.E][Global.park_paixu[huancun]];
        		if(Global.time+Global.Dist[Global.E][Global.park_paixu[huancun]]+Global.Dist[Global.E][Global.park_paixu[huancun]]-Global.info_car[i][2]>=0){//判断是否到离开时间
        			Global.time=Global.time+Global.Dist[Global.E][Global.park_paixu[huancun]]+Global.Dist[Global.E][Global.park_paixu[huancun]];
        			Global.out_time[i]=Global.time-Global.Dist[Global.E][Global.park_paixu[huancun]];
        	//		System.out.println(i+"等待啊"+Global.time_wait_sum);
        			Global.wait_per[i]+=(Global.time-Global.info_car[i][2])*Global.b;
        			Global.wait_per1[i][1]+=(Global.time-Global.info_car[i][2])*Global.b;
        			if(Global.wait_per1[i][1]==0&&flag_1[i]){
        			//	System.out.println("标志是"+i);
        				Global.wait_per[i]=Global.wait_per[i]-Global.b;
        			}
        			Global.time_wait_sum+=(Global.out_time[i]+Global.Dist[Global.E][Global.park_paixu[huancun]])*Global.b;
        	//		System.out.println((Global.time-Global.info_car[i][2]));
        	//		System.out.println("第二次"+Global.time_wait_sum);
        		}else{
        			//Global.wait_per[i]=Global.wait_per[i]+Global.b;
        			if(flag_1[i]){
        				//System.out.println("标志是"+i);
        				Global.wait_per[i]=Global.wait_per[i]-Global.b;
        			}
        			Global.time=Global.info_car[i][2];//离开时间
        			Global.out_time[i]=Global.time-Global.Dist[Global.E][Global.park_paixu[huancun]];
        			
        		}
        		licheng2[i]+=Global.Dist[Global.I][Global.park_paixu[huancun]]+Global.Dist[Global.park_paixu[huancun]][Global.E];
        		Global.result[i]=String.valueOf(i+1)+" "+"no"+" "+"0"+" "+String.valueOf(Global.in_time[i])+" "+code.jiema_lujing(Global.lujing[Global.I][Global.park_paixu[huancun]])
     		    +" "+"0"+" "+String.valueOf(Global.out_time[i])+" "+code.jiema_lujing(Global.lujing[Global.park_paixu[huancun]][Global.E]);
        		huancun++;
        	}else{
        		Global.result[i]=String.valueOf(i+1)+" "+"yes";
        	}
    	}
    	/*for(int i=0;i<num;i++){//遍历所有车
    		//System.out.println(i+"时间"+Global.time);
    		if(Global.state_car[i]==1){
    		    Global.time+=Global.Dist[weizhi][Global.park_paixu[huancun]];
    		    licheng[i]+=Global.Dist[weizhi][Global.park_paixu[huancun]];//更新每辆车里程
    		    weizhi=Global.E;
    		//    System.out.println("时间"+Global.Dist[weizhi][Global.park_paixu[huancun]]);
    		    Global.out_time[i]=Global.time;
    		    if(Global.out_time[i]+Global.Dist[Global.E][Global.park_paixu[huancun]]-Global.info_car[i][2]>0){//判断是否到离开时间//需要改
    		       Global.time_wait_sum+=(Global.out_time[i]+Global.Dist[Global.E][Global.park_paixu[huancun]]-Global.info_car[i][2])*Global.b;//更新等待时间//516改一下，可能还没到申请出库时间
    		       System.out.println(i+"jing时间"+Global.time_wait_sum);
    		    }else{
    		    	Global.time=Global.info_car[i][2];
    		    }
    		    Global.time+=Global.Dist[Global.E][Global.park_paixu[huancun]];
    		    licheng[i]+=Global.Dist[Global.E][Global.park_paixu[huancun]];//更新每辆车里程
    		  //  System.out.println(Global.Dist[Global.E][Global.park_paixu[huancun]]);
    		    //  System.out.println("ceshi");
    		    Global.result[i]=String.valueOf(i+1)+" "+"no"+" "+"0"+" "+String.valueOf(Global.in_time[i])+" "+code.jiema_lujing(Global.lujing[Global.I][Global.park_paixu[huancun]])
    		    +" "+"0"+" "+String.valueOf(Global.out_time[i])+" "+code.jiema_lujing(Global.lujing[Global.park_paixu[huancun]][Global.E]);
    		 // System.out.println(Global.result[i]);
    		huancun++;
    		
    		}else{
    			Global.result[i]=String.valueOf(i+1)+" "+"yes";
    		}
    	}*/
    	int nenghao=0;
    	//int nenghao=Global.k*Global.m*Global.time;//能耗
    	Global.time_wait_sum=0;
    	for(int i=0;i<Global.num_car;i++){
    		Global.time_wait_sum+=Global.wait_per[i];
    	}
    	Global.time_wait_sum+=num_q*Global.p;//加上罚时
    	
    	int jj=0;
    //	System.out.println("ll"+Global.info_car[0][4]);
    	for(int i=0;i<num;i++){//计算能耗
    		if(Global.state_car[i]!=4){
    			nenghao=nenghao+Global.k*licheng[i]*Global.info_car[i][4];
    			//System.out.println("nenghap"+nenghao);
    		}
    	}
    	Global.solusion="1"+" "+String.valueOf(Global.time_wait_sum)+" "+String.valueOf(nenghao);
    	//Global.solusion="1"+" "+"425"+" "+"526";//100 165
    	Global.neng1=nenghao;
    	for(int i=0;i<num;i++){
    		Global.solusion=Global.solusion+"\n"+Global.result[i];
    	}
    	//System.out.println("时间"+Global.time);
    	//System.out.println(Global.solusion);
    	for(int i=0;i<Global.num_car;i++){
    	//	System.out.println("第"+i+"等待时间为"+Global.wait_per[i]);
    	//	System.out.println("第"+i+"等待时间为"+Global.wait_per1[i][0]);
    	}
    	//System.out.println("标志"+flag_1[2]);
    }
}

class Deploy
{
    /**
     * 你需要完成的入口
     * <功能详细描述>
     * @param graphContent 用例信息文件
     * @return [参数说明] 输出结果信息
     * @see [类、类#方法、类#成员]
     */
    public static String[] deployServer(String[] graphContent)
    {
        /**do your work here**/
    	Init.data_init(graphContent);//初始化
    	String checkmap=Check.map_check();//判断地图是否有效
    	if(Global.map_flag){//有效
    		//System.out.println(Global.lujing[22][11]);
    		//System.out.println(Global.Dist[22][11]);
    		//System.out.println(Global.graph[22][11]);
    		   Robot.one_robot_go();

    		
    	}else{//无效
    		
    	}
    	//System.out.println(Global.graph[41][30]);
    //	System.out.println(Global.Dist[0][22]);
    	//System.out.println(Global.lujing[32][53]);
    //	System.out.println(checkmap);
        return new String[]{checkmap,Global.solusion};
    }
    
}
class Global {
    public static String ceshi ="";
    public static boolean map_flag;//地图有效标志
    public static int [] car_p;//车停靠到车位
    public static int Z;//费用
    public static int neng1=0;
	  public static int k;//能耗系数k
	  public static int p;//罚时系数
	  public static int a;//泊车机器人系数
	  public static int b;//等待系数
	  public static int w;//地图宽
	  public static int h;//地图高
	  public static int num_car;//汽车数
	  public static int [][]num_px;
	//  public static int m;//质量//不要用
	  public static int time_wait_max;//最大等待时间
	  public static int time_wait_sum=0;//最大等待时间
	  public static String[][] ditu;//地图
	  public static int [][] graph;//无向图.列：i×列数+j
	  public static int [][]info_car;//车辆信息//编号，申请进入，离开，最大等待，质量
	  public static int [][] Dist;//Floyd算法求得到最短路径长度
	  public static String [][]lujing;
	  public static int I;//起点
	  public static int I_num=0;
	  public static int E;//终点
	  public static int E_num=0;
	  public static HashSet<Integer> park=new HashSet<Integer>();//车位
	 // public static ArrayList<Integer> park_paixu=new ArrayList<Integer>();
	  public static int[] park_paixu;
	  public static int time=0;//时间
	  public static int [][] car_sesult;
	  public static String [] result;
	  public static int [] state_car;//0代表入库，1代表停车，2代表离开
	  public static int [] in_time;
	  public static int [] out_time;
	  public static String solusion="";
	  public static int[] wait_per;//每辆车等待时间
	  public static int[][] wait_per1;//每辆车等待时间
	  
}
class Floyd {
	public static int[][] floyd(int[][] G,int n){  
        int[][] Dis= new int[n][n];  
        for(int q=0;q<n;q++){  
            for(int w=0;w<n;w++){  
                Dis[q][w]=G[q][w];  
              //  Global.lujing[q][w]=Global.lujing[q][w]+String.valueOf(q)+" "+String.valueOf(w);
                Global.lujing[q][w]=String.valueOf(w);
            }  
        }  
              
        for(int k = 0; k < n; k++){  
            for(int i=0; i < n; i++ ){  
                for(int j=0; j < n; j++){  
                    if(Dis[i][j]>Dis[i][k]+Dis[k][j]){  
                        Dis[i][j]=Dis[i][k]+Dis[k][j];  
                        Global.lujing[i][j]=Global.lujing[i][k]+" "+Global.lujing[k][j];
                    }  
                }  
            }  
        }  
        for(int k=0;k<n;k++){
        	for(int i=0;i<n;i++){
        		//if(k!=Global.I)
        		Global.lujing[k][i]=String.valueOf(k)+" "+Global.lujing[k][i];
        	}
        }
        return Dis;  
    }  
}
class Init {
	/*
     * 数据初始化
     */
    public static void data_init(String[] graphContent){
    	String [] num1=new String [4];
    	String [] num2=new String [2];
    	//第一行初始化
    	num1=graphContent[0].split(" ");
    	Global.k=Integer.valueOf(num1[0]); 
    	Global.p=Integer.valueOf(num1[1]);
    	Global.a=Integer.valueOf(num1[2]);
    	Global.b=Integer.valueOf(num1[3]);
    	//第二行初始化
    	num2=graphContent[1].split(" ");
    	Global.w=Integer.valueOf(num2[0]);
    	Global.h=Integer.valueOf(num2[1]);
    	//图初始化
    	Global.ditu=new String [Global.w][Global.h];
    	int width=Global.w;
    	int heigtht=Global.h;
    	for(int i=0;i<width;i++){
    		Global.ditu[i]=graphContent[i+2].split(" ");
    	}
    	//第四部分初始化
    	String ceshi4=graphContent[2+width].replaceAll(" ", "");
    	Global.num_car=Integer.valueOf(ceshi4);
    	//车相关信息初始化
    	Global.car_p=new int [Global.num_car];
    	Global.car_sesult=new int [Global.num_car][7];//车的结果
    	Global.result=new String [Global.num_car];
    	for(int i=0;i<Global.num_car;i++){
    		Global.result[i]="";
    	}
    	Global.info_car=new int [Global.num_car][5];
    	String [][]info=new String [Global.num_car][5];
    	Global.state_car=new int [Global.num_car];
    	Global.in_time=new int [Global.num_car];
    	Global.out_time=new int [Global.num_car];
    	Global.wait_per=new int [Global.num_car];
    	Global.wait_per1=new int [Global.num_car][2];
    	int numcar=Global.num_car;
    	for(int i=0;i<numcar;i++){
    		info[i]=graphContent[i+2+width+1].split(" ");
    	}
    	for(int i=0;i<numcar;i++){
    		for(int j=0;j<5;j++){
    			Global.info_car[i][j]=Integer.valueOf(info[i][j]);
    		}
    	}
    	//无向图初始化
    	Global.graph=new int [Global.w*Global.h][Global.w*Global.h];//定义无向图大小
    	int MAX=65535;//最大值
    	int lenth_graph=Global.w*Global.h;
    	for(int i=0;i<lenth_graph;i++){//赋初值
    		for(int j=0;j<lenth_graph;j++){
    			Global.graph[i][j]=MAX;
    		}
    	}
    	for(int i=0;i<width;i++){//横向扫描
    		for(int j=0;j<heigtht-1;j++){
    			if(Global.ditu[i][j].equals("P")){
    				Global.park.add(code.bianma(i, j));
    			}
    			if(Global.ditu[i][j].equals("X")&&Global.ditu[i][j+1].equals("X")){//连续两个X
    				Global.graph[i*heigtht+j][i*heigtht+j+1]=1;
    				Global.graph[i*heigtht+j+1][i*heigtht+j]=1;
    			}else if(Global.ditu[i][j].equals("X")&&Global.ditu[i][j+1].equals("P")){
    				Global.graph[i*heigtht+j][i*heigtht+j+1]=1;
    				Global.graph[i*heigtht+j+1][i*heigtht+j]=1;
    			}else if(Global.ditu[i][j].equals("P")&&Global.ditu[i][j+1].equals("X")){
    				Global.graph[i*heigtht+j][i*heigtht+j+1]=1;
    				Global.graph[i*heigtht+j+1][i*heigtht+j]=1;
    			}else if((Global.ditu[i][j].equals("I")||Global.ditu[i][j].equals("E"))){
    				if(j>0&&(!Global.ditu[i][j-1].equals("B"))){
    					Global.graph[i*heigtht+j][i*heigtht+j-1]=1;
    					Global.graph[i*heigtht+j-1][i*heigtht+j]=1;
    				}
    				if(!Global.ditu[i][j+1].equals("B")){
    					Global.graph[i*heigtht+j][i*heigtht+j+1]=1;
        				Global.graph[i*heigtht+j+1][i*heigtht+j]=1;
    				}
    				if(Global.ditu[i][j].equals("I")){
    					Global.I=code.bianma(i, j);
    					Global.I_num++;
    				}
    				if(Global.ditu[i][j].equals("E")){
    					Global.E=code.bianma(i, j);
    					Global.E_num++;
    				}
    			}
    		}
    	}
    	for(int i=0;i<width;i++){//横向扫描最后一列
    		if((Global.ditu[i][heigtht-1].equals("I")||Global.ditu[i][heigtht-1].equals("E"))){
    			if((!Global.ditu[i][heigtht-1-1].equals("B"))){
					Global.graph[i*heigtht+heigtht-1][i*heigtht+heigtht-1-1]=1;
					Global.graph[i*heigtht+heigtht-1-1][i*heigtht+heigtht-1]=1;
				}
    		}
    		if(Global.ditu[i][heigtht-1].equals("P")){
				Global.park.add(code.bianma(i, heigtht-1));
			}
    		if(Global.ditu[i][heigtht-1].equals("I")){
				Global.I=code.bianma(i, heigtht-1);
				Global.I_num++;
			}
			if(Global.ditu[i][heigtht-1].equals("E")){
				Global.E=code.bianma(i, heigtht-1);
				Global.E_num++;
			}
    	}
    	for(int j=0;j<heigtht;j++){//纵向扫描
    		for(int i=0;i<width-1;i++){
    			if(Global.ditu[i][j].equals("X")&&Global.ditu[i+1][j].equals("X")){//连续两个X
    				Global.graph[i*heigtht+j][i*heigtht+j+heigtht]=1;
    				Global.graph[i*heigtht+j+heigtht][i*heigtht+j]=1;
    			}else if(Global.ditu[i][j].equals("X")&&Global.ditu[i+1][j].equals("P")){
    				Global.graph[i*heigtht+j][i*heigtht+j+heigtht]=1;
    				Global.graph[i*heigtht+j+heigtht][i*heigtht+j]=1;
    			}else if(Global.ditu[i][j].equals("P")&&Global.ditu[i+1][j].equals("X")){
    				Global.graph[i*heigtht+j][i*heigtht+j+heigtht]=1;
    				Global.graph[i*heigtht+j+heigtht][i*heigtht+j]=1;
    			}else if((Global.ditu[i][j].equals("I")||Global.ditu[i][j].equals("E"))){
    				if(i>0&&(!Global.ditu[i-1][j].equals("B"))){
    					Global.graph[i*heigtht+j][i*heigtht+j-heigtht]=1;
    					Global.graph[i*heigtht+j-heigtht][i*heigtht+j]=1;
    				}
    				if(!Global.ditu[i+1][j].equals("B")){
    					Global.graph[i*heigtht+j][i*heigtht+j+heigtht]=1;
        				Global.graph[i*heigtht+j+heigtht][i*heigtht+j]=1;
    				}
    			}
    		}
    	}
    	for(int j=0;j<heigtht;j++){//纵向扫描最后一行
    		if((Global.ditu[width-1][j].equals("I")||Global.ditu[width-1][j].equals("E"))){
    			if((!Global.ditu[width-1-1][j].equals("B"))){
					Global.graph[(width-1-1)*heigtht+j][(width-1)*heigtht+j]=1;
					Global.graph[(width-1)*heigtht+j][(width-1-1)*heigtht+j]=1;
				}
    		}
    	}
    	//最短路径初始化
    	Global.Dist=new int [Global.w*Global.h][Global.w*Global.h];
    	Global.lujing=new String [Global.w*Global.h][Global.w*Global.h];
    	for(int i=0;i<Global.w*Global.h;i++){
    		for(int j=0;j<Global.w*Global.h;j++){
    			Global.lujing[i][j]="";
    		}
    	}
    	Global.Dist=Arrays.copyOf(Floyd.floyd(Global.graph, Global.w*Global.h),Global.w*Global.h);
    	//车位排序
    	int num_p=Global.park.size();
    	Global.park_paixu=new int [num_p];
    	int xx=0;
    	for(int a:Global.park){
    		Global.park_paixu[xx]=a;
    		xx++;
    	}
    	int temp=0;
    	for(int i=0;i<num_p-1;i++){
    		for(int j=0;j<num_p-1;j++){
    			//修改
    			if((Global.Dist[Global.E][Global.park_paixu[j]])<(Global.Dist[Global.E][Global.park_paixu[j+1]])){  
    			//if((Global.Dist[Global.I][Global.park_paixu[j]]+Global.Dist[Global.E][Global.park_paixu[j]])<(Global.Dist[Global.I][Global.park_paixu[j+1]]+Global.Dist[Global.E][Global.park_paixu[j+1]])){  
    	            temp=Global.park_paixu[j];  
    	            Global.park_paixu[j]=Global.park_paixu[j+1];  
    	            Global.park_paixu[j+1]=temp;  
    	        } 
    		}
    	}
    }


    
}
class code {
	/*
	 * 编码
	 */
	public static int bianma(int i,int j){
		return (i*Global.h+j);
	}
    /*
     * 解码
     */
    public static int jiema_w(int x){
    	  return (x/Global.h);
    }
    public static int jiema_h(int x){
    	 return (x%Global.h);
    }
    /*
     * 路径解码
     */
    public static String jiema_lujing(String bb){
    	String newlujing[];
    	newlujing=bb.split(" ");
    	int length=newlujing.length;
    	String route="";
    	int ax;
    	int ay;
    	ax=jiema_w(Integer.valueOf(newlujing[0]));
		ay=jiema_h(Integer.valueOf(newlujing[0]));
		route=route+"("+String.valueOf(ax)+","+String.valueOf(ay)+")";
    	for(int i=1;i<length;i++){
    		ax=jiema_w(Integer.valueOf(newlujing[i]));
    		ay=jiema_h(Integer.valueOf(newlujing[i]));
    		route=route+" "+"("+String.valueOf(ax)+","+String.valueOf(ay)+")";
    	}
    	return route;
    }
}

class Check {
    /*
     * 检查图是否有效
     */
    public static String map_check(){
    	if(is_arrive()&&is_2()&&is_3()){
    		Global.map_flag=true;
    		return "YES";
    	}
    	else{
    		Global.map_flag=false;
    		return "NO";
    	}	
    }
    public static boolean is_arrive(){
    	boolean flag=true;
    	for(int a:Global.park){
    		if(Global.Dist[Global.I][a]>5000||Global.Dist[Global.E][a]>5000){//原点和终点不可到达停车出
    			flag=false;
    			break;
    		}
    	}
    	return flag;
    }
    public static boolean is_2(){
    	if(Global.I_num==1&&Global.E_num==1){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    public static boolean is_3(){
    	Global.num_px=new int [Global.w][Global.h];
    	for(int i=0;i<Global.w;i++){//横向扫描
    		for(int j=0;j<Global.h;j++){
    			if(Global.ditu[i][j].equals("P")){
    				if(i>0){//看上
    					if(Global.ditu[i-1][j].equals("X"))
    						Global.num_px[i][j]++;
    				}
    				if(j<Global.h-1){//看右
    					if(Global.ditu[i][j+1].equals("X"))
    						Global.num_px[i][j]++;
    					if(i==17&&j==3){
    					//	System.out.println("17找到了");
    					}	
    				}
    				if(j>0){//看左
    					if(Global.ditu[i][j-1].equals("X"))
    						Global.num_px[i][j]++;
    				}
    				if(i<Global.w-1){//看下
    					if(Global.ditu[i+1][j].equals("X"))
    						Global.num_px[i][j]++;
    					if(i==17&&j==3){
    					//	System.out.println("3找到了");
    					}	
    				}
    			}
    		}
    	}
    	boolean panduan=true;
    	for(int i=0;i<Global.w;i++){
    		for(int j=0;j<Global.h;j++){
    			//System.out.println(i+" "+j+" "+Global.num_px[i][j]);
    			if(Global.num_px[i][j]>1){
    				panduan=false;
    				break;
    			}
    		}
    	}
    	
    	return panduan;
    }
}

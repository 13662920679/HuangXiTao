package dadacar;

public class goodsCar extends Car {
	goodsCar(int num,String name,int money,double goods){
		super(num,name,money,0,goods);
	}
	
	public String toString() {
		return num+".\t"+name+"\t"+money+"Ôª/Ìì\tÔØ»õ£º"+goods+"¶Ö";
	}

	

}

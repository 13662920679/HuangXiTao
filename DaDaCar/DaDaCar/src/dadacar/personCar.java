package dadacar;

public class personCar extends Car {
	personCar(int num,String name,int money,int preson){
		super(num,name,money,preson,0);
	}
	
	public String toString() {
		return num+".\t"+name+"\t"+money+"元/天\t载人："+person+"人";
	}

}

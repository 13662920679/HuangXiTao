package dadacar;

public class pikaCar extends Car {
	pikaCar(int num,String name,int money,int preson,double goods){
		super(num,name,money,preson,goods);
	}
	
	public String toString() {
		return num+".\t"+name+"\t"+money+"元/天\t载人："+person+"人  载货："+goods+"吨";
		
	}
}

package dadacar;

public class personCar extends Car {
	personCar(int num,String name,int money,int preson){
		super(num,name,money,preson,0);
	}
	
	public String toString() {
		return num+".\t"+name+"\t"+money+"Ԫ/��\t���ˣ�"+person+"��";
	}

}

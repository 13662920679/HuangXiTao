package dadacar;

public class pikaCar extends Car {
	pikaCar(int num,String name,int money,int preson,double goods){
		super(num,name,money,preson,goods);
	}
	
	public String toString() {
		return num+".\t"+name+"\t"+money+"Ԫ/��\t���ˣ�"+person+"��  �ػ���"+goods+"��";
		
	}
}

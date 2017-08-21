package pg_ex21;

public class Service {

	int c1=0;
	int e1=0;
	String[] c1Number = new String[2];

	public void set(String service){
		if(service.substring(2,4).equals("C1")){
			if(c1>=0 && c1<=1){
				this.c1Number[c1++] = service.substring(5,18);
			}else{
				//登録できないですよ
			}
		}
		if(service.substring(2,4).equals("E1")){
			this.e1=1;
		}
	}

	public int getE1(){
		return this.e1;
	}

	public int getC1(){
		return this.c1;
	}

	public boolean c1Check(String number){
		for (int i=0; i < this.c1 ; i++){
			if(this.c1Number[i].equals(number)){
				return true;
			}
		}
		return false;

	}

}

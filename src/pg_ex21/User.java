package pg_ex21;

public class User {

	static final int BASIC_BASICFEE = 1000;
	static final int BASIC_CALLRATE = 20;

	String number;
	Service service;
	Record records;

	//通話料金
	int callfee=0;

	public User(){}

	public User(String number) {
		this.number = number;
		this.service = new Service();
	}

	public void set(String line){
		if(line.charAt(0)=='2'){
			this.service.set(line);
		}
		if(line.charAt(0)=='5'){
			this.records = new Record(line);
			callfee += getCallfee(records);

		}
	}

	//基本料金計算
	public int getBasicfee(){
		int basicfee = BASIC_BASICFEE;
		if(this.service.getC1() >= 1){
			basicfee += 100;
		}
		if(this.service.getE1() == 1){
			basicfee += 200;
		}
		return basicfee;
	}

	//通話料金計算
	public int getCallfee(Record records) {
		int timeHour;
		int callrate = BASIC_CALLRATE;
		timeHour = records.getTimeHour();
		if(timeHour>=8 && timeHour<18 && service.getE1()==1){
			callrate -= 5;
		}
		if(service.c1Check(records.getNumber())){
			callrate /= 2;
		}
		return callrate * records.getInterval();
	}

	//出力
	public String getOutput(){
		String output;
		output = "1 "+ this.number + "\n";
		output += "5 "+ this.getBasicfee() + "\n";
		output += "7 "+ this.callfee + "\n";
		output += "9 "+ "====================" + "\n";
		return output;
	}
}

package pg_ex21;

public class User {

	static final int BASIC_BASICFEE = 1000;
	static final int BASIC_CALLRATE = 20;

	String number;
	Service service;
	Record[] records;
	int recordCount;

	public User(String number) {
		this.number = number;
		this.service = new Service();
		this.records = new Record[10000];
		this.recordCount=0;
	}

	public void set(String line){
		if(line.charAt(0)=='2'){
			this.service.set(line);
		}
		if(line.charAt(0)=='5'){
			this.records[recordCount++] = new Record(line);
		}
	}

	public String getNumber() {
		return this.number;
	}

	public Service getService(){
		return this.service;
	}

	public Record getRecord(int i) {
		return this.records[i];
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
	public int getCallfee() {
		int callfee = 0;
		int timeHour;
		if(recordCount>0){
			for(int i=0;  i<recordCount; i++ ){
				int callrate = BASIC_CALLRATE;
				timeHour = records[i].getTimeHour();
				if(timeHour>=8 && timeHour<18 && service.getE1()==1){
					callrate -= 5;
				}
				if(service.c1Check(records[i].getNumber())){
					callrate /= 2;
				}
				callfee += callrate * records[i].getInterval();
			}
		}
		return callfee;
	}

	//出力
	public String getOutput(){
		String output;
		output = "1 "+ this.number + "\n";
		output += "5 "+ this.getBasicfee() + "\n";
		output += "7 "+ this.getCallfee() + "\n";
		output += "9 "+ "====================" + "\n";
		return output;
	}
}

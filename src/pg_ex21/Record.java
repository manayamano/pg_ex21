package pg_ex21;

public class Record {

	int count=0;
	String date;
	String time;
	String interval;
	String number;

	public Record(String line) {
		this.date=line.substring(2,12);
		this.time=line.substring(13,18);
		this.interval=line.substring(19,22);
		this.number=line.substring(23,36);
	}

	public int getTimeHour(){
		if(time.charAt(0)=='0'){

			return Integer.parseInt(this.time.substring(0,2));
		}
		return Integer.parseInt(this.time.substring(0,2));
	}

	public int getInterval() {
		return Integer.parseInt(this.interval);
	}

	public String getNumber(){
		return this.number;
	}

}


public class frecuans implements Comparable<frecuans> {
	private int year;
	private int frec;
	
	
	public frecuans(int year, int frec) {
		super();
		setYear(year);
		setFrec(frec);
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getFrec() {
		return frec;
	}
	public void setFrec(int frec) {
		this.frec = frec;
	}

	@Override
	public int compareTo(frecuans o) {
		return this.year - o.getYear();
	}

	@Override
	public String toString() {
		return "Frecuans year " + year + " is = " +frec+"\n" ;
	}
	
	
}

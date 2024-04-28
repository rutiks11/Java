package vehiclemain;

public class Vehicle {
	private String chasisno;
	private Color col;
	private Double price;
	private Double pollutionLevel;
	private Double km;

	public Vehicle(String chasisno, Color col, Double price, Double pollutionLevel) {
		this.chasisno = chasisno;
		this.col = col;
		this.price = price;
		this.pollutionLevel = pollutionLevel;
		this.km = 0.0;
	}

	public String getChasisno() {
		return chasisno;
	}

	public void setKm(Double kilometer) {
		this.km = kilometer;
	}

	public Double getKm() {
		return km;
	}

	@Override
	public String toString() {
		return "\nChasis No : " + this.chasisno + "\nColor : " + this.col + "\nPrice : " + this.price
				+ "\nPollution Level : " + this.pollutionLevel;
	}
}

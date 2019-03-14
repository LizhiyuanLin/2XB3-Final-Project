package temp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.JOptionPane;



public class Industry implements Comparable<Industry>{
	
	private final Double HourlyEarn;
	private final Double WorkHour;
	private final String region;
	private final String Name;
	private final String Time;
	
	public Industry(String Name, String region, Double HE,Double WH, String T){
		if(HE < 0 || WH < 0 || region == "" || T == "")
			throw new IllegalArgumentException();
		this.Name = Name;
		this.region = region;
		this.HourlyEarn = HE;
		this.WorkHour = WH;
		this.Time = T;
	}
	@Override
	public int compareTo(Industry j)
	{	
		if (this.HourlyEarn > j.HourlyEarn) return -1;
		else if (this.HourlyEarn < j.HourlyEarn) return 1;
		else if (this.WorkHour < j.WorkHour) return -1;
		else if (this.WorkHour < j.WorkHour) return 1;
        return 0;
	}
	

	public static void main(String[] args) {
		double s = Double.parseDouble(JOptionPane.showInputDialog("Please enter a number"));
		System.out.println(s);

	}

}

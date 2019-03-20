package temp;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
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
	
	@Override public String toString() { 
		return "Industry [name=" + this.Name + ", region=" + this.region + ", "
				+ "Hourly Earning=" + this.HourlyEarn + ", Hours of Working=" + this.WorkHour + 
				", Time=" + this.Time+ "]"; 
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
	

	public static void main(String[] args) throws IOException {
		double wantWage = Double.parseDouble(JOptionPane.showInputDialog("Please enter the wage you want"));
		System.out.println(wantWage);
		
		BufferedReader Hourlyearning = new BufferedReader(new FileReader("Data/HourlyEarning/14100205.csv"));
		BufferedReader WeeklyHour = new BufferedReader(new FileReader("Data/Weekly hours/14100255.csv"));
		
		PrintStream output = new PrintStream (new File("Data/out.txt"));
		
		String line1, line2;
		/*Hourlyearning.readLine();
		WeeklyHour.readLine();
		Boolean check = true; 
		int count = 2;
		line1 = Hourlyearning.readLine();
		System.out.println(line1);
		line2 = WeeklyHour.readLine();
		System.out.println(line2);
		String[] Properties1, Properties2;
		while (line1 != null) {
			Properties1 = line1.split(",");
			Properties2 = line2.split(",");
			if (Properties1[0].compareTo(Properties2[0]) != 0 || Properties1[1].compareTo(Properties2[1]) != 0 
					|| Properties1[4].compareTo(Properties2[4]) != 0) { 
				check = false;
				break;
			}
			line1 = Hourlyearning.readLine();
			line2 = WeeklyHour.readLine();
			count++;
		}
		System.out.println(check);
		System.out.println(count);*/
		String testr = "\"";
		//testr.replace("\"", "");
		System.out.println(testr.length() == 1);
		for(int i = 1; i <= 831841; i++) {
			Hourlyearning.readLine();
			WeeklyHour.readLine();
		}
		int count = 831841;
		Industry[] test = new Industry[51384];
		line1 = Hourlyearning.readLine();
		line2 = WeeklyHour.readLine();
		String[] Properties;
		String hourlyEarn, weeklyHour, name, Region, time; 
		Double HE, WH;
		for (int i = 0; i < 51384; i++) {
			System.out.println(line1);
			Properties = line1.split("\",");
			time = Properties[0].replace("\"", "");
			Region = Properties[1].replace("\"", "");
			name = Properties[4].replace("\"", "");
			
			System.out.println(Properties[11]);
			if (Properties[11].length() == 1)
				HE = 0.0;
			else {
				hourlyEarn = Properties[11].replace("\"", "");
				HE = Double.parseDouble(hourlyEarn);
			}	
			
			Properties = line2.split("\",");
			System.out.println(Properties[11]);
			if (Properties[11].length() == 1)
				WH = 0.0;
			else {
				weeklyHour = Properties[11].replace("\"", "");
				WH = Double.parseDouble(weeklyHour);
			}
			//System.out.println(name + "   ");
			//System.out.print(Region + "   ");
			//System.out.print(HE + "   ");
			//System.out.print(WH + "   ");
			//System.out.print(time);
			test[i] = new Industry(name, Region, HE, WH, time);
			//output.println(test[i].toString());
			
			line1 = Hourlyearning.readLine();
			line2 = WeeklyHour.readLine();
			count++;
			//System.out.println(count);
			
		}
		
		Sort.sortMergeTD(test,test.length);
		
		for(int i = 0; i < test.length; i++) {
			output.println(test[i].toString());
		}
		/*line = Hourlyearning.readLine();
		System.out.println(line);
		String[] Properties = line.split(",");
		Properties[0] = Properties[0].replace("\"", "");
		Properties[1] = Properties[1].replace("\"", "");
		Properties[4] = Properties[4].replace("\"", "");
		Properties[11] = Properties[11].replace("\"", "");
		System.out.println(Properties[11]);
		Double HE = Double.parseDouble(Properties[11]);
		Industry test = new Industry(Properties[4], Properties[1], HE, 0.0, Properties[0]);
		String testr = test.toString();
		System.out.println(testr);*/
		
		Hourlyearning.close();
		WeeklyHour.close();
		output.close();
		

	}

}

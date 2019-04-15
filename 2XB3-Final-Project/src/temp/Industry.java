package temp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Industry implements Comparable<Industry> {

	private final Double HourlyEarn;
	private final Double WorkHour;
	private final String region;
	private final String Name;
	private final String Time;
	private final boolean Overtime;

	public Industry(String Name, String region, Double HE, Double WH, String T, boolean OT) {
		if (HE < 0 || WH < 0 || region == "" || T == "")
			throw new IllegalArgumentException();
		this.Name = Name;
		this.region = region;
		this.HourlyEarn = HE;
		this.WorkHour = WH;
		this.Time = T;
		this.Overtime = OT;
	}

	public String Name() {
		return this.Name;
	}

	public String region() {
		return this.region;
	}

	public Double HourlyEarn() {
		return this.HourlyEarn;
	}

	public Double WorkHour() {
		return this.WorkHour;
	}

	public String Time() {
		return this.Time;
	}

	public boolean Overtime() {
		return this.Overtime;
	}

	@Override
	public String toString() {
		return "Industry [name=" + this.Name + ", region=" + this.region + ", " + "Hourly Earning=" + this.HourlyEarn
				+ ", Hours of Working=" + this.WorkHour + ", Time=" + this.Time + ", Overtime = " + this.Overtime + "]";
	}

	@Override
	public int compareTo(Industry j) {
		if (this.HourlyEarn > j.HourlyEarn)
			return -1;
		else if (this.HourlyEarn < j.HourlyEarn)
			return 1;
		else if (this.WorkHour < j.WorkHour)
			return -1;
		else if (this.WorkHour > j.WorkHour)
			return 1;
		else if (this.Overtime == false && j.Overtime == true)
			return -1;
		else if (this.Overtime == true && j.Overtime == false)
			return 1;
		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader Hourlyearning = new BufferedReader(new FileReader("Data/HourlyEarning/14100205.csv"));
		BufferedReader WeeklyHour = new BufferedReader(new FileReader("Data/Weekly hours/14100255.csv"));

		PrintStream output = new PrintStream(new File("Data/out.txt"));

		String line1, line2;
		for (int i = 1; i <= 831841; i++) {
			Hourlyearning.readLine();
			WeeklyHour.readLine();
		}
		Industry[] test = new Industry[51384];
		line1 = Hourlyearning.readLine();
		System.out.println(line1);
		line2 = WeeklyHour.readLine();
		String[] Properties;
		String hourlyEarn, weeklyHour, name, Region, time, overT;
		Double HE, WH;
		for (int i = 0; i < 51384; i++) {
			Properties = line1.split("\",");
			time = Properties[0].replace("\"", "");
			Region = Properties[1].replace("\"", "");
			overT = Properties[3].replace("\"", "");
			name = Properties[4].replace("\"", "");

			if (Properties[11].length() == 1)
				HE = 0.0;
			else {
				hourlyEarn = Properties[11].replace("\"", "");
				HE = Double.parseDouble(hourlyEarn);
			}

			Properties = line2.split("\",");

			if (Properties[11].length() == 1)
				WH = 0.0;
			else {
				weeklyHour = Properties[11].replace("\"", "");
				WH = Double.parseDouble(weeklyHour);
			}
			test[i] = new Industry(name, Region, HE, WH, time, (overT.compareTo("Including overtime") == 0));

			line1 = Hourlyearning.readLine();
			line2 = WeeklyHour.readLine();

		}

		Industry[] indusCA = new Industry[0];
		Industry[] indusON = new Industry[0];
		Industry[] indusBC = new Industry[0];
		Industry[] indusAB = new Industry[0];
		Industry[] indusMB = new Industry[0];
		Industry[] indusSK = new Industry[0];
		Industry[] indusYT = new Industry[0];
		Industry[] indusNT = new Industry[0];
		Industry[] indusNL = new Industry[0];
		Industry[] indusNU = new Industry[0];
		Industry[] indusPE = new Industry[0];
		Industry[] indusQC = new Industry[0];
		Industry[] indusNB = new Industry[0];
		Industry[] indusNS = new Industry[0];

		ArrayList<Industry> CAindus = new ArrayList<Industry>(Arrays.asList(indusCA));
		ArrayList<Industry> ONindus = new ArrayList<Industry>(Arrays.asList(indusON));
		ArrayList<Industry> BCindus = new ArrayList<Industry>(Arrays.asList(indusBC));
		ArrayList<Industry> ABindus = new ArrayList<Industry>(Arrays.asList(indusAB));
		ArrayList<Industry> MBindus = new ArrayList<Industry>(Arrays.asList(indusMB));
		ArrayList<Industry> SKindus = new ArrayList<Industry>(Arrays.asList(indusSK));
		ArrayList<Industry> YTindus = new ArrayList<Industry>(Arrays.asList(indusYT));
		ArrayList<Industry> NTindus = new ArrayList<Industry>(Arrays.asList(indusNT));
		ArrayList<Industry> NLindus = new ArrayList<Industry>(Arrays.asList(indusNL));
		ArrayList<Industry> NUindus = new ArrayList<Industry>(Arrays.asList(indusNU));
		ArrayList<Industry> PEindus = new ArrayList<Industry>(Arrays.asList(indusPE));
		ArrayList<Industry> QCindus = new ArrayList<Industry>(Arrays.asList(indusQC));
		ArrayList<Industry> NBindus = new ArrayList<Industry>(Arrays.asList(indusNB));
		ArrayList<Industry> NSindus = new ArrayList<Industry>(Arrays.asList(indusNS));
		for (Industry industry : test) {
			if (industry.region.compareTo("Canada") == 0)
				CAindus.add(industry);
			else if (industry.region.compareTo("Ontario") == 0)
				ONindus.add(industry);
			else if (industry.region.compareTo("British Columbia") == 0)
				BCindus.add(industry);
			else if (industry.region.compareTo("Alberta") == 0)
				ABindus.add(industry);
			else if (industry.region.compareTo("Manitoba") == 0)
				MBindus.add(industry);
			else if (industry.region.compareTo("Saskatchewan") == 0)
				SKindus.add(industry);
			else if (industry.region.compareTo("Yukon") == 0)
				YTindus.add(industry);
			else if (industry.region.compareTo("Northwest Territories") == 0)
				NTindus.add(industry);
			else if (industry.region.compareTo("Newfoundland and Labrador") == 0)
				NLindus.add(industry);
			else if (industry.region.compareTo("Nunavut") == 0)
				NUindus.add(industry);
			else if (industry.region.compareTo("Prince Edward Island") == 0)
				PEindus.add(industry);
			else if (industry.region.compareTo("Quebec") == 0)
				QCindus.add(industry);
			else if (industry.region.compareTo("New Brunswick") == 0)
				NBindus.add(industry);
			else if (industry.region.compareTo("Nova Scotia") == 0)
				NSindus.add(industry);
			else
				continue;
		}
		indusCA = CAindus.toArray(indusCA);
		indusON = ONindus.toArray(indusON);
		indusBC = BCindus.toArray(indusBC);
		indusAB = ABindus.toArray(indusAB);
		indusMB = MBindus.toArray(indusMB);
		indusSK = SKindus.toArray(indusSK);
		indusYT = YTindus.toArray(indusYT);
		indusNT = NTindus.toArray(indusNT);
		indusNL = NLindus.toArray(indusNL);
		indusNU = NUindus.toArray(indusNU);
		indusPE = PEindus.toArray(indusPE);
		indusQC = QCindus.toArray(indusQC);
		indusNB = NBindus.toArray(indusNB);
		indusNS = NSindus.toArray(indusNS);

		Sort.sortMergeTD(indusCA, indusCA.length);
		Sort.sortMergeTD(indusON, indusON.length);
		Sort.sortMergeTD(indusBC, indusBC.length);
		Sort.sortMergeTD(indusAB, indusAB.length);
		Sort.sortMergeTD(indusMB, indusMB.length);
		Sort.sortMergeTD(indusSK, indusSK.length);
		Sort.sortMergeTD(indusYT, indusYT.length);
		Sort.sortMergeTD(indusNT, indusNT.length);
		Sort.sortMergeTD(indusNL, indusNL.length);
		Sort.sortMergeTD(indusNU, indusNU.length);
		Sort.sortMergeTD(indusPE, indusPE.length);
		Sort.sortMergeTD(indusQC, indusQC.length);
		Sort.sortMergeTD(indusNB, indusNB.length);
		Sort.sortMergeTD(indusNS, indusNS.length);

		// December data
		Industry[] Sample = new Industry[0];
		ArrayList<Industry> SampleLst = new ArrayList<Industry>(Arrays.asList(Sample));
		for (Industry industry : indusCA) {
			if (industry.Overtime() == false && (industry.Time().compareTo("2017-12")) == 0)
				SampleLst.add(industry);
		}
		Sample = SampleLst.toArray(Sample);
		Sort.sortMergeTD(Sample, Sample.length);

		Double wantedWage = Double.parseDouble(JOptionPane.showInputDialog("Please enter the wage you want"));
		Industry[] indusInrange = Search.printout(Sample, wantedWage);
		System.out.println(indusInrange.length);

		// Search result list (industry names)
		String[] namesInrange = new String[indusInrange.length];
		for (int i = 0; i < indusInrange.length; i++) {
			namesInrange[i] = indusInrange[i].Name();
			output.println(namesInrange[i] + "     " + indusInrange[i].HourlyEarn());
		}

		RelaventIndustries IndusGraph = new RelaventIndustries();
		// Recommendation industry names
		ArrayList<String> Recommendations = IndusGraph.giveRecommendations(namesInrange);

		output.println("Recommendations:");
		for (String indusName : Recommendations) {
			output.println(indusName);
		}

		// May need modification - changing Recommendation contents
		for (int i = 0; i < namesInrange.length; i++) {
			Recommendations.add(namesInrange[i]);
		}
		;

		String nameLst[] = Recommendations.toArray(new String[Recommendations.size()]);
		String sltName = (String) JOptionPane.showInputDialog(null, "Choose now...", "The Choice of a Industry name",
				JOptionPane.QUESTION_MESSAGE, null, nameLst, nameLst[0]);

		String location[] = { "Canada", "Ontario", "British Columbia", "Albreta", "Manitoba", "Saskatchewan", "Yukon",
				"Northwest Territories", "Newfoundland and Labrador", "Nunavut", "Prince Edward Island", "Quebec",
				"New Brunswick", "Nova Scotia" };
		String sltLocation = (String) JOptionPane.showInputDialog(null, "Choose now...", "The Choice of a Region",
				JOptionPane.QUESTION_MESSAGE, null, location, location[0]);

		int counter = -1;
		ArrayList<Double> IndHE = new ArrayList();
		ArrayList<Double> IndWH = new ArrayList();
		for (Industry ind : test) {
			if ((ind.region.compareTo(sltLocation) == 0) && (ind.Name.compareTo(sltName) == 0)) {
				if (ind.HourlyEarn - 0.0 < 0.00001) {
					IndHE.add(IndHE.get(counter));
				}
				else {
					IndHE.add(ind.HourlyEarn);
				}
				
				if (ind.WorkHour - 0.0 < 0.00001) {
					IndWH.add(IndWH.get(counter));
				}
				else {
					IndWH.add(ind.WorkHour);
				}
				
				counter++;
			}
		}

		StdDraw.setXscale(1, 12);
		StdDraw.setYscale(0, 100);
		StdDraw.text(6, 80, sltName + " industry hourly wage trend");
		for (int i = 0; i < 12; i++) {
			StdDraw.line(i, IndHE.get(i), i + 1, IndHE.get(i + 1));
		}
		StdDraw.save("Data/wage trend.jpg");
		StdDraw.clear();
		StdDraw.text(6, 80, sltName + " industry work hour trend");
		for (int i = 0; i < 12; i++) {
			StdDraw.line(i, IndWH.get(i), i + 1, IndWH.get(i + 1));
		}
		StdDraw.save("Data/work hour.jpg");

		Hourlyearning.close();
		WeeklyHour.close();
		output.close();

	}

}

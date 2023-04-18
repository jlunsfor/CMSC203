import java.util.Arrays;

/*
 * Class: CMSC203
 * Instructor: Grinberg
 * Description: This program helps determine bonuses handed out 
 * by a company.
 * Due: 17 April 2023
 * I pledge that I have completed the programming assignment independently. I 
 * have not copied the code from a student or any source. I have not given my
 * code to any student.
 * 
 * Jeremy Lunsford
 */

public class HolidayBonus {
	static final double BONUS_HIGH = 5000.0;
	static final double BONUS_LOW = 1000.0;
	static final double BONUS_STANDARD = 2000.0;
	
	public static double[] calculateHolidayBonus(double[][] data) {
		int rowNum = 0;
		int categories = 6;
		int highestStore;
		int lowestStore;
		for (double[] row: data) {
			rowNum++;
		}
		double[][] bonuses = new double[rowNum][categories];
		for (double[] row: bonuses) {
		    Arrays.fill(row, BONUS_STANDARD);
		}
		
		for (int i = 0; i < categories; i++) {
			double highSale = TwoDimRaggedArrayUtility.getHighestInColumn(data, i);
			double lowSale = TwoDimRaggedArrayUtility.getLowestInColumn(data, i);
			if ((highSale > 0) && (lowSale > 0)) {
				bonuses[TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, i)][i] = BONUS_HIGH;
				bonuses[TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, i)][i] = BONUS_LOW;
			}
			else if (highSale > 0) {
				bonuses[TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, i)][i] = BONUS_HIGH;
				for (int j = 0; j < rowNum; j++) {
					try {
						if (data[j][i] < 0) {
							bonuses[j][i] = 0.0;
						}
						else {
							bonuses[j][i] = BONUS_STANDARD;
						}
					}
					catch (ArrayIndexOutOfBoundsException e) {}
				}
			}
			else {
				for (int j = 0; j < rowNum; j++) {
					bonuses[i][j] = 0.0;
				}
			}	
		}
		
		double[] result = new double[rowNum];
		for (int i = 0; i < rowNum; i++) {
			result[i] = TwoDimRaggedArrayUtility.getRowTotal(bonuses, i);
		}
		
		return result;
	}
	
	public static double calculateTotalHolidayBonus(double[][] data) {
		double result = TwoDimRaggedArrayUtility.getTotal(data);
		
		return result;
	}

}

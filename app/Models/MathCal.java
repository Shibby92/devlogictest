package models;


public class MathCal {

	public static int GetIntResult(String expression) {
		if ((!expression.contains(" ")) && (!expression.contains("+"))
				&& (!expression.contains("-"))) {
			return Integer.parseInt(expression);
		} else {
			StringBuilder sb = new StringBuilder();
			expression = expression.replace(" ", "");
			int result = 0;
			boolean operation = true;
			for (int i = 0; i < expression.length(); i++) {
				if ((expression.charAt(i) > 47) && (expression.charAt(i) < 58)) {
					sb.append(String.valueOf(expression.charAt(i)));
					if (i == expression.length() - 1) {
						if (operation) {
							result += Integer.parseInt(sb.toString());
						} else {
							result -= Integer.parseInt(sb.toString());
						}
					}
				} else {
					if (operation) {
						result += Integer.parseInt(sb.toString());
					} else {
						result -= Integer.parseInt(sb.toString());
					}
					if (expression.charAt(i) == '+') {
						operation = true;
					} else {
						operation = false;
					}
					sb.setLength(0);
				}
			}
			return result;
		}
	}
	
	// radi do milion 
	
	final static String[] tensNames = { "", " ten", " twenty", " thirty",
			" forty", " fifty", " sixty", " seventy", " eighty", " ninety" };

	final static String[] numNames = { "", " one", " two", " three", " four",
			" five", " six", " seven", " eight", " nine", " ten", " eleven",
			" twelve", " thirteen", " fourteen", " fifteen", " sixteen",
			" seventeen", " eighteen", " nineteen" };

	public static String GetStringResult(int num) {
		if (num == 0) {
			return "zero";
		}

		if (num < 20) {
			return numNames[num];
		}
		if (num < 100) {
			String result = tensNames[num / 10];
			return result + numNames[num % 10];
		}
		if (num < 1000) {
			return convertLessThanOneThousand(num);
		}
		if(num <1000000){
		int thousands = num/1000;
		int hundreds = num%1000;
		return convertLessThanOneThousand(thousands)+" thousands" + convertLessThanOneThousand(hundreds);

		}
		if (num == 1000000){
			return "One million";
		}
		return null;
	}

	private static String convertLessThanOneThousand(int num) {
		String soFar;

		if (num % 100 < 20) {
			soFar = numNames[num % 100];
			num /= 100;
		} else {
			soFar = numNames[num % 10];
			num /= 10;

			soFar = tensNames[num % 10] + soFar;
			num /= 10;
		}
		if (num == 0) {
			return soFar;
		}
		return numNames[num] + " hundred" + soFar;

	}
}


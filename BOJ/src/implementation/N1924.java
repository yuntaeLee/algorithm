package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.StringTokenizer;

public class N1924 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int month = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
		
		LocalDate date = LocalDate.of(2007, month, day);
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		
		String strDay = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US);
		System.out.println(strDay.toUpperCase());
	}
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

//Wite a function, that will return the latest modification of files
//These files are in plik.txt, which contains informations about permissions in Linux system
public class LinuxAccessAlgorithm {

    private static String year;
    private static String month;
    private static String month_int;
    private static String day;
    private static Vector<LocalDate> all_dates = new Vector<LocalDate>();

    private static int getMonthNumber(String monthName) {
        Date date = null;
        try {
            date = new SimpleDateFormat("MMMM", Locale.ENGLISH).parse(monthName);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);

            return cal.get(Calendar.MONTH);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    private static void sort() {
        int size = all_dates.size();
        for(int i=0; i<size -1 ; i++)
        {
            for(int j=0; j<size - i - 1;j++)
            {
                if(all_dates.get(j).isAfter(all_dates.get(j+1))){
                    LocalDate temp = all_dates.get(j);
                    all_dates.set(j, all_dates.get(j+1));
                    all_dates.set(j+1, temp);
                }
            }
        }
    }

    public static void ass(String filePath) {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();


            while (line != null) {
                year = String.valueOf(line.charAt(18)) + String.valueOf(line.charAt(19)) + String.valueOf(line.charAt(20)) + String.valueOf(line.charAt(21));
                month = String.valueOf(line.charAt(14)) + String.valueOf(line.charAt(15)) + String.valueOf(line.charAt(16));

                month_int = String.valueOf(getMonthNumber(month));
                int temporary = Integer.parseInt(month_int);  //This line are there because function GetNumberSort return that Feb - 11 and Jan - 0
                temporary+=1;                                 //
                month_int = String.valueOf(temporary);        //

                if(month_int.length() == 1)
                {
                    month_int = "0"+month_int;
                }

                day = String.valueOf(line.charAt(11)) + String.valueOf(line.charAt(12));
//                System.out.println(year);
//                System.out.println(month_int);
//                System.out.println(day);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//                LocalDate It = LocalDate.parse();
                all_dates.add(LocalDate.parse(year+"-"+month_int+"-"+day));

                line = reader.readLine();

            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main() {

        String x = new String();
        x = "dog";

        ass("plik.txt");
        sort();

        System.out.println(all_dates.get(0));


    }




}
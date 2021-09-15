package BrijeshClassAssignment;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Assignment implements Serializable {

    public static String getDayNumberOld(String date) {
        DateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
        Calendar c = Calendar.getInstance();
        Date date1= new Date(date);
        c.setTime(date1);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        String day="";
        switch (dayOfWeek){
            case 1:
                day="Sunday";
                break;
            case 2:
                day="Monday";
                break;
            case 3:
                day="Tueday";
                break;
            case 4:
                day="Wednesday";
                break;
            case 5:
                day="Thursday";
                break;
            case 6:
                day="Friday";
                break;
            case 7:
                day="Saturday";
                break;
            default:
                System.out.println("Not valid day");
        }
        return day;
    }
    public static void main(String[] args) throws Exception{
        getDayNumberOld("12-Sep-2021");

        try {
            File file= new File("/Users/manindersingh/IdeaProjects/TestingPurpose/InputFile/bank_transactions.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            BufferedWriter bw= new BufferedWriter(new FileWriter("/Users/manindersingh/IdeaProjects/TestingPurpose/InputFile/output.txt"));


            String i;
            while((i= br.readLine())!=null){
                String [] transaction = i.split("\t");
                if (!transaction[1].equals("DATE")) {
                    String transactionDay = getDayNumberOld(transaction[1]);

                    if (transactionDay.equalsIgnoreCase("monday") ||
                            transactionDay.equalsIgnoreCase("wednesday") ||
                            transactionDay.equalsIgnoreCase("friday")){

                        System.out.println("Transaction Date: " + transaction[1]);
                        System.out.println("Transaction Day: " + transactionDay);
                        System.out.println("Transaction Details: " + transaction[2]);
                        bw.write(transaction[2]);
                        bw.newLine();
                        bw.flush();
                        System.out.println("---------------------------------------------");

                    }

                }
            }
            br.close();
            bw.close();
        }catch (Exception e){
            System.out.println(e);
        }
        finally {

        }

    }
}


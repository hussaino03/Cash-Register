import java.util.Scanner;

class Main {
  public static void main(String[] args) {

    Scanner inp = new Scanner(System.in);
    System.out.println("Press any key to start");
    String key = inp.nextLine();
    System.out.println("\nEnter the amount of each item");
    System.out.println("Upto 5 inputs are allowed!");
    System.out.println("To enter a HST value, type h or H before or after the value\n");

    int counter = 0;
    int hstcount = 0;
    int nonhstcount = 0;
    int maxDollar = 1000;
    double NHSTT=0;
    
    Double[] value2 = new Double[5];
    Double[] numbers = new Double[5];
    Double[] numbers2 = new Double[5];
    boolean go = true;

    while (go) {

      String value = inp.nextLine();
      value = value.toLowerCase();
      int indexOfh = value.indexOf('h');
      boolean containsh = indexOfh == 0 || indexOfh == (value.length() - 1);
      
      if (containsh) {

        
        value2[hstcount] = Double.parseDouble(value.replace("h", ""));

        if (value2[hstcount] >= maxDollar && value2[hstcount] > 0) {
          System.out.println("Keep values under $1000 please");
 
        } else if (value2[hstcount] <= maxDollar && value2[hstcount] > 0) {

          numbers[hstcount] = Double.parseDouble(value.replace("h", ""));
          System.out.println("HST will be taken account for this value");
          hstcount++;
        }
      
      } else {
        value2[hstcount] = Double.parseDouble(value);

        if (value2[hstcount] >= maxDollar && value2[hstcount] > 0) {
          System.out.println("Keep values under $1000 please");

        } else if (value2[hstcount] <= maxDollar && value2[hstcount] > 0) {

          numbers2[nonhstcount] = Double.parseDouble(value);
          nonhstcount++;
        }

      }
      counter++;
      if (counter == 5) {
        go = false;
      }
    }
    
    System.out.println("\nValues with HST:");

    double Total = 0;
    double Total2 = 0;
    double HST = 0;
    
    for (int i = 0; i < hstcount; i++) {

      double calc = numbers[i] * 0.15;
      NHSTT = NHSTT + numbers[i];
      System.out.print("\n" + numbers[i]);
      System.out.format(" With HST: " + "%.2f", calc);

      double HST2 = numbers[i] * 0.15;
      HST = HST + numbers[i] * 0.15;

      numbers[i] = numbers[i] + HST2;

      Total = Total + numbers[i];

      System.out.format("\nItem Total With HST : " + "%.2f", numbers[i]);

      System.out.println();

    }
    System.out.println("\nNon-HST Values:");
    
    for (int x = 0; x < nonhstcount; x++) {
      System.out.println(numbers2[x]);
      
      Total2 = Total2 + numbers2[x];
    }
    double amountDue = Total+Total2;
    double NHSTT2= NHSTT+Total2;
    
    System.out.format("\nItem Summary Total: " + "%.2f",NHSTT2);
    System.out.format("\nHST Total: " + "%.2f", HST);
    System.out.format("\nAmount Due Total: " + "%.2f", amountDue);

  }
}

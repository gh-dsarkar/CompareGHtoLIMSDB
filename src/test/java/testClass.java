import java.util.*;

public class testClass {
    static Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    static ArrayList<Integer> mylist = new ArrayList<Integer>();

    public static void main(String[] args) {

        testmethod();
        }


    private static void testmethod(){

        System.out.println("Enter a number corresponding to the Variant to be tested. If you tests lists is complete, Enter 0 to exit the Lists");

        while (myObj.hasNextInt()) {
            int i = myObj.nextInt();
            if (i == 0) {
                System.out.println("Selected Test numbers are : ");
                String listString = "";

                for (Integer s : mylist) {
                    listString = s.toString() + "\t";
                    System.out.println(listString);
//                    System.out.println(s.toString());
                }


            } else {
                if (i >= 10 && i <= 1) {
                    System.out.println("Enter Valid input to continue");
                } else {
                    mylist.add(i);

                    testmethod();
                }
            }
        }
    }
}








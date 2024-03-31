import java.util.Scanner;

public class SafeInput {
    public static void main(String[] args)                                                                               //Start of Main
    {
        Scanner scanner = new Scanner(System.in);
    }                                                                                                                    //End of Main

    public static void sayMessage()                                                                                     //Start of sayMessage Test
    {
        System.out.println("HI!");
    }                                                                                                                   //End of sayMessage Test

    //Start of  getNonZeroLenString

    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;

    }                                                                                                                   //End of getNonZeroString


    public static int getInt(Scanner pipe, String prompt)                                                               //Start of getInt
    {
        int number = 0;

        System.out.println(prompt); //Prompt
        while (true) {
            if (pipe.hasNextInt()) {
                number = pipe.nextInt();
                pipe.nextLine();

                break;
            } else {
                System.out.println("Invalid input, please enter a valid number."); //Invalid input response
                pipe.nextLine();
                System.out.println(prompt);
            }
        }
        return number;
    }                                                                                                                   //End of getInt


    public static double getDouble(Scanner pipe, String prompt)                                                         //Start of getDouble
    {
        double doubleNumber = 0.0;
        System.out.println(prompt);

        while (true) {
            if (pipe.hasNextDouble()) //Checking for valid input
            {
                doubleNumber = pipe.nextDouble();
                pipe.nextLine();
                break;
            } else
            {
                System.out.println("Invalid input, please enter a valid number.");
                pipe.nextLine();
                System.out.println(prompt);
            }
        }
        return doubleNumber;
    }                                                                                                                   //End of getDouble


    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)                                      //Start of getRangedInt
    {
        int retVal = 0;
        String trash = "";
        boolean done =false;

        do {
            System.out.println("\n" + prompt + "[" + low + "-" + high + "]:");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("\nNumber is out of range [" + low + "-" + high + "]:" + retVal);
                }
            }
            else
                {
                    trash = pipe.nextLine();
                    System.out.println("You must enter an integer.");
                }

        }
        while (!done);
        return retVal;
    }                                                                                                                   //End of getRangedInt


    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)                                   //Start of getRangedDouble
    {
        double retVal = 0;
        String trash = "";
        boolean done =false;

        do
        {
            System.out.println("\n" + prompt);
            if(pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("\nNumber is out of range: " + retVal);
                }
            }else
                {
                    trash = pipe.nextLine();
                    System.out.println("You must enter an double.");
                }
            }
        while (!done);
        return retVal;
    }                                                                                                                   //End of getRangedDouble


    public static boolean getYNConfirm(Scanner pipe, String prompt)                                                     //Start of getNYConfirm
    {
        boolean retVal = true;
        String response = "";
        boolean gotAval = false;

        do
        {
            System.out.println("\n" + prompt + " [Y/N] ");
            response = pipe.nextLine();
            if(response.equalsIgnoreCase("Y"))
            {
             gotAval = true;
             retVal = true;
            }
            else if (response.equalsIgnoreCase("N"))
            {
            gotAval = true;
            retVal = false;
            }
            else
            {
                System.out.println("You must answer [Y/N].");
            }
        }
        while(!gotAval);
        return retVal;
    }                                                                                                                   //End of getYNConfirm


    public static String getRegExString(Scanner pipe, String prompt, String regExPattern)                               //Start of getRegExString
    {
        String response = "";
        boolean gotAVal = false;

        do
        {
            System.out.println("\n" + prompt + ": ");
            response = pipe.nextLine();
            if (response.matches(regExPattern))
            {
                gotAVal = true;
            }
            else
            {
                System.out.println("\n" +response + " must match the pattern.");
                System.out.println("Try again!");
            }
        }
        while (!gotAVal);
        return response;
    }                                                                                                                   //End of getRegExString











}

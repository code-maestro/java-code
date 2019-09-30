package group4;

import java.util.*;

import static javax.swing.JOptionPane.*;

public class Group4 {

    public static void main(String[] args) {

        int num;

        try {
            
            System.out.println("Please enter the array size");

            Scanner Obj = new Scanner(System.in);

            num = Obj.nextInt();

            System.out.println("\n\nThe Array size chosen is\n " + num);

            int arrayNum[] = new int[num];

            System.out.println("Please enter the array elements\n");

            for (int a = 0; a < arrayNum.length; a++) {

                arrayNum[a] = Obj.nextInt();
            }
              
            
            System.out.println("Please enter the array index you want");

            int index;
            index = Obj.nextInt();

            System.out.println("\n The array element successfully accessed " + arrayNum[index]);

            if (index != index) {
                
                throw new InputMismatchException();
                
            } 
            
            else {
            
                throw new ArrayIndexOutOfBoundsException();
            }
            
        } 
        
        catch (ArrayIndexOutOfBoundsException e) {
            showMessageDialog(null, "You have exceeded the Array size!");
        } 
        
        catch (InputMismatchException e) {
            showMessageDialog(null, "You have entered a wrong format!");
        } 
        
        finally {
            showMessageDialog(null, "You have entered a negative value ");
        }
    }
}


import java.util.Scanner;

public class FractionCalculator {
    
    public static String getOperation(Scanner input){
        System.out.println("Please enter an operation (+, -, /, *, = or Q to quit: ");
        String operator = input.nextLine();
        while(!"+".equals(operator) && !"-".equals(operator) && !"/".equals(operator) && !"*".equals(operator) && !"=".equals(operator) && !"Q".equals(operator)){            
            System.out.println("Please enter valid operation (+, -, /, *, = or Q to quit");
            operator = input.nextLine();
        }
        return operator;
    }
    
    public static boolean validFraction(String input) {
        int indexOfSlash = input.indexOf('/');
        if (indexOfSlash != -1 ) {
            String a = input.substring(0, indexOfSlash);
            if(a.charAt(0) == '-'){
                a = input.substring(1, indexOfSlash);
            }
            String b = input.substring(indexOfSlash+1);
            if(b.charAt(0) == '-'){
                b = input.substring(indexOfSlash+2);
            }
            if (a.chars().allMatch(Character::isDigit) && b.chars().allMatch(Character::isDigit)) {
                return true;            
            }
            else {
                return false;
            }
        }
        else {
            if (input.charAt(0) == '-'){
                input = input.substring(1);
            }
            if (input.chars().allMatch(Character::isDigit)){
                return true;
            }
            else{
                return false;
            }            
        }
    }
    
    public static Fraction getFraction(Scanner input){
        System.out.println("Please eneter a fraction (a/b) or integer (a): ");
        String fractionInput = input.nextLine();
        int indexOfSlash;
        do {
            if (validFraction(fractionInput)) {
                indexOfSlash = fractionInput.indexOf('/');
                if (indexOfSlash != -1 ) {
                    String a = fractionInput.substring(0, indexOfSlash);
                    String b = fractionInput.substring(indexOfSlash+1);                            
                    Fraction fraction = new Fraction(Integer.parseInt(a), Integer.parseInt(b));
                    return fraction;
                }
                else {
                    Fraction fraction = new Fraction(Integer.parseInt(fractionInput));
                    return fraction;
                }
            }
            else {
                    System.out.println("Invalid fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero: ");
                    
                    fractionInput = input.nextLine();
            }
        } while (!validFraction(fractionInput));
        indexOfSlash = fractionInput.indexOf('/');
        if (indexOfSlash != -1 ) {
            String a = fractionInput.substring(0, indexOfSlash);
            String b = fractionInput.substring(indexOfSlash+1);                            
            Fraction fraction = new Fraction(Integer.parseInt(a), Integer.parseInt(b));
            return fraction;
        }
        else {
            Fraction fraction = new Fraction(Integer.parseInt(fractionInput));
            return fraction;
        }         
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("This program is a fraction calculator\nIt will add, subtract, multiply and divide"
                + "fraction until you type Q to quit\nPlease enter your fractions in the form a/b, where a and b are integers."
                + "\n--------------------");
        
        Scanner input1, input2, input3;
        String operator;
        String result;
        boolean equalsResult;
        
        while(true) {
            operator = getOperation(input1 = new Scanner(System.in));
            if ("Q".equals(operator)) {
                break;
            }
            Fraction fraction1 = getFraction(input2 = new Scanner(System.in));
            Fraction fraction2 = getFraction(input3 = new Scanner(System.in));
            if ("+".equals(operator)) {
                fraction1.add(fraction2);
                result = fraction1.toString();
                System.out.println("result = "+result);
            }
            else if ("-".equals(operator)) {
                fraction1.subtract(fraction2);
                result = fraction1.toString();
                System.out.println("result = "+result);
            }
            else if ("*".equals(operator)) {
                fraction1.multiply(fraction2);
                result = fraction1.toString();
                System.out.println("result = "+result);
            }
            else if ("/".equals(operator)) {
                fraction1.divide(fraction2);
                result = fraction1.toString();
                System.out.println("result = "+result);
            }
            else if ("=".equals(operator)) { 
                
                equalsResult = fraction1.equals(fraction2);
                System.out.println("result = "+equalsResult);
            }
        }
    }
    
}


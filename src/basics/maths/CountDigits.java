package basics.maths;
//https://www.codingninjas.com/studio/problems/count-digits_8416387
public class CountDigits {

    public static int countDigits(int input){
        // Write your code here.
        int initialInput = input;
        int result=0;
        int currentVal;

        while(input > 0){
            currentVal = input%10;
            //Corner case : if input contains a 0 digit, first check currentVal>0
            if( currentVal >0 && initialInput % currentVal == 0){
                result++;
            }
            input = input/10;
        }
        return result;
    }
    public static void main(String[] args) {
        int result = countDigits(350 );
        System.out.println("Result : "+result);
    }
}

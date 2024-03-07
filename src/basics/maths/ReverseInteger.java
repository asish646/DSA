package basics.maths;
//https://leetcode.com/problems/reverse-integer/description/
public class ReverseInteger {
    //Not recommended
    public int reverseUsingString(int input) {

        int resut = 0;
        String inputStr = Integer.valueOf(input).toString();

        StringBuilder builder = new StringBuilder();
        for (int i = inputStr.length() - 1; i >= 0; i--) {
            builder.append(inputStr.charAt(i));
        }

        String reversedStr = builder.toString();
        if (reversedStr.contains("-")) {
            reversedStr = reversedStr.replace("-", "");
            reversedStr = "-" + reversedStr;
        }
        //Edge case : input 1534236469,  java.lang.NumberFormatException: For input string: "9646324351"
        try {
            resut = Integer.parseInt(reversedStr);
        } catch (Exception ex) {
            //If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0
            return 0;
        }
        return resut;
    }

    public int reverse(int in) {

        int input = Math.abs(in);
        int resut = 0;

        while(input != 0){
            int lastNum = input%10;
            //Edgecase: after reverse if it grows bigger than Integer Max value,(1534236469)
            if(resut > ((Integer.MAX_VALUE-lastNum)/10)){
                return 0;
            }

            resut = resut*10+lastNum;
            input = input/10;
        }

        //EdgeCase : if input is a negative number, then add -sign before returning
        return in<0 ? -resut: resut;
    }

    public static void main(String[] args) {

        int result = new ReverseInteger().reverse(-123);
        System.out.println("Result : " + result);
    }
}

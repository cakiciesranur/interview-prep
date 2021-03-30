package grubTech;
/**Given a list of integers, determine how many of them are divisible by 7.
 * If you encounter an integer in the list that is greater than or equal to 77,
 * return 0 regardless of how many numbers are divisible by 7.
 * */
public class Q1 {
    public static void main(String[] args) {


    }
    public static Integer divisible_by_7( Integer[] my_list ) {
        //Insert your code here
        int count= 0;
        if(my_list.length<1){
            return count;
        }

        for(Integer n : my_list){
            if(n>=77){
                return 0;
            }else if(n==0 || n%7 == 0){
                count++;
            }
        }

        return count;

    }
}

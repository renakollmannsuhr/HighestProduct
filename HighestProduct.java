import java.util.*; 

public class HighestProduct {

    /* 
    Given a list of integers, create a function that returns the highest product between three of those numbers.
    e.g. given the list [1, 10, 2, 6, 5, 3] the highest product would be 10 * 6 * 5 = 300
    */
    public static String findHighestProduct(ArrayList<Integer> intList){
        if (intList.isEmpty()){
            return ("empty list");
        }
        Collections.sort(intList, Collections.reverseOrder());  
        Integer product = 1;
        for(int i = 0; i<3 & i<= intList.size() - 1; i++){
            product *= intList.get(i);
        }
        String stringProduct = product.toString();
        return ("The highest product is: " + stringProduct);
    }

    public static void main(String[] args){
        // if user inputted command line arguments to create an integer list e.g. java test "1" "2" "3"
        if (Arrays.stream(args).count() != 0) {
            ArrayList<Integer> intList = new ArrayList<Integer>();
            int index = 0;
            for (String s : args) {
                Integer stringToInt = Integer.parseInt(s);
                intList.add(index, stringToInt);
                index++;
            }
            String product = findHighestProduct(intList);
            System.out.println(product);

        // if user did not input command line arguments
        } else {
            ArrayList<Integer> intList = new ArrayList<Integer>();
            Collections.addAll(intList, 1, 10, 2, 6, 5, 3);
            String product = findHighestProduct(intList);
            System.out.println(product);
        }
    }
}

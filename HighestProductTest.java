
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

    /*
    This file tests the findHighestProduct() function that is contained in the HighestProduct
    file against different inputs using JUnit.
     */
    public class HighestProductTest {

        @Test
        void testEmptyList(){
            ArrayList<Integer> intList = new ArrayList<Integer>();
            Assertions.assertEquals("empty list", HighestProduct.findHighestProduct(intList));
        }

        @Test
        void sortedInput(){
            ArrayList<Integer> intList = new ArrayList<Integer>();
            Collections.addAll(intList, 40, 30, 20);
            Assertions.assertEquals("The highest product is: 24000", HighestProduct.findHighestProduct(intList));
        }

        @ParameterizedTest
        @MethodSource("generator")
        void unsortedInput(String expected, ArrayList<Integer> intList){
            Assertions.assertEquals(expected, HighestProduct.findHighestProduct(intList));
        }

        @Test
        void moreThanThreeElements(){
            ArrayList<Integer> intList = new ArrayList<Integer>();
            Collections.addAll(intList, 1, 10, 2, 6, 5, 3);
            Assertions.assertEquals("The highest product is: 300", HighestProduct.findHighestProduct(intList));
        }

        @Test
        void lessThanThreeElements(){
            ArrayList<Integer> intList = new ArrayList<Integer>();
            Collections.addAll(intList, 1, 10);
            String result = HighestProduct.findHighestProduct(intList);
            Assertions.assertEquals("The highest product is: 10", result);
        }

        private static Stream<Arguments> generator() {
            ArrayList<Integer> intList1 = new ArrayList<Integer>();
            Collections.addAll(intList1, 1, 10, 2);

            ArrayList<Integer> intList2 = new ArrayList<Integer>();
            Collections.addAll(intList2, 0, 0, 0);

            ArrayList<Integer> intList3 = new ArrayList<Integer>();
            Collections.addAll(intList3, 10, 10, 10);
            return Stream.of(Arguments.of("The highest product is: 20",  intList1),
                    Arguments.of("The highest product is: 0",  intList2),
                    Arguments.of("The highest product is: 1000",  intList3)
            );
        }

    }
///Jordan Lillis
///C00204110
///04/03/2019
///Verification Project Task 3

package cm;


import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LillisJordanTestTask3 {

    private  BigDecimal normalRate;
    private  BigDecimal reducedRate;
    private ArrayList<Period> normalPeriod;
    private ArrayList<Period> reducedPeriod;

    @Before
    public void setUp() throws Exception {
      normalRate = new BigDecimal("10");
        reducedRate = new BigDecimal("6");
       normalPeriod = new ArrayList<Period>(Arrays.asList(new Period(1,2)));
      reducedPeriod = new ArrayList<Period>(Arrays.asList(new Period(4,5)));
    }

    @Test
    public void test_1_all_normal(){
        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }

    @Test
    public void test_2_normalRate_0(){
         normalRate = new BigDecimal("0");
         reducedRate = normalRate;

        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_2a_less_than_reduced(){
        normalRate = new BigDecimal("1");
        reducedRate = new BigDecimal("2");
        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }

    @Test
    public void test_3_reducedRate_0(){
        BigDecimal reducedRate = new BigDecimal("0");
        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }

    @Test
    public void test_4_reducedPeriod_start_0(){
        reducedPeriod = new ArrayList<Period>(Arrays.asList(new Period(0,3)));
        normalPeriod = new ArrayList<Period>(Arrays.asList(new Period(11,12)));
        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }

    @Test
    public void test_5_normalPeriod_start_0(){
         normalPeriod = new ArrayList<Period>(Arrays.asList(new Period(0,5)));
         reducedPeriod = new ArrayList<Period>(Arrays.asList(new Period(6,7)));
        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_5_reducedRate_less_than_0(){
        BigDecimal reducedRate = new BigDecimal("-1");
        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_6_normalRate_less_than_0(){
        BigDecimal normalRate = new BigDecimal("-1");
        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_7_reducedPeriod_start_less_than_0(){
        reducedPeriod = new ArrayList<Period>(Arrays.asList(new Period(-1,5)));
        normalPeriod = new ArrayList<Period>(Arrays.asList(new Period(6,8)));
        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_8_normalPeriod_start_less_than_0(){
          reducedPeriod = new ArrayList<Period>(Arrays.asList(new Period(-1,5)));
         normalPeriod = new ArrayList<Period>(Arrays.asList(new Period(6,8)));
        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_9_periods_overlap(){
        reducedPeriod = new ArrayList<Period>(Arrays.asList(new Period(1,5), new Period(9,10)));
        normalPeriod = new ArrayList<Period>(Arrays.asList(new Period(4,8)));
        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_10_reduced_overlap(){
      reducedPeriod = new ArrayList<Period>(Arrays.asList(new Period(1,3), new Period(2,4)));
         normalPeriod = new ArrayList<Period>(Arrays.asList(new Period(5,8)));
        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }


    @Test(expected = IllegalArgumentException.class)
    public void test_11_normal_periods_overlap(){
         reducedPeriod = new ArrayList<Period>(Arrays.asList(new Period(1,5)));
          normalPeriod = new ArrayList<Period>(Arrays.asList(new Period(6,8), new Period(7,9), new Period(11,12)));
        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriod, normalPeriod);
    }


    @Test
    public void test_12_calculate_correct(){
         reducedPeriod = new ArrayList<Period>(Arrays.asList(new Period(1,5)));
         normalPeriod = new ArrayList<Period>(Arrays.asList( new Period(7,9)));
        Rate theRate = new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriod, normalPeriod);
        assertEquals(theRate.calculate(new Period(4,8)),new BigDecimal("4.00"));
    }

    @Test
    public void test_13_calculate_free(){
         reducedPeriod = new ArrayList<Period>(Arrays.asList(new Period(1,5)));
         normalPeriod = new ArrayList<Period>(Arrays.asList( new Period(7,9)));
        Rate theRate = new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriod, normalPeriod);
        assertEquals(theRate.calculate(new Period(11,18)),new BigDecimal("0.00"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_14_null_normalRate(){
        new Rate(CarParkKind.VISITOR, null, reducedRate, reducedPeriod, normalPeriod);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_15_null_reducedRate(){
        new Rate(CarParkKind.VISITOR, normalRate, null, reducedPeriod, normalPeriod);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_16_null_normalPeriod(){
        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriod, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_17_null_reducedPeriod(){
        new Rate(CarParkKind.VISITOR, normalRate, reducedRate, null, normalPeriod);
    }


    @Test
    public void test_18_calculate_visitor_free_til_8euro(){
        reducedPeriod = new ArrayList<Period>(Arrays.asList(new Period(1,5)));
        normalPeriod = new ArrayList<Period>(Arrays.asList( new Period(7,9)));
        normalRate = new BigDecimal("4");
        reducedRate = new BigDecimal("0");
        Rate theRate = new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriod, normalPeriod);
        assertEquals(theRate.calculate(new Period(7,9)),new BigDecimal("0.00"));
    }


    @Test
    public void test_19_calculate_visitor_discount_after_8_euro_at_normal_rate(){
        reducedPeriod = new ArrayList<Period>(Arrays.asList(new Period(1,5)));
        normalPeriod = new ArrayList<Period>(Arrays.asList( new Period(7,11)));
        normalRate = new BigDecimal("4");
        reducedRate = new BigDecimal("2");
        Rate theRate = new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriod, normalPeriod);
        assertEquals(theRate.calculate(new Period(7,11)),new BigDecimal("4.00"));
    }


    @Test
    public void test_20_calculate_visitor_discount_after_8_euro_at_reduced_rate(){
        reducedPeriod = new ArrayList<Period>(Arrays.asList(new Period(1,5)));
        normalPeriod = new ArrayList<Period>(Arrays.asList( new Period(7,11)));
        reducedRate = new BigDecimal("4");
        Rate theRate = new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriod, normalPeriod);
        assertEquals(theRate.calculate(new Period(1,5)),new BigDecimal("4.00"));
    }

    @Test
    public void test_21_calculate_visitor_discount_after_8_euro_with_both_rates(){
        reducedPeriod = new ArrayList<Period>(Arrays.asList(new Period(1,7)));
        normalPeriod = new ArrayList<Period>(Arrays.asList( new Period(7,11)));
        reducedRate = new BigDecimal("4");
        normalRate = new BigDecimal("8");
        Rate theRate = new Rate(CarParkKind.VISITOR, normalRate, reducedRate, reducedPeriod, normalPeriod);
        assertEquals(theRate.calculate(new Period(5,9)),new BigDecimal("8.00"));
    }

    @Test
    public void test_22_calculate_management_min_charge_3_euro_reducedRate(){
        reducedPeriod = new ArrayList<Period>(Arrays.asList(new Period(1,7)));
        normalPeriod = new ArrayList<Period>(Arrays.asList( new Period(7,11)));
        reducedRate = new BigDecimal("1");
        normalRate = new BigDecimal("8");
        Rate theRate = new Rate(CarParkKind.MANAGEMENT, normalRate, reducedRate, reducedPeriod, normalPeriod);
        assertEquals(theRate.calculate(new Period(2,3)),new BigDecimal("3.00"));
    }

    @Test
    public void test_23_calculate_management_min_charge_3_euro_normalRate(){
        reducedPeriod = new ArrayList<Period>(Arrays.asList(new Period(1,7)));
        normalPeriod = new ArrayList<Period>(Arrays.asList( new Period(7,11)));
        reducedRate = new BigDecimal("1");
        normalRate = new BigDecimal("2");
        Rate theRate = new Rate(CarParkKind.MANAGEMENT, normalRate, reducedRate, reducedPeriod, normalPeriod);
        assertEquals(theRate.calculate(new Period(8,9)),new BigDecimal("3.00"));
    }


    @Test
    public void test_24_calculate_management_min_charge_3_euro_free_period(){
        reducedPeriod = new ArrayList<Period>(Arrays.asList(new Period(1,7)));
        normalPeriod = new ArrayList<Period>(Arrays.asList( new Period(7,11)));
        reducedRate = new BigDecimal("1");
        normalRate = new BigDecimal("2");
        Rate theRate = new Rate(CarParkKind.MANAGEMENT, normalRate, reducedRate, reducedPeriod, normalPeriod);
        assertEquals(theRate.calculate(new Period(12,14)),new BigDecimal("3.00"));
    }


    @Test
    public void test_25_calculate_management_min_charge_3_euro_all_periods(){
        reducedPeriod = new ArrayList<Period>(Arrays.asList(new Period(1,6)));
        normalPeriod = new ArrayList<Period>(Arrays.asList( new Period(7,11)));
        reducedRate = new BigDecimal("1");
        normalRate = new BigDecimal("1");
        Rate theRate = new Rate(CarParkKind.MANAGEMENT, normalRate, reducedRate, reducedPeriod, normalPeriod);
        assertEquals(theRate.calculate(new Period(5,8)),new BigDecimal("3.00"));
    }

    @Test
    public void test_26_calculate_student_reduction_normal_period(){
        reducedPeriod = new ArrayList<Period>(Arrays.asList(new Period(1,6)));
        normalPeriod = new ArrayList<Period>(Arrays.asList( new Period(7,11)));
        reducedRate = new BigDecimal("1");
        normalRate = new BigDecimal("5");
        Rate theRate = new Rate(CarParkKind.STUDENT, normalRate, reducedRate, reducedPeriod, normalPeriod);
        assertEquals(theRate.calculate(new Period(8,10)),new BigDecimal("8.88"));
    }


    @Test
    public void test_27_calculate_student_reduction_applied_reduced_period(){
        reducedPeriod = new ArrayList<Period>(Arrays.asList(new Period(1,6)));
        normalPeriod = new ArrayList<Period>(Arrays.asList( new Period(7,11)));
        reducedRate = new BigDecimal("3");
        normalRate = new BigDecimal("5");
        Rate theRate = new Rate(CarParkKind.STUDENT, normalRate, reducedRate, reducedPeriod, normalPeriod);
        assertEquals(theRate.calculate(new Period(2,5)),new BigDecimal("8.13"));
    }

    @Test
    public void test_28_calculate_student_reduction_all_periods(){
        reducedPeriod = new ArrayList<Period>(Arrays.asList(new Period(1,6)));
        normalPeriod = new ArrayList<Period>(Arrays.asList( new Period(7,11)));
        reducedRate = new BigDecimal("3");
        normalRate = new BigDecimal("5");
        Rate theRate = new Rate(CarParkKind.STUDENT, normalRate, reducedRate, reducedPeriod, normalPeriod);
        assertEquals(theRate.calculate(new Period(4,8)),new BigDecimal("9.63"));
    }

    @Test
    public void test_28_calculate_student_no_reduction_not_under_limit(){
        reducedPeriod = new ArrayList<Period>(Arrays.asList(new Period(1,6)));
        normalPeriod = new ArrayList<Period>(Arrays.asList( new Period(7,11)));
        reducedRate = new BigDecimal("3");
        normalRate = new BigDecimal("5");
        Rate theRate = new Rate(CarParkKind.STUDENT, normalRate, reducedRate, reducedPeriod, normalPeriod);
        assertEquals(theRate.calculate(new Period(2,3)),new BigDecimal("3.00"));
    }


    @Test
    public void test_29_calculate_staff_max_limit(){
        reducedPeriod = new ArrayList<Period>(Arrays.asList(new Period(1,6)));
        normalPeriod = new ArrayList<Period>(Arrays.asList( new Period(7,11)));
        reducedRate = new BigDecimal("3");
        normalRate = new BigDecimal("5");
        Rate theRate = new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
        assertEquals(theRate.calculate(new Period(2,23)),new BigDecimal("16.00"));
    }

    @Test
    public void test_30_calculate_staff_calculates_correctly_under_max(){
        reducedPeriod = new ArrayList<Period>(Arrays.asList(new Period(1,6)));
        normalPeriod = new ArrayList<Period>(Arrays.asList( new Period(7,11)));
        reducedRate = new BigDecimal("3");
        normalRate = new BigDecimal("5");
        Rate theRate = new Rate(CarParkKind.STAFF, normalRate, reducedRate, reducedPeriod, normalPeriod);
        assertEquals(theRate.calculate(new Period(5,8)),new BigDecimal("8.00"));
    }

    @Test
    public void test_31_calculate_management_min_charge_3_euro_normalRate(){
        reducedPeriod = new ArrayList<Period>(Arrays.asList(new Period(1,7)));
        normalPeriod = new ArrayList<Period>(Arrays.asList( new Period(7,11)));
        reducedRate = new BigDecimal("1");
        normalRate = new BigDecimal("2");
        Rate theRate = new Rate(CarParkKind.MANAGEMENT, normalRate, reducedRate, reducedPeriod, normalPeriod);
        assertEquals(theRate.calculate(new Period(8,11)),new BigDecimal("6.00"));
    }
}
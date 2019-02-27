package cm;
///Written by Jordan Lillis C00204110
///Verification project stage 2
///24/02/2019

import static org.junit.Assert.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.Test;



public class LillisJordanTestTask2 {

    @Test
    public void successTest() {
        Period a,b ;
        b = new Period(0,6) ;
        a = new Period(7,23) ;
        ArrayList<Period> n = new ArrayList<Period>() ,r = new ArrayList<Period>();
        n.add(a);
        r.add(b);
        CarParkKind kind= CarParkKind.VISITOR ;
        BigDecimal normal = new BigDecimal(1),reduced = new BigDecimal(2);
        Rate testValue = new Rate(kind,normal,reduced,r,n);
        assertEquals(Rate.calculate(a).add(Rate.calculate(b)) ,30.0);
    }
    @Test
    public void reducedRateDecimalTest() {
        Period a,b ;
        b = new Period(0,6) ;
        a = new Period(7,23) ;
        ArrayList<Period> n = new ArrayList<Period>() ,r = new ArrayList<Period>();
        n.add(a);
        r.add(b);
        CarParkKind kind= CarParkKind.MANAGEMENT  ;
        BigDecimal normal = new BigDecimal(1) ,reduced = new BigDecimal(0.1);
        Rate testValue = new Rate(kind,normal,reduced,r,n);
        assertEquals(Rate.calculate(a).add(Rate.calculate(b)) ,18.6);
    }
    @Test
    public void normalRateDecimalTest() {
        Period a,b ;
        b = new Period(0,6) ;
        a = new Period(7,23) ;
        ArrayList<Period> n = new ArrayList<Period>() ,r = new ArrayList<Period>();
        n.add(a);
        r.add(b);
        CarParkKind kind= CarParkKind.VISITOR ;
        BigDecimal normal = new BigDecimal(0.1) ,reduced = new BigDecimal(1);
        Rate testValue = new Rate(kind,normal,reduced,r,n);
        assertEquals(Rate.calculate(a).add(Rate.calculate(b)) ,18.6);
    }
    @Test
    public void reducedRateNegativeDecimalTest() {
        Period a,b ;
        b = new Period(0,6) ;
        a = new Period(7,23) ;
        ArrayList<Period> n = new ArrayList<Period>() ,r = new ArrayList<Period>();
        n.add(a);
        r.add(b);
        CarParkKind kind= CarParkKind.STAFF ;
        BigDecimal normal = new BigDecimal(1) ,reduced = new BigDecimal(-0.1);
        Rate testValue = new Rate(kind,normal,reduced,r,n);
        assertEquals(Rate.calculate(a).add(Rate.calculate(b)) , new IllegalArgumentException() );
    }
    @Test
    public void normalRateNegativeDecimalTest() {
        Period a,b ;
        b = new Period(0,6) ;
        a = new Period(7,23) ;
        ArrayList<Period> n = new ArrayList<Period>() ,r = new ArrayList<Period>();
        n.add(a);
        r.add(b);
        CarParkKind kind= CarParkKind.STUDENT ;
        BigDecimal normal = new BigDecimal(-0.1) ,reduced = new BigDecimal(1);
        Rate testValue = new Rate(kind,normal,reduced,r,n);
        assertEquals(Rate.calculate(a).add(Rate.calculate(b)) ,new IllegalArgumentException());
    }
    @Test
    public void doubleZeroTest() {
        Period a,b ;
        b = new Period(0,6) ;
        a = new Period(7,23) ;
        ArrayList<Period> n = new ArrayList<Period>() ,r = new ArrayList<Period>();
        n.add(a);
        r.add(b);
        CarParkKind kind= CarParkKind.STAFF ;
        BigDecimal normal = new BigDecimal(0) ,reduced = new BigDecimal(0);
        Rate testValue = new Rate(kind,normal,reduced,r,n);
        assertEquals(Rate.calculate(a).add(Rate.calculate(b)) ,0);
    }
    @Test
    public void postiveNormalZeroReducedTest() {
        Period a,b ;
        b = new Period(0,6) ;
        a = new Period(7,23) ;
        ArrayList<Period> n = new ArrayList<Period>() ,r = new ArrayList<Period>();
        n.add(a);
        r.add(b);
        CarParkKind kind= CarParkKind.VISITOR ;
        BigDecimal normal = new BigDecimal(1) ,reduced = new BigDecimal(0);
        Rate testValue = new Rate(kind,normal,reduced,r,n);
        assertEquals(Rate.calculate(a).add(Rate.calculate(b)) ,6);
    }
    @Test
    public void zeroNormalPositiveReducedTest() {
        Period a,b ;
        b = new Period(0,6) ;
        a = new Period(7,23) ;
        ArrayList<Period> n = new ArrayList<Period>() ,r = new ArrayList<Period>();
        n.add(a);
        r.add(b);
        CarParkKind kind= CarParkKind.STAFF ;
        BigDecimal normal = new BigDecimal(0) ,reduced = new BigDecimal(1);
        Rate testValue = new Rate(kind,normal,reduced,r,n);
        assertEquals(Rate.calculate(a).add(Rate.calculate(b)) ,18);
    }
    @Test
    public void reducedRateNegativeTest() {
        Period a,b ;
        b = new Period(0,6) ;
        a = new Period(7,23) ;
        ArrayList<Period> n = new ArrayList<Period>() ,r = new ArrayList<Period>();
        n.add(a);
        r.add(b);
        CarParkKind kind= CarParkKind.STUDENT ;
        BigDecimal normal = new BigDecimal(1) ,reduced = new BigDecimal(-1);
        Rate testValue = new Rate(kind,normal,reduced,r,n);
        assertEquals(Rate.calculate(a).add(Rate.calculate(b)) , new IllegalArgumentException() );
    }
    @Test
    public void normalRateNegativeTest() {
        Period a,b ;
        b = new Period(0,6) ;
        a = new Period(7,23) ;
        ArrayList<Period> n = new ArrayList<Period>() ,r = new ArrayList<Period>();
        n.add(a);
        r.add(b);
        CarParkKind kind= CarParkKind.MANAGEMENT ;
        BigDecimal normal = new BigDecimal(-1) ,reduced = new BigDecimal(1);
        Rate testValue = new Rate(kind,normal,reduced,r,n);
        assertEquals(Rate.calculate(a).add(Rate.calculate(b)) ,new IllegalArgumentException());
    }
    @Test
    public void wholeNormalRateDecimalReducedTest() {
        Period a,b ;
        b = new Period(0,6) ;
        a = new Period(7,23) ;
        ArrayList<Period> n = new ArrayList<Period>() ,r = new ArrayList<Period>();
        n.add(a);
        r.add(b);
        CarParkKind kind= CarParkKind.STAFF ;
        BigDecimal normal = new BigDecimal(1.5) ,reduced = new BigDecimal(2);
        Rate testValue = new Rate(kind,normal,reduced,r,n);
        assertEquals(Rate.calculate(a).add(Rate.calculate(b)) ,39.0);
    }
    @Test
    public void decimalNormalRateWholeReducedTest() {
        Period a,b ;
        b = new Period(0,6) ;
        a = new Period(7,23) ;
        ArrayList<Period> n = new ArrayList<Period>() ,r = new ArrayList<Period>();
        n.add(a);
        r.add(b);
        CarParkKind kind= CarParkKind.VISITOR ;
        BigDecimal normal = new BigDecimal(1) ,reduced = new BigDecimal(2.7);
        Rate testValue = new Rate(kind,normal,reduced,r,n);
        assertEquals(Rate.calculate(a).add(Rate.calculate(b)) ,34.2);
    }
    @Test
    public void overlapReducedRateTest() {
        Period a,b ;
        b = new Period(0,6) ;
        a = new Period(3,5) ;
        ArrayList<Period> n = new ArrayList<Period>() ,r = new ArrayList<Period>();
        n.add(a);
        r.add(b);
        CarParkKind kind= CarParkKind.STAFF ;
        BigDecimal normal = new BigDecimal(1),reduced = new BigDecimal(2);
        Rate testValue = new Rate(kind,normal,reduced,r,n);
        assertEquals(Rate.calculate(a).add(Rate.calculate(b)) ,new IllegalArgumentException());
    }
    @Test
    public void overlapNormalRateTest() {
        Period a,b ;
        b = new Period(3,5) ;
        a = new Period(0,6) ;
        ArrayList<Period> n = new ArrayList<Period>() ,r = new ArrayList<Period>();
        n.add(a);
        r.add(b);
        CarParkKind kind= CarParkKind.STUDENT ;
        BigDecimal normal = new BigDecimal(1),reduced = new BigDecimal(99);
        Rate testValue = new Rate(kind,normal,reduced,r,n);
        assertEquals(Rate.calculate(a).add(Rate.calculate(b)) ,new IllegalArgumentException());
    }
    @Test
    public void nullTypeTest() {
        Period a,b ;
        b = new Period(0,6) ;
        a = new Period(7,23) ;
        ArrayList<Period> n = new ArrayList<Period>() ,r = new ArrayList<Period>();
        n.add(a);
        r.add(b);
        CarParkKind kind= null ;
        BigDecimal normal = new BigDecimal(1),reduced = new BigDecimal(2);
        Rate testValue = new Rate(kind,normal,reduced,r,n);
        assertEquals(Rate.calculate(a).add(Rate.calculate(b)) ,new IllegalArgumentException());
    }
    @Test
    public void nullNormalPeriodsTest() {
        Period a,b ;
        b = new Period(0,6) ;
        a = new Period(7,23) ;
        ArrayList<Period> n = new ArrayList<Period>() ,r = new ArrayList<Period>();
        n.add(null);
        r.add(b);
        CarParkKind kind= null ;
        BigDecimal normal = new BigDecimal(1),reduced = new BigDecimal(2);
        Rate testValue = new Rate(kind,normal,reduced,r,n);
        assertEquals(Rate.calculate(a).add(Rate.calculate(b)) ,new IllegalArgumentException());
    }
    @Test
    public void nullReducedPeriodsTest() {
        Period a,b ;
        b = new Period(0,6) ;
        a = new Period(7,23) ;
        ArrayList<Period> n = new ArrayList<Period>() ,r = new ArrayList<Period>();
        n.add(a);
        r.add(null);
        CarParkKind kind= null ;
        BigDecimal normal = new BigDecimal(1),reduced = new BigDecimal(2);
        Rate testValue = new Rate(kind,normal,reduced,r,n);
        assertEquals(Rate.calculate(a).add(Rate.calculate(b)) ,new IllegalArgumentException());
    }
    @Test
    public void nullReducedRateTest() {
        Period a,b ;
        b = new Period(0,6) ;
        a = new Period(7,23) ;
        ArrayList<Period> n = new ArrayList<Period>() ,r = new ArrayList<Period>();
        n.add(a);
        r.add(null);
        CarParkKind kind= null ;
        BigDecimal normal = new BigDecimal(1),reduced = null;
        Rate testValue = new Rate(kind,normal,reduced,r,n);
        assertEquals(Rate.calculate(a).add(Rate.calculate(b)) ,new IllegalArgumentException());
    }
    @Test
    public void nullNormalRateTest() {
        Period a,b ;
        b = new Period(0,6) ;
        a = new Period(7,23) ;
        ArrayList<Period> n = new ArrayList<Period>() ,r = new ArrayList<Period>();
        n.add(a);
        r.add(null);
        CarParkKind kind= null ;
        BigDecimal normal = null,reduced = new BigDecimal(1);
        Rate testValue = new Rate(kind,normal,reduced,r,n);
        assertEquals(Rate.calculate(a).add(Rate.calculate(b)) ,new IllegalArgumentException());
    }
    @Test
    public void freePeriodTest() {
        Period a,b ;
        b = new Period(0,1) ;
        a = new Period(22,23) ;
        ArrayList<Period> n = new ArrayList<Period>() ,r = new ArrayList<Period>();
        n.add(a);
        r.add(b);
        CarParkKind kind= CarParkKind.MANAGEMENT ;
        BigDecimal normal = new BigDecimal(3),reduced = new BigDecimal(5);
        Rate testValue = new Rate(kind,normal,reduced,r,n);
        assertEquals(Rate.calculate(a).add(Rate.calculate(b)) ,8);
    }
}

package org.multi.projects.jdk;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BigDecimalTest {

    @Test
    public void test() {
        BigDecimal d1 = new BigDecimal("1535345346346546457567568678679789780897824325235235252.23");
        BigDecimal d2 = new BigDecimal("1634645645756856878969867967978235435435634645645756856856858758568585686585.23");

        BigDecimal result = d1.add(d2);
        System.out.println(result.toString());
    }
}

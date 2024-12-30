package org.multi.projects.netty;

import org.junit.jupiter.api.Test;

import java.security.AccessController;
import java.security.PrivilegedAction;

public class SecurityManagerTest {
    private static final String PASSWORD = "password";

    @Test
    public void testSecurityManager() {
        if (System.getSecurityManager() == null) {
            System.getProperty(PASSWORD, "test-security-manager");
        } else {
            AccessController.doPrivileged(new PrivilegedAction<String>() {
                @Override
                public String run() {
                    return System.getProperty(PASSWORD, "test-security-manager");
                }
            });
        }
    }
}

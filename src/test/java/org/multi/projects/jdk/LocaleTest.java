package org.multi.projects.jdk;

import org.junit.jupiter.api.Test;

import java.util.Locale;

public class LocaleTest {

    @Test
    public void test() {
        Locale localeUS = Locale.of("en", "US");
        Locale localeCN = Locale.of("zh", "CN");

        System.out.println("LocaleUS 显示名称: " + localeUS.getDisplayName());
        System.out.println("LocaleCN 显示名称: " + localeCN.getDisplayName());

        System.out.println("LocaleUS 显示语言: " + localeUS.getDisplayLanguage());
        System.out.println("LocaleCN 显示语言: " + localeCN.getDisplayLanguage());

        System.out.println("LocaleUS 显示国家/地区: " + localeUS.getDisplayCountry());
        System.out.println("LocaleCN 显示国家/地区: " + localeCN.getDisplayCountry());
    }
}

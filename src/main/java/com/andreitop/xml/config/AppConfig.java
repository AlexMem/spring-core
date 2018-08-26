package com.andreitop.xml.config;

import com.andreitop.xml.mount.*;
import com.andreitop.xml.unit.*;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Configuration
@ComponentScan(basePackages = "com.andreitop.xml")
public class AppConfig {

    @Bean
    public Mount frostWolf() {
        return new Wolf();
    }

    @Bean
    public Mount shadowTiger() {
        return new Tiger();
    }

    @Bean
    public Unit knight() {
        return new Human(shadowTiger(), "thunderFury", "soulBlade");
    }

    @Bean
    public Unit trall() {
        Orc orc = new Orc(frostWolf());
        orc.setWeapon("furryAxe");
        orc.setColorCode(9);
        return orc;
    }

    @Bean
    public SimpleDateFormat dateFormatter() {
        return new SimpleDateFormat("dd-mm-yyyy");
    }

    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setLocation(new ClassPathResource("config/heroes.properties"));
        return configurer;
    }

    @Bean
    public Map<String, Mount> trollMountMap() {
        Map<String, Mount> map = new HashMap<>();
        map.put("m1", frostWolf());
        map.put("m2", shadowTiger());
        return map;
    }

    @Bean
    public Set<Mount> trollMountSet() {
        Set<Mount> set = new HashSet<>();
        set.add(shadowTiger());
        set.add(frostWolf());
        return set;
    }

    @Bean
    public Unit zulJin() throws ParseException {
        Troll zulJin = new Troll();
        zulJin.setColorCode(ThreadLocalRandom.current().nextInt(1, 10));
        zulJin.setCreationDate(dateFormatter().parse("01-01-2004"));
        zulJin.setListOfMounts(Arrays.asList(Troll.DEFAULT_MOUNT, null, shadowTiger()));
        zulJin.setSetOfMounts(trollMountSet());
        zulJin.setMapOfMounts(trollMountMap());
        return zulJin;
    }
}

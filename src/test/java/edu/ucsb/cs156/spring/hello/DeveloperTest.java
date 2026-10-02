package edu.ucsb.cs156.spring.hello;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Christian", Developer.getName());
    }

    @Test 
    public void getGithubId_returns_correct_id() {
        assertEquals("csdiez-eng", Developer.getGithubId());
    }

    @Test 
    public void getTeam_returns_correct_team() {
        Team t = new Team("f26-01");
        t.addMember("CHRISTIAN SANTIAGO");
        t.addMember("OWEN");
        t.addMember("ANDREW BOYAO");
        t.addMember("JONATHAN ISAI");
        t.addMember("NATHAN YAN WEN");
        t.addMember("YIFAN");

        assertEquals(true, t.equals(Developer.getTeam()));
    }

}

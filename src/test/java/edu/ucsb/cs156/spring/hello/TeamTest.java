package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void equals_same_team() {
        Team t = new Team("test");
        assertEquals(true, t.equals(t));
    }

    @Test 
    public void equals_with_incorrect_type() {
        Team t1 = new Team("test1");
        String t2 = "test2";
        assertEquals(false, t1.equals(t2));
    }

    @Test
    public void equals_varying_attributes() {
        Team t1 = new Team("test1");
        Team t2 = new Team("test1");
        Team t3 = new Team("test2");

        assertEquals(true, t1.equals(t2));
        assertEquals(false, t1.equals(t3));

        t2.addMember("test_member");

        assertEquals(false, t1.equals(t2));
    }
   
    @Test 
    public void toString_returns_correct_string() {
        Team t = new Team("test");
        String t_str = "Team(name=" + t.name + ", members=" + t.members + ")";
        assertEquals(true, t.toString().equals(t_str));
    }

    @Test 
    public void hashCode_returns_correct_string() {
        Team t = new Team("test");
        t.members.add("test_member");
        int hash = "test".hashCode() | t.members.hashCode();
        assertEquals(true, t.hashCode() == hash);
    }

}

package util;

import org.junit.Test;

import static org.junit.Assert.*;

public class HelperTest {

    @Test
    public void TestSnake() {
        assertEquals("user_id", Helper.Snake("UserId"));
        assertEquals("user_id", Helper.Snake("user_id"));
        assertEquals("user_id", Helper.Snake("User_id"));
        assertEquals("user_id", Helper.Snake("User_id"));
        assertEquals("user_name_id", Helper.Snake("UserNameId"));
    }
}
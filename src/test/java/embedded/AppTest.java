package embedded;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest
{

    @Test
    public void testServerPort() throws Exception
    {
        assertEquals(App.getServer().getURI().getPort(), -1);
    }
}
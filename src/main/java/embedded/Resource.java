package embedded;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Path("servertime")
public class Resource
{

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String paramMethod()
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return "Current time is " + sdf.format(cal.getTime());
    }
}

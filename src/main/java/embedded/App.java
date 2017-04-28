package embedded;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class App
{
    private static final int PORT = 2017;
    private static final String PACKAGE_NAME = "embedded";
    private static final String PATH_SPEC = "/*";

    public static void main( String[] args )
    {
        Server server = getServer();

        try
        {
            server.start();
            server.join();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            server.destroy();
        }
    }

    public static Server getServer() {
        ResourceConfig config = new ResourceConfig();
        config.packages(PACKAGE_NAME);
        Server server = new Server(PORT);
        ServletContextHandler context = new ServletContextHandler(server, PATH_SPEC);
        ServletHolder servlet = new ServletHolder(new ServletContainer(config));
        context.addServlet(servlet, PATH_SPEC);
        return server;
    }
}

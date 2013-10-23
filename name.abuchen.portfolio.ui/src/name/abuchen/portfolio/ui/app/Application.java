package name.abuchen.portfolio.ui.app;

import java.util.Map;
import java.util.Properties;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

public class Application implements IApplication
{

    public Object start(IApplicationContext context)
    {
        Display display = PlatformUI.createDisplay();
        try
        {
          //look in the environment for proxy settings
            Map<String, String> env = System.getenv();
            String envValue = env.get("PROXYHOST");
            if (envValue != null) {
                Properties systemProperties = System.getProperties();
                systemProperties.setProperty("http.proxyHost", envValue);
                envValue = env.get("PROXYPORT");
                if (envValue != null)
                    systemProperties.setProperty("http.proxyPort", envValue);
            }
            int returnCode = PlatformUI.createAndRunWorkbench(display, new ApplicationWorkbenchAdvisor());
            if (returnCode == PlatformUI.RETURN_RESTART)
                return IApplication.EXIT_RESTART;
            else
                return IApplication.EXIT_OK;
        }
        finally
        {
            display.dispose();
        }

    }

    public void stop()
    {
        if (!PlatformUI.isWorkbenchRunning())
            return;
        final IWorkbench workbench = PlatformUI.getWorkbench();
        final Display display = workbench.getDisplay();
        display.syncExec(new Runnable()
        {
            public void run()
            {
                if (!display.isDisposed())
                    workbench.close();
            }
        });
    }
}

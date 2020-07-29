package core.environment;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.ServerSocket;

public class AppiumServer {

    private static AppiumDriverLocalService service;

    public static void startServer() {
        if (!checkIfServerIsRunning(4723)) {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("noReset", "false");

            AppiumServiceBuilder builder = new AppiumServiceBuilder();
            builder.withIPAddress("127.0.0.1");
            builder.usingPort(4723);
            builder.withCapabilities(cap);
            builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
            builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
            service = builder.build();
            service.start();

        }
    }

    public static void stopServer() {
        service.stop();
    }

    public static boolean checkIfServerIsRunning(int port) {

        boolean isServerRunning = false;
        java.net.ServerSocket serverSocket;
        try {
            serverSocket = new java.net.ServerSocket(port);
            serverSocket.close();
        } catch (java.io.IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        }
        return isServerRunning;
    }
}
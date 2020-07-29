package utilProperties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;


public class CMDExecution {

    public static void executeWithOutWait(String command) {
        try {
            CommandLine cmd = new CommandLine("cmd");
            cmd.addArgument("/c");
            cmd.addArgument(command);
            cmd.getExecutable();
            DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
            DefaultExecutor executor = new DefaultExecutor();
            executor.setExitValue(1);
            executor.execute(cmd, resultHandler);
        } catch (Exception e) {
            System.out.println("something happens");
        }
    }

    public static ArrayList<String> executeWithWait(String command) {
        ArrayList<String> allLines = new ArrayList<>();
        try {
            Runtime rt = Runtime.getRuntime();
            String command1 = new CommandLine(command).getExecutable();
            Process process = rt.exec(new String[]{"cmd.exe", "/c", command1});

            InputStream inputStream = process.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                allLines.add(line);
                if (line.contains("value="))

                    System.out.println(line);
            }
        } catch (IOException ex) {
            System.out.println("Validate the case the file can't be accessed (not enough permissions");
        } catch (Exception e) {
            System.out.println("something happens");
        }
        return allLines;

    }


}

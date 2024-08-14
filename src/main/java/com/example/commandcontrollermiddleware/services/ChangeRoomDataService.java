package com.example.commandcontrollermiddleware.services;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class ChangeRoomDataService implements ChangeRoomDataServiceInterface{

    public void compileAndRunChangeRoomData(
            String id, String name, String price, String checkedOut, String checkInDate, Model model) throws IOException, InterruptedException {

        String targetDir = "C:\\Users\\Ante\\Desktop\\Diplomski\\CheckInDemoVanilla";
        String batchFilePath = targetDir + "\\runCommand.bat";

        // Build the Java execution command
        StringBuilder commandBuilder = new StringBuilder("java -cp \"bin;C:\\Users\\Ante\\.gradle\\caches\\modules-2\\files-2.1\\mysql\\mysql-connector-java\\8.0.27\\f1da9f10a3de6348725a413304aab6d0aa04f923\\mysql-connector-java-8.0.27.jar\" org.hotelApp.ChangeRoomData");

        if (id != null) {
            commandBuilder.append(" id ").append(id);
        }
        if (name != null && !name.isEmpty()) {
            commandBuilder.append(" name ").append(name);
        }
        if (price != null && !price.isEmpty()) {
            commandBuilder.append(" price ").append(price);
        }
        if (checkedOut != null && !checkedOut.isEmpty()) {
            commandBuilder.append(" checkedOut ").append(checkedOut);
        }
        if (checkInDate != null && !checkInDate.isEmpty()) {
            commandBuilder.append(" checkInDate ").append(checkInDate);
        }

        String command = commandBuilder.toString();

        // Write the batch file
        try (FileWriter writer = new FileWriter(batchFilePath)) {
            writer.write("cd /d \"" + targetDir + "\"\n");
            writer.write("javac -d bin src\\main\\java\\org\\hotelApp\\Model\\*.java src\\main\\java\\org\\hotelApp\\Repos\\RepoImpl\\*.java src\\main\\java\\org\\hotelApp\\Repos\\RepoInterfaces\\*.java src\\main\\java\\org\\hotelApp\\*.java\n");
            writer.write(command + "\n");
        }

        // Execute the batch file
        Process process = Runtime.getRuntime().exec("cmd /c " + batchFilePath);
        String output = logProcessOutput(process);
        process.waitFor();

        model.addAttribute("result", output);
    }

    public String logProcessOutput(Process process) throws IOException, InterruptedException {
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        StringBuilder output = new StringBuilder();
        String line;

        // Read the output from the command
        while ((line = stdInput.readLine()) != null) {
            output.append(line).append("\n");
        }

        // Read any errors from the attempted command
        while ((line = stdError.readLine()) != null) {
            output.append(line).append("\n");
        }

        stdInput.close();
        stdError.close();
        process.waitFor();

        return output.toString();
    }
}

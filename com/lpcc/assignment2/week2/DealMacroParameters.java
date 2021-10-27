package com.lpcc.assignment2.week2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DealMacroParameters {
    private List<Map<String, Integer>> MNT = new ArrayList<>();
    private List<String> MDT = new ArrayList<>();
    private final Pattern macroPattern = Pattern.compile("(\\AMACRO)\\s+([a-zA-Z]+[0-9a-zA-Z]*)\\s*([&[A-Z]*,]*).*");


    private void codeScan(File inputCode) throws FileNotFoundException {
        Scanner scanner = new Scanner(inputCode);
        while (scanner.hasNextLine()) {
            String instruction = scanner.nextLine();     // one instruction
            Matcher macroMatcher = macroPattern.matcher(instruction);
            if (macroMatcher.find()) {
                String macroName = macroMatcher.group(2);
                String[] macroParameter = macroMatcher.group(3).split(",");
                List<String> macroLines = consumeMacro(scanner, macroParameter, macroName);
                MDT.addAll(macroLines);
                int mdtPointer = MDT.size() - macroLines.size();
                MNT.add(Map.of(macroName, mdtPointer));
            } else {
                try {
                    File file = new File("output.txt");
                    FileWriter fr = new FileWriter(file, true);
                    fr.write(instruction + "\n");
                    fr.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
        }
        scanner.close();
    }

    private List<String> consumeMacro(Scanner scanner, String[] parameterList, String macroName) {
        List<String> macroLines = new ArrayList<>();
        String macroNameParameter = macroName + ' ';
        for (String parameter : parameterList) {
            macroNameParameter += parameter;
        }
        macroLines.add(macroNameParameter);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String line2 = getParameterOpcode(line, parameterList);
            macroLines.add(line2);
            if (Objects.equals("MEND", line.strip())) {
                return macroLines;
            }
        }
        throw new RuntimeException("MEND not found for macro");
    }

    private String getParameterOpcode(String line, String[] parameterList) {
        String parameterOpcode = "";
        if (line.contains("&")) {
            //\s*([a-zA-Z0-9]+)\s+([&[A-Z]*]*),*([&[A-Z]*]*)?.*
            Pattern parameter = Pattern.compile("\\s*([a-zA-Z0-9]+)\\s+(&?[A-Z0-9]*),*\\s*(&?[A-Z0-9]*)?.*");
            Matcher matcher2 = parameter.matcher(line);
            if (matcher2.find()){
                int i = 1;
                while (!Objects.equals(matcher2.group(i), "")){
                    String group = matcher2.group(i);
                    if (group.contains("&")){
                        for(String x : parameterList){
                            if(Objects.equals(matcher2.group(i), x)){
                                int index = Arrays.asList(parameterList).indexOf(x);
                                String number = Integer.toString(index);
                                parameterOpcode += "#" + number;
                                parameterOpcode += " ";
                            }
                        }
                    }
                    else {
                        parameterOpcode += matcher2.group(i);
                        parameterOpcode += " ";
                    }
                    i += 1;
                    if (i > matcher2.groupCount()){
                        break;
                    }
                }
            }
        }
        else {
            return line;
        }
        return parameterOpcode;
    }

    public static void main(String[] args) throws IOException {

        File assemblyCodeFile = new File("/home/diksha/IdeaProjects/FifthSem/src/com/lpcc/assignment2/week2/input code.txt");
        DealMacroParameters phaseOne = new DealMacroParameters();
        phaseOne.codeScan(assemblyCodeFile);
        for(String line : phaseOne.MDT){
            System.out.println(line);
        }
        System.out.println(phaseOne.MNT);

    }
}

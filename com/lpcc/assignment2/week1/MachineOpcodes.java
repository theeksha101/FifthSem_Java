package com.lpcc.assignment2.week1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
emot = {1: {'STOP': 00, 'ADD': 1, 'SUB': 2, 'MULT': 3, 'MOVER': 4, 'MOVEM': 5, 'COMP': 6,
            'BC': 7, 'DIV': 8, 'READ': 9, 'PRINT': 10},
        2: {'DS': 1, 'DC': 2},
        3: {'START': 1, 'END': 2, 'ORIGIN': 3, 'EQU': 4, 'LTORG': 5},
        4: {'AREG': 1, 'BREG': 2, 'CREG': 3},
        5: {'EQ': 1, 'LT': 2, 'GT': 3, 'NE': 4, 'LE': 5, 'GE': 6, 'ANY': 7}}
 */

public class MachineOpcodes {

    public static final Map<String, Integer> _class = new HashMap<>();
    public static final Map<Integer, HashMap<String, Integer>> emot = new HashMap<>();
    public static String[][] statements = {{"STOP", "ADD", "SUB", "MULT", "MOVER", "MOVEM", "COMP", "BC", "DIV", "READ", "PRINT"},
            {"DS", "DC"},
            {"START", "END", "ORIGIN", "EQU", "LTORG"},
            {"AREG", "BREG", "CREG"},
            {"EQ", "LT", "GT", "NE", "LE", "GE", "ANY"},
    };

    public void generateEMOT() {
        int classNumber = 1;
        for (String[] statement : statements) {
            int opcode = 1;
            for (String string : statement) {
                _class.put(string, opcode);
                opcode += 1;
            }
        }
    }

}

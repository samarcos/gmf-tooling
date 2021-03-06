/*******************************************************************************
* Copyright (c) 2006 Eclipse.org
* 
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*******************************************************************************/
package org.eclipse.gmf.internal.xpand.xtend.parser;

public class XtendKWLexerprs implements lpg.lpgjavaruntime.ParseTable, XtendKWLexersym {

    public interface IsKeyword {
        public final static byte isKeyword[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0
        };
    };
    public final static byte isKeyword[] = IsKeyword.isKeyword;
    public final boolean isKeyword(int index) { return isKeyword[index] != 0; }

    public interface BaseCheck {
        public final static byte baseCheck[] = {0,
            4,4,5,3,3,6,4,7,7,3,
            4,10,6,6,9,7,6,6,10,6,
            9,8,7,6,6,4,9
        };
    };
    public final static byte baseCheck[] = BaseCheck.baseCheck;
    public final int baseCheck(int index) { return baseCheck[index]; }
    public final static byte rhs[] = baseCheck;
    public final int rhs(int index) { return rhs[index]; };

    public interface BaseAction {
        public final static char baseAction[] = {
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,30,
            35,45,51,49,52,55,56,62,64,54,
            70,15,10,72,27,25,19,58,66,74,
            37,39,75,76,81,82,84,85,88,42,
            90,92,96,95,99,100,104,105,106,108,
            109,110,113,114,115,118,122,121,127,40,
            123,130,131,133,140,142,136,144,145,146,
            152,148,155,150,156,157,8,159,161,166,
            164,168,162,177,180,182,178,185,171,186,
            188,189,190,192,193,195,198,206,201,209,
            212,196,214,216,204,217,218,221,225,223,
            227,229,231,232,233,234,240,241,244,245,
            246,250,251,254,260,253,257,262,263,265,
            264,266,267,155,155
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,0,8,0,
            1,11,12,6,0,15,16,17,0,1,
            20,7,8,9,0,7,0,27,19,29,
            30,13,8,7,0,9,0,1,0,0,
            2,0,3,5,0,4,7,6,0,25,
            0,0,1,0,0,0,8,0,22,15,
            10,0,7,0,1,0,5,33,14,0,
            1,0,1,0,0,0,23,3,5,4,
            0,0,2,0,0,1,21,0,31,0,
            3,0,3,12,0,0,5,2,0,0,
            17,3,8,0,0,0,2,0,0,0,
            3,12,0,0,0,1,13,0,1,10,
            0,0,0,3,19,4,0,14,2,0,
            0,9,0,3,26,0,24,2,9,0,
            1,0,1,0,0,0,1,0,4,0,
            18,0,1,10,0,0,0,3,0,10,
            0,0,2,0,9,0,1,0,12,11,
            0,8,5,3,13,28,0,0,2,0,
            1,0,1,6,0,0,1,0,0,0,
            6,0,0,2,0,0,2,0,3,7,
            0,4,14,0,15,0,6,20,0,4,
            2,0,1,0,1,0,0,0,2,16,
            0,6,0,3,0,1,0,5,0,1,
            0,0,0,0,2,18,5,4,8,0,
            0,2,2,0,0,0,3,21,4,0,
            0,2,0,0,2,10,0,7,5,0,
            1,0,0,0,0,0,0,4,2,7,
            6,0,11,0,0,0,11,0,0,0,
            0,0,0,0,0,0,0,0,32,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            155,35,45,43,42,39,41,155,34,155,
            60,46,33,115,155,37,40,44,155,68,
            38,58,57,59,155,67,155,36,61,31,
            32,69,66,63,155,64,155,73,155,155,
            75,155,101,76,155,84,100,83,155,65,
            155,155,50,155,155,155,49,155,74,47,
            48,155,52,155,54,155,53,154,51,155,
            56,155,62,155,155,155,55,77,72,78,
            155,155,165,155,155,81,71,155,70,155,
            82,155,85,79,155,155,86,160,155,155,
            80,88,87,155,155,155,91,155,155,155,
            92,89,155,155,155,96,90,155,97,181,
            155,155,155,99,159,98,155,95,166,155,
            155,102,155,104,93,155,94,107,103,155,
            162,155,106,155,155,155,110,155,109,155,
            105,155,157,108,155,155,155,156,155,112,
            155,155,117,155,113,155,118,155,114,116,
            155,119,120,127,121,111,155,155,122,155,
            123,155,124,125,155,155,158,155,155,155,
            126,155,155,131,155,155,173,155,136,132,
            155,133,129,155,130,155,134,128,155,169,
            175,155,135,155,179,155,155,155,172,180,
            155,137,155,168,155,138,155,139,155,178,
            155,155,155,155,143,161,142,164,141,155,
            155,163,171,155,155,155,144,140,145,155,
            155,177,155,155,150,146,155,147,148,155,
            149,155,155,155,155,155,155,170,174,151,
            152,155,176,155,155,155,167,155,155,155,
            155,155,155,155,155,155,155,155,182
        };
    };
    public final static char termAction[] = TermAction.termAction;
    public final int termAction(int index) { return termAction[index]; }
    public final int asb(int index) { return 0; }
    public final int asr(int index) { return 0; }
    public final int nasb(int index) { return 0; }
    public final int nasr(int index) { return 0; }
    public final int terminalIndex(int index) { return 0; }
    public final int nonterminalIndex(int index) { return 0; }
    public final int scopePrefix(int index) { return 0;}
    public final int scopeSuffix(int index) { return 0;}
    public final int scopeLhs(int index) { return 0;}
    public final int scopeLa(int index) { return 0;}
    public final int scopeStateSet(int index) { return 0;}
    public final int scopeRhs(int index) { return 0;}
    public final int scopeState(int index) { return 0;}
    public final int inSymb(int index) { return 0;}
    public final String name(int index) { return null; }
    public final int getErrorSymbol() { return 0; }
    public final int getScopeUbound() { return 0; }
    public final int getScopeSize() { return 0; }
    public final int getMaxNameLength() { return 0; }

    public final static int
           NUM_STATES        = 124,
           NT_OFFSET         = 53,
           LA_STATE_OFFSET   = 182,
           MAX_LA            = 0,
           NUM_RULES         = 27,
           NUM_NONTERMINALS  = 2,
           NUM_SYMBOLS       = 55,
           SEGMENT_SIZE      = 8192,
           START_STATE       = 28,
           IDENTIFIER_SYMBOL = 0,
           EOFT_SYMBOL       = 33,
           EOLT_SYMBOL       = 54,
           ACCEPT_ACTION     = 154,
           ERROR_ACTION      = 155;

    public final static boolean BACKTRACK = false;

    public final int getNumStates() { return NUM_STATES; }
    public final int getNtOffset() { return NT_OFFSET; }
    public final int getLaStateOffset() { return LA_STATE_OFFSET; }
    public final int getMaxLa() { return MAX_LA; }
    public final int getNumRules() { return NUM_RULES; }
    public final int getNumNonterminals() { return NUM_NONTERMINALS; }
    public final int getNumSymbols() { return NUM_SYMBOLS; }
    public final int getSegmentSize() { return SEGMENT_SIZE; }
    public final int getStartState() { return START_STATE; }
    public final int getStartSymbol() { return lhs[0]; }
    public final int getIdentifierSymbol() { return IDENTIFIER_SYMBOL; }
    public final int getEoftSymbol() { return EOFT_SYMBOL; }
    public final int getEoltSymbol() { return EOLT_SYMBOL; }
    public final int getAcceptAction() { return ACCEPT_ACTION; }
    public final int getErrorAction() { return ERROR_ACTION; }
    public final boolean isValidForParser() { return isValidForParser; }
    public final boolean getBacktrack() { return BACKTRACK; }

    public final int originalState(int state) { return 0; }
    public final int asi(int state) { return 0; }
    public final int nasi(int state) { return 0; }
    public final int inSymbol(int state) { return 0; }

    public final int ntAction(int state, int sym) {
        return baseAction[state + sym];
    }

    public final int tAction(int state, int sym) {
        int i = baseAction[state],
            k = i + sym;
        return termAction[termCheck[k] == sym ? k : i];
    }
    public final int lookAhead(int la_state, int sym) {
        int k = la_state + sym;
        return termAction[termCheck[k] == sym ? k : la_state];
    }
}

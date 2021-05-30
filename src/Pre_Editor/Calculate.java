package Pre_Editor;

import javax.swing.*;


public class Calculate {
    //private CurrentLineInfo currentLineInfo;
    private static int isInt = 1;
    private static int ASD;
    private static int choice = 0;
    private CalculateInterface calculateMode;
    //choice 为选择答案形式：0->auto
//    						1->integer
//    						2->float
    public Calculate(Pre_Editor editor) {

        String originline = editor.workingManager.getCurrentWritingArea().getCurrentLineInfo().getLineText();

        String validline = "";
        if (originline.charAt(originline.length() - 1) == '=') {
            try {
                validline = originline.substring(0, originline.length() - 1);


                int caretPosition = editor.workingManager.getCurrentWritingArea().getCurrentLineInfo().getCaretPosition();
                if (choice == 1) {
                    //插入整数

                    calculateMode = new calculateInt();
                    editor.workingManager.getCurrentWritingArea().textArea.replaceRange(calculateMode.calc(validline),
                            caretPosition, caretPosition);
                } else if (choice == 2) {
                    calculateMode = new calculateFloat();
                    editor.workingManager.getCurrentWritingArea().textArea.replaceRange(calculateMode.calc(validline),
                            caretPosition, caretPosition);
                } else
                //auto
                {
                    calculateMode = new calclateAuto();
                    editor.workingManager.getCurrentWritingArea().textArea.replaceRange(calculateMode.calc(validline),
                            caretPosition, caretPosition);
                }
            } catch (Exception e) {
                // TODO 自动生成的 catch 块
                JOptionPane.showMessageDialog(
                        editor.mainframe,
                        "Not compliant",
                        //TODO
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        } else {
            JOptionPane.showMessageDialog(
                    editor.mainframe,
                    "Not compliant",
                    //TODO
                    "Error Message",
                    JOptionPane.ERROR_MESSAGE
            );

        }
    }

    public Boolean isint(String originString) {
        for (int i = 0; i < originString.length(); i++) {
            if (originString.charAt(i) == '/' || originString.charAt(i) == '.') {
                return false;
            }
        }
        return true;
    }
//
//    public static float opt(String s) throws Exception {
//        if (s == null || "".equals(s.trim())) {
//            return 0f;
//        }
//        int a1 = s.indexOf("+");
//        int a2 = s.indexOf("-");
//        int a3 = s.indexOf("*");
//        int a4 = s.indexOf("/");
//        int a5 = s.indexOf("(");
//        if (a1 == -1 && a2 == -1 && a3 == -1 && a4 == -1) {
//            if (s.trim() == null || "".equals(s.trim())) {
//                throw new Exception("operate error");
//            }
//            return Float.parseFloat(s.trim());
//        }
//
//        if (a5 != -1) {
//            int a6 = s.indexOf(")");
//            if (a6 == -1) {
//                throw new Exception("括号不匹配");
//            } else {
//                float f = opt(s.substring(a5 + 1, a6).trim());
//                s = s.replace(s.substring(a5, a6 + 1), String.valueOf(f));
//                return opt(s);
//            }
//        }
//
//        if (a1 != -1) {
//            return opt(s.substring(0, a1)) + opt(s.substring(a1 + 1));
//        }
//        if (a2 != -1) {
//            return opt(s.substring(0, a2)) - opt(s.substring(a2 + 1));
//        }
//        if (a3 != -1) {
//            return opt(s.substring(0, a3)) * opt(s.substring(a3 + 1));
//        }
//        if (a4 != -1) {
//            return opt(s.substring(0, a4)) / opt(s.substring(a4 + 1));
//        }
//        return Integer.parseInt(s.trim());
//    }
//
//    public static void setChoice(int myChoice) {
//        choice = myChoice;
//    }
//
//    public static void setIsInt(int choice) {
//        isInt = choice;
//    }
//
//    public int getIsInt() {
//        return isInt;
//    }
}
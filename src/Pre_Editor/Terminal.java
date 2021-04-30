package Pre_Editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class Terminal {

    private JPanel mainPanel;
    private JTextArea textArea;
    private JButton restartButton;
    private CurrentLineInfo lineInfo;
    private Process process;
    private OutputStream outputStream;
    private InputStream stdout;
    private InputStream stderr;


    public Terminal() throws Exception {
        this.mainPanel = new JPanel(new BorderLayout());
        this.textArea = new JTextArea();
        this.lineInfo = new CurrentLineInfo(textArea);
        this.restartButton = new JButton("Restart");
        this.mainPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        this.mainPanel.add(restartButton, BorderLayout.WEST);

        initCmd();
        initTextArea();
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
               initCmd();
                try {
                    initTextArea();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    public void initCmd() {
        try {
            process = Runtime.getRuntime().exec("cmd");
        } catch (IOException e) {
            e.printStackTrace();
        }
        outputStream = process.getOutputStream();
        stdout = process.getInputStream();
        stderr = process.getErrorStream();
    }

    public static String filterSimpleTTY(String s) {
        while (true) {
            {
                String k1 = "[";
                int p1 = s.indexOf(k1);
                if (p1 >= 0) {
                    int p2 = s.indexOf("m", p1 + k1.length());
                    if (p2 >= 0) {
                        s = s.substring(0, p1) + s.substring(p2 + 1);
                        continue;
                    }
                }
            }
            break;
        }
        return s;
    }

    static CharSequence removeTailR(CharSequence s) {
        if (s.length() == 0) {
            return s;
        }
        if (s.charAt(s.length() - 1) == '\r') {
            s = s.subSequence(0, s.length() - 1);
        }
        return s;
    }

    public static void startThread(Thread thread) {
        thread.setDaemon(true);
        thread.start();
    }

    public void initTextArea() throws Exception {
        String action = "cd src/";
        action += "\n";
        try {
            outputStream.write(action.getBytes(StandardCharsets.UTF_8));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        try {
            outputStream.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        textArea.append("C:\\Users\\KKKZOZ\\Desktop\\Pre_Work_Editor\\src>\n");
        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (keyChar == 10) {
                    String action = lineInfo.getLineText();
                    action += "\n";
                    try {
                        outputStream.write(action.getBytes(StandardCharsets.UTF_8));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    try {
                        outputStream.flush();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    print(stdout);
                    print(stderr);
//                    System.out.println("!!!!!!!!!!!!!!!");
//                    System.out.println(lineInfo.getTail(lineInfo.getColumn()));
//                    lineInfo.setCaretPosition(lineInfo.getTail(lineInfo.getColumn()));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void print(InputStream stdout) {
        startThread(new Thread() {
            @Override
            public void run() {
                try {

                    int len;
                    byte[] buf = new byte[10240];
                    while ((len = stdout.read(buf)) > 0) {
                        String enc;
                        enc = "GBK";

                        String line = new String(buf, 0, len, enc);
//                        line = filterSimpleTTY(line);
                        String[] ss = line.split("\\n");
                        for (String s : ss) {
                            //s = removeTailR(s).toString();
//                            if (s.startsWith("\r")) {
//                                s = s.substring(1);
//                                // int y = page.pageData.roLines.getLinesize() - 2;
//                                // if (y >= 0) {
//                                // page.ptEdit.deleteLine(y);
//                                // }
//                            }
                            textArea.append(s + "\n");
                            System.out.println(s);
                        }
                    }
                    textArea.append("<EOF>\n");
                } catch (Throwable e) {
                    System.err.println("error:" + e + "\n");
                }
                System.out.println("Over!");
            }

        });

    }


    //Getters and Setters

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }


    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public InputStream getStdout() {
        return stdout;
    }

    public void setStdout(InputStream stdout) {
        this.stdout = stdout;
    }

    public InputStream getStderr() {
        return stderr;
    }

    public void setStderr(InputStream stderr) {
        this.stderr = stderr;
    }
}

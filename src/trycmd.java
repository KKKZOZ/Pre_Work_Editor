import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class trycmd {

    public static void main(String[] args) throws Exception {
        String cmd = "cmd";
        Process process = Runtime.getRuntime().exec(cmd);
        OutputStream outputStream = process.getOutputStream();
        InputStream stdout = process.getInputStream();
        InputStream stderr = process.getErrorStream();
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String action=reader.readLine();
            action+="\n";
            outputStream.write(action.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            print(stdout);
            print(stderr);
        }
    }

    public static void print(InputStream stdout) {
        startThread(new Thread(){
            @Override
            public void run() {
                try {

                    int len;
                    byte[] buf = new byte[10240];
                    while ((len = stdout.read(buf)) > 0) {
                        String enc;
                        enc = "GBK";

                        String line = new String(buf, 0, len, enc);
                        line = filterSimpleTTY(line);
                        String[] ss = line.split("\\n");
                        for (String s : ss) {
                            s = removeTailR(s).toString();
                            if (s.startsWith("\r")) {
                                s = s.substring(1);
                                // int y = page.pageData.roLines.getLinesize() - 2;
                                // if (y >= 0) {
                                // page.ptEdit.deleteLine(y);
                                // }
                            }
                            System.out.println(s);
                        }

                    }
                } catch (Throwable e) {
                    System.err.println("error:" + e + "\n");
                }
                System.out.println("Over!");
            }

        });

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
        if (s.length() == 0)
            return s;
        if (s.charAt(s.length() - 1) == '\r') {
            s = s.subSequence(0, s.length() - 1);
        }
        return s;
    }
    public static void startThread(Thread thread) {
        thread.setDaemon(true);
        thread.start();
    }

}

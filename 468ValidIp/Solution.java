import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidIp {
    public static void main(String[] args) {
     System.out.println(valid("2001:0db8:85a3:0000:0:8A2E:0370:733a"));
    }
    public static String valid(String IP){
        String ipv4Part = "([0-9]|[1-9][0-9]|[1][0-9][0-9]|[2][0-5][0-5])";
        String ipv4 = ipv4Part+"."+ipv4Part+"."+ipv4Part+"."+ipv4Part;
        Pattern p = Pattern.compile(ipv4);
        Matcher m = p.matcher(IP);
        if(m.matches()) {
            return "IPv4";
        } else {
            String ipv6Part = "([0-9A-F]|[0-9A-F][0-9A-F]|[0-9A-F][0-9A-F][0-9A-F]|[0-9A-F][0-9A-F][0-9A-F][0-9A-F])";
            String ipv6 = ipv6Part + ":" + ipv6Part + ":" + ipv6Part + ":" + ipv6Part + ":" + ipv6Part + ":" + ipv6Part + ":"+ ipv6Part + ":"+ ipv6Part;
            p = Pattern.compile(ipv6);
            m = p.matcher(IP.toUpperCase());
            if(m.matches()){
                return "IPv6";
            }
        }
        return "Neither";
    }
}


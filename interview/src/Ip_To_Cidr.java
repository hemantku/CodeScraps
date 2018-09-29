import java.util.ArrayList;
import java.util.List;

/**
 * Given a start IP address ip and a number of ips we need to cover n, return a representation of the range as a list (of smallest possible length) of CIDR blocks.
 * A CIDR block is a string consisting of an IP, followed by a slash, and then the prefix length. For example: "123.45.67.89/20".
 * That prefix length "20" represents the number of common prefix bits in the specified range.
 * Input: ip = "255.0.0.7", n = 10
 Output: ["255.0.0.7/32","255.0.0.8/29","255.0.0.16/32"]
 Explanation:
 The initial ip address, when converted to binary, looks like this (spaces added for clarity):
 255.0.0.7 -> 11111111 00000000 00000000 00000111
 The address "255.0.0.7/32" specifies all addresses with a common prefix of 32 bits to the given address,
 ie. just this one address.
 *
 */
public class Ip_To_Cidr {
    public List<String> IpToCidr(String ip, int range) {
        long ipInLong = 0;
        List<String> ans = new ArrayList<>();
        String[] ips = ip.split("\\.");
        for(String ipPart : ips) {
            ipInLong = Integer.parseInt(ipPart) + ipInLong * 256;
        }
        while(range > 0) {
            long step = ipInLong & ~ipInLong;
            while (step > range) step /= 2;
            //ans.add(longtoIp(, (int)step))

        }
        return ans;
    }

    public static void main(String[] args) {
        Ip_To_Cidr ip_to_cidr = new Ip_To_Cidr();
        String ip = "255.0.0.7";
        int n = 10;
        ip_to_cidr.IpToCidr(ip, n);

    }

}

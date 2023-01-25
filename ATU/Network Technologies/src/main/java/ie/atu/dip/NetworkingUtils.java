package ie.atu.dip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * Locates the user by different means.
 *
 * @author Andrei Drynov
 */
public class NetworkingUtils {

    /**
     * Public servers that return your public IP address.
     */
    private static final String[] externalServers = {
            "http://checkip.amazonaws.com/", "https://api.ipify.org",
            "http://ipecho.net/plain", "http://myexternalip.com/raw",
            "https://ipv4.icanhazip.com/", "http://myip.dnsomatic.com/"
    };

    /**
     * Gets the public IP address of the current machine.
     * <p>
     * It pings one of the public servers that listen for client connections
     * and return the client's public IP address.
     * <p>
     * The public address is not usually the same as the machine's as there are
     * multiple hosts on the LAN connected to the same router.
     *
     * @return Public IPv4 address reachable from the internet.
     */
    public static String getPublicAddress() throws IOException {
        // ping the servers until one of them responds with an IP address
        for (String server : externalServers) {
            URL serverURL = new URL(server);

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(serverURL.openStream()))) {
                // the IP address returned as a raw text string
                return reader.readLine();
            }
        }

        // it is likely the machine is not connected to the Internet
        return "";
    }

    /**
     * Gets the working IP address of the client machine.
     * <p>
     * Your PC can have multiple NICs with different IP addresses.
     * We are interested in the IP address that can reach the Internet.
     * <p>     *
     *
     * @return Chat server address
     */
    public static String getLocalIpAddress() {
        try (final DatagramSocket socket = new DatagramSocket()) {
            // ping Google
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            return socket.getLocalAddress().getHostAddress();

        } catch (SocketException | UnknownHostException e) {
            System.err.println("Unable to ping Google. Are you connected to the Internet?");
            return "";
        }
    }

}

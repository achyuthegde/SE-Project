package utils;

import java.net.InetAddress;
import java.net.NetworkInterface;

public class Addressing
{
	public static String getIpAddress()
	{
		try
		{
			return InetAddress.getLocalHost().getHostAddress();
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	}

	public static String getMacAddress()
	{
		try
		{
			InetAddress ip = InetAddress.getLocalHost();
			NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			byte[] mac = network.getHardwareAddress();

//			System.out.print("The mac address is : ");

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++)
			{
				//System.out.println(mac[i]);
				sb.append(String.format("%02X%s", mac[i],
						(i < mac.length - 1) ? "-" : ""));
			}

			return sb.toString();
		}
		catch (Exception ex)
		{
			System.out.println("Exception caught:"+ex.getMessage());
		}
		return null;
	}

}

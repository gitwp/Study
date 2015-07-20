package com.ex1;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpATTRS;

public class SFTPClientGet {
	public SFTPChannel getSFTPChannel() {
		return new SFTPChannel();
	}

	public static void main(String[] args) throws Exception {
		SFTPClientGet test = new SFTPClientGet();

		Map<String, String> sftpDetails = new HashMap<String, String>();
		// 设置主机ip，端口，用户名，密码
		sftpDetails.put(SFTPConstants.SFTP_REQ_HOST, "192.168.1.100");
        sftpDetails.put(SFTPConstants.SFTP_REQ_USERNAME, "ftp");
        sftpDetails.put(SFTPConstants.SFTP_REQ_PASSWORD, "ftp");
        sftpDetails.put(SFTPConstants.SFTP_REQ_PORT, "22");

		SFTPChannel channel = test.getSFTPChannel();
		ChannelSftp chSftp = channel.getChannel(sftpDetails, 60000);
		
		String filename = "/var/logs/ftp/2015-07-15/biz.2015-07-15.log.gz";
		SftpATTRS attr = chSftp.stat(filename);
		long fileSize = attr.getSize();

		String dst = "D:/biz.2015-07-15.log.gz";
		OutputStream out = new FileOutputStream(dst);
		try {

			chSftp.get(filename, dst, new FileProgressMonitor(fileSize)); // 代码段1

			// chSftp.get(filename, out, new FileProgressMonitor(fileSize)); //
			// 代码段2

			/**
			 * 代码段3
			 * 
			 * InputStream is = chSftp.get(filename, new MyProgressMonitor());
			 * byte[] buff = new byte[1024 * 2]; int read; if (is != null) {
			 * System.out.println("Start to read input stream"); do { read =
			 * is.read(buff, 0, buff.length); if (read > 0) { out.write(buff, 0,
			 * read); } out.flush(); } while (read >= 0);
			 * System.out.println("input stream read done."); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			chSftp.quit();
			channel.closeChannel();
		}
	}
}

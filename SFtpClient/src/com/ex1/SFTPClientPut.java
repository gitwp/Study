package com.ex1;

import java.util.HashMap;
import java.util.Map;

import com.jcraft.jsch.ChannelSftp;

public class SFTPClientPut {
	  public SFTPChannel getSFTPChannel() {
	        return new SFTPChannel();
	    }

	    /**
	     * @param args
	     * @throws Exception
	     */
	    public static void main(String[] args) throws Exception {
	    	SFTPClientPut test = new SFTPClientPut();

	        Map<String, String> sftpDetails = new HashMap<String, String>();
	        // ��������ip���˿ڣ��û���������
	        sftpDetails.put(SFTPConstants.SFTP_REQ_HOST, "192.168.1.100");
	        sftpDetails.put(SFTPConstants.SFTP_REQ_USERNAME, "ftp");
	        sftpDetails.put(SFTPConstants.SFTP_REQ_PASSWORD, "ftp");
	        sftpDetails.put(SFTPConstants.SFTP_REQ_PORT, "22");
	        
	        String src = "D:/var/test4"; // �����ļ���
	        String dst = "/home/ftp/ftplcpt/test4"; // Ŀ���ļ���
	              
	        SFTPChannel channel = test.getSFTPChannel();
	        ChannelSftp chSftp = channel.getChannel(sftpDetails, 60000);
	        
	        /**
	         * �����1
	        OutputStream out = chSftp.put(dst, ChannelSftp.OVERWRITE); // ʹ��OVERWRITEģʽ
	        byte[] buff = new byte[1024 * 256]; // �趨ÿ�δ�������ݿ��СΪ256KB
	        int read;
	        if (out != null) {
	            System.out.println("Start to read input stream");
	            InputStream is = new FileInputStream(src);
	            do {
	                read = is.read(buff, 0, buff.length);
	                if (read > 0) {
	                    out.write(buff, 0, read);
	                }
	                out.flush();
	            } while (read >= 0);
	            System.out.println("input stream read done.");
	        }
	        **/
	        
	        chSftp.put(src, dst, ChannelSftp.OVERWRITE); // �����2
	        
	        // chSftp.put(new FileInputStream(src), dst, ChannelSftp.OVERWRITE); // �����3
	        
	        chSftp.quit();
	        channel.closeChannel();
	    }
}

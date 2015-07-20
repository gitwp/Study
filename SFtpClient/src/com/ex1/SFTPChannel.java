package com.ex1;

import java.util.Map;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SFTPChannel {
    private Session session = null;
    private Channel channel = null;

    public ChannelSftp getChannel(Map<String, String> sftpDetails, int timeout) throws JSchException {

        String ftpHost = sftpDetails.get(SFTPConstants.SFTP_REQ_HOST);
        String port = sftpDetails.get(SFTPConstants.SFTP_REQ_PORT);
        String ftpUserName = sftpDetails.get(SFTPConstants.SFTP_REQ_USERNAME);
        String ftpPassword = sftpDetails.get(SFTPConstants.SFTP_REQ_PASSWORD);

        int ftpPort = SFTPConstants.SFTP_DEFAULT_PORT;
        if (port != null && !port.equals("")) {
            ftpPort = Integer.valueOf(port);
        }

        JSch jsch = new JSch(); // ����JSch����
        session = jsch.getSession(ftpUserName, ftpHost, ftpPort); // �����û���������ip���˿ڻ�ȡһ��Session����
        System.out.println("Session created.");
        if (ftpPassword != null) {
            session.setPassword(ftpPassword); // ��������
        }
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config); // ΪSession��������properties
        session.setTimeout(timeout); // ����timeoutʱ��
        session.connect(); // ͨ��Session��������
        System.out.println("Session connected.");

        System.out.println("Opening Channel.");
        channel = session.openChannel("sftp"); // ��SFTPͨ��
        channel.connect(); // ����SFTPͨ��������
        System.out.println("Connected successfully to ftpHost = " + ftpHost + ",as ftpUserName = " + ftpUserName
                + ", returning: " + channel);
        return (ChannelSftp) channel;
    }

    public void closeChannel() throws Exception {
        if (channel != null) {
            channel.disconnect();
        }
        if (session != null) {
            session.disconnect();
        }
    }
}

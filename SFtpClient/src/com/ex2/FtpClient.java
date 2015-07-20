package com.ex2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class FtpClient {
	/**
	 * Description: ��FTP�����������ļ�
	 * 
	 * @param url
	 *            FTP������hostname
	 * @param port
	 *            FTP�������˿�
	 * @param username
	 *            FTP��¼�˺�
	 * @param password
	 *            FTP��¼����
	 * @param remotePath
	 *            FTP�������ϵ����·��
	 * @param fileName
	 *            Ҫ���ص��ļ���
	 * @param localPath
	 *            ���غ󱣴浽���ص�·��
	 * @return
	 * @throws IOException
	 */
	private boolean downFile(String url, int port, String username,
			String password, String remotePath, String fileName,
			String localPath) throws IOException {
		// �ж�localPath�Ƿ���ڣ���������ڣ��򴴽�·��
		File f = new File(localPath);
		if (!f.exists()) {
			if (!f.isDirectory()) {
				if (!f.mkdirs()) {
					System.out.println("���ش洢·������ʧ�ܣ���ȷ��Ȩ���Ƿ���ȷ");
					throw new IOException("���ش洢·������ʧ�ܣ���ȷ��Ȩ���Ƿ���ȷ");
				}//
			}
		}

		boolean success = false;
		boolean fileExists = false;
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			ftp.connect(url, port);
			// �������Ĭ�϶˿ڣ�����ʹ��ftp.connect(url)�ķ�ʽֱ������FTP������
			ftp.login(username, password);// ��¼
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return success;
			}
			// ת�Ƶ�FTP������Ŀ¼
			if (ftp.changeWorkingDirectory(remotePath)) {
				FTPFile[] fs = ftp.listFiles();

				for (FTPFile ff : fs) {
					if (ff.getName().equals(fileName)) {
						File localFile = new File(localPath + "/"
								+ ff.getName());

						OutputStream is = new FileOutputStream(localFile);
						ftp.retrieveFile(ff.getName(), is);
						is.close();
						fileExists = true;
					}
				}

				ftp.logout();
				success = true;
			}

		} catch (IOException e) {
			System.out.println("ftp�����������ļ�ʧ��:������Ϣ��" + e);
			throw e;
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return success && fileExists;
	}

	/**
	 * Description: ��FTP�������ϴ��ļ�
	 * 
	 * @param url
	 *            FTP������hostname
	 * @param port
	 *            FTP�������˿�
	 * @param username
	 *            FTP��¼�˺�
	 * @param password
	 *            FTP��¼����
	 * @param path
	 *            FTP����������Ŀ¼
	 * @param filename
	 *            �ϴ���FTP�������ϵ��ļ���
	 * @param input
	 *            ������
	 * @return �ɹ�����true�����򷵻�false
	 */
	private boolean uploadFile(String url, int port, String username,
			String password, String path, String filename, InputStream input) {
		boolean success = false;
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			ftp.connect(url, port);// ����FTP������
			// �������Ĭ�϶˿ڣ�����ʹ��ftp.connect(url)�ķ�ʽֱ������FTP������
			ftp.login(username, password);// ��¼
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return success;
			}
			ftp.changeWorkingDirectory(path);
			ftp.storeFile(filename, input);

			input.close();
			ftp.logout();
			success = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return success;
	}
}

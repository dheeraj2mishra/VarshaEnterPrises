package com.digital.education.system.data.dao.model;

import java.util.List;

public class EmailModel {
	private String mailTo;
	private String subject;
	private String messages;
	private List<String> attachFiles;
	public String getMailTo() {
		return mailTo;
	}
	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessages() {
		return messages;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}
	public List<String> getAttachFiles() {
		return attachFiles;
	}
	public void setAttachFiles(List<String> attachFiles) {
		this.attachFiles = attachFiles;
	}
	
	

}

package com.member.model;

public class MemberDTO {
	
		private int num,admin;
		private String userid,userpwd,useraddr,usertel,useremail,userzipcode,username;
		
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public String getUserzipcode() {
			return userzipcode == null ? "" : userzipcode.trim();
		}
		public String getUsername() {
			return username == null ? "" : username.trim();
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public void setUserzipcode(String userzipcode) {
			this.userzipcode = userzipcode;
		}
		public int getAdmin() {
			return admin;
		}
		public void setAdmin(int admin) {
			this.admin = admin;
		}
		public String getUserid() {
			return userid == null ? "" : userid.trim();
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public String getUserpwd() {
			return userpwd == null ? "" : userpwd.trim();
		}
		public void setUserpwd(String userpwd) {
			this.userpwd = userpwd;
		}
		public String getUseraddr() {
			return useraddr == null ? "" : useraddr.trim();
		}
		public void setUseraddr(String useraddr) {
			this.useraddr = useraddr;
		}
		public String getUsertel() {
			return usertel == null ? "" : usertel.trim();
		}
		public void setUsertel(String usertel) {
			this.usertel = usertel;
		}
		public String getUseremail() {
			return useremail == null ? "" : useremail.trim();
		}
		public void setUseremail(String useremail) {
			this.useremail = useremail;
		}
		
		
}

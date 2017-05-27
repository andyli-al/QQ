package com.llf.qqzone.Entity;

import java.io.Serializable;

public class ZoneAccessPermission implements Serializable{
	
	private int ZoneAccessPermissionId;
	private int QQ_No;
	private int QQ_friend;
	public int getZoneAccessPermissionId() {
		return ZoneAccessPermissionId;
	}
	public void setZoneAccessPermissionId(int zoneAccessPermissionId) {
		ZoneAccessPermissionId = zoneAccessPermissionId;
	}
	public int getQQ_No() {
		return QQ_No;
	}
	public void setQQ_No(int qQNo) {
		QQ_No = qQNo;
	}
	public int getQQ_friend() {
		return QQ_friend;
	}
	public void setQQ_friend(int qQFriend) {
		QQ_friend = qQFriend;
	}
	public ZoneAccessPermission() {
		super();
	}
	public ZoneAccessPermission(int zoneAccessPermissionId, int qQNo,
			int qQFriend) {
		super();
		ZoneAccessPermissionId = zoneAccessPermissionId;
		QQ_No = qQNo;
		QQ_friend = qQFriend;
	}
	

}

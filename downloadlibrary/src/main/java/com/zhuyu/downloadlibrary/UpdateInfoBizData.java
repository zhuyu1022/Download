package com.zhuyu.downloadlibrary;

import java.io.Serializable;

public class UpdateInfoBizData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


//	private String Code = "";
//
//	private String Message = "";
//
//	private  UpdateInfo Result;
//
//	public String getCode() {
//		return Code;
//	}
//
//	public void setCode(String code) {
//		Code = code;
//	}
//
//	public String getMessage() {
//		return Message;
//	}
//
//	public void setMessage(String message) {
//		Message = message;
//	}
//
//	public  UpdateInfo getResult() {
//		return Result;
//	}
//
//	public void setResult( UpdateInfo result) {
//		Result = result;
//	}
//
//	public class  UpdateInfo {
//		
//		private  String VersionNo ="";//版本号
//		private  String URL ="";//下载路径
//		public String getVersionNo() {
//			return VersionNo;
//		}
//		public void setVersionNo(String versionNo) {
//			VersionNo = versionNo;
//		}
//		public String getURL() {
//			return URL;
//		}
//		public void setURL(String uRL) {
//			URL = uRL;
//		}
//
//		
//	}
	
	
	
	
	
//	
//	 "pkid":"5371678EB7CD4582A6E282C102747C29",
//	    "appname":"test.apk",
//	    "androidUrl":"testurl",
//	    "androidversionName":"版本号",
//	    "androidversionCode":"2",
//	    "androidForced":1,
//	    "deviceType":"Pad"
	
	
	    	private String pkid="";
	    	private String appname="";
	
	    	private String androidUrl="";
	    	private String androidversionName="";
	
	    	private String androidversionCode="";
	    	private String androidForced="";
	
	    	private String deviceType="";

			public String getPkid() {
				return pkid;
			}

			public void setPkid(String pkid) {
				this.pkid = pkid;
			}

			public String getAppname() {
				return appname;
			}

			public void setAppname(String appname) {
				this.appname = appname;
			}

			public String getAndroidUrl() {
				return androidUrl;
			}

			public void setAndroidUrl(String androidUrl) {
				this.androidUrl = androidUrl;
			}

			public String getAndroidversionName() {
				return androidversionName;
			}

			public void setAndroidversionName(String androidversionName) {
				this.androidversionName = androidversionName;
			}

			public String getAndroidversionCode() {
				return androidversionCode;
			}

			public void setAndroidversionCode(String androidversionCode) {
				this.androidversionCode = androidversionCode;
			}

		
			

			public String getAndroidForced() {
				return androidForced;
			}

			public void setAndroidForced(String androidForced) {
				this.androidForced = androidForced;
			}

			public String getDeviceType() {
				return deviceType;
			}

			public void setDeviceType(String deviceType) {
				this.deviceType = deviceType;
			}
	
	
	
	
	
	
		
}

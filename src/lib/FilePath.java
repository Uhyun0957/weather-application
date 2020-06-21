package lib;

import java.io.File;

public class FilePath {
	public static String resDir=new File("src/res").getAbsolutePath();
	public static String bgDir=resDir+"./bg/";
	public static String buttonDir=resDir+"./button/";
	public static String topIconDir=resDir+"./topIcon/";
	public static String weatherIconDir=resDir+"./weatherIcon/";
	public static String oriIconDir=resDir+"./oriIcon/";
	public static String selectIconDir=resDir+"./selectIcon/";
	public static String copyObjectDir=resDir+"./copyObject/";
	public static String dustIconDir=resDir+"./dustIcon/";
	
	// 파일명에서 확장자 추출하는 메서드
	public static String getEXT(String path) {
		int lastIndex=path.lastIndexOf("\\");
		String fileName=path.substring(lastIndex+1, path.length());

		lastIndex=fileName.lastIndexOf(".");
		String exit=fileName.substring((lastIndex)+1, fileName.length());
		return exit;
	}
}
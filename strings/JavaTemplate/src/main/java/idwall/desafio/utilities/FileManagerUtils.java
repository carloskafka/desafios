package idwall.desafio.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileManagerUtils {
	private static final String CHARSET_ENCODING = "UTF-8";

	public static String fetchContent(String path) {
		String content = "";
		try {
			content = FileUtils.readFileToString(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	public static String fetchContent(File file) {
		String content = "";
		try {
			content = FileUtils.readFileToString(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	public static boolean writeContentToFile(File file, String data) {
		boolean successful = true;

		try {
			FileUtils.writeStringToFile(file, data, CHARSET_ENCODING);
		} catch (Exception e) {
			successful = false;
		}

		return successful;
	}
}

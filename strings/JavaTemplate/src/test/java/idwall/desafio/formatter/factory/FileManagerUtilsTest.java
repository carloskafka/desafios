package idwall.desafio.formatter.factory;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import idwall.desafio.utilities.FileManagerUtils;

public class FileManagerUtilsTest {

	@Test
	public void given_a_valid_file_when_fetch_content_then_return_content() {
		Assert.assertFalse(FileManagerUtils.fetchContent("docs/output_parte1.txt").isEmpty());
	}
	
	@Test(expectedExceptions = NullPointerException.class)
	public void given_null_file_when_fetch_content_then_return_nullpointerexception() {
		Assert.assertNull(FileManagerUtils.fetchContent(null));
	}
	
	@Test
	public void given_valid_file_when_write_content_to_file_then_return_true() {
		File tempFile = null;
		try {
			tempFile = File.createTempFile("1234", ".pdf");
		} catch (IOException e) {
		}
		
		Assert.assertTrue(FileManagerUtils.writeContentToFile(tempFile, "1234"));
	}
	
	@Test
	public void given_null_file_when_write_content_to_file_then_return_true() {
		Assert.assertFalse(FileManagerUtils.writeContentToFile(null, null));
	}
}

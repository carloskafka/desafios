package idwall.desafio.repository;

import java.io.File;

import idwall.desafio.utilities.FileManagerUtils;

public class FileRepositoryImpl implements FileRepository {

	private static final File GENERATED_FILE = new File("docs/generated_file_parte_1.txt");

	@Override
	public boolean saveFile(String text) {
		return FileManagerUtils.writeContentToFile(GENERATED_FILE, text);
	}

}

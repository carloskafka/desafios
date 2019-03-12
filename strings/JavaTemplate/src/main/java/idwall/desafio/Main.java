package idwall.desafio;

import java.io.File;

import idwall.desafio.string.IdwallFormatter;
import idwall.desafio.string.StringFormatter;
import idwall.desafio.utilities.FileManagerUtils;

/**
 * Created by Rodrigo Catão Araujo on 06/02/2018.
 */
public class Main {

	private static final String DEFAULT_INPUT_TEXT = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\n"
			+ "\n"
			+ "And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.";
	private static final Integer DEFAULT_LIMIT = 42;
	private static final Boolean DEFAULT_JUSTIFY = false;

	public static void main(String[] args) throws Exception {
		String text = DEFAULT_INPUT_TEXT;
		Integer limit = DEFAULT_LIMIT;
		Boolean justify = DEFAULT_JUSTIFY;
		switch (args.length) {
		case 1:
			text = args[0];
			break;
		case 2:
			text = args[0];
			limit = Integer.parseInt(args[1]);
			break;
		case 3:
			text = args[0];
			limit = Integer.parseInt(args[1]);
			justify = Boolean.parseBoolean(args[2]);
			break;
		}

		if (justify) {
			System.out.println("Justify was detected enabled");
			System.out.println("ERROR: Justify process under development :(");
		} else {
			// Print input data
			System.out.println("Inputs: ");
			System.out.println("Text: " + text);
			System.out.println("Limit: " + limit);
			System.out.println("Should justify: " + justify);
			System.out.println("=========================");

			// Run IdwallFormatter
			final StringFormatter stringFormatter = new IdwallFormatter();

			stringFormatter.setLimit(limit);
			stringFormatter.setJustify(justify);

			String outputText = stringFormatter.format(text);

			// Print output text
			System.out.println("\nOutput: ");
			System.out.println(outputText);
			System.out.println("=========================");

			File generatedFile = null;

			if (!justify.booleanValue()) {
				generatedFile = new File("docs/generated_file_parte_1.txt");

				FileManagerUtils.writeContentToFile(generatedFile, outputText);
			}
			if (generatedFile != null) {
				System.out.println("Generated File's Detail");
				System.out.println();
				System.out.println("Path: " + generatedFile.getAbsolutePath());
				System.out.println("Content:");
				System.out.println(FileManagerUtils.fetchContent(generatedFile));
			}
			System.out.println("=========================");

		}
	}
}

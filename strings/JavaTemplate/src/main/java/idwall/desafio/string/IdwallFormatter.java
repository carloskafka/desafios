package idwall.desafio.string;

import java.text.BreakIterator;
import java.util.Locale;

/**
 * Created by Rodrigo Catão Araujo on 06/02/2018.
 */
public class IdwallFormatter extends StringFormatter {

	/**
	 * Should format as described in the challenge
	 *
	 * @param text
	 * @return
	 */
	@Override
	public String format(String text) {
		return formatLines(text, getLimit());
	}

	private String formatLines(String target, int maxLength) {
		String formattedText = "";

		BreakIterator boundary = BreakIterator.getLineInstance(Locale.getDefault());
		boundary.setText(target);
		int start = boundary.first();
		int end = boundary.next();
		int lineLength = 0;
		String fullWord = "";

		while (end != BreakIterator.DONE) {
			String word = target.substring(start, end);

			if (getJustify().booleanValue()) {
				word += " ";
			}
			
			lineLength = lineLength + word.length();
			if (lineLength >= maxLength) {
				System.out.println();
				lineLength = word.length();
				fullWord = fullWord.substring(0, fullWord.length() - 1);
				formattedText += fullWord + "\n";
				fullWord = "";
			}
			if ( (!word.isEmpty() || end == BreakIterator.DONE)) {
				fullWord += word;
			}
			System.out.print(word);
			start = end;
			end = boundary.next();
		}
		formattedText += fullWord + "\n";

		return formattedText;
	}
}

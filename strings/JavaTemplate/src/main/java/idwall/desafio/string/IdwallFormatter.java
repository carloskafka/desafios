package idwall.desafio.string;

import idwall.desafio.domain.Text;

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
		Text newText = new Text(text, getLimit());
		
		return newText.formatLines();
	}

}

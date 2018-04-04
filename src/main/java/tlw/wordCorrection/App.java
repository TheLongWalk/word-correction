package tlw.wordCorrection;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import tlw.wordCorrection.model.AdModel;
import zemberek.morphology.analysis.tr.TurkishMorphology;
import zemberek.normalization.TurkishSpellChecker;

public class App {
	/**
	 * test file: /Users/ibrahim/git/website-scraping/sahibinden/scrapy/buick.json
	 * @param args
	 */
	public static void main(final String[] args) {

		Type collectionType = new TypeToken<Collection<AdModel>>(){}.getType();
		Gson gson = new Gson();
		try {

			JsonReader reader = new JsonReader(new FileReader(args[0]));	
			Collection<AdModel> models = gson.fromJson(reader, collectionType);

			TurkishMorphology morphology = TurkishMorphology.createWithDefaults();
			TurkishSpellChecker spellChecker = new TurkishSpellChecker(morphology);
			int cnt = 0;
			for (AdModel adModel : models) {
				String desc = adModel.getInfo().getDescription();
				String[] descWords = desc.replace(".", " ").replace(",", " ").split(" ");
				for (String word : descWords) {
					word = word.trim();
					if(!spellChecker.check(word) && word.length()>0) {
						System.out.println(word + " = " + spellChecker.suggestForWord(word));
						cnt++;
					}
				}
			}
			System.out.println("HATALI: " + cnt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

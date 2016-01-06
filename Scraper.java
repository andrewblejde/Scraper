/*
 * Andrew Blejde
 * 
 * Simple scraper to get the contributing attributes
 * of a given website. style sheets, images, etc
 *
*/

// Imports
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;

public class Scraper
{
	private static void parse(String url) throws IOException
	{
		// Connect and get document from url
		Document page = Jsoup.connect(url).get();

		// Get links from document
		Elements images = page.select("[src]");

		// Get style sheet imports
		Elements css = page.select("link[href]");

		// Header
		System.out.println("Images:");

		// Get images
		for(Element img : images)
		{
			// Get image link
			if(img.tagName().equals("img"))
			{
				System.out.println("    link: " + img.attr("abs:src"));
			}
		}

		// Header
		System.out.println("\nStylesheets:");

		// Get stylesheets
		for(Element link : css)
		{
			System.out.println("    link: " + link.attr("abs:href"));
		}
	}
	public static void main(String[] args) throws IOException
	{
		// Get URL
		String url = "";

		// Check for errors or parse
		if(args.length != 1 || args[0] == null || args[0].length() < 1)
		{
			// Print usage
			System.out.println("Input error. Please provide a URL");
		}
		else
		{
			// Assign URL 
			url = args[0];

			// Make method call
			parse(url);
		}
	}
}
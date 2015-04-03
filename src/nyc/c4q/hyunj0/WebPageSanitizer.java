package nyc.c4q.hyunj0;

import java.net.URL;
import java.util.Scanner;

//Based from http://stackoverflow.com/questions/19540438/remove-data-between-two-strings

public class WebPageSanitizer
{

    public static void main(String[] args)
    {
        System.out.println(sanitize(
                "http://www.ted.com/talks/amy_cuddy_your_body_language_shapes_who_you_are?language=en"));

    }

    public static String sanitize(String html)
    {

        URL url = HTTP.stringToURL(html);
        String rawHtml = HTTP.get(url);
        Scanner read = new Scanner(rawHtml);

        String oneLineHtml = "";
        String sanitizedHtml = "";

        while(read.hasNextLine())
        {
            String line = read.nextLine();
            oneLineHtml += (line + "\n");
            sanitizedHtml = oneLineHtml.replaceAll("<script[^>]*>([^<]*)<\\/script>", "");
        }

        return sanitizedHtml;
    }
}

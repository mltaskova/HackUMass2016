import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 * 
 */

/**
 * @author mtaskova
 *
 */
public class EssayChecker {
	
	protected String myText;
//	protected SpannableString spannable;
	
    private final static String[] firstPersonPronouns = {"I", "me", "mine", "my", "we", "our", "ours", "us"};
    private final static String[] secondPersonPronouns = {"you", "your", "yours"};
    private final static String[] contractions = {"I'm", "you're", "he's", "she's", "it's", "we're", "they're", "that's", "who's", "what's", "where's", "when's", "why's", "how's", "I'll", "you'll", "he'll", "she'll", "it'll", "we'll", "they'll", "that'll", "who'll", "what'll", "where'll", "when'll", "why'll", "how'll", "I'd", "you'd", "he'd", "she'd", "it'd", "we'd", "they'd", "that'd", "who'd", "what'd", "where'd", "when'd", "why'd", "how'd", "I've", "you've", "we've", "they've", "that've", "who've", "what've", "where've", "when've", "why've", "how've", "would've", "should've", "could've", "might've", "must've"};
    private final static String[] nContractions = {"isn't", "aren't", "wasn't", "weren't", "haven't", "hasn't", "hadn't", "wouldn't", "don't", "doesn't", "didn't", "couldn't", "shouldn't", "mightn't", "mustn't", "can't", "won't"};


    public EssayChecker(String essay)
    {
    	myText = essay;
//    	spannable = new SpannableString(essay);
    }
    
    public void highlight()
    {
    	Pattern myPattern = Pattern.compile("[A-z0-9']+");
    	Matcher myMatcher = myPattern.matcher(myText);
    	
    	
    	while(myMatcher.find())
    	{
//    		spannable.addSpan(color, matcher.start(), matcher.end())
    	}
    }
    
    public void deHighlight()
    {
    	
    }
    
}

/**
 * Created by mltaskova on 10/8/16.
 */

import java.util.Stack;

public class TextChecker {

    protected String myText;
    protected boolean[][] boolText;
    protected int textSize;
    private final static String[] firstPersonPronouns = {"I", "me", "mine", "my", "we", "our", "ours", "us"};
    private final static String[] secondPersonPronouns = {"you", "your", "yours"};
    private final static String[] contractions = {"I'm", "you're", "he's", "she's", "it's", "we're", "they're", "that's", "who's", "what's", "where's", "when's", "why's", "how's", "I'll", "you'll", "he'll", "she'll", "it'll", "we'll", "they'll", "that'll", "who'll", "what'll", "where'll", "when'll", "why'll", "how'll", "I'd", "you'd", "he'd", "she'd", "it'd", "we'd", "they'd", "that'd", "who'd", "what'd", "where'd", "when'd", "why'd", "how'd", "I've", "you've", "we've", "they've", "that've", "who've", "what've", "where've", "when've", "why've", "how've", "would've", "should've", "could've", "might've", "must've"};
    private final static String[] nContractions = {"isn't", "aren't", "wasn't", "weren't", "haven't", "hasn't", "hadn't", "wouldn't", "don't", "doesn't", "didn't", "couldn't", "shouldn't", "mightn't", "mustn't", "can't", "won't"};

    public TextChecker(String s)
    {
        myText = s;
        textSize = s.length();
        //for now 5 positions for: 1stPerPro, 2ndPerPro, Contr, nContr, Quoted
        boolText = new boolean[5][textSize];

        compareWordToArrays();
    }

    public void highlight(boolean firstPersonPr, boolean secondPersonPr, boolean contractions, boolean nContractions, boolean quoted)
    {


        for (int i = 0; i < textSize; i++)
        {
            if (boolText[0][i] && firstPersonPr)
            {
                //highlight text at index i
            }
            if (boolText[1][i] && secondPersonPr)
            {
                //highlight text at index i
            }
            if (boolText[2][i] && contractions)
            {
                //highlight text at index i
            }
            if (boolText[3][i] && nContractions)
            {
                //highlights text at index i
            }
            if (quoted)
            {
                ignoreQuoted();
                //dehighlight text at index i
            }
        }
    }

    /*
        need deHighliight() method
     */

    public void replace()
    {

    }

    public void ignoreQuoted()
    {
        String myTextHolder = myText;
        int j = myTextHolder.indexOf("\"");
        myTextHolder = myTextHolder.substring(j+1);
        int i = myTextHolder.indexOf("\"");
        for (int k = j; k <= i; k++)
        {
            boolText[4][k] = true;
        }
    }
    /*

     */
    public boolean compare(String s,String[] stringArray)
    {
        for (int i = 0; i < stringArray.length; i++)
        {
            if (s.equals(stringArray[i]))
                return true;
        }
        return false;
    }


    public void compareWordToArrays()
    {
        String myTextHolder = myText;
        String tempString = "";
        int j = 0;
        for (int i = 0; i < myText.length(); i++)
        {
            if (myTextHolder.indexOf(" ") == i || myTextHolder.indexOf(".") == i || myTextHolder.indexOf(",") == i) {
                tempString = myText.substring(j, i-1);
                if (compare(tempString, firstPersonPronouns))
                    for (int k = j; k <= i; k++) {
                        boolText[0][k] = true;
                    }
                if (compare(tempString, secondPersonPronouns))
                    for (int k = j; k <= i; k++) {
                        boolText[1][k] = true;
                    }
                if (compare(tempString, contractions))
                    for (int k = j; k <= i; k++) {
                        boolText[2][k] = true;
                    }
                if (compare(tempString, nContractions))
                    for (int k = j; k <= i; i++) {
                        boolText[3][k] = true;
                    }
                j = i + 1;
                if (j <= myText.length())
                    myTextHolder = myTextHolder.substring(j);
                else
                    myTextHolder = myTextHolder.substring(i);
            }
        }
    }
}

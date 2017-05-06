package com.myjokesjava.android;

import java.util.Random;

public class MyJokes {
    private static final String[] JOKES = {
            "Teacher: Name 5 animals that live in water.\n" +
                    "Student: Frog.\n" +
                    "Teacher: Very good, 4 others? \n" +
                    "Student: Its mother, father, sister and brother..\uD83D\uDE2C\uD83D\uDE1D\uD83D\uDE1C\n",
            "Teacher: I think you are chewing gum. \n" +
                    "John: No Sir, I am John Smith. ",
            "Teacher: What is a synonym?\n" +
                    "Student: A synonym is a word you use when you can't spell the other!\t\uD83D\uDE02\uD83D\uDE1D\uD83D\uDE02",
            "Teacher: \"what's the further away, America or the Moon?\"\n" +
                    "Student: \"America!\"\n" +
                    "Teacher: \"America? Whatever gave you that idea?\"\n" +
                    "Student: \"Simple, We can always see the moon from the india, but not america!\"\uD83D\uDE02 \uD83D\uDE02 \uD83D\uDE02 \uD83D\uDE02 \uD83D\uDE02",
            "TEACHER : What do you call a person who keeps on talking when people are no longer interested? \n" +
                    "PAPPU: A teacher",
            "Whenever I’m on my computer, I don’t type ‘lol’. I type ‘lqtm’ – laugh quietly to myself. It’s more honest.",
            "If a word in the dictionary were misspelled, how would we know?",
            "Isn’t it great to live in the 21st century? Where deleting history has become more important than making it.\n \uD83D\uDE02\uD83D\uDE02\uD83D\uDE1D\uD83D\uDE1C",
            "I asked God for a bike, but I know God works in mysterious ways. So I stole a bike and asked for forgiveness.",
            "Teacher : \"Now, children, if I saw a man beating a donkey and stopped him,what virtue would I be showing?\"\n" +
                    "Student : \"Brotherly love\".\n",
                };
    private static final Random random = new Random();

    public static String getMyJoke() {
        return JOKES[random.nextInt(JOKES.length)];
    }
}

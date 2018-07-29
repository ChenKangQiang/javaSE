package edu.tongji.comm.example.emoji;

import com.vdurmont.emoji.EmojiParser;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/7/28
 */
public class EmojiTransform {

    public static void main(String[] args) {

        String emojiStr = "哈哈哈(*^ω^*)\uD83D\uDE00\uD83D\uDE2C\uD83D\uDE0C\uD83D\uDE2A\uD83C\uDF4E\uD83C\uDF50\uD83C\uDF5A\uD83C\uDF7A很好玩";
        System.out.println(emojiStr);
        String dealStr = parserEmoji(emojiStr);
        System.out.println(dealStr);

    }


    public static String parserEmoji(String input) {
        return EmojiParser.parseToAliases(input);
    }


    public static String rebuildEmoji(String input) {
        return EmojiParser.parseToUnicode(input);
    }

}

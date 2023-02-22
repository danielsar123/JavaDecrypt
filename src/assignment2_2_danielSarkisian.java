public class assignment2_2_danielSarkisian {
    public static String key = "thisisasecretkey";
    public static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public static void main(String[] args) {
        String cipherTxt = "mom zgldmpx aspjl, lpw tedspbxk uywgsk, xjv kewrepvy deszgj tvp usmfl,\n" +
                "ls tvxkxc h zijmgra wh tskl, ql'k nzox e vltwalisp tlhsv fhlw ty xjv\n" +
                "akrb vn i fjmgeh.";
        String plaintxt = "";
        int keyIndex;
        for (int i = 0, j=0; i < cipherTxt.length(); i++,j++) {
            char curLetter = cipherTxt.charAt(i);
            int index = alphabet.indexOf(curLetter);
            if (j == key.length()){
                j = 0;
            }
            if (index == -1) {
                plaintxt += curLetter;
                continue;

            }
            keyIndex = alphabet.indexOf(key.charAt(j));

            plaintxt += alphabet.charAt((index - keyIndex + 26) % 26);

        }
        System.out.println(plaintxt);
    }
}
package kz.chesschicken.ojw.item.infopaper;

import java.util.ArrayList;

public class TextFormatting {
    public String title;
    public String[] raw;

    public ArrayList<String> lines = new ArrayList<>();

    public TextFormatting(int i)
    {
        raw = EventInfoPaper.getText(i);

        initTitle();
        parseLines();
    }

    private void initTitle()
    {
        if(raw[0].startsWith("!!T "))
        {
            String[] newT = new String[raw.length - 1];
            title = raw[0].replace("!!T ", "");
            System.arraycopy(raw, 1, newT, 0, newT.length);
            raw = newT;
        }
    }

    private void parseLines()
    {
        for (String s : raw) {
            if (s.startsWith("!!S"))
            {
                if (s.startsWith("!!SN"))
                {
                    lines.add(" ");
                } else {
                    lines.add(s.replace("!!S ", ""));
                }
            }
        }
        raw = null;
    }

}

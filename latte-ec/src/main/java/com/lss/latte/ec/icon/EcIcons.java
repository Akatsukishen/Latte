package com.lss.latte.ec.icon;

import com.joanzapata.android.iconify.Icon;

/**
 * Created by li.shensong on 19/08/2017.
 * 参照 FontAwesomeIcons 实现
 */

public enum EcIcons implements Icon {
    icons_scan('\ue67e'),
    icons_ali_pay('\ue61f');

    private char character;

    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}

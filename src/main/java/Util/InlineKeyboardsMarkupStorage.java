package Util;

import Model.Entities.Films;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class InlineKeyboardsMarkupStorage {
    public static InlineKeyboardMarkup GetInlineKeyboardMarkupMenuMain() {
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row;
        InlineKeyboardButton button;

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(ButtonsStorage.ButtonAllFilmsInMenuMain.getName());
        button.setCallbackData(ButtonsStorage.ButtonAllFilmsInMenuMain.getCallBackData());
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(ButtonsStorage.ButtonAddFilmsInMenuMain.getName());
        button.setCallbackData(ButtonsStorage.ButtonAddFilmsInMenuMain.getCallBackData());
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(ButtonsStorage.ButtonDeleteFilmsInMenuMain.getName());
        button.setCallbackData(ButtonsStorage.ButtonDeleteFilmsInMenuMain.getCallBackData());
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(ButtonsStorage.ButtonFindFilmsInMenuMain.getName());
        button.setCallbackData(ButtonsStorage.ButtonFindFilmsInMenuMain.getCallBackData());
        row.add(button);
        keyboard.add(row);

        InlineKeyboardMarkup replyKeyboardMarkup = new InlineKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboard);

        return replyKeyboardMarkup;
    }

    public static InlineKeyboardMarkup GetInlineKeyboardMarkupMenuMainStylesFilm() {
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row;
        InlineKeyboardButton button;

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(ButtonsStorage.ButtonStylesFilmsFromMenuMainHorrors.getName());
        button.setCallbackData(ButtonsStorage.ButtonStylesFilmsFromMenuMainHorrors.getCallBackData());
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(ButtonsStorage.ButtonStylesFilmsFromMenuMainMystic.getName());
        button.setCallbackData(ButtonsStorage.ButtonStylesFilmsFromMenuMainMystic.getCallBackData());
        row.add(button);
        keyboard.add(row);

        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(ButtonsStorage.ButtonStylesFilmsFromMenuMainHistory.getName());
        button.setCallbackData(ButtonsStorage.ButtonStylesFilmsFromMenuMainHistory.getCallBackData());
        row.add(button);
        keyboard.add(row);


        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(ButtonsStorage.ButtonStylesFilmsFromMenuMainComedy.getName());
        button.setCallbackData(ButtonsStorage.ButtonStylesFilmsFromMenuMainComedy.getCallBackData());
        row.add(button);
        keyboard.add(row);


        row = new ArrayList<>();
        button = new InlineKeyboardButton();
        button.setText(ButtonsStorage.ButtonStylesFilmsFromMenuMainMilitary.getName());
        button.setCallbackData(ButtonsStorage.ButtonStylesFilmsFromMenuMainMilitary.getCallBackData());
        row.add(button);
        keyboard.add(row);


        InlineKeyboardMarkup replyKeyboardMarkup = new InlineKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboard);

        return replyKeyboardMarkup;
    }
}

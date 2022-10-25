package Service.Handlers;

import Model.DbManager;
import Statemachine.State;
import Statemachine.TransmittedData;
import Util.ButtonsStorage;
import Util.DialogStringsStorage;
import Util.InlineKeyboardsMarkupStorage;
import Util.SystemStringsStorage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import Model.Tables.TableFilms;


import static Statemachine.State.WaitingInputStartFromMenu;
import static Statemachine.State.WaitingInputStartFromMenuChooseFilm;


public class MainMenuService {
    private TableFilms tableFilms;

    public SendMessage processCommandStart(String command, TransmittedData transmittedData) {

        SendMessage message = new SendMessage();
        message.setChatId(transmittedData.getChatId());

        if (!command.equals(SystemStringsStorage.CommandStart)) {
            message.setText(DialogStringsStorage.CommandStartError);
            return message;
        }

        transmittedData.setState(State.WaitingClickOnInlineButtonInMenuMain);

        message.setText(DialogStringsStorage.CommandStartOK);
        message.setReplyMarkup(InlineKeyboardsMarkupStorage.GetInlineKeyboardMarkupMenuMain());

        return message;

    }

    public SendMessage processClickOnInlineButtonInMenuMain(String callBackData, TransmittedData transmittedData) throws Exception {

        SendMessage message = new SendMessage();
        message.setChatId(transmittedData.getChatId());

        if (callBackData.equals(ButtonsStorage.ButtonAllFilmsInMenuMain.getCallBackData())) {
            message.setText(DialogStringsStorage.CommandMenuStyleFilms);
            message.setReplyMarkup(InlineKeyboardsMarkupStorage.GetInlineKeyboardMarkupMenuMainStylesFilm());

            transmittedData.setState(WaitingInputStartFromMenuChooseFilm);

            return message;

        } else if (callBackData.equals(ButtonsStorage.ButtonAddFilmsInMenuMain.getCallBackData())) {
            message.setText("Вы нажали добавить фильм");
            return message;
        } else if (callBackData.equals(ButtonsStorage.ButtonDeleteFilmsInMenuMain.getCallBackData())) {
            message.setText("Вы нажали удалить фильм");
            return message;
        } else if (callBackData.equals(ButtonsStorage.ButtonFindFilmsInMenuMain.getCallBackData())) {
            message.setText("Вы нажали поиск фильма");
            return message;
        }

        throw new Exception("Неправильный ввод");
    }

    public SendMessage processClickOnInlineButtonStylesFilms(String callBackData, TransmittedData transmittedData) throws Exception {
        SendMessage message = new SendMessage();
        message.setChatId(transmittedData.getChatId());
        if (callBackData.equals(ButtonsStorage.ButtonStylesFilmsFromMenuMainHorrors.getCallBackData())) {
            message.setText(DialogStringsStorage.CommandStyleFilmsHorror);
            DbManager.getInstance().getTableFilms().getAllHorror();
            transmittedData.setState(WaitingInputStartFromMenu);
            return message;

        } else if (callBackData.equals(ButtonsStorage.ButtonStylesFilmsFromMenuMainMystic.getCallBackData())) {
            message.setText("Вы нажали на мистика");
            return message;
        } else if (callBackData.equals(ButtonsStorage.ButtonStylesFilmsFromMenuMainHistory.getCallBackData())) {
            message.setText("Вы нажали на исторические");
            return message;
        } else if (callBackData.equals(ButtonsStorage.ButtonStylesFilmsFromMenuMainComedy.getCallBackData())) {
            message.setText("Вы нажали на комедии");
            return message;
        } else if (callBackData.equals(ButtonsStorage.ButtonStylesFilmsFromMenuMainMilitary.getCallBackData())) {
            message.setText("Вы нажали на боевики");
            return message;
        }
        throw new Exception("Ввод говно");
    }
}


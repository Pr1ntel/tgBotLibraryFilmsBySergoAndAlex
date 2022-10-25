package Service.Handlers;

import Model.DbManager;
import Model.Entities.Films;
import Model.Entities.StyleFilms;
import Statemachine.State;
import Statemachine.TransmittedData;
import Util.ButtonsStorage;
import Util.DialogStringsStorage;
import Util.InlineKeyboardsMarkupStorage;
import Util.SystemStringsStorage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.List;


public class MainMenuService {
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



           /* List<Films> film = DbManager.getInstance().getTableFilms().getAllByChatId(transmittedData.getChatId());
                message.setText(DialogStringsStorage.CommandMenuStyleFilms);
                List<StyleFilms> styleFilm = DbManager.getInstance().getTableStyleFilms().getAll();
               film.stream().forEach(
                       films -> films.setStyleFilms(
                               styleFilm.stream()
                                       .filter(styleFilms -> styleFilms.getId()==films.getStyleFilmToId()).findFirst().get()
                       )
               );
        message.setText(DialogStringsStorage.CommandMenuStyleFilms);
        message.setReplyMarkup(InlineKeyboardsMarkupStorage.GetInlineKeyboardMarkupMenuMainStylesFilm(film));*/

                // остановился
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
    }


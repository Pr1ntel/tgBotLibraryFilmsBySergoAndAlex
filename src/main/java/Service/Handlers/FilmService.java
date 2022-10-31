package Service.Handlers;
import Model.DataStorageKeys;
import Model.DbManager;
import Model.Entities.Film;
import Statemachine.State;
import Statemachine.TransmittedData;
import Util.ButtonsStorage;
import Util.DialogStringsStorage;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class FilmService {
    public SendMessage processClickOnInlineButtonInMenuAddFilms(String callBackData, TransmittedData transmittedData) throws Exception {
        SendMessage message = new SendMessage();
        message.setChatId(transmittedData.getChatId());
        if (callBackData.equals(ButtonsStorage.ButtonAddFilmsInMenuMain.getCallBackData())) {
            message.setText(DialogStringsStorage.ActionInputNameFilm);

            transmittedData.setState(State.WaitingInputName);

            return message;


        }
        return message;
    }
}
}

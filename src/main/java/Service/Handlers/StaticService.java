package Service.Handlers;

import Statemachine.State;
import Statemachine.TransmittedData;
import Util.DialogStringsStorage;
import Util.InlineKeyboardsMarkupStorage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class StaticService {
    public SendMessage processCommandReset(TransmittedData transmittedData) {
        transmittedData.setState(State.WaitingClickOnInlineButtonInMenuChooseFilm);

        transmittedData.getDataStorage().clear();

        SendMessage message = new SendMessage();
        message.setChatId(transmittedData.getChatId());
        message.setText(DialogStringsStorage.CommandStartOK);
        message.setReplyMarkup(InlineKeyboardsMarkupStorage.GetInlineKeyboardMarkupMenuMain());

        return message;
    }
}

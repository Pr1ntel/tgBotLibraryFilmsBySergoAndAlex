package Service;

import Statemachine.TransmittedData;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public interface Service {
    void processUpdate(long chatId, TransmittedData transmittedData, Update update, TelegramLongPollingBot bot) throws TelegramApiException;
}

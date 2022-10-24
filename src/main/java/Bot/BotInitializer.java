package Bot;

import Statemachine.ChatRouter;
import Util.SystemStringsStorage;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BotInitializer extends TelegramLongPollingBot {

    private ChatRouter chatRouter;

    public BotInitializer() {
        chatRouter = new ChatRouter();
    }

    @Override
    public String getBotUsername() {
        return "LibraryDilmsDb_bot";
    }

    @Override
    public String getBotToken() {
        return "5718694950:AAHMadIo0T6HeRTkc8Nc7QPEvU5ILD6O2eo";
    }

    @Override
    public void onUpdateReceived(Update update) {
        long chatId = 0;
        int messageId = 0;
        String textData = SystemStringsStorage.Empty;

        try {

            if (update.hasMessage()) {
                chatId = update.getMessage().getChatId();
                messageId = update.getMessage().getMessageId();
                textData = update.getMessage().getText();
            } else if (update.hasCallbackQuery()) {
                chatId = update.getCallbackQuery().getMessage().getChatId();
                messageId = update.getCallbackQuery().getMessage().getMessageId();
                textData = update.getCallbackQuery().getData();
            }

            SendMessage message = chatRouter.route(chatId, textData);
            execute(message);
        } catch (Exception e) {
            e.printStackTrace();
            DeleteMessage message = new DeleteMessage();
            message.setChatId(chatId);
            message.setMessageId(messageId);
            try {
                execute(message);
            } catch (TelegramApiException telegramApiException) {
                telegramApiException.printStackTrace();
            }
        }
    }
}
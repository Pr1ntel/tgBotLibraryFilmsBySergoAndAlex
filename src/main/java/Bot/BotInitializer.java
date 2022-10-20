package Bot;

import Statemachine.ChatRouter;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
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
        try {
            long chatId = 0;

            if (update.hasMessage()) {
                chatId = update.getMessage().getChatId();
            } else if (update.hasCallbackQuery()) {
                chatId = update.getCallbackQuery().getMessage().getChatId();
            }

            chatRouter.route(chatId, update, this);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
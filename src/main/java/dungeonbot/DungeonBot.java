package dungeonbot;

import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.TelegramClient;

public class DungeonBot implements LongPollingSingleThreadUpdateConsumer {

    private final TelegramClient telegramClient;

    public DungeonBot(String botToken) {
        this.telegramClient = new OkHttpTelegramClient(botToken);
    }

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String chatId = update.getMessage().getChatId().toString();
            String receivedText = update.getMessage().getText();

            SendMessage message = SendMessage.builder()
                    .chatId(chatId)
                    .text("Привет! Ты написал: " + receivedText)
                    .build();

            try {
                telegramClient.execute(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
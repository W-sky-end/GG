package dungeonbot.bot;

import dungeonbot.model.Location;
import dungeonbot.model.LocationRepository;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardRow;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.util.ArrayList;
import java.util.List;

public class DungeonBot implements LongPollingSingleThreadUpdateConsumer {

    private final TelegramClient telegramClient;
    private final LocationRepository locationRepository;


    public DungeonBot(String botToken) {
        this.telegramClient = new OkHttpTelegramClient(botToken);
        this.locationRepository = new LocationRepository();
    }

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String chatId = update.getMessage().getChatId().toString();
            String text = update.getMessage().getText();

            if (text.equals("/start")) {
                sendLocation(chatId, "forest_entrance");
            }
        } else if (update.hasCallbackQuery()) {
            String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
            String nextLocationId = update.getCallbackQuery().getData();
            String callbackQueryId = update.getCallbackQuery().getId();

            AnswerCallbackQuery answer = AnswerCallbackQuery.builder()
                    .callbackQueryId(callbackQueryId)
                    .build();

            try {
                telegramClient.execute(answer);
            } catch (Exception e) {
                e.printStackTrace();
            }

            sendLocation(chatId, nextLocationId);
        }
    }
    private void sendLocation(String chatId, String locationId) {
        Location location = locationRepository.getById(locationId);

        List<InlineKeyboardRow> keyboardRows = new ArrayList<>();
        for (String nextId : location.getNextLocationIds()) {
            Location nextLocation = locationRepository.getById(nextId);
            InlineKeyboardButton button = InlineKeyboardButton.builder()
                    .text(nextLocation.getName())
                    .callbackData(nextId)
                    .build();
            keyboardRows.add(new InlineKeyboardRow(button));
        }

        InlineKeyboardMarkup keyboard = InlineKeyboardMarkup.builder()
                .keyboard(keyboardRows)
                .build();

        SendMessage message = SendMessage.builder()
                .chatId(chatId)
                .text(location.getName() + "\n\n" + location.getDescription())
                .replyMarkup(keyboard)
                .build();

        try {
            telegramClient.execute(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package dungeonbot.bot;

import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {
        String botToken = loadBotToken();

        TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication();
        botsApplication.registerBot(botToken, new DungeonBot(botToken));

        System.out.println("Бот запущен!");

        Thread.currentThread().join();
    }

    private static String loadBotToken() throws IOException {
        Properties properties = new Properties();
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IOException("Файл config.properties не найден в resources!");
            }
            properties.load(input);
        }
        return properties.getProperty("bot.token");
    }
}

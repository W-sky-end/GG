package dungeonbot.bot;

import dungeonbot.model.*;
import dungeonbot.system.EncounterService;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {
        //********************ТЕСТ*******************
        MonsterRepository monsterRepository = new MonsterRepository();
        Monster zombie = monsterRepository.getByName("Zombie");
        LocationRepository locationRepository = new LocationRepository();

        EncounterService encounterService = new EncounterService(monsterRepository);
        Location graveyard = locationRepository.getById("graveyard_entrance");
        System.out.println("Локация: " + graveyard.getName() + ", шанс встречи: " + graveyard.getEncounterChance());
        for (int i = 0; i < 1000; i++) {
        Optional<Monster> encounter = encounterService.resolveEncounter(
                graveyard.getEncounterChance(),
                graveyard.getPossibleMonsters()
        );

        if (encounter.isPresent()) {
            System.out.println("Встречен монстр: " + encounter.get().getName());
        } else {
            System.out.println("Монстров не встречено.");
        }
        }
        //********************КОНЕЦ ТЕСТА*******************
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

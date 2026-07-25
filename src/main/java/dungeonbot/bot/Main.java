package dungeonbot.bot;

import dungeonbot.model.Monster;
import dungeonbot.model.Player;
import dungeonbot.system.CombatSystem;
import dungeonbot.system.Dice;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {
        //********************ТЕСТ*******************
        Player player = new Player("TestGuy");
        Monster monster = new Monster("Zombie", 1, 50, 5, 1, 1);
        Dice dice = new Dice();
        CombatSystem combatSystem = new CombatSystem(dice);

        boolean run = true;
        while (run) {
            if (player.isAlive()) {
                int battle = combatSystem.performAttack(player.getAttackModifier(), monster.getArmorClass());
                monster.takeDamage(battle);
                System.out.println(player.getName() + " attacks " + monster.getName() + " for " + battle +
                        " | " + monster.getName() + " HP: " + monster.getCurrentHP() + "/" + monster.getMaxHP());
            } else {
                run = false;
            }
            if (run && monster.isAlive()) {
                int battle = combatSystem.performAttack(monster.getDamage(), player.getDefenseModifier());
                player.takeDamage(battle);
                System.out.println(monster.getName() + " attacks " + player.getName() + " for " + battle +
                        " | " + player.getName() + " HP: " + player.getCurrentHP() + "/" + player.getMaxHP());
            } else {
                run = false;
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

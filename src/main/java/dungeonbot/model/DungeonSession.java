package dungeonbot.model;

import dungeonbot.system.SessionState;

public class DungeonSession {
   private SessionState sessionState;
   private Monster currentMonster;
   private String currentLocationId;


   public DungeonSession(String currentLocationId) {
       this.sessionState = SessionState.EXPLORING;
       this.currentMonster = null;
       this.currentLocationId = currentLocationId;

   }

    public SessionState getSessionState() {
        return sessionState;
    }

    public Monster getCurrentMonster() {
        return currentMonster;
    }

    public String getCurrentLocationId() {
        return currentLocationId;
    }

    public void startCombat (Monster monster) {
      this.currentMonster = monster;
      this.sessionState = SessionState.IN_COMBAT;
    }
    public void endCombat () {
       this.sessionState = SessionState.EXPLORING;
       this.currentMonster = null;

    }
}

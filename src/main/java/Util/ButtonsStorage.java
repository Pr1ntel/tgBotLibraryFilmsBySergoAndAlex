package Util;

public class ButtonsStorage {
    public static class Button {
        private String name;
        private String callBackData;

        public Button(String name, String callBackData) {
            this.name = name;
            this.callBackData = callBackData;
        }

        public String getName() {
            return name;
        }

        public String getCallBackData() {
            return callBackData;
        }
    }

    public final static Button ButtonAllFilmsInMenuMain = new Button("Список фильмов", "ButtonMyCardsInMenuMain");
    public final static Button ButtonAddFilmsInMenuMain = new Button("Добавить фильм", "ButtonTransferMoneyInMenuMain");
    public final static Button ButtonDeleteFilmsInMenuMain = new Button("Удалить фильм", "ButtonInstructionInMenuMain");
    public final static Button ButtonFindFilmsInMenuMain = new Button("Поиск фильма", "ButtonInstructionInMenuMain");
}

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

    public final static Button ButtonAllFilmsInMenuMain = new Button("Список фильмов", "ButtonAllFilmsInMenuMain");
    public final static Button ButtonAddFilmsInMenuMain = new Button("Добавить фильм", "ButtonAddFilmsInMenuMain");
    public final static Button ButtonDeleteFilmsInMenuMain = new Button("Удалить фильм", "ButtonDeleteFilmsInMenuMain");
    public final static Button ButtonFindFilmsInMenuMain = new Button("Поиск фильма", "ButtonFindFilmsInMenuMain");
    public final static Button ButtonStylesFilmsFromMenuMainHorrors = new Button("Ужасы", "ButtonStylesFilmsFromMenuMainHorrors");
    public final static Button ButtonStylesFilmsFromMenuMainMystic = new Button("Мистика", "ButtonStylesFilmsFromMenuMainMystic");
    public final static Button ButtonStylesFilmsFromMenuMainHistory = new Button("Исторические", "ButtonStylesFilmsFromMenuMainHistory");
    public final static Button ButtonStylesFilmsFromMenuMainComedy = new Button("Комедии", "ButtonStylesFilmsFromMenuMainComedy");
    public final static Button ButtonStylesFilmsFromMenuMainMilitary = new Button("Боевики", "ButtonStylesFilmsFromMenuMainMilitary");
}

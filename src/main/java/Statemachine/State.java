package Statemachine;

public enum State {
    WaitingCommandStart,
    WaitingClickOnInlineButtonInMenuMain,
    WaitingClickOnInlineButtonInMenuChooseFilm,
    WaitingInputStartFromMenu,
    WaitingClickOnInlineButtonInMenuAddFilm,
    WaitingClickOnInlineButtonInMenuDeleteFilm,
    WaitingClickOnInlineButtonInMenuChooseFromDeleteFilm,
    WaitingClickOnInlineButtonInMenuFindFilm,

    // states from add films

    WaitingInputName,
    WaitingInputTimeLength,
    WaitingInputLinkFilm,
    WaitingInputYearRelease,
    WaitingInputStyleFilm

}

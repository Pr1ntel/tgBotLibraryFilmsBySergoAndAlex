package Service;

import Service.Handlers.FilmService;
import Service.Handlers.MainMenuService;
import Service.Handlers.StaticService;
import Statemachine.State;
import Statemachine.TransmittedData;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;


import java.util.HashMap;
import java.util.Map;

public class ServiceManager {
    private Map<State, Service> methods;
    private MainMenuService mainMenuService;
    private StaticService staticService;
    private FilmService filmService;

    public ServiceManager() {
        methods = new HashMap<>();
        mainMenuService = new MainMenuService();
        staticService = new StaticService();
        filmService = new FilmService();


        methods.put(State.WaitingCommandStart, mainMenuService::processCommandStart);
        methods.put(State.WaitingClickOnInlineButtonInMenuMain, mainMenuService::processClickOnInlineButtonInMenuMain);
        methods.put(State.WaitingClickOnInlineButtonInMenuChooseFilm, mainMenuService::processClickOnInlineButtonStylesFilms);
        methods.put(State.WaitingInputStartFromMenu, mainMenuService::processCommandStart);
        methods.put(State.WaitingClickOnInlineButtonInMenuAddFilm,filmService::processClickOnInlineButtonInMenuAddFilms);
        methods.put(State.WaitingInputName, filmService ::processNameFilm);

    }

    public SendMessage processUpdate(String textData, TransmittedData transmittedData) throws Exception {
        return methods.get(transmittedData.getState()).processUpdate(textData, transmittedData);
    }

    public StaticService getStaticService() {
        return staticService;
    }
}
package Statemachine;

import Service.ServiceManager;
import Util.SystemStringsStorage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;


import java.util.HashMap;
import java.util.Map;

public class ChatRouter {


        private Map<Long,TransmittedData> chats;
        private ServiceManager serviceManager;

        public ChatRouter() {
            chats = new HashMap<>();
            serviceManager = new ServiceManager();
        }

        public SendMessage route(long chatId, String textData) throws Exception {

            if(!chats.containsKey(chatId)){
                chats.put(chatId,new TransmittedData(chatId));
            }

            TransmittedData transmittedData = chats.get(chatId);

            if(textData.equals(SystemStringsStorage.CommandReset) && transmittedData.getState() != State.WaitingCommandStart){
                return serviceManager.getStaticService().processCommandReset(transmittedData);
            }

            return serviceManager.processUpdate(textData, transmittedData);
        }
}

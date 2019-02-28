package PlayCode;

import PlayCode.model.Payload;
import PlayCode.service.InputLoader;
import PlayCode.service.LogicExecutor;

public class App {

    public static void main(String[] args) {
        final InputLoader inputLoader = new InputLoader();
        final Payload payload = inputLoader.getPayload();
        final LogicExecutor logicExecutor = new LogicExecutor();
        logicExecutor.doTheLogic(payload);
    }
}

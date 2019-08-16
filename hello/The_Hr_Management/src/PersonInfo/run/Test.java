package PersonInfo.run;

import PersonInfo.AddAll.UserAdd;
import PersonInfo.AddAll.WokerAdd;
import PersonInfo.Login.LoginFrame;

import PersonInfo.Update_Select.WorkerSelect;
import PersonInfo.Update_Select.WorkerUpdate;

public class Test {
    public static void main(String[] args) {
        new LoginFrame();
        new WokerAdd();
        new UserAdd();

        new WorkerSelect();
        new WorkerUpdate();

    }
}

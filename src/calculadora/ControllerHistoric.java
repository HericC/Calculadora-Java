package calculadora;

import Database.Database;
import java.util.ArrayList;

public class ControllerHistoric extends Database {
    private ModelHistoric instance;
    private ArrayList<String[]> list;
    private static ControllerHistoric controllerHistoric;
    
    private ControllerHistoric() {
        
    }
    
    public static ControllerHistoric getInstance() {
        if (ControllerHistoric.controllerHistoric == null) {
            ControllerHistoric.controllerHistoric = new ControllerHistoric();
        }
        return ControllerHistoric.controllerHistoric;
    }
    
    public void truncate() {
        super.truncate("historic");
    }
    
    public void insert(String[] obj) {
        try {
            String str_stmt = "insert into historic (expression, result) values (?,?);";
            super.insertUpdate(str_stmt, obj);
        } catch (Exception e) {
            System.err.println("Error, class: 'ControllerHistoric', line: '37'");
            System.err.println(e.getMessage()+"\n"+e.getClass());
        }
    }
   
    public ModelHistoric[] getListInstance() {
        this.list = super.getTable("select * from historic;");
        
        if (this.list != null) {
            ModelHistoric[] listHistoric = new ModelHistoric[this.list.size()];
            
            for (int index = 0; index < this.list.size(); index++) {
                this.instance = new ModelHistoric(
                        Integer.parseInt(this.list.get(index)[0]),
                        this.list.get(index)[1],
                        this.list.get(index)[2]
                );
                listHistoric[index] = this.instance;
            }
            return listHistoric;
        }
        return null;
    }
}

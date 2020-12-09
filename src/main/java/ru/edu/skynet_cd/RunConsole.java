package ru.edu.skynet_cd;

import java.util.List;
import ru.edu.skynet_cd.dao.DAO;
import ru.edu.skynet_cd.dao.PositionDAOImpl;
import ru.edu.skynet_cd.domain.Position;

/**
 *
 * @author ralew
 */
public class RunConsole {

    public static void main(String[] args) {
        /*
        Config.getProperty(Config.DB_URL);
        System.out.println(Config.getProperty(Config.DB_URL));
        System.out.println(Config.getProperty(Config.DB_LOGIN));
        System.out.println(Config.getProperty(Config.DB_PASSWORD));
        */
        DAO<Position> pos = new PositionDAOImpl();
        List lst = pos.getAll();
        for (Object p : lst) {
            System.out.println(p.toString());
        }
        System.out.println("----------------------");
        DAO<Position> pos2 = new PositionDAOImpl();        
        Position p =  pos2.getById(11);
        System.out.println(pos2.getById(11).getName());
        
        DAO<Position> pos3 = new PositionDAOImpl();
        System.out.println("----------------------");
        System.out.println(pos3.delete(10));
        DAO<Position> pos4 = new PositionDAOImpl();
        System.out.println("----------------------");
        p.setName("ZZZZZ");        
        System.out.println(pos4.update(p));
        
        DAO<Position> pos5 = new PositionDAOImpl();
        System.out.println("----------------------");        
        
        //System.out.println(pos5.insert(new Position("GGGG")));
        
    }
}

package org.perscholas;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemService implements ItemDAO {
    @Override
    public List<Item> getAllItems() {
        DatabaseConnection db = new DatabaseConnection();
        List<Item> result = new ArrayList<>();

        db.connect();
        try{
            db.ps = db.conn.prepareStatement(SQL.GET_ALL_ITEMS.getQuery());
            db.rs = db.ps.executeQuery();
            while(db.rs.next()) {
                int id = db.rs.getInt("id");
                String name = db.rs.getString("name");
                String price = db.rs.getString("price");

                result.add(new Item(id, name, price));
            }
        }
        catch(SQLException exc) {
            exc.printStackTrace();
        }

        db.dispose();
        return result;
    }

    @Override
    public boolean addItem(Item i) {
        DatabaseConnection db = new DatabaseConnection();
        boolean result = false;
        db.connect();

        try {
            db.ps = db.conn.prepareStatement(SQL.ADD_ITEM.getQuery());
            db.ps.setString(1, i.getName());
            db.ps.setString(2, i.getPrice());

            result = db.ps.execute();
        }
        catch(SQLException exc) {
            exc.printStackTrace();
        }

        db.dispose();
        return result;
    }

    @Override
    public boolean removeItemById(int id) {
        DatabaseConnection db = new DatabaseConnection();
        boolean result = false;

        try {
            db.ps = db.conn.prepareStatement(SQL.REMOVE_ITEM.getQuery());
            db.ps.setInt(1, id);

            result = db.ps.execute();
        }
        catch(SQLException exc) {
            exc.printStackTrace();
        }

        db.dispose();
        return result;
    }
}

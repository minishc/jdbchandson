package org.perscholas;

import java.util.List;

public interface ItemDAO {
    enum SQL {
        REMOVE_ITEM("DELETE FROM Item WHERE id = ?"),
        ADD_ITEM("INSERT INTO Item VALUES (?, ?)"),
        GET_ALL_ITEMS("SELECT * FROM items");

        private final String query;

        private SQL(String s) {
            this.query = s;
        }

        public String getQuery() {
            return query;
        }
    }
    List<Item> getAllItems();
    boolean addItem(Item i);
    boolean removeItemById(int id);
}

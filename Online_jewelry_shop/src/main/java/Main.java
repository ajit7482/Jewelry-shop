import Beans.JewelryItem;
import DAO.JewelryItemDAO;

public class Main {
    public static void main(String[] args) {
        JewelryItemDAO jewelryItemDAO = new JewelryItemDAO();

        // Add a new jewelry item
        JewelryItem item = new JewelryItem();
        item.setName("Gold Necklace");
        item.setDescription("18k Gold Necklace");
        item.setPrice(1500.00);
        item.setQuantity(10);
        jewelryItemDAO.saveJewelryItem(item);

        // List all jewelry items
        for (JewelryItem jItem : jewelryItemDAO.getJewelryItems()) {
            System.out.println(jItem.getName() + " - " + jItem.getPrice());
        }
    }
}

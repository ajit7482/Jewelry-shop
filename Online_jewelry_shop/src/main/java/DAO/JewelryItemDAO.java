package DAO;

import Beans.JewelryItem;
import Utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class JewelryItemDAO {
    public void saveJewelryItem(JewelryItem item) {
        Transaction transaction = null;
//        Session HibernateUtil = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(item);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<JewelryItem> getJewelryItems() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from JewelryItem", JewelryItem.class).list();
        }
    }
}


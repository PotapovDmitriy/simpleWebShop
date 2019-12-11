package com.webshop.simplewebapplication.database;

import com.webshop.simplewebapplication.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class ProductDAOHib implements ProductDAO {
    @Override
    public void addProduct(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        session.save(product);
//        session.createQuery("insert into product values (" +
//                product.getId() + ","+ product.getName() + "," + product.getPrice() + "," + product.getPath()+")");
        tx1.commit();
        session.close();
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = (List<Product>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Product").list();
        return products;
    }

    @Override
    public Product findProduct(long id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("FROM Product where id = :id");
            query.setParameter("id", id);
            return (Product) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }


    }

    @Override
    public void deleteProduct(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(product);
        tx1.commit();
        session.close();
    }

    public int countOfProduct() {
        List<Product> products = (List<Product>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Product").list();
        return products.size();
    }
}

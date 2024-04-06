	package in.co.rays.model;

	import java.util.List;

	import org.hibernate.Criteria;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.hibernate.cfg.Configuration;
	import org.hibernate.criterion.Restrictions;

import in.co.rays.dto.CarDTO;


public class CarModel {




		public void add(CarDTO dto) {

			SessionFactory sf = new Configuration().configure().buildSessionFactory();

			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();

			session.save(dto);
			tx.commit();
			session.close();

		}
		
		public void update(CarDTO dto) {
			
			SessionFactory sf = new Configuration().configure().buildSessionFactory();

			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			
			session.update(dto);
			tx.commit();
			session.close();
		}
		
		public void delete(CarDTO dto) {
			
			SessionFactory sf = new Configuration().configure().buildSessionFactory();

			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			
			session.delete(dto);
			tx.commit();
			session.close();
		}
		public List search(CarDTO dto) {
			
			SessionFactory sf = new Configuration().configure().buildSessionFactory();

			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			 
			Criteria c =  session.createCriteria(CarDTO.class);
			
			if(dto !=null) {
				if(dto.getOwnerName() !=null && dto.getOwnerName().length() > 0) {
					c.add(Restrictions.like("ownerName", dto.getOwnerName()+"%"));
				}
				if(dto.getId() !=0 && dto.getId()>0) {
				c.add(Restrictions.eq("id", dto.getId()));	
				}
			}
			List list = c.list();
			tx.commit();
			
			return list;
			
		}
		public CarDTO findByPk(long id) {
			
			SessionFactory sf = new Configuration().configure().buildSessionFactory();

			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			CarDTO dto =  (CarDTO) session.get(CarDTO.class, id);
			
			
			return dto;
			
		}
	}



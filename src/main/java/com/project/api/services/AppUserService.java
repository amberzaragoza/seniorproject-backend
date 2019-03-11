// package com.project.api.services;

// import java.util.ArrayList;
// import java.util.List;

// import com.project.api.models.AppUser;

// import org.hibernate.Query;
// import org.hibernate.SessionFactory;
// import org.springframework.stereotype.Service;


// @Service
// public class AppUserService {

//   // public List<AppUser> findOnlineUsers(double latitud, double longitude){
//   //   List<AppUser> users = new ArrayList<>();
//   //   String hqlQuery = "SELECT a FROM AppUser a WHERE (((acos(sin(((:latitude)*pi()/180)) * " +
//   //   "sin((a.latitude*pi()/180))+cos(((:latitude)*pi()/180)) * cos((a.latitude*pi()/180)) * " +
//   //   "cos((((:longitude)- a.longitude)*pi()/180))))*180/pi())*60*1.1515) <=50 AND a.is_online=true";

//   //   try{
//   //     Query query = SessionFactory.getCurrentSession().createQuery(hqlQuery);
//   //     query.setDouble("latitude", latitud);
//   //     query.setDouble("longitude", longitude);
//   //     users = (List<AppUser>) query.list();

//   //   } catch(Exception e){
//   //     e.printStackTrace();
//   //   }
//   //   return users;
//   // }








// }


DELETE  FROM  restaurant.restaurants ;
DELETE  FROM   staff.clients ;
DELETE FROM  menu.menus;

Insert into restaurant.restaurants(code,nom,adresse,ville,telephone,heure_ouverture,heure_fermeture,jour_ouverture,coordonnee_gps_x,coordonnee_gps_y,etat)
values(1,'rejkl','klmll','klkll','986889','10','45','{Lundi}','0.555','0.3666','ouvert');

Insert into restaurant.restaurants(code,nom,adresse,ville,telephone,heure_ouverture,heure_fermeture,jour_ouverture,coordonnee_gps_x,coordonnee_gps_y,etat)
values(2,'rejkl','klmll','klkll','794689','10','45','{Mardi}','0.555','0.3666','ouvert');

INSERT INTO staff.clients(id,favoris,nom,prenom,telephone) values (1,ARRAY['ll'],'eklou','fidele','788956');

INSERT INTO menu.menus(code,nom,prix,temps_preparation,created_at,updated_at,restaurant_id,statut) VALUES (1,'hodo',500,'12','2002-02-11','2002-02-11',2,'en cours');

INSERT INTO menu.menus(code,nom,prix,temps_preparation,created_at,updated_at,restaurant_id,statut) VALUES (2,'ll',200,'12','2002-02-11','2002-02-11',2,'en cours');
INSERT INTO menu.menus(code,nom,prix,temps_preparation,created_at,updated_at,restaurant_id,statut) VALUES (3,'hido',1200,'12','2002-02-11','2002-02-11',2,'en cours');
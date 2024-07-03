
DELETE  FROM  restaurants ;
DELETE  FROM   clients ;
DELETE FROM  menus;

Insert into restaurants(code,nom,adresse,ville,telephone,heure_ouverture,heure_fermeture,jour_ouverture,coordonnee_gps_x,coordonnee_gps_y,etat)
values(1,'rejkl','klmll','klkll','986889','10','45','{Lundi}','0.555','0.3666','ouvert');

Insert into restaurants(code,nom,adresse,ville,telephone,heure_ouverture,heure_fermeture,jour_ouverture,coordonnee_gps_x,coordonnee_gps_y,etat)
values(2,'rejkl','klmll','klkll','794689','10','45','{Mardi}','0.555','0.3666','ouvert');

INSERT INTO clients(client_id,favoris,user_id) values (1,'ll',2);

INSERT INTO menus(code,nom,prix,temps_preparation,created_at,updated_at,restaurant_id,statut) VALUES (1,'hodo',500,'12','2002-02-11','2002-02-11',2,'en cours');

INSERT INTO menus(code,nom,prix,temps_preparation,created_at,updated_at,restaurant_id,statut) VALUES (2,'ll',200,'12','2002-02-11','2002-02-11',2,'en cours');
INSERT INTO menus(code,nom,prix,temps_preparation,created_at,updated_at,restaurant_id,statut) VALUES (3,'hido',1200,'12','2002-02-11','2002-02-11',2,'en cours');


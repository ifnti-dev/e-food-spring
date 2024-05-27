

-- INSERT INTO manage.values(id, label,parameter_code,value)
-- values 
-- ('DF','Draft','LISTING_STATE','DFT'),
-- ('PBD','Published','LISTING_STATE','PBHD')
-- ON CONFLICT (id) DO UPDATE 
-- SET label= EXCLUDED.label,
-- parameter_code=EXCLUDED.parameter_code,
-- value=EXCLUDED.value;




   
INSERT INTO restaurant.restaurants(code ,nom, ville, adresse,telephone,heure_ouverture,heure_fermeture,jour_ouverture,etat,coordonnee_gps_x,coordonnee_gps_y)
values 
(100,'feu de glace','kara','N°1','98745124','8h','0h','{Lun à dim}','en service', 8.7, 9.5),
(101,'afrik-pros','kara','N°1','92857896','7h','0h','{Lun à dim}','en service', 5.2, 3.6)
ON CONFLICT (code) DO UPDATE 
SET nom=EXCLUDED.nom,
ville=EXCLUDED.ville,
adresse=EXCLUDED.adresse,
telephone=EXCLUDED.telephone,
heure_ouverture=EXCLUDED.heure_ouverture,
heure_fermeture=EXCLUDED.heure_fermeture,
jour_ouverture=EXCLUDED.jour_ouverture,
etat=EXCLUDED.etat,
coordonnee_gps_x=EXCLUDED.coordonnee_gps_x,
coordonnee_gps_y=EXCLUDED.coordonnee_gps_y;


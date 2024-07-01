/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  kwamaGithub
 * Created: 16 mars 2022
 */

/**

**/
-- INSERT INTO manage.parameters(code, label) 
-- values
-- ('LISTING_STATE','listing possible states')
-- ON CONFLICT (code) DO UPDATE 
-- SET label= EXCLUDED.label;

/**

**/
-- INSERT INTO manage.values(id, label,parameter_code,value)
-- values 
-- ('DF','Draft','LISTING_STATE','DFT'),
-- ('PBD','Published','LISTING_STATE','PBHD')
-- ON CONFLICT (id) DO UPDATE 
-- SET label= EXCLUDED.label,
-- parameter_code=EXCLUDED.parameter_code,
-- value=EXCLUDED.value;


/**

-- **/
-- INSERT INTO restaurant.restaurants(code, nom, adresse, ville, telephone, heure_ouverture, heure_fermeture, jour_ouverture, coordonnee_gps_x,coordonnee_gps_y, etat)
-- values 
-- (1,'Kratos','Diaoure','Sokodé','90909090','','','',12.0,14.0,'En service'),
-- (2,'Solim','Kpangalam','Sokodé','90909090','','','',12.0,14.0,'En service'),
-- (3,'BB','Salimde','Sokodé','90909090','','','',12.0,14.0,'Suspendu'),
-- (4,'Les Pros','chaminade','Kara','90909090','','','',12.0,14.0,'En service');



-- ON CONFLICT (id) DO UPDATE 
-- SET url=EXCLUDED.url;

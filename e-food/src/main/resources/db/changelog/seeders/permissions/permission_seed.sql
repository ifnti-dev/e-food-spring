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

**/
INSERT INTO command.permissions(id, libelle)
values 
(1,'user_create'),
(2,'user_update'),
(3,'user_delete'),
(4,'user_edit'),
(5,'restaurant_create'),
(6,'restaurant_update'),
(7,'restaurant_delete'),
(8,'restaurant_edit'),
(9,'menu_create'),
(10,'menu_update'),
(11,'menu_delete'),
(12,'menu_edit'),
(13,'commande_create'),
(14,'commande_update'),
(15,'commande_delete'),
(16,'commande_edit'),
(17,'composant_create'),
(18,'composant_update'),
(19,'composant_delete'),
(20,'composant_edit'),
(21,'evenement_create'),
(22,'evenement_update'),
(23,'evenement_delete'),
(24,'evenement_edit'),
(25,'publicite_create'),
(26,'publicite_update'),
(27,'publicite_delete'),
(28,'publicite_edit'),
(29,'livraison_create'),
(30,'livraison_update'),
(31,'livraison_delete'),
(32,'livraison_edit'),
(33,'role_create'),
(34,'role_update'),
(35,'role_delete'),
(36,'role_edit')
ON CONFLICT (id) DO UPDATE 
SET libelle=EXCLUDED.libelle;

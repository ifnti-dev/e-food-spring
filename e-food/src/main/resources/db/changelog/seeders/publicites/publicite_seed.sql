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


INSERT INTO restaurant.publicites(id, description, titre)
values 
(1,'Nouveau menu','Escargot au lait'),
(2,'Promotion ','Promotion Djama'),
(3,'Nouveau menu','Escargot au lait');

-- ON CONFLICT (id) DO UPDATE 
-- SET url=EXCLUDED.url;

CREATE DATABASE smart_city;


CREATE TABLE smart_city.bus_stop(
       bus_stop_id VARCHAR(12) NOT NULL PRIMARY KEY,
       bus_stop_name VARCHAR(100) NOT NULL,
       bus_stop_location VARCHAR(100) NOT NULL,
       bus_id VARCHAR (9) NOT NULL,
       bus_name VARCHAR (100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO smart_city.bus_stop
       (bus_stop_id, bus_stop_name, bus_stop_location, bus_id, bus_name) 
VALUES                  
       ('101865204800', 'Estacao MOVE - Minas Shopping', 'Avenida Cristiano Machado em frente ao numero 4800', '1', '5106'),
       ('100446108400', 'Estacao MOVE - Santa Rosa', 'Avenida Presidente Antonio Carlos em frente ao numero 8400', '1', '5106'),
       ('100446107452', 'Estacao MOVE - Mineirao', 'Avenida Presidente Antonio Carlos  em frente ao numero 7452', '1', '5106'),
       ('100446106700', 'Estacao MOVE - UFMG', 'Avenida Presidente Antonio Carlos em frente ao numero 6700', '1', '5106'),
       ('100446106290', 'Estacao MOVE - Liberdade', 'Avenida Presidente Antonio Carlos em frente ao numero 6290', '1', '5106'),
       ('100446104060', 'Estacao MOVE - Colegio Militar', 'Avenida Presidente Antonio Carlos  em frente ao numero 4060', '1', '5106'),
       ('100446103720', 'Estacao MOVE - Sao Francisco', 'Avenida Presidente Antonio Carlos em frente ao numero 3720', '1', '5106'),
       ('100446103640', 'Estacao MOVE - Cachoeirinha', 'Avenida Presidente Antonio Carlos em frente ao numero 3640', '1', '5106'),
       ('100446103100', 'Estacao MOVE - Americo Vespucio', 'Avenida Presidente Antonio Carlos em frente ao numero 3100', '1', '5106'),
       ('100446102650', 'Estacao MOVE - Aparecida', 'Avenida Presidente Antonio Carlos em frente ao numero 2650', '1', '5106'),
       ('100446101980', 'Estacao MOVE - Operarios', 'Avenida Presidente Antonio Carlos em frente ao numero 1980', '1', '5106'),
       ('100446101560', 'Estacao MOVE - Hospital Belo Horizonte', 'Avenida Presidente Antonio Carlos em frente ao numero 1560', '1', '5106'),
       ('100446101200', 'Estacao MOVE - IAPI', 'Avenida Presidente Antonio Carlos em frente ao numero 1200', '1', '5106'),
       ('100446100880', 'Estacao MOVE - Hospital Odilon Behrens', 'Avenida Presidente Antonio Carlos em frente ao numero 880', '1', '5106'),
       ('100446100580', 'Estacao MOVE - SENAI', 'Avenida Presidente Antonio Carlos em frente ao numero 580', '1', '5106');


DELIMITER //
CREATE PROCEDURE smart_city.select_bus_stop_by_bus_id (IN selected_bus_id VARCHAR(9))
    BEGIN
         SELECT bus_stop_id, bus_stop_name, bus_stop_location, bus_id, bus_name 
           FROM smart_city.bus_stop 
          WHERE bus_id = selected_bus_id;
    END
//

